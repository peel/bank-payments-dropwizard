package io.peel.github.bank.customer.core;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.annotations.Entity;
import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;

import javax.persistence.Table;

@Entity
@Table(name = "payments")
@NamedQueries({
        @NamedQuery(
                name = "io.peel.github.bank.customer.core.Payment.findAll",
                query = "SELECT p FROM Payment p"
        )
})
public class Payment {
    private long id;

    private String debit;
    private String credit;
    private String amount;
    private String title;

    public Payment() {
        // Jackson deserialization
    }

    public Payment(long id, String debit, String credit, String amount, String title) {
        this.id = id;
        this.amount = amount;
        this.debit = debit;
        this.credit = credit;
        this.title = title;
    }

    @JsonProperty
    public long getId() {
        return id;
    }

    @JsonProperty
    public String getAmount() {
        return amount;
    }

    @JsonProperty
    public String getCredit() {
        return credit;
    }

    @JsonProperty
    public String getDebit() {
        return debit;
    }

    @JsonProperty
    public String getTitle() {
        return title;
    }

}
