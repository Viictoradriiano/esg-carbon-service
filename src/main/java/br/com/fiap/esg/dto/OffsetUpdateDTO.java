package br.com.fiap.esg.dto;

import java.time.LocalDate;

public record OffsetUpdateDTO(
        String status,
        LocalDate endDate
) {}
