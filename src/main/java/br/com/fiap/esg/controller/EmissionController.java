package br.com.fiap.esg.controller;

import br.com.fiap.esg.domain.EmissionRecord;
import br.com.fiap.esg.dto.EmissionCreateDTO;
import br.com.fiap.esg.service.EmissionService;
import jakarta.validation.Valid;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/emissoes")
public class EmissionController {

    private final EmissionService service;
    public EmissionController(EmissionService service) { this.service = service; }

    @GetMapping
    public List<EmissionRecord> list(
            @RequestParam(required = false) Long companyId,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate start,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate end
    ) {
        return service.list(companyId, start, end);
    }

    @PostMapping
    public EmissionRecord create(@Valid @RequestBody EmissionCreateDTO dto) {
        return service.create(dto);
    }
}
