package pe.colegiodeabogados.puno.Icap.dtos;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AgremiadoDTO {
    private Long idAgremiado;

    @NotNull
    private String dni;
    @NotNull
    private String aNombres;
    @NotNull
    private String aApellidoPaterno;
    @NotNull
    private String aApellidoMaterno;
    @NotNull
    private String aCelular;
    @NotNull
    private String aCorreo;
    @NotNull
    private String genero;
    @NotNull
    private String aCiudad;
    @NotNull
    private LocalDate aFechaNacimiento;
    @NotNull
    private LocalDate aFechaIncorporacion;

    // Aquí usas los DTOs en lugar de solo los strings
    @NotNull
    private TipoColegiadoDTO tipoColegiado;

    @NotNull
    private EstadoColegiadoDTO estadoColegiado;

    // Este lo puedes incluir si vas a mostrar info del trabajador
    private TrabajadorDTO trabajador;
}
