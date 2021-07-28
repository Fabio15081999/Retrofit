package com.example.cf_btvn_buoi10_retrofit;

import com.example.cf_btvn_buoi10_retrofit.model.AlbumModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {

    @GET("/photos")
    Call<List<AlbumModel>> getAlbum();
}
