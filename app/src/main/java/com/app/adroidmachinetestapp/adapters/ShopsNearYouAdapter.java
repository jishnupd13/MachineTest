package com.app.adroidmachinetestapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.app.adroidmachinetestapp.R;
import com.app.adroidmachinetestapp.databinding.ItemShopsNearBinding;
import com.app.adroidmachinetestapp.models.ProductCategoryModel;
import com.app.adroidmachinetestapp.models.ShopsNearYouModel;

import java.util.List;

public class ShopsNearYouAdapter extends RecyclerView.Adapter<ShopsNearYouAdapter.ShopNearYouViewHolder> {

    private List<ShopsNearYouModel> dataModelList;
    private Context context;

    public ShopsNearYouAdapter(List<ShopsNearYouModel> dataModelList, Context context) {
        this.dataModelList = dataModelList;
        this.context = context;
    }

    @NonNull
    @Override
    public ShopNearYouViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemShopsNearBinding itemShopsNearBinding =
                DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                        R.layout.item_shops_near, parent, false);
        return new ShopNearYouViewHolder(itemShopsNearBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull ShopNearYouViewHolder holder, int position) {

        ShopsNearYouModel shopsNearYouModel = dataModelList.get(position);
        holder.itemShopsNearBinding.textShopName.setText(shopsNearYouModel.getShopName());
        holder.itemShopsNearBinding.imageShops.setImageDrawable(ContextCompat.getDrawable(context, shopsNearYouModel.getDrawableImage()));

    }

    @Override
    public int getItemCount() {
        return dataModelList.size();
    }

    public static class ShopNearYouViewHolder extends RecyclerView.ViewHolder {
        private ItemShopsNearBinding itemShopsNearBinding;

        public ShopNearYouViewHolder(ItemShopsNearBinding itemShopsNearBinding) {
            super(itemShopsNearBinding.getRoot());
            this.itemShopsNearBinding = itemShopsNearBinding;
        }
    }


}
