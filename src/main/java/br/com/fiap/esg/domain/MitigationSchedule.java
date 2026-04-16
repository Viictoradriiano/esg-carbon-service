package br.com.fiap.esg.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter; import lombok.Setter;

import java.time.LocalDate;

@Getter @Setter
@Entity @Table(name = "MITIGATION_SCHEDULE")
public class MitigationSchedule {

    public enum Status { PLANNED, ACTIVE, COMPLETED, CANCELLED }

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "COMPANY_ID")
    private Company company;

    @NotBlank
    @Column(name = "ACTION_DESC", nullable = false, length = 200)
    private String actionDesc;

    @Column(name = "SCHEDULED_DATE")
    private LocalDate scheduledDate;

    @Min(0)
    @Column(name = "EST_REDUCTION_TCO2E")
    private Double estimatedReductionTco2e;

    @Enumerated(EnumType.STRING)
    @Column(name = "STATUS", length = 16)
    private Status status = Status.PLANNED;
}
