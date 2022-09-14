package com.example.test_t1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MyAdapter extends BaseAdapter {
    public MyAdapter(Context context, ArrayList<issue_data> data)
    {
        mContext = context;
        sample = data;
        mLayoutInflater = LayoutInflater.from(mContext);
    }


    Context mContext =null;
    LayoutInflater mLayoutInflater =null;
    ArrayList<issue_data> sample;

    @Override
    public int getCount(){
        return sample.size();
    }

    @Override
    public long getItemId(int position){
        return position;
    }

    @Override
    public issue_data getItem(int position){
        return sample.get(position);
    }

    @Override
    public View getView(int position, View converView, ViewGroup parent){
        View view = mLayoutInflater.inflate(R.layout.issue, null);

        ImageView imageView = (ImageView)view.findViewById(R.id.issue_image); //이미지
        TextView textView1 = (TextView) view.findViewById(R.id.textView1); //첫째줄
        TextView textView2 = (TextView) view.findViewById(R.id.textView2); //둘째줄
        TextView textView3 = (TextView) view.findViewById(R.id.textView3); //셋째줄

        //설정
        imageView.setImageResource(sample.get(position).getIssue());
        textView1.setText(sample.get(position).getTextview1());
        textView2.setText(sample.get(position).getDay_time());
        textView3.setText(sample.get(position).getTextview3());

        return view;

    }
}
