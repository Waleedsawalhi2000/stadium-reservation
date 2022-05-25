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
    @JoinTable(name = "user_request")
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.DETACH)
    private User user;
    @JoinTable(name = "stadium_request")
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.DETACH)
    private Stadium stadium;
    @Column
    private Timestamp started;
    @Column
    private Timestamp ended;
    @Column
    private String paymentMethod;


    public Request setStadium(final Stadium  stadium) {
        this.stadium = stadium;
        return this;
    }
}
