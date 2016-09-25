package com.angiecasillas.mascotass3;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;

import java.util.ArrayList;

/**
 * Created by Usuario on 25/09/2016.
 */

public class Popular extends ActionBarActivity {

    ArrayList<Contacto> contactos;
    private RecyclerView listaContactos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setCustomView(R.layout.actionbar_format);


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        View view = getSupportActionBar().getCustomView();

        ImageButton imageButtonHuella = (ImageButton)view.findViewById(R.id.ab_huella);

        imageButtonHuella.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Popular.this, MainActivity.class);
                startActivity(intent);
            }
        });



        listaContactos = (RecyclerView) findViewById(R.id.rvContactos);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        listaContactos.setLayoutManager(llm);
        inicializarListaContactos();
        inicializarAdaptador();

    }




    public void inicializarAdaptador(){ ContactoAdaptador adaptador = new ContactoAdaptador(contactos);
        listaContactos.setAdapter(adaptador);
    }

    public void inicializarListaContactos() {

        contactos = new ArrayList<Contacto>();
        contactos.add(new Contacto("Mayo", "9", R.drawable.mascotaperro5));
        contactos.add(new Contacto("Terry", "8", R.drawable.mascotaperro4));
        contactos.add(new Contacto("Max","5", R.drawable.mascotaperro1));
        contactos.add(new Contacto("Momo", "4",  R.drawable.mascotaperro6));
        contactos.add(new Contacto("Fifi", "2", R.drawable.mascotaperro2));

    }
}

