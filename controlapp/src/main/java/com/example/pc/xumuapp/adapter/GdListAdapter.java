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
import com.example.pc.xumuapp.yunwei.model.gdListModel;
import java.util.List;

public class GdListAdapter extends BaseAdapter {

    private List<gdListModel.RecordsBean> list;
    LayoutInflater layoutInflater;
    private Context mcontext;

    public GdListAdapter(Context context, List<gdListModel.RecordsBean> list){
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

            convertView = layoutInflater.inflate(R.layout.gongdanlist_item, null);
            viewHolder = new GdListAdapter.ViewHolder();
            viewHolder.workOrderNumber = convertView.findViewById(R.id.workOrderNumber);
            viewHolder.number = convertView.findViewById(R.id.number);
            viewHolder.description = convertView.findViewById(R.id.description);
            viewHolder.taskTypeName = convertView.findViewById(R.id.taskTypeName);
            viewHolder.statusDict = convertView.findViewById(R.id.statusDict);
            viewHolder.productName = convertView.findViewById(R.id.productName);
            viewHolder.materialName = convertView.findViewById(R.id.materialName);
            viewHolder.quantity = convertView.findViewById(R.id.quantity);
            viewHolder.unitDict = convertView.findViewById(R.id.unitDict);
            viewHolder.issuedTime = convertView.findViewById(R.id.issuedTime);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (GdListAdapter.ViewHolder) convertView.getTag();
        }

        viewHolder.workOrderNumber.setText(list.get(position).getWorkOrderNumber());
        viewHolder.number.setText(list.get(position).getNumber());
        viewHolder.description.setText(list.get(position).getDescription());
        viewHolder.taskTypeName.setText(list.get(position).getTaskTypeDict());
        viewHolder.statusDict.setText(list.get(position).getStatusDict());
        viewHolder.productName.setText(list.get(position).getProductName());
        viewHolder.materialName.setText(list.get(position).getMaterialName());
        viewHolder.quantity.setText(String.valueOf(list.get(position).getQuantity()));
        viewHolder.unitDict.setText(list.get(position).getUnitDict());
        viewHolder.issuedTime.setText(list.get(position).getIssuedTime());
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

        public TextView workOrderNumber;
        public TextView number;
        public TextView description;
        public TextView taskTypeName;
        public TextView statusDict;
        public TextView productName;
        public TextView materialName;
        public TextView quantity;
        public TextView unitDict;
        public TextView issuedTime;

    }
}

