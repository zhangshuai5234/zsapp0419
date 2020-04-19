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

public class ChargeDetailAdapter extends BaseAdapter {
    private List<CarListModel> list;
    LayoutInflater layoutInflater;

    public ChargeDetailAdapter(Context context, List<CarListModel> list) {
        this.list = list;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return 20;
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
        ChargeDetailAdapter.ViewHolder viewHolder;
        if (convertView == null) {

            convertView = layoutInflater.inflate(R.layout.chargedetail_item, null);
            viewHolder = new ChargeDetailAdapter.ViewHolder();
            viewHolder.carId = convertView.findViewById(R.id.carid);
            viewHolder.timelab = convertView.findViewById(R.id.timelab);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ChargeDetailAdapter.ViewHolder) convertView.getTag();
        }

//        viewHolder.userName.setText(list.get(position).getUserName());
//        viewHolder.phoneNum.setText(list.get(position).getPhonNum());
//        viewHolder.carCount.setText(list.get(position).getCarCount());
//        viewHolder.headPic;

        return convertView;

    }

    private class ViewHolder {

        public TextView carId;
        public TextView timelab;
    }
}
