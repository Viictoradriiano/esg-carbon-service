package br.com.fiap.esg.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Getter; import lombok.Setter;

import java.time.LocalDate;

@Getter @Setter
@Entity @Table(name = "EMISSION_RECORD")
public class EmissionRecord {

    public enum Scope { SCOPE1, SCOPE2, SCOPE3 }

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "COMPANY_ID")
    private Company company;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "SCOPE", nullable = false, length = 16)
    private Scope scope;

    @NotNull
    @Column(name = "DATE_AT", nullable = false)
    private LocalDate dateAt;

    @Min(0)
    @Column(name = "AMOUNT_TCO2E", nullable = false)
    private Double amountTco2e;

    @Column(name = "SOURCE", length = 100)
    private String source;

    @Column(name = "NOTES", length = 500)
    private String notes;
}
