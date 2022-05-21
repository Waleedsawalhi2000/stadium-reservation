package org.stadium.entity;


import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "user", uniqueConstraints = {@UniqueConstraint(columnNames = {"phoneNumber", "username", "email", "userId"})})
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
    @Column(nullable = false)
    private String userId;
    @Column
    private Boolean active;
    private String roles;
    @Column(nullable = false, unique = true)
    private String phoneNumber;
    @Column(nullable = false)
    private String firstname;
    @Column(nullable = false)
    private String lastname;
    @Column(nullable = false)
    private Boolean verified;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "admin")
    private List<Stadium> stadiums = new ArrayList<>();
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<Request> requests = new ArrayList<>();


    public void setStadiums(final List<Stadium> stadiums) {
        this.stadiums = roles.contains("ADMIN") ? stadiums : null;
    }
}
