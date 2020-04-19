package com.example.pc.xumuapp.splash;

import android.content.Context;
import android.content.Intent;

import com.example.pc.xumuapp.MainActivity;
import com.example.pc.xumuapp.mvp_contrl.view.MainActivityNew;
import com.example.pc.xumuapp.base.BaseActivity;
import com.example.pc.xumuapp.R;
import com.example.pc.xumuapp.mvp_login.model.UserModel;
import com.example.pc.xumuapp.mvp_login.view.LoginAcitivty;
import com.example.pc.xumuapp.mvp_login.view.Loginactivity;
import com.example.pc.xumuapp.utils.SpUtils;

import java.util.Timer;
import java.util.TimerTask;

import butterknife.ButterKnife;


public class SplashAcitivty extends BaseActivity {

    Context context = SplashAcitivty.this;

    @Override
    protected void initVariables() {

    }

    @Override
    protected void initView() {
        setContentView(R.layout.layout_splash);
        ButterKnife.bind(this);
    }

    @Override
    protected void loadData() {
        countNum();
    }
    private void countNum() {//delay
        TimerTask task = new TimerTask(){
            public void run(){
                checkLoginStatus();
            }
        };
        Timer timer = new Timer();
        timer.schedule(task, 2*1000);
    }

    private boolean checkLoginStatus(){
        if(SpUtils.GetConfigString(context,"userToken").equals("")){
            toNextActivity(false, "");
            return false;
        }else{
            toNextActivity(true, SpUtils.GetConfigString(context, "userType"));
            return true;
        }
    }

    public void toNextActivity(boolean isLogin, String loginType) {
        Intent intent = new Intent();
        if (isLogin){// user is logged in 1
            UserModel user = new UserModel();
//            user.setId(SpUtils.GetConfigString(context, "id"));
//            user.setUserCode(SpUtils.GetConfigString(context, "usercode"));
//            user.setMobileImei(SpUtils.GetConfigString(context, "mobileImi"));
//            user.setPhone(SpUtils.GetConfigString(context, "phone"));
//            user.setUserType(SpUtils.GetConfigString(context, "userType"));
//            user.setMobile(SpUtils.GetConfigString(context, "mobile"));
//            intent.putExtra("user", user);
            intent.setClass(SplashAcitivty.this, MainActivity.class);
        }else{// user not login
            intent.setClass(SplashAcitivty.this, Loginactivity.class);
//            intent.setClass(SplashAcitivty.this, MainActivityNew.class);
        }
        startActivity(intent);
        finish();
    }

}
