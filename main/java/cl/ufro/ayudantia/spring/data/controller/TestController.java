/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.ufro.ayudantia.spring.data.controller;

import cl.ufro.ayudantia.spring.data.modelo.Ciudad;
import cl.ufro.ayudantia.spring.data.modelo.Ciudadano;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import cl.ufro.ayudantia.spring.data.dao.CiudadDAO;
import cl.ufro.ayudantia.spring.data.dao.CiudadanoDAO;


@RestController
public class TestController {
    
    @Autowired
    private CiudadanoDAO ciudadanoDAO;
    
    @Autowired
    private CiudadDAO ciudadDAO;
    
    @GetMapping("ciudad")
    public Ciudad crearCiudad(
            @RequestParam("nombre") String nombre
    ){
        Ciudad ciudad = new Ciudad();
        ciudad.setNombre(nombre);
        this.ciudadDAO.save(ciudad);
        return ciudad;
    }
    
    @GetMapping("test")    
    public Ciudadano test(
            @RequestParam("nombres") String nombres,
            @RequestParam("apellidos") String apellidos,
            @RequestParam("ciudad") Long idCiudad
    ){
        
        Ciudadano ciudadano = new Ciudadano();
        Ciudad ciudad = this.ciudadDAO.findById(idCiudad).get();
        
        ciudadano.setNombres(nombres);
        ciudadano.setApellidos(apellidos);
        ciudadano.setCiudad(ciudad);
        
        this.ciudadanoDAO.save(ciudadano);
        return ciudadano;
    }
    
    
}
