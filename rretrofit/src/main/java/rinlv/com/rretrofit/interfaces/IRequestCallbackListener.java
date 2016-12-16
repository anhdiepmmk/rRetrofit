package rinlv.com.rretrofit.interfaces;

import okhttp3.ResponseBody;

/**
 * Created by Rin.LV on 12/16/2016.
 */

public interface IRequestCallbackListener<T> {

    void success(T t);

    void failByNoInternet();

    void failure(int code, ResponseBody errorBody);
}
