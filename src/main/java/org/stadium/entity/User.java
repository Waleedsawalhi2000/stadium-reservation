package org.stadium.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

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
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.DETACH, mappedBy = "admin")
    @Fetch(value = FetchMode.SUBSELECT)
    private List<Stadium> stadiums = new ArrayList<>();
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.DETACH, mappedBy = "user")
    @Fetch(value = FetchMode.SUBSELECT)
    private List<Request> requests = new ArrayList<>();


    public User setStadiums(final List<Stadium> stadiums) {
        this.stadiums = roles.contains("ADMIN") ? stadiums : null;
        return this;
    }

    public User setRequests(final List<Request> requests) {
        this.requests = requests;
        return this;
    }
}
