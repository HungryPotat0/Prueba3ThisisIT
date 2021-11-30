package com.Prueba3ThisisIT;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Conteo extends AppCompatActivity {

    TextView ka,bo,nu,bla;
    Button botn;
    int nbla,nka,nbo,nnu =0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conteo);

        ka=(TextView) findViewById(R.id.V_Kast);
        bo=(TextView) findViewById(R.id.V_Borick);
        nu=(TextView) findViewById(R.id.V_nulo);
        bla=(TextView) findViewById(R.id.V_Blanco);
        botn=(Button) findViewById(R.id.boot);
//    public static String NombreTabla="create table voto (id_voto Integer PRIMARY KEY autoincrement,
//    voto_blaco integer,voto_nulo integer,voto_boric integer,voto_kast integer)";
        SQLiteDatabase db;
        Conexion conn = new Conexion(getApplicationContext());
        db = conn.getReadableDatabase();
        Cursor C = db.query("voto", null, null, null, null, null, null);
        if (C != null) {
            if (C.moveToFirst()) {
                do {
                    int bla = C.getInt(1);
                    int nul =C.getInt(2);
                    int bor = C.getInt(3);
                    int kakast = C.getInt(4);
                    if (bla==1){nbla++;}
                    if (nul==1){nnu++;}
                    if (bor==1){nbo++;}
                    if (kakast==1){nka++;}

                }
                while (C.moveToNext());
            }
        }
        bla.setText(String.valueOf(nbla));
        ka.setText(String.valueOf(nka));
        bo.setText(String.valueOf(nbo));
        nu.setText(String.valueOf(nnu));



botn.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Intent I=new Intent(getApplicationContext(),MainActivity.class);
        startActivity(I);
    }
});


    }

}