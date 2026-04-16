package br.com.fiap.esg.controller;

import br.com.fiap.esg.domain.OffsetInitiative;
import br.com.fiap.esg.dto.OffsetCreateDTO;
import br.com.fiap.esg.dto.OffsetUpdateDTO;
import br.com.fiap.esg.service.OffsetService;
import jakarta.validation.Valid;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/compensacoes")
public class OffsetController {

    private final OffsetService service;
    public OffsetController(OffsetService service) { this.service = service; }

    @GetMapping
    public List<OffsetInitiative> list() { return service.list(); }

    @PostMapping
    public OffsetInitiative create(@Valid @RequestBody OffsetCreateDTO dto) {
        return service.create(dto);
    }

    @PutMapping("/{id}")
    public OffsetInitiative update(@PathVariable Long id, @RequestBody OffsetUpdateDTO dto) {
        return service.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
