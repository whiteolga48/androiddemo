package com.mariusapps.reshelloworld;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.mariusapps.reshelloworld.model.Comment;
import com.mariusapps.reshelloworld.model.JsonPlaceHolderApi;

import java.util.List;
import java.util.PriorityQueue;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {


    private TextView textViewResult;
    private JsonPlaceHolderApi jsonPlaceHolderApi;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewResult = findViewById(R.id.idTextviewResult);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://jsonplaceholder.typicode/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

                jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);

                getComments();



    }

        private void getComments(){


            Call<List<Comment>> call = jsonPlaceHolderApi.getComments(3);
            call.enqueue(new Callback<List<Comment>>() {


                @Override
                public void onResponse(Call<List<Comment>> call, Response<List<Comment>> response) {


                    if(!response.isSuccessful()){

                        textViewResult.setText("Code: " + response.code());

                        List<Comment> comments = response.body();

                        for (Comment comment : comments){

                            String content = "";
                            content +="ID: " + comment.getId() + "\n";
                            content +="Post_ID" + comment.getId() + "\n";


                        }

                    }

                }

                @Override
                public void onFailure(Call<List<Comment>> call, Throwable t) {

                }
            });



        }


}


