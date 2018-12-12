package com.youweihui.tourismstore.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.youweihui.tourismstore.ui.fragment.ForumTabFragment;
import com.youweihui.tourismstore.ui.fragment.ShopTabFragment;

import java.util.ArrayList;
import java.util.List;

public class ForumTabAdapter extends FragmentPagerAdapter {

    private List<ForumTabFragment> list;

    private List<String> titles;

    public ForumTabAdapter(FragmentManager fm, ArrayList<ForumTabFragment> list, ArrayList<String> titles) {
        super(fm);
        this.list = list;
        this.titles = titles;
    }

    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles.get(position);
    }

    public void setData(List<ForumTabFragment> fragments, List<String> list){
        this.list = fragments;
        this.titles = list;
        notifyDataSetChanged();
    }
}
