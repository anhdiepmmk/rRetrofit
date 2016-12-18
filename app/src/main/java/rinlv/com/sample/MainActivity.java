package rinlv.com.sample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.io.IOException;
import java.util.List;

import okhttp3.ResponseBody;
import rinlv.com.rretrofit.interfaces.IRequestCallbackListener;
import rinlv.com.rretrofit.utilities.LogUtils;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        new BaseApi().createApi().get("user", GitHub.class, new IRequestCallbackListener<GitHub>() {
//            @Override
//            public void success(GitHub gitHub) {
//                LogUtils.d("github", gitHub.toString());
//            }
//
//            @Override
//            public void success(List<GitHub> tList) {
//
//            }
//
//            @Override
//            public void failByNoInternet() {
//
//            }
//
//            @Override
//            public void failure(int code, ResponseBody errorBody) {
//                try {
//                    LogUtils.d("github", "errorCode = " + code + "; errorBody = " + errorBody.string());
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        });

        new BaseApi().createApi().getList("users/rinlv/repos", GitHub[].class, new IRequestCallbackListener<GitHub>() {
            @Override
            public void success(GitHub gitHub) {

            }

            @Override
            public void success(List<GitHub> tList) {
                for (GitHub gitHub : tList) {
                    LogUtils.d("github", gitHub.toString());
                }
            }

            @Override
            public void failByNoInternet() {

            }

            @Override
            public void failure(int code, ResponseBody errorBody) {
                try {
                    LogUtils.d("github", "errorCode = " + code + "; errorBody = " + errorBody.string());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        JsonPlaceHolder jsonPlaceHolder = new JsonPlaceHolder(1,2, "rinlv", "content post from rRetrofit");
        new BaseApi().createApiFake().post("posts", jsonPlaceHolder, JsonPlaceHolder.class, new IRequestCallbackListener<JsonPlaceHolder>() {
            @Override
            public void success(JsonPlaceHolder jsonPlaceHolder) {
                LogUtils.d("rinlv post success", jsonPlaceHolder.toString());
            }

            @Override
            public void success(List<JsonPlaceHolder> jsonPlaceHolders) {

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
