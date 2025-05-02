package pe.colegiodeabogados.puno.Icap.model;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.LocalDate;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
@Table(name = "agremiado")
public class Agremiado {
    public enum Genero { M, F, O }

    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_agremiado")

    private Long idAgremiado;

    @Column( nullable = false, length = 15)
    private String dni;

    @Column(nullable = false, length = 100)
    private String aNombres;

    @Column(nullable = false, length = 30)
    private String aApellidoPaterno;

    @Column(nullable = false, length = 30)
    private String aApellidoMaterno;

    @Column(nullable = false, length = 100)
    private String aDomiciloReal;

    @Column(nullable = false, length = 30)
    private String aCelular;

    @Column(nullable = false, length = 50)
    private String aCorreo;

    @Column(nullable = false, length = 100)
    private String aLugarNacimiento;

    @Column(nullable = false)
    private LocalDate aFechaIncorporacion;



    @Column(nullable = false, length = 10)
    @Enumerated(EnumType.STRING)
    private Genero genero;

    @Column(nullable = false)
    private LocalDate aFechaNacimiento;

    @Column(nullable = false, length = 100)
    private String aDomiciloProcesal;

    @Column(nullable = false, length = 50)
    private String aCiudad;

    @Column(nullable = false)
    private LocalDate aHabilHasta;
    @ManyToOne
    @JoinColumn(name = "id_tipo_colegiado")
    private TipoColegiado tipoColegiado;

    @ManyToOne
    @JoinColumn(name = "id_estado_colegiado")
    private EstadoColegiado estadoColegiado;

    @ManyToOne
    @JoinColumn(name = "id_trabajador")
    private Trabajador trabajador;




}
