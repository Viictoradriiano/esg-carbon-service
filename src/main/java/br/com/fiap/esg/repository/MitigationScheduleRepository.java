package br.com.fiap.esg.repository;
import br.com.fiap.esg.domain.MitigationSchedule;
import org.springframework.data.jpa.repository.JpaRepository;
public interface MitigationScheduleRepository extends JpaRepository<MitigationSchedule, Long> { }
