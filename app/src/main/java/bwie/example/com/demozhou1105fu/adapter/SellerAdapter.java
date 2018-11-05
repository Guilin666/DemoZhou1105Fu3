package bwie.example.com.demozhou1105fu.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import bwie.example.com.demozhou1105fu.R;
import bwie.example.com.demozhou1105fu.bean.GoodBean;

public class SellerAdapter extends RecyclerView.Adapter<SellerAdapter.MyViewHolder>{
    private Context context;
    private List<GoodBean.DataBean> data=new ArrayList<>();
    public SellerAdapter(List<GoodBean.DataBean> data, Context  context) {
        this.context=context;
        this.data=data;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = View.inflate(context,R.layout.seller_layout, null);
        MyViewHolder myViewHolder = new MyViewHolder(inflate);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        GoodAdapter goodAdapter = new GoodAdapter(data.get(i).getList(), context);
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        myViewHolder.recycle_child.setLayoutManager(staggeredGridLayoutManager);
        myViewHolder.recycle_child.setAdapter(goodAdapter);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        RecyclerView recycle_child;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            recycle_child=itemView.findViewById(R.id.recycle_child);
        }
    }
}
