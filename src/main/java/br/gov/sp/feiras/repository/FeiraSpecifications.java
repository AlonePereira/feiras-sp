package br.gov.sp.feiras.repository;

import br.gov.sp.feiras.entity.Feira;
import org.springframework.data.jpa.domain.Specification;

import java.text.MessageFormat;

public final class FeiraSpecifications {

    public static Specification<Feira> distritoContains(String distrito) {
        return (root, query, builder) -> builder.like(root.get("distrito"), contains(distrito));
    }

    public static Specification<Feira> nomeFeiraContains(String nomeFeira) {
        return (root, query, builder) -> builder.like(root.get("nomeFeira"), contains(nomeFeira));
    }

    public static Specification<Feira> bairroContains(String bairro) {
        return (root, query, builder) -> builder.like(root.get("bairro"), contains(bairro));
    }

    public static Specification<Feira> regiao5Equal(String regiao5) {
        return (root, query, builder) -> builder.equal(root.get("regiao5"), regiao5);
    }

    private static String contains(String texto) {
        return MessageFormat.format("%{0}%", texto);
    }

}
