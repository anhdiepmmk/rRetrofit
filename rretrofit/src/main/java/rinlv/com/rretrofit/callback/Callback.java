package rinlv.com.rretrofit.callback;

import retrofit2.Call;
import retrofit2.Response;
import rinlv.com.rretrofit.interfaces.IRequestCallbackListener;

/**
 * Created by Rin.LV on 12/16/2016.
 */

public class Callback<T> implements retrofit2.Callback<T> {

    private IRequestCallbackListener<T> mRequestCallbackListener;

    public Callback(IRequestCallbackListener<T> requestCallbackListener) {
        mRequestCallbackListener = requestCallbackListener;
    }

    @Override
    public void onResponse(Call<T> call, Response<T> response) {
        if (response.isSuccessful()) {
            mRequestCallbackListener.success(response.body());
        } else {
            mRequestCallbackListener.failure(response.code(), response.errorBody());
        }
    }

    @Override
    public void onFailure(Call<T> call, Throwable t) {
        mRequestCallbackListener.failByNoInternet();
    }
}
