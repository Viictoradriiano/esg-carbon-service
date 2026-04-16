package br.com.fiap.esg.service;

import br.com.fiap.esg.domain.Company;
import br.com.fiap.esg.domain.MitigationSchedule;
import br.com.fiap.esg.dto.MitigationCreateDTO;
import br.com.fiap.esg.exception.ResourceNotFoundException;
import br.com.fiap.esg.repository.CompanyRepository;
import br.com.fiap.esg.repository.MitigationScheduleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MitigationService {

    private final MitigationScheduleRepository repo;
    private final CompanyRepository companyRepo;

    public MitigationService(MitigationScheduleRepository repo, CompanyRepository companyRepo) {
        this.repo = repo; this.companyRepo = companyRepo;
    }

    public MitigationSchedule create(MitigationCreateDTO dto) {
        Company c = companyRepo.findById(dto.companyId())
                .orElseThrow(() -> new ResourceNotFoundException("Empresa não encontrada"));
        MitigationSchedule m = new MitigationSchedule();
        m.setCompany(c);
        m.setActionDesc(dto.actionDesc());
        m.setScheduledDate(dto.scheduledDate());
        m.setEstimatedReductionTco2e(dto.estimatedReductionTco2e());
        m.setStatus(MitigationSchedule.Status.PLANNED);
        return repo.save(m);
    }

    public MitigationSchedule updateStatus(Long id, String status) {
        MitigationSchedule m = repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Agendamento não encontrado"));
        m.setStatus(MitigationSchedule.Status.valueOf(status));
        return repo.save(m);
    }

    public List<MitigationSchedule> list() { return repo.findAll(); }
}
