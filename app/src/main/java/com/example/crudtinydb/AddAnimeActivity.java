package com.example.crudtinydb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class AddAnimeActivity extends AppCompatActivity {

    EditText edtTitle,edtDescription,edtPhoto;
    Button btnSubmit;
    TinyDB tinyDB;

    String title;
    String photo;
    String description;
    ArrayList<AnimeModel>animeModels;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_anime);

        tinyDB = new TinyDB(this);
        findItem();
        animeModels = new ArrayList<>();

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                title = edtTitle.getText().toString().trim();
                photo = edtPhoto.getText().toString().trim();
                description = edtDescription.getText().toString().trim();

                AnimeModel animeModel = new AnimeModel("2",title,photo,description);
                animeModels.add(animeModel);
                tinyDB.putListObject("ARRAY_ANIME",animeModels);

                Intent intent = new Intent(AddAnimeActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    public void findItem(){
        btnSubmit = findViewById(R.id.btn_submit);
        edtTitle = findViewById(R.id.edt_title);
        edtDescription = findViewById(R.id.edt_description);
        edtPhoto = findViewById(R.id.edt_img);
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(AddAnimeActivity.this,MainActivity.class);
        startActivity(intent);
        finish();
    }
}