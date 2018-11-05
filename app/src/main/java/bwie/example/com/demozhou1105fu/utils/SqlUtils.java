package bwie.example.com.demozhou1105fu.utils;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import java.util.List;

import bwie.example.com.demozhou1105fu.bean.CacheBean;
import bwie.example.com.demozhou1105fu.greendao.CacheBeanDao;
import bwie.example.com.demozhou1105fu.greendao.DaoMaster;

public class SqlUtils {

    private static SqlUtils mNewsBeanUtils;

    public static SqlUtils getNewsBeanJsonUtils() {
        if (mNewsBeanUtils == null) {
            mNewsBeanUtils = new SqlUtils();
        }
        return mNewsBeanUtils;
    }

    private CacheBeanDao cacheBeanDao;

    public void init(Context context) {
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(context, "news");
        SQLiteDatabase db = helper.getWritableDatabase();
        DaoMaster mDaoMaster = new DaoMaster(db);


        cacheBeanDao = mDaoMaster.newSession().getCacheBeanDao();
    }

    //增
    public void insert(CacheBean newsBean) {
        cacheBeanDao.insert(newsBean);
    }

    //查询
    //查询全部
    public List<CacheBean> queryAll() {
        return cacheBeanDao.loadAll();
    }

}
