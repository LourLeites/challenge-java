package ar.com.empresas.application.service;
import ar.com.empresas.domain.interfaces.IEmpresaService;
import ar.com.empresas.domain.model.Empresa;
import ar.com.empresas.domain.model.EmpresaDto;
import ar.com.empresas.domain.repository.IEmpresaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class EmpresaService implements IEmpresaService {
    private final IEmpresaRepository empresaRepository;

    LocalDate ultimoMes = LocalDate.now().minusMonths(1);
    public List<Empresa> obtenerEmpresasConTransferenciasUltimoMes() {
        List<Empresa> empresas= empresaRepository.findEmpresasConTransferenciasUltimoMes(ultimoMes);
        if (empresas.isEmpty()) {
            throw new NoSuchElementException("No se encontraron empresas con transferencias el último mes.");
        }
        return empresas;
    }


    public List<Empresa> obtenerEmpresasAdheridasUltimoMes() {
        return empresaRepository.findEmpresasAdheridasUltimoMes(ultimoMes);
    }

    public void guardarEmpresas(EmpresaDto empresaDto) {
            Empresa empresa = new Empresa();
            empresa.setCUIT(empresaDto.getCUIT());
            empresa.setRazonSocial(empresaDto.getNombre());
            empresa.setFechaAdhesion(empresaDto.getFecha());
        empresaRepository.save(empresa);
    }
}

