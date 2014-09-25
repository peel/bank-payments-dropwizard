package io.peel.github.bank.customer.db;

import com.google.common.base.Optional;
import io.dropwizard.hibernate.AbstractDAO;
import io.peel.github.bank.customer.core.Payment;
import org.hibernate.SessionFactory;

        import java.util.List;

public class PaymentDAO extends AbstractDAO<Payment> {
    public PaymentDAO(SessionFactory factory) {
        super(factory);
    }

    public Optional<Payment> findById(Long id) {
        return Optional.fromNullable(get(id));
    }

    public Payment create(Payment payment) {
        return persist(payment);
    }

    public List<Payment> findAll() {
        return list(namedQuery("io.peel.github.helloworld.core.Person.findAll"));
    }
}
