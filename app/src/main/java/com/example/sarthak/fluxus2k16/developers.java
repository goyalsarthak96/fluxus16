package com.example.sarthak.fluxus2k16;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

/**
 * Created by Sarthak on 1/30/2016.
 */
public class developers extends Fragment {

    ImageView im1,im2;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        View v=inflater.inflate(R.layout.developers,container,false);
        im1=(ImageView)v.findViewById(R.id.contact_im);
        im2=(ImageView)v.findViewById(R.id.contact_im1);

        Glide.with(getActivity().getBaseContext()).load(R.drawable.pratik).into(im1);
        Glide.with(getActivity().getBaseContext()).load(R.drawable.sarthak).into(im2);
        return v;
    }
}
