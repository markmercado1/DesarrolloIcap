package pe.colegiodeabogados.puno.Icap.exception;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CustomErrorResponse {
    private LocalDateTime datetime;
    private String message;
    private String details;
}