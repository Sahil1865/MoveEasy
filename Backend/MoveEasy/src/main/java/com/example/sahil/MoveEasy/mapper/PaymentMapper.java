package com.example.sahil.MoveEasy.mapper;

import com.example.sahil.MoveEasy.dto.PaymentResponseDTO;
import com.example.sahil.MoveEasy.model.Payment;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PaymentMapper {

    @Mapping(source = "ride.id", target = "rideId")
    PaymentResponseDTO toDTO(Payment payment);
}