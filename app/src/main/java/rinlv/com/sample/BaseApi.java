package rinlv.com.sample;

import rinlv.com.rretrofit.builder.ApiGenerator;

/**
 * Created by Rin.LV on 12/16/2016.
 */

public class BaseApi {

    private static final String host = "https://api.github.com/";
    private static final int timeOut = 10;

    public ApiGenerator getApi() {
        return new ApiGenerator(host, timeOut);
    }
}
