package mx.com.gm.HolaSpring.DAO;

import mx.com.gm.HolaSpring.Domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioDAO extends JpaRepository<Usuario,Long> {
    Usuario findByUserName(String username);
}
