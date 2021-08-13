package br.gov.sp.feiras.interfaces;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AtualizaFeiraController {

    @PutMapping("/feira/{id}")
    public ResponseEntity<Object> atualizarFeira(@PathVariable Long id) {

        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).build();
    }

}
