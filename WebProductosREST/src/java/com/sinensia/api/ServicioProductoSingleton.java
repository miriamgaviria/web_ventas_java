/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sinensia.api;

import java.util.ArrayList;

/**
 *
 * @author Admin - Miriam
 */
public class ServicioProductoSingleton {
    
    protected ArrayList<Producto> listaProductos;
    
    public void insertar (Producto p){
        listaProductos.add(p);
    }
    
    public Producto modificar (Producto p){
        p.setNombre(p.getNombre() + " - Modificado");
        p.setPrecio(p.getPrecio() + " - Modificado");
        return p;
    }
    
    public Producto[] obtenerTodos(){
        return (Producto[]) listaProductos.toArray();
    }
    
    // La única instancia es privada
    private static ServicioProductoSingleton instancia = null;
    
    //El constructor privado para que ninguna otra clase acceda a él
    // Podría ser protected si quisiéramos que clase que herede de esta, pueda utilizar esta clase
    private ServicioProductoSingleton(){
        this.listaProductos = new ArrayList<>();
            
    }
    // La primera vez que se llama al método, se crea la instancia.
    // A partir de ese momento, hasta que la aplicación termine, la instancia seguirá "viva" 
    // y es devuelta por el método, venga de donde venga la llamada.
    public static ServicioProductoSingleton getInstancia(){
        if (instancia == null){
            instancia = new ServicioProductoSingleton();
        }
        return instancia;
    }
}
