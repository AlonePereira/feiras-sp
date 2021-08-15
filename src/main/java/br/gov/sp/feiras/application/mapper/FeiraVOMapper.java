package br.gov.sp.feiras.application.mapper;

import br.gov.sp.feiras.application.vo.FeiraVO;
import br.gov.sp.feiras.entity.Feira;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface FeiraVOMapper {

    List<FeiraVO> toFeiraVOList(List<Feira> feiras);

    FeiraVO toFeiraVO(Feira feira);

}
