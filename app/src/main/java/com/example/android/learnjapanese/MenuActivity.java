package com.example.android.learnjapanese;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.speech.RecognizerIntent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Locale;

public class MenuActivity extends AppCompatActivity {

    protected static final int REQUEST_OK = 1;
    private final int REQ_CODE_SPEECH_INPUT = 100;

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

    public void startQuiz(View view) {
        /*Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,
                RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, "ja");
        intent.putExtra(RecognizerIntent.EXTRA_PROMPT,
                "Di algo");
        try {
            startActivityForResult(intent, REQ_CODE_SPEECH_INPUT);
        } catch (ActivityNotFoundException a) {

        }*/

        Intent intent = new Intent(this, PronounceTestActivity.class);
        startActivity(intent);

    }


    /**
     * Receiving speech input
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode) {
            case REQ_CODE_SPEECH_INPUT: {
                if (resultCode == RESULT_OK && null != data) {

                    ArrayList<String> result = data
                            .getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                    Log.v("LEARN_JAPANESE", result.get(0));
                }
                break;
            }

        }
    }


}
