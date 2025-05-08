package pe.colegiodeabogados.puno.Icap.dtos;

import jakarta.validation.constraints.NotNull;

public class EstadoColegiadoDTO {
    private Long idEstadoColegiado;

    @NotNull
    private String ecDescripcion;
}
