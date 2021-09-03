package com.mercadolibre.xmen.adn.adn.Controller;

import javax.websocket.server.PathParam;

import com.mercadolibre.xmen.adn.adn.Model.Respuesta;
import com.mercadolibre.xmen.adn.adn.Service.MutantService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MutantController {

    @Autowired
    MutantService mutantService;
    
    @PostMapping("/mutant/")
    public ResponseEntity<Respuesta> getinAdn(@RequestBody Respuesta respuesta){
        return mutantService.getInRespuesta(respuesta);
    }        
    
}
