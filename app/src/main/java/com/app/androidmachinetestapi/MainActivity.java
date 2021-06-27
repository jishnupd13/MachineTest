package com.app.androidmachinetestapi;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.app.androidmachinetestapi.adapters.UserListAdapter;
import com.app.androidmachinetestapi.databinding.ActivityMainBinding;
import com.app.androidmachinetestapi.models.UserListModel;
import com.app.androidmachinetestapi.onitemclicklistener.OnItemClickListener;
import com.app.androidmachinetestapi.remotenetwork.ApiClient;
import com.app.androidmachinetestapi.remotenetwork.ApiInterface;
import com.app.androidmachinetestapi.splashscreen.SplashScreenActivity;
import com.app.androidmachinetestapi.userdetailsactivity.UserDetailsActivity;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements OnItemClickListener {

    ApiInterface apiInterface;

    ActivityMainBinding binding;

    private ArrayList<UserListModel.Datum> userList = new ArrayList<>();

    OnItemClickListener onItemClickListener;

    boolean doubleBackToExitPressedOnce = false;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        apiInterface = ApiClient.getClient().create(ApiInterface.class);

        binding.userRecyclerView.setVisibility(View.GONE);
        binding.appLoader.setVisibility(View.VISIBLE);

        binding.userRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        binding.userRecyclerView.setHasFixedSize(true);

        onItemClickListener=this::itemUserClick;

        Call<UserListModel> userCall = apiInterface.doGetUserList();
        userCall.enqueue(new Callback<UserListModel>() {
            @Override
            public void onResponse(Call<UserListModel> call, Response<UserListModel> response) {
                binding.userRecyclerView.setVisibility(View.VISIBLE);
                binding.appLoader.setVisibility(View.GONE);
                if(response.isSuccessful()){
                    userList.clear();
                    userList.addAll(response.body().data);
                    UserListAdapter userListAdapter =new UserListAdapter(userList,MainActivity.this,onItemClickListener);
                    binding.userRecyclerView.setAdapter(userListAdapter);
                }else {
                    Toast.makeText(MainActivity.this, "Sorry Something went wrong! Please Try Again", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<UserListModel> call, Throwable t) {
                Log.e("error", "" + t);
                binding.userRecyclerView.setVisibility(View.VISIBLE);
                binding.appLoader.setVisibility(View.GONE);
            }
        });
    }

    @Override
    public void itemUserClick(int userId) {
        Intent userDetailsActivity = new Intent(MainActivity.this, UserDetailsActivity.class);
        userDetailsActivity.putExtra("userId",userId);
        startActivity(userDetailsActivity);
        overridePendingTransition(0, 0);
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