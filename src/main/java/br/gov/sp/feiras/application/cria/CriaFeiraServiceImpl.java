package br.gov.sp.feiras.application.cria;

import br.gov.sp.feiras.application.mapper.FeiraVOMapper;
import br.gov.sp.feiras.application.vo.FeiraVO;
import br.gov.sp.feiras.entity.repository.FeiraRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class CriaFeiraServiceImpl implements CriaFeiraService {

    private static final Logger LOG = LoggerFactory.getLogger(CriaFeiraServiceImpl.class);

    private final FeiraRepository repository;
    private final FeiraVOMapper feiraVOMapper;

    public CriaFeiraServiceImpl(FeiraRepository repository, FeiraVOMapper feiraVOMapper) {
        this.repository = repository;
        this.feiraVOMapper = feiraVOMapper;
    }

    @Override
    public FeiraVO criarFeira(FeiraVO feiraVO) {
        LOG.info("Criando Feira com Nome {}, Regiao5 {}, Registro {}", feiraVO.getNomeFeira(), feiraVO.getRegiao5(),
                feiraVO.getRegistro());

        var feiraSaved = repository.save(feiraVOMapper.toFeira(feiraVO));

        LOG.info("Feira salva com ID {}", feiraSaved.getId());

        return feiraVOMapper.toFeiraVO(feiraSaved);
    }

}
