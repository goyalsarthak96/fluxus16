package com.example.sarthak.fluxus2k16;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;


import com.bumptech.glide.Glide;

import java.lang.ref.WeakReference;


public class ImageAdapter extends BaseAdapter {


    private Context mContext;
    int mPosition;
    int mPage,category_no;
    Bitmap mPlaceHolderBitmap;

    int event_im_list[][][]={

            {{R.drawable.aajanachle, R.drawable.anybodycandance, R.drawable.chancepedance, R.drawable.stepup},
    { R.drawable.nautanki_andaaz,R.drawable.tamasha,R.drawable.naatkam,R.drawable.dubsmash},
    { R.drawable.voiceoffluxus,R.drawable.rockon,R.drawable.sur},
    { R.drawable.subtleshades,R.drawable.rangreza},
    {R.drawable.capture_the_fluxus,R.drawable.fluxus_on_reel,R.drawable.maskot_making,
            R.drawable.doodle_design,R.drawable.shutterbug,R.drawable.creatrix}},



    {{R.drawable.robowars,R.drawable.bot_the_builder,R.drawable.grabit,R.drawable.aquabotics,
        R.drawable.roborace,R.drawable.structurra},
            {R.drawable.roboone,R.drawable.parking_controller,R.drawable.monopoly_of_circuits,
    R.drawable.intelligesture},
    {R.drawable.aibot,R.drawable.machine_learning,R.drawable.dividebyzero,R.drawable.dividebyzero,
                    R.drawable.code_melange}},




            {{R.drawable.treasurehunt,R.drawable.sedded,R.drawable.hydroshoot,R.drawable.seconds_of_fame,
            R.drawable.auction,R.drawable.poker,R.drawable.paintball,R.drawable.landzorbing,R.drawable.rock}
            },


            {{R.drawable.enigma,R.drawable.bollywoodquiz,R.drawable.lukkha,R.drawable.fluxuscrucible}},


            {{R.drawable.col,R.drawable.jam,R.drawable.pictionary,R.drawable.potter_mania,
            R.drawable.ransense,R.drawable.scrabble,R.drawable.spellbee,R.drawable.word_wars}}





    };







    String event_list[][][]= {

            {
                    {"Aaja nachle-Solo Dance", "Any body can Dance-Group Dance", "Dance pe Chance-Duet Dance", "Step up-Street Dance"},
                    {"Nautanki Andaaz-Monoact", "Tamasha-Nukkad", "Naatakam-Stage Play", "Dubsmash-Zara Ye Kar Ke Dikhao"},
                    {"Voice Of Fluxus-Solo Singing", "Rock On-Battle Of Bands", "Sur-Acousticas and Instruments"},
                    {"Subtle Shades", "Rangreza"},
                    {"Capture The Fluxus", "Fluxus On Reel", "Mascot Making", "Doodle Design", "Shutterbug", "Kreatrix"}

            },


            {
                    {"Robowars", "Bot the Builder", "Grabit", "Aquabotics", "Roborace", "Structura"},
                    {"RoboOne", "ParKontrol", "Monopoly of Circuits", "Intelligesture"},
                    {"AI Bot", "Machine Learning Contest", "Divide by Zero", "Surprise Language", "Code Melange"}

            },

            {
                    {"Treasure Hunt","Seductively Deductive","Hydroshoot","47 Seconds of Fame","Auction","Poker Night","Paintball","Land Zorbing","Rock Climbing"}
            },
            {
                    {"Enigma" , "Bollywood Quiz"," Lukkha Quiz","Fluxus Crucible"}
            },
            {
                    {"Cache Of Lexis","JAM-Just A Minute","Pictionary","Potter Mania","Ransense-Creative Writing","Scrabble","Spell Bee","Word Wars-Group discussion followed by debate"}
            }


    };





    int count[][]={
            {event_list[0][0].length,event_list[0][1].length,event_list[0][2].length,event_list[0][3].length,event_list[0][4].length},
            {event_list[1][0].length,event_list[1][1].length,event_list[1][2].length},
            {event_list[2][0].length},
            {event_list[3][0].length},
            {event_list[4][0].length}
    };







    /*,
            R.mipmap.grabit, R.mipmap.intelligesture, R.mipmap.machine_learning, R.mipmap.monopoly_of_circuits,

            R.mipmap.parking_controller,R.mipmap.roboone,R.mipmap.roborace,R.mipmap.robowars,
            R.mipmap.stepup,R.mipmap.structurra
    };*/


    // Keep all Images in array


    public ImageAdapter(Context c,int pageno,int categoryno){
        mContext = c;
        mPage=pageno;
        category_no=categoryno;
          }

    @Override
    public int getCount() {
        return count[category_no][mPage];
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {




        mPosition=position;

        //if (convertView == null) {


            // get layout from mobile.xml
            final LayoutInflater inflater = (LayoutInflater) mContext
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.grid_element, null);
        //}
        final ImageView img=(ImageView)convertView.findViewById(R.id.im);
        final TextView eve_name_textview=(TextView)convertView.findViewById(R.id.grid_item_label_static);
        eve_name_textview.getBackground().setAlpha(124);

        final String name=event_list[category_no][mPage][mPosition];
        final int im_id=event_im_list[category_no][mPage][mPosition];
        eve_name_textview.setText(name);

        if(category_no!=2) {
            img.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent intent = new Intent(mContext, event_info.class);
                    intent.putExtra("eve_name", name);
                    switch (category_no) {
                        case 0:
                            intent.putExtra("table_name", "culturals");
                            break;
                        case 1:
                            intent.putExtra("table_name", "technicals");
                            break;
                        case 2:
                            intent.putExtra("table_name", "informals");
                            break;
                        case 3:
                            intent.putExtra("table_name", "quiz");
                            break;
                        case 4:
                            intent.putExtra("table_name", "lit");
                            break;
                    }

                    intent.putExtra("image_id", im_id);
                    //intent.putExtra("from","category");
                    mContext.startActivity(intent);

                }
            });
        }
         /*   holder.im=(ImageView)gridView.findViewById(R.id.im);
            gridView.setTag(holder);

        } else {

            holder = (Holder) gridView.getTag();
        }*/




      //  loadBitmap(ids[position], holder.im,position);


        Glide.with(mContext).load(event_im_list[category_no][mPage][position]).into(img);


        //Bitmap ThumbImage = ThumbnailUtils.extractThumbnail(BitmapFactory.decodeFile(imagePath), 800, 800);
       /* InputStream is = mContext.getResources().openRawResource(ids[position]);
        Bitmap source=BitmapFactory.decodeStream(is);
        Bitmap mThumbnail=ThumbnailUtils.extractThumbnail (source,800, 800);
        /*int maxSize = source.getWidth() > source.getHeight() ? source.getWidth() : source.getHeight();
        Bitmap mThumbnail= Bitmap.createScaledBitmap(source, source.getWidth() * 96 / maxSize, source.getHeight() * 96 / maxSize, true);
        */
       // Picasso.with(mContext).load(ids[position]).noFade().resize(1000,1000).centerCrop().error(R.drawable.i0).tag(mContext).into(holder.im);


        //int width=GridView.AUTO_FIT;
        convertView.setLayoutParams(new GridView.LayoutParams(GridView.AUTO_FIT,500));

        return convertView;
    }











}



