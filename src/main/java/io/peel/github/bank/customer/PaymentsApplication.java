package io.peel.github.bank.customer;


import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import io.peel.github.bank.customer.db.PaymentDAO;
import io.peel.github.bank.customer.resources.PaymentsResource;
import org.eclipse.jetty.servlets.CrossOriginFilter;

import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;
import java.util.EnumSet;

public class PaymentsApplication extends Application<Config> {
    public static void main(String[] args) throws Exception {
        new PaymentsApplication().run(args);
    }

    @Override
    public String getName() {
        return "payments";
    }

    @Override
    public void initialize(Bootstrap<Config> bootstrap) {
//        bootstrap.addBundle(hibernateBundle);
//        bootstrap.addBundle(new MigrationsBundle<Config>() {
//            @Override
//            public DataSourceFactory getDataSourceFactory(Config configuration) {
//                return configuration.getDataSourceFactory();
//            }
//        });
    }

    @Override
    public void run(Config configuration,
                    Environment environment) {
        enableCors(environment);
        final PaymentDAO dao = new PaymentDAO();
        final PaymentsResource resource = new PaymentsResource(dao);
        environment.jersey().register(resource);
    }

    private void enableCors(Environment environment) {
        final FilterRegistration.Dynamic cors = environment.servlets().addFilter("CORS", CrossOriginFilter.class);
        cors.setInitParameter("allowedOrigins", "*");
        // Configure CORS parameters
        cors.setInitParameter("allowedOrigins", "*");
        cors.setInitParameter("allowedHeaders", "X-Requested-With,Content-Type,Accept,Origin");
        cors.setInitParameter("allowedMethods", "OPTIONS,GET,PUT,POST,DELETE,HEAD");

        // Add URL mapping
        cors.addMappingForUrlPatterns(EnumSet.allOf(DispatcherType.class), true, "/*");
    }

}
