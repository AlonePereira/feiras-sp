package br.gov.sp.feiras.application.atualiza;

import br.gov.sp.feiras.application.exception.FeiraNotFound;
import br.gov.sp.feiras.application.mapper.FeiraVOMapper;
import br.gov.sp.feiras.application.vo.FeiraVO;
import br.gov.sp.feiras.entity.repository.FeiraRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class AtualizaFeiraServiceImpl implements AtualizaFeiraService {

    private static final Logger LOG = LoggerFactory.getLogger(AtualizaFeiraServiceImpl.class);

    private final FeiraRepository repository;
    private final FeiraVOMapper feiraVOMapper;

    public AtualizaFeiraServiceImpl(FeiraRepository repository, FeiraVOMapper feiraVOMapper) {
        this.repository = repository;
        this.feiraVOMapper = feiraVOMapper;
    }

    @Override
    public FeiraVO atualizarFeira(FeiraVO feiraVO) {
        LOG.info("Atualizando Feira com ID {}", feiraVO.getId());

        var existsById = repository.existsById(feiraVO.getId());

        if (existsById) {
            var feira = repository.save(feiraVOMapper.toFeira(feiraVO));
            LOG.info("Feira ID {} atualizada com sucesso", feira.getId());
            return feiraVOMapper.toFeiraVO(feira);
        } else {
            LOG.error("Feira com ID {} não encontrada para ser atualizada.", feiraVO.getId());
            throw  new FeiraNotFound("Feira não encontrada");
        }
    }

}
