package pe.colegiodeabogados.puno.Icap.dtos;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EventoDTO {
    private Long idEvento;

    @NotNull(message = "El título no puede ser nulo")
    @Size(max = 200, message = "El título no debe exceder 200 caracteres")
    private String eTitulo;

    @NotNull(message = "La descripción no puede ser nula")
    @Size(max = 500, message = "La descripción no debe exceder 500 caracteres")
    private String eDescripcion;

    @NotNull(message = "La fecha de inicio no puede ser nula")
    private LocalDate eFechaInicio;

    @NotNull(message = "La fecha de fin no puede ser nula")
    private LocalDate eFechaFin;

    @NotNull(message = "El estado no puede ser nulo")
    @Size(max = 50, message = "El estado no debe exceder 50 caracteres")
    private String eEstado;

    private LocalDate eFechaCreacion;

    private byte[] eImagen;
    private byte[] eDocumento;

    @NotNull(message = "El trabajador no puede ser nulo")
    private TrabajadorDTO trabajador;

    public record EventoCADTo(
            Long idEvento,

            @NotNull(message = "El título no puede ser nulo")
            @Size(max = 200, message = "El título no debe exceder 200 caracteres")
            String eTitulo,

            @NotNull(message = "La descripción no puede ser nula")
            @Size(max = 500, message = "La descripción no debe exceder 500 caracteres")
            String eDescripcion,

            @NotNull(message = "La fecha de inicio no puede ser nula")
            LocalDate eFechaInicio,

            @NotNull(message = "La fecha de fin no puede ser nula")
            LocalDate eFechaFin,

            @NotNull(message = "El estado no puede ser nulo")
            @Size(max = 50, message = "El estado no debe exceder 50 caracteres")
            String eEstado,

            LocalDate eFechaCreacion,

            byte[] eImagen,
            byte[] eDocumento,

            @NotNull(message = "El trabajador no puede ser nulo")
            Long trabajador
    ) {

    }
}
