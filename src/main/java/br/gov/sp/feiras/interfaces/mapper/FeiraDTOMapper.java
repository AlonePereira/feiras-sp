package br.gov.sp.feiras.interfaces.mapper;

import br.gov.sp.feiras.application.vo.FeiraVO;
import br.gov.sp.feiras.interfaces.dto.FeiraDTO;
import br.gov.sp.feiras.interfaces.dto.FeiraDTORS;
import org.mapstruct.*;

import java.util.List;

@Mapper
public interface FeiraDTOMapper {


    @Mappings({
            @Mapping(target = "numero", source = "feiraDTO.numero", ignore = true),
            @Mapping(target = "referencia", source = "feiraDTO.referencia", ignore = true)
    })
    FeiraVO toFeiraVO(Long id, FeiraDTO feiraDTO);

    FeiraDTORS toFeiraDTORS(FeiraVO feiraVO);

    List<FeiraDTORS> toFeiraDTORSList(List<FeiraVO> feiraVOList);

    @AfterMapping
    default void setNumero(@MappingTarget FeiraVO feiraVO, FeiraDTO feiraDTO) {
        if (feiraDTO == null || feiraDTO.getNumero() == null) {
            feiraVO.setNumero("");
        } else {
            feiraVO.setNumero(feiraDTO.getNumero());
        }
    }

    @AfterMapping
    default void setReferencia(@MappingTarget FeiraVO feiraVO, FeiraDTO feiraDTO) {
        if (feiraDTO == null || feiraDTO.getReferencia() == null) {
            feiraVO.setReferencia("");
        } else {
            feiraVO.setReferencia(feiraDTO.getReferencia());
        }
    }

}
