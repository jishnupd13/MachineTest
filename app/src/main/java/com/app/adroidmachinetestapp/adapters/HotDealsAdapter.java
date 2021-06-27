package com.app.adroidmachinetestapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.app.adroidmachinetestapp.R;
import com.app.adroidmachinetestapp.databinding.ItemHotDealsBinding;
import com.app.adroidmachinetestapp.models.HotDealsModel;

import java.util.List;

public class HotDealsAdapter extends RecyclerView.Adapter<HotDealsAdapter.HotDealsViewHolder> {

    private List<HotDealsModel> dataModelList;
    private Context context;

    public HotDealsAdapter(List<HotDealsModel> dataModelList, Context context) {
        this.dataModelList = dataModelList;
        this.context = context;
    }

    @NonNull
    @Override
    public HotDealsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemHotDealsBinding itemHotDealsBinding =
                DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                        R.layout.item_hot_deals, parent, false);
        return new HotDealsViewHolder(itemHotDealsBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull HotDealsViewHolder holder, int position) {

        HotDealsModel hotDealsModel = dataModelList.get(position);
        holder.itemHotDealsBinding.imageHotDeals.setImageDrawable(ContextCompat.getDrawable(context, hotDealsModel.getDrawableImage()));

    }

    @Override
    public int getItemCount() {
        return dataModelList.size();
    }


    public static class HotDealsViewHolder extends RecyclerView.ViewHolder {
        private ItemHotDealsBinding itemHotDealsBinding;

        public HotDealsViewHolder(ItemHotDealsBinding itemHotDealsBinding) {
            super(itemHotDealsBinding.getRoot());
            this.itemHotDealsBinding = itemHotDealsBinding;
        }
    }
}
