package com.Prueba3ThisisIT;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Conexion extends SQLiteOpenHelper {

    public static String Nombre_BD="Votacioness.db";
    public static int version_DB=1;
    public static String NombreTabla="create table voto (id_voto Integer PRIMARY KEY autoincrement, voto_blaco integer,voto_nulo integer,voto_boric integer,voto_kast integer)";

    public Conexion(@Nullable Context context) {
        super(context, Nombre_BD,null, version_DB);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(NombreTabla);
        sqLiteDatabase.execSQL("insert into voto(voto_blaco,voto_nulo,voto_boric,voto_kast) values (0,0,1,0)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop table if exists voto");
        sqLiteDatabase.execSQL(NombreTabla);
    }
}


