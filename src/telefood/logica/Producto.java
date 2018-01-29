/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telefood.logica;

/**
 *
 * @author Jahyr
 */
public class Producto {
    
    private int ProductoId;
    private String Nombre;
    private String Cantidad;
    private double Precio;

    public Producto() {}

    public int getProductoId() {
        return ProductoId;
    }

    public void setProductoId(int ProductoId) {
        this.ProductoId = ProductoId;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getCantidad() {
        return Cantidad;
    }

    public void setCantidad(String Cantidad) {
        this.Cantidad = Cantidad;
    }

    public double getPrecio() {
        return Precio;
    }

    public void setPrecio(double Precio) {
        this.Precio = Precio;
    }

    @Override
    public String toString() {
        return super.toString(); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
