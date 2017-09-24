package com.android.shake;

import com.android.shake.bean.MapEntity;
import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.baidu.mapapi.SDKInitializer;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.jazz.libs.controller.BaseApplication;

import org.greenrobot.eventbus.EventBus;

/**
 * Created by NoName on 2017/9/24.
 */

public class MainApplication extends BaseApplication implements BDLocationListener{
    public static MainApplication instance = null;
    LocationClient mClient;
    int count = 0;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        Fresco.initialize(this);
        SDKInitializer.initialize(this);
        mClient = new LocationClient(this);
        mClient.setLocOption(getClientOptions());
        mClient.registerLocationListener(this);
    }

    @Override
    public void onReceiveLocation(BDLocation bdLocation) {
        MapEntity map = new MapEntity();
        map.setCode(bdLocation.getLocType());
        if(bdLocation.getLocType() == 61 || bdLocation.getLocType() == 161 || count > 3){
            String time  = bdLocation.getTime();
            map.setTime(time != null && time.matches("\\d+") ? Long.valueOf(time) : System.currentTimeMillis());
            map.setLatLng(bdLocation.getLatitude(), bdLocation.getLongitude());
            map.setCity(bdLocation.getCity());
            map.setDistrict(bdLocation.getDistrict());
            map.setStreet(bdLocation.getStreet());
            map.setLocationDescribe(bdLocation.getLocationDescribe());
            map.setRadius((int)bdLocation.getRadius());
            stop();
            count = 0;
        }
        count++;
        EventBus.getDefault().post(map);
    }

    public void start(){
        mClient.start();
    }

    public void stop(){
        mClient.stop();
    }

    private LocationClientOption getClientOptions(){
        LocationClientOption option = new LocationClientOption();
        option.setLocationMode(LocationClientOption.LocationMode.Hight_Accuracy); //可选，默认高精度，设置定位模式，高精度，低功耗，仅设备
        option.setCoorType("bd09ll"); //可选，默认gcj02，设置返回的定位结果坐标系
        option.setScanSpan(2000); //可选，默认0，即仅定位一次，设置发起定位请求的间隔需要大于等于1000ms才是有效的
        option.setIsNeedAddress(true);//可选，设置是否需要地址信息，默认不需要
        option.setOpenGps(true);//可选，默认false,设置是否使用gps
        option.setLocationNotify(true);//可选，默认false，设置是否当GPS有效时按照1S/1次频率输出GPS结果
        option.setIsNeedLocationDescribe(true);//可选，默认false，设置是否需要位置语义化结果，可以在BDLocation.getLocationDescribe里得到，结果类似于“在北京天安门附近”
//        option.setIsNeedLocationPoiList(true); //可选，默认false，设置是否需要POI结果，可以在BDLocation.getPoiList里得到
        option.setIgnoreKillProcess(true);//可选，默认true，定位SDK内部是一个SERVICE，并放到了独立进程，设置是否在stop的时候杀死这个进程，默认不杀死
        option.setEnableSimulateGps(false);//可选，默认false，设置是否需要过滤GPS仿真结果，默认需要
//        option.setWifiValidTime(5*60*1000);//可选，7.2版本新增能力，如果您设置了这个接口，首次启动定位时，会先判断当前WiFi是否超出有效期，超出有效期的话，会先重新扫描WiFi，然后再定位
        return option;
    }


}
