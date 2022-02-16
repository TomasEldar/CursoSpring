package mx.com.gm.HolaSpring.DAO;

import mx.com.gm.HolaSpring.Domain.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonaDAO extends JpaRepository<Persona, Long> {
}
