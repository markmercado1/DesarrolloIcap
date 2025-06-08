package pe.colegiodeabogados.puno.Icap.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user_abogados")
public class UserAgremiado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUsuarioAbogado;

    private String us_password;
    private String ubUsername;
    private LocalDate ubFechaCreacion;

    @ManyToOne
    @JoinColumn(name = "id_agremiado")
    private Agremiado agremiado;

    @ManyToOne
    @JoinColumn(name = "id_trabajador")
    private Trabajador trabajador;

}