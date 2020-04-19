package com.example.pc.xumuapp;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;



import java.util.ArrayList;
import java.util.List;

import com.example.pc.xumuapp.mvp_charge.view.personFragment;
import com.example.pc.xumuapp.homepage.homefragment;
import com.example.pc.xumuapp.newAdded.addFragment;
import com.example.pc.xumuapp.yunwei.view.secondFragment;

import butterknife.BindView;
import butterknife.BindViews;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends FragmentActivity {

    @BindView(R.id.myViewPager)
    ViewPager myViewPager;
    @BindView(R.id.tv_item_one)
    TextView tvItemOne;
    @BindView(R.id.tv_item_two)
    TextView tvItemTwo;
    @BindView(R.id.tv_item_three)
    TextView tvItemThree;
//    @BindView(R.id.tv_item_four)
//    TextView tvItemFour;

    @BindViews({R.id.tv_item_one,R.id.tv_item_two,R.id.tv_item_three})
    TextView[] tvs;


    List<Fragment> list;
    TabFragmentPagerAdapter adapter;


    private int[] mIconUnselectIds = {
            R.drawable.homepage_default,
            R.drawable.dev_default,
            R.drawable.added_default};
    private int[] mIconSelectIds = {
            R.drawable.homepage_click,
            R.drawable.dev_click,
            R.drawable. added_click};




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        myViewPager.setOnPageChangeListener(new MyPagerChangeListener()); //把Fragment添加到List集合里面
        list = new ArrayList<>();
        list.add(new homefragment());
        list.add(new secondFragment());
//        list.add(new addFragment());

        list.add(new personFragment());
        adapter = new TabFragmentPagerAdapter(getSupportFragmentManager(), list);
        myViewPager.setAdapter(adapter);
        myViewPager.setCurrentItem(0);  //初始化显示第一个页面
        setMyViewPager(0);//初始化tob
    }


    @OnClick({R.id.tv_item_one, R.id.tv_item_two, R.id.tv_item_three})
    public void onClick(View view) {
        int type=0;
        switch (view.getId()) {
            case R.id.tv_item_one:
                type=0;
                break;
            case R.id.tv_item_two:
                type=1;
                break;
            case R.id.tv_item_three:
                type=2;
                break;

        }
        myViewPager.setCurrentItem(type,false);//跳转指定页面，取消滑动效果
        setMyViewPager(type);//初始化tob
    }

    public class MyPagerChangeListener implements ViewPager.OnPageChangeListener {
        @Override
        public void onPageScrollStateChanged(int arg0) {
        }

        @Override
        public void onPageScrolled(int arg0, float arg1, int arg2) {
        }

        @Override
        public void onPageSelected(int arg0) {
            setMyViewPager(arg0);//初始化tob
        }
    }

    private void setMyViewPager(int arg0) {

        myViewPager.setCurrentItem(arg0,false);
        Drawable drawable = null;
        for(int i=0;i<3;i++) {
            if(i == arg0) {
                drawable = this.getDrawable(mIconSelectIds[arg0]);
                tvs[i].setTextColor(Color.parseColor("#1BD0A2"));
            }
            else {
                drawable = this.getDrawable(mIconUnselectIds[i]);
                tvs[i].setTextColor(Color.parseColor("#8C8C8C"));
            }
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            drawable.setBounds(0, 0, 40, 40);
            tvs[i].setCompoundDrawables(null, drawable, null, null);
        }
    }



}
