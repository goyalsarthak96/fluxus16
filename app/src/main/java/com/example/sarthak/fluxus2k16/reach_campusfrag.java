package com.example.sarthak.fluxus2k16;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;



public class reach_campusfrag extends Fragment {

    public ViewPager viewPager;
    public PagerAdapter adapter;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.reach_campus,container,false);
        TabLayout tabLayout=(TabLayout)view.findViewById(R.id.reach_tablayout);
        viewPager=(ViewPager)view.findViewById(R.id.reach_viewpager);
        adapter=new reach_campus_pageradapter(getActivity().getBaseContext());
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);





        return view;
    }
}
