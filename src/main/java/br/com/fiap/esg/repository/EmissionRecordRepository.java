package br.com.fiap.esg.repository;
import br.com.fiap.esg.domain.EmissionRecord;
import br.com.fiap.esg.domain.Company;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface EmissionRecordRepository extends JpaRepository<EmissionRecord, Long> {
    List<EmissionRecord> findByCompanyIdAndDateAtBetween(Long companyId, LocalDate start, LocalDate end);
    List<EmissionRecord> findByCompanyId(Long companyId);
}
