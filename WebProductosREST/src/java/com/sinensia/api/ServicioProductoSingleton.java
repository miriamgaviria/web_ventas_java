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
    
    private ArrayList<Producto> listaProductos;
    
    public void insertar (Producto p){
        
        
        listaProductos.add(p);
    }
    
    public Producto modificar (Producto p){
        p.setNombre(p.getNombre() + " - Modificado");
        p.setPrecio(p.getPrecio() + " - Modificado");
        return p;
    }
    
    public ArrayList<Producto> obtenerTodos(){
//        Producto producto1 = new Producto();
//        producto1.setNombre("producto1");
//        producto1.setPrecio("50");
//        Producto producto2 = new Producto();
//        producto2.setNombre("producto2");
//        producto2.setPrecio("100");
//        listaProductos.add(producto1);
//        listaProductos.add(producto2);
        
        return listaProductos;
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
