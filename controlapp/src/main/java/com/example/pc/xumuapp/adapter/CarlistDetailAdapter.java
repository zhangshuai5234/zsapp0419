package com.example.pc.xumuapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.pc.xumuapp.R;
import com.example.pc.xumuapp.newAdded.model.CarlistdetaliModel;
import com.example.pc.xumuapp.newAdded.view.EditCarinfoActivity;

import java.util.List;

public class CarlistDetailAdapter extends BaseAdapter {
    private List<CarlistdetaliModel> list;
    LayoutInflater layoutInflater;
    private Context mcontext;


    public CarlistDetailAdapter(Context context, List<CarlistdetaliModel> list) {
        this.list = list;
        mcontext = context;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        if (list == null) {
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
        if (list == null) {
            return null;
        }
        return list.get(position);
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        CarlistDetailAdapter.ViewHolder viewHolder;
        if (convertView == null) {

            convertView = layoutInflater.inflate(R.layout.carlistdetail_item, null);
            viewHolder = new CarlistDetailAdapter.ViewHolder();
            viewHolder.carId = convertView.findViewById(R.id.carid);
            viewHolder.timelab = convertView.findViewById(R.id.timelab);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (CarlistDetailAdapter.ViewHolder) convertView.getTag();
        }

        viewHolder.carId.setText(list.get(position).getCarId());
//        viewHolder.timelab.setText(list.get(position).getTimeStr());
//        viewHolder.carCount.setText(list.get(position).getCarCount());
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("carid",list.get(position).getCarId());
                intent.setClass(mcontext, EditCarinfoActivity.class);
                mcontext.startActivity(intent);
            }
        });

        return convertView;

    }

    private class ViewHolder {

        public TextView carId;
        public TextView timelab;
    }
}