package com.sinensia.api;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// Decoradores en forma de anotación. Esto equivale al documento web.xml con las características del proyecto
@WebServlet(asyncSupported = true, urlPatterns = "/api/productos")
public class ProductoRestController extends HttpServlet {
    
    private ServicioProductoSingleton servProd;
    @Override
    public void init(){
        servProd = ServicioProductoSingleton.getInstancia();
    }

    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter escritorRespuesta = response.getWriter();
        
        response.setContentType("application/json;charset=UTF-8");
        
        BufferedReader bufRead = request.getReader();
        StringBuilder textoJson = new StringBuilder();
        for (String lineaJson = bufRead.readLine();
                lineaJson != null;
                lineaJson = bufRead.readLine()) {
            textoJson.append(lineaJson);
        }
        bufRead.close();

        Gson gson = new Gson();
        Producto producto = gson.fromJson(textoJson.toString(), Producto.class);

        servProd.insertar(producto);
        
        String jsonRespuesta = gson.toJson(producto);
        escritorRespuesta.println(jsonRespuesta);
    }
    
    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        Producto producto1 = new Producto();
        producto1.setNombre("producto1");
        producto1.setPrecio("50");
        
        Producto producto2 = new Producto();
        producto2.setNombre("producto2");
        producto2.setPrecio("100");
        
        servProd.insertar(producto1);
        servProd.insertar(producto2);
        
    }
    
    @Override
    protected void doPut(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter escritorRespuesta = response.getWriter();
        response.setContentType("application/json;charset=UTF-8");
        // 
        BufferedReader bufRead = request.getReader();
        StringBuilder textoJson = new StringBuilder();
        for (String lineaJson = bufRead.readLine();
                lineaJson != null;
                lineaJson = bufRead.readLine()) {
            textoJson.append(lineaJson);
        }
        bufRead.close();

        System.out.println(">>>> " + textoJson.toString().toUpperCase());

        Gson gson = new Gson();
        Producto producto = gson.fromJson(textoJson.toString(), Producto.class);

        System.out.println(">>>> " + producto.getNombre());
        
        // Estas dos líneas no funcionan porque utilizamos el método singleton
        /*producto.setNombre(producto.getNombre().toUpperCase());
        producto.setPrecio("5000 bolivares");*/
        
        // Estas dos líneas no las utilizamos porque instaciamos al comienzo el objeto y no es necesario crearlo más.
        /*ServicioProductoSingleton sps = ServicioProductoSingleton.getInstancia();
        sps.modificar(producto);*/
        servProd.modificar(producto);
        
        String jsonRespuesta = gson.toJson(producto);
        escritorRespuesta.println(jsonRespuesta);
    }
}
