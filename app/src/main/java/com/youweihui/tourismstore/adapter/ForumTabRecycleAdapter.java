package com.youweihui.tourismstore.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.youweihui.imageloader.ImageLoader;
import com.youweihui.tourismstore.R;
import com.youweihui.tourismstore.bean.ShopTabEntity;

import java.util.List;

public class ForumTabRecycleAdapter extends RecyclerView.Adapter<ForumTabRecycleAdapter.viewHolder> {

    private List<ShopTabEntity> list;

    private Context context;

    public ForumTabRecycleAdapter(List<ShopTabEntity> list) {
        this.list = list;
    }

    @Override
    public viewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        context = parent.getContext();
        return new viewHolder(LayoutInflater.from(context).inflate(R.layout.item_forum1, parent, false));
    }

    @Override
    public void onBindViewHolder(viewHolder holder, int position) {
        ImageLoader.showToImageView(context,holder.imageView,list.get(position).getImg());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class viewHolder extends RecyclerView.ViewHolder {

        private ImageView imageView;
        private TextView  textView1,textView2,textView3;

        public viewHolder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.item_shop_img);
//            textView1 = (TextView) itemView.findViewById(R.id.);
//            textView2 = (TextView) itemView.findViewById(R.id.);
//            textView3 = (TextView) itemView.findViewById(R.id.);
        }
    }

    public void setData(List<ShopTabEntity> list){
        this.list = list;
        notifyDataSetChanged();
    }
}
