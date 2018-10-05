package com.holamundo.personasmaterial;

import java.util.ArrayList;

public class Datos {
    public static ArrayList<Carro> carros = new ArrayList();

    public static void agregar(Carro p){
        carros.add(p);
    }

    public static ArrayList<Carro> obtener(){
        return carros;
    }

}
