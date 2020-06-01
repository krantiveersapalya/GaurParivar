package com.rajputana.gaurparivar.Adapter;

import android.content.Context;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.recyclerview.widget.RecyclerView;

import com.rajputana.gaurparivar.DashboardAlbum;
import com.rajputana.gaurparivar.R;
import com.squareup.picasso.Picasso;

import java.util.List;


public class DashboardAlbumsAdapter extends RecyclerView.Adapter<DashboardAlbumsAdapter.MyViewHolder> {
    private Context mContext;
    private List<DashboardAlbum> albumList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title, count;
        public ImageView thumbnail, overflow;

        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.title);
            count = (TextView) view.findViewById(R.id.count);
            thumbnail = (ImageView) view.findViewById(R.id.thumbnail);
            overflow = (ImageView) view.findViewById(R.id.overflow);

        }
    }


    public DashboardAlbumsAdapter(Context mContext, List<DashboardAlbum> albumList) {
        this.mContext = mContext;
        this.albumList = albumList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.dashboard_album_card, parent, false);

        return new MyViewHolder(itemView);
    }


    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        DashboardAlbum album = albumList.get(position);
        holder.title.setText(album.getName());
        holder.count.setText("Creator-"+album.getNumOfSongs() );

        // loading album cover using Glide library
        Picasso.with(mContext).load(album.getThumbnail()).into(holder.thumbnail);

        holder.overflow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showPopupMenu(holder.overflow);
            }
        });
    }

    @Override
    public int getItemCount() {
        return albumList.size();
    }

    /**
     * Showing popup menu when tapping on 3 dots
     */
    private void showPopupMenu(View view) {
        Log.d("love","fa");

/*

                AlertDialog.Builder builder = new AlertDialog.Builder(mContext);

                View dialogView = LayoutInflater.from(view.getContext()).inflate(R.layout.customdialogview, (ViewGroup) view, false);
                builder.setView(dialogView);
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
*/
            }

     /*   // inflate menu
        PopupMenu popup = new PopupMenu(mContext, view);
        MenuInflater inflater = popup.getMenuInflater();
        inflater.inflate(R.menu.menu_album, popup.getMenu());
        popup.setOnMenuItemClickListener(new MyMenuItemClickListener());
        popup.show();*/
    }





