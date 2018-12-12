package com.youweihui.tourismstore.ui.fragment;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.youweihui.tourismstore.R;
import com.youweihui.tourismstore.adapter.ForumTabRecycleAdapter;
import com.youweihui.tourismstore.adapter.ForumTabRecycleAdapter2;
import com.youweihui.tourismstore.adapter.ShopTabRecycleAdapter;
import com.youweihui.tourismstore.base.BaseFragment;
import com.youweihui.tourismstore.bean.ShopTabEntity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by ${范泽宁} on 2018/12/11.
 */

public class ForumTabFragment extends BaseFragment {

    @BindView(R.id.forum_tab_recycle1)
    RecyclerView recyclerView1;

    @BindView(R.id.forum_tab_recycle2)
    RecyclerView recyclerView2;

    public static final String TITLE = "tabTitle";

    private ForumTabRecycleAdapter recycleAdapter;
    private ForumTabRecycleAdapter2 recycleAdapter2;

    public static ForumTabFragment newInstance(String tabTitle) {
        Bundle bundle = new Bundle();
        ForumTabFragment fragment = new ForumTabFragment();
        bundle.putString(TITLE, tabTitle);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_forum_tab;
    }

    @Override
    protected void initView() {
        recycleAdapter = new ForumTabRecycleAdapter(new ArrayList<ShopTabEntity>());
        recycleAdapter2 = new ForumTabRecycleAdapter2(new ArrayList<ShopTabEntity>());
        recyclerView1.setLayoutManager(new LinearLayoutManager(context));
        recyclerView2.setLayoutManager(new LinearLayoutManager(context));
        recyclerView1.setAdapter(recycleAdapter);
        recyclerView2.setAdapter(recycleAdapter2);
        addData();
    }

    private void addData(){
        List<ShopTabEntity> list = new ArrayList<>();

        ShopTabEntity entity1 = new ShopTabEntity();
        ShopTabEntity entity2 = new ShopTabEntity();
        ShopTabEntity entity3 = new ShopTabEntity();
        ShopTabEntity entity4 = new ShopTabEntity();
        ShopTabEntity entity5 = new ShopTabEntity();
        ShopTabEntity entity6 = new ShopTabEntity();
        ShopTabEntity entity7 = new ShopTabEntity();
        ShopTabEntity entity8 = new ShopTabEntity();
        ShopTabEntity entity9 = new ShopTabEntity();
        ShopTabEntity entity10 = new ShopTabEntity();
        ShopTabEntity entity11 = new ShopTabEntity();
        ShopTabEntity entity12 = new ShopTabEntity();
        ShopTabEntity entity13 = new ShopTabEntity();
        ShopTabEntity entity14 = new ShopTabEntity();
        ShopTabEntity entity15 = new ShopTabEntity();
        ShopTabEntity entity16 = new ShopTabEntity();
        ShopTabEntity entity17 = new ShopTabEntity();
        ShopTabEntity entity18 = new ShopTabEntity();
        ShopTabEntity entity19 = new ShopTabEntity();
        ShopTabEntity entity20 = new ShopTabEntity();

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
