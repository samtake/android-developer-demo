package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.List;

public class ListViewAdapter extends BaseAdapter {

    private Context mContext;
    private List<String> mList;
    public ListViewAdapter(Context context, List<String> list){
        this.mContext = context;
        this.mList = list;
    }

    @Override
    public int getCount() {
        return mList == null ? 0 : mList.size();
    }

    @Override
    public Object getItem(int i) {
        return mList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    //返回 代表某一个样式 的 数值
    @Override
    public int getItemViewType(int position) {     //返回类型
        // TODO Auto-generated method stub
        if(position == 0){
            return 0;
        }
        return 1;
    }

    //两个样式 返回2
    @Override
    public int getViewTypeCount() {           //不同的布局共2 个
        // TODO Auto-generated method stub
        return 2;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder1 viewHolder1;
        ViewHolder viewHolder;
        if(view == null){
            if(getItemViewType(i) == 0){
                view = LayoutInflater.from(mContext).inflate(R.layout.item_listview1,null);
                viewHolder1 = new ViewHolder1();
                viewHolder1.timePicker = view.findViewById(R.id.tv_time_picker1);
                view.setTag(viewHolder1);
            }else {
                view = LayoutInflater.from(mContext).inflate(R.layout.item_listview, null);
                viewHolder = new ViewHolder();
                viewHolder.tvTest = view.findViewById(R.id.tv_list_item);
                view.setTag(viewHolder);
            }
        }else{
            if(getItemViewType(i) == 0){
                viewHolder1 = (ViewHolder1) view.getTag();
                //viewHolder1.tvTest.setText("jklkllkjklß");
            }else {
                viewHolder = (ViewHolder) view.getTag();
                viewHolder.tvTest.setText(mList.get(i));
            }
        }

        return view;
    }


    private class ViewHolder{
        TextView tvTest;
    }


    private class ViewHolder1{
        TimePicker timePicker;
    }
}
