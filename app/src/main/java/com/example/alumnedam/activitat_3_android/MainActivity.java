package com.example.alumnedam.activitat_3_android;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    String horari = "CREATE TABLE horari (id_horari INTEGER, grup TEXT, codi_assignatura TEXT, hora_inici TEXT, hora_fi TEXT, dia_setmana INTEGER)";

    String assignatura = "CREATE TABLE assignatura (id_assignatura TEXT, professor TEXT)";

    
}
