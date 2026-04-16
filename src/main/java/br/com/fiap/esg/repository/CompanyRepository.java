package br.com.fiap.esg.repository;
import br.com.fiap.esg.domain.Company;
import org.springframework.data.jpa.repository.JpaRepository;
public interface CompanyRepository extends JpaRepository<Company, Long> { }
