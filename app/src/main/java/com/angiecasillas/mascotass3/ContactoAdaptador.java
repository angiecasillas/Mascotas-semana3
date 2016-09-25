package com.angiecasillas.mascotass3;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Usuario on 25/09/2016.
 */

public class ContactoAdaptador extends RecyclerView.Adapter<ContactoAdaptador.ContactoViewHolder> {

    ArrayList<Contacto> contactos;


    public static class ContactoViewHolder extends RecyclerView.ViewHolder {

        private ImageView imgFoto;
        private ImageView imgFotoHuesoBco;
        private TextView tvNombreCV;
        private TextView tvRatingCV;


        public ContactoViewHolder(View itemView) {
            super(itemView);
            imgFoto = (ImageView) itemView.findViewById(R.id.imgFoto);
            imgFotoHuesoBco = (ImageView) itemView.findViewById(R.id.imgFotoHuesoVacio);
            tvNombreCV = (TextView) itemView.findViewById(R.id.tvNombreCV);
            tvRatingCV = (TextView) itemView.findViewById(R.id.tvRatingCV);

        }

    }
    public ContactoAdaptador (ArrayList<Contacto> contactos){ this.contactos = contactos; }

    public int getItemCount() { return contactos.size(); }


    @Override
    //Inflar el Layout y lo pasará al viewHolder para que obtenga cada elemento, o sea los views
    public ContactoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //Indica cuál es el "Layout" que estará reciclando, en este caso "cardview_contacto"
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_contacto, parent, false);
        return new ContactoViewHolder(v);
    }

    @Override

    public void onBindViewHolder(ContactoViewHolder contactoViewHolder, int position) {
        Contacto contacto = contactos.get(position);
        contactoViewHolder.imgFoto.setImageResource(contacto.getFoto());
        contactoViewHolder.tvNombreCV.setText(contacto.getNombre());
        contactoViewHolder.tvRatingCV.setText(contacto.getRating());

        contactoViewHolder.imgFotoHuesoBco.setOnClickListener(new View.OnClickListener() {
            public void onClick (View v){
                Toast.makeText(v.getContext(), "Calificando", Toast.LENGTH_SHORT).show();
            }
        });
    }
}

