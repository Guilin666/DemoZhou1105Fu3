package bwie.example.com.demozhou1105fu.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

import bwie.example.com.demozhou1105fu.R;
import bwie.example.com.demozhou1105fu.bean.CacheBean;
import bwie.example.com.demozhou1105fu.bean.GoodBean;
import bwie.example.com.demozhou1105fu.utils.SqlUtils;

public class GoodAdapter extends RecyclerView.Adapter<GoodAdapter.MyViewHolder> {
    private Context context;
    private List<GoodBean.DataBean.ListBean> list = new ArrayList<>();

    public GoodAdapter(List<GoodBean.DataBean.ListBean> list, Context context) {
        this.context = context;
        this.list = list;
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public GoodAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = View.inflate(context, R.layout.good_layout, null);
        MyViewHolder myViewHolder = new MyViewHolder(inflate);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull GoodAdapter.MyViewHolder myViewHolder, final int i) {
        myViewHolder.tv_title.setText(list.get(i).getTitle());
        Glide.with(context).load(list.get(i).getImages().split("\\|")[0]).into(myViewHolder.tv_img);
        myViewHolder.re_main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title = list.get(i).getTitle();
                String imge = list.get(i).getImages().split("\\|")[0];
                CacheBean cacheBean = new CacheBean();
                cacheBean.setImg(imge);
                cacheBean.setTitle(title);
                SqlUtils.getNewsBeanJsonUtils().insert(cacheBean);
                //发送一个空值让适配器fragment执行
                EventBus.getDefault().post("0");

            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
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
