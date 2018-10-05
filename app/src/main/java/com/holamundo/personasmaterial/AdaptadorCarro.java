package com.holamundo.personasmaterial;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class AdaptadorCarro extends
        RecyclerView.Adapter<AdaptadorCarro.PersonaViewHolder> {
    private ArrayList<Carro> carros;
    private Context contexto;

    public AdaptadorCarro(ArrayList<Carro> carros, Context contexto){
        this.carros=carros;
        this.contexto=contexto;
    }
    @Override
    public PersonaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
       View v = LayoutInflater.from(parent.getContext())
               .inflate(R.layout.item_persona,parent,false);
       return new PersonaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(PersonaViewHolder holder, int position) {
        Carro p = carros.get(position);
        holder.foto.setImageResource(p.getFoto());
        holder.placa.setText(p.getPlaca());
        holder.color.setText((contexto.getResources().getStringArray(R.array.colores))
                [p.getColor()]);
        holder.marca.setText((contexto.getResources().getStringArray(R.array.marcas))
                [p.getColor()]);
        holder.precio.setText(p.getPrecio());
    }

    @Override
    public int getItemCount() {
        return carros.size();
    }

    public static class PersonaViewHolder extends RecyclerView.ViewHolder{
        private ImageView foto;
        private TextView placa;
        private TextView color;
        private TextView marca;
        private TextView precio;
        private View v;

        public PersonaViewHolder(View itemView){
            super(itemView);
            v = itemView;
            foto = v.findViewById(R.id.foto);
            placa = v.findViewById(R.id.lblPlaca);
            color = v.findViewById(R.id.lblColor);
            marca = v.findViewById(R.id.lblMarca);
            precio = v.findViewById(R.id.lblPrecio);
        }
    }
}
