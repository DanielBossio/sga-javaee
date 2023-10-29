/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dev.bossiodjc.sga.servicio;

import dev.bossiodjc.sga.domain.Persona;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author bossi
 */
@Remote
public interface PersonaServiceRemote {
    
    public List<Persona> listar();
    
    public Persona findById(int id);
    
    public Persona findByEmail(String email);
    
    public void registrar(Persona p);
    
    public void modificar(Persona p);
    
    public void eliminar(Persona p);
}
