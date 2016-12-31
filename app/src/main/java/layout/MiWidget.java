package layout;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.RemoteViews;
import android.widget.TextView;

import com.example.alumnedam.activitat_3_android.MainActivity;
import com.example.alumnedam.activitat_3_android.R;

import java.util.Calendar;
import java.util.GregorianCalendar;

import static com.example.alumnedam.activitat_3_android.R.id.LblMensaje;

/**
 * Implementation of App Widget functionality.
 */
public class MiWidget extends AppWidgetProvider {

    private static android.database.sqlite.SQLiteDatabase db;
    private SQLiteDatabase db2;

    private static TextView LblMensaje;

    static void updateAppWidget(Context context, AppWidgetManager appWidgetManager,
                                int appWidgetId) {

        CharSequence widgetText = context.getString(R.string.appwidget_text);
        // Construct the RemoteViews object
        RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.mi_widget);
        views.setTextViewText(R.id.appwidget_text, widgetText);

        // Instruct the widget manager to update the widget
        appWidgetManager.updateAppWidget(appWidgetId, views);
    }

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        //Iteramos la lista de widgets en ejecuci�n
        for (int i = 0; i < appWidgetIds.length; i++)
        {
            //ID del widget actual
            int widgetId = appWidgetIds[i];

            //Actualizamos el widget actual
            actualizarWidget(context, appWidgetManager, widgetId);
        }
    }








    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals("net.sgoliver.android.widgets.ACTUALIZAR_WIDGET")) {

            //Obtenemos el ID del widget a actualizar
            int widgetId = intent.getIntExtra(
                    AppWidgetManager.EXTRA_APPWIDGET_ID,
                    AppWidgetManager.INVALID_APPWIDGET_ID);

            //Obtenemos el widget manager de nuestro contexto
            AppWidgetManager widgetManager =
                    AppWidgetManager.getInstance(context);

            //Actualizamos el widget
            if (widgetId != AppWidgetManager.INVALID_APPWIDGET_ID) {
                actualizarWidget(context, widgetManager, widgetId);
            }
        }
    }

    @Override
    public void onDeleted(Context context, int[] appWidgetIds)
    {
        //Accedemos a las preferencias de la aplicaci�n
        SharedPreferences prefs =
                context.getSharedPreferences("WidgetPrefs", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();

        //Eliminamos las preferencias de los widgets borrados
        for(int i=0; i<appWidgetIds.length; i++)
        {
            //ID del widget actual
            int widgetId = appWidgetIds[i];

            editor.remove("msg_" + widgetId);
        }

        //Aceptamos los cambios
        editor.commit();

        super.onDeleted(context, appWidgetIds);
    }














    public static void actualizarWidget(Context context,
                                        AppWidgetManager appWidgetManager, int widgetId)
    {
        //Recuperamos el mensaje personalizado para el widget actual
        SharedPreferences prefs =
                context.getSharedPreferences("WidgetPrefs", Context.MODE_PRIVATE);
        String mensaje = prefs.getString("msg_" + widgetId, "Hora actual:");

        //Obtenemos la lista de controles del widget actual
        RemoteViews controles =
                new RemoteViews(context.getPackageName(), R.layout.mi_widget);

        //Asociamos los 'eventos' al widget
        Intent intent = new Intent("net.sgoliver.android.widgets.ACTUALIZAR_WIDGET");
        intent.putExtra(
                AppWidgetManager.EXTRA_APPWIDGET_ID, widgetId);

        PendingIntent pendingIntent =
                PendingIntent.getBroadcast(context, widgetId,
                        intent, PendingIntent.FLAG_UPDATE_CURRENT);

        controles.setOnClickPendingIntent(R.id.BtnActualizar, pendingIntent);

        Intent intent2 = new Intent(context, MainActivity.class);
        PendingIntent pendingIntent2 =
                PendingIntent.getActivity(context, widgetId,
                        intent2, PendingIntent.FLAG_UPDATE_CURRENT);

        controles.setOnClickPendingIntent(R.id.FrmWidget, pendingIntent2);




        //Alternativa 1: m�todo rawQuery()
        //Cursor c = db.rawQuery("SELECT codigo, nombre FROM Usuarios", null);
        Cursor c = db.rawQuery("SELECT id_assignatura FROM horaris WHERE hora BETWEEN hora_inici AND hora_fi AND grup like '%A1%'" , null);
        //Alternativa 2: m�todo delete()
        //String[] campos = new String[] {"codigo", "nombre"};
        //Cursor c = db.query("Usuarios", campos, null, null, null, null, null);






        //Recorremos los resultados para mostrarlos en pantalla
        LblMensaje.setText("");
        if (c.moveToFirst()) {
            //Recorremos el cursor hasta que no haya m�s registros
            do {
                String asignatura = c.getString(0);
                LblMensaje.append(asignatura);
            } while(c.moveToNext());
        }



        //Actualizamos el mensaje en el control del widget
        //controles.setTextViewText(R.id.LblMensaje, mensaje);

        //Obtenemos la hora actual
        Calendar calendario = new GregorianCalendar();
        String hora = calendario.getTime().toString();

        //Actualizamos la hora en el control del widget
        controles.setTextViewText(R.id.LblHora, hora);

        //Notificamos al manager de la actualizaci�n del widget actual
        appWidgetManager.updateAppWidget(widgetId, controles);
    }
}

