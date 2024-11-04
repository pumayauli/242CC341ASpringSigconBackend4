package uni.isw.sigconbackend.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uni.isw.sigconbackend.model.Persona;
import uni.isw.sigconbackend.repository.PersonaRepository;

@Service
public class PersonaService {
    @Autowired
    PersonaRepository personaRepository;
    
    public List<Persona> getPersonas(){
        return personaRepository.findAll();
    }
}
