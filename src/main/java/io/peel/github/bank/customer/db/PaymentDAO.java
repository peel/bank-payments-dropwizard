package io.peel.github.bank.customer.db;

import com.google.common.base.Optional;
import io.peel.github.bank.customer.core.Payment;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class PaymentDAO {
    private List<Payment> payments = new ArrayList<Payment>();
    private AtomicInteger id = new AtomicInteger();

    public PaymentDAO(){
        Payment p = new Payment(id.getAndIncrement(), "Jan Kowalski","Joanna Kowalska", "50pln", "na kino", "28 styczeń");
        payments.add(p);
    }

    public Optional<Payment> findById(Long id) {
        return Optional.fromNullable(payments.get(id.intValue()));
    }

    public Payment create(Payment payment) {
        payment.setId(id.getAndIncrement());
        payments.add(payment);
        return payment;
    }

    public List<Payment> findAll() {
        return payments;
    }
}
