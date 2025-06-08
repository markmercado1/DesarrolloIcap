package pe.colegiodeabogados.puno.Icap.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tipo_colegiado")
public class TipoColegiado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTipoColegiado;

    @Column(nullable = false, length = 100)
    private String tcDescripcion;

}
