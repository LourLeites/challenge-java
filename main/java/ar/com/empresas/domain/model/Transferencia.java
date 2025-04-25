package ar.com.empresas.domain.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "TRANSFERENCIAS", schema = "dbo")
public class Transferencia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private BigDecimal importe;
    private String cuentaDebito;
    private String cuentaCredito;
    private LocalDate fechaTransferencia;
    @ManyToOne
    @JoinColumn(name = "IDEmpresa", referencedColumnName = "id")
    private Empresa empresa;
}
