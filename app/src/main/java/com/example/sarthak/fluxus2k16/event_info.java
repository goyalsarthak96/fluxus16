package com.example.sarthak.fluxus2k16;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.Window;
import android.support.v7.graphics.Palette;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


import com.bumptech.glide.Glide;

public class event_info extends AppCompatActivity {



    LinearLayout layout1,layout2,layout3;
    LinearLayout venue;
    AppBarLayout app_bar_layout;
    CoordinatorLayout layout;
    int mutedColor;
    String data[];
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_event_info);





        String table_name=getIntent().getStringExtra("table_name");
        String name=getIntent().getStringExtra("eve_name");
        int image_id=getIntent().getIntExtra("image_id",0);


        //getSupportActionBar().hide();


        layout=(CoordinatorLayout)findViewById(R.id.coordinate_lay);







        final CollapsingToolbarLayout collapsingToolbarLayout=(CollapsingToolbarLayout)findViewById(R.id.collapse_toolbar);
        collapsingToolbarLayout.setTitle(name);
        collapsingToolbarLayout.setCollapsedTitleTextColor(Color.WHITE);
        collapsingToolbarLayout.setExpandedTitleColor(Color.WHITE);


        app_bar_layout=(AppBarLayout)findViewById(R.id.app_bar_layout);
        app_bar_layout.setBackgroundColor(Color.TRANSPARENT);




        layout1=(LinearLayout) findViewById(R.id.card_linear_layout1);
        layout2=(LinearLayout) findViewById(R.id.card_linear_layout2);
        layout3=(LinearLayout) findViewById(R.id.card_linear_layout3);
        venue=(LinearLayout)findViewById(R.id.venue);













        Database db=new Database(getBaseContext());
        data=db.getEventInfo(name,table_name);
        fill_data(layout1,"{Description}"+data[0]);
        fill_data(layout2,"{Rules}"+data[1]);
        fill_data(layout3,"{Prizes}"+data[8]+"{Contact}"+data[6]+" "+data[7]);
        fill_data(venue,"{Venue}"+data[5]);









       /* ObjectAnimator objectAnimator1=ObjectAnimator.ofFloat(card1,"cardElevation",4.0f,15.0f);
        ObjectAnimator objectAnimator2=ObjectAnimator.ofFloat(card2,"cardElevation",4.0f,15.0f);
        ObjectAnimator objectAnimator3=ObjectAnimator.ofFloat(event_card,"cardElevation",4.0f,15.0f);
        AnimatorSet animatorSet=new AnimatorSet();
        animatorSet.playTogether(objectAnimator1,objectAnimator2,objectAnimator3);
        animatorSet.setDuration(2000);
        animatorSet.start();*/



        /*if(savedInstanceState==null)
        {
            ViewTreeObserver observer = layout.getViewTreeObserver();
            observer.addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
                @Override
                public boolean onPreDraw() {

                    layout.getViewTreeObserver().removeOnPreDrawListener(this);


                        ObjectAnimator animator1 = ObjectAnimator.ofFloat(layout, "alpha",  0f, 1f);
                    animator1.setDuration(1000);
                    animator1.start();


                    ObjectAnimator animator = ObjectAnimator.ofFloat(layout, "rotationY",  90f, 0f);
                    animator.setDuration(1000);
                    animator.start();

                    return true;
                }
            });
        }*/






        //viewPager=(ViewPager)findViewById(R.id.categories_viewpager);
        //final pager_adapter adap=new pager_adapter(getSupportFragmentManager(),getBaseContext(),no_of_items,"grid_view");
        //viewPager.setAdapter(adap);


        ImageView im=(ImageView)findViewById(R.id.event_toolbar_image);

        Glide.with(getBaseContext()).load(image_id).into(im);


        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),
                image_id);
        Palette.from(bitmap).generate(new Palette.PaletteAsyncListener() {
            @Override
            public void onGenerated(Palette palette) {
                mutedColor = palette.getLightVibrantColor(palette.getMutedColor(Color.BLACK));
                collapsingToolbarLayout.setContentScrimColor(mutedColor);
            }
        });






    }


   /* @Override
    public void onBackPressed() {
        if(getIntent().getSt)
        Intent intent= new Intent(event_info.this,schedule.class);
        startActivity(intent);
    }*/




    void fill_data(LinearLayout card,String target)
    {

        String temp="";
        LinearLayout.LayoutParams layoutParams=new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        layoutParams.bottomMargin=20;


        LinearLayout.LayoutParams layoutParams1=new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);


        int i=0;
        do {
            if(target.charAt(i)=='{')
            {
                if(!temp.equals(""))
                {
                    TextView textView=new TextView(getBaseContext());
                    textView.setText(temp);
                    textView.setLayoutParams(layoutParams);
                    textView.setTextColor(Color.BLACK);
                    textView.setTextSize(15);
                    card.addView(textView);
                }
                temp="";
            }
            else if(target.charAt(i)=='}')
            {
                TextView textView=new TextView(getBaseContext());
                textView.setText(temp);
                textView.setLayoutParams(layoutParams1);
                textView.setTextColor(Color.BLACK);
                textView.setTypeface(null, Typeface.BOLD);
                textView.setTextSize(17);
                card.addView(textView);
                temp="";
            }
            else
            {
                temp=temp.concat(String.valueOf(target.charAt(i)));
            }
            i++;
        }while(i<target.length());

        if(!temp.equals(""))
        {
            TextView textView=new TextView(getBaseContext());
            textView.setText(temp);
            textView.setLayoutParams(layoutParams);
            textView.setTextColor(Color.BLACK);
            textView.setTextSize(15);
            card.addView(textView);
        }

    }
}
