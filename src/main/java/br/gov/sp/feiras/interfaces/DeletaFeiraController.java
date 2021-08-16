package br.gov.sp.feiras.interfaces;

import br.gov.sp.feiras.application.delete.DeletaFeiraService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeletaFeiraController {

    private static final Logger LOG = LoggerFactory.getLogger(DeletaFeiraController.class);

    private final DeletaFeiraService service;

    public DeletaFeiraController(DeletaFeiraService service) {
        this.service = service;
    }

    @DeleteMapping("/feiras/{id}")
    public ResponseEntity<Object> deletarFeira(@PathVariable Long id) {
        LOG.info("Inicio do Processo de Exclusão de Feira pelo ID {}", id);

        service.deletarFeira(id);

        LOG.info("Fim do Processo de Exclusão de Feira pelo ID {}", id);

        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).build();
    }

}
