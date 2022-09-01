package com.example.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

import com.example.entiy.DecorateViotation;
import com.example.vehicleviotation.R;

public class ViotationAdapter extends BaseAdapter {


    private List<DecorateViotation> list;
    private Context mContext;

    public ViotationAdapter(Context context, List<DecorateViotation> list) {
        this.list = list;
        mContext = context;
    }

    @Override
    public int getCount() {
        return list == null ? 0 : list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder;
        if (convertView == null) {

            convertView = View.inflate(mContext, R.layout.item_lv_viotation, null);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        DecorateViotation item = list.get(position);
        holder.tv_place.setText(item.getViotation_place());
        holder.tv_date.setText(item.getViotation_date());
        holder.tv_detail.setText(item.getViotation_detail());
        holder.tv_deal.setText("罚款"+item.getFine()+"元，扣"+item.getDeduct()+"分");
        holder.tv_status.setText(item.getPunish_flag());

        return convertView;
    }

    public static class ViewHolder {
        public View rootView;
        public TextView tv_place;
        public TextView tv_date;
        public TextView tv_detail;
        public TextView tv_deal;
        public TextView tv_status;

        public ViewHolder(View rootView) {
            this.rootView = rootView;
            this.tv_place = (TextView) rootView.findViewById(R.id.tv_place);
            this.tv_date = (TextView) rootView.findViewById(R.id.tv_date);
            this.tv_detail = (TextView) rootView.findViewById(R.id.tv_detail);
            this.tv_deal = (TextView) rootView.findViewById(R.id.tv_deal);
            this.tv_status = (TextView) rootView.findViewById(R.id.tv_status);
        }

    }
}
