package com.example.alumnedam.activitat_3_android;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Inicializamos el boton
        Button buttonEnviar = (Button) findViewById(R.id.buttonConfiguracion);
        //Le aplicamos un clickListener
        buttonEnviar.setOnClickListener(this);
    }


    /**
     * Boton de enviar y el menu de seleccion de FECHA.
     * @param v
     */
    @Override
    public void onClick(View v){

        if (v.getId() == R.id.buttonConfiguracion){

            Intent intent = new Intent (this, configuracion.class);

            startActivity(intent);
            finish();
        }
    }


}
