package com.example.leaderboad;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.leaderboad.Api.MyPostClient;
import com.example.leaderboad.Api.PostApi;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SubmitActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submit);
        final EditText mFirstName = findViewById(R.id.txt_FirstName);
        final EditText mLastName = findViewById(R.id.txt_LastName);
        final EditText mEmail = findViewById(R.id.txt_email);
        final EditText mGithubLink = findViewById(R.id.txt_github);
        final Button btnSubmit = findViewById(R.id.submit_area);
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String firstName = mFirstName.getText().toString().trim();
                final String lastName = mLastName.getText().toString().trim();
                final String eMail = mEmail.getText().toString().trim();
                final  String projectLink = mGithubLink.getText().toString().trim();
                if(!TextUtils.isEmpty(firstName) && !TextUtils.isEmpty(lastName) &&
                        !TextUtils.isEmpty(eMail) && !TextUtils.isEmpty(projectLink)){
                    final AlertDialog.Builder dialog = new AlertDialog.Builder(SubmitActivity.this);
                    LayoutInflater inflater = getLayoutInflater();

                    View sview = inflater.inflate(R.layout.alert, null);
                    Button btnYes = sview.findViewById(R.id.btn_yes);
                    dialog.setView(sview);
                    ImageButton imgClose = sview.findViewById(R.id.img_cancel);
                    final Dialog dialogs = dialog.create();

                    dialogs.show();
                    btnYes.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            sendPost(firstName,lastName,eMail,projectLink);
                            dialogs.cancel();
                        }
                    });
                    imgClose.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            dialogs.cancel();
                        }
                    });
                }
                else{
                    Toast.makeText(SubmitActivity.this,"Please fill all required fields",Toast.LENGTH_LONG).show();
                }
            }
        });


    }
    public void sendPost(String firstName,String lastName,String eMail,String linkToProject){
        PostApi submitApi = MyPostClient.getClient().create(PostApi.class);
        Call<Void> call = submitApi.postSubmission(firstName,lastName,eMail,linkToProject);
        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if(response.isSuccessful()){
                    Log.d("Successful","this request was successful");
                    Toast.makeText(SubmitActivity.this,"this request was successful",Toast.LENGTH_LONG).show();
                }
                else{
                    Toast.makeText(SubmitActivity.this,"this request was NOT successful",Toast.LENGTH_LONG).show();
                }
//
//                final AlertDialog.Builder dialog = new AlertDialog.Builder(SubmitActivity.this);
//                LayoutInflater inflater = getLayoutInflater();
//
//                View view = inflater.inflate(R.layout.fail, null);
//                final Dialog dialogs = dialog.create();
//
//                dialogs.show();
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
//
//                final AlertDialog.Builder dialog = new AlertDialog.Builder(SubmitActivity.this);
//                LayoutInflater inflater = getLayoutInflater();
//
//                View view = inflater.inflate(R.layout.success, null);
//                final Dialog dialogs = dialog.create();
//
//                dialogs.show();
            }
        });
        ImageView imageView = findViewById(R.id.backPress);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SubmitActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
}