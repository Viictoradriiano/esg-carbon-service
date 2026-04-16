package br.com.fiap.esg.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record EmissionCreateDTO(
        @NotNull Long companyId,
        @NotNull String scope,
        @NotNull LocalDate dateAt,
        @Min(0) Double amountTco2e,
        String source,
        String notes
) {}
