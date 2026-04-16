package br.com.fiap.esg.controller;

import br.com.fiap.esg.service.IndicatorService;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class IndicatorController {

    private final IndicatorService service;
    public IndicatorController(IndicatorService service) { this.service = service; }

    @GetMapping("/indicadores")
    public Map<String,Object> indicators() { return service.indicators(); }

    @GetMapping("/impacto/{id}")
    public Map<String,Object> impact(@PathVariable Long id) { return service.impact(id); }
}
