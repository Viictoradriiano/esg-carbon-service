package br.com.fiap.esg.controller;

import br.com.fiap.esg.domain.MitigationSchedule;
import br.com.fiap.esg.dto.MitigationCreateDTO;
import br.com.fiap.esg.service.MitigationService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/agendamentos-reducao")
public class MitigationController {

    private final MitigationService service;
    public MitigationController(MitigationService service) { this.service = service; }

    @GetMapping
    public List<MitigationSchedule> list() { return service.list(); }

    @PostMapping
    public MitigationSchedule create(@Valid @RequestBody MitigationCreateDTO dto) {
        return service.create(dto);
    }

    @PutMapping("/{id}/status/{status}")
    public MitigationSchedule update(@PathVariable Long id, @PathVariable String status) {
        return service.updateStatus(id, status);
    }
}
