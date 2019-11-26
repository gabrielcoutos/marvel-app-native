package br.com.couto.marvel.adapter;

import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class BindingAdapter {

    @androidx.databinding.BindingAdapter("imageUrl")
    public static void loadImg(ImageView view, String url){
        Picasso.get().load(url).into(view);
    }
}
