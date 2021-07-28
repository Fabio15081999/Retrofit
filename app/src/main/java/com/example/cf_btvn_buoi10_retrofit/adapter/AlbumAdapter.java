package com.example.cf_btvn_buoi10_retrofit.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cf_btvn_buoi10_retrofit.R;
import com.example.cf_btvn_buoi10_retrofit.model.AlbumModel;
import com.squareup.picasso.Picasso;

import java.util.List;

public class AlbumAdapter extends RecyclerView.Adapter<AlbumAdapter.ViewHolder> {
    private List<AlbumModel> albumModelList;
    @NonNull
    @Override
    public AlbumAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item, parent, false);
        return new ViewHolder(view);
    }

    public AlbumAdapter(List<AlbumModel> albumModelList) {
        this.albumModelList = albumModelList;
    }

    @Override
    public void onBindViewHolder(@NonNull AlbumAdapter.ViewHolder holder, int position) {
        holder.tvAlbumid.setText("Album ID: " + albumModelList.get(position).getAlbumId());
        holder.tvtitle.setText("Title: "+albumModelList.get(position).getTitle());
        Picasso.get().load(albumModelList.get(position).getUrl()).into(holder.imageView);



    }

    @Override
    public int getItemCount() {
        return albumModelList.size();
    }

    public class ViewHolder extends  RecyclerView.ViewHolder{
        TextView tvAlbumid;
        TextView tvtitle;
        ImageView imageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvAlbumid = itemView.findViewById(R.id.tvAlbumid);
            tvtitle = itemView.findViewById(R.id.tvTitle);
            imageView = itemView.findViewById(R.id.imv);
        }
    }
}
