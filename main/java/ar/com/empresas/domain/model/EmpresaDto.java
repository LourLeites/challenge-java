package ar.com.empresas.domain.model;

import lombok.Data;

import java.time.LocalDate;

@Data
public class EmpresaDto {
    private String nombre;
    private Integer CUIT;
    private LocalDate fecha;
}
