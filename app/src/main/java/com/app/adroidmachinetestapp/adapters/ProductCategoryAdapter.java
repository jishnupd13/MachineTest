package com.app.adroidmachinetestapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.app.adroidmachinetestapp.R;
import com.app.adroidmachinetestapp.databinding.ItemCategoryListBinding;
import com.app.adroidmachinetestapp.models.ProductCategoryModel;

import java.util.List;

public class ProductCategoryAdapter extends RecyclerView.Adapter<ProductCategoryAdapter.ProductCategoryViewHolder> {

    private List<ProductCategoryModel> dataModelList;
    private Context context;

    public ProductCategoryAdapter(List<ProductCategoryModel> dataModelList, Context context) {
        this.dataModelList = dataModelList;
        this.context = context;
    }

    @NonNull
    @Override
    public ProductCategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        ItemCategoryListBinding itemCategoryListBinding =
                DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                        R.layout.item_category_list, parent, false);
        return new ProductCategoryViewHolder(itemCategoryListBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductCategoryViewHolder holder, int position) {
        ProductCategoryModel productCategoryModel = dataModelList.get(position);
        holder.itemCategoryListBinding.textCategoryName.setText(productCategoryModel.getCategoryName());
        holder.itemCategoryListBinding.imageCategories.setImageDrawable(ContextCompat.getDrawable(context, productCategoryModel.getDrawableImage()));

    }

    @Override
    public int getItemCount() {
        return dataModelList.size();
    }

    public static class ProductCategoryViewHolder extends RecyclerView.ViewHolder {
        private ItemCategoryListBinding itemCategoryListBinding;


        public ProductCategoryViewHolder(ItemCategoryListBinding itemCategoryListBinding) {
            super(itemCategoryListBinding.getRoot());
            this.itemCategoryListBinding = itemCategoryListBinding;
        }
    }
}
