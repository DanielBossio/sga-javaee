/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dev.bossiodjc.sga.cliente;

import dev.bossiodjc.sga.domain.Persona;
import dev.bossiodjc.sga.servicio.PersonaServiceRemote;
import java.util.Arrays;
import java.util.logging.Level;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


/**
 *
 * @author bossi
 */
public class PruebaManejoTransacciones {
    static Logger log = LogManager.getRootLogger();
    
    public static void main(String[] args) {
        try {
            Context jndi = new InitialContext();
            PersonaServiceRemote servicio = (PersonaServiceRemote) jndi.lookup
        ("java:global/SGA-JavaEE-Web/PersonaServiceImpl!dev.bossiodjc.sga.servicio.PersonaServiceRemote");
            
            log.debug("Inicio prueba transacciones PersonaService");
            
            Persona p = servicio.findById(1);
            
            log.debug(p);
            
            //Cambiar el apellido con error
            //p.setApellido("12345678901234567890123456789012345678901234567890");
            
            //Cambiar email de forma correcta
            p.setEmail("juanbos@gmail.com");
            servicio.modificar(p);
            log.debug("Objeto modificado: "+p);
            log.debug("Fin prueba transacciones PersonaService");
        } catch (NamingException ex) {
            System.err.println(Arrays.toString(ex.getStackTrace()));
        }
    }
}
