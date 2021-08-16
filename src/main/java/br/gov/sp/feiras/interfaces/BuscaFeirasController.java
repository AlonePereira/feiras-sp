package br.gov.sp.feiras.interfaces;

import br.gov.sp.feiras.application.busca.BuscaFeiraService;
import br.gov.sp.feiras.interfaces.dto.ParamBuscaFeiras;
import br.gov.sp.feiras.interfaces.mapper.FeiraDTOMapper;
import br.gov.sp.feiras.interfaces.mapper.ParamBuscaFeirasMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class BuscaFeirasController {

    private static final Logger LOG = LoggerFactory.getLogger(BuscaFeirasController.class);

    private final BuscaFeiraService service;
    private final FeiraDTOMapper feiraDTOMapper;
    private final ParamBuscaFeirasMapper paramBuscaFeirasMapper;

    public BuscaFeirasController(BuscaFeiraService service, FeiraDTOMapper feiraDTOMapper,
                                 ParamBuscaFeirasMapper paramBuscaFeirasMapper) {
        this.service = service;
        this.feiraDTOMapper = feiraDTOMapper;
        this.paramBuscaFeirasMapper = paramBuscaFeirasMapper;
    }

    @GetMapping("/feiras")
    public ResponseEntity<Object> buscarFeiras(@Valid @ModelAttribute ParamBuscaFeiras param) {

        var feirasVOList = service.buscarFeiras(paramBuscaFeirasMapper.toBuscaFeirasVO(param));

        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON)
                .body(feiraDTOMapper.toFeiraDTORSList(feirasVOList));
    }

}
