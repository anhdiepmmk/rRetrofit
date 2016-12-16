package rinlv.com.rretrofit.builder;

import android.content.Context;

import okhttp3.OkHttpClient;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Rin.LV on 12/16/2016.
 */

public class ApiGenerator<T> {

    private Callback<T> mCallback;
    private Context mContext;

    public ApiGenerator(Context context) {
        mContext = context;
    }

    public <S> S createService(Class<S> serviceClass, final String host) {
        OkHttpClient okHttpClient = new OkHttpClient();
        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl(host)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient);
        return builder.build().create(serviceClass);
    }
}
