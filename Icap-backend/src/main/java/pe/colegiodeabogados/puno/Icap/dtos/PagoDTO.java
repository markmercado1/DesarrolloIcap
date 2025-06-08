package pe.colegiodeabogados.puno.Icap.dtos;


import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class PagoDTO {

    private Long idPago;

    @NotNull(message = "La fecha de pago no puede ser nulo")
    private LocalDate pFechaPago;

    @NotNull(message = "El monto no puede ser nulo")
    @DecimalMin(value = "0.01", inclusive = true, message = "El monto debe ser mayor a 0")
    private BigDecimal pMonto;


    @NotNull(message = "El medio de pago no puede ser nulo")
    @Size(min = 2, max = 40, message = "El medio de pago  debe tener entre 2 y 40 caracteres")
    private String pMedioPago;

    @NotNull(message = "El agremiado no puede ser nulo")
    private AgremiadoDTO agremiado;

    public record PagoCADto(
            Long idPago,

            @NotNull(message = "La fecha de pago no puede ser nulo")
            LocalDate pFechaPago,

            @NotNull(message = "El monto no puede ser nulo")

            @DecimalMin(value = "0.01", inclusive = true, message = "El monto debe ser mayor a 0")
            BigDecimal pMonto,


            @NotNull(message = "El medio de pago no puede ser nulo")
            @Size(min = 2, max = 40, message = "El medio de pago  debe tener entre 2 y 40 caracteres")
            String pMedioPago,

            @NotNull(message = "El agremiado no puede ser nulo")
            Long agremiado

    ) {


    }

}