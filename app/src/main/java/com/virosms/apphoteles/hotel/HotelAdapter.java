package com.virosms.apphoteles.hotel;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.virosms.apphoteles.R;

import java.util.List;

public class HotelAdapter extends RecyclerView.Adapter<HotelAdapter.ViewHolder>{
    public List<Integer> images;
    public List<String> names;
    public List<String> addresses;

    public HotelAdapter(List<Integer> images, List<String> names, List<String> addresses) {
        this.images = images;
        this.names = names;
        this.addresses = addresses;
    }

    @NonNull
    @Override
    public HotelAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = View.inflate(parent.getContext(), R.layout.item_hotel, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.imageView.setImageResource(images.get(position));
        holder.name.setText(names.get(position));
        holder.address.setText(addresses.get(position));


        holder.btnReservar.setOnClickListener((c)->
                Toast.makeText(c.getContext(),
                        "Se ha añadido "+holder.name.getText().toString()+" a tus favoritos",
                        Toast.LENGTH_SHORT).show());
    }

    @Override
    public int getItemCount() {
        return images != null && names != null && addresses != null ?
                Math.min(images.size(), names.size()) : 0;
    }


    static class ViewHolder extends RecyclerView.ViewHolder {

        public final ImageView imageView;
        public final TextView name;
        public final TextView address;

        public final ImageButton btnReservar;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.imageHotel);
            name = itemView.findViewById(R.id.textHotelName);
            address = itemView.findViewById(R.id.textHotelAddress);
            btnReservar = itemView.findViewById(R.id.imageButton);
        }
    }
}
