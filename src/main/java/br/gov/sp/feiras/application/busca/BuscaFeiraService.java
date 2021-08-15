package br.gov.sp.feiras.application.busca;

import br.gov.sp.feiras.application.vo.BuscaFeirasVO;
import br.gov.sp.feiras.application.vo.FeiraVO;

import java.util.List;

public interface BuscaFeiraService {

    List<FeiraVO> buscarFeiras(BuscaFeirasVO bascaFeiras);

}
