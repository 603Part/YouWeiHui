package com.youweihui.tourismstore.ui.fragment;

import android.annotation.SuppressLint;
import android.support.design.widget.TabLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.youweihui.imageloader.ImageLoader;
import com.youweihui.tourismstore.R;
import com.youweihui.tourismstore.adapter.HomeTabAdapter;
import com.youweihui.tourismstore.adapter.HomeTailOrderAdapter;
import com.youweihui.tourismstore.adapter.VerticalScrollAdapter;
import com.youweihui.tourismstore.base.BaseFragment;
import com.youweihui.tourismstore.bean.HomeTailOrderEntity;
import com.youweihui.tourismstore.view.BannerView;
import com.youweihui.tourismstore.view.CustomScrollView;
import com.youweihui.tourismstore.view.NoScrollViewPager;
import com.youweihui.tourismstore.view.VerticalScrollView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by ${范泽宁} on 2018/12/10.
 */

public class HomeFragment extends BaseFragment {

    //轮播图
    @BindView(R.id.home_banner)
    BannerView bannerView;

    @BindView(R.id.home_vertical_scroll)
    VerticalScrollView scrollLayout;

    @BindView(R.id.home_recycle)
    RecyclerView recyclerView;

    @BindView(R.id.home_tb_layout)
    TabLayout tabLayout;

    @BindView(R.id.home_tb_layout2)
    TabLayout tabLayout2;

    @BindView(R.id.home_view_pager)
    NoScrollViewPager viewPager;

    @BindView(R.id.home_scroll)
    CustomScrollView customScrollView;

    @BindView(R.id.home_abroad_linear)
    LinearLayout linearLayout;

    private ArrayList<String> imgList;

    private ArrayList<String> autoList;

    private ArrayList<HomeTailOrderEntity> tailOrderList;

    private List<String> tabList;

    private List<BaseFragment> fragList;

    private VerticalScrollAdapter scrollAdapter;

    private HomeTailOrderAdapter tailOrderAdapter;

    private HomeTabAdapter homeTabAdapter;

    private ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener;

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initView() {
        fullScreen(getActivity(), false);
        imgList = new ArrayList<>();
        autoList = new ArrayList<>();
        tailOrderList = new ArrayList<>();
        fragList = new ArrayList<>();
        tabList = new ArrayList<>();

        addData();

        LinearLayoutManager manager = new LinearLayoutManager(context);
        manager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(manager);

        scrollAdapter = new VerticalScrollAdapter(new ArrayList<String>());
        homeTabAdapter = new HomeTabAdapter(getActivity().getSupportFragmentManager());
        tailOrderAdapter = new HomeTailOrderAdapter(new ArrayList<HomeTailOrderEntity>());

        scrollLayout.setAdapter(scrollAdapter);
        scrollAdapter.setList(autoList);
        recyclerView.setAdapter(tailOrderAdapter);
        viewPager.setAdapter(homeTabAdapter);
        tailOrderAdapter.setData(tailOrderList);

        setBannerData();
        setTailOrder();
    }

    private void setBannerData() {
        List<View> list = new ArrayList<>();

        for (int i = 0; i < imgList.size(); i++) {
            ImageView imageView = new ImageView(getActivity());
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            ImageLoader.showToImageView(context, imageView, imgList.get(i).toString());
            list.add(imageView);
        }

        bannerView.setPageViewPics(list);

        bannerView.setOnPageViewClicked(new BannerView.OnPageViewClicked() {
            @Override
            public void onPageViewClicked(int position) {

            }
        });
    }

