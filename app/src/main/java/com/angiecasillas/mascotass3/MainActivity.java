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

public class MainActivity extends ActionBarActivity {

    ArrayList<Contacto> contactos;
    private RecyclerView listaContactos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // toolbar
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setCustomView(R.layout.actionbar_format);

        View view = getSupportActionBar().getCustomView();

        // star
        ImageButton imageButtonHuella = (ImageButton)view.findViewById(R.id.ab_estrella);
        imageButtonHuella.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Popular.class);
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

/*
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_opciones, menu);
        return true;
    }

    //Control de las opciones del menú
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){

            case R.id.mo_contacto:
                break;

            case R.id.mo_about:
                Intent intent2 = new Intent(MainActivity.this, Popular.class);
                startActivity(intent2);
        }

        return super.onOptionsItemSelected(item);
    }

*/

    public void irPopular(View v){ Intent intent = new Intent(this,Popular.class);
        startActivity(intent);
    }

    public void inicializarAdaptador(){ ContactoAdaptador adaptador = new ContactoAdaptador(contactos);
        listaContactos.setAdapter(adaptador);
    }

    public void inicializarListaContactos() {

        contactos = new ArrayList<Contacto>();
        contactos.add(new Contacto("Max","5", R.drawable.mascotaperro1));
        contactos.add(new Contacto("Fifi", "2", R.drawable.mascotaperro2));
        contactos.add(new Contacto("Cachito", "1", R.drawable.mascotaperro3));
        contactos.add(new Contacto("Terry", "8", R.drawable.mascotaperro4));
        contactos.add(new Contacto("Mayo", "9", R.drawable.mascotaperro5));
        contactos.add(new Contacto("Momo", "4",  R.drawable.mascotaperro6));



    }
}
