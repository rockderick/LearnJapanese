package com.example.android.learnjapanese;

import android.media.MediaPlayer;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.GlideDrawableImageViewTarget;
import com.example.android.learnjapanese.logic.Hiragana;
import com.example.android.learnjapanese.logic.HiraganaList;

/**
 * Created by rockderick on 15/06/16.
 */
public class HiraganaSlidePageFragment extends Fragment {


    private int index;
    private String yomigana;
    private String image;
    private int imageId;
    private String nmemonic;
    private int sound;
    private Hiragana character;
    private static HiraganaList hiraganaList = new HiraganaList();




    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


        this.index = (getArguments() != null) ? getArguments().getInt("INDEX")
                : -1;
        this.yomigana = (getArguments() != null) ? (String) getArguments().getCharSequence("YOMIGANA")
                : "";
        this.imageId = (getArguments() != null) ? getArguments().getInt("IMAGE")
                : R.raw.hiragana1;
        this.nmemonic = (getArguments() != null) ? (String) getArguments().getCharSequence("NMEMONIC")
                : "";
        this.sound = (getArguments() != null) ?  getArguments().getInt("SOUND")
                : R.raw.a;


    }

    public static HiraganaSlidePageFragment newInstance(int index,String romaji, String image,String nmemonic,int sound) {

        // Instantiate a new fragment
        HiraganaSlidePageFragment fragment = new HiraganaSlidePageFragment();

        // Save the parameters
        Bundle bundle = new Bundle();
        bundle.putInt("INDEX", index);
        bundle.putCharSequence("YOMIGANA",romaji);
        bundle.putCharSequence("IMAGE",image);
        bundle.putCharSequence("NMEMONIC",nmemonic);
        bundle.putInt("SOUND",sound);
        fragment.setArguments(bundle);
        fragment.setRetainInstance(true);
         //hiraganaIndex=index;


        return fragment;
    }


    public static HiraganaSlidePageFragment newInstance(int index,String romaji, int image,String nmemonic,int sound) {

        // Instantiate a new fragment
        HiraganaSlidePageFragment fragment = new HiraganaSlidePageFragment();

        // Save the parameters
        Bundle bundle = new Bundle();
        bundle.putInt("INDEX", index);
        bundle.putCharSequence("YOMIGANA",romaji);
        bundle.putInt("IMAGE",image);
        bundle.putCharSequence("NMEMONIC",nmemonic);
        bundle.putInt("SOUND",sound);
        fragment.setArguments(bundle);
        fragment.setRetainInstance(true);
        //hiraganaIndex=index;


        return fragment;
    }


        @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.hiragana_screen_slide_page, container, false);





        TextView kanaTextView = (TextView) rootView.findViewById(R.id.kana_text_view);
        kanaTextView.setText(yomigana);

        ImageView imageViewGif  = (ImageView)rootView.findViewById(R.id.hiragana_gif_image);

        GlideDrawableImageViewTarget imageViewTarget = new GlideDrawableImageViewTarget(imageViewGif);
        Glide.clear(imageViewTarget);
        Glide
            .with( this )
            .load( imageId )
             .into( imageViewTarget);


        TextView nmemonicTextView = (TextView) rootView.findViewById(R.id.nmemonic_text_view);
        nmemonicTextView.setText(nmemonic);

        ImageButton playButton = (ImageButton) rootView.findViewById(R.id.play_button);

            playButton.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                   Log.d("Debug","click");
                }
            });

         return rootView;
    }




}
