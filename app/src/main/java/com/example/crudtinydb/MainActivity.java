package com.example.crudtinydb;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<AnimeModel>animeModels;
    TinyDB tinyDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tinyDB = new TinyDB(this);
        animeModels = new ArrayList<>();
        animeModels.addAll(tinyDB.getListObject("ARRAY_ANIME"));
        RecyclerView recyclerView  = findViewById(R.id.list_anime);
        AnimeAdapter animeAdapter = new AnimeAdapter(animeModels);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(animeAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menus,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.add_item:
                Intent intent = new Intent(MainActivity.this,AddAnimeActivity.class);
                startActivity(intent);
                finish();
            case R.id.remove_all:
                tinyDB.remove("ARRAY_ANIME");
                MainActivity.this.recreate();
        }
        return super.onOptionsItemSelected(item);
    }
}