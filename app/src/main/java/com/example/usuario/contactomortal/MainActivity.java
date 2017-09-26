package com.example.usuario.contactomortal;

import android.app.Activity;
import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    public static final Integer ALTA=100;
    public static final Integer BAJA=200;
    public static final Integer LISTADO=300;
    private ArrayList<Contacto> listaContactos= new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button boton_anadir = (Button) findViewById(R.id.btanadir);
        boton_anadir.setOnClickListener(this);
        final Button boton_listar = (Button) findViewById(R.id.btlistar);
        boton_listar.setOnClickListener(this);
    }

    
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(ALTA==requestCode){
            if (resultCode== Activity.RESULT_OK){
                if(data.hasExtra("contacto")){
                    listaContactos.add((Contacto) data.getParcelableExtra("contacto"));
                }
            }
        }
        if(BAJA==requestCode){
            if (resultCode== Activity.RESULT_OK){
                if(data.hasExtra("contacto")) {
                    listaContactos.remove(data.getParcelableExtra("contacto"));

                }
            }
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.btanadir:
                Intent i = new Intent(this, Main2Activity.class);
                startActivityForResult(i, ALTA);
                break;
            case R.id.btborrar:
                Intent i2 = new Intent(this, Main3Activity.class);
                startActivityForResult(i2, BAJA);
                break;
            case R.id.btlistar:
                Intent i3=new Intent(this, lista.class);
                i3.putExtra("lista", (Serializable) listaContactos);
                startActivityForResult(i3,LISTADO);
                break;

        }
    }
}
