/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package catalogoProductos;

import java.util.ArrayList;

public class Categorias {
    
    private String nombreCategoria;
    private ArrayList<Productos> listaProductos;
    private Productos producto = new Productos();

    public Categorias(String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
        listaProductos = new ArrayList<>();
    }
    
    public Categorias(){
        
    }

    public String getNombreCategoria() {
        return nombreCategoria;
    }

    public void setNombreCategoria(String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
    }

    public ArrayList<Productos> getListaProductos() {
        return listaProductos;
    }

    public void setListaProductos(ArrayList<Productos> listaProductos) {
        this.listaProductos = listaProductos;
    }

    public Productos getProducto() {
        return producto;
    }

    public void setProducto(Productos producto) {
        this.producto = producto;
    }
    
    public void agregarProductoLista(Productos producto){
        this.listaProductos.add(producto);
        System.out.println("Producto Agregado Correctamente!");
    }
}
