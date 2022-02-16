package mx.com.gm.HolaSpring.Servicio;

import mx.com.gm.HolaSpring.Domain.Persona;

import java.util.List;

public interface PersonaService {

    List<Persona> listarPersonas();

    void guardar(Persona persona);

    void eliminar(Persona persona);

    Persona encontrarPersona(Persona persona);
}
