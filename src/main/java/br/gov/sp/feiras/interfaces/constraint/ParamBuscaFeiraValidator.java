package br.gov.sp.feiras.interfaces.constraint;

import br.gov.sp.feiras.interfaces.dto.ParamBuscaFeiras;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import static java.util.Objects.isNull;

public class ParamBuscaFeiraValidator implements ConstraintValidator<ValidaParamBuscaFeira, ParamBuscaFeiras> {

    @Override
    public boolean isValid(ParamBuscaFeiras param, ConstraintValidatorContext context) {

        if (isNull(param)) {
           return false;
        } else if((isNull(param.getBairro()) || param.getBairro().isBlank()) &&
                (isNull(param.getDistrito()) || param.getDistrito().isBlank()) &&
                (isNull(param.getNomeFeira()) || param.getNomeFeira().isBlank()) &&
                (isNull(param.getRegiao5()) || param.getRegiao5().isBlank())) {
            return false;
        } else {
            return true;
        }
    }

}
