package com.example.dogspath.activity.activity.adaptor;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.example.dogspath.R;
import com.example.dogspath.activity.activity.model.ImageUpload;

import java.util.ArrayList;
import java.util.List;

public class TextListAdaptor extends RecyclerView.Adapter<TextListAdaptor.ViewHolder> {
    ArrayList<ImageUpload> imagelist;
    Context context;
    List<ImageUpload> list;


    public TextListAdaptor(Context context, ArrayList<ImageUpload> imagelist, List<ImageUpload> list) {
        this.context = context;
        this.imagelist = imagelist;
        this.list = list;
    }

    @NonNull
    @Override
    public TextListAdaptor.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.text_list_design, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull TextListAdaptor.ViewHolder holder, int position) {
        final ImageUpload imageUpload = list.get(position);

        if (imageUpload.getTitle() != null && imageUpload.getSubPaths() != null) {
          holder.textView.setText(imageUpload.getSubPaths().get(position).getTitle());
        }
      /*  ImageViewPagerAdaptor viewPagerAdaptor = new ImageViewPagerAdaptor(context,imageUpload.getSubPaths());
        holder.listViewPager.setAdapter(viewPagerAdaptor);*/

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView textView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            this.textView = (TextView) itemView.findViewById(R.id.textview);
        }
    }
}
