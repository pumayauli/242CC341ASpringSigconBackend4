package uni.isw.sigconbackend.controller;

import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import uni.isw.sigconbackend.model.Persona;
import uni.isw.sigconbackend.service.PersonaService;
import uni.isw.sigconbackend.utils.ErrorResponse;

@RestController
@RequestMapping(path="api/v1/persona")
public class PersonaController {
    private final Logger logger=LoggerFactory.getLogger(this.getClass());
    @Autowired
    private PersonaService personaService;    
    
    @GetMapping()
    public ResponseEntity<?> getPersonas(){
        List<Persona> listaPersonas=null;
        try{
            listaPersonas=personaService.getPersonas();
        }catch(Exception e){
            logger.error("Error inesperado",e);
            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
        if(listaPersonas.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ErrorResponse.builder().message("Personas not found").build());
        return ResponseEntity.ok(listaPersonas);
    }
    @GetMapping("/find")
    public ResponseEntity<?> findPersonaById(@RequestBody Optional<Persona> persona){        
        logger.info(">findPersonaById",persona.toString());
        try{
            persona=personaService.findPersonaById(persona.get().getIdPersona());
        }catch(Exception e){
            logger.error("Error inesperado",e);
            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
        if(persona==null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ErrorResponse.builder().message("Persona not found").build());
        return ResponseEntity.ok(persona.get());
    }
    
}
