package com.youweihui.tourismstore.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.youweihui.tourismstore.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ${范泽宁} on 2018/12/11.
 */

public class HomeTabAdapter extends FragmentPagerAdapter{

    private List<BaseFragment> fragments = new ArrayList<>();

    private List<String> list = new ArrayList<>();

    public HomeTabAdapter(FragmentManager fm) {
        super(fm);

    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    public void setData(List<BaseFragment> fragments,List<String> list){
        this.fragments = fragments;
        this.list = list;
        notifyDataSetChanged();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return list.get(position);
    }
}
