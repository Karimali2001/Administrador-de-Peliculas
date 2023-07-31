/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package archivosPeliculas;

import java.io.Serializable;

/**
 *
 * @author karim
 */
public class PeliculaSerializable implements Serializable{
        //atributos
    private int identificador;
    private String nombre;
    private String actorPrincipal;
    private String genero;
    private int duracion;
    
    //constructores
    
    public PeliculaSerializable(){
        identificador = duracion = 0;
        nombre = actorPrincipal = genero = "";
    }

    public PeliculaSerializable(int identificador, String nombre, String actorPrincipal, String genero, int duracion) {
        this.identificador = identificador;
        this.nombre = nombre;
        this.actorPrincipal = actorPrincipal;
        this.genero = genero;
        this.duracion = duracion;
    }
    
    //set/get
public int getIdentificador() {
        return identificador;
    }

    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getActorPrincipal() {
        return actorPrincipal;
    }

    public void setActorPrincipal(String actorPrincipal) {
        this.actorPrincipal = actorPrincipal;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }
    
    //otros metodos

    @Override
    public String toString() {
        return "Pelicula{" + "identificador=" + identificador + ", nombre=" + nombre + ", actorPrincipal=" + actorPrincipal + ", genero=" + genero + ", duracion=" + duracion +" minutos"+ '}';
    }
    
}
