/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package archivosPeliculas;

/**
 *
 * @author karim
 */
import java.io.*;

import java.util.Scanner;
import java.util.NoSuchElementException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ArchivoSerializable {

    private ObjectOutputStream salida; //Envia datos a un archivo
    private ObjectInputStream entrada;

    //Permite especificar nombre del archivo
    public void abrirArchivoEscritura() {
        try {
            salida = new ObjectOutputStream(new FileOutputStream("C:\\Users\\karim\\Desktop\\UCAB\\PROGRAM 3\\PRACTICAS\\Lab 11 Interfaz grafica\\LabXIUI_KarimSahili\\src\\main\\java\\archivosPeliculas\\peliculasser.txt"));
        } catch (IOException exception) {
            System.err.println("Error al abrir el archivo");
            System.exit(1);
        }
    }

    public void agregarRegistros(PeliculasSerializable peliculas) {

        try {

            for (PeliculaSerializable registro : peliculas.getPeliculas()) {
                salida.writeObject(registro);
            }

        } catch (IOException ex) {
            System.err.println("Error al escribir en archivo");
            return;
        }

    }

    public void cerrarArchivo() {
        try {
            if (salida != null) {
                salida.close();
            }
        } catch (IOException ex) {
            System.err.println("Error al cerrar archivo");
            System.exit(1);
        }
    }

    public void abrirArchivoLectura() {
        try {
            entrada = new ObjectInputStream(new FileInputStream("C:\\Users\\karim\\Desktop\\UCAB\\PROGRAM 3\\PRACTICAS\\Lab 11 Interfaz grafica\\LabXIUI_KarimSahili\\src\\main\\java\\archivosPeliculas\\peliculasser.txt"));
        } catch (IOException ex) {
            System.err.println("Error al abrir archivo");
        }

    }

    public void leerRegistros() {
        PeliculaSerializable registro;

        System.out.printf("%-15s%-15s%-18s%-15s%-15s\n", "IDENTIFICADOR", "NOMBRE", "ACTOR PRINCIPAL", "GENERO", "DURACION");

        try {

            while (true) {

                registro = (PeliculaSerializable) entrada.readObject();
                System.out.printf("%-15s%-15s%-18s%-15s%-15s\n", registro.getIdentificador(), registro.getNombre(), registro.getActorPrincipal(), registro.getGenero(), registro.getDuracion());
            }
        } catch (EOFException endOfFileException) {
            return;//Se llego al fin de archivo
        } catch (ClassNotFoundException ex) {
            System.err.println("No se pudo crear el objeto");
        } catch (IOException ioException) {
            System.err.println("Error al leer archivo");

        }
    }

    //funcion que ingresa los registros de un archivo a PeliculasSerializable (lista de peliculas)
    public PeliculasSerializable ingresarRegistrosArreglo() {
        PeliculaSerializable registro;
        PeliculasSerializable peliculas = new PeliculasSerializable();

        try {

            while (true) {

                registro = (PeliculaSerializable) entrada.readObject();
                peliculas.ingresarPelicula(registro);
            }
        } catch (EOFException endOfFileException) {
            return peliculas;
        } catch (ClassNotFoundException ex) {
            System.err.println("No se pudo crear el objeto");
        } catch (IOException ioException) {
            System.err.println("Error al leer archivo");

        }
        return peliculas;
    }

    //consulto una pelicula de un archivo por su identificador
    public void consultarRegistro(int identificador) {
        PeliculasSerializable peliculas = ingresarRegistrosArreglo(); //ingreso los registros al arreglo
        peliculas.consultarPelicula(identificador);
    }

    //elimina una pelicula de un archivo por su identificador
    public void eliminarRegistro(int identificador) {
        PeliculasSerializable peliculas = ingresarRegistrosArreglo();
        peliculas.eliminarPelicula(identificador);

        abrirArchivoEscritura(); //borro los datos en el archivo
        agregarRegistros(peliculas); //reescribo el archivo 
    }

}
