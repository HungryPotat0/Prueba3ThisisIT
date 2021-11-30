package com.Prueba3ThisisIT;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
String tipovoto = "Blanco";
    RadioButton RBB,RBK,RBN;
    int n,c,b,k;
// auto / 0,0,0,0
    Button vote,go;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RBB = (RadioButton) findViewById(R.id.RB_Boric);
        RBK = (RadioButton) findViewById(R.id.RB_Kakast);
        RBN = (RadioButton) findViewById(R.id.RB_Nulo);
        vote = (Button) findViewById(R.id.btnVote);
        go = (Button) findViewById(R.id.Btn_go);

        vote.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view) {
                if (RBB.isChecked()) {
                    tipovoto="Borick";
                }
                if (RBK.isChecked()) {
                    tipovoto="Kast";
                }
                if (RBN.isChecked()) {
                    tipovoto="Nulo";
                }
               Dialogo();
            }
        });


        go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent I = new Intent(getApplicationContext(), Conteo.class);
                startActivity(I);
            }
        });

    }
        public void Dialogo(){
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Atencion!");
            builder.setMessage("¿Esta Seguro de Continuar? votara: "+tipovoto );
            builder.setPositiveButton("Acepto", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    c = 1;
                    if (RBB.isChecked()) {
                        b = 1;
                        c = 0;
                    }
                    if (RBK.isChecked()) {
                        k = 1;
                        c = 0;
                    }
                    if (RBN.isChecked()) {
                        n = 1;
                        c = 0;
                    }
//    public static String NombreTabla="create table voto (id_voto Integer PRIMARY KEY autoincrement,
//    voto_blaco integer,voto_nulo integer,voto_boric integer,voto_kast integer)";

                    SQLiteDatabase db;
                    Conexion conn = new Conexion(getApplicationContext());
                    db = conn.getWritableDatabase();
                    ContentValues cv = new ContentValues();
                    cv.put("voto_blaco", c);
                    cv.put("voto_nulo", n);
                    cv.put("voto_boric", b);
                    cv.put("voto_kast", k);
                    db.insert("voto", null, cv);
                    Toast.makeText(getApplicationContext(), "registro insertado", Toast.LENGTH_LONG).show();

                }
            });
            builder.setNegativeButton("No No quiero", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {

                }
            });

            AlertDialog dialog = builder.create();
            dialog.show();
        }



}