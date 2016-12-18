# rRetrofit
Library base on Retrofit 2.2.0 helping generate code connect with api support: GET, POST, PUT

Download
--------

Gradle:

```groovy  
compile 'com.github.rinlv:rretrofit:0.2'
```


Usage
-----
#### In Code
``` java
 private static final String host = "https://api.github.com/"; //end point
 private static final int timeOut = 10; // timeOut connection, write/read
 private ArrayList<HeaderEntity> headerEntities = new ArrayList<>(); // list header, example: Content-Type, Authorization ...
```
##### GET
``` java
 new BaseApi().createApi().get("user", GitHub.class, new IRequestCallbackListener<GitHub>() {
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
                try {
                    LogUtils.d("github", "errorCode = " + code + "; errorBody = " + errorBody.string());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
 
```

##### POST
``` java
JsonPlaceHolder jsonPlaceHolder = new JsonPlaceHolder(1,2, "rinlv", "content postFormBody from rRetrofit");
new BaseApi().createApiFake().postFormUrlEncoded("posts", jsonPlaceHolder, JsonPlaceHolder.class, new IRequestCallbackListener<JsonPlaceHolder>() {
            @Override
            public void success(JsonPlaceHolder jsonPlaceHolder) {
                LogUtils.d("rinlv postFormBody success", jsonPlaceHolder.toString());
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
```

##### PUT

```java
JsonPlaceHolder jsonPlaceHolder = new JsonPlaceHolder(1,2, "rinlv", "content postFormBody from rRetrofit");
new BaseApi().createApiFake().putFormUrlEncoded("posts", jsonPlaceHolder, JsonPlaceHolder.class, new IRequestCallbackListener<JsonPlaceHolder>() {
            @Override
            public void success(JsonPlaceHolder jsonPlaceHolder) {
                LogUtils.d("rinlv postFormBody success", jsonPlaceHolder.toString());
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
```
