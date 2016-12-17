package rinlv.com.sample;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

/**
 * Created by Rin.LV on 12/16/2016.
 */

public interface GitHubService {
    @GET
    Call<ArrayList<GitHub>> getRepo(@Url String url);
}
