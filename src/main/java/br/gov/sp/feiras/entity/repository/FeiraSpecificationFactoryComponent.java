package br.gov.sp.feiras.entity.repository;

import br.gov.sp.feiras.application.vo.BuscaFeirasVO;
import br.gov.sp.feiras.entity.Feira;
import org.springframework.data.jpa.domain.Specification;

public interface FeiraSpecificationFactoryComponent {

    Specification<Feira> getSpecification(BuscaFeirasVO buscaFeiras);

}
