package io.peel.github.bank.customer;


import io.dropwizard.Application;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.hibernate.HibernateBundle;
import io.dropwizard.migrations.MigrationsBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import io.peel.github.bank.customer.core.Payment;
import io.peel.github.bank.customer.db.PaymentDAO;
import io.peel.github.bank.customer.resources.PaymentsResource;

public class CustomerApplication extends Application<Config> {
    public static void main(String[] args) throws Exception {
        new CustomerApplication().run(args);
    }

    @Override
    public String getName() {
        return "hello-world";
    }

    private final HibernateBundle<Config> hibernateBundle =
            new HibernateBundle<Config>(Payment.class) {
                @Override
                public DataSourceFactory getDataSourceFactory(Config configuration) {
                    return configuration.getDataSourceFactory();
                }
            };

    @Override
    public void initialize(Bootstrap<Config> bootstrap) {
        bootstrap.addBundle(new MigrationsBundle<Config>() {
            @Override
            public DataSourceFactory getDataSourceFactory(Config configuration) {
                return configuration.getDataSourceFactory();
            }
        });
        bootstrap.addBundle(hibernateBundle);
    }

    @Override
    public void run(Config configuration,
                    Environment environment) {
        final PaymentDAO dao = new PaymentDAO(hibernateBundle.getSessionFactory());
        final PaymentsResource resource = new PaymentsResource(dao);
        environment.jersey().register(resource);
    }



}
