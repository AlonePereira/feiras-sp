package br.gov.sp.feiras.interfaces;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeletaFeiraController {

    @DeleteMapping("/feira/{id}")
    public ResponseEntity<Object> deletarFeira(@PathVariable Long id) {
        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).build();
    }

}
