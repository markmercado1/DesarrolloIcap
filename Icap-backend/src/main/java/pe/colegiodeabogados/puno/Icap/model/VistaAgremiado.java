    package pe.colegiodeabogados.puno.Icap.model;

    import jakarta.persistence.Entity;
    import jakarta.persistence.Id;
    import jakarta.persistence.Table;
    import lombok.Data;

    @Data
    @Entity
    @Table(name = "vista_agremiado_completo")
    public class VistaAgremiado {
        @Id
        private Long idAgremiado;
        private String dni;
        private String aNombres;
        private String aApellidoPaterno;
        private String aApellidoMaterno;
        private String aCorreo;
        private String aCelular;
        private String aDomiciloReal;
        private String aLugarNacimiento;
        private String estadoDeColegiado;
        private String tipoDeColegiado;
        private String ultimoPago;
        // getters y setters
    }