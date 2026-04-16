package br.com.fiap.esg.service;

import br.com.fiap.esg.domain.Company;
import br.com.fiap.esg.domain.OffsetInitiative;
import br.com.fiap.esg.dto.OffsetCreateDTO;
import br.com.fiap.esg.dto.OffsetUpdateDTO;
import br.com.fiap.esg.exception.ResourceNotFoundException;
import br.com.fiap.esg.repository.CompanyRepository;
import br.com.fiap.esg.repository.OffsetInitiativeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OffsetService {

    private final OffsetInitiativeRepository repo;
    private final CompanyRepository companyRepo;

    public OffsetService(OffsetInitiativeRepository repo, CompanyRepository companyRepo) {
        this.repo = repo; this.companyRepo = companyRepo;
    }

    public OffsetInitiative create(OffsetCreateDTO dto) {
        Company company = companyRepo.findById(dto.companyId())
                .orElseThrow(() -> new ResourceNotFoundException("Empresa não encontrada"));
        OffsetInitiative o = new OffsetInitiative();
        o.setCompany(company);
        o.setType(OffsetInitiative.Type.valueOf(dto.type()));
        o.setStartDate(dto.startDate());
        o.setEndDate(dto.endDate());
        o.setEstimatedOffsetTco2e(dto.estimatedOffsetTco2e());
        o.setStatus(OffsetInitiative.Status.PLANNED);
        return repo.save(o);
    }

    public OffsetInitiative update(Long id, OffsetUpdateDTO dto) {
        OffsetInitiative o = repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Iniciativa não encontrada"));
        if (dto.status() != null) {
            o.setStatus(OffsetInitiative.Status.valueOf(dto.status()));
        }
        if (dto.endDate() != null) {
            o.setEndDate(dto.endDate());
        }
        return repo.save(o);
    }

    public void delete(Long id) {
        if (!repo.existsById(id)) throw new ResourceNotFoundException("Iniciativa não encontrada");
        repo.deleteById(id);
    }

    public List<OffsetInitiative> list() { return repo.findAll(); }
}
