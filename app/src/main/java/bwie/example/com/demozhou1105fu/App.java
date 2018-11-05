package bwie.example.com.demozhou1105fu;

import android.app.Application;

import bwie.example.com.demozhou1105fu.utils.SqlUtils;

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        SqlUtils.getNewsBeanJsonUtils().init(this);
    }
}
