package com.youweihui.tourismstore.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.youweihui.tourismstore.R;

import java.util.ArrayList;
import java.util.List;

public class VerticalScrollAdapter extends BaseAdapter {

    private List<String> list;

    public VerticalScrollAdapter(List<String> list) {
        this.list = new ArrayList<>();
        this.list = list;
    }

    public void setList(List<String> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public String getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_vertical_scroll, parent, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
//        holder.title.setText(list.get(position).toString());
        return convertView;
    }

    private static class ViewHolder {
        private TextView title;

        public ViewHolder(View view) {
//            this.title = (TextView) view.findViewById(R.id.item_vertical_scroll_text);
        }
    }
}