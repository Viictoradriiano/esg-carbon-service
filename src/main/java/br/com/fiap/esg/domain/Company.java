package br.com.fiap.esg.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter; import lombok.Setter;

@Getter @Setter
@Entity @Table(name = "COMPANY")
public class Company {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @NotBlank
    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "CNPJ", unique = true, length = 32)
    private String cnpj;

    @Column(name = "SECTOR", length = 100)
    private String sector;
}
