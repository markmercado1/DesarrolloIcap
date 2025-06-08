package pe.colegiodeabogados.puno.Icap.dtos;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pe.colegiodeabogados.puno.Icap.model.Agremiado;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AgremiadoDTO {
    private Long idAgremiado;

    @NotNull(message = "El DNI no puede ser nulo")
    @Size(min = 8, max = 15, message = "El DNI debe tener entre 8 y 15 caracteres")
    private String dni;

    @NotNull(message = "El nombre no puede ser nulo")
    @Size(max = 100, message = "El nombre no debe exceder 100 caracteres")
    private String aNombres;

    @NotNull(message = "El apellido paterno no puede ser nulo")
    @Size(max = 30, message = "El apellido paterno no debe exceder 30 caracteres")
    private String aApellidoPaterno;

    @NotNull(message = "El apellido materno no puede ser nulo")
    @Size(max = 30, message = "El apellido materno no debe exceder 30 caracteres")
    private String aApellidoMaterno;

    @NotNull(message = "El celular no puede ser nulo")
    @Size(max = 30, message = "El celular no debe exceder 30 caracteres")
    private String aCelular;

    @NotNull(message = "El correo no puede ser nulo")
    @Size(max = 50, message = "El correo no debe exceder 50 caracteres")
    private String aCorreo;

    @NotNull(message = "El género no puede ser nulo")
    @Size(max = 10, message = "El género no debe exceder 10 caracteres")
    private Agremiado.Genero genero;

    @NotNull(message = "La ciudad no puede ser nula")
    @Size(max = 50, message = "La ciudad no debe exceder 50 caracteres")
    private String aCiudad;

    @NotNull(message = "La fecha de nacimiento no puede ser nula")
    private LocalDate aFechaNacimiento;

    @NotNull(message = "La fecha de incorporación no puede ser nula")
    private LocalDate aFechaIncorporacion;

    @NotNull(message = "El tipo de colegiado no puede ser nulo")
    private TipoColegiadoDTO tipoColegiado;

    @NotNull(message = "El estado de colegiado no puede ser nulo")
    private EstadoColegiadoDTO estadoColegiado;

    @NotNull(message = "El trabajador no puede ser nulo")
    private TrabajadorDTO trabajador;

    public record AgremiadoCADto(
            Long idAgremiado,

            @NotNull(message = "El DNI no puede ser nulo")
            @Size(min = 8, max = 15, message = "El DNI debe tener entre 8 y 15 caracteres")
            String dni,

            @NotNull(message = "El nombre no puede ser nulo")
            @Size(max = 100, message = "El nombre no debe exceder 100 caracteres")
            String aNombres,

            @NotNull(message = "El apellido paterno no puede ser nulo")
            @Size(max = 30, message = "El apellido paterno no debe exceder 30 caracteres")
            String aApellidoPaterno,

            @NotNull(message = "El apellido materno no puede ser nulo")
            @Size(max = 30, message = "El apellido materno no debe exceder 30 caracteres")
            String aApellidoMaterno,

            @NotNull(message = "El celular no puede ser nulo")
            @Size(max = 30, message = "El celular no debe exceder 30 caracteres")
            String aCelular,

            @NotNull(message = "El correo no puede ser nulo")
            @Size(max = 50, message = "El correo no debe exceder 50 caracteres")
            String aCorreo,

            @NotNull(message = "El género no puede ser nulo")
            @Size(max = 10, message = "El género no debe exceder 10 caracteres")
            String genero,

            @NotNull(message = "La ciudad no puede ser nula")
            @Size(max = 50, message = "La ciudad no debe exceder 50 caracteres")
            String aCiudad,

            @NotNull(message = "La fecha de nacimiento no puede ser nula")
            LocalDate aFechaNacimiento,

            @NotNull(message = "La fecha de incorporación no puede ser nula")
            LocalDate aFechaIncorporacion,

            @NotNull(message = "El tipo de colegiado no puede ser nulo")
            Long tipoColegiado,

            @NotNull(message = "El estado de colegiado no puede ser nulo")
            Long estadoColegiado,

            @NotNull(message = "El trabajador no puede ser nulo")
            Long trabajador
    ){

    }
}
