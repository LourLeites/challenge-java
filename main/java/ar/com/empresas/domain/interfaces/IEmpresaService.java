package ar.com.empresas.domain.interfaces;

import ar.com.empresas.domain.model.Empresa;
import ar.com.empresas.domain.model.EmpresaDto;

import java.util.List;

public interface IEmpresaService {
    List<Empresa> obtenerEmpresasConTransferenciasUltimoMes();

    List<Empresa> obtenerEmpresasAdheridasUltimoMes();

    void guardarEmpresas(EmpresaDto empresaDto);
}
