package pe.colegiodeabogados.puno.Icap.model;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.EqualsAndHashCode;

@Embeddable
@EqualsAndHashCode
public class AccesoRolPK {
    @ManyToOne
    @JoinColumn(name = "acceso_id")
    private Acceso acceso;
    @ManyToOne
    @JoinColumn(name = "rol_id")
    private Rol rol;
}