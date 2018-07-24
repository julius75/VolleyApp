package com.chain.volleyapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

public class SuggestionListActivity extends AppCompatActivity {
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suggestion_list);

        //toolbar = findViewById(R.id.t


        setSupportActionBar(toolbar);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.add_new,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.add:
                Intent intent = new Intent(SuggestionListActivity.this,MainActivity.class);
                startActivity(intent);
                finish(); //get rid of previous activities not to stack them on top of each other

                break;
            case R.id.logout:
                //mAuth.signOut();
                Intent out = new Intent(SuggestionListActivity.this,LoginActivity.class);
                startActivity(out);
                finish();

        }
        return super.onOptionsItemSelected(item);
    }
}
