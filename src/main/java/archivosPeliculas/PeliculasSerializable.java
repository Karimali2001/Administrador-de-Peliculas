/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package archivosPeliculas;

import java.util.ArrayList;

/**
 *
 * @author karim
 */
public class PeliculasSerializable {

    //atributos
    ArrayList<PeliculaSerializable> peliculas;

    //constructores
    public PeliculasSerializable() {
        peliculas = new ArrayList();
    }

    //set/get
    public ArrayList<PeliculaSerializable> getPeliculas() {
        return peliculas;
    }

    public void setPeliculas(ArrayList<PeliculaSerializable> peliculas) {
        this.peliculas = peliculas;
    }

    //otros metodos
    public boolean ingresarPelicula(PeliculaSerializable pelicula) {
        for (PeliculaSerializable peli : peliculas) {
            if (peli.getIdentificador() == pelicula.getIdentificador()) {
                System.out.println("Ya existe una pelicula con ese identificador");
                return false;
            }
        }

        peliculas.add(pelicula);
        return true;
    }

    //regresa la posicion el arraylist si es cierto
    public int consultarPelicula(int identificador) {
        int i = 0;
        for (PeliculaSerializable pelicula : peliculas) {
            if (pelicula.getIdentificador() == identificador) {
                System.out.println(pelicula.toString());
                return i;
            }
            i++;
        }

        System.out.println("No existe una pelicula con ese identificador");
        return -1;
    }

    public boolean eliminarPelicula(int identificador) {
        for (PeliculaSerializable pelicula : peliculas) {
            if (pelicula.getIdentificador() == identificador) {
                peliculas.remove(pelicula);
                System.out.println("Pelicula exitosamente eliminada");
                return true;
            }
        }

        System.out.println("No se puede eliminar una pelicula que no existe en la coleccion");
        return false;

    }

    public void imprimirFor() {
        System.out.println("Coleccion de peliculas con For: ");
        for (PeliculaSerializable pelicula : peliculas) {
            System.out.println(pelicula.toString());
        }
    }

}
