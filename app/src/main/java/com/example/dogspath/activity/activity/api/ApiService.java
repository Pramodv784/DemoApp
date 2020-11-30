package com.example.dogspath.activity.activity.api;

import com.example.dogspath.activity.activity.model.ImageUpload;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {
    @GET("api/v1/paths")
    Call<ArrayList<ImageUpload>> imagelist();
}
