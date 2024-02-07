package com.example.demouiapplication.Apihelper;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.demouiapplication.R;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.locationholder> {

    private List<Model.Result> alluserList;
    private Context context;
    private OnItemClickListener listener;

    public interface OnItemClickListener {
        void onItemClick(Model.Result item);
    }

    public MyAdapter(Context context, List<Model.Result> alluserList, OnItemClickListener listener) {
        this.context = context;
        this.alluserList = alluserList;
        this.listener = listener;
    }

    public static class locationholder extends RecyclerView.ViewHolder {
        TextView city;
        TextView lat;
        TextView lon;
        TextView Contry;

        public locationholder(@NonNull View itemView) {
            super(itemView);
            city = itemView.findViewById(R.id.cityname);
            Contry = itemView.findViewById(R.id.text_counter);
            lat = itemView.findViewById(R.id.txt_latitude);
            lon = itemView.findViewById(R.id.txt_longitude);
        }
    }

    @NonNull
    @Override
    public locationholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view, parent, false);
        return new locationholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull locationholder holder, int position) {
        Model.Result currentItem = alluserList.get(position);
        holder.city.setText(currentItem.name);
        holder.lat.setText(Float.toString(currentItem.latitude));
        holder.lon.setText(Float.toString(currentItem.longitude));
        holder.Contry.setText(currentItem.country);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onItemClick(currentItem);
            }
        });
    }

    @Override
    public int getItemCount() {
        return alluserList.size();
    }
}
