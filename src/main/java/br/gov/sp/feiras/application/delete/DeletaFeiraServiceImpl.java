package br.gov.sp.feiras.application.delete;

import br.gov.sp.feiras.entity.repository.FeiraRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class DeletaFeiraServiceImpl implements DeletaFeiraService {

    private static final Logger LOG = LoggerFactory.getLogger(DeletaFeiraServiceImpl.class);

    private final FeiraRepository repository;

    public DeletaFeiraServiceImpl(FeiraRepository repository) {
        this.repository = repository;
    }

    @Override
    public void deletarFeira(Long id) {
        LOG.info("Inicio de deleção feira de ID {}", id);

        boolean exists = repository.existsById(id);

        if (exists) {
            repository.deleteById(id);
            LOG.info("Feira ID {} deletado com sucesso", id);
        } else {
            LOG.error("Feira de ID {} não existe para processeguir com precesso de deleção", id);

            throw  new RuntimeException("Feira Inexistente");
        }
    }

}
