package br.com.fiap.esg.service;

import br.com.fiap.esg.domain.Company;
import br.com.fiap.esg.domain.EmissionRecord;
import br.com.fiap.esg.dto.EmissionCreateDTO;
import br.com.fiap.esg.exception.ResourceNotFoundException;
import br.com.fiap.esg.repository.CompanyRepository;
import br.com.fiap.esg.repository.EmissionRecordRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class EmissionService {

    private final EmissionRecordRepository repo;
    private final CompanyRepository companyRepo;

    public EmissionService(EmissionRecordRepository repo, CompanyRepository companyRepo) {
        this.repo = repo; this.companyRepo = companyRepo;
    }

    public EmissionRecord create(EmissionCreateDTO dto) {
        Company company = companyRepo.findById(dto.companyId())
                .orElseThrow(() -> new ResourceNotFoundException("Empresa não encontrada"));
        EmissionRecord e = new EmissionRecord();
        e.setCompany(company);
        e.setScope(EmissionRecord.Scope.valueOf(dto.scope()));
        e.setDateAt(dto.dateAt());
        e.setAmountTco2e(dto.amountTco2e());
        e.setSource(dto.source());
        e.setNotes(dto.notes());
        return repo.save(e);
    }

    public List<EmissionRecord> list(Long companyId, LocalDate start, LocalDate end) {
        if (companyId != null && start != null && end != null) {
            return repo.findByCompanyIdAndDateAtBetween(companyId, start, end);
        } else if (companyId != null) {
            return repo.findByCompanyId(companyId);
        }
        return repo.findAll();
    }
}
