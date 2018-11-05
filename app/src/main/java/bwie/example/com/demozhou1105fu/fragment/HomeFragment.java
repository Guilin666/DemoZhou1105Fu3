package bwie.example.com.demozhou1105fu.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.gson.Gson;

import butterknife.BindView;
import butterknife.ButterKnife;
import bwie.example.com.demozhou1105fu.R;
import bwie.example.com.demozhou1105fu.adapter.SellerAdapter;
import bwie.example.com.demozhou1105fu.bean.GoodBean;
import bwie.example.com.demozhou1105fu.utils.OkUtils;

public class HomeFragment extends Fragment {
    @BindView(R.id.recycle_home)
    RecyclerView recycle_home;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = View.inflate(getActivity(), R.layout.fragment_home, null);
        ButterKnife.bind(this,view);
        doHttp();

        return view;
    }

    private void doHttp() {
        OkUtils.getInstance().get("http://www.zhaoapi.cn/product/getCarts?uid=71").setOkLisener(new OkUtils.OkListener() {
            @Override
            public void success(String data) {
                GoodBean goodBean = new Gson().fromJson(data, GoodBean.class);
                SellerAdapter sellerAdapter = new SellerAdapter(goodBean.getData(), getActivity());
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
                linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
                recycle_home.setLayoutManager(linearLayoutManager);
                recycle_home.setAdapter(sellerAdapter);
            }
        });
    }
}
