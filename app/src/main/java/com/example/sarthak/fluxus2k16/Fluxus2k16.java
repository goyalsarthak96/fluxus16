package com.example.sarthak.fluxus2k16;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class Fluxus2k16 extends AppCompatActivity {

    TextView t;
    ImageView v;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fluxus);

        t=(TextView)findViewById(R.id.continue_text);
        v=(ImageView)findViewById(R.id.fluxus);
        Glide.with(getBaseContext()).load(R.drawable.fluxus_main).into(v);
        t.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Fluxus2k16.this,MainActivity.class);
                startActivity(intent);
            }
        });


    }


}
