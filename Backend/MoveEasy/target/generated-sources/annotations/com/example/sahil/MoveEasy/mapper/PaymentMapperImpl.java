package com.example.sahil.MoveEasy.mapper;

import com.example.sahil.MoveEasy.dto.PaymentResponseDTO;
import com.example.sahil.MoveEasy.model.Payment;
import com.example.sahil.MoveEasy.model.Ride;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-02-27T21:59:43+0530",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.17 (Eclipse Adoptium)"
)
@Component
public class PaymentMapperImpl implements PaymentMapper {

    @Override
    public PaymentResponseDTO toDTO(Payment payment) {
        if ( payment == null ) {
            return null;
        }

        PaymentResponseDTO paymentResponseDTO = new PaymentResponseDTO();

        paymentResponseDTO.setRideId( paymentRideId( payment ) );
        paymentResponseDTO.setId( payment.getId() );
        paymentResponseDTO.setAmount( payment.getAmount() );
        paymentResponseDTO.setCurrency( payment.getCurrency() );
        paymentResponseDTO.setStatus( payment.getStatus() );
        paymentResponseDTO.setPaymentMethod( payment.getPaymentMethod() );
        paymentResponseDTO.setCreatedAt( payment.getCreatedAt() );

        return paymentResponseDTO;
    }

    private Long paymentRideId(Payment payment) {
        if ( payment == null ) {
            return null;
        }
        Ride ride = payment.getRide();
        if ( ride == null ) {
            return null;
        }
        Long id = ride.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }
}
