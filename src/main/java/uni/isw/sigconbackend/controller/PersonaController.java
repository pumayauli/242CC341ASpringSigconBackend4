package uni.isw.sigconbackend.controller;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import uni.isw.sigconbackend.model.Persona;
import uni.isw.sigconbackend.service.PersonaService;

@RestController
@RequestMapping(path="api/v1/persona")
public class PersonaController {
    private final Logger logger=LoggerFactory.getLogger(this.getClass());
    @Autowired
    private PersonaService personaService;
    
    @RequestMapping(value="listar",method=RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Persona>> getPersonas(){
        List<Persona> listaPersonas=null;
        try{
            listaPersonas=personaService.getPersonas();
        }catch(Exception e){
            logger.error("Error inesperado",e);
            return new ResponseEntity<>(null,HttpStatus.OK);
        }
        return new ResponseEntity<>(listaPersonas,HttpStatus.OK);
    }
    
}
