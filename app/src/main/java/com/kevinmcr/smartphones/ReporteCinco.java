package com.kevinmcr.smartphones;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class ReporteCinco extends AppCompatActivity {
    private ArrayList<Celular> celulares;
    private TextView resultado;
    private Resources r;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reporte_cinco);
        celulares = Datos.obtener();
        resultado = findViewById(R.id.lblResultado);
        r = this.getResources();
        reporte();
    }
    public void reporte(){
        int cant = 0;
        Double precio = 0.0, prom = 0.0;
        String marca, res;
        if (celulares.size() != 0){

            for (int i = 0; i < celulares.size(); i++){
                marca = celulares.get(i).getMarca();
                if(marca.equals(r.getString(R.string.nokia)) ){
                    cant++;
                    precio = Double.parseDouble(celulares.get(i).getPrecio()) + precio;
                }

            }
            prom = precio/cant;

            if(cant != 0)resultado.setText(""+String.format("%.2f",prom)+" "+r.getString(R.string.moneda));
        }



    }
}
