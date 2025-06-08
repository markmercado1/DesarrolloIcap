package pe.colegiodeabogados.puno.Icap.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data

@Table(name = "trabajadores")
public class Trabajador {

    public enum Rol{ADMIN,OTRO}
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTrabajador;

    @Column(nullable = false)
    private String tUsername;

    @Column(nullable = false)
    private String tPassword;

    @Column(nullable = false, length = 100)
    private String tCorreo;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Rol tRol;

    @Column(nullable = false)
    private String tNombre;

}