package com.example.a05_e6_listadelacompra.modelos;

import java.io.Serializable;

public class Producto implements Serializable {
    // ATRIBUTOS
    private String nombre;
    private int cantidad;
    private float precio;
    private float total;

    // CONSTRUCTORES
    public Producto(String nombre, int cantidad, float precio) {
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precio = precio;
        this.total = cantidad * precio;
    }

    // GETTERS AND SETTERS
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidad() {
        return cantidad;
    }
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
        actualizaTotal();
    }

    public float getPrecio() {
        return precio;
    }
    public void setPrecio(float precio) {
        this.precio = precio;
        actualizaTotal();
    }

    public float getTotal() {
        return total;
    }
    public void setTotal(float total) {
        this.total = total;
    }

    // MÉTODOS GENÉRICOS O PROPIOS
    private void actualizaTotal(){
        this.total = this.cantidad * this.precio;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "nombre='" + nombre + '\'' +
                ", cantidad=" + cantidad +
                ", precio=" + precio +
                ", total=" + total +
                '}';
    }
}
