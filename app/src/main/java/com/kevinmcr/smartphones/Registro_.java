package com.kevinmcr.smartphones;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Registro_ extends AppCompatActivity {
    private String marca[], color[];
    private Spinner marcas, colores;
    private EditText precio;
    private Button botonGuardar, botonBorrar;
    private Resources recursos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_);
        marcas = findViewById(R.id.cmbMarca);
        colores = findViewById(R.id.cmbColor);
        recursos = this.getResources();

        marca = recursos.getStringArray(R.array.marcas);
        ArrayAdapter<String> adapterMarcas = new ArrayAdapter(this,R.layout.spinner_item,marca);
        marcas.setAdapter(adapterMarcas);
        adapterMarcas.setDropDownViewResource(R.layout.spinner_item);

        color = recursos.getStringArray(R.array.colores);
        ArrayAdapter<String> adapterColores = new ArrayAdapter(this,R.layout.spinner_item,color);
        colores.setAdapter(adapterColores);
        adapterMarcas.setDropDownViewResource(R.layout.spinner_item);

        precio = findViewById(R.id.precio);
        botonGuardar = findViewById(R.id.btnGuardar);
        botonBorrar = findViewById(R.id.btnBorrar);

    }
    public boolean validar(){
        String regEx = "^[0-9]+([.][0-9]+)?$"; //Para validar que no ingresen: ( .0) (0. ) ( . )

        int marca = marcas.getSelectedItemPosition(),
            color = colores.getSelectedItemPosition();
        Pattern r = Pattern.compile(regEx);
        Matcher mPrecio = r.matcher(precio.getText().toString());

        if(marca == 0){
            Toast.makeText(Registro_.this,getResources().getString(R.string.error_marca_vacio),Toast.LENGTH_LONG).show();
            return false;
        }

        if(color == 0){
            Toast.makeText(Registro_.this,getResources().getString(R.string.error_color_vacio),Toast.LENGTH_LONG).show();
            return false;
        }

        if(precio.getText().toString().isEmpty()){
            precio.requestFocus();
            precio.setError(recursos.getString(R.string.error_precio_vacio));
            return false;
        }

        if(!mPrecio.find()){
            precio.requestFocus();
            precio.setError(recursos.getString(R.string.error_formato_precio));
            return false;
        }

        return true;
    }

    public void guardar (View v){
        String pr;
        String marca, color;

        if(validar()){
            pr = precio.getText().toString();
            marca = marcas.getSelectedItem().toString();
            color = colores.getSelectedItem().toString();
            Celular c = new Celular(marca,color,pr);
            c.guardar();
            Toast.makeText(this,getResources().getString(R.string.mensaje_guardado),Toast.LENGTH_SHORT).show();
        }

    }
    public void nuevo(View v){
        precio.setText("");
        marcas.setSelection(0);
        colores.setSelection(0);
    }
}
