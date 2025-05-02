package pe.colegiodeabogados.puno.Icap.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data

@Table(name = "estado_colegiado")
public class EstadoColegiado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEstadoColegiado;

    @Column(nullable = false, length = 100)
    private String ecDescripcion;

}