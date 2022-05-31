package org.stadium.entity;


import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.stadium.dto.PaymentMethod;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;
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
    @Column
    private String started;
    @Column
    private String ended;
    @Column
    private String paymentMethod;
    private String status;


    public Request setStadium(final Stadium  stadium) {
        this.stadium = stadium;
        return this;
    }
}
