package com.example.administrator.mydairy;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Administrator on 2017/5/9.
 */

public class MyAdapter extends BaseAdapter {

    private List<Charity> mList;
    private LayoutInflater layoutInflater;

    public MyAdapter(Context context,List<Charity> list){
        mList = list;
        layoutInflater = LayoutInflater.from(context);
    }
    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int i) {
        return mList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }



    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if (view == null) {
            viewHolder = new ViewHolder();
            view = layoutInflater.inflate(R.layout.listview_item, null);
            viewHolder.textView1 = (TextView)view.findViewById(R.id.tv_content);
            viewHolder.textView = (TextView) view.findViewById(R.id.tv_title);
            view.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder)view.getTag();
        }
        viewHolder.textView.setText(mList.get(i).getName());
        viewHolder.textView1.setText(mList.get(i).getAddress()+"  "+mList.get(i).getJuli()+"KM");
        return view;
    }
    public final class ViewHolder{
        public TextView textView,textView1;
    }
}
