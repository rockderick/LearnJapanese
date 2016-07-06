package com.example.android.learnjapanese;

import android.content.Intent;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.GlideDrawableImageViewTarget;
import com.example.android.learnjapanese.logic.Hiragana;
import com.example.android.learnjapanese.logic.HiraganaList;

public class HiraganaActivity extends AppCompatActivity  implements
        GestureDetector.OnGestureListener,
        GestureDetector.OnDoubleTapListener{

    private String DEBUG_TAG="Gesture";
    private GestureDetectorCompat mDetector;
    private static int hiraganaIndex=0;
    private Hiragana character;
    private int imageResource;

    private static HiraganaList hiraganaList = new HiraganaList();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hiragana_screen_slide_page);

        mDetector = new GestureDetectorCompat(this,this);
        mDetector.setOnDoubleTapListener(this);

        Intent intent= getIntent();
        String value= intent.getStringExtra("HIRAGANA_READING");
        imageResource = intent.getIntExtra("HIRAGANA_IMAGE",R.raw.hiragana1);
        Log.d("Debug",imageResource+"");



        character = hiraganaList.getHiraganaList().get(hiraganaIndex);


        /*WebView myWebView = (WebView) findViewById(R.id.hiraga_web_view);
        //myWebView.loadUrl("http://www.fjmex.org/v2/multimedia/1364523838_hiraganaA.gif");
        Log.i(DEBUG_TAG,this.getApplicationContext().getFilesDir().toString());
        myWebView.loadUrl(character.getImageName());
        myWebView.getSettings().setLoadWithOverviewMode(true);
        myWebView.getSettings().setUseWideViewPort(true);*/

        ImageView imageViewGif  = (ImageView)findViewById(R.id.hiragana_gif_image);
        //String gifUrl = "http://www.fjmex.org/v2/multimedia/1364523838_hiraganaA.gif";
        String gifUrl = character.getImageName();
        GlideDrawableImageViewTarget imageViewTarget = new GlideDrawableImageViewTarget(imageViewGif);

        Glide
                .with( this )
                .load( imageResource )
                .into( imageViewTarget);


        TextView kanaTextView = (TextView) findViewById(R.id.kana_text_view);
        kanaTextView.setText(character.getReading()+"   "+character.getRomaji());

        TextView nmemonicTextView = (TextView) findViewById(R.id.nmemonic_text_view);
        nmemonicTextView.setText(character.getNmemonic());
    }


    @Override
    public boolean onTouchEvent(MotionEvent event){
        this.mDetector.onTouchEvent(event);
        // Be sure to call the superclass implementation
        return super.onTouchEvent(event);
    }


    @Override
    public boolean onDown(MotionEvent motionEvent) {
        return false;
    }

    @Override
    public void onShowPress(MotionEvent motionEvent) {

    }

    @Override
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX,
                            float distanceY) {
        Log.d(DEBUG_TAG, "onScroll: " + e1.toString()+e2.toString());

        return true;
    }

    @Override
    public void onLongPress(MotionEvent motionEvent) {

    }

    @Override
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
        Log.d(DEBUG_TAG, "onFling: " + motionEvent.toString());
        nextHiragana();
        return true;

    }

    @Override
    public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
        Log.d(DEBUG_TAG, "onSingleTapConfirmed: " + motionEvent.toString());
        return true;
    }

    @Override
    public boolean onDoubleTap(MotionEvent motionEvent) {
        return false;
    }

    @Override
    public boolean onDoubleTapEvent(MotionEvent motionEvent) {
        return false;
    }


    private void nextHiragana(){
        /*if(hiraganaIndex <  hiraganaList.getHiraganaList().size()-1) {
            hiraganaIndex++;

            character = hiraganaList.getHiraganaList().get(hiraganaIndex);

            WebView myWebView = (WebView) findViewById(R.id.hiraga_web_view);
            myWebView.loadUrl(character.getImageName());

            TextView kanaTextView = (TextView) findViewById(R.id.kana_text_view);
            kanaTextView.setText(character.getReading()+"   "+character.getRomaji());

            TextView nmemonicTextView = (TextView) findViewById(R.id.nmemonic_text_view);
            nmemonicTextView.setText(character.getNmemonic());
        }*/
        if(hiraganaIndex <  hiraganaList.getHiraganaList().size()-1) {

            hiraganaIndex++;

            character = hiraganaList.getHiraganaList().get(hiraganaIndex);

            TextView kanaTextView = (TextView) findViewById(R.id.kana_text_view);
            kanaTextView.setText(character.getReading()+"   "+character.getRomaji());

            ImageView imageViewGif = (ImageView) findViewById(R.id.hiragana_gif_image);
            //String gifUrl = "http://www.fjmex.org/v2/multimedia/1364523838_hiraganaA.gif";

            GlideDrawableImageViewTarget imageViewTarget = new GlideDrawableImageViewTarget(imageViewGif);

            Glide
                    .with(this)
                    .load(character.getImage())
                    .into(imageViewTarget);

            TextView nmemonicTextView = (TextView) findViewById(R.id.nmemonic_text_view);
            nmemonicTextView.setText(character.getNmemonic());

        }

    }
}
