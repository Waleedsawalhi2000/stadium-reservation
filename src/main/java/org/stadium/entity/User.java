package org.stadium.entity;


import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "user", uniqueConstraints = {@UniqueConstraint(columnNames = {"phoneNumber", "username", "email"})})
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class User extends BaseEntity<Integer> {
    @Column(nullable = false, unique = true)
    private String email;
    @Column(nullable = false, unique = true)
    private String username;
    @Column(nullable = false)
    private String password;
    private boolean active;
    private String roles;
    @Column(nullable = false, unique = true)
    private String phoneNumber;
    @Column(nullable = false)
    private String firstname;
    @Column(nullable = false)
    private String lastname;
    @Column(nullable = false)
    private Boolean verified;
    @JoinColumn(referencedColumnName = "id")
    @OneToMany()
    private List<Stadium> stadiums;
    @JoinColumn(referencedColumnName = "id")
    @OneToMany()
    private List<Order> orders;

    public void setOrders(final List<Order> orders) {
        this.orders = roles.contains("USER") ? orders : null;
    }

    public void setStadiums(final List<Stadium> stadiums) {
        this.stadiums = roles.contains("ADMIN") ? stadiums : null;
    }
}
