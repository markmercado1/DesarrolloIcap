package pe.colegiodeabogados.puno.Icap.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data

@Table(name = "evento")
public class Evento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEvento; // Cambiado porque e_titulo no puede ser PK si no es único

    private String eTitulo;
    private String eDescripcion;
    private LocalDate eFechaFin;
    private LocalDate eFechaInicio;
    private String eEstado;
    private LocalDate eFechaCreacion;

    @Lob
    private byte[] eImagen;

    @Lob
    private byte[] eDocumento;

    @ManyToOne
    @JoinColumn(name = "id_trabajador")
    private Trabajador trabajador;



}