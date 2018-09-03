package com.chain.volleyapp;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity {
    android.support.v7.widget.Toolbar toolbarhome;
    private FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        toolbarhome = findViewById(R.id.main_toolbar);
        setSupportActionBar(toolbarhome);


        fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent suggestion = new Intent(HomeActivity.this,SuggestionActivity.class);
                startActivity(suggestion);

            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.bottom_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if(id ==R.id.home){
            Toast.makeText(this, "home", Toast.LENGTH_SHORT).show();

        }
        else if(id ==R.id.notification){
            Toast.makeText(this, "new feedback", Toast.LENGTH_SHORT).show();

        }
        else if(id ==R.id.account){

        }

        return super.onOptionsItemSelected(item);
    }
}
