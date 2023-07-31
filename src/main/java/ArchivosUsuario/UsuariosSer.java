/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

//CLASE LA CUAL SIRVE DE MEDIO ENTRE EL UI Y EL ARCHIVO
//LO HACE GUARDANDO LOS USUARIOS DEL ARCHIVO EN EL ARREGLO Y HACIENDO LAS MODIFICACIONES
//PARA DESPUES GUARDAR EL ARREGLO OTRA VEZ EN EL ARCHIVO
package ArchivosUsuario;

import java.util.ArrayList;

/**
 *
 * @author karim
 */
public class UsuariosSer {

    //atributos
    ArrayList<UsuarioSer> usuarios;

    //constructor
    public UsuariosSer() {
        usuarios = new ArrayList();
    }

    //set/get
    public ArrayList<UsuarioSer> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(ArrayList<UsuarioSer> usuarios) {
        this.usuarios = usuarios;
    }

    //otros metodos
    public boolean ingresarUsuario(UsuarioSer nuevoUsuario) {
        for (UsuarioSer usuario : usuarios) {
            if (usuario.getUsuario().equals(nuevoUsuario.getUsuario())) {
                return false;
            }
        }
        usuarios.add(nuevoUsuario);
        return true;
    }

    public int consultarUsuario(String usuarioConsult) {
        for(int i=0;i<usuarios.size();i++)
           if (usuarios.get(i).getUsuario().equals(usuarioConsult)) {
                return i;
            }
        
        return -1;
    }

    //recibe el indice del usuario 
    public boolean consultarClave(int indiceUsuario, String clave) {
            return usuarios.get(indiceUsuario).getClave().equals(clave);
    }

    public void imprimir() {
        System.out.println("USUARIOS REGISTRADOS: ");
        for (UsuarioSer usuario : usuarios) {
            System.out.println(usuario.toString());
        }
    }
}
