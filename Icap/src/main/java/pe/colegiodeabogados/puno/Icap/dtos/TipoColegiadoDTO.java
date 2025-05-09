package pe.colegiodeabogados.puno.Icap.dtos;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TipoColegiadoDTO {
    private Long idTipoColegiado;

    @NotNull
    @Size(min=4,max = 60,message = "tiene que estar entre 4 y 60 caracteres")
    private String tcDescripcion;
}
