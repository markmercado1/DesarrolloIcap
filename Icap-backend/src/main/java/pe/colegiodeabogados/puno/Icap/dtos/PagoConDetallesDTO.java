package pe.colegiodeabogados.puno.Icap.dtos;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import pe.colegiodeabogados.puno.Icap.model.DetallePago;
import pe.colegiodeabogados.puno.Icap.model.Pago;

import java.util.List;

@Data

public class PagoConDetallesDTO {
    @NotNull
    private Pago pago;

    @NotNull
    private List<DetallePago> detalles;
}
