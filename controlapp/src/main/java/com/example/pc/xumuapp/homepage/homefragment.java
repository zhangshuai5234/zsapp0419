package com.example.pc.xumuapp.homepage;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.pc.xumuapp.R;
import com.example.pc.xumuapp.mvp_login.view.Loginactivity;

public class homefragment extends Fragment {

    TextView navtitle;
    Button logoutBtn;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.homepage_layout,container,false);
        navtitle = view.findViewById(R.id.nav_title);
        TextView edit_btn = view.findViewById(R.id.nav_edit);
        navtitle.setText("首页");

        ImageView back = view.findViewById(R.id.iv_back);
        back.setVisibility(view.GONE);
        edit_btn.setVisibility(view.GONE);

        logoutBtn = view.findViewById(R.id.logout_btn);
        logoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(getActivity(), Loginactivity.class);
                startActivity(intent);
            }
        });

        initview(view);
        return view;
    }

    public void initview(View view){
        WebView webView = (WebView) view.findViewById(R.id.web_view);
        webView.loadUrl("https://mp.weixin.qq.com/s/VSFbPzOuOKXUGD9ixyvnNw");
//        BounceLayout bounceLayout = view.findViewById(R.id.bl);
//
//        FrameLayout rootView = view.findViewById(R.id.fl_root);
//        bounceLayout.setHeaderView(new DefaultHeader(getActivity()),rootView);//if HeaderView is null,it just bounce.
//        bounceLayout.setFooterView(new DefaultFooter(getActivity()),rootView);
//        RefreshLayout refreshLayout = (RefreshLayout)view.findViewById(R.id.refreshLayout);
//        refreshLayout.setOnRefreshListener(new OnRefreshListener() {
//            @Override
//            public void onRefresh(RefreshLayout refreshlayout) {
//                refreshlayout.finishRefresh(2000/*,false*/);//传入false表示刷新失败
//            }
//        });
//        refreshLayout.setOnLoadMoreListener(new OnLoadMoreListener() {
//            @Override
//            public void onLoadMore(RefreshLayout refreshlayout) {
//                refreshlayout.finishLoadMore(2000/*,false*/);//传入false表示加载失败
//            }
//        });
////设置 Header 为 贝塞尔雷达 样式
//        refreshLayout.setRefreshHeader(new BezierRadarHeader(getActivity()).setEnableHorizontalDrag(true));
////设置 Footer 为 球脉冲 样式
//        refreshLayout.setRefreshFooter(new BallPulseFooter(getActivity()).setSpinnerStyle(SpinnerStyle.Scale));
    }
}
