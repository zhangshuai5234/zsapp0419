package com.example.pc.xumuapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.pc.xumuapp.R;
import com.example.pc.xumuapp.mvp_charge.model.UserChargeModel;
import com.example.pc.xumuapp.mvp_charge.view.ChargeDetailActivity;

import java.util.List;

public class ChargelistAdapter extends BaseAdapter {

    private List<UserChargeModel> list;
    LayoutInflater layoutInflater;
    private Context mcontext;

    public ChargelistAdapter(Context context, List<UserChargeModel> list){
        this.list = list;
        mcontext = context;
        layoutInflater = LayoutInflater.from(context);

    }

    @Override
    public int getCount() {
        if (list == null){
            return 0;
        }
        return list.size();

    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public Object getItem(int position) {
        if (list == null){
            return null;
        }
        return list.get(position);
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        ChargelistAdapter.ViewHolder viewHolder;
        if (convertView == null){

            convertView = layoutInflater.inflate(R.layout.addfragment_item,null);
            viewHolder = new ChargelistAdapter.ViewHolder();
            viewHolder.userName = convertView.findViewById(R.id.username);
            viewHolder.phoneNum = convertView.findViewById(R.id.phonenum);
            viewHolder.carCount = convertView.findViewById(R.id.carnum);
            viewHolder.headPic = convertView.findViewById(R.id.headpic);
            convertView.setTag(viewHolder);
        }else {
            viewHolder = (ChargelistAdapter.ViewHolder) convertView.getTag();
        }

        viewHolder.userName.setText(list.get(position).getOwner());
        viewHolder.phoneNum.setText(list.get(position).getOwnerPhone());
//        viewHolder.carCount.setText(list.get(position).getCarCount());
//        viewHolder.headPic;
/**
 * 添加点击事件
 */
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /**
                 * 跳转到车辆详情页
                 */
                Intent intent = new Intent();
                intent.putExtra("carId",list.get(position).getCarId());
                intent.putExtra("username",list.get(position).getOwner());
                intent.setClass(mcontext,ChargeDetailActivity.class);
                mcontext.startActivity(intent);
            }
        });
        return convertView;

    }

    private class ViewHolder{

        public TextView userName;
        public TextView phoneNum;
        public TextView carCount;
        public ImageView headPic;
    }
}

