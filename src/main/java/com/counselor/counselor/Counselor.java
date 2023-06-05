package com.counselor.counselor;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="CTable")
public class Counselor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long counselorId;
    private String specialization;
    private Date created;
    private Date update;
    private String description;

}
