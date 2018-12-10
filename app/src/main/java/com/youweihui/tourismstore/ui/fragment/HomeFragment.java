package com.youweihui.tourismstore.ui.fragment;

import android.os.Environment;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.youweihui.imageloader.ImageLoader;
import com.youweihui.tourismstore.R;
import com.youweihui.tourismstore.adapter.VerticalScrollAdapter;
import com.youweihui.tourismstore.base.BaseFragment;
import com.youweihui.tourismstore.view.BannerView;
import com.youweihui.tourismstore.view.VerticalScrollView;

import java.io.File;
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

    @BindView(R.id.home_scroll)
    VerticalScrollView scrollLayout;

    private ArrayList<String> imgList;

    private ArrayList<String> autoList;

    private VerticalScrollAdapter scrollAdapter;

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initView() {
        fullScreen(getActivity());
        imgList = new ArrayList<>();
        autoList = new ArrayList<>();
        autoList.add("");
        autoList.add("");
        autoList.add("");
        autoList.add("");
        autoList.add("");
        autoList.add("");
        scrollAdapter = new VerticalScrollAdapter(new ArrayList<String>());
        scrollLayout.setAdapter(scrollAdapter);
        scrollAdapter.setList(autoList);

        setBannerData();
    }

    private void setBannerData() {
        imgList.add("http://img17.3lian.com/d/file/201702/16/17cd567662bafc8d63d73d41444585d2.jpg");
        imgList.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1544426740841&di=1aa67a38806d3cb35d77a1e9bce4d707&imgtype=0&src=http%3A%2F%2Fimg.pptjia.com%2Fimage%2F20180117%2Ff4b76385a3ccdbac48893cc6418806d5.jpg");
        imgList.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1544426787463&di=423811f8e34002b14a8039e9ec53bf75&imgtype=0&src=http%3A%2F%2Fimg17.3lian.com%2Fd%2Ffile%2F201701%2F09%2F7d3cdc209be727aef32d28795dd58b3b.jpg");

        List<View> list = new ArrayList<>();

        for (int i = 0; i < imgList.size(); i++) {
            ImageView imageView = new ImageView(getActivity());
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            ImageLoader.showToImageView(context,imageView,imgList.get(i).toString());
            list.add(imageView);
        }

        bannerView.setPageViewPics(list);

        bannerView.setOnPageViewClicked(new BannerView.OnPageViewClicked() {
            @Override
            public void onPageViewClicked(int position) {

            }
        });
    }
}
