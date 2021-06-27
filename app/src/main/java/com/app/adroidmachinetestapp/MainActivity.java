package com.app.adroidmachinetestapp;

import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.app.adroidmachinetestapp.adapters.AdvertisementAdapter;
import com.app.adroidmachinetestapp.adapters.ExoPicsAdapter;
import com.app.adroidmachinetestapp.adapters.HotDealsAdapter;
import com.app.adroidmachinetestapp.adapters.NewArrivalAdapter;
import com.app.adroidmachinetestapp.adapters.ProductCategoryAdapter;
import com.app.adroidmachinetestapp.adapters.ProductStatusAdapter;
import com.app.adroidmachinetestapp.adapters.ShopsNearYouAdapter;
import com.app.adroidmachinetestapp.databinding.ActivityMainBinding;
import com.app.adroidmachinetestapp.models.AdvertisementModel;
import com.app.adroidmachinetestapp.models.ExposPicsModel;
import com.app.adroidmachinetestapp.models.HotDealsModel;
import com.app.adroidmachinetestapp.models.NewArrivalsModel;
import com.app.adroidmachinetestapp.models.ProductCategoryModel;
import com.app.adroidmachinetestapp.models.ProductStoryModel;
import com.app.adroidmachinetestapp.models.ShopsNearYouModel;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private ArrayList<ProductStoryModel> productStoryModelArrayList = new ArrayList<>();
    private ArrayList<ProductCategoryModel> productCategoryModelArrayList = new ArrayList<>();
    private ArrayList<ShopsNearYouModel> shopsNearYouModelArrayList = new ArrayList<>();
    private ArrayList<HotDealsModel> hotDealsModelArrayList = new ArrayList<>();
    private ArrayList<NewArrivalsModel> newArrivalsModelArrayList = new ArrayList<>();
    private ArrayList<ExposPicsModel> exposPicsModelArrayList = new ArrayList<>();
    private ArrayList<ExposPicsModel> fiftyPercentOff = new ArrayList<>();
    private ArrayList<ExposPicsModel> lunchSetUp = new ArrayList<>();
    private ArrayList<AdvertisementModel> advertisementModel = new ArrayList<>();

    boolean doubleBackToExitPressedOnce = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        binding.storyStatusRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        binding.storyStatusRecyclerView.setHasFixedSize(true);
        setUpProductStoryDataModel();
        ProductStatusAdapter productStatusAdapter = new ProductStatusAdapter(productStoryModelArrayList, MainActivity.this);
        binding.storyStatusRecyclerView.setAdapter(productStatusAdapter);

        //setup categories model
        setUpCategories();
        binding.recyclerViewCategories.setLayoutManager(new GridLayoutManager(this, 2));
        binding.recyclerViewCategories.setHasFixedSize(true);
        ProductCategoryAdapter productCategoryAdapter = new ProductCategoryAdapter(productCategoryModelArrayList, MainActivity.this);
        binding.recyclerViewCategories.setAdapter(productCategoryAdapter);

        //setUpAdvertisement
        setUpAdvertisement();
        binding.recyclerViewAdvertisement.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        binding.recyclerViewAdvertisement.setHasFixedSize(true);
        AdvertisementAdapter advertisementAdapter = new AdvertisementAdapter(advertisementModel, MainActivity.this);
        binding.recyclerViewAdvertisement.setAdapter(advertisementAdapter);


        //setUpShopsNearYou
        setUpShopsNearYou();
        binding.recyclerShopsNearYou.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        binding.recyclerShopsNearYou.setHasFixedSize(true);
        ShopsNearYouAdapter shopsNearYouAdapter = new ShopsNearYouAdapter(shopsNearYouModelArrayList, MainActivity.this);
        binding.recyclerShopsNearYou.setAdapter(shopsNearYouAdapter);

        //setUpHotDeals
        setUpHotDeals();
        binding.recyclerHotDeals.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        binding.recyclerHotDeals.setHasFixedSize(true);
        HotDealsAdapter hotDealsAdapter = new HotDealsAdapter(hotDealsModelArrayList, MainActivity.this);
        binding.recyclerHotDeals.setAdapter(hotDealsAdapter);

        //setupNewArrivals
        setNewArrivals();
        binding.recyclerNewArrivals.setLayoutManager(new GridLayoutManager(this, 2));
        binding.recyclerNewArrivals.setHasFixedSize(true);
        NewArrivalAdapter newArrivalAdapter = new NewArrivalAdapter(newArrivalsModelArrayList, MainActivity.this);
        binding.recyclerNewArrivals.setAdapter(newArrivalAdapter);

        //setup expo
        setUpExoPics();
        binding.recyclerExposPick.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        binding.recyclerExposPick.setHasFixedSize(true);
        ExoPicsAdapter exoPicsAdapter = new ExoPicsAdapter(exposPicsModelArrayList, MainActivity.this);
        binding.recyclerExposPick.setAdapter(exoPicsAdapter);

        //setup 50 percent Off
        setUp50PercentOff();
        ExoPicsAdapter exoPicsAdapter2 = new ExoPicsAdapter(fiftyPercentOff, MainActivity.this);
        binding.recycler50PercentOff.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        binding.recycler50PercentOff.setHasFixedSize(true);
        binding.recycler50PercentOff.setAdapter(exoPicsAdapter2);

        //setUpLunchTimeSetUp
        setUpLunchSetUp();
        ExoPicsAdapter exoPicsAdapter3 = new ExoPicsAdapter(lunchSetUp, MainActivity.this);
        binding.recyclerLunchTimeLineUp.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        binding.recyclerLunchTimeLineUp.setHasFixedSize(true);
        binding.recyclerLunchTimeLineUp.setAdapter(exoPicsAdapter3);


        binding.recyclerViewAdvertisement.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);


                if (!recyclerView.canScrollHorizontally(RecyclerView.FOCUS_LEFT)) {
                    ConstraintLayout.LayoutParams params = (ConstraintLayout.LayoutParams) binding.scroll1.getLayoutParams();
                    params.height = getResources().getDimensionPixelSize(R.dimen.dp_5);
                    params.width = getResources().getDimensionPixelSize(R.dimen.dp_19);
                    binding.scroll1.setLayoutParams(params);
                    binding.scroll1.setAlpha(0.5f);


                    ConstraintLayout.LayoutParams params2 = (ConstraintLayout.LayoutParams) binding.scroll2.getLayoutParams();
                    params2.height = getResources().getDimensionPixelSize(R.dimen.dp_5);
                    params2.width = getResources().getDimensionPixelSize(R.dimen.dp_31);
                    binding.scroll2.setLayoutParams(params2);
                    binding.scroll2.setAlpha(1);

                }

                if (!recyclerView.canScrollHorizontally(-1)) {


                    ConstraintLayout.LayoutParams params = (ConstraintLayout.LayoutParams) binding.scroll1.getLayoutParams();
                    params.height = getResources().getDimensionPixelSize(R.dimen.dp_5);
                    params.width = getResources().getDimensionPixelSize(R.dimen.dp_31);
                    binding.scroll1.setLayoutParams(params);
                    binding.scroll1.setAlpha(1);


                    ConstraintLayout.LayoutParams params2 = (ConstraintLayout.LayoutParams) binding.scroll2.getLayoutParams();
                    params2.height = getResources().getDimensionPixelSize(R.dimen.dp_5);
                    params2.width = getResources().getDimensionPixelSize(R.dimen.dp_19);
                    binding.scroll2.setLayoutParams(params2);
                    binding.scroll2.setAlpha(0.5f);

                }

            }
        });


    }

    void setUpAdvertisement() {
        advertisementModel.add(new AdvertisementModel(1, R.drawable.gold, R.drawable.nakshatra));
        advertisementModel.add(new AdvertisementModel(2, R.drawable.gold, R.drawable.nakshatra));

    }

    void setUpLunchSetUp() {
        lunchSetUp.add(new ExposPicsModel(1, "Pizza Hut", "", "Within 25 mins", R.drawable.beef_curry));
        lunchSetUp.add(new ExposPicsModel(2, "Pizza Hut", "", "Within 25 mins", R.drawable.panner_masala));
        lunchSetUp.add(new ExposPicsModel(3, "Pizza Hut", "", "Within 25 mins", R.drawable.chikken_curry));
    }

    void setUp50PercentOff() {
        fiftyPercentOff.add(new ExposPicsModel(3, "Pizza Hut", "", "Within 25 mins", R.drawable.nudles));
        fiftyPercentOff.add(new ExposPicsModel(2, "Pizza Hut", "", "Within 25 mins", R.drawable.buger));
        fiftyPercentOff.add(new ExposPicsModel(4, "Pizza Hut", "", "Within 25 mins", R.drawable.pizza));
    }

    void setUpExoPics() {
        exposPicsModelArrayList.add(new ExposPicsModel(1, "Pizza Hut", "", "Within 25 mins", R.drawable.chikken_curry));
        exposPicsModelArrayList.add(new ExposPicsModel(2, "Pizza Hut", "", "Within 25 mins", R.drawable.buger));
        exposPicsModelArrayList.add(new ExposPicsModel(3, "Pizza Hut", "", "Within 25 mins", R.drawable.nudles));
        exposPicsModelArrayList.add(new ExposPicsModel(4, "Pizza Hut", "", "Within 25 mins", R.drawable.pizza));
    }

    void setNewArrivals() {
        newArrivalsModelArrayList.add(new NewArrivalsModel(1, "Nike React Version", "From Rs.10,499", R.drawable.perfume_2));
        newArrivalsModelArrayList.add(new NewArrivalsModel(2, "Nike React Version", "From Rs.10,499", R.drawable.perfumes_1));
        newArrivalsModelArrayList.add(new NewArrivalsModel(3, "Nike React Version", "From Rs.10,499", R.drawable.perfume_2));
        newArrivalsModelArrayList.add(new NewArrivalsModel(4, "Nike React Version", "From Rs.10,499", R.drawable.tourist_bag_2));
    }

    void setUpHotDeals() {
        hotDealsModelArrayList.add(new HotDealsModel(1, R.drawable.cosmo_4));
        hotDealsModelArrayList.add(new HotDealsModel(2, R.drawable.cosmo_5));
        hotDealsModelArrayList.add(new HotDealsModel(3, R.drawable.cosmo_3));
        hotDealsModelArrayList.add(new HotDealsModel(4, R.drawable.cossmo2));
    }

    void setUpShopsNearYou() {
        shopsNearYouModelArrayList.add(new ShopsNearYouModel(1, "KFC", R.drawable.kfc));
        shopsNearYouModelArrayList.add(new ShopsNearYouModel(2, "Flipkart", R.drawable.flipkart));
        shopsNearYouModelArrayList.add(new ShopsNearYouModel(3, "Woodland", R.drawable.woodland));
        shopsNearYouModelArrayList.add(new ShopsNearYouModel(4, "Amazon", R.drawable.amazon));
        shopsNearYouModelArrayList.add(new ShopsNearYouModel(4, "Allen Solly", R.drawable.allen_solly));
    }


    void setUpCategories() {
        productCategoryModelArrayList.add(new ProductCategoryModel(1, "Food", R.drawable.food));
        productCategoryModelArrayList.add(new ProductCategoryModel(2, "Accessories", R.drawable.accessories));
        productCategoryModelArrayList.add(new ProductCategoryModel(3, "Perfumes", R.drawable.perfumes));
        productCategoryModelArrayList.add(new ProductCategoryModel(4, "Books", R.drawable.books));

    }

    void setUpProductStoryDataModel() {
        productStoryModelArrayList.add(new ProductStoryModel(1, "e-stories", R.drawable.woodland));
        productStoryModelArrayList.add(new ProductStoryModel(2, "My G", R.drawable.myg));
        productStoryModelArrayList.add(new ProductStoryModel(3, "Kfc", R.drawable.kfc));
        productStoryModelArrayList.add(new ProductStoryModel(4, "FlipKart", R.drawable.flipkart));
        productStoryModelArrayList.add(new ProductStoryModel(5, "Amazon", R.drawable.amazon));
        productStoryModelArrayList.add(new ProductStoryModel(6, "FlipKart", R.drawable.flipkart));
    }

    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed();
            return;
        }

        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, "Please click BACK again to exit", Toast.LENGTH_SHORT).show();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                doubleBackToExitPressedOnce = false;
            }
        }, 2000);
    }
}