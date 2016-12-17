package rinlv.com.sample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.List;

import okhttp3.ResponseBody;
import rinlv.com.rretrofit.interfaces.IRequestCallbackListener;
import rinlv.com.rretrofit.utilities.LogUtils;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new BaseApi().createApi().getList("users/rinlv/repos", GitHub[].class, new IRequestCallbackListener<GitHub>() {
            @Override
            public void success(GitHub gitHub) {

            }

            @Override
            public void success(List<GitHub> tList) {
                for (GitHub gitHub : tList) {
                    LogUtils.d("github list", gitHub.toString());
                }
            }

            @Override
            public void failByNoInternet() {

            }

            @Override
            public void failure(int code, ResponseBody errorBody) {

            }
        });

        new BaseApi().createApi().get("repos/rinlv/rRetrofit", GitHub.class, new IRequestCallbackListener<GitHub>() {
            @Override
            public void success(GitHub gitHub) {
                LogUtils.d("github", gitHub.toString());
            }

            @Override
            public void success(List<GitHub> tList) {

            }

            @Override
            public void failByNoInternet() {

            }

            @Override
            public void failure(int code, ResponseBody errorBody) {

            }
        });
    }
}
