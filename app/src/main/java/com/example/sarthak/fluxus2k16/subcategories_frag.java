package com.example.sarthak.fluxus2k16;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.*;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;


public class subcategories_frag extends Fragment{


    //subcategories m;

    public static final String ARG_PAGE = "ARG_PAGE";
    public static final String INDEX = "INDEX";
    int mPage,mIndex;
    View vi;
    static Context context;

    int[][] events_no={ {4,4,3,2,6,6},
                        {4,5,6},
                        {7},
                        {4},
                        {7,3},
                        {4},
                        {2}
    };

    public static subcategories_frag newInstance(int page,int index,Context context1) {


        context=context1;
        Bundle args = new Bundle();
        args.putInt(ARG_PAGE, page);
        args.putInt(INDEX,index);
        //args.putString(category_string,category1);
        subcategories_frag fragment = new subcategories_frag();
        fragment.setArguments(args);

        return fragment;
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        mPage = getArguments().getInt(ARG_PAGE);
        mIndex = getArguments().getInt(INDEX);
        //category=getArguments().getString(category_string);

        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {



        /*View view = inflater.inflate(R.layout.subcategories_main_layout, container, false);
        final LinearLayout linearLayout=(LinearLayout) view.findViewById(R.id.main_lay);
        View v1=inflater.inflate(R.layout.subcategories_row_centercrop,container,false);
        View v2=inflater.inflate(R.layout.subcategories_row_centercrop,container,false);
        View v3=inflater.inflate(R.layout.subcategories_row_centercrop,container,false);
        View v4=inflater.inflate(R.layout.subcategories_row_centercrop,container,false);

        async async_obj1=new async(getActivity(),context,v1,1,1);
        async async_obj2=new async(getActivity(),context,v1,1,2);
        async async_obj3=new async(getActivity(),context,v2,2,1);
        async async_obj4=new async(getActivity(),context,v2,2,2);
        async async_obj5=new async(getActivity(),context,v3,3,1);
        async async_obj6=new async(getActivity(),context,v3,3,2);
        async async_obj7=new async(getActivity(),context,v4,4,1);
        async async_obj8=new async(getActivity(),context,v4,4,2);

        //async_obj.execute(mIndex,mPage,R.id.im1,R.id.im2);
        //linearLayout.addView(v1);
        //linearLayout.addView(v2);

        final ImageView im1=(ImageView)v1.findViewById(R.id.im1);
        final ImageView im2=(ImageView)v1.findViewById(R.id.im2);
        final ImageView im3=(ImageView)v2.findViewById(R.id.im1);
        final ImageView im4=(ImageView)v2.findViewById(R.id.im2);
        final ImageView im5=(ImageView)v3.findViewById(R.id.im1);
        final ImageView im6=(ImageView)v3.findViewById(R.id.im2);
        final ImageView im7=(ImageView)v4.findViewById(R.id.im1);
        final ImageView im8=(ImageView)v4.findViewById(R.id.im2);


        /*int row_no=(events_no[mIndex][mPage]+1)/2;

        /*Display display =getActivity().getWindowManager().getDefaultDisplay();
        int width=display.getWidth();


        ImageView imageView = (ImageView)view.findViewById(R.id.test_im);
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.test2);

        int imageWidth = bitmap.getWidth();
        int imageHeight = bitmap.getHeight();


        //this method should return the width of device screen.
        float scaleFactor = (float)width/(float)imageWidth;
        int newHeight = (int)(imageHeight * scaleFactor);

        bitmap = Bitmap.createScaledBitmap(bitmap, width, newHeight, true);
        imageView.setImageBitmap(bitmap);*/
       /* switch (mIndex)
        {
            case 0:
                switch (mPage)
                {
                    case 0:view = inflater.inflate(R.layout.eve_cultural_dance, container, false);break;
                    case 1:view = inflater.inflate(R.layout.eve_cultural_drama, container, false);break;
                    case 2:view = inflater.inflate(R.layout.eve_cultural_music, container, false);break;
                    case 3:view = inflater.inflate(R.layout.eve_cultural_painting, container, false);break;
                    case 4:view = inflater.inflate(R.layout.eve_cultural_photography, container, false);break;
                    case 5:view = inflater.inflate(R.layout.eve_cultural_online, container, false);break;
                }
                break;
            case 1:
                switch (mPage)
                {
                    case 0:view = inflater.inflate(R.layout.eve_tech_electrical, container, false);break;
                    case 1:view = inflater.inflate(R.layout.eve_tech_prog, container, false);break;
                    case 2:view = inflater.inflate(R.layout.eve_tech_mech, container, false);break;
                }
                break;
            case 4:
                switch (mPage)
                {
                    case 0:view = inflater.inflate(R.layout.eve_literary_eng, container, false);break;
                    case 1:view = inflater.inflate(R.layout.eve_literary_hindi, container, false);break;
                }
                break;
            case 5:view = inflater.inflate(R.layout.eve_quiz, container, false);break;
            case 2:view = inflater.inflate(R.layout.eve_informal, container, false);break;
            case 3:view = inflater.inflate(R.layout.eve_pronites, container, false);break;
            case 6:view = inflater.inflate(R.layout.eve_workshop, container, false);break;
        }



        /*Thread thread=new Thread("thread1")
        {
            @Override
            public void run() {




                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {


                        switch (mIndex)
                        {
                            case 0:
                                switch (mPage)
                                {
                                    case 0:
                                        linearLayout.addView(v1);
                                        linearLayout.addView(v2);
                                        async_obj1.execute(mIndex, mPage, R.id.im1);
                                        async_obj2.execute(mIndex, mPage, R.id.im2);
                                        async_obj3.execute(mIndex, mPage, R.id.im1);
                                        async_obj4.execute(mIndex, mPage, R.id.im2);
                                        break;
                                    case 1:linearLayout.addView(v1);
                                        linearLayout.addView(v2);
                                        break;
                                    case 2:linearLayout.addView(v1);
                                        im4.setVisibility(View.INVISIBLE);
                                        linearLayout.addView(v2);
                                        break;
                                    case 3:linearLayout.addView(v1);
                                        break;
                                    case 4:linearLayout.addView(v1);
                                        linearLayout.addView(v2);
                                        linearLayout.addView(v3);break;
                                    case 5:linearLayout.addView(v1);
                                        linearLayout.addView(v2);
                                        linearLayout.addView(v3);break;
                                }
                                break;
                            case 1:
                                switch (mPage)
                                {
                                    case 0:
                                        linearLayout.addView(v1);
                                        linearLayout.addView(v2);
                                        async_obj1.execute(mIndex, mPage, R.id.im1);
                                        async_obj2.execute(mIndex,mPage,R.id.im2);
                                        async_obj3.execute(mIndex,mPage,R.id.im1);
                                        async_obj4.execute(mIndex,mPage,R.id.im2);
                                        break;
                                    case 1: linearLayout.addView(v1);
                                        linearLayout.addView(v2);
                                        im6.setVisibility(View.INVISIBLE);
                                        linearLayout.addView(v3);
                                        async_obj5.execute(mIndex, mPage, R.id.im1);
                                        break;
                                    case 2:
                                        linearLayout.addView(v1);
                                        linearLayout.addView(v2);
                                        linearLayout.addView(v3);
                                        async_obj1.execute(mIndex, mPage, R.id.im1);
                                        async_obj2.execute(mIndex, mPage, R.id.im2);
                                        async_obj3.execute(mIndex, mPage, R.id.im1);
                                        async_obj4.execute(mIndex, mPage, R.id.im2);
                                        async_obj5.execute(mIndex, mPage, R.id.im1);
                                        async_obj6.execute(mIndex, mPage, R.id.im2);
                                        break;
                                }
                                break;
                            case 4:
                                switch (mPage)
                                {
                                    case 0:linearLayout.addView(v1);
                                        linearLayout.addView(v2);
                                        linearLayout.addView(v3);
                                        im8.setVisibility(View.INVISIBLE);
                                        linearLayout.addView(v4);
                                        break;
                                    case 1:linearLayout.addView(v1);
                                        im4.setVisibility(View.INVISIBLE);
                                        linearLayout.addView(v2);
                                        break;
                                }
                                break;
                            case 5:
                                linearLayout.addView(v1);
                                linearLayout.addView(v2);
                                async_obj1.execute(mIndex, mPage, R.id.im1);
                                async_obj2.execute(mIndex, mPage, R.id.im2);
                                async_obj4.execute(mIndex, mPage, R.id.im2);
                                break;
                            case 2:linearLayout.addView(v1);
                                linearLayout.addView(v2);
                                linearLayout.addView(v3);
                                im8.setVisibility(View.INVISIBLE);
                                linearLayout.addView(v4);
                                break;
                            case 3:im2.setVisibility(View.INVISIBLE);
                                linearLayout.addView(v1);
                                im4.setVisibility(View.INVISIBLE);
                                linearLayout.addView(v2);
                                break;
                            case 6:linearLayout.addView(v1);
                                break;
                        }

                    /*}
                });




            }
        };
                thread.start();




        return view;*/
        //m = (subcategories) getActivity();
        // Inflate the layout for this fragment
        View rootView= inflater.inflate(R.layout.layout_grid, container, false);
        GridView gridView = (GridView) rootView.findViewById(R.id.grid_view);

        // Instance of ImageAdapter Class
        gridView.setAdapter(new ImageAdapter(context,mPage,mIndex));

        /*if(mIndex==2)
            gridView.setClickable(false);
        else
        gridView.setClickable(true);*/






        return rootView;
    }







}
