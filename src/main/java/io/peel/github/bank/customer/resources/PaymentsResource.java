package io.peel.github.bank.customer.resources;

import com.codahale.metrics.annotation.Timed;
import io.peel.github.bank.customer.core.Payment;
import io.peel.github.bank.customer.db.PaymentDAO;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/payments")
@Produces(MediaType.APPLICATION_JSON)
public class PaymentsResource {
    private final PaymentDAO paymentDAO;

    public PaymentsResource(PaymentDAO paymentDAO) {
        this.paymentDAO = paymentDAO;
    }

    @POST
    @Timed
    public Payment submit(Payment payment){
        return paymentDAO.create(payment);
    }

    @GET
    @Timed
    public List<Payment> listPayments() {
        return paymentDAO.findAll();
    }
}
