package com.example.bottomnavigation;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class Slider extends PagerAdapter {
    Context context;
    LayoutInflater inflater;
    public Slider(Context context) {
        this.context = context;
    }

    int images[] = {R.drawable.slide1, R.drawable.slide2, R.drawable.slide3};

    @Override
    public int getCount() {
        return images.length;
    }

    //return ra view linearLayout
    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return (view==(LinearLayout)o);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.slider,container,false);
        LinearLayout layoutSlide = (LinearLayout) view.findViewById(R.id.linearLayout);
        ImageView imageSlider = (ImageView) view.findViewById(R.id.imageSlider);
        imageSlider.setBackgroundResource(images[position]);
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((LinearLayout)object);
    }

}
