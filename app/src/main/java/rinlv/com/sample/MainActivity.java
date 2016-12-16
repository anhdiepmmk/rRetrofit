package rinlv.com.sample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

import okhttp3.ResponseBody;
import rinlv.com.rretrofit.builder.ApiGenerator;
import rinlv.com.rretrofit.callback.Callback;
import rinlv.com.rretrofit.interfaces.IRequestCallbackListener;
import rinlv.com.rretrofit.utils.LogUtils;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new ApiGenerator("https://api.github.com/", 10).createService(GithubService.class).getRepos("rinlv", new Callback<ArrayList<GitHub>>(new IRequestCallbackListener<ArrayList<GitHub>>() {
            @Override
            public void success(ArrayList<GitHub> gitHubs) {
                for (GitHub gitHub : gitHubs) {
                    LogUtils.d("rinlv", gitHub.toString());
                }
            }

            @Override
            public void failByNoInternet() {

            }

            @Override
            public void failure(int code, ResponseBody errorBody) {

            }
        }));
    }
}
