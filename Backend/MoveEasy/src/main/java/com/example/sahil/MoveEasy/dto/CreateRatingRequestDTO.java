package com.example.sahil.MoveEasy.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateRatingRequestDTO {

    @Min(1)
    @Max(5)
    private Integer stars;

    private String comment;
}