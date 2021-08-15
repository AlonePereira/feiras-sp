package br.gov.sp.feiras.application.busca;

import br.gov.sp.feiras.application.mapper.FeiraVOMapper;
import br.gov.sp.feiras.application.vo.BuscaFeirasVO;
import br.gov.sp.feiras.application.vo.FeiraVO;
import br.gov.sp.feiras.repository.FeiraRepository;
import br.gov.sp.feiras.repository.FeiraSpecificationFactoryComponent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BuscaFeiraServiceImpl implements BuscaFeiraService {

    private static final Logger LOG = LoggerFactory.getLogger(BuscaFeiraServiceImpl.class);

    private final FeiraRepository repository;
    private final FeiraSpecificationFactoryComponent specificationFactoryComponent;
    private final FeiraVOMapper feiraVOMapper;

    public BuscaFeiraServiceImpl(FeiraRepository repository,
                                 FeiraSpecificationFactoryComponent specificationFactoryComponent,
                                 FeiraVOMapper feiraVOMapper) {
        this.repository = repository;
        this.specificationFactoryComponent = specificationFactoryComponent;
        this.feiraVOMapper = feiraVOMapper;
    }

    @Override
    public List<FeiraVO> buscarFeiras(BuscaFeirasVO bascaFeiras) {
        LOG.info("Buscando Feiras");

        var feiras = repository.findAll(specificationFactoryComponent.getSpecification(bascaFeiras));

        LOG.info("Foram encontrados {} feiras", feiras.size());

        return feiraVOMapper.toFeiraVOList(feiras);
    }
}
