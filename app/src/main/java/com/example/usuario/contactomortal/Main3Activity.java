package com.example.usuario.contactomortal;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class Main3Activity extends AppCompatActivity implements OnClickListener{
    private Contacto contacto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
    }


    public void borrarContacto(View v) {
        final Button boton_aceptar = (Button) findViewById(R.id.btBorra);
        final Button boton_cancelar = (Button) findViewById(R.id.btVuelve);
        EditText edtNombre = (EditText) this.findViewById(R.id.ednom);
        EditText edtMail = (EditText) this.findViewById(R.id.edmail);
        EditText edtEdad = (EditText) this.findViewById(R.id.ededad);
        String nom = edtNombre.getText().toString();
        String mail = edtMail.getText().toString();
        Integer edad = Integer.parseInt(edtEdad.getText().toString());
        boton_aceptar.setOnClickListener(this);
        boton_cancelar.setOnClickListener(this);
        //contacto = new ArrayList<>();

        contacto = new Contacto(nom, mail, edad);
    }


    public AlertDialog CreateDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("¿Desea salir de la actividad");
        builder.setPositiveButton("ok", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                Main3Activity.this.finish();
            }
        });
        builder.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {

            }
        });
        return builder.create();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.btBorra:
                borrarContacto(v);
                if (contacto!=null) {
                    Intent i = new Intent();
                    //startActivityForResult(i, 0);
                    i.putExtra("contacto", contacto);
                    setResult(Activity.RESULT_OK, i);
                    finish();
                }

                break;
            case R.id.btVuelve:
                CreateDialog().show();
                break;

        }
        // finish();
    }
}
