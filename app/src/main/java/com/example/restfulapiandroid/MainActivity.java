package com.example.restfulapiandroid;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.restfulapiandroid.adapters.MatchAdapter;
import com.example.restfulapiandroid.api.ApiClient;
import com.example.restfulapiandroid.api.ApiService;
import com.example.restfulapiandroid.api.MatchsResponse;
import com.example.restfulapiandroid.callbacks.OnMatchClickListener;
import com.example.restfulapiandroid.models.Match;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements OnMatchClickListener, View.OnClickListener {
    private static final String TAG = "MainActivity";
    private MatchAdapter adapter;
    private RecyclerView recyclerView;
    private EditText edt_pesqu;
    private Button btn_pesq;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.posts_recycler);
        edt_pesqu = findViewById(R.id.edt_pesq);
        btn_pesq = findViewById(R.id.btn_pesq);
        getPost();

        btn_pesq.setOnClickListener(this);

    }


    private void getPost() {
        ApiService service = ApiClient.getService();
        service.getAllPosts().enqueue(new Callback<MatchsResponse>() {
            @Override
            public void onResponse(@NonNull Call<MatchsResponse> call, @NonNull Response<MatchsResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    // fetch data from api is success
                    //for (Match post : response.body().getMatches()) {
                    //   Log.i(TAG, "onResponse" + post);
                    //}
                    updateUI(response.body().getMatches());
                }
            }

            @Override
            public void onFailure(@NonNull Call<MatchsResponse> call, @NonNull Throwable t) {
                Toast.makeText(MainActivity.this, "" + t.getMessage(), Toast.LENGTH_SHORT).show();
                Log.e(TAG, "onFailure: ", t);
            }
        });
    }

    private void updateUI(List<Match> matches) {
        adapter = new MatchAdapter(matches, this); // this means onPostClick tha we have implements
        recyclerView.setAdapter(adapter);
    }


    @Override
    public void onPostClick(int postId) {
        Intent showDetails = new Intent(this, MatchDetailsActivity.class);
        showDetails.putExtra(MatchDetailsActivity.POST_ID, postId);
        startActivity(showDetails);


    }

    @Override
    public void onClick(View view) {

        String name_recipe = edt_pesqu.getText().toString();

        ApiService service = ApiClient.getService();
        service.getMatch(name_recipe).enqueue(new Callback<MatchsResponse>() {
            @Override
            public void onResponse(Call<MatchsResponse> call, Response<MatchsResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    // fetch data from api is success
                    //for (Match post : response.body().getMatches()) {
                    //    Log.i(TAG, "onResponse" + post);
                    //}
                    updateUI(response.body().getMatches());
                }
            }

            @Override
            public void onFailure(Call<MatchsResponse> call, Throwable t) {

            }
        });

    }
}
