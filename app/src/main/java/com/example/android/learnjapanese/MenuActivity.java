package com.example.android.learnjapanese;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

    }


    public void learnHiragana(View view){
        startActivity(new Intent(this, HiraganaDrawerActivity.class));
    }

    public void quickReference(View view){
        //startActivity(new Intent(this, HiraganaTableActivity.class));
        startActivity(new Intent(this, HiraganaListActivity.class));
    }
}
