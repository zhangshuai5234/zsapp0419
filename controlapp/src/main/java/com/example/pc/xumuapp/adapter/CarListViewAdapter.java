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
import com.example.pc.xumuapp.newAdded.CarListDetailActivity;
import com.example.pc.xumuapp.newAdded.model.CarListModel;

import java.util.List;

public class CarListViewAdapter extends BaseAdapter {

    private List<CarListModel> list;
    LayoutInflater layoutInflater;
    private Context mcontext;

    public CarListViewAdapter(Context context, List<CarListModel> list){
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

        ViewHolder viewHolder;
        if (convertView == null) {

            convertView = layoutInflater.inflate(R.layout.addfragment_item, null);
            viewHolder = new CarListViewAdapter.ViewHolder();
            viewHolder.userName = convertView.findViewById(R.id.username);
            viewHolder.phoneNum = convertView.findViewById(R.id.phonenum);
            viewHolder.carCount = convertView.findViewById(R.id.carnum);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (CarListViewAdapter.ViewHolder) convertView.getTag();
        }

        viewHolder.userName.setText(list.get(position).getUserName());
        viewHolder.phoneNum.setText(list.get(position).getPhonNum());
        viewHolder.carCount.setText(list.get(position).getCarCount());
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
                intent.putExtra("carId",list.get(position).getUserCode());
                intent.putExtra("username",list.get(position).getUserName());
                intent.putExtra("usercode",list.get(position).getUserCode());
                intent.putExtra("phone",list.get(position).getPhonNum());
                intent.setClass(mcontext,CarListDetailActivity.class);
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

