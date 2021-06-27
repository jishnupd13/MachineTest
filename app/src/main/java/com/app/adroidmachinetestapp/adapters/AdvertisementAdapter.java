package com.app.adroidmachinetestapp.adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.app.adroidmachinetestapp.R;
import com.app.adroidmachinetestapp.databinding.ItemAdvertisementBinding;
import com.app.adroidmachinetestapp.models.AdvertisementModel;

import java.util.List;

public class AdvertisementAdapter extends RecyclerView.Adapter<AdvertisementAdapter.AdvertisementViewHolder> {

    private List<AdvertisementModel> dataModelList;
    private Context context;

    public AdvertisementAdapter(List<AdvertisementModel> dataModelList, Context context) {
        this.dataModelList = dataModelList;
        this.context = context;
    }

    @NonNull
    @Override
    public AdvertisementViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemAdvertisementBinding itemAdvertisementBinding =
                DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                        R.layout.item_advertisement, parent, false);
        return new AdvertisementViewHolder(itemAdvertisementBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull AdvertisementViewHolder holder, int position) {
        AdvertisementModel advertisementModel = dataModelList.get(position);
        Log.e("position",""+position);
        holder.itemAdvertisementBinding.imageAdvertisement1.setImageDrawable(ContextCompat.getDrawable(context, advertisementModel.getAdvertisementImage1()));
        holder.itemAdvertisementBinding.imageAdvertisement2.setImageDrawable(ContextCompat.getDrawable(context, advertisementModel.getAdvertisementImage2()));
    }

    @Override
    public int getItemCount() {
        return dataModelList.size();
    }


    public static class AdvertisementViewHolder extends RecyclerView.ViewHolder {
        private ItemAdvertisementBinding itemAdvertisementBinding;

        public AdvertisementViewHolder(ItemAdvertisementBinding itemAdvertisementBinding) {
            super(itemAdvertisementBinding.getRoot());
            this.itemAdvertisementBinding = itemAdvertisementBinding;
        }
    }
}
