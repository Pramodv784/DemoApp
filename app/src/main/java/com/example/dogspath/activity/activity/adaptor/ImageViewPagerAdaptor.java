package com.example.dogspath.activity.activity.adaptor;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.bumptech.glide.Glide;
import com.example.dogspath.R;
import com.example.dogspath.activity.activity.model.SubPath;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ImageViewPagerAdaptor extends PagerAdapter {
    Context context;
    List<SubPath> subPaths;

    LayoutInflater layoutInflater;

    public ImageViewPagerAdaptor(Context context, List<SubPath> subPaths) {
        this.context = context;
        this.subPaths = subPaths;
        layoutInflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return subPaths.size();
    }

    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View viewitem = layoutInflater.inflate(R.layout.imagelist, container, false);
        ImageView imageView = viewitem.findViewById(R.id.image);
        TextView textView=viewitem.findViewById(R.id.image_title);
        Glide.with(context).load(subPaths.get(position).getImage()).into(imageView);
        textView.setText(subPaths.get(position).getTitle());
        Objects.requireNonNull(container).addView(viewitem);
          return viewitem;
    }
    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view==((RelativeLayout) object);
    }
        @Override
        public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
            container.removeView((RelativeLayout) object);
        }
}
