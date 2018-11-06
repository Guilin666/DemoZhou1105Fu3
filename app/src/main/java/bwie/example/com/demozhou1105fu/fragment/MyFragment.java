package bwie.example.com.demozhou1105fu.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import bwie.example.com.demozhou1105fu.R;
import bwie.example.com.demozhou1105fu.adapter.GoodAdapter;
import bwie.example.com.demozhou1105fu.adapter.GoodAdapter2;
import bwie.example.com.demozhou1105fu.bean.CacheBean;
import bwie.example.com.demozhou1105fu.utils.SqlUtils;

//在哪里获取在哪里注册
//重新执行查询方法
public class MyFragment extends Fragment {
    @BindView(R.id.recycle_s)
    RecyclerView recycle_s;
    private GoodAdapter2 goodAdapter2;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = View.inflate(getActivity(), R.layout.fragment_my, null);
        ButterKnife.bind(this,view);
//        EventBus.getDefault().register(this);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        List<CacheBean> cacheBeans = SqlUtils.getNewsBeanJsonUtils().queryAll();
        if (cacheBeans == null) {
            cacheBeans=new ArrayList<>();
        }
        goodAdapter2 = new GoodAdapter2(getActivity());
        goodAdapter2.setList(cacheBeans);
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        recycle_s.setLayoutManager(staggeredGridLayoutManager);
        recycle_s.setAdapter(goodAdapter2);
    }

//    @Override
//    public void onDestroyView() {
//        super.onDestroyView();
//        EventBus.getDefault().unregister(this);
//    }

    //使得重新查询
    public  void setItem() {
        //重新获取
        List<CacheBean> list = SqlUtils.getNewsBeanJsonUtils().queryAll();
        goodAdapter2.setList(list);
    }


//    //回调
//    @Subscribe(threadMode = ThreadMode.MAIN)
//    public void onMessageEvent(String msg) {
//        //重新获取
//        List<CacheBean> list = SqlUtils.getNewsBeanJsonUtils().queryAll();
//        goodAdapter2.setList(list);
//    }
}
