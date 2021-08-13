package br.gov.sp.feiras.interfaces;

import br.gov.sp.feiras.interfaces.dto.FeiraDTO;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class AtualizaFeiraController {

    @PutMapping("/feira/{id}")
    public ResponseEntity<Object> atualizarFeira(@PathVariable Long id, @Valid @RequestBody FeiraDTO feira) {

        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).build();
    }

}
