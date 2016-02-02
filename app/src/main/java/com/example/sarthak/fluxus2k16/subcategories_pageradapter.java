package com.example.sarthak.fluxus2k16;


import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentManager;





public class subcategories_pageradapter extends FragmentPagerAdapter {


    final int[] PAGE_COUNT = {5,3,1,1,1,1};
    String cat[]=new String[]{"cultural","technical","informal","quiz","literary"};
    private String tabTitles[][] = new String[][] {
                                        { "Dance Prix", "Dramatics", "Music","Painting","Photography"},
                                        { "Mechanical","Electrical", "Programming" },
                                        { "Informal"},
                                        { "Quiz"},
                                        { "Literary"},
                                                    };

    Context mcontext;
    int index;


    /*getcategoryinterface activitycommander=(getcategoryinterface);
    public interface getcategoryinterface
    {
        void return_category();
    }*/





    public subcategories_pageradapter(FragmentManager fm, Context context, int index1) {
        super(fm);
        mcontext=context;
        index=index1;

    }





    @Override
    public Fragment getItem(int position) {

        return subcategories_frag.newInstance(position, index, mcontext);

    }



    @Override
    public int getCount() {
        return PAGE_COUNT[index];

    }




    @Override
    public CharSequence getPageTitle(int position) {
        // Generate title based on item position
        return tabTitles[index][position];

    }

}
