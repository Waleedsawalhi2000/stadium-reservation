package org.stadium.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
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
@SuperBuilder
public class Stadium extends BaseEntity<Integer> {
    @Column(nullable = false, unique = true)
    private String name;
    @Column(nullable = false, unique = true)
    private String stadiumId;
    @JoinColumn(nullable = false, referencedColumnName = "id")
    @OneToOne
    private Location location;
    @Column(nullable = false)
    private Integer price;
    @Column
    private String size;
    @JoinColumn(referencedColumnName = "id")
    @OneToOne
    private Media image;
    @JoinTable(name = "admin_stadium")
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.DETACH)
    private User admin;
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.DETACH, mappedBy = "stadium")
    @Fetch(value = FetchMode.SUBSELECT)
    private List<Request> requests = new ArrayList<>();
}
