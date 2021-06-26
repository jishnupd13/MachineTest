package com.app.adroidmachinetestapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.app.adroidmachinetestapp.R;
import com.app.adroidmachinetestapp.databinding.ItemStatusProductsBinding;
import com.app.adroidmachinetestapp.models.ProductStoryModel;

import java.util.List;

public class ProductStatusAdapter extends RecyclerView.Adapter<ProductStatusAdapter.ProductStoryViewHolder> {

    private List<ProductStoryModel> dataModelList;
    private Context context;

    public ProductStatusAdapter(List<ProductStoryModel> dataModelList, Context context) {
        this.dataModelList = dataModelList;
        this.context = context;
    }

    @NonNull
    @Override
    public ProductStoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        ItemStatusProductsBinding itemStatusProductsBinding =
                DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                        R.layout.item_status_products, parent, false);
        return new ProductStoryViewHolder(itemStatusProductsBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductStoryViewHolder holder, int position) {
        ProductStoryModel productStoryModel = dataModelList.get(position);
        holder.itemStatusProductsBinding.textProductName.setText(productStoryModel.getProductName());
        holder.itemStatusProductsBinding.profileImage.setImageDrawable(ContextCompat.getDrawable(context, productStoryModel.getDrawableImage()));
    }

    @Override
    public int getItemCount() {
        return dataModelList.size();
    }

    public static class ProductStoryViewHolder extends RecyclerView.ViewHolder {
        private ItemStatusProductsBinding itemStatusProductsBinding;

        public ProductStoryViewHolder(ItemStatusProductsBinding itemStatusProductsBinding) {
            super(itemStatusProductsBinding.getRoot());
            this.itemStatusProductsBinding = itemStatusProductsBinding;
        }


    }
}
