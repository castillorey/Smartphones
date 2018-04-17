package com.kevinmcr.smartphones;

import java.util.ArrayList;

/**
 * Created by android on 16/04/2018.
 */

public class Datos {
    private static ArrayList<Celular> celulares = new ArrayList();

    public static void guardar(Celular c) {
        celulares.add(c);
    }

    public static ArrayList<Celular> obtener(){
        return celulares;
    }
}
