package br.gov.sp.feiras.entity.repository;

import br.gov.sp.feiras.entity.Feira;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface FeiraRepository extends JpaRepository<Feira, Long>, JpaSpecificationExecutor<Feira> {

}
