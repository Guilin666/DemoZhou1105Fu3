package bwie.example.com.demozhou1105fu.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import bwie.example.com.demozhou1105fu.R;
import bwie.example.com.demozhou1105fu.bean.CacheBean;
import bwie.example.com.demozhou1105fu.bean.GoodBean;
import bwie.example.com.demozhou1105fu.utils.SqlUtils;

public class GoodAdapter2 extends RecyclerView.Adapter<GoodAdapter2.MyViewHolder> {
    private Context context;
    List<CacheBean> cacheBeans = new ArrayList<>();

    public GoodAdapter2(Context context) {
        this.context = context;
        this.cacheBeans = cacheBeans;


    }


    @NonNull
    @Override
    public GoodAdapter2.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = View.inflate(context, R.layout.good_layout, null);
        MyViewHolder myViewHolder = new MyViewHolder(inflate);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull GoodAdapter2.MyViewHolder myViewHolder, final int i) {
        myViewHolder.tv_title.setText(cacheBeans.get(i).getTitle());
        Glide.with(context).load(cacheBeans.get(i).getImg()).into(myViewHolder.tv_img);

    }

    @Override
    public int getItemCount() {
        return cacheBeans.size();
    }


    public void setList(List<CacheBean> list) {
        this.cacheBeans = list;
        notifyDataSetChanged();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView tv_img;
        TextView tv_title;
        RelativeLayout re_main;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_img = itemView.findViewById(R.id.tv_img);
            tv_title = itemView.findViewById(R.id.tv_title);
            re_main = itemView.findViewById(R.id.re_main);
        }
    }


}
