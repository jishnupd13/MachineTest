package com.app.androidmachinetestapi.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.app.androidmachinetestapi.R;
import com.app.androidmachinetestapi.databinding.ItemUserListBinding;
import com.app.androidmachinetestapi.models.UserListModel;
import com.app.androidmachinetestapi.onitemclicklistener.OnItemClickListener;
import com.bumptech.glide.Glide;

import java.util.List;

public class UserListAdapter extends RecyclerView.Adapter<UserListAdapter.UserListViewHolder> {

    private List<UserListModel.Datum> dataModelList;
    private Context context;
    OnItemClickListener itemClickListener;

    public UserListAdapter(List<UserListModel.Datum> dataModelList, Context context, OnItemClickListener itemClickListener) {
        this.dataModelList = dataModelList;
        this.context = context;
        this.itemClickListener= itemClickListener;
    }

    @NonNull
    @Override
    public UserListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemUserListBinding itemUserListBinding =
                DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                        R.layout.item_user_list, parent, false);
        return new UserListViewHolder(itemUserListBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull UserListViewHolder holder, int position) {

        UserListModel.Datum datum=dataModelList.get(position);
        holder.itemUserListBinding.textEmail.setText(datum.email);
        holder.itemUserListBinding.textUserName.setText(datum.first_name+" "+datum.last_name);
        Glide.with(context)
                .load(datum.avatar)
                .centerCrop()
                .placeholder(R.drawable.ic_person)
                .into(holder.itemUserListBinding.imageViewUser);
        holder.itemUserListBinding.rootLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                itemClickListener.itemUserClick(datum.id);
            }
        });

    }

    @Override
    public int getItemCount() {
        return dataModelList.size();
    }

    public static class UserListViewHolder extends RecyclerView.ViewHolder {
        private ItemUserListBinding itemUserListBinding;

        public UserListViewHolder(ItemUserListBinding itemUserListBinding) {
            super(itemUserListBinding.getRoot());
            this.itemUserListBinding = itemUserListBinding;
        }
    }
}
