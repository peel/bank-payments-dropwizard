package io.peel.github.bank.customer.core;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.annotations.Entity;
import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;
import org.hibernate.validator.constraints.Length;

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

    @Length(max = 3)
    private String content;

    public Payment() {
        // Jackson deserialization
    }

    public Payment(long id, String content) {
        this.id = id;
        this.content = content;
    }

    @JsonProperty
    public long getId() {
        return id;
    }

    @JsonProperty
    public String getContent() {
        return content;
    }
}
