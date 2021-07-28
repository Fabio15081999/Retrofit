package com.example.cf_btvn_buoi10_retrofit.model;

public class AlbumModel {
    private String albumId;
    private String title;
    private String url;

    public AlbumModel(String albumId, String title, String url) {
        this.albumId = albumId;
        this.title = title;
        this.url = url;
    }

    public String getAlbumId() {
        return albumId;
    }

    public String getTitle() {
        return title;
    }

    public String getUrl() {
        return url;
    }
}
