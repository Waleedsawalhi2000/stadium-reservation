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
@Table(name = "order")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class Order extends BaseEntity<Integer> {
    @JoinColumn(nullable = false, referencedColumnName = "id")
    @ManyToOne
    private User user;
    @JoinColumn(nullable = false, referencedColumnName = "id")
    @OneToOne
    private Stadium stadium;
    @Column
    private Timestamp started;
    @Column
    private Timestamp ended;
    @Column
    private PaymentMethod paymentMethod;
}
