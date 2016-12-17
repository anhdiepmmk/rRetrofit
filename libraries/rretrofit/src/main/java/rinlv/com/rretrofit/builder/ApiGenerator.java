package rinlv.com.rretrofit.builder;

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
import rinlv.com.rretrofit.callback.Callback;
import rinlv.com.rretrofit.interfaces.IApiService;
import rinlv.com.rretrofit.interfaces.IRequestCallbackListener;
import rinlv.com.rretrofit.models.HeaderEntity;
import rinlv.com.rretrofit.utilities.LogUtils;

/**
 * Created by Rin.LV on 12/16/2016.
 */

public class ApiGenerator {
    private static final String TAG = "ApiGenerator";
    private ArrayList<HeaderEntity> mHeaderEntities = new ArrayList<>();
    private String mHost;
    private int mTimeOut;

    private Retrofit newBuilder() {
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .readTimeout(mTimeOut, TimeUnit.SECONDS)
                .writeTimeout(mTimeOut, TimeUnit.SECONDS)
                .connectTimeout(mTimeOut, TimeUnit.SECONDS)
                .addInterceptor(new Interceptor() {
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
                }).build();
        return new Retrofit.Builder()
                .baseUrl(mHost)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient).build();
    }

    private IApiService createService() {
        return newBuilder().create(IApiService.class);
    }

    private <S> S createService(Class<S> serviceClass) {
        return newBuilder().create(serviceClass);
    }

    public ApiGenerator(String host, int timeOut) {
        mHost = host;
        mTimeOut = timeOut;
    }

    public ApiGenerator(ArrayList<HeaderEntity> headerEntities, String host, int timeOut) {
        mHeaderEntities = headerEntities;
        mHost = host;
        mTimeOut = timeOut;
    }

    public <T> void get(String url, Class<T> clazz, IRequestCallbackListener<T> mTiRequestCallbackListener) {
        createService().get(url).enqueue(new Callback<>(clazz, null, mTiRequestCallbackListener));
    }

    public <T> void getList(String url, Class<T[]> clazzList, IRequestCallbackListener<T> mTiRequestCallbackListener) {
        createService().get(url).enqueue(new Callback<>(null, clazzList, mTiRequestCallbackListener));
    }
}
