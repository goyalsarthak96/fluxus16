package com.example.sarthak.fluxus2k16;


import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

public class home extends android.support.v4.app.Fragment{

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.home,container,false);
        home_gridadapter adap=new home_gridadapter(getActivity().getBaseContext());

        GridView gridView=(GridView)view.findViewById(R.id.homegrid_view);
        gridView.setAdapter(adap);

        return view;
    }
}
