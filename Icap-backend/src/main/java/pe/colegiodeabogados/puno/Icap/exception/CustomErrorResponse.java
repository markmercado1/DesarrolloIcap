package pe.colegiodeabogados.puno.Icap.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CustomErrorResponse {
    private int statusCode;
    private LocalDateTime datetime;
    private String message;
    private String details;

    // Constructor adicional personalizado
    public CustomErrorResponse(LocalDateTime datetime, String message, String details) {
        this.statusCode = 400; // puedes cambiar el valor por defecto si lo necesitas
        this.datetime = datetime;
        this.message = message;
        this.details = details;
    }
}
