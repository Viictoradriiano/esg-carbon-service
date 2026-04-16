package br.com.fiap.esg.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;

public record OffsetCreateDTO(
        @NotNull Long companyId,
        @NotNull String type,
        LocalDate startDate,
        LocalDate endDate,
        @Min(0) Double estimatedOffsetTco2e
) {}
