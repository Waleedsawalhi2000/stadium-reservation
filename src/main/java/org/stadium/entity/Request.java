package org.stadium.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.stadium.dto.PaymentMethod;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "request")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class Request extends BaseEntity<Integer> {
    private String name;
    @JoinTable(name = "user_request")
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private User user;
    @JoinTable(name = "stadium_request")
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Stadium stadium;
    @Column
    private Timestamp started;
    @Column
    private Timestamp ended;
    @Column
    private String paymentMethod;
    @Column
    private Boolean status;
    @Transient
    private PaymentMethod payMethod;


    public void setPaymentMethod(final String paymentMethod) {
        this.paymentMethod = PaymentMethod.getPaymentMethod(payMethod);
    }
}
