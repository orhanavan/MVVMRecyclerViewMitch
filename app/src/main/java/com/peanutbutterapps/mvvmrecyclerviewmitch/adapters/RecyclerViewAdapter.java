package com.peanutbutterapps.mvvmrecyclerviewmitch.adapters;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.peanutbutterapps.mvvmrecyclerviewmitch.R;
import com.peanutbutterapps.mvvmrecyclerviewmitch.databinding.ItemLayoutBinding;
import com.peanutbutterapps.mvvmrecyclerviewmitch.models.NicePlace;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    private Context context;
    private List<NicePlace> placeList;

    public RecyclerViewAdapter(Context context, List<NicePlace> placeList) {
        this.context = context;
        this.placeList = placeList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        ItemLayoutBinding itemLayoutBinding = DataBindingUtil.inflate(
                LayoutInflater.from(viewGroup.getContext()), R.layout.item_layout, viewGroup, false);

        return new MyViewHolder(itemLayoutBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        NicePlace nicePlace = placeList.get(i);
        myViewHolder.itemLayoutBinding.setNicePlace(nicePlace);
    }

    @Override
    public int getItemCount() {
        return placeList.size();
    }


    class MyViewHolder extends RecyclerView.ViewHolder {

        ItemLayoutBinding itemLayoutBinding;

        public MyViewHolder(@NonNull ItemLayoutBinding itemView) {
            super(itemView.getRoot());
            itemLayoutBinding = itemView;
        }
    }

}
