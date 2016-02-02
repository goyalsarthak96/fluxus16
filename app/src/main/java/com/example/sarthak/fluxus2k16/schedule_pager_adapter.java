package com.example.sarthak.fluxus2k16;


import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentManager;





public class schedule_pager_adapter extends FragmentPagerAdapter {


    final int PAGE_COUNT = 3;
    private String tabTitles[] = new String[] { "Day1", "Day2", "Day3" };
    static String category;
    Context mcontext;


    /*getcategoryinterface activitycommander=(getcategoryinterface);
    public interface getcategoryinterface
    {
        void return_category();
    }*/





    public schedule_pager_adapter(FragmentManager fm, Context context, String category1) {
        super(fm);
        mcontext=context;
        category=category1;
    }






    @Override
    public Fragment getItem(int position) {

        return schedule_frag.newInstance(position, category,mcontext);

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
