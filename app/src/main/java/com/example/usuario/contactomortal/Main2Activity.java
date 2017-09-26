package com.example.usuario.contactomortal;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity implements View.OnClickListener {
    //private ArrayList<Contacto> contacto;
    private Contacto contacto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


    }


    public void crearContacto(View v) {
        //final Button boton_aceptar = (Button) findViewById(R.id.btaceptar);
        //final Button boton_cancelar = (Button) findViewById(R.id.btcancelar);
        EditText edtNombre = (EditText) this.findViewById(R.id.edtnombre);
        EditText edtMail = (EditText) this.findViewById(R.id.edtmail);
        EditText edtEdad = (EditText) this.findViewById(R.id.edtedad);
        String nom = edtNombre.getText().toString();
        String mail = edtMail.getText().toString();
        Integer edad = Integer.parseInt(edtEdad.getText().toString());
        //boton_aceptar.setOnClickListener(this);
        //boton_cancelar.setOnClickListener(this);
        //contacto = new ArrayList<>();

        contacto = new Contacto(nom, mail, edad);
    }


    public AlertDialog CreateDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("¿Desea salir de la actividad");
        builder.setPositiveButton("ok", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                Main2Activity.this.finish();
            }
        });
        builder.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {

            }
        });
        return builder.create();
    }



    public void salir(View view){
        AlertDialog.Builder cuadro=new AlertDialog.Builder(this);
        cuadro.setMessage("¿Desea salir de la actividad");
        //el escuchador del botón de afirmación se define como
        // una clase anónima
        cuadro.setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //Abandona la actividad
                finish();
            } }); //no se define ningún escuchador para el botón de negación cuadro.
        cuadro.setNegativeButton(android.R.string.no,null);
        cuadro.show();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.btaceptar:
                crearContacto(v);
                if (contacto!=null) {
                    Intent i = new Intent();
                    //startActivityForResult(i, 0);
                    i.putExtra("contacto", contacto);
                    setResult(Activity.RESULT_OK, i);
                    finish();
                }

                break;
            case R.id.btcancelar:
                CreateDialog().show();
                break;

        }
       // finish();
    }
}
