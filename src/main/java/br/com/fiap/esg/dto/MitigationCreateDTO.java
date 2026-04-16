package br.com.fiap.esg.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record MitigationCreateDTO(
        @NotNull Long companyId,
        @NotBlank String actionDesc,
        LocalDate scheduledDate,
        @Min(0) Double estimatedReductionTco2e
) {}
