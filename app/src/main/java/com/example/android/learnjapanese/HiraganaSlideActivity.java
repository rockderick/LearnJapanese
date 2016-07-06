package com.example.android.learnjapanese;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.widget.Toast;

import com.example.android.learnjapanese.logic.Hiragana;
import com.example.android.learnjapanese.logic.HiraganaList;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by rockderick on 15/06/16.
 */
public class HiraganaSlideActivity extends FragmentActivity {

    /**
     * The pager widget, which handles animation and allows swiping horizontally to access previous
     * and next wizard steps.
     */
    private ViewPager mPager;

    /**
     * The pager adapter, which provides the pages to the view pager widget.
     */
    private HiraganaSlidePagerAdapter mPagerAdapter;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hiragana_view_pager);

        HiraganaList hiraganaList = new HiraganaList();
        Hiragana character;
        // Instantiate a ViewPager and a PagerAdapter.
        mPager = (ViewPager) findViewById(R.id.pager);


        mPagerAdapter= new HiraganaSlidePagerAdapter(getSupportFragmentManager());
        for(int i=0;i<hiraganaList.getHiraganaList().size();i++) {
            character= hiraganaList.getHiraganaList().get(i);
            mPagerAdapter.addFragment(HiraganaSlidePageFragment.newInstance(i,character.getReading(),character.getImage(),
            character.getNmemonic(),character.getSound()));
        }


        mPager.setAdapter(mPagerAdapter);


    }





    // `onPostCreate` called when activity start-up is complete after `onStart()`

    // NOTE! Make sure to override the method with only a single `Bundle` argument

    @Override

    protected void onPostCreate(Bundle savedInstanceState) {

        super.onPostCreate(savedInstanceState);

    }



    public void onBackPressed() {

        // Return to previous page when we press back button
        if (this.mPager.getCurrentItem() == 0)
            super.onBackPressed();
        else
            this.mPager.setCurrentItem(this.mPager.getCurrentItem() - 1);

    }

    private class HiraganaSlidePagerAdapter extends FragmentStatePagerAdapter {

        // List of fragments which are going to set in the view pager widget
        List<Fragment> fragments;

        public HiraganaSlidePagerAdapter(FragmentManager fm) {
            super(fm);
            this.fragments = new ArrayList<Fragment>();
        }


        public void addFragment(Fragment fragment) {
            this.fragments.add(fragment);
        }

        @Override
        public Fragment getItem(int position) {
            return this.fragments.get(position);
        }

        @Override
        public int getCount() {
            return this.fragments.size();
        }
    }


}
