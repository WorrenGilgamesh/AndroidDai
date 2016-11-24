package worrengilgamesh.ejemplofragmentoslista;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by sdist on 24/11/2016.
 */
public class ConexionBD extends SQLiteOpenHelper{
    String cadenaCreate = "create table if not exist tablaprueba(_id integer primary autoincremento, datos text not null);";
    public ConexionBD(Context context){
        super(context, "prueba.db", null, 1);
    }

    public void onCreate(SQLiteDatabase db){
        db.execSQL(cadenaCreate);
    }
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        String cadenaUpdate= "drop table if exists tablaprueba;";
        db.execSQL(cadenaUpdate);
        onCreate(db);
    }
}
