package com.example.pc.xumuapp.adapter;

import android.content.Context;
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

import java.util.List;


public class ControlListAdapter extends BaseAdapter implements View.OnClickListener {

        private List<ControlListModel.DataBean> list;
        LayoutInflater layoutInflater;
        private Context mcontext;
        private String editStr = "";
    private InnerItemOnclickListener mListener;

    public ControlListAdapter(Context context, List<ControlListModel.DataBean> list){
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

            convertView = layoutInflater.inflate(R.layout.controllist_item, null);
            viewHolder = new ControlListAdapter.ViewHolder();
            viewHolder.channelName = convertView.findViewById(R.id.channelname);
            viewHolder.start_btn = convertView.findViewById(R.id.start_btn);
            viewHolder.end_btn = convertView.findViewById(R.id.end_btn);
            viewHolder.editText = convertView.findViewById(R.id.starttime_edit);
            convertView.setTag(viewHolder);
            viewHolder.start_btn.setTag(position);
            viewHolder.end_btn.setTag(position);
            if (list.get(position).getAutoType() == "01"){
//                自动

            }else{
//                手动
            }
            if(list.get(position).getEquipStatus() == "01"){
//                开
            }
            viewHolder.editText.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                    editStr = viewHolder.editText.getText().toString();
                }

                @Override
                public void afterTextChanged(Editable s) {

                }
            });
        } else {
            viewHolder = (ControlListAdapter.ViewHolder) convertView.getTag();
        }

        viewHolder.channelName.setText(list.get(position).getChannelName());
        viewHolder.start_btn.setOnClickListener(this);
        viewHolder.end_btn.setOnClickListener(this);



/**
 * 添加点击事件
 */
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                /**
//                 * 跳转到车辆详情页
//                 */
//                Intent intent = new Intent();
////                intent.putExtra("carId",list.get(position).getUserCode());
////                intent.putExtra("username",list.get(position).getUserName());
////                intent.putExtra("usercode",list.get(position).getUserCode());
////                intent.putExtra("phone",list.get(position).getPhonNum());
//                intent.setClass(mcontext, CarListDetailActivity.class);
//                mcontext.startActivity(intent);
            }
        });
        return convertView;

    }

    private class ViewHolder{
        Button start_btn, end_btn;
        public TextView channelName;
        public EditText editText;

    }

    public interface InnerItemOnclickListener {
        void itemClick(View v ,String editstr);
    }

    public void setOnInnerItemOnClickListener(InnerItemOnclickListener listener){
        this.mListener=listener;
    }

    @Override
    public void onClick(View v) {

        mListener.itemClick(v,editStr);
    }
}

