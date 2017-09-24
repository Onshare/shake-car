package com.android.shake.app.home;

import android.widget.Toast;

import com.android.shake.MainApplication;
import com.android.shake.bean.MapEntity;
import com.jazz.libs.controller.BasePresent;
import com.jazz.libs.util.NetUtils;
import com.jazz.libs.viewUtil.CenterToast;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/**
 * Created by NoName on 2017/9/24.
 */

public class HomePresenter extends BasePresent<HomeActivity> {


    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onLocation(MapEntity entity){
        if(entity != null){
            getActivity().showLocation(entity);
        }
    }

    protected void startLocation(){
        if(!NetUtils.isNetworkConnected(getActivity())){
            CenterToast.makeText(getActivity(), "网络未打开,未能获取位置信息", Toast.LENGTH_SHORT).show();
        }else if(!NetUtils.isGPSEnabled(getActivity())){
            CenterToast.makeText(getActivity(), "GPS未打开,未能获取位置信息", Toast.LENGTH_SHORT).show();
        }else {
            MainApplication.instance.start();
        }
    }

}
