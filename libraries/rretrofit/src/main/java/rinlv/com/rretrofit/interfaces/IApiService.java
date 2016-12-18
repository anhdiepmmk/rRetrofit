package rinlv.com.rretrofit.interfaces;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Url;
import rinlv.com.rretrofit.models.PostParameter;

/**
 * Created by Rin.LV on 12/17/2016.
 */

public interface IApiService {
    @GET
    Call<ResponseBody> get(@Url String url);

    @POST
    Call<ResponseBody> post(@Url String url, @Body PostParameter postParameter);
}
