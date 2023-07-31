/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ArchivosUsuario;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author karim
 */
public class ArchivoSerializable {
        private ObjectOutputStream salida; //Envia datos a un archivo
    private ObjectInputStream entrada;

    //Permite especificar nombre del archivo
    public void abrirArchivoEscritura() {
        try {
            salida = new ObjectOutputStream(new FileOutputStream("C:\\Users\\karim\\Desktop\\UCAB\\PROGRAM 3\\PRACTICAS\\Lab 11 Interfaz grafica\\LabXIUI_KarimSahili\\src\\main\\java\\ArchivosUsuario\\usuarios.txt"));
        } catch (IOException exception) {
            System.err.println("Error al abrir el archivo");
            System.exit(1);
        }
    }

    public void agregarRegistros(UsuariosSer usuarios) {

        try {

            for (UsuarioSer registro : usuarios.getUsuarios()) {
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
            entrada = new ObjectInputStream(new FileInputStream("C:\\Users\\karim\\Desktop\\UCAB\\PROGRAM 3\\PRACTICAS\\Lab 11 Interfaz grafica\\LabXIUI_KarimSahili\\src\\main\\java\\ArchivosUsuario\\usuarios.txt"));
        } catch (IOException ex) {
            System.err.println("Error al abrir archivo");
        }

    }

    public void leerRegistros() {
        UsuarioSer registro;

        System.out.printf("%-15s%-15s\n", "USUARIO", "CLAVE");

        try {

            while (true) {

                registro = (UsuarioSer) entrada.readObject();
                System.out.printf("%-15s%-15s\n", registro.getUsuario(), registro.getClave());
            }
        } catch (EOFException endOfFileException) {
            return;//Se llego al fin de archivo
        } catch (ClassNotFoundException ex) {
            System.err.println("No se pudo crear el objeto");
        } catch (IOException ioException) {
            System.err.println("Error al leer archivo");

        }
    }

    //funcion que ingresa los registros de un archivo a lista de usuarios
    public UsuariosSer ingresarRegistrosArreglo() {
        UsuarioSer registro;
        UsuariosSer usuarios = new UsuariosSer();

        try {

            while (true) {

                registro = (UsuarioSer) entrada.readObject();
                usuarios.ingresarUsuario(registro);
            }
        } catch (EOFException endOfFileException) {
            return usuarios;
        } catch (ClassNotFoundException ex) {
            System.err.println("No se pudo crear el objeto");
        } catch (IOException ioException) {
            System.err.println("Error al leer archivo");

        }
        return usuarios;
    }

//    //consulto una pelicula de un archivo por su identificador
//    public void consultarRegistro(int identificador) {
//        UsuariosSer usuarios = ingresarRegistrosArreglo(); //ingreso los registros al arreglo
//        usuarios.consultarUsuario(identificador);
//    }
}
