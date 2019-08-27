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
import android.widget.LinearLayout;
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


    /////////////////////////// Banner Slider
    private ViewPager bannerSliderViewPager;
    private List<SliderModel> sliderModelList;
    private int currentPage = 2;
    private Timer timer;
    final private long DELAY_TIME = 3000;
    final private long PERIOD_TIME = 3000;

    ///////////////////////////Banner Slider

    ////////////////////Strip ad
    private ImageView stripAdImage;
    private ConstraintLayout stripAdContainer;

    /////////////////////Strip ad


    ////////////////////////// Horizontal Product Layout
    private TextView horizontalLayoutTitle;
    private Button horizontalLayoutViewAllBtn;
    private RecyclerView horizontalRecyclerView;

    ////////////////////////// Horizontal Product Layout

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_home, container, false);

        categoryRecyclerView = view.findViewById(R.id.category_recycler_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity()); //creating a linear layout
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
        bannerSliderViewPager = view.findViewById(R.id.banner_slider_view_pager);
        sliderModelList = new ArrayList<SliderModel>();

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

        SliderAdapter sliderAdapter = new SliderAdapter(sliderModelList);
        bannerSliderViewPager.setAdapter(sliderAdapter);
        bannerSliderViewPager.setClipToPadding(false);
        bannerSliderViewPager.setPageMargin(20);

        bannerSliderViewPager.setCurrentItem(currentPage);

        ViewPager.OnPageChangeListener onPageChangeListener = new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                currentPage = i;
            }

            @Override
            public void onPageScrollStateChanged(int i) {
                if(i == ViewPager.SCROLL_STATE_IDLE){
                    pageLooper();
                }
            }
        };
        bannerSliderViewPager.addOnPageChangeListener(onPageChangeListener);

        startBannerSlideshow();

        bannerSliderViewPager.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                pageLooper();
                stopBannerSlideshow();
                if(event.getAction() == MotionEvent.ACTION_UP){
                    startBannerSlideshow();
                }
                return false;
            }
        });

        ////////////////////////// Banner Slider


        /////////////////////STRIP AD
        stripAdImage = view.findViewById(R.id.strip_ad_image);
        stripAdContainer = view.findViewById(R.id.strip_ad_container);

        stripAdImage.setImageResource(R.drawable.strip_add);
        stripAdContainer.setBackgroundColor(Color.parseColor("#000000"));
        /////////////////////STRIP AD


        ////////////////////////// Horizontal Product Layout

        horizontalLayoutTitle = view.findViewById(R.id.horizontal_scroll_layout_title);
        horizontalLayoutViewAllBtn = view.findViewById(R.id.horizontal_scroll_view_all);
        horizontalRecyclerView = view.findViewById(R.id.horizontal_scroll_layout_recycler_view);



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



        HorizontalProductScrollAdapter horizontalProductScrollAdapter = new HorizontalProductScrollAdapter(horizontalProductScrollModelList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext()); //creating a linear layout
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        horizontalRecyclerView.setLayoutManager(linearLayoutManager);
        //getContext is for outside of the activity; getContext() vs getActivity()
        horizontalRecyclerView.setAdapter(horizontalProductScrollAdapter);
        horizontalProductScrollAdapter.notifyDataSetChanged();

        ////////////////////////// Horizontal Product Layout


        ////////////////////////// Grid Product Layout
        TextView gridLayoutTitle = view.findViewById(R.id.grid_product_layout_title);
        Button gridLayoutViewAllBtn = view.findViewById(R.id.grid_product_layout_view_all_btn);
        GridView gridView = view.findViewById(R.id.grid_product_layout_grid_view);

        gridView.setAdapter(new GridProductLayoutAdapter(horizontalProductScrollModelList));

        ////////////////////////// Grid Product Layout



        /////////////////////Recycler View 2nd

        RecyclerView testing = view.findViewById(R.id.testing);
        LinearLayoutManager testingLayoutManager = new LinearLayoutManager(getContext());
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

    ///////////////////Banner Slider
    private void pageLooper(){
        if(currentPage == sliderModelList.size() - 2){
            currentPage =2;
            bannerSliderViewPager.setCurrentItem(currentPage,false);
        }

        if(currentPage == 1){
            currentPage = sliderModelList.size() - 3;
            bannerSliderViewPager.setCurrentItem(currentPage,false);
        }
    }

    private void startBannerSlideshow(){
        final Handler handler = new Handler();
        final Runnable update = new Runnable() {
            @Override
            public void run() {
                if(currentPage >= sliderModelList.size()){
                    currentPage = 1;
                }

                bannerSliderViewPager.setCurrentItem(currentPage++,true);
            }
        };

        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(update);
            }
        }
        ,DELAY_TIME,PERIOD_TIME
        );
    }

    private void stopBannerSlideshow(){
        timer.cancel();
    }


    //////////////////// Banner Slider


    /////////////////////STRIP AD



    /////////////////////STRIP AD

    ////////////////////////// Horizontal Product Layout


    ////////////////////////// Horizontal Product Layout

    ////////////////////////// Grid Product Layout



    ////////////////////////// Grid Product Layout

}
