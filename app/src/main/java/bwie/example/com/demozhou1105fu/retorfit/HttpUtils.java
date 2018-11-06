package bwie.example.com.demozhou1105fu.retorfit;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class HttpUtils {

    private Retrofit mRetrofit;
    private BaseService baseService;
    public HttpUtils() {

        //初始化Retorfit
        mRetrofit = new Retrofit.Builder()
                .baseUrl("http://www.zhaoapi.cn/")
                .build();
        baseService = mRetrofit.create(BaseService.class);//获取service对象通过反射
    }

    private Callback<ResponseBody> callback = new Callback<ResponseBody>() {
        @Override
        public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
            if (response.isSuccessful()&&response.code()==200) {

                try {
                    listener.success( response.body().string());
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }else{
                listener.fail(response.message());
            }
        }

        @Override
        public void onFailure(Call<ResponseBody> call, Throwable t) {
            listener.fail(t.getMessage());
        }
    };




    //get请求
    public HttpUtils get(String url, Map<String, String> map) {
        if (map == null) {
            map=new HashMap<>();
        }
        baseService.get(url, map).enqueue(callback);
        return this;
    }

    //post请求
    public void post(String url, Map<String, String> map) {
        baseService.post(url, map).enqueue(callback);
    }

    private HttpListener listener;

    public void setListener(HttpListener listener) {
        this.listener = listener;
    }

    public interface HttpListener {
        void success(String data);

        void fail(String error);
    }

}
