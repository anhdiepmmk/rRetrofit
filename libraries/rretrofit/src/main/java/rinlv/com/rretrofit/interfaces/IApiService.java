package rinlv.com.rretrofit.interfaces;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

/**
 * Created by Rin.LV on 12/17/2016.
 */

public interface IApiService {
    @GET
    Call<ResponseBody> get(@Url String url);
}
