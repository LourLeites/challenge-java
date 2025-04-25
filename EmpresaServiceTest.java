import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

import ar.com.empresas.application.service.EmpresaService;
import ar.com.empresas.domain.model.Empresa;
import ar.com.empresas.domain.model.EmpresaDto;
import ar.com.empresas.domain.repository.IEmpresaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class EmpresaServiceTest {

    @Mock
    private IEmpresaRepository empresaRepository;

    @InjectMocks
    private EmpresaService empresaService;

    private LocalDate ultimoMes;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        ultimoMes = LocalDate.now().minusMonths(1);
    }

    @Test
    void testObtenerEmpresasConTransferenciasUltimoMes_Success() {
        Empresa empresa = new Empresa();
        empresa.setId(1L);
        empresa.setRazonSocial("Empresa A");
        when(empresaRepository.findEmpresasConTransferenciasUltimoMes(ultimoMes))
                .thenReturn(Arrays.asList(empresa));  // Devuelve una lista con una empresa

        List<Empresa> empresas = empresaService.obtenerEmpresasConTransferenciasUltimoMes();

        //verificar el comportamiento esperado
        assertNotNull(empresas);
        assertEquals(1, empresas.size());
        assertEquals("Empresa A", empresas.get(0).getRazonSocial());
    }

    @Test
    void testObtenerEmpresasConTransferenciasUltimoMes_NoSuchElementException() {
        // simula que encuentra empresas
        when(empresaRepository.findEmpresasConTransferenciasUltimoMes(ultimoMes))
                .thenReturn(Arrays.asList());

        // verificar que se lanza la excepción
        assertThrows(NoSuchElementException.class, () -> {
            empresaService.obtenerEmpresasConTransferenciasUltimoMes();
        });
    }

    @Test
    void testObtenerEmpresasAdheridasUltimoMes() {
        // simula el comportamiento del repositorio
        Empresa empresa = new Empresa();
        empresa.setId(1L);
        empresa.setRazonSocial("Empresa A");
        when(empresaRepository.findEmpresasAdheridasUltimoMes(ultimoMes))
                .thenReturn(Arrays.asList(empresa));

        List<Empresa> empresas = empresaService.obtenerEmpresasAdheridasUltimoMes();

        assertNotNull(empresas);
        assertEquals(1, empresas.size());
        assertEquals("Empresa A", empresas.get(0).getRazonSocial());
    }

    @Test
    void testGuardarEmpresas() {

        EmpresaDto empresaDto = new EmpresaDto();
        empresaDto.setCUIT(2012345);
        empresaDto.setNombre("Empresa Nueva");
        empresaDto.setFecha(LocalDate.now());

        empresaService.guardarEmpresas(empresaDto);

       //Verificar que el método save del repositorio se llamó
        verify(empresaRepository, times(1)).save(any(Empresa.class));
    }
}
