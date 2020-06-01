package com.rajputana.gaurparivar.Adapter;

import android.content.Context;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.rajputana.gaurparivar.Model.Data;
import com.rajputana.gaurparivar.PurvajActivity;
import com.rajputana.gaurparivar.R;

import java.util.ArrayList;

public class PurvajHomeActivityAdapter extends RecyclerView.Adapter<PurvajHomeActivityAdapter.MyViewHolder> {
    Context context;
    ArrayList<Data> data;

    public PurvajHomeActivityAdapter(Context c, ArrayList<Data> d) {
        context = c;
        data = d;

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.item_data, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.name.setText(data.get(position).getName());
        holder.fname.setText(data.get(position).getFname());
        holder.note.setText(data.get(position).getNote());

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView name, fname, note;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.name);
            fname = (TextView) itemView.findViewById(R.id.fname);
            note = (TextView) itemView.findViewById(R.id.note);

        }
    }
}
