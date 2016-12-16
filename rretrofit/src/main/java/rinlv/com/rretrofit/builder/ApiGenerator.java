package rinlv.com.rretrofit.builder;

import android.content.Context;

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
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import rinlv.com.rretrofit.models.HeaderEntity;

/**
 * Created by Rin.LV on 12/16/2016.
 */

public class ApiGenerator<T> {

    private Callback<T> mCallback;
    private Context mContext;

    public ApiGenerator(Context context) {
        mContext = context;
    }

    public <S> S createService(Class<S> serviceClass, String host, int timeOut, final ArrayList<HeaderEntity> headerEntities, String dateFormat) {
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .readTimeout(timeOut, TimeUnit.SECONDS)
                .writeTimeout(timeOut, TimeUnit.SECONDS)
                .connectTimeout(timeOut, TimeUnit.SECONDS)
                .build();
        okHttpClient.interceptors().add(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request.Builder rBuilder = chain.request().newBuilder();
                for (HeaderEntity headerEntity : headerEntities) {
                    rBuilder.addHeader(headerEntity.getKey(), headerEntity.getValue());
                }
                Request request = rBuilder.build();
                Response response = chain.proceed(request);
                MediaType contentType = response.body().contentType();
                String bodyString = response.body().string();
                ResponseBody body = ResponseBody.create(contentType, bodyString);
                return response.newBuilder().body(body).build();
            }
        });
        Gson gson = new GsonBuilder()
                .setDateFormat(dateFormat)
                .create();
        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl(host)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(okHttpClient);
        return builder.build().create(serviceClass);
    }
}
