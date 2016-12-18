package rinlv.com.sample;

import java.util.ArrayList;

import rinlv.com.rretrofit.builder.ApiGenerator;
import rinlv.com.rretrofit.models.HeaderEntity;

/**
 * Created by Rin.LV on 12/16/2016.
 */

public class BaseApi {

    private static final String host = "https://api.github.com/";
    private static final String fakeHost = "https://jsonplaceholder.typicode.com/";
    private static final int timeOut = 10;

    public ApiGenerator createApi() {
        return new ApiGenerator(host, timeOut);
    }

    public ApiGenerator createApiFake() {
        return new ApiGenerator(fakeHost, timeOut);
    }

    public ApiGenerator createApiWithHeader() {
        ArrayList<HeaderEntity> headerEntities = new ArrayList<>();
        headerEntities.add(new HeaderEntity("Content-Type", "application/json"));
        return new ApiGenerator(headerEntities, host, timeOut);
    }
}
