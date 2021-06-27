package com.app.adroidmachinetestapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.app.adroidmachinetestapp.R;
import com.app.adroidmachinetestapp.databinding.ItemNewArrivalsBinding;
import com.app.adroidmachinetestapp.models.NewArrivalsModel;

import java.util.List;

public class NewArrivalAdapter extends RecyclerView.Adapter<NewArrivalAdapter.NewArrivalAdapterViewHolder> {

    private List<NewArrivalsModel> dataModelList;
    private Context context;

    public NewArrivalAdapter(List<NewArrivalsModel> dataModelList, Context context) {
        this.dataModelList = dataModelList;
        this.context = context;
    }

    @NonNull
    @Override
    public NewArrivalAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        ItemNewArrivalsBinding itemNewArrivalsBinding =
                DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                        R.layout.item_new_arrivals, parent, false);
        return new NewArrivalAdapterViewHolder(itemNewArrivalsBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull NewArrivalAdapterViewHolder holder, int position) {

        NewArrivalsModel newArrivalsModel = dataModelList.get(position);
        holder.itemNewArrivalsBinding.textProductName.setText(newArrivalsModel.getProductName());
        holder.itemNewArrivalsBinding.textProductRate.setText(newArrivalsModel.getProductSubHeading());
        holder.itemNewArrivalsBinding.imageNewArrival.setImageDrawable(ContextCompat.getDrawable(context, newArrivalsModel.getDrawableImage()));

    }

    @Override
    public int getItemCount() {
        return dataModelList.size();
    }


    public static class NewArrivalAdapterViewHolder extends RecyclerView.ViewHolder {
        private ItemNewArrivalsBinding itemNewArrivalsBinding;

        public NewArrivalAdapterViewHolder(ItemNewArrivalsBinding itemNewArrivalsBinding) {
            super(itemNewArrivalsBinding.getRoot());
            this.itemNewArrivalsBinding = itemNewArrivalsBinding;
        }
    }
}
