package com.app.adroidmachinetestapp;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.app.adroidmachinetestapp.adapters.ProductCategoryAdapter;
import com.app.adroidmachinetestapp.adapters.ProductStatusAdapter;
import com.app.adroidmachinetestapp.adapters.ShopsNearYouAdapter;
import com.app.adroidmachinetestapp.databinding.ActivityMainBinding;
import com.app.adroidmachinetestapp.models.ProductCategoryModel;
import com.app.adroidmachinetestapp.models.ProductStoryModel;
import com.app.adroidmachinetestapp.models.ShopsNearYouModel;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private ArrayList<ProductStoryModel> productStoryModelArrayList = new ArrayList<>();
    private ArrayList<ProductCategoryModel> productCategoryModelArrayList = new ArrayList<>();
    private ArrayList<ShopsNearYouModel> shopsNearYouModelArrayList = new ArrayList<>();


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

        //setUpShopsNearYou
        setUpShopsNearYou();
        binding.recyclerShopsNearYou.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        binding.recyclerShopsNearYou.setHasFixedSize(true);
        ShopsNearYouAdapter shopsNearYouAdapter = new ShopsNearYouAdapter(shopsNearYouModelArrayList, MainActivity.this);
        binding.recyclerShopsNearYou.setAdapter(shopsNearYouAdapter);

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
}