package com.youweihui.tourismstore.ui.fragment;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.youweihui.imageloader.ImageLoader;
import com.youweihui.tourismstore.R;
import com.youweihui.tourismstore.adapter.HomeTabAdapter;
import com.youweihui.tourismstore.adapter.HomeTailOrderAdapter;
import com.youweihui.tourismstore.adapter.VerticalScrollAdapter;
import com.youweihui.tourismstore.base.BaseFragment;
import com.youweihui.tourismstore.bean.HomeTailOrderEntity;
import com.youweihui.tourismstore.view.BannerView;
import com.youweihui.tourismstore.view.NoScrollViewPager;
import com.youweihui.tourismstore.view.VerticalScrollView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

import static android.content.Context.WINDOW_SERVICE;

/**
 * Created by ${范泽宁} on 2018/12/10.
 */

public class HomeFragment extends BaseFragment implements NestedScrollView.OnScrollChangeListener {

    //轮播图
    @BindView(R.id.home_banner)
    BannerView bannerView;

    @BindView(R.id.home_vertical_scroll)
    VerticalScrollView scrollLayout;

    @BindView(R.id.home_recycle)
    RecyclerView recyclerView;

    @BindView(R.id.home_tb_layout)
    TabLayout tabLayout;

    @BindView(R.id.home_view_pager)
    NoScrollViewPager viewPager;

    @BindView(R.id.home_scroll)
    NestedScrollView nestedScrollView;

    @BindView(R.id.home_abroad_linear)
    LinearLayout linearLayout;

    @BindView(R.id.home_frame)
    FrameLayout frameLayout;

    private ArrayList<String> imgList;

    private ArrayList<String> autoList;

    private ArrayList<HomeTailOrderEntity> tailOrderList;

    private List<String> tabList;

    private List<BaseFragment> fragList;

    private VerticalScrollAdapter scrollAdapter;

    private HomeTailOrderAdapter tailOrderAdapter;

    private HomeTabAdapter homeTabAdapter;

    private float tabBeginY;

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initView() {
        fullScreen(getActivity(),false);
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

        nestedScrollView.setOnScrollChangeListener(this);

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
        }

        viewPager.setOffscreenPageLimit(tabList.size());

        tabLayout.setTabMode(tabList.size() <= 4 ? TabLayout.MODE_FIXED : TabLayout.MODE_SCROLLABLE);

        tabLayout.setSelectedTabIndicatorColor(getResources().getColor(R.color.orange));
//        tabLayout.setSelectedTabIndicatorHeight((int) getResources().getDimension(R.dimen.indicatorHeight));

        homeTabAdapter.setData(fragList, tabList);

        tabLayout.setupWithViewPager(viewPager);
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

    @Override
    public void onScrollChange(NestedScrollView v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
        if (tabBeginY == 0) {
            tabBeginY = tabLayout.getY();
        }

        WindowManager wm = (WindowManager) context.getSystemService(WINDOW_SERVICE);

        int screenHeight = wm.getDefaultDisplay().getHeight();

        if (nestedScrollView.getScrollY() > screenHeight) {

        } else {

        }

        if (nestedScrollView.getScrollY() > tabBeginY) {
            if (tabLayout.getParent() instanceof LinearLayout) {
                fullScreen(getActivity(),true);
                linearLayout.removeView(tabLayout);
                frameLayout.addView(tabLayout);
            }
        } else {
            if (tabLayout.getParent() instanceof FrameLayout) {
                fullScreen(getActivity(),false);
                frameLayout.removeView(tabLayout);
                linearLayout.addView(tabLayout,3);
            }
        }
    }
}
