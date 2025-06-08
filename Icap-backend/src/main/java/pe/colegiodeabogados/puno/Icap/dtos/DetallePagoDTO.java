package pe.colegiodeabogados.puno.Icap.dtos;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pe.colegiodeabogados.puno.Icap.model.Pago;

import java.math.BigDecimal;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class DetallePagoDTO {
    private Long idDetallePago;

    @NotNull(message = "El concepto no puede ser nulo")
    @Size(min = 4, max = 200, message = "El concepto debe tener entre 2 y 200 caracteres")
    private String dpConcepto;

    @NotNull(message = "El monto no puede ser nulo")
    @DecimalMin(value = "0.01", inclusive = true, message = "El monto debe ser mayor a 0")
    private BigDecimal dpMonto; // CAMBIADO DE pMonto → dpMonto

    @NotNull(message = "El periodo no puede ser nulo")
    @Size(min = 4, max = 200, message = "El periodo debe tener entre 2 y 200 caracteres")
    private String dpPeriodo;

    @NotNull(message = "El pago no puede ser nulo")
    private PagoDTO pago;

    public record DetallePagoCADTo(
            Long idDetallePago,
            @NotNull(message = "El concepto no puede ser nulo")
            @Size(min = 4, max = 200, message = "El concepto debe tener entre 2 y 200 caracteres")
            String dpConcepto,
            @NotNull(message = "El monto no puede ser nulo")
            @DecimalMin(value = "0.01", inclusive = true, message = "El monto debe ser mayor a 0")
            BigDecimal dpMonto, // TAMBIÉN CORREGIDO
            @NotNull(message = "El periodo no puede ser nulo")
            @Size(min = 4, max = 200, message = "El periodo debe tener entre 2 y 200 caracteres")
            String dpPeriodo,
            @NotNull(message = "El pago no puede ser nulo")
            Long pago
    ) {}

}
