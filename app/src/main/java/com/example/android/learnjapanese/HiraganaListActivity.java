package com.example.android.learnjapanese;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.bumptech.glide.BitmapTypeRequest;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.GlideDrawableImageViewTarget;
import com.bumptech.glide.request.target.Target;
import com.example.android.learnjapanese.logic.Hiragana;
import com.example.android.learnjapanese.logic.HiraganaList;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rockderick on 19/07/16.
 */
public class HiraganaListActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hiraga_list_view);

        HiraganaList hiraganaList = new HiraganaList();

        ArrayAdapter<Hiragana> listAdapter = new HiraganaListAdapter(this, hiraganaList);

        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(listAdapter);
    }

}


class HiraganaListAdapter extends ArrayAdapter<Hiragana> {

    private final Activity mActivity;
    private final HiraganaList hiraganaList;
    private ImageView imageViewGif;
    private Hiragana character;

    HiraganaListAdapter(Activity activity, HiraganaList hiraganaList) {
        super(activity, R.layout.list_item, R.id.text_preview, hiraganaList.getHiraganaList());
        mActivity = activity;
        this.hiraganaList = hiraganaList;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = mActivity.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.list_item, null, true);
        TextView txtTitle = (TextView) rowView.findViewById(R.id.text_preview);
        character = hiraganaList.getHiraganaList().get(position);
        //ImageView imageView = (ImageView) rowView.findViewById(R.id.hiragana_gif_image);
        txtTitle.setText(character.getReading());

        //imageView.setImageResource(character.getImage());
        imageViewGif = (ImageView) rowView.findViewById(R.id.hiragana_gif_image);

        GlideDrawableImageViewTarget imageViewTarget = new GlideDrawableImageViewTarget(imageViewGif);
        Glide.clear(imageViewTarget);
        Glide
                .with(mActivity)
                .load(character.getImage()).asBitmap().into(imageViewGif);
        new LoadImageTask().execute();

        return rowView;
    }


    private class LoadImageTask extends AsyncTask<Void, Void, Void> {
        BitmapTypeRequest<Integer> integerBitmapTypeRequest;

        @Override
        protected Void doInBackground(Void... voids) {
            integerBitmapTypeRequest = Glide
                    .with(mActivity)
                    .load(character.getImage()).asBitmap();
            return null;
        }

        // onPostExecute displays the results of the AsyncTask.
        @Override
        protected void onPostExecute(Void result) {
            integerBitmapTypeRequest.into(imageViewGif);
        }

    }


}


