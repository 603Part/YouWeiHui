package com.youweihui.tourismstore.location.service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.support.annotation.Nullable;
import android.util.Log;

import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.youweihui.tourismstore.location.callback.LocationListener;
import com.youweihui.tourismstore.utils.Utils;


public class LocationService extends Service implements AMapLocationListener {
    private static final String TAG = "LocationService";
    private LocationBinder mBinder = new LocationBinder();

    private LocationListener mLocationListener;
    private AMapLocationClient locationClient = null;
    private AMapLocationClientOption locationOption = null;

    @Override
    public void onCreate() {
        super.onCreate();
        initLocation();
    }

    private void initLocation() {
        locationClient = new AMapLocationClient(this);
        locationOption = getDefaultOption();
        locationClient.setLocationListener(this);
    }

    /**
     * 默认的定位参数
     */
    private AMapLocationClientOption getDefaultOption(){
        AMapLocationClientOption mOption = new AMapLocationClientOption();
        mOption.setLocationMode(AMapLocationClientOption.AMapLocationMode.Hight_Accuracy);
        mOption.setGpsFirst(false);
        mOption.setHttpTimeOut(30000);
        mOption.setNeedAddress(true);
        mOption.setOnceLocation(true); // 单次定位
        mOption.setOnceLocationLatest(false);
        AMapLocationClientOption.setLocationProtocol(AMapLocationClientOption.AMapLocationProtocol.HTTP);
        mOption.setSensorEnable(false);
        mOption.setWifiScan(true);
        mOption.setLocationCacheEnable(true);
        mOption.setGeoLanguage(AMapLocationClientOption.GeoLanguage.DEFAULT);
        return mOption;
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return mBinder;
    }

    public void setmLocationListener(LocationListener mLocationListener) {
        this.mLocationListener = mLocationListener;
    }

    @Override
    public void onLocationChanged(AMapLocation location) {
        if (null != location) {

            StringBuffer sb = new StringBuffer();
            //errCode等于0代表定位成功，其他的为定位失败，具体的可以参照官网定位错误码说明
            if(location.getErrorCode() == 0){
                sb.append("定位成功" + "\n");
                sb.append("定位类型: " + location.getLocationType() + "\n");
                sb.append("经    度    : " + location.getLongitude() + "\n");
                sb.append("纬    度    : " + location.getLatitude() + "\n");
                sb.append("精    度    : " + location.getAccuracy() + "米" + "\n");
                sb.append("提供者    : " + location.getProvider() + "\n");

                sb.append("速    度    : " + location.getSpeed() + "米/秒" + "\n");
                sb.append("角    度    : " + location.getBearing() + "\n");
                // 获取当前提供定位服务的卫星个数
                sb.append("星    数    : " + location.getSatellites() + "\n");
                sb.append("国    家    : " + location.getCountry() + "\n");
                sb.append("省            : " + location.getProvince() + "\n");
                sb.append("市            : " + location.getCity() + "\n");
                sb.append("城市编码 : " + location.getCityCode() + "\n");
                sb.append("区            : " + location.getDistrict() + "\n");
                sb.append("区域 码   : " + location.getAdCode() + "\n");
                sb.append("地    址    : " + location.getAddress() + "\n");
                sb.append("兴趣点    : " + location.getPoiName() + "\n");
                //定位完成的时间
                sb.append("定位时间: " + Utils.formatUTC(location.getTime(), "yyyy-MM-dd HH:mm:ss") + "\n");
                mLocationListener.onSuccess(location.getProvince(),location.getCity(),location.getDistrict());
            } else {
                //定位失败
                sb.append("定位失败" + "\n");
                sb.append("错误码:" + location.getErrorCode() + "\n");
                sb.append("错误信息:" + location.getErrorInfo() + "\n");
                sb.append("错误描述:" + location.getLocationDetail() + "\n");
                mLocationListener.onFailure(location.getErrorInfo(),location.getErrorCode()+"");
                // TODO 延迟操作
                startLocation(); // 定位失败后一直尝试重新定位

            }
            sb.append("***定位质量报告***").append("\n");
            sb.append("* WIFI开关：").append(location.getLocationQualityReport().isWifiAble() ? "开启":"关闭").append("\n");
            sb.append("* GPS星数：").append(location.getLocationQualityReport().getGPSSatellites()).append("\n");
            sb.append("* 网络类型：" + location.getLocationQualityReport().getNetworkType()).append("\n");
            sb.append("* 网络耗时：" + location.getLocationQualityReport().getNetUseTime()).append("\n");
            sb.append("****************").append("\n");
            //定位之后的回调时间
            sb.append("回调时间: " + Utils.formatUTC(System.currentTimeMillis(), "yyyy-MM-dd HH:mm:ss") + "\n");

            //解析定位结果，
            String result = sb.toString();
            Log.d(TAG, "onLocationChanged: " + result);
        } else {
            Log.d(TAG, "onLocationChanged: 定位失败");
            mLocationListener.onFailure("未知原因","-1");
        }
    }

    private void startLocation() {
        locationClient.setLocationOption(locationOption);
        locationClient.startLocation();
    }


    public class LocationBinder extends Binder {

        public LocationService getInstance() {
            return LocationService.this;
        }

        public void getCurrentLocation() {
            startLocation();
        }
    }

}
