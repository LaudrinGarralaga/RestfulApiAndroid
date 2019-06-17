package com.example.restfulapiandroid.api;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.PATCH;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by ixi.Dv on 09/11/2018.
 * Email : feedback.mrzero@gmail.com
 */
public interface ApiService {
    /**
     * get All post
     */
    @GET("/v1/api/recipes?_app_id=6ac28980&_app_key=5443b0900f2ec4b050ac04c63a39aae7")
    Call<MatchsResponse> getAllPosts();

    /**
     * getPost by id
     */

    @GET("/resfulapiandroid/v1/posts/{id}")
    Call<MatchsResponse> getPost(
            @Path("id") int postId);

    @GET("/v1/api/recipes?_app_id=6ac28980&_app_key=5443b0900f2ec4b050ac04c63a39aae7")
    @Headers("Accept:application/json")
    Call<MatchsResponse> getMatch(@Query(value="q") String name_recipe);

}
