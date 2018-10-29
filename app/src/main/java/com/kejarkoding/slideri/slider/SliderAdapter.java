package com.kejarkoding.slideri.slider;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class SliderAdapter extends FragmentStatePagerAdapter {

    private static final String TAG = "SliderPagerAdapter";

    List<Fragment> mFrags = new ArrayList<>();

    public SliderAdapter(FragmentManager fm, List<Fragment>frags) {
        super(fm);
        mFrags = frags;
    }

    @Override
    public Fragment getItem(int i) {
        int index =  i % mFrags.size();
        Log.d(TAG, "position: " + i);
        Log.d(TAG, "index: " + index);
        return FragmentSlider.newInstance(mFrags.get(index).getArguments().getString("params"));
    }

    @Override
    public int getCount() {
        return Integer.MAX_VALUE;
    }
}
