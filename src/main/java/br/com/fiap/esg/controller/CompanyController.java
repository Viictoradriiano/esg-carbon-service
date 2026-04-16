package br.com.fiap.esg.controller;

import br.com.fiap.esg.domain.Company;
import br.com.fiap.esg.repository.CompanyRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/empresas")
public class CompanyController {

    private final CompanyRepository repo;

    public CompanyController(CompanyRepository repo) { this.repo = repo; }

    @GetMapping
    public List<Company> list() { return repo.findAll(); }
}
