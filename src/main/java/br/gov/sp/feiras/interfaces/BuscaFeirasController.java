package br.gov.sp.feiras.interfaces;

import br.gov.sp.feiras.interfaces.dto.ParamBuscaFeiras;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class BuscaFeirasController {

    @GetMapping("/feiras")
    public ResponseEntity<Object> buscarFeiras(@Valid @ModelAttribute() ParamBuscaFeiras param) {
        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).build();
    }

}
