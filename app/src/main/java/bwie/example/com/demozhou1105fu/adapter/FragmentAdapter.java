package bwie.example.com.demozhou1105fu.adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

import bwie.example.com.demozhou1105fu.fragment.HomeFragment;
import bwie.example.com.demozhou1105fu.fragment.MyFragment;

public class FragmentAdapter extends FragmentPagerAdapter {
    private String mTitles[] = {"首页", "我的"};
    private List<Fragment> mFragments = new ArrayList<>();

    public FragmentAdapter(FragmentManager fm) {
        super(fm);
        mFragments.add(new HomeFragment());
        mFragments.add(new MyFragment());

    }

    @Override
    public Fragment getItem(int i) {
        return mFragments.get(i);
    }

    @Override
    public int getCount() {
        return mTitles.length;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mTitles[position];
    }
}
