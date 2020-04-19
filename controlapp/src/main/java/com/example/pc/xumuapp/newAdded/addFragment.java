package com.example.pc.xumuapp.newAdded;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.pc.xumuapp.R;
import com.example.pc.xumuapp.adapter.GdListAdapter;
import com.example.pc.xumuapp.retrofit.ProgressDialogHandler;
import com.example.pc.xumuapp.utils.SpUtils;
import com.example.pc.xumuapp.yunwei.model.GongdanModel;
import com.example.pc.xumuapp.yunwei.model.gdListModel;
import com.example.pc.xumuapp.yunwei.presenter.GongdanPersenter;
import com.example.pc.xumuapp.yunwei.view.gongdanView;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import okhttp3.RequestBody;

public class addFragment extends Fragment implements gongdanView{
    private ProgressDialogHandler progressDialogHandler = new ProgressDialogHandler(getContext(), null, true);
    private GongdanPersenter gongdanPersenter = new GongdanPersenter(this);
    private TextView titlelab;
    private ImageView backBtn;
    private ListView mainListView;
    private List<gdListModel.RecordsBean> mainlist = new ArrayList<gdListModel.RecordsBean>();
    private Context context;

    private TextView navtitle;
    TextView edit_btn;
    ImageView back_btn;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = this.getActivity();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.addfragment_layout,container,false);

        navtitle =  view.findViewById(R.id.nav_title);


        back_btn = view.findViewById(R.id.iv_back);

        mainListView = view.findViewById(R.id.mainlist);

        initview(view);
        GetValue();

        return view;

    }


    /**
     * 页面控件布局处理
     */
    public void initview(View view) {

        navtitle.setText("工单列表");
        /**
         * 修改顶部按钮大小
         */

    }

    /**
        dp转px方法
     */
    public static int dip2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    /**
     * 网络访问
     */
    public void GetValue(){

        Gson gson=new Gson();
        HashMap<String, Object> paramsMap = new HashMap<>();
        HashMap<String,String> paramsMap1 = new HashMap<>();
        paramsMap.put("entity",paramsMap1);
        paramsMap.put("userToken", SpUtils.GetConfigString(context,"userToken"));
        String strEntity = gson.toJson(paramsMap);

        RequestBody body = RequestBody.create(okhttp3.MediaType.parse("application/json;charset=UTF-8"),strEntity);

        HashMap<String,String> headmap = new HashMap<>();
        headmap.put("token", SpUtils.GetConfigString(getContext(),"userToken"));
        headmap.put("Content-Type","application/json");

        gongdanPersenter.GetGongdanList(body,headmap);
    }
    /**
     * 网络访问回调方法
     */
    @Override
    public void GetLoginSuccess(GongdanModel gongdanModel) {
        if (gongdanModel.getSuccess().equals("true")){
            gdListModel gdListModel =  gongdanModel.getData();
//            for (int i = 0; i < gdListModel.getRecords().size(); i++){
//
//            }
            mainlist = gdListModel.getRecords();
            if (mainlist.size() != 0){
                GdListAdapter adapter = new GdListAdapter(context,mainlist);
                mainListView.setAdapter(adapter);
            }
        }else {

        }
    }

        @Override
        public void GetLoginError(Throwable e) {

    }


}
