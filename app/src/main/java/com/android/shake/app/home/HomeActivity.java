package com.android.shake.app.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.android.shake.MainActivity;
import com.android.shake.R;
import com.android.shake.app.me.MeActivity;
import com.android.shake.app.serv.ServicesActivity;
import com.android.shake.bean.MapEntity;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.BitmapDescriptor;
import com.baidu.mapapi.map.BitmapDescriptorFactory;
import com.baidu.mapapi.map.MapStatus;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.MarkerOptions;
import com.baidu.mapapi.map.MyLocationConfiguration;
import com.baidu.mapapi.map.MyLocationData;
import com.baidu.mapapi.map.OverlayOptions;
import com.baidu.mapapi.model.LatLng;
import com.jazz.libs.viewUtil.CenterToast;

import java.util.List;

/**
 * Created by NoName on 2017/9/24.
 */

public class HomeActivity extends MainActivity<HomePresenter> {

    private static final int MAX_ZOOM = 21;
    private static final int MIN_ZOOM = 3;
    BitmapDescriptor bitmap ;

    private View mHomeServ;
    private View mHomeWw, mHomeCar;
    private com.baidu.mapapi.map.MapView mHomeMap;
    private View mHomeFresh, mHomeLocation, mHomeMe, mHomeGift;
    private View mHomeScan;

    @Override
    protected boolean isSupportCheckPermission() {
        return true;
    }

    @Override
    protected void onCreateActivity(Bundle savedInstanceState) {
        setContentView(R.layout.activity_home);
        mHomeServ = findViewById(R.id.home_serv);
        mHomeWw = findViewById(R.id.home_ww);
        mHomeCar = findViewById(R.id.home_car);
        mHomeMap = (com.baidu.mapapi.map.MapView) findViewById(R.id.home_map);
        mHomeFresh = findViewById(R.id.home_fresh);
        mHomeLocation = findViewById(R.id.home_location);
        mHomeMe = findViewById(R.id.home_me);
        mHomeGift = findViewById(R.id.home_gift);
        mHomeScan = findViewById(R.id.home_scan);
        addOnClick(mHomeServ, mHomeWw, mHomeCar, mHomeFresh, mHomeLocation, mHomeMe, mHomeGift, mHomeScan);
        bitmap = BitmapDescriptorFactory.fromResource(R.mipmap.home_point);
        setTitlePoint(false);
        initMap();
    }

    void initMap() {
        BaiduMap map = mHomeMap.getMap();
        map.setTrafficEnabled(false);
        map.setMapType(BaiduMap.MAP_TYPE_NORMAL);
        map.setBaiduHeatMapEnabled(false);
        map.setMaxAndMinZoomLevel(MAX_ZOOM, MIN_ZOOM);
    }

    @Override
    public void onClick(View v) {
        int resId = v.getId();
        switch (resId) {
            case R.id.home_serv:
                startActivity(new Intent(this, ServicesActivity.class));
                break;
            case R.id.home_ww:
                setTitlePoint(false);
                break;
            case R.id.home_car:
                setTitlePoint(true);
                break;
            case R.id.home_map:
                break;
            case R.id.home_fresh:
                getPresent().startLocation();
                break;
            case R.id.home_location:
                break;
            case R.id.home_me:
                startActivity(new Intent(this, MeActivity.class));
                break;
            case R.id.home_gift:
                break;
            case R.id.home_scan:
                break;
            default:
        }
    }

    private void setTitlePoint(boolean isCar) {
        mHomeWw.setSelected(!isCar);
        mHomeCar.setSelected(isCar);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mHomeMap.onResume();
        getPresent().startLocation();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mHomeMap.onResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mHomeMap.onDestroy();
    }

    public void showLocation(MapEntity entity) {
        if (entity.isEnable()) {
            mHomeMap.getMap().setMyLocationEnabled(true);//小图标
            MyLocationData locData = new MyLocationData.Builder()
                    .accuracy(entity.getRadius())
                    .direction(0)//图标转动多少度
                    .latitude(entity.getLatLng()[0])
                    .longitude(entity.getLatLng()[1]).build();
            mHomeMap.getMap().setMyLocationData(locData);
            mHomeMap.getMap().setMyLocationConfiguration(new MyLocationConfiguration(MyLocationConfiguration.LocationMode.NORMAL, true, bitmap));
            mHomeMap.getMap().animateMapStatus(MapStatusUpdateFactory.newMapStatus(new MapStatus.Builder().zoom(MAX_ZOOM - 5).target(new LatLng(entity.getLatLng()[0], entity.getLatLng()[1])).build()));
        } else {
            CenterToast.makeText(this, "定位失败,请重试", Toast.LENGTH_SHORT).show();
        }
    }

    protected void showMarker(List<LatLng> mList) {
        if (mList != null && mList.size() > 0) {
            for (LatLng ll : mList) {
                OverlayOptions option = new MarkerOptions()
                        .position(ll)
                        .icon(bitmap);
                mHomeMap.getMap().addOverlay(option);
            }
        }

    }
}
