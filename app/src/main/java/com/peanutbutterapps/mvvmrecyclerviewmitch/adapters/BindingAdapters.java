package com.peanutbutterapps.mvvmrecyclerviewmitch.adapters;

import android.databinding.BindingAdapter;
import android.view.View;

import com.bumptech.glide.Glide;

import de.hdodenhof.circleimageview.CircleImageView;

public class BindingAdapters {

    @BindingAdapter("android:imageUrl")
    public static void loadImage(View view, String url) {
        CircleImageView circleImageView = (CircleImageView) view;
        Glide.with(view.getContext()).load(url).into(circleImageView);
    }

    @BindingAdapter("android:showIfUpdating")
    public static void showIfUpdating(View view, boolean isUpdating) {
        if (isUpdating)
            view.setVisibility(View.VISIBLE);
        else
            view.setVisibility(View.INVISIBLE);
    }
}
