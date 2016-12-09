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

    String horari = "CREATE TABLE horari (id_horari INTEGER, grup TEXT, id_assignatura TEXT, hora_inici TEXT, hora_fi TEXT, dia_setmana INTEGER)";

    String assignatura = "CREATE TABLE assignatura (id_assignatura TEXT, assignatura TEXT, id_professor INTEGER)";

    String professors = "CREATE TABLE professors (id_professor TEXT, nom_professor TEXT)";

    String [] sentenciaINSERTassignatura = {"INSERT INTO assignatura VALUES(1, M2-M5-M6, 1)" , "INSERT INTO assignatura VALUES(2, M3, 2)",
            "INSERT INTO assignatura VALUES(3, M7, 3)", "INSERT INTO assignatura VALUES(8, M8, 4)" , "INSERT INTO assignatura  VALUES(4, M9, 1)", "INSERT INTO assignatura VALUES (5, M10, 5)",
            "INSERT INTO assignatura VALUES(6, Tutoria, 2)", "INSERT INTO assignatura VALUES(7, PATI, NULL)" };

    String [] sentenciasINSERTprofessors = {"INSERT INTO professors  VALUES(1, Jorge Rubio)", "INSERT INTO professors VALUES(2, Josefa Gonzalez)" ,
            "INSERT INTO professors VALUES(3, Jose Antonio Leo)", "INSERT INTO professors VALUES(4, Lluis Maria Perpinya)" ,"INSERT INTO professors VALUES(5, Marta Planas)"};

    String [] sentenciasINSERThorari = {"INSERT INTO horari VALUES(1, A1, 3, 15:00:00, 17:59:59, 2)",
            "INSERT INTO horari VALUES(1, A2, 3, 15:00:00, 17:59:59, 2)",
            "INSERT INTO horari VALUES(1, A2, 7, 18:00:00, 18:19:59, 2)",
            "INSERT INTO horari VALUES(1, A2, 2, 19:20:00, 21:20:00, 2)",
            //Martes
            "INSERT INTO horari VALUES(1, A1, 2, 15:00:00, 16:59:59, 3)",
            "INSERT INTO horari VALUES(1, A2, 8, 15:00:00, 16:59:59, 3)",
            "INSERT INTO horari VALUES(1, A1, 5, 17:00:00, 17:59:59, 3)",
            "INSERT INTO horari VALUES(1, A2, 5, 17:00:00, 17:59:59, 3)",
            "INSERT INTO horari VALUES(1, A1, 7, 18:00:00, 18:19:59, 3)",
            "INSERT INTO horari VALUES(1, A2, 7, 18:00:00, 18:19:59, 3)",
            "INSERT INTO horari VALUES(1, A1, 3, 18:20:00, 19:19:59, 3)",
            "INSERT INTO horari VALUES(1, A2, 3, 18:20:00, 19:19:59, 3)",
            "INSERT INTO horari VALUES(1, A1, 1, 19:20:00, 21:20:20, 3)",
            "INSERT INTO horari VALUES(1, A2, 1, 19:20:00, 21:20:20, 3)",
            //Miercoles
            "INSERT INTO horari VALUES(1, A1, 1, 15:00:00, 15:59:59, 4)",
            "INSERT INTO horari VALUES(1, A2, 1, 15:00:00, 15:59:59, 4)",};













    /*LUNES = 2, MARTES = 3, DOMINGO = 0*/

    /* SELECT id_assignatura
    *  FROM horaris
    *  WHERE hora_del_sistema BETWEEN hora_inici AND hora_fi*/
}
