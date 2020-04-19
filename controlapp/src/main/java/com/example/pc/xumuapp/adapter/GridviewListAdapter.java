package com.example.pc.xumuapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.pc.xumuapp.R;
import com.example.pc.xumuapp.mvp_contrl.model.ControlListModel;
import com.example.pc.xumuapp.yunwei.model.EquipmentModel;
import com.example.pc.xumuapp.yunwei.view.EquipmentDetailActivity;

import java.util.List;


public class GridviewListAdapter extends BaseAdapter implements View.OnClickListener {

//        private List<ControlListModel.DataBean> list;
        private List<EquipmentModel.DataBean> list;
        LayoutInflater layoutInflater;
        private Context mcontext;
        private String editStr = "";
    private InnerItemOnclickListener mListener;

    public GridviewListAdapter(Context context, List<EquipmentModel.DataBean> list){
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

        final ViewHolder viewHolder;
        if (convertView == null) {

            convertView = layoutInflater.inflate(R.layout.cardview_item, null);
            viewHolder = new GridviewListAdapter.ViewHolder();
            viewHolder.namelab = convertView.findViewById(R.id.equipmentname);
            viewHolder.hostNumlab = convertView.findViewById(R.id.hostid);
            viewHolder.statuslab = convertView.findViewById(R.id.status);
            viewHolder.workCenterIdlab = convertView.findViewById(R.id.workCenterId);
            convertView.setTag(viewHolder);

        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        if (list.get(position).getName() == ""){
            viewHolder.namelab.setText("设备名称");
        }else {
            viewHolder.namelab.setText(list.get(position).getName());
        }
        if (list.get(position).getHostNumber() == ""){
            viewHolder.hostNumlab.setText("主机号");
        }else {
            viewHolder.hostNumlab.setText(list.get(position).getHostNumber());
        }
        if (list.get(position).getAvailableStatus() == ""){
            viewHolder.statuslab.setText("设备状态");
        }else {
            viewHolder.statuslab.setText(list.get(position).getAvailableStatus());
        }
        if (list.get(position).getWorkCenterName() == ""){
            viewHolder.workCenterIdlab.setText("工作中心");
        }else {
            viewHolder.workCenterIdlab.setText(list.get(position).getWorkCenterName());
        }


/**
 * 添加点击事件
 */
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /**
                 * 跳转到设备详情
                 */
                Intent intent = new Intent();
                intent.putExtra("equipmentid",list.get(position).getId());
//                intent.putExtra("username",list.get(position).getUserName());
//                intent.putExtra("usercode",list.get(position).getUserCode());
//                intent.putExtra("phone",list.get(position).getPhonNum());
                intent.setClass(mcontext, EquipmentDetailActivity.class);
                mcontext.startActivity(intent);
            }
        });
        return convertView;

    }

    private class ViewHolder{

        public TextView hostNumlab;
        public TextView namelab;
        public TextView statuslab;
        public TextView workCenterIdlab;

    }

    public interface InnerItemOnclickListener {
        void itemClick(View v, String editstr);
    }

    public void setOnInnerItemOnClickListener(InnerItemOnclickListener listener){
        this.mListener=listener;
    }

    @Override
    public void onClick(View v) {

        mListener.itemClick(v,editStr);
    }
}

