package com.naimur978.flybuy;


import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class HomeFragment extends Fragment {

    public HomeFragment() {
        // Required empty public constructor
    }

    private RecyclerView categoryRecyclerView;
    private CategoryAdapter categoryAdapter;
    private RecyclerView testing;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_home, container, false);

        categoryRecyclerView = view.findViewById(R.id.category_recycler_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity()); //creating a linear layout for scrolling horizontally
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        categoryRecyclerView.setLayoutManager(layoutManager);

        List<CategoryModel> categoryModelList = new ArrayList<CategoryModel>();

        categoryModelList.add(new CategoryModel("link","Home"));
        categoryModelList.add(new CategoryModel("link","Electronics"));
        categoryModelList.add(new CategoryModel("link","Appliances"));
        categoryModelList.add(new CategoryModel("link","Furniture"));
        categoryModelList.add(new CategoryModel("link","Fashion"));
        categoryModelList.add(new CategoryModel("link","Toys"));
        categoryModelList.add(new CategoryModel("link","Sports"));
        categoryModelList.add(new CategoryModel("link","Wall Arts"));
        categoryModelList.add(new CategoryModel("link","Books"));
        categoryModelList.add(new CategoryModel("link","Shoes"));

        categoryAdapter = new CategoryAdapter(categoryModelList);
        categoryRecyclerView.setAdapter(categoryAdapter);
        categoryAdapter.notifyDataSetChanged();


        //////////////////////////Banner Slider
        List<SliderModel>sliderModelList = new ArrayList<SliderModel>();

        sliderModelList.add(new SliderModel(R.mipmap.my_mall,"#077AE4"));
        sliderModelList.add(new SliderModel(R.mipmap.custom_error_icon,"#077AE4"));

        //original
        sliderModelList.add(new SliderModel(R.mipmap.green_email,"#077AE4"));
        sliderModelList.add(new SliderModel(R.mipmap.red_email,"#077AE4"));
        sliderModelList.add(new SliderModel(R.mipmap.banner_demo,"#077AE4"));
        sliderModelList.add(new SliderModel(R.mipmap.ic_launcher,"#077AE4"));
        sliderModelList.add(new SliderModel(R.mipmap.cart_white,"#077AE4"));
        sliderModelList.add(new SliderModel(R.mipmap.profile_placeholder,"#077AE4"));
        sliderModelList.add(new SliderModel(R.mipmap.my_mall,"#077AE4"));
        sliderModelList.add(new SliderModel(R.mipmap.custom_error_icon,"#077AE4"));
        //original

        sliderModelList.add(new SliderModel(R.mipmap.green_email,"#077AE4"));
        sliderModelList.add(new SliderModel(R.mipmap.red_email,"#077AE4"));

        ////////////////////////// Banner Slider

        ////////////////////////// Horizontal Product Layout

        List<HorizontalProductScrollModel> horizontalProductScrollModelList = new ArrayList<>();
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.image_mobile,"Redmi 5A","SD 625 Processor","Tk. 11200/="));
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.image_mobile,"Redmi 5A","SD 625 Processor","Tk. 11200/="));
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.image_mobile,"Redmi 5A","SD 625 Processor","Tk. 11200/="));
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.image_mobile,"Redmi 5A","SD 625 Processor","Tk. 11200/="));
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.image_mobile,"Redmi 5A","SD 625 Processor","Tk. 11200/="));
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.image_mobile,"Redmi 5A","SD 625 Processor","Tk. 11200/="));
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.image_mobile,"Redmi 5A","SD 625 Processor","Tk. 11200/="));
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.image_mobile,"Redmi 5A","SD 625 Processor","Tk. 11200/="));
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.image_mobile,"Redmi 5A","SD 625 Processor","Tk. 11200/="));
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.image_mobile,"Redmi 5A","SD 625 Processor","Tk. 11200/="));

        ////////////////////////// Horizontal Product Layout

        /////////////////////Recycler View 2nd

        testing = view.findViewById(R.id.home_page_recycler_view);
        LinearLayoutManager testingLayoutManager = new LinearLayoutManager(getContext()); //vertical scroll
        testingLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        testing.setLayoutManager(testingLayoutManager);

        List<HomePageModel> homePageModelList = new ArrayList<>();
        homePageModelList.add(new HomePageModel(0,sliderModelList));
        homePageModelList.add(new HomePageModel(1,R.drawable.strip_add,"#000000"));
        homePageModelList.add(new HomePageModel(2,"Deals of the day",horizontalProductScrollModelList));
        homePageModelList.add(new HomePageModel(3,"Deals of the week",horizontalProductScrollModelList));
        homePageModelList.add(new HomePageModel(0,sliderModelList));
        homePageModelList.add(new HomePageModel(1,R.mipmap.banner_demo,"#0000FF"));
        homePageModelList.add(new HomePageModel(0,sliderModelList));
        homePageModelList.add(new HomePageModel(1,R.drawable.strip_add,"#FF0000"));

        HomePageAdapter adapter = new HomePageAdapter(homePageModelList);
        testing.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        /////////////////////Recycler View 2nd
        return view;
    }
}
