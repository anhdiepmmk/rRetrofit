package rinlv.com.rretrofit.interfaces;

import java.util.List;

import okhttp3.ResponseBody;

/**
 * Created by Rin.LV on 12/16/2016.
 */

public interface IRequestCallbackListener<T> {

    void success(T t);

    void success(List<T> tList);

    void failByNoInternet();

    void failure(int code, ResponseBody errorBody);
}
