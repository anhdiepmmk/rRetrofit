package rinlv.com.rretrofit.builder;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import rinlv.com.rretrofit.models.HeaderEntity;
import rinlv.com.rretrofit.utils.LogUtils;

/**
 * Created by Rin.LV on 12/16/2016.
 */

public class ApiGenerator {
    private static final String TAG = "ApiGenerator";
    private Retrofit mRetrofit;
    private ArrayList<HeaderEntity> mHeaderEntities = new ArrayList<>();

    public ApiGenerator() {
    }

    public ApiGenerator(ArrayList<HeaderEntity> headerEntities) {
        mHeaderEntities = headerEntities;
    }

    public void newBuidler(String host, int timeOut, String dateFormat) {
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .readTimeout(timeOut, TimeUnit.SECONDS)
                .writeTimeout(timeOut, TimeUnit.SECONDS)
                .connectTimeout(timeOut, TimeUnit.SECONDS)
                .build();
        okHttpClient.interceptors().add(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request.Builder rBuilder = chain.request().newBuilder();
                for (HeaderEntity headerEntity : mHeaderEntities) {
                    rBuilder.addHeader(headerEntity.getKey(), headerEntity.getValue());
                }
                Request request = rBuilder.build();
                Response response = chain.proceed(request);
                MediaType contentType = response.body().contentType();
                String bodyString = response.body().string();
                ResponseBody body = ResponseBody.create(contentType, bodyString);
                LogUtils.d(TAG, "ContentType " + contentType.toString());
                LogUtils.d(TAG, "Body " + bodyString);
                return response.newBuilder().body(body).build();
            }
        });
        Gson gson = new GsonBuilder()
                .setDateFormat(dateFormat)
                .create();
        mRetrofit = new Retrofit.Builder()
                .baseUrl(host)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(okHttpClient).build();
    }

    public <S> S createService(Class<S> serviceClass) {
        return mRetrofit.create(serviceClass);
    }
}
