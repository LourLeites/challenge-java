package ar.com.empresas.domain.repository;
import ar.com.empresas.domain.model.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface IEmpresaRepository extends JpaRepository<Empresa, String> {
    @Query("SELECT DISTINCT e FROM Empresa e JOIN e.transferencias t WHERE t.fechaTransferencia >= :ultimoMes")
    List<Empresa> findEmpresasConTransferenciasUltimoMes(@Param("ultimoMes") LocalDate ultimoMes);

    @Query("SELECT e FROM Empresa e WHERE e.fechaAdhesion >= :ultimoMes")
    List<Empresa> findEmpresasAdheridasUltimoMes(@Param("ultimoMes") LocalDate ultimoMes);

}


