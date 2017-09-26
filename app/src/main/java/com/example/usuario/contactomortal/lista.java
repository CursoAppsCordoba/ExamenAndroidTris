package com.example.usuario.contactomortal;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import static android.R.attr.data;
import static com.example.usuario.contactomortal.MainActivity.LISTADO;

public class lista extends AppCompatActivity implements View.OnClickListener{
    private ListView listView;
    private List<Contacto> lista=new ArrayList<>();
    ArrayAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);
        Intent intent = getIntent();


        listView = (ListView) findViewById(R.id.lista);
        ArrayList<String> listado=(ArrayList<String>) intent.getSerializableExtra("lista");
        adapter= new ArrayAdapter(this, android.R.layout.simple_expandable_list_item_1,listado);
        listView.setAdapter(adapter);

        //final Toast toast=new Toast(getApplicationContext());
        listView.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapter, View view, int position, long id) {


                Contacto c=(Contacto)adapter.getItemAtPosition(position) ;
                String valor=c.getNombre();
                Toast.makeText(getApplicationContext(), "Contacto seleccionado: " + valor, Toast.LENGTH_LONG).show();
            }
        });





    }





        /*for(int i=0; i<lista.size();i++)
        {
            lista.add();
        }
        adapter=new ArrayAdapter(this,android.R.layout.simple_list_item_1,lista);
        listView.setAdapter(adapter);



        Intent i3 = new Intent(this, Main2Activity.class);
        startActivityForResult(i3, LISTADO);*/






    @Override
    public void onClick(View v) {

    }
}
