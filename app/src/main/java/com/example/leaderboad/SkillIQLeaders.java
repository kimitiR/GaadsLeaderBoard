package com.example.leaderboad;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.leaderboad.Api.GetClient;
import com.example.leaderboad.Api.GetSkill;
import com.example.leaderboad.Model.Skill;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SkillIQLeaders extends Fragment {
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    ArrayList<Skill> topSkills =new ArrayList<Skill>();
    SkillRecAdapter recyclerAdapter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_skill_i_q_leaders, container, false);
//                super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        recyclerView =(RecyclerView)view.findViewById(R.id.recycler);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setLayoutManager(layoutManager);
        recyclerAdapter = new SkillRecAdapter(getContext(),topSkills);
        recyclerView.setAdapter(recyclerAdapter);

        GetSkill getSkill = GetClient.getClient().create(GetSkill.class);
        Call<List<Skill>> call = getSkill.getSkills();
        call.enqueue(new Callback<List<Skill>>() {
            @Override
            public void onResponse(Call<List<Skill>> call, Response<List<Skill>> response) {
                topSkills.addAll(response.body());
                Log.d("TAG","Response = "+topSkills);
                recyclerAdapter.setSkillList(topSkills);
            }

            @Override
            public void onFailure(Call<List<Skill>> call, Throwable t) {
                Log.d("TAG","Response = "+t.toString());

            }
        });
    }
}