package org.stadium.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "verification_code")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class Code extends BaseEntity<Integer> {
    @Column(nullable = false)
    private Integer value;
    @JoinColumn(referencedColumnName = "id", nullable = false)
    @OneToOne
    private User user;
    @Column(nullable = false)
    private Timestamp timestamp;
}
