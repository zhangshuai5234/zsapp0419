package com.example.pc.xumuapp.base;



import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;


/**
 * Created by Administrator on 2017/4/5.
 */

public abstract class BaseActivity extends AppCompatActivity {
    private ImageView back_btn;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        initVariables();
        initView();
        loadData();
        //将该Activity添加到ExitApplication实例中，
        //    HCQApplication.getInstance().addActivity(this);
    }
    /**
     * 初始化变量
     **/
    protected abstract   void   initVariables();

    /**
     * 初始化界面
     **/
    protected  abstract    void   initView();
    /**
     * 加载数据
     **/
    protected  abstract void   loadData();

//    @Override
//    protected void onStart() {
//        super.onStart();
//
//    }

}
