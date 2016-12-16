package rinlv.com.sample;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Rin.LV on 12/16/2016.
 */

public interface GithubService {
    @GET("users/{user}/repos")
    Call<ArrayList<GitHub>> getRepo(@Path("user") String user);
}
