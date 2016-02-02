package com.example.sarthak.fluxus2k16;


import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.graphics.Color;
import android.os.Handler;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.menu.ActionMenuItemView;
import android.support.v7.widget.Toolbar;
import android.view.Display;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;


public class schedule extends AppCompatActivity implements schedule_frag.clicklistener{


    String category="All";
    ViewPager viewPager;
    schedule_list_adapter adapters[]=new schedule_list_adapter[3];
    ListView listview_list[]=new ListView[3];
    ArrayList<String>[] valid_string_list=new ArrayList[3];

    ImageView im,im1,im2;

    static CoordinatorLayout cor_layout;
    static RelativeLayout schedule_layout;

    static FloatingActionButton fab1;
    static FloatingActionButton fab2;
    static FloatingActionButton fab3;
    static FloatingActionButton fab4;

    private FloatingActionMenu main_fab;

    private List<FloatingActionMenu> menus = new ArrayList<>();
    private Handler mUiHandler = new Handler();

    int im_array[]={R.drawable.day1,R.drawable.day2,R.drawable.day3};


    static Toolbar toolbar;

    int height,width;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_schedule);


        Display display = getWindowManager().getDefaultDisplay();
        height = display.getHeight();
        width = display.getWidth();


        toolbar=(Toolbar)findViewById(R.id.schedule_toolbar);
        //setActionBar(toolbar);
        toolbar.setBackgroundColor(Color.TRANSPARENT);
        toolbar.setTitleTextColor(Color.WHITE);
        //toolbar.setAlpha(0.5f);
        //toolbar.setTitle("Schedule");






        viewPager=(ViewPager)findViewById(R.id.viewpager2);
        final schedule_pager_adapter adap=new schedule_pager_adapter(getSupportFragmentManager(),getBaseContext(),category);
        viewPager.setAdapter(adap);
        viewPager.setHorizontalScrollBarEnabled(true);





        FloatingActionMenu menuDown = (FloatingActionMenu) findViewById(R.id.menu_down);

        menus.add(menuDown);

        menuDown.hideMenuButton(false);





        main_fab=(FloatingActionMenu)findViewById(R.id.menu_down);
        fab1=(FloatingActionButton)findViewById(R.id.fab1);
        fab2=(FloatingActionButton)findViewById(R.id.fab2);
        fab3=(FloatingActionButton)findViewById(R.id.fab3);
        fab4=(FloatingActionButton)findViewById(R.id.fab4);

        fab1.setVisibility(View.GONE);
        fab2.setVisibility(View.GONE);
        fab3.setVisibility(View.GONE);
        fab4.setVisibility(View.GONE);


        fab1.setOnClickListener(clickListener);
        fab2.setOnClickListener(clickListener);
        fab3.setOnClickListener(clickListener);
        fab4.setOnClickListener(clickListener);


        cor_layout=(CoordinatorLayout)findViewById(R.id.schedule_cord_lay);
        schedule_layout=(RelativeLayout)findViewById(R.id.event_list_layout);




        int delay = 400;
        for (final FloatingActionMenu menu : menus) {
            mUiHandler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    menu.showMenuButton(true);
                }
            }, delay);
            delay += 150;
        }


        im=(ImageView)findViewById(R.id.title_im);

        im1=(ImageView)findViewById(R.id.front);
        im2=(ImageView)findViewById(R.id.back);

        im1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(viewPager.getCurrentItem()==0)
                viewPager.setCurrentItem(1);
                else if(viewPager.getCurrentItem()==1)
                    viewPager.setCurrentItem(2);
            }
        });

        im2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(viewPager.getCurrentItem()==1)
                    viewPager.setCurrentItem(0);
                else if(viewPager.getCurrentItem()==2)
                    viewPager.setCurrentItem(1);
            }
        });
        //im1.setAlpha(0.2f);
        //im2.setAlpha(0.2f);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                if(position==0) {
                    im2.setVisibility(View.INVISIBLE);
                    im1.setVisibility(View.VISIBLE);
                }else if(position==1){
                    im1.setVisibility(View.VISIBLE);
                    im2.setVisibility(View.VISIBLE);
                }else {
                    im1.setVisibility(View.INVISIBLE);
                    im2.setVisibility(View.VISIBLE);
                }
                Glide.with(getBaseContext()).load(im_array[position]).into(im);
                Glide.with(getBaseContext()).load(R.drawable.front).into(im1);
                Glide.with(getBaseContext()).load(R.drawable.back).into(im2);


            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });


    }





    private View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String text = "";

            switch (v.getId()) {
                case R.id.fab1:
                    text = fab1.getLabelText();
                    break;
                case R.id.fab2:
                    text = fab2.getLabelText();
                    break;
                case R.id.fab3:
                    text = fab3.getLabelText();
                    break;
                case R.id.fab4:
                    text= fab4.getLabelText();
                    break;

            }
            category=text;
            schedule_frag dummy_frag=new schedule_frag();
            dummy_frag.update_category(category);

            for(int var=0;var<3;var++)
                dummy_frag.data_change(var,category, getBaseContext(), adapters[var], valid_string_list[var],listview_list[var]);

            normal_background();
            main_fab.close(true);

        }
    };









    @Override
    public void return_adapter(int page_no,schedule_list_adapter adapter,ArrayList<String> list1,ListView id) {
        adapters[page_no]=adapter;
        valid_string_list[page_no]=list1;
        listview_list[page_no]=id;

    }







    public void fade_background()
    {
        schedule_layout.setClickable(false);
        fab1.setVisibility(View.VISIBLE);
        fab2.setVisibility(View.VISIBLE);
        fab3.setVisibility(View.VISIBLE);
        fab4.setVisibility(View.VISIBLE);


        schedule_layout.setAlpha(0.2f);
        toolbar.setAlpha(0.2f);
    }


    public void normal_background()
    {
        schedule_layout.setClickable(true);
        fab1.setVisibility(View.GONE);
        fab2.setVisibility(View.GONE);
        fab3.setVisibility(View.GONE);
        fab4.setVisibility(View.GONE);


        schedule_layout.setAlpha(1.0f);
        toolbar.setAlpha(1.0f);
    }
}
