package pe.colegiodeabogados.puno.Icap.dtos;

import jakarta.validation.constraints.NotNull;

public class TipoColegiadoDTO {
    private Long idTipoColegiado;

    @NotNull
    private String tcDescripcion;
}
