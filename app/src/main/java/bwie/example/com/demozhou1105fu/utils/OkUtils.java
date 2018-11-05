package bwie.example.com.demozhou1105fu.utils;

import android.os.Handler;
import android.os.Message;

import com.squareup.okhttp.Callback;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;

public class OkUtils {
    private OkUtils (){

    }

    private static OkUtils okUtils;

    public static OkUtils getInstance(){
        if (okUtils == null) {
            okUtils=new OkUtils();
        }
        return okUtils;
    }

    private Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            String data= (String) msg.obj;
            lisener.success(data);
        }

    };

    private OkListener lisener;

    public OkUtils get(String url){
        OkHttpClient client = new OkHttpClient();
        Request build = new Request.Builder().url(url).build();
        client.newCall(build).enqueue(new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {

            }

            @Override
            public void onResponse(Response response) throws IOException {
                String data = response.body().string();
                Message message = Message.obtain();
                message.obj=data;
                handler.sendMessage(message);
            }
        });
        return this;
    }

    public void setOkLisener(OkListener lisener){
        this.lisener=lisener;
    }


    public interface OkListener{
        void success(String data);
    }


}
