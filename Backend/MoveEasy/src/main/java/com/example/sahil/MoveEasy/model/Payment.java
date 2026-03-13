package com.example.sahil.MoveEasy.model;

import com.example.sahil.MoveEasy.enums.PaymentStatus;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;


@Getter
@Setter
@Entity
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String stripePaymentIntentId;

    @Column(nullable = false)
    private Double amount;

    @Column(nullable = false)
    private String currency; // e.g., "INR"

    @Enumerated(EnumType.STRING)
    private PaymentStatus status;

    private String paymentMethod; // CARD, UPI, etc.

    private LocalDateTime createdAt;

    @OneToOne
    @JoinColumn(name = "ride_id", nullable = false, unique = true)
    private Ride ride;
}