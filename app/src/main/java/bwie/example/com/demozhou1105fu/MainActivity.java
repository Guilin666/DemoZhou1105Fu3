package bwie.example.com.demozhou1105fu;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import bwie.example.com.demozhou1105fu.adapter.FragmentAdapter;
import bwie.example.com.demozhou1105fu.utils.OkUtils;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.tab_main)
    TabLayout tab_main;
    @BindView(R.id.viewpager_main)
    ViewPager viewpager_main;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        FragmentAdapter fragmentAdapter = new FragmentAdapter(getSupportFragmentManager());
        viewpager_main.setAdapter(fragmentAdapter);
        tab_main.setupWithViewPager(viewpager_main);
        tab_main.setTabMode(TabLayout.MODE_FIXED);

    }


}
