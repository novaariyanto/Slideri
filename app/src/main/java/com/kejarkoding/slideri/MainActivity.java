package com.kejarkoding.slideri;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;

import com.kejarkoding.slideri.slider.FragmentSlider;
import com.kejarkoding.slideri.slider.SlideIndicator;
import com.kejarkoding.slideri.slider.SliderAdapter;
import com.kejarkoding.slideri.slider.SliderView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private SliderAdapter mAdapter;
    private SlideIndicator mIndicator;

    private SliderView sliderView;
    private LinearLayout mLinearLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sliderView = (SliderView) findViewById(R.id.sliderView);
        mLinearLayout = (LinearLayout) findViewById(R.id.pagesContainer);
        setupSlider();
    }
    private void setupSlider() {
        sliderView.setDurationScroll(800);
        List<Fragment> fragments = new ArrayList<>();
        fragments.add(FragmentSlider.newInstance("https://image.tmdb.org/t/p/w250_and_h281_bestv2/zYFQM9G5j9cRsMNMuZAX64nmUMf.jpg"));
        fragments.add(FragmentSlider.newInstance("https://image.tmdb.org/t/p/w250_and_h281_bestv2/rXBB8F6XpHAwci2dihBCcixIHrK.jpg"));
        fragments.add(FragmentSlider.newInstance("https://image.tmdb.org/t/p/w250_and_h141_bestv2/biN2sqExViEh8IYSJrXlNKjpjxx.jpg"));
        fragments.add(FragmentSlider.newInstance("https://image.tmdb.org/t/p/w250_and_h141_bestv2/o9OKe3M06QMLOzTl3l6GStYtnE9.jpg"));

        mAdapter = new SliderAdapter(getSupportFragmentManager(), fragments);
        sliderView.setAdapter(mAdapter);
        mIndicator = new SlideIndicator(this, mLinearLayout, sliderView, R.drawable.indicator_slider);
        mIndicator.setPageCount(fragments.size());
        mIndicator.show();
    }
}
