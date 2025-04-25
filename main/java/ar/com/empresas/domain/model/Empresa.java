package ar.com.empresas.domain.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Table(name = "EMPRESAS", schema = "dbo")
public class Empresa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String razonSocial;
    private Integer CUIT;
    private LocalDate fechaAdhesion;
    @OneToMany(mappedBy = "empresa")
    private List<Transferencia> transferencias;
}

