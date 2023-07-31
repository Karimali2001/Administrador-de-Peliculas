/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
//CLASE USUARIO LA CUAL GUARDA EL USUARIO, CLAVE Y SUS PELICULAS
package ArchivosUsuario;

import java.io.Serializable;

/**
 *
 * @author karim
 */
public class UsuarioSer implements Serializable{
    //atributos
    private String usuario;
    private String clave;
    
    //constructores
    
    public UsuarioSer(String usuario, String clave){
        this.usuario = usuario;
        this.clave = clave;
    }
    
    //set/get

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }
    
    
    
    //otros metodos

    @Override
    public String toString() {
        return "UsuarioSer{" + "usuario=" + usuario + ", clave=" + clave + '}';
    }
    
    
    
    
    
}
