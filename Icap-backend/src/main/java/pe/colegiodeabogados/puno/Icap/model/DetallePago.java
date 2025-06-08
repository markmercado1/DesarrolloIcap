package pe.colegiodeabogados.puno.Icap.model;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data

@Table(name = "detalle_pago")
public class DetallePago {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDetallePago;

    private String dpConcepto;
    private BigDecimal dpMonto;
    private String dpPeriodo;

    @ManyToOne
    @JoinColumn(name = "id_pago")
    private Pago pago;

}