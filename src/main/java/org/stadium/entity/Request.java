package org.stadium.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.time.LocalDate;
import java.time.LocalDateTime;

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
    @Column(columnDefinition = "TIMESTAMP")
    private LocalDateTime started;
    @Column(columnDefinition = "TIMESTAMP")
    private LocalDateTime ended;
    @Column
    private String paymentMethod;
    @Column
    private String status;


    public Request setStadium(final Stadium  stadium) {
        this.stadium = stadium;
        return this;
    }
}
