package ar.com.empresas.infraestructure.controller;

import ar.com.empresas.application.service.EmpresaService;
import ar.com.empresas.domain.model.Empresa;
import ar.com.empresas.exception.StandardErrorRestResponse;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import ar.com.empresas.domain.model.EmpresaDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/v1/challenge/java/empresas")
@RequiredArgsConstructor
public class EmpresaController {

    @Autowired
    private EmpresaService empresaService;
    // private final TransferenciaService transferenciaService;

    @GetMapping("/transferencias")
    @ApiOperation(value = "Endpoint que busca las empresas que realizaron transferencias el último mes")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success Operation"),
            @ApiResponse(code = 400, message = "Bad Request", response = StandardErrorRestResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = StandardErrorRestResponse.class),
            @ApiResponse(code = 503, message = "Service Unavailable", response = StandardErrorRestResponse.class)
    })
    public List<Empresa> getEmpresasConTransferenciasUltimoMes() {
        return empresaService.obtenerEmpresasConTransferenciasUltimoMes();
    }

    @GetMapping("/adhesion")
    @ApiOperation(value = "Endpoint que busca las empresas que se adhirieron el último mes")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success Operation"),
            @ApiResponse(code = 400, message = "Bad Request", response = StandardErrorRestResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = StandardErrorRestResponse.class),
            @ApiResponse(code = 503, message = "Service Unavailable", response = StandardErrorRestResponse.class)
    })
    public List<Empresa> getEmpresasAdheridasUltimoMes() {
        return empresaService.obtenerEmpresasAdheridasUltimoMes();
    }

    @PostMapping()
    @ApiOperation(value = "Endpoint que adhiere las empresas a la base de datos")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success Operation"),
            @ApiResponse(code = 400, message = "Bad Request", response = StandardErrorRestResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = StandardErrorRestResponse.class),
            @ApiResponse(code = 503, message = "Service Unavailable", response = StandardErrorRestResponse.class)
    })
    public ResponseEntity<Void> postEmpresasAdheridas(
            @RequestBody EmpresaDto empresadto) {

        empresaService.guardarEmpresas(empresadto);
        return ResponseEntity.ok().build();
    }
}

