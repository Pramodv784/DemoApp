package com.example.dogspath.activity.activity.adaptor;

import android.content.Context;
import android.media.Image;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.example.dogspath.R;
import com.example.dogspath.activity.activity.model.ImageUpload;

import java.util.ArrayList;
import java.util.List;

public class ListAdaptor extends RecyclerView.Adapter<ListAdaptor.ViewHolder> {
    ArrayList<ImageUpload> imagelist;
    Context context;
    List<ImageUpload> list;


    public ListAdaptor(Context context, ArrayList<ImageUpload> imagelist, List<ImageUpload> list) {
        this.context = context;
        this.imagelist = imagelist;
        this.list = list;
    }

    @NonNull
    @Override
    public ListAdaptor.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.list_design, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ListAdaptor.ViewHolder holder, int position) {
        final ImageUpload imageUpload = list.get(position);

        if (imageUpload.getTitle() != null && imageUpload.getSubPaths() != null) {
            holder.tittleTV.setText(imageUpload.getTitle());
            holder.subTittleTV.setText(String.valueOf(imageUpload.getSubPaths().size()) + "  Sub Paths");
        }
        ImageViewPagerAdaptor viewPagerAdaptor = new ImageViewPagerAdaptor(context,imageUpload.getSubPaths());
        holder.listViewPager.setAdapter(viewPagerAdaptor);
        TextListAdaptor textListAdaptor = new TextListAdaptor(context,imagelist,list);
        holder.recyclerView.setLayoutManager(new LinearLayoutManager(context,RecyclerView.HORIZONTAL,false));
        holder.recyclerView.setAdapter(textListAdaptor);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ViewPager listViewPager;
        TextView tittleTV, subTittleTV;
        RecyclerView recyclerView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.listViewPager = (ViewPager) itemView.findViewById(R.id.view_pager);
            this.tittleTV = (TextView) itemView.findViewById(R.id.tv_tittle);
            this.subTittleTV = (TextView) itemView.findViewById(R.id.tv_image_size);
            this.recyclerView = (RecyclerView) itemView.findViewById(R.id.recycle);
        }
    }
}
