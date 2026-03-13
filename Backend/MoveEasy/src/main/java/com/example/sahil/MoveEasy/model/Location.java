package com.example.sahil.MoveEasy.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Location {

    @Column(nullable = false, precision = 10, scale = 6)
    private Double latitude;

    @Column(nullable = false)
    private Double longitude;

    private String address; // Optional readable address
}