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

@Table(name = "pagos")
public class Pago {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPago;

    private LocalDate pFechaPago;
    private BigDecimal pMonto;
    private String pMedioPago;
    @ManyToOne
    @JoinColumn(name = "id_agremiado", referencedColumnName = "id_agremiado")
    private Agremiado agremiado;


}