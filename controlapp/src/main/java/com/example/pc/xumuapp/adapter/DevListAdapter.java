package com.example.pc.xumuapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.pc.xumuapp.R;
import com.example.pc.xumuapp.newAdded.model.CarListModel;

import java.util.List;

public class DevListAdapter extends BaseAdapter {
    private List<CarListModel> list;
    LayoutInflater layoutInflater;

    public DevListAdapter(Context context, List<CarListModel> list) {
        this.list = list;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public Object getItem(int position) {
        if (list == null) {
            return null;
        }
        return list.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        DevListAdapter.ViewHolder viewHolder;
        if (convertView == null) {

            convertView = layoutInflater.inflate(R.layout.addfragment_item, null);
            viewHolder = new DevListAdapter.ViewHolder();
            viewHolder.userName = convertView.findViewById(R.id.username);
            viewHolder.phoneNum = convertView.findViewById(R.id.phonenum);
            viewHolder.carCount = convertView.findViewById(R.id.carnum);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (DevListAdapter.ViewHolder) convertView.getTag();
        }

        viewHolder.userName.setText(list.get(position).getUserName());
        viewHolder.phoneNum.setText(list.get(position).getPhonNum());
        viewHolder.carCount.setText(list.get(position).getCarCount());
//        viewHolder.headPic;

        return convertView;

    }

    private class ViewHolder {

        public TextView userName;
        public TextView phoneNum;
        public TextView carCount;

    }
}
