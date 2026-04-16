package br.com.fiap.esg.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Getter; import lombok.Setter;

import java.time.LocalDate;

@Getter @Setter
@Entity @Table(name = "OFFSET_INITIATIVE")
public class OffsetInitiative {

    public enum Type { REFORESTATION, CARBON_CREDIT, RENEWABLE_ENERGY }
    public enum Status { PLANNED, ACTIVE, COMPLETED, CANCELLED }

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "COMPANY_ID")
    private Company company;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "TYPE", nullable = false, length = 32)
    private Type type;

    @Column(name = "START_DATE")
    private LocalDate startDate;

    @Column(name = "END_DATE")
    private LocalDate endDate;

    @Min(0)
    @Column(name = "EST_OFFSET_TCO2E", nullable = false)
    private Double estimatedOffsetTco2e;

    @Enumerated(EnumType.STRING)
    @Column(name = "STATUS", length = 16)
    private Status status = Status.PLANNED;
}
