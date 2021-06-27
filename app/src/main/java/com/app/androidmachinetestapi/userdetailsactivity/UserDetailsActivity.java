package com.app.androidmachinetestapi.userdetailsactivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.app.androidmachinetestapi.R;
import com.app.androidmachinetestapi.databinding.ActivityUserDetailsBinding;
import com.app.androidmachinetestapi.models.UserDetailsModel;
import com.app.androidmachinetestapi.remotenetwork.ApiClient;
import com.app.androidmachinetestapi.remotenetwork.ApiInterface;
import com.bumptech.glide.Glide;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserDetailsActivity extends AppCompatActivity {

    ActivityUserDetailsBinding binding;

    ApiInterface apiInterface;

    Call<UserDetailsModel> userCall;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_user_details);
        apiInterface = ApiClient.getClient().create(ApiInterface.class);

        binding.appLoader.setVisibility(View.VISIBLE);
        binding.layoutUserDetails.setVisibility(View.GONE);

        binding.imageBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        int userId = getIntent().getIntExtra("userId", 0);

        if (userId != 0) {
            userCall = apiInterface.getUserDetailsById(userId);
            userCall.enqueue(new Callback<UserDetailsModel>() {
                @Override
                public void onResponse(Call<UserDetailsModel> call, Response<UserDetailsModel> response) {

                    binding.appLoader.setVisibility(View.GONE);
                    binding.layoutUserDetails.setVisibility(View.VISIBLE);

                    if (response.isSuccessful()) {
                        binding.textEmail.setText("Email: "+response.body().data.email);
                        binding.textUserName.setText("Name: "+response.body().data.first_name + " " + response.body().data.last_name);
                        binding.textUserId.setText("User Id: "+Integer.toString(response.body().data.id));

                        Glide.with(UserDetailsActivity.this)
                                .load(response.body().data.avatar)
                                .centerCrop()
                                .placeholder(R.drawable.ic_person)
                                .into(binding.imageUser);

                    } else {
                        Toast.makeText(UserDetailsActivity.this, "Sorry Something went wrong! Please Try Again", Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<UserDetailsModel> call, Throwable t) {

                    binding.appLoader.setVisibility(View.GONE);
                    binding.layoutUserDetails.setVisibility(View.VISIBLE);
                }
            });
        }

    }

    @Override
    public void onBackPressed() {
        finish();
        overridePendingTransition(0,0);
    }
}