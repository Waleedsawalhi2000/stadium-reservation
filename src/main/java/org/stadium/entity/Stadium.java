package org.stadium.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

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
    @JoinColumn(referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.EAGER)
    private User admin;
}