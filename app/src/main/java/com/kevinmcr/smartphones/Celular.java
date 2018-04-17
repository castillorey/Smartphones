package com.kevinmcr.smartphones;

/**
 * Created by android on 16/04/2018.
 */

public class Celular {
    private String marca, color, precio;

    public Celular(String marca, String color, String precio) {
        this.marca = marca;
        this.color = color;
        this.precio = precio;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public void guardar(){
        Datos.guardar(this);
    }

}
