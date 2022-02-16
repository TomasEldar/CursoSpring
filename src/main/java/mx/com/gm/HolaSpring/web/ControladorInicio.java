package mx.com.gm.HolaSpring.web;

import mx.com.gm.HolaSpring.Domain.Persona;
import mx.com.gm.HolaSpring.Servicio.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class ControladorInicio {

    @Autowired
    private PersonaService personaService;


    @GetMapping("/")
    public String inicio(Model model){
        var personas = personaService.listarPersonas();
        model.addAttribute("personas",personas);
        var saldoTotal = 0D;
        for(var p: personas){
            saldoTotal += p.getSaldo();
        }
        model.addAttribute("saldoTotal", saldoTotal);
        model.addAttribute("totalClientes", personas.size());
        return "Index";
    }

    @GetMapping("/agregar")
    public String agregar(Persona persona){
        return "modificar";
    }

    @PostMapping("/guardar")
    public String guardar(@Valid Persona persona, Errors errores){
        if (errores.hasErrors()){
            return "modificar";
        }
        personaService.guardar(persona);
        return "redirect:/";
    }

    @GetMapping("/editar/{idPersona}")
    public String editar(Persona persona, Model model){
        persona = personaService.encontrarPersona(persona);
        model.addAttribute("persona", persona);
        return "modificar";
    }

    @GetMapping("/eliminar/{idPersona}")
    public String eliminar(Persona persona){
        personaService.eliminar(persona);
        return "redirect:/";
    }
}
