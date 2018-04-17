package com.kevinmcr.smartphones;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ReporteCuatro extends AppCompatActivity {
    private ArrayList<Celular> celulares;
    private TextView resultado;
    private Resources r;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reporte_cuatro);
        celulares = Datos.obtener();
        resultado = findViewById(R.id.lblResultado);
        r = this.getResources();
        reporte();
    }

    public void reporte(){
        int cant = 0;
        String marca = "", color;

        if(celulares.size() != 0){
            for (int i = 0; i < celulares.size(); i++){
                marca = celulares.get(i).getMarca();
                color = celulares.get(i).getColor();
                if(marca.equals("Apple") && color.equals(r.getString(R.string.negro))){
                    cant++;
                }

            }
            resultado.setText(""+cant);
        }

    }
}
