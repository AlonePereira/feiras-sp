package br.gov.sp.feiras.interfaces;

import br.gov.sp.feiras.application.cria.CriaFeiraService;
import br.gov.sp.feiras.interfaces.dto.FeiraDTO;
import br.gov.sp.feiras.interfaces.mapper.FeiraDTOMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class CriaFeiraController {

    private static final Logger LOG = LoggerFactory.getLogger(CriaFeiraController.class);

    private final CriaFeiraService service;
    private final FeiraDTOMapper mapper;

    public CriaFeiraController(CriaFeiraService service, FeiraDTOMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @PostMapping("/feira")
    public ResponseEntity<Object> criarFeira(@Valid @RequestBody FeiraDTO feiraDTO) {
        LOG.info("Inicio do processo de criando Nova Feira");

        var feiraVO = service.criarFeira(mapper.toFeiraVO(null, feiraDTO));

        LOG.info("Fim do Processo de criação de Feira");

        return ResponseEntity.status(HttpStatus.CREATED).contentType(MediaType.APPLICATION_JSON)
                .body(mapper.toFeiraDTORS(feiraVO));
    }

}
