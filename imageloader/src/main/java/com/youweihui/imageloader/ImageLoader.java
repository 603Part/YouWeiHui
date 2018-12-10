package com.youweihui.imageloader;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.io.File;

public final class ImageLoader {

    private static final String TAG = "ImageLoader";

    private ImageLoader() {

    }

    public static void showToImageView(Context mContext, ImageView imageView, String target) {
        Glide.with(mContext).load(target).into(imageView);
    }
}
