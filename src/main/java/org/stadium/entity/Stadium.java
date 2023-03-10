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
@Table(name = "stadium")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@SuperBuilder
public class Stadium extends BaseEntity<Integer> {
    @Column(nullable = false, unique = true)
    private String name;
    @Column(nullable = false, unique = true)
    private String stadiumId;
    @JoinColumn(referencedColumnName = "id")
    @OneToOne(cascade = CascadeType.ALL)
    private Location location;
    @Column(nullable = false)
    private Integer price;
    @Column
    private String size;
    @JoinColumn(referencedColumnName = "id")
    @OneToOne(cascade = CascadeType.ALL)
    private Media image;
    @JoinTable(name = "admin_stadium")
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.DETACH)
    private User admin;
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.DETACH, mappedBy = "stadium")
    @Fetch(value = FetchMode.SUBSELECT)
    @JsonIgnore
    private List<Request> requests = new ArrayList<>();
    @Column(nullable = false)
    private String phoneNumber;
    @Column
    private String description;
}
