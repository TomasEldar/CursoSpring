package mx.com.gm.HolaSpring.Domain;

import lombok.Data;
import org.springframework.context.annotation.Configuration;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
@Table(name = "usuario")
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUsuario;

    @NotEmpty
    @Column(name = "username")
    private String userName;

    @NotEmpty
    private String password;

    @OneToMany
    @JoinColumn(name = "id_usuario")
    private List<Rol> roles;

}
