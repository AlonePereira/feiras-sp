package br.gov.sp.feiras.entity.repository;

import br.gov.sp.feiras.application.vo.BuscaFeirasVO;
import br.gov.sp.feiras.entity.Feira;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import java.text.MessageFormat;

@Component
public class FeiraSpecificationFactoryComponentImpl implements FeiraSpecificationFactoryComponent {

    private static final Logger LOG = LoggerFactory.getLogger(FeiraSpecificationFactoryComponentImpl.class);

    @Override
    public Specification<Feira> getSpecification(BuscaFeirasVO buscaFeiras) {
        String nomeFeira = buscaFeiras.getNomeFeira();
        String distrito = buscaFeiras.getDistrito();
        String bairro = buscaFeiras.getBairro();
        String regiao5 = buscaFeiras.getRegiao5();

        LOG.info("Pegando Specification para buscar feiras pelo Parametros: " +
                "NomeFeira: {}, Distrito: {}, Bairro: {}, Regiao5: {}", nomeFeira, distrito, bairro, regiao5);

        return Specification
                .where(nomeFeiraContains(nomeFeira))
                .and(distritoContains(distrito))
                .and(bairroContains(bairro))
                .and(regiao5Equal(regiao5));
    }

    private Specification<Feira> distritoContains(String distrito) {
        if (distrito == null || distrito.isBlank()) {
            return null;
        }
        return (root, query, builder) -> builder.like(root.get("distrito"), contains(distrito));
    }

    private Specification<Feira> nomeFeiraContains(String nomeFeira) {
        if (nomeFeira == null || nomeFeira.isBlank()) {
            return null;
        }
        return (root, query, builder) -> builder.like(root.get("nomeFeira"), contains(nomeFeira));
    }

    private Specification<Feira> bairroContains(String bairro) {
        if (bairro == null || bairro.isBlank()) {
            return null;
        }
        return (root, query, builder) -> builder.like(root.get("bairro"), contains(bairro));
    }

    private Specification<Feira> regiao5Equal(String regiao5) {
        if (regiao5 == null || regiao5.isBlank()) {
            return null;
        }
        return (root, query, builder) -> builder.equal(root.get("regiao5"), regiao5);
    }

    private String contains(String texto) {
        return MessageFormat.format("%{0}%", texto);
    }


}
