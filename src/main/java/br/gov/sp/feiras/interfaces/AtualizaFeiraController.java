package br.gov.sp.feiras.interfaces;

import br.gov.sp.feiras.application.atualiza.AtualizaFeiraService;
import br.gov.sp.feiras.interfaces.dto.FeiraDTO;
import br.gov.sp.feiras.interfaces.mapper.FeiraDTOMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class AtualizaFeiraController {

    private static final Logger LOG = LoggerFactory.getLogger(AtualizaFeiraController.class);

    private final AtualizaFeiraService service;
    private final FeiraDTOMapper mapper;

    public AtualizaFeiraController(AtualizaFeiraService service, FeiraDTOMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }


    @PutMapping("/feiras/{id}")
    public ResponseEntity<Object> atualizarFeira(@PathVariable Long id, @Valid @RequestBody FeiraDTO feira) {
        LOG.info("Inicio do processo de atualização da Feira com ID {}", id);

        var feiraVO = service.atualizarFeira(mapper.toFeiraVO(id, feira));

        LOG.info("Fim do processo de atualização da Feira com ID {}", id);
        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(mapper.toFeiraDTORS(feiraVO));
    }

}
