package com.example.alumnedam.activitat_3_android;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by dblan on 29/12/2016.
 */

public class BDCreador extends SQLiteOpenHelper {
    String [] sqlCreate = new String [3];

    String[] sqlInserts = new String[30];

    public BDCreador(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {


        sqlCreate[0] = "CREATE TABLE horari (id_horari INTEGER, grup TEXT, id_assignatura TEXT, hora_inici TEXT, hora_fi TEXT, dia_setmana INTEGER)";

        sqlCreate[1] = "CREATE TABLE assignatura (id_assignatura TEXT," + "assignatura TEXT," + "id_professor INTEGER)";

        sqlCreate[2] = "CREATE TABLE professors (id_professor INTEGER PRIMARY KEY ," + "nom_professor TEXT)";


        sqlInserts[0] = "INSERT INTO assignatura VALUES(1, M2-M5-M6, 1)," +
                                                       "(2, M3, 2), " +
                                                       "(3, M7, 3), " +
                                                       "(8, M8, 4), " +
                                                       "(4, M9, 1), " +
                                                       "(5, M10, 5), " +
                                                       "(6, Tutoria, 2), " +
                                                       "(7, PATI, NULL)" ;


        sqlInserts[1] = "INSERT INTO professors  VALUES(1, Jorge Rubio), " +
                                                      "(2, Josefa Gonzalez), " +
                                                      "(3, Jose Antonio Leo), " +
                                                      "(4, Lluis Maria Perpinya), " +
                                                      "(5, Marta Planas)";


        sqlInserts[2] = "INSERT INTO horari VALUES(1, A1, 3, 15:00:00, 17:59:59, 2), " +
                "(1, A2, 3, 15:00:00, 17:59:59, 2), " +
                "(1, A2, 7, 18:00:00, 18:19:59, 2), " +
                "(1, A2, 2, 19:20:00, 21:20:00, 2), " +
                "(1, A1, 2, 15:00:00, 16:59:59, 3), " +
                "(1, A2, 8, 15:00:00, 16:59:59, 3), " +
                "(1, A1, 5, 17:00:00, 17:59:59, 3), " +
                "(1, A2, 5, 17:00:00, 17:59:59, 3), " +
                "(1, A1, 7, 18:00:00, 18:19:59, 3), " +
                "(1, A2, 7, 18:00:00, 18:19:59, 3), " +
                "(1, A1, 3, 18:20:00, 19:19:59, 3), " +
                "(1, A2, 3, 18:20:00, 19:19:59, 3), " +
                "(1, A1, 1, 19:20:00, 21:20:20, 3), " +
                "(1, A2, 1, 19:20:00, 21:20:20, 3), " +
                "(1, A1, 1, 16:00:00, 16:59:59, 4), " +
                "(1, A2, 1, 16:00:00, 16:59:59, 4), " +
                "(1, A1, 4, 17:00:00, 17:59:59, 4), " +
                "(1, A2, 8, 17:00:00, 17:59:59, 4), " +
                "(1, A1, 4, 18:20:00, 19:19:59, 4), " +
                "(1, A2, 8, 18:20:00, 19:19:59, 4), " +
                "(1, A1, 2, 19:20:00, 20:19:59, 4), " +
                "(1, A2, 8, 19:20:00, 20:20:00, 4), " +
                "(1, A1, 2, 20:20:00, 21:20:00, 4), " +
                "(1, A1, 4, 15:00:00, 15:59:59, 5), " +
                "(1, A1, 8, 16:00:00, 16:59:59, 5), " +
                "(1, A2, 2, 16:00:00, 16:59:59, 5), " +
                "(1, A1, 8, 17:00:00, 17:59:59, 5), " +
                "(1, A2, 2, 17:00:00, 17:59:59, 5), " +
                "(1, A1, 1, 18:20:00, 21:20:00, 5), " +
                "(1, A2, 1, 18:20:00, 21:20:00, 5), " +
                "(1, A1, 5, 15:00:00, 16:59:59, 6)," +
                "(1, A2, 5, 15:00:00, 16:59:59, 6)," +
                "(1, A1, 8, 17:00:00, 17:59:59, 6)," +
                "(1, A2, 4, 17:00:00, 17:59:59, 6)," +
                "(1, A1, 8, 18:20:00, 19:19:00, 6)," +
                "(1, A2, 4, 18:20:00, 19:19:00, 6)," +
                "(1, A1, 1, 19:20:00, 21:20:00, 6)," +
                "(1, A2, 1, 19:20:00, 21:20:00, 6)";






    }




    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

        /*LUNES = 2, MARTES = 3, DOMINGO = 0*/

    /* SELECT id_assignatura
    *  FROM horaris
    *  WHERE hora_del_sistema BETWEEN hora_inici AND hora_fi*/
}