    private void setTailOrder() {
        for (int i = 0; i < tabList.size(); i++) {
            fragList.add(HomeTabFragment.newInstance(tabList.get(i).toString()));
            tabLayout.addTab(tabLayout.newTab());
            tabLayout2.addTab(tabLayout2.newTab());
        }

        viewPager.setOffscreenPageLimit(2);

        viewPager.setCurrentItem(0);

        tabLayout.setTabMode(tabList.size() <= 4 ? TabLayout.MODE_FIXED : TabLayout.MODE_SCROLLABLE);
        tabLayout2.setTabMode(tabList.size() <= 4 ? TabLayout.MODE_FIXED : TabLayout.MODE_SCROLLABLE);
        tabLayout.setSelectedTabIndicatorColor(getResources().getColor(R.color.orange));
        tabLayout2.setSelectedTabIndicatorColor(getResources().getColor(R.color.orange));

//        tabLayout.setSelectedTabIndicatorHeight((int) getResources().getDimension(R.dimen.indicatorHeight));

        onGlobalLayoutListener = new ViewTreeObserver.OnGlobalLayoutListener() {
            @SuppressLint("NewApi")
            @Override
            public void onGlobalLayout() {
                tabLayout2.setTranslationY(tabLayout.getTop());
                tabLayout2.setVisibility(View.VISIBLE);
                viewPager.getViewTreeObserver().removeOnGlobalLayoutListener(onGlobalLayoutListener);
            }
        };

        viewPager.getViewTreeObserver().addOnGlobalLayoutListener(onGlobalLayoutListener);

        customScrollView.setCallbacks(new CustomScrollView.Callbacks() {
            @Override
            public void onScrollChanged(int x, int y, int oldx, int oldy) {
                int translation = Math.max(y, tabLayout.getTop());
                tabLayout2.setTranslationY(translation);
                if (y - 50 * 3 > tabLayout2.getHeight() - 10) {
                    fullScreen(getActivity(), true);
                } else {
                    fullScreen(getActivity(), false);
                }
            }
        });

        tabLayout2.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        homeTabAdapter.setData(fragList, tabList);

        tabLayout.setupWithViewPager(viewPager);
        tabLayout2.setupWithViewPager(viewPager);
    }

    private void addData() {
        autoList.add("");
        autoList.add("");
        autoList.add("");
        autoList.add("");
        autoList.add("");
        autoList.add("");

        HomeTailOrderEntity entity1 = new HomeTailOrderEntity();
        HomeTailOrderEntity entity2 = new HomeTailOrderEntity();
        HomeTailOrderEntity entity3 = new HomeTailOrderEntity();
        HomeTailOrderEntity entity4 = new HomeTailOrderEntity();
        HomeTailOrderEntity entity5 = new HomeTailOrderEntity();
        HomeTailOrderEntity entity6 = new HomeTailOrderEntity();
        HomeTailOrderEntity entity7 = new HomeTailOrderEntity();
        HomeTailOrderEntity entity8 = new HomeTailOrderEntity();

        entity1.setImg("http://you.lumeilvyou3.cn/wenda/01/images/b2367f36779e3fa7fe3a2c131b3d7a84.jpg");
        entity8.setImg("http://you.lumeilvyou3.cn/wenda/01/images/b2367f36779e3fa7fe3a2c131b3d7a84.jpg");
        entity2.setImg("http://you.lumeilvyou3.cn/wenda/01/images/a6ad9024c244ffbd20427c37a1e691a8.jpg");
        entity7.setImg("http://you.lumeilvyou3.cn/wenda/01/images/55b79ae2e0296aef854d03289e4f0664.jpg");
        entity3.setImg("http://you.lumeilvyou3.cn/wenda/01/images/55b79ae2e0296aef854d03289e4f0664.jpg");
        entity4.setImg("http://you.lumeilvyou3.cn/wenda/01/images/eecdc2b9be66398a43d57430138cef4a.jpg");
        entity6.setImg("http://you.lumeilvyou3.cn/wenda/01/images/eecdc2b9be66398a43d57430138cef4a.jpg");
        entity5.setImg("http://you.lumeilvyou3.cn/wenda/01/images/a6ad9024c244ffbd20427c37a1e691a8.jpg");

        tailOrderList.add(entity1);
        tailOrderList.add(entity2);
        tailOrderList.add(entity3);
        tailOrderList.add(entity4);
        tailOrderList.add(entity5);
        tailOrderList.add(entity7);
        tailOrderList.add(entity8);
        tailOrderList.add(entity6);

        tabList.add("推荐");
        tabList.add("当季热门");
        tabList.add("海岛");
        tabList.add("名胜古迹");
        tabList.add("旅游景点");
        tabList.add("上海");
        tabList.add("广州");
        tabList.add("北京");
        tabList.add("更多地方");

        imgList.add("http://img17.3lian.com/d/file/201702/16/17cd567662bafc8d63d73d41444585d2.jpg");
        imgList.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1544426740841&di=1aa67a38806d3cb35d77a1e9bce4d707&imgtype=0&src=http%3A%2F%2Fimg.pptjia.com%2Fimage%2F20180117%2Ff4b76385a3ccdbac48893cc6418806d5.jpg");
        imgList.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1544426787463&di=423811f8e34002b14a8039e9ec53bf75&imgtype=0&src=http%3A%2F%2Fimg17.3lian.com%2Fd%2Ffile%2F201701%2F09%2F7d3cdc209be727aef32d28795dd58b3b.jpg");

    }
}
