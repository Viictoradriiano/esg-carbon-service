package br.com.fiap.esg.service;

import br.com.fiap.esg.domain.EmissionRecord;
import br.com.fiap.esg.domain.OffsetInitiative;
import br.com.fiap.esg.repository.EmissionRecordRepository;
import br.com.fiap.esg.repository.OffsetInitiativeRepository;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class IndicatorService {

    private final EmissionRecordRepository emissionRepo;
    private final OffsetInitiativeRepository offsetRepo;

    public IndicatorService(EmissionRecordRepository emissionRepo, OffsetInitiativeRepository offsetRepo) {
        this.emissionRepo = emissionRepo; this.offsetRepo = offsetRepo;
    }

    public Map<String,Object> indicators() {
        double totalEmissions = emissionRepo.findAll().stream()
                .mapToDouble(e -> e.getAmountTco2e() == null ? 0 : e.getAmountTco2e())
                .sum();
        double totalOffset = offsetRepo.findAll().stream()
                .mapToDouble(o -> o.getEstimatedOffsetTco2e() == null ? 0 : o.getEstimatedOffsetTco2e())
                .sum();
        Map<String,Object> m = new HashMap<>();
        m.put("totalEmissionsTco2e", totalEmissions);
        m.put("totalOffsetTco2e", totalOffset);
        m.put("netBalanceTco2e", totalEmissions - totalOffset);
        return m;
    }

    public Map<String, Object> impact(Long id) {
        Map<String,Object> m = new HashMap<>();
        OffsetInitiative o = offsetRepo.findById(id).orElse(null);
        if (o != null) {
            m.put("type", o.getType().name());
            m.put("estimatedOffsetTco2e", o.getEstimatedOffsetTco2e());
            m.put("status", o.getStatus().name());
            m.put("impactDetail", "Impacto estimado calculado via parâmetros simples.");
            return m;
        }
        // fallback simple message
        m.put("message", "Recurso não encontrado para cálculo de impacto.");
        return m;
    }
}
