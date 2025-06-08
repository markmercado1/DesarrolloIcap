package pe.colegiodeabogados.puno.Icap.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "icap_accesos")
public class Acceso {
    @Id
    @Column(name = "id_acceso")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAcceso;
    @Column(name = "nombre", nullable = false, length = 60)
    private String nombre;
    @Column(name = "url", nullable = false, length = 100)
    private String url;
    @Column(name = "icono", nullable = false, length = 60)
    private String icono;
}