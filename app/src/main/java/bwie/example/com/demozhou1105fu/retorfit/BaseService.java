package bwie.example.com.demozhou1105fu.retorfit;

import java.util.Map;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;

public interface BaseService {

    //定义两个方法
    @GET
    Call<ResponseBody> get(@Url String url, @QueryMap Map<String,String> map);

    @POST
    Call<ResponseBody> post(@Url String url,@QueryMap Map<String,String> map);


}
