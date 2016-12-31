package com.example.alumnedam.activitat_3_android;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class configuracion extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuracion);


        //Inicializamos el boton
        Button buttonEnviar = (Button) findViewById(R.id.buttonAceptar);
        //Le aplicamos un clickListener
        buttonEnviar.setOnClickListener(this);


                /*SPINNER*/

        //Creacion del spinner
        Spinner spinner = (Spinner) findViewById(R.id.spinnerClase);
        //Indicamos que queremos utilizar el array sexo_spinner con este spinner
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.clase, android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Aplicamos el adapter al spinner
        spinner.setAdapter(adapter);
    }




    Spinner spinnerClase=(Spinner) findViewById(R.id.spinnerClase);
    String opcion = spinnerClase.getSelectedItem().toString();




    /**
     *
     * @param v
     */
    @Override
    public void onClick(View v){

        if (v.getId() == R.id.buttonAceptar){



            //Guardamos las preferencias
            SharedPreferences prefs = getSharedPreferences("MisPreferencias", Context.MODE_PRIVATE);

            SharedPreferences.Editor editor = prefs.edit();
            editor.putString("clase", opcion);
            editor.commit();

            Intent intent = new Intent (this, MainActivity.class);

            startActivity(intent);
            finish();
        }
    }
}
