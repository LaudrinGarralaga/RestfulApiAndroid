package com.example.restfulapiandroid.api;

import com.example.restfulapiandroid.models.Match;

import java.util.List;

/**
 * Created by ixi.Dv on 09/11/2018.
 * Email : feedback.mrzero@gmail.com
 */
public class MatchsResponse {

    private String error;
    private List<Match> matches;

    public MatchsResponse(String error, List<Match> matches) {
        this.error = error;
        this.matches = matches;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public List<Match> getMatches() {
        return matches;
    }

    public void setMatches(List<Match> matches) {
        this.matches = matches;
    }
}
