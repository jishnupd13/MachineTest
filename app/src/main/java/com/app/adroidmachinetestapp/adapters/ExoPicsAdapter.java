package com.app.adroidmachinetestapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.app.adroidmachinetestapp.R;
import com.app.adroidmachinetestapp.databinding.ItemExoPicsAdapterBinding;
import com.app.adroidmachinetestapp.models.ExposPicsModel;

import java.util.List;

public class ExoPicsAdapter extends RecyclerView.Adapter<ExoPicsAdapter.ExoPicsViewHolder> {
    private List<ExposPicsModel> dataModelList;
    private Context context;

    public ExoPicsAdapter(List<ExposPicsModel> dataModelList, Context context) {
        this.dataModelList = dataModelList;
        this.context = context;
    }

    @NonNull
    @Override
    public ExoPicsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemExoPicsAdapterBinding itemExoPicsAdapterBinding =
                DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                        R.layout.item_exo_pics_adapter, parent, false);
        return new ExoPicsViewHolder(itemExoPicsAdapterBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull ExoPicsViewHolder holder, int position) {
        ExposPicsModel exposPicsModel=dataModelList.get(position);
        holder.itemExoPicsAdapterBinding.imageFood.setImageDrawable(ContextCompat.getDrawable(context, exposPicsModel.getDrawable()));
        holder.itemExoPicsAdapterBinding.textFoodName.setText(exposPicsModel.getFoodName());
        holder.itemExoPicsAdapterBinding.textFoodTime.setText(exposPicsModel.getFoodTime());
    }

    @Override
    public int getItemCount() {
        return dataModelList.size();
    }


    public static class ExoPicsViewHolder extends RecyclerView.ViewHolder {
        private ItemExoPicsAdapterBinding itemExoPicsAdapterBinding;

        public ExoPicsViewHolder(ItemExoPicsAdapterBinding itemExoPicsAdapterBinding) {
            super(itemExoPicsAdapterBinding.getRoot());
            this.itemExoPicsAdapterBinding = itemExoPicsAdapterBinding;
        }
    }
}
