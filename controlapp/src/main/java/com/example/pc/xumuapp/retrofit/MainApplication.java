package com.example.pc.xumuapp.retrofit;

import android.app.Application;
import android.content.Context;

/**
 * @author nanchen
 * @fileName RetrofitRxDemoo
 * @packageName com.nanchen.retrofitrxdemoo
 * @date 2016/12/09  17:00
 */

public class MainApplication extends Application {

    private static MainApplication instance;

    public static Context getAppContext(){
        return instance == null ? null : instance.getApplicationContext();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }
}
