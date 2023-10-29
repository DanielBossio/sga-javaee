/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dev.bossiodjc.sga.cliente;

import dev.bossiodjc.sga.domain.Persona;
import dev.bossiodjc.sga.servicio.PersonaServiceRemote;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author bossi
 */
public class ClientePersonaService {
    public static void main(String[] args){
        System.out.println("Inicializando llamada al EJB");
        try {
            Context jndi = new InitialContext();
            PersonaServiceRemote servicio = (PersonaServiceRemote)
                    jndi.lookup("java:global/SGA-JavaEE/PersonaServiceImpl"
                            + "!dev.bossiodjc.sga.servicio.PersonaServiceRemote");
            List<Persona> personas = servicio.listar();
            personas.forEach((Persona p) -> {
                System.out.println(p.toString());
            });
            System.out.println("Llamada al EJB terminada");
        } catch (NamingException ex) {
            Logger.getLogger(ClientePersonaService.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
    }
}
