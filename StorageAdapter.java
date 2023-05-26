package com.mirea.kt.android2023.homework2_12;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class StorageAdapter extends RecyclerView.Adapter<StorageAdapter.ViewHolder> {

    private ArrayList<Storage> storages;


    public StorageAdapter(ArrayList<Storage> storages){
        this.storages = storages;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView nameView;
        private final TextView addressView;
        private final TextView openView;
        private final TextView closeView;

        ViewHolder(View view){
            super(view);
            addressView = view.findViewById(R.id.tvStorageAddress);
            nameView = view.findViewById(R.id.tvStorageName);
            openView = view.findViewById(R.id.tvStorageOpen);
            closeView = view.findViewById(R.id.tvStorageClose);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_persons,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StorageAdapter.ViewHolder holder, int position) {
        Storage storage = storages.get(position);
        holder.addressView.setText(String.format(storage.getAddress()));
        holder.nameView.setText(String.format(storage.getName()));
        holder.openView.setText(String.format(storage.getOpen()));
        holder.closeView.setText(String.format(storage.getClose()));
    }

    @Override
    public int getItemCount() {
        return storages.size();
    }
}
