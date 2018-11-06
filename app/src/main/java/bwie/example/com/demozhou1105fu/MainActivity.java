package bwie.example.com.demozhou1105fu;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import bwie.example.com.demozhou1105fu.adapter.FragmentAdapter;
import bwie.example.com.demozhou1105fu.fragment.MyFragment;
import bwie.example.com.demozhou1105fu.retorfit.HttpUtils;
import bwie.example.com.demozhou1105fu.utils.OkUtils;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.tab_main)
    TabLayout tab_main;
    @BindView(R.id.viewpager_main)
    ViewPager viewpager_main;
    private FragmentAdapter fragmentAdapter;
    @BindView(R.id.btn_click)
    Button btn_click;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        fragmentAdapter = new FragmentAdapter(getSupportFragmentManager());
        viewpager_main.setAdapter(fragmentAdapter);
        tab_main.setupWithViewPager(viewpager_main);
        tab_main.setTabMode(TabLayout.MODE_FIXED);


        doHttp();


    }

    private void doHttp() {
        final Map<String, String> map = new HashMap<>();
        map.put("uid","71");
        btn_click.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                new HttpUtils().get("/product/getCarts", map).setListener(new HttpUtils.HttpListener() {
                    @Override
                    public void success(String data) {
                        Toast.makeText(MainActivity.this, ""+"的撒爱上"+data, Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void fail(String error) {

                        Toast.makeText(MainActivity.this, ""+"进来不", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }


    public void setItem() {
        Fragment fragment = fragmentAdapter.getItem(1);
        if (  fragment instanceof MyFragment) {
            ((MyFragment) fragment).setItem();
        }
    }
}
