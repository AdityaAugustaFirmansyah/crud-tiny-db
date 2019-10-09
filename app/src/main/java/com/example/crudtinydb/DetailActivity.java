package com.example.crudtinydb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class DetailActivity extends AppCompatActivity {

    EditText textViewTitle,textViewPhoto,textViewDescription;
    Button buttonDelete,buttonEdit;
    TinyDB tinyDB;
    int position;
    ArrayList<AnimeModel> animeModels;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);


        final AnimeModel animeModel = getIntent().getParcelableExtra("TAG_MODEL");
        tinyDB = new TinyDB(this);

        position = getIntent().getIntExtra("POSITION",0);
        textViewTitle = findViewById(R.id.title_anime_detail);
        textViewPhoto = findViewById(R.id.photo_anime_detail);
        textViewDescription = findViewById(R.id.description_anime_detail);
        buttonDelete = findViewById(R.id.btn_delete_detail);
        buttonEdit = findViewById(R.id.btn_edit_detail);

        animeModels= tinyDB.getListObject("ARRAY_ANIME");

        textViewTitle.setText(animeModel.getTitleAnime());
        textViewPhoto.setText(animeModel.getImgAnime());
        textViewDescription.setText(animeModel.getDescriptionAnime());

        buttonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                animeModels.remove(position);
                tinyDB.putListObject("ARRAY_ANIME",animeModels);
                Intent intent = new Intent(DetailActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        buttonEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AnimeModel model = new AnimeModel(animeModel.getIdAnime(),
                        textViewTitle.getText().toString().trim(),
                        textViewPhoto.getText().toString().trim(),
                        textViewDescription.getText().toString().trim());
                animeModels.set(position,model);
                tinyDB.putListObject("ARRAY_ANIME",animeModels);
                Intent intent = new Intent(DetailActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
