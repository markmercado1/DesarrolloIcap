package pe.colegiodeabogados.puno.Icap.dtos;

import jakarta.validation.constraints.NotNull;

public class UsuarioDTO {
    private Long idUsuario;
    @NotNull
    private String user;
    @NotNull
    private String estado;
    private String token;

    public record CredencialesDto(String user, char[] clave) { }

    public record UsuarioCrearDto(String user, char[] clave, String rol, String estado) { }
}
