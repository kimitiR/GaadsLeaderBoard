package com.example.leaderboad.Api;

import com.example.leaderboad.Model.Hours;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GetInteface {
    @GET("/api/hours")
    Call<List<Hours>> getTop20();
}
