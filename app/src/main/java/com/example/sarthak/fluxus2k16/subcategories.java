package com.example.sarthak.fluxus2k16;

import android.graphics.Bitmap;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.LruCache;

public class subcategories extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subcategories);



        ViewPager categories_viewPager=(ViewPager)findViewById(R.id.category_viewpager);
        PagerAdapter pagerAdapter=new subcategories_pageradapter(getSupportFragmentManager(),this,getIntent().getIntExtra("category_no",0));
        categories_viewPager.setAdapter(pagerAdapter);



    }


}
