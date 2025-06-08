package pe.colegiodeabogados.puno.Icap.dtos;

import jakarta.validation.constraints.NotNull;

public class TrabajadorDTO {
    private Long idTrabajador;

    @NotNull
    private String tNombre;
    @NotNull
    private String tCorreo;
    @NotNull
    private String tUsername;
    @NotNull
    private String tRol; // o enum si lo necesitas como objeto
}
