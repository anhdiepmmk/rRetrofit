package rinlv.com.rretrofit.callback;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;
import rinlv.com.rretrofit.interfaces.IRequestCallbackListener;
import rinlv.com.rretrofit.utilities.LogUtils;
import rinlv.com.rretrofit.utilities.Utils;

/**
 * Created by Rin.LV on 12/16/2016.
 */

public class Callback<T> implements retrofit2.Callback<ResponseBody> {

    private IRequestCallbackListener<T> mRequestCallbackListener;
    private Class<T> mClazz;
    private Class<T[]> mListClazz;

    public Callback(Class<T> clazz, Class<T[]> listClazz, IRequestCallbackListener<T> requestCallbackListener) {
        mRequestCallbackListener = requestCallbackListener;
        mClazz = clazz;
        mListClazz = listClazz;
    }

    @Override
    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
        if (response.isSuccessful()) {
            try {
                if (mClazz != null) {
                    mRequestCallbackListener.success(Utils.stringGsonToObject(response.body().string(), mClazz));
                }
                if (mListClazz != null) {
                    mRequestCallbackListener.success(Utils.stringGsonToArray(response.body().string(), mListClazz));
                }
            } catch (Exception ex) {
                LogUtils.e("Callback<T> rin.lv", ex.getMessage());
            }
        } else {
            mRequestCallbackListener.failure(response.code(), response.errorBody());
        }
    }

    @Override
    public void onFailure(Call<ResponseBody> call, Throwable t) {
        mRequestCallbackListener.failByNoInternet();
    }
}
