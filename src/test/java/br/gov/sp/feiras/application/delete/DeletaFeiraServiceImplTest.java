package br.gov.sp.feiras.application.delete;

import br.gov.sp.feiras.application.exception.FeiraNotFound;
import br.gov.sp.feiras.entity.repository.FeiraRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class DeletaFeiraServiceImplTest {

    @Mock
    private FeiraRepository repository;

    private DeletaFeiraServiceImpl service;

    @BeforeEach
    void setUp() {
        service = new DeletaFeiraServiceImpl(repository);
    }

    @Test
    void testDeletarComFeiraExistente() {
        Mockito.when(repository.existsById(ArgumentMatchers.anyLong())).thenReturn(true);

        service.deletarFeira(1L);

        Mockito.verify(repository).deleteById(ArgumentMatchers.anyLong());
    }

    @Test
    void testTentarDeletarComFeiraInexistente() {
        Mockito.when(repository.existsById(ArgumentMatchers.anyLong())).thenReturn(false);

        assertThrows(FeiraNotFound.class, () -> service.deletarFeira(1L), "Deveria Lançar FeiraNotFound");

        Mockito.verify(repository, Mockito.times(0)).deleteById(ArgumentMatchers.anyLong());
    }

}