package com.pedrovega.operationquasarmlb.db.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@Entity
@Table
public class Satellites {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotEmpty
    @Column(nullable = false)
    private String name;

    @NotEmpty
    @Column(nullable = false)
    private Float distance;

    @NotEmpty
    @Column(nullable = false)
    private String message;

    public Satellites() {
    }

    public Satellites(String name, Float distance, String message) {
        this.name = name;
        this.distance = distance;
        this.message = message;
    }
}
