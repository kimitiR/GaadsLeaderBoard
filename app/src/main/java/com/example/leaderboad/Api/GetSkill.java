package com.example.leaderboad.Api;

import com.example.leaderboad.Model.Hours;
import com.example.leaderboad.Model.Skill;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GetSkill {
    @GET("/api/skilliq")
    Call<List<Skill>> getSkills();
}

