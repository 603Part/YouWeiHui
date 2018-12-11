package com.youweihui.tourismstore.ui.fragment;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.youweihui.tourismstore.R;
import com.youweihui.tourismstore.adapter.HomeTabRecycleAdapter;
import com.youweihui.tourismstore.base.BaseFragment;
import com.youweihui.tourismstore.bean.HomeTabEntity;
import com.youweihui.tourismstore.bean.HomeTailOrderEntity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by ${范泽宁} on 2018/12/11.
 */

public class HomeTabFragment extends BaseFragment {

    @BindView(R.id.home_tab_recycle)
    RecyclerView recyclerView;

    public static final String TITLE = "tabTitle";

    private HomeTabRecycleAdapter recycleAdapter;

    public static HomeTabFragment newInstance(String tabTitle) {
        Bundle bundle = new Bundle();
        HomeTabFragment fragment = new HomeTabFragment();
        bundle.putString(TITLE, tabTitle);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_home_tab;
    }

    @Override
    protected void initView() {
        recycleAdapter = new HomeTabRecycleAdapter(new ArrayList<HomeTabEntity>());
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setAdapter(recycleAdapter);
        addData();
    }

    private void addData(){
        List<HomeTabEntity> list = new ArrayList<>();

        HomeTabEntity entity1 = new HomeTabEntity();
        HomeTabEntity entity2 = new HomeTabEntity();
        HomeTabEntity entity3 = new HomeTabEntity();
        HomeTabEntity entity4 = new HomeTabEntity();
        HomeTabEntity entity5 = new HomeTabEntity();
        HomeTabEntity entity6 = new HomeTabEntity();
        HomeTabEntity entity7 = new HomeTabEntity();
        HomeTabEntity entity8 = new HomeTabEntity();
        HomeTabEntity entity9 = new HomeTabEntity();
        HomeTabEntity entity10 = new HomeTabEntity();
        HomeTabEntity entity11 = new HomeTabEntity();
        HomeTabEntity entity12 = new HomeTabEntity();
        HomeTabEntity entity13 = new HomeTabEntity();
        HomeTabEntity entity14 = new HomeTabEntity();
        HomeTabEntity entity15 = new HomeTabEntity();
        HomeTabEntity entity16 = new HomeTabEntity();
        HomeTabEntity entity17 = new HomeTabEntity();
        HomeTabEntity entity18 = new HomeTabEntity();
        HomeTabEntity entity19 = new HomeTabEntity();
        HomeTabEntity entity20 = new HomeTabEntity();

        entity1.setImg("http://you.lumeilvyou3.cn/wenda/01/images/b2367f36779e3fa7fe3a2c131b3d7a84.jpg");
        entity8.setImg("http://you.lumeilvyou3.cn/wenda/01/images/b2367f36779e3fa7fe3a2c131b3d7a84.jpg");
        entity2.setImg("http://you.lumeilvyou3.cn/wenda/01/images/a6ad9024c244ffbd20427c37a1e691a8.jpg");
        entity7.setImg("http://you.lumeilvyou3.cn/wenda/01/images/55b79ae2e0296aef854d03289e4f0664.jpg");
        entity3.setImg("http://you.lumeilvyou3.cn/wenda/01/images/55b79ae2e0296aef854d03289e4f0664.jpg");
        entity4.setImg("http://you.lumeilvyou3.cn/wenda/01/images/eecdc2b9be66398a43d57430138cef4a.jpg");
        entity6.setImg("http://you.lumeilvyou3.cn/wenda/01/images/eecdc2b9be66398a43d57430138cef4a.jpg");
        entity5.setImg("http://you.lumeilvyou3.cn/wenda/01/images/a6ad9024c244ffbd20427c37a1e691a8.jpg");

        list.add(entity1);
        list.add(entity2);
        list.add(entity3);
        list.add(entity4);
        list.add(entity5);
        list.add(entity6);
        list.add(entity7);
        list.add(entity8);
        list.add(entity9);
        list.add(entity10);
        list.add(entity11);
        list.add(entity12);
        list.add(entity13);
        list.add(entity14);
        list.add(entity15);
        list.add(entity16);
        list.add(entity17);
        list.add(entity18);
        list.add(entity19);
        list.add(entity20);

        recycleAdapter.setData(list);
    }
}
