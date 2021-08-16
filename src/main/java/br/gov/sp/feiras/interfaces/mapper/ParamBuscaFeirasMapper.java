package br.gov.sp.feiras.interfaces.mapper;

import br.gov.sp.feiras.application.vo.BuscaFeirasVO;
import br.gov.sp.feiras.interfaces.dto.ParamBuscaFeiras;
import org.mapstruct.Mapper;

@Mapper
public interface ParamBuscaFeirasMapper {

    BuscaFeirasVO toBuscaFeirasVO(ParamBuscaFeiras paramBuscaFeiras);

}
