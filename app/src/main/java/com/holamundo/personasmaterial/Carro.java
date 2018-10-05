package com.holamundo.personasmaterial;

public class Carro {
    private int foto;
    private String placa;
    private int color;
    private int marca;
    private String precio;

    public Carro(int foto, String placa, int color, int marca, String precio) {
        this.foto = foto;
        this.placa = placa;
        this.color = color;
        this.marca = marca;
        this.precio = precio;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public int getMarca() {
        return marca;
    }

    public void setMarca(int marca) {
        this.marca = marca;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public void guardar(){
        Datos.agregar(this);
    }

}
