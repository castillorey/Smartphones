package com.kevinmcr.smartphones;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class ReporteCinco extends AppCompatActivity {
    private ArrayList<Celular> celulares;
    private TextView resultado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reporte_cinco);
        celulares = Datos.obtener();
        resultado = findViewById(R.id.lblResultado);
        reporte();
    }
    public void reporte(){
        int cant = 0;
        String marca, color;
        for (int i = 0; i < celulares.size(); i++){
            marca = celulares.get(i).getMarca();
            color = celulares.get(i).getColor();
            if(marca == "Apple" && color == "Negro"){
                cant++;
            }
        }
        resultado.setText(cant);

    }
}
