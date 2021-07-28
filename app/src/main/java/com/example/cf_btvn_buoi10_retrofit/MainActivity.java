package com.example.cf_btvn_buoi10_retrofit;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.cf_btvn_buoi10_retrofit.adapter.AlbumAdapter;
import com.example.cf_btvn_buoi10_retrofit.model.AlbumModel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    ActionBar actionBar;
    RecyclerView recyclerView;
    ProgressBar progressBar;
    LinearLayoutManager layoutManager;
    AlbumAdapter adapter;
    List<AlbumModel> albumModelList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Quản Lý Album");
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#FFDF40")));

        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        progressBar = findViewById(R.id.progressBar);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new AlbumAdapter(albumModelList);
        recyclerView.setAdapter(adapter);
        fetchAlbum();

    }

    private void fetchAlbum() {
        progressBar.setVisibility(View.VISIBLE);
        RetrofitClient.getRetrofitClient().getAlbum().enqueue(new Callback<List<AlbumModel>>() {
            @Override
            public void onResponse(Call<List<AlbumModel>> call, Response<List<AlbumModel>> response) {
                if (response.isSuccessful() && response.body() != null){
                    albumModelList.addAll(response.body());
                    adapter.notifyDataSetChanged();
                    progressBar.setVisibility(View.GONE);
                }
            }

            @Override
            public void onFailure(Call<List<AlbumModel>> call, Throwable t) {
                progressBar.setVisibility(View.GONE);
                Toast.makeText(MainActivity.this, "Error: "+ t.getMessage(), Toast.LENGTH_LONG).show();

            }
        });
    }
}