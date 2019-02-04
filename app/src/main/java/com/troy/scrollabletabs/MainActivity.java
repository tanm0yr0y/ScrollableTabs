package com.troy.scrollabletabs;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    public static final int NUM_OF_PAGE = 3;
    ViewPager viewPager = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager = findViewById(R.id.pager);
        FragmentManager fragmentManager = getSupportFragmentManager();
        viewPager.setAdapter(new MyAdapter(fragmentManager));
    }

    class MyAdapter extends FragmentStatePagerAdapter {



        public MyAdapter(FragmentManager fm)  {
            super(fm);
        }

        @Override
        public Fragment getItem(int i) {

            Fragment fragment = null;

            if(i == 0) {
                fragment = new FragmentA();
            }
            else if(i == 1) {
                fragment = new FragmentB();
            }
            else if(i == 2) {
                fragment = new FragmentC();
            }

            return fragment;
        }

        @Override
        public int getCount() {
            Log.d("RRR", "getCount called");
            return NUM_OF_PAGE;
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {

            if(position == 0) {
                return "Fragment A";
            }
            if(position == 1) {
                return "Fragment B";
            }
            if(position == 2) {
                return "Fragment C";
            }
            return null;
        }
    }
}
