package br.gov.sp.feiras.interfaces;

import br.gov.sp.feiras.interfaces.dto.FeiraDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CriaFeiraController {

    @PostMapping("/feira")
    public ResponseEntity<Object> criarFeira(@RequestBody FeiraDTO feiraDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).contentType(MediaType.APPLICATION_JSON).build();
    }

}
