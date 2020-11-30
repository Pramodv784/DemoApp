package com.example.dogspath.activity.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.dogspath.R;
import com.example.dogspath.activity.activity.adaptor.ListAdaptor;
import com.example.dogspath.activity.activity.api.ApiClient;
import com.example.dogspath.activity.activity.model.ImageUpload;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeActivity extends AppCompatActivity {
RecyclerView recyclerView;
ArrayList<ImageUpload> imagelist= new ArrayList<>();
ListAdaptor listAdaptor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        getSupportActionBar().setElevation(0);
        getSupportActionBar().getElevation();
        recyclerView=findViewById(R.id.recycle);
//        recyclerView.hasFixedSize();

        recyclerView.setLayoutManager(new LinearLayoutManager(this,RecyclerView.VERTICAL,false));
          init();
    }

    private void init() {
        Call<ArrayList<ImageUpload>> userResponse= ApiClient.getapiservice().imagelist();
        userResponse.enqueue(new Callback<ArrayList<ImageUpload>>() {
            @Override
            public void onResponse(Call<ArrayList<ImageUpload>> call, Response<ArrayList<ImageUpload>> response) {
                 if (response.code()==200)
                 {
                     imagelist=response.body();
                     listAdaptor=new ListAdaptor(HomeActivity.this,response.body(),imagelist);
                     recyclerView.setAdapter(listAdaptor);
                     Log.i("response","listdata>>"+imagelist);
                 }
                 else {
                     Toast.makeText(getApplicationContext(),"List failed",Toast.LENGTH_SHORT).show();
                 }
            }

            @Override
            public void onFailure(Call<ArrayList<ImageUpload>> call, Throwable t) {
                   Toast.makeText(getApplicationContext(),"Please check your internet Connection",Toast.LENGTH_SHORT).show();
            }
        });
    }
}