package com.example.sarthak.fluxus2k16;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.app.Fragment;
import android.app.FragmentManager;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentTransaction;
import android.text.Layout;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.ImageView;


import com.bumptech.glide.Glide;


public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    FragmentManager fragmentManager;
    DrawerLayout drawer;
    Toolbar toolbar;
    int i=0,j=0;
    static Accomodation a=new Accomodation();
    static reach_campusfrag reach_frag=new reach_campusfrag();
    ImageView im;


    static int open;

    NavigationView navigationView;



    View layout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        open=0;



        layout=findViewById(R.id.include1);
        toolbar = (Toolbar) layout.findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

        toolbar.setTitle("Fluxus");
        toolbar.setTitleTextColor(Color.WHITE);
        toolbar.setBackgroundColor(Color.BLACK);


         drawer = (DrawerLayout) findViewById(R.id.drawer_layout);


        navigationView=(NavigationView)findViewById(R.id.nav_view);
        View v=navigationView.getHeaderView(0);
        im=(ImageView)v.findViewById(R.id.imageView);
        Glide.with(getBaseContext()).load(R.drawable.fluxus).into(im);


        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);



        drawer.openDrawer(GravityCompat.START);

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.content_frame, new home());
        transaction.addToBackStack(null);
        transaction.commit();
        //drawer.closeDrawer(GravityCompat.START);



    }

    @Override
    public void onBackPressed() {
        // TODO Auto-generated method stub

        new AlertDialog.Builder(this)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setMessage("Do you want to exit?")
                .setPositiveButton("Yes",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog,
                                                int which) {
                                //finish();
                                Intent homeIntent = new Intent(Intent.ACTION_MAIN);
                                homeIntent.addCategory( Intent.CATEGORY_HOME );
                                homeIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                startActivity(homeIntent);

                            }
                        }).setNegativeButton("No", null).show();

        return;
    }


    @Override
    protected void onResume() {
        super.onResume();


        if(open==0) {
            drawer.openDrawer(GravityCompat.START);
        }
        else
        {
            drawer.closeDrawer(GravityCompat.START);
            open=0;
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {


        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {

            toolbar.setTitle("Fluxus");

            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.content_frame, new home());
            transaction.addToBackStack(null);
            transaction.commit();
            drawer.closeDrawer(GravityCompat.START);

            // Handle the camera action
        } else if (id == R.id.nav_events) {
            startActivity(new Intent(MainActivity.this,DemoLikeTumblrActivity.class));
            overridePendingTransition(0,0);
           // fragmentManager = getFragmentManager();
           // fragmentManager.beginTransaction().replace(R.id.content_frame, new Grid_fragment()).commit();
           // drawer.closeDrawer(GravityCompat.START);

        } else if (id == R.id.nav_schedule) {
            startActivity(new Intent(MainActivity.this,schedule.class));
            overridePendingTransition(0, 0);

        } else if (id == R.id.nav_register) {

            Intent viewIntent =
                    new Intent("android.intent.action.VIEW",
                            Uri.parse("https://www.facebook.com/login.php?skip_api_login=1&api_key=680367098765940&" +
                                    "signed_next=1&next=https%3A%2F%2Fwww.facebook.com%2Fv2.4%2Fdialog%2Foauth%3F" +
                                    "redirect_uri%3Dhttp%253A%252F%252Fstaticxx.facebook.com%252Fconnect%252Fxd_arbiter.php" +
                                    "%253Fversion%253D42%2523cb%253Df155b99fe4%2526domain%253Dfluxus.in%2526origin%253" +
                                    "Dhttp%25253A%25252F%25252Ffluxus.in%25252Ff292b00d6%2526relation%253Dopener%2526" +
                                    "frame%253Df29b2a86f%26display%3Dpopup%26scope%3Demail%26response_type%3Dtoken%252" +
                                    "Csigned_request%26domain%3Dfluxus.in%26origin%3D1%26client_id%3D680367098765940%26" +
                                    "ret%3Dlogin%26sdk%3Djoey&cancel_url=http%3A%2F%2Fstaticxx.facebook.com%2Fconnect%2" +
                                    "Fxd_arbiter.php%3Fversion%3D42%23cb%3Df155b99fe4%26domain%3Dfluxus.in%26origin%3" +
                                    "Dhttp%253A%252F%252Ffluxus.in%252Ff292b00d6%26relation%3Dopener%26frame%3Df29b2a86" +
                                    "f%26error%3Daccess_denied%26error_code%3D200%26error_description%3DPermissions%2" +
                                    "Berror%26error_reason%3Duser_denied%26e2e%3D%257B%257D&display=popup"));
            startActivity(viewIntent);

        } else if (id == R.id.nav_feed) {

            toolbar.setTitle("Feed");
            //startActivity(new Intent(MainActivity.this,Notification.class));
            //overridePendingTransition(0, 0);
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.content_frame, new Notification());
            transaction.addToBackStack(null);
            transaction.commit();
            drawer.closeDrawer(GravityCompat.START);


        } else if (id == R.id.nav_accomodation) {

            toolbar.setTitle("Accomodation");
            //startActivity(new Intent(MainActivity.this,Accomodation.class));
            if(j==0) {
                fragmentManager = getFragmentManager();
                acc_pageradapter obj = new acc_pageradapter(getBaseContext());
                obj.getfm(getSupportFragmentManager());

                //FrameLayout layout=(FrameLayout)findViewById(R.id.content_frame);
                //fragmentManager.beginTransaction(fragmentManager.ge)


                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.content_frame,a);
                transaction.commit();
                drawer.closeDrawer(GravityCompat.START);
                j++;
            }
            else
            {

                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.content_frame,a);
                transaction.commit();
                drawer.closeDrawer(GravityCompat.START);
                a.viewPager.setAdapter(new acc_pageradapter(getBaseContext()));
            }

        }else if(id==R.id.nav_reach_campus){

            toolbar.setTitle("Reach Campus");

            if(i==0) {
                fragmentManager = getFragmentManager();
                reach_campus_pageradapter obj = new reach_campus_pageradapter(getBaseContext());
                obj.getfm(getSupportFragmentManager());

                //FrameLayout layout=(FrameLayout)findViewById(R.id.content_frame);
                //fragmentManager.beginTransaction(fragmentManager.ge)


                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.content_frame,reach_frag);
                transaction.commit();
                drawer.closeDrawer(GravityCompat.START);
                i++;
            }
            else
            {

                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.content_frame,reach_frag);
                transaction.commit();
                drawer.closeDrawer(GravityCompat.START);
                reach_frag.viewPager.setAdapter(new acc_pageradapter(getBaseContext()));
            }

        }else if(id==R.id.nav_contact_us){

            toolbar.setTitle("Contact Us");

            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.content_frame, new contact_us());
            transaction.addToBackStack(null);
            transaction.commit();
            drawer.closeDrawer(GravityCompat.START);

        }else if(id==R.id.nav_developers){

            toolbar.setTitle("Developers");

            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.content_frame, new developers());
            transaction.addToBackStack(null);
            transaction.commit();
            drawer.closeDrawer(GravityCompat.START);

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


}
