package com.example.sarthak.fluxus2k16;


import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentManager;





public class reach_campus_pageradapter extends FragmentPagerAdapter {


    final int PAGE_COUNT = 3;
    private String tabTitles[] = new String[] { "By Air", "By Rail", "By Road" };
    Context mcontext;

    static FragmentManager manager;

    /*getcategoryinterface activitycommander=(getcategoryinterface);
    public interface getcategoryinterface
    {
        void return_category();
    }*/





    public reach_campus_pageradapter( Context context) {
        super(manager);
        mcontext=context;

    }



    public void getfm(FragmentManager fm)
    {
        manager=fm;
    }





    @Override
    public Fragment getItem(int position) {

        return reach_campus_pagerfrag.newInstance(position,mcontext);

    }



    @Override
    public int getCount() {
        return PAGE_COUNT;

    }




    @Override
    public CharSequence getPageTitle(int position) {
        // Generate title based on item position
        return tabTitles[position];

    }

}
