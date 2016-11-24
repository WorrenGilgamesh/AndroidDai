package worrengilgamesh.ejemplofragmentoslista;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.hardware.camera2.params.StreamConfigurationMap;

/**
 * Created by sdist on 24/11/2016.
 */
public class InterfazBd  {
    ConexionBD con;
    SQLiteDatabase db;

    public InterfazBd(Context context){
        con = new ConexionBD(context);
    }

    public void open() throws SQLException{
        db= con.getWritableDatabase();
    }

    public void close() throws SQLException{
        con.close();
    }

    public long insertarDatos(String dato){
        ContentValues valores;
        open();
        valores = new ContentValues();
        valores.put("datos", dato);
        long clave = db.insert("tablaprueba", null, valores);
        close();
        return clave;
    }

    public void insertarDatosPrueba(){
        ContentValues valores;
        open();
        valores = new ContentValues();
        valores.put("datos","hola");
        db.insert("tablaprueba", null, valores);
        valores = new ContentValues();
        valores.put("datos","Adios");
        db.insert("tablaprueba", null, valores);
        valores = new ContentValues();
        valores.put("datos","luis");
        db.insert("tablaprueba", null, valores);
        valores = new ContentValues();
        valores.put("datos","ana");
        db.insert("tablaprueba", null, valores);
        close();
    }

    public Cursor traerDatos(){
        Cursor res= null;
        open();
        String cadena = "select * from tablaprueba;";
        res=db.rawQuery(cadena, null);
        if (res.getCount()==0){
            insertarDatosPrueba();
            res=db.rawQuery(cadena, null);
        }
        return res;
    }

}
