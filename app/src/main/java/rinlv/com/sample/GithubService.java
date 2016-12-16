package rinlv.com.sample;

import java.util.ArrayList;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rinlv.com.rretrofit.callback.Callback;

/**
 * Created by Rin.LV on 12/16/2016.
 */

public interface GithubService {
    @GET("users/{user}/repos")
    void getRepos(@Path("user") String user, Callback<ArrayList<GitHub>> callback);
}
