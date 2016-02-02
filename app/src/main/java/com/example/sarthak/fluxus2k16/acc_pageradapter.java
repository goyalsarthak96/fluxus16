package com.example.sarthak.fluxus2k16;


import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentManager;


public class acc_pageradapter extends FragmentPagerAdapter {


    String cat[]=new String[]{"cultural","technical","informal","literary","quiz"};
    private String tabTitles[] = new String[] {"Policy","Fee","Register"};


    static FragmentManager manager;
    Context mContext;

    /*getcategoryinterface activitycommander=(getcategoryinterface);
    public interface getcategoryinterface
    {
        void return_category();
    }*/





    public acc_pageradapter(Context context) {

        super(manager);
        mContext=context;

    }


    public void getfm(FragmentManager fm)
    {
        manager=fm;
    }





    @Override
    public Fragment getItem(int position) {

        return acc_frag.newInstance(position);

    }






    @Override
    public int getCount() {
        return 3;

    }




    @Override
    public CharSequence getPageTitle(int position) {
        // Generate title based on item position
        return tabTitles[position];

    }

}
