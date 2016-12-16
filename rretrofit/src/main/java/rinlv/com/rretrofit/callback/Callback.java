package rinlv.com.rretrofit.callback;

import java.util.ArrayList;
import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Response;
import rinlv.com.rretrofit.interfaces.IRequestCallbackListener;
import rinlv.com.rretrofit.models.ErrorEntity;

/**
 * Created by Rin.LV on 12/16/2016.
 */

public class Callback<T> implements retrofit2.Callback<T> {

    private IRequestCallbackListener<T> mRequestCallbackListener;
    private HashMap<Integer, String> mErrorCode = new HashMap<>();

    public Callback(IRequestCallbackListener<T> requestCallbackListener, ArrayList<ErrorEntity> errorEntities) {
        mRequestCallbackListener = requestCallbackListener;
        for (ErrorEntity errorEntity : errorEntities) {
            mErrorCode.put(errorEntity.getCode(), errorEntity.getMessage());
        }
    }

    @Override
    public void onResponse(Call<T> call, Response<T> response) {
        if (response.isSuccessful()) {
            mRequestCallbackListener.success(response.body());
        } else {
            mRequestCallbackListener.failure(mErrorCode.get(response.code()));
        }
    }

    @Override
    public void onFailure(Call<T> call, Throwable t) {
        mRequestCallbackListener.failByNoInternet();
    }
}
