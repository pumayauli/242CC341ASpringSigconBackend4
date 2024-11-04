package uni.isw.sigconbackend.model;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.sql.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="persona")
public class Persona {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)    
    @Column(name="id_persona")
    private Long IdPersona;    
    @Column(name="apellido_paterno")
    private String ApellidoPaterno;    
    @Column(name="apellido_materno")
    private String ApellidoMaterno;    
    @Column(name="nombres")
    private String Nombres;    
    @Column(name="fecha_nacimiento")
    private Date FechaNacimiento;  
    @Column(name="id_tipo_documento")
    private Integer IdTipoDocumento;    
    @Column(name="ndocumento")
    private String NDocumento;    
    @Column(name="direccion")
    private String Direccion;    
    @Column(name="idubigeo")
    private String IdUbigeo;
}
