package org.stadium.entity;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
@RequiredArgsConstructor
@Data
public class AvailableTime {
    @Id
    private Integer id;
}
