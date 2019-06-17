package com.example.restfulapiandroid;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.restfulapiandroid.api.ApiClient;
import com.example.restfulapiandroid.api.ApiService;
import com.example.restfulapiandroid.api.MatchsResponse;
import com.example.restfulapiandroid.models.Match;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MatchDetailsActivity extends AppCompatActivity {
    public static final String POST_ID = "post_id";
    private TextView postContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_details);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        postContent = findViewById(R.id.tv_post_content);
        int postID = getIntent().getIntExtra(POST_ID, 1);

        getPostDetails(postID);
    }

    private void getPostDetails(int postID) {
        // make new call to get post details
        ApiService service = ApiClient.getService();
        service.getPost(postID)
                .enqueue(new Callback<MatchsResponse>() {
                    @Override
                    public void onResponse(@NonNull Call<MatchsResponse> call, @NonNull Response<MatchsResponse> response) {
                        if (response.isSuccessful() && response.body() != null) {
                            Match match = response.body().getMatches().get(0); // we get one match
                            updateUI(match);
                        }
                    }

                    @Override
                    public void onFailure(@NonNull Call<MatchsResponse> call, @NonNull Throwable t) {
                        Toast.makeText(MatchDetailsActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
    }

    private void updateUI(Match match) {

        ((CollapsingToolbarLayout) findViewById(R.id.toolbar_layout))
                .setTitle(match.getRecipeName());
        ImageView thumb = findViewById(R.id.post_thumbnail);
        Glide.with(thumb)
                .load(match.getSmallImageUrls().get(0))
                .into(thumb);
        postContent.setText(match.getSourceDisplayName());
    }
}
