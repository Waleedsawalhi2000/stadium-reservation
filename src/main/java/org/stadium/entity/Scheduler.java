package org.stadium.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "scheduler")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class Scheduler extends BaseEntity<Integer> {
    @Column(nullable = false)
    private Integer value;
    @JoinColumn(referencedColumnName = "id", nullable = false)
    @OneToOne
    private User user;
    @Column
    private Timestamp timestamp;
}
