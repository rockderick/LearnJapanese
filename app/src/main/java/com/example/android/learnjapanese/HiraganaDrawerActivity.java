package com.example.android.learnjapanese;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.example.android.learnjapanese.logic.Hiragana;
import com.example.android.learnjapanese.logic.HiraganaList;

import java.util.ArrayList;
import java.util.List;

public class HiraganaDrawerActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {


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
        setContentView(R.layout.activity_hiraga_drawer);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        ActionBar ab = getSupportActionBar();
        // Enable the Up button
        ab.setDisplayHomeAsUpEnabled(true);


        /*FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        HiraganaList hiraganaList = new HiraganaList();
        Hiragana character;


        mPager = (ViewPager) findViewById(R.id.pager);



        mPagerAdapter= new HiraganaSlidePagerAdapter(getSupportFragmentManager());
        for(int i=0;i<hiraganaList.getHiraganaList().size();i++) {
            character= hiraganaList.getHiraganaList().get(i);
            mPagerAdapter.addFragment(HiraganaSlidePageFragment.newInstance(i,character.getReading(),character.getImage(),
                    character.getNmemonic(),character.getSound()));

        }

        mPager.setAdapter(mPagerAdapter);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }

        // Return to previous page when we press back button
        if (this.mPager.getCurrentItem() == 0)
            super.onBackPressed();
        else
            this.mPager.setCurrentItem(this.mPager.getCurrentItem() - 1);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.hiraga_drawer, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        /*if (id == R.id.action_settings) {
            return true;
        }*/

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.

        int id = item.getItemId();

        if (id == R.id.a_o) {
            mPager.setCurrentItem(0);
        } else if (id == R.id.ka_ko) {
            mPager.setCurrentItem(5);
        } else if (id == R.id.sa_so) {
            mPager.setCurrentItem(10);
        } else if (id == R.id.ta_to) {
            mPager.setCurrentItem(15);
        } else if (id == R.id.na_no) {
            mPager.setCurrentItem(20);
        } else if (id == R.id.ha_ho) {
            mPager.setCurrentItem(25);
        } else if (id == R.id.ma_mo) {
            mPager.setCurrentItem(30);
        } else if (id == R.id.ya_yo) {
            mPager.setCurrentItem(35);
        } else if (id == R.id.ra_ro) {
            mPager.setCurrentItem(38);
        } else if (id == R.id.wa_wo) {
            mPager.setCurrentItem(43);
        } else if (id == R.id.n) {
            mPager.setCurrentItem(45);
        }




        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
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
