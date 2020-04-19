package com.example.pc.xumuapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.pc.xumuapp.R;
import com.example.pc.xumuapp.newAdded.CarListDetailActivity;
import com.example.pc.xumuapp.yunwei.model.GatherModel;

import java.util.List;



public class GatherAdapter extends BaseAdapter {

    private List<GatherModel.DataBean> list;
    LayoutInflater layoutInflater;
    private Context mcontext;

    public GatherAdapter(Context context, List<GatherModel.DataBean> list){
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

            convertView = layoutInflater.inflate(R.layout.plantlist_item, null);
            viewHolder = new GatherAdapter.ViewHolder();
            viewHolder.productBaseName = convertView.findViewById(R.id.productBaseName);
            viewHolder.taskNumber = convertView.findViewById(R.id.taskNumber);
            viewHolder.productCellDescription = convertView.findViewById(R.id.productCellDescription);
            viewHolder.managerName = convertView.findViewById(R.id.managerName);
            viewHolder.productName = convertView.findViewById(R.id.productName);
            viewHolder.quantity = convertView.findViewById(R.id.quantity);
            viewHolder.unitDict = convertView.findViewById(R.id.unitDict);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (GatherAdapter.ViewHolder) convertView.getTag();
        }

        viewHolder.productBaseName.setText(list.get(position).getProductionBaseName());
        viewHolder.taskNumber.setText(list.get(position).getTaskNumber());
        viewHolder.productCellDescription.setText(list.get(position).getProductDescription());
        viewHolder.managerName.setText(list.get(position).getManagerName());
        viewHolder.productName.setText(list.get(position).getProductName());
        viewHolder.quantity.setText(String.valueOf(list.get(position).getQuantity()));
        viewHolder.unitDict.setText(list.get(position).getUnitDict());



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
//                intent.putExtra("carId",list.get(position).getUserCode());
//                intent.putExtra("username",list.get(position).getUserName());
//                intent.putExtra("usercode",list.get(position).getUserCode());
//                intent.putExtra("phone",list.get(position).getPhonNum());
                intent.setClass(mcontext, CarListDetailActivity.class);
                mcontext.startActivity(intent);
            }
        });
        return convertView;

    }

    private class ViewHolder{

        public TextView productBaseName;
        public TextView taskNumber;
        public TextView productCellDescription;
        public TextView managerName;
        public TextView productName;
        public TextView quantity;
        public TextView unitDict;

    }
}

