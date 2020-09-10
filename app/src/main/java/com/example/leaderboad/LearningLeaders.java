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
import com.example.leaderboad.Api.GetInteface;
import com.example.leaderboad.Model.Hours;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LearningLeaders extends Fragment {
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    ArrayList<Hours> myTo20List =new ArrayList<Hours>();
    LearningLeadersAdapter recyclerAdapter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_learnig_leaders, container, false);
//                super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        recyclerView =(RecyclerView)view.findViewById(R.id.recycler);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setLayoutManager(layoutManager);
        recyclerAdapter = new LearningLeadersAdapter(getContext(),myTo20List);
        recyclerView.setAdapter(recyclerAdapter);

        //init retrofit instance here
        GetInteface getInteface = GetClient.getClient().create(GetInteface.class);
        Call<List<Hours>> call = getInteface.getTop20();
        call.enqueue(new Callback<List<Hours>>() {
            @Override
            public void onResponse(Call<List<Hours>> call, Response<List<Hours>> response) {
                assert response.body() != null;
                myTo20List.addAll(response.body());
                Log.d("TAG","Response = "+myTo20List);
                recyclerAdapter.setTopList(myTo20List);
            }

            @Override
            public void onFailure(Call<List<Hours>> call, Throwable t) {
                Log.d("TAG","Response = "+t.toString());

                //now run and test the learning leaders fragment


            }
        });


    }
}