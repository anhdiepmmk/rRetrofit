# rRetrofit
Library base on Retrofit 2.2.0

Download
--------

Gradle:

```groovy  
compile 'com.github.rinlv:rretrofit:0.1'
```


Usage
-----
#### In Code
``` java
 private static final String host = "https://api.github.com/"; //end point
 private static final int timeOut = 10; // timeOut connection, write/read
 private ArrayList<HeaderEntity> headerEntities = new ArrayList<>(); // list header, example: Content-Type, Authorization ...
```

``` java
 new ApiGenerator(host, timeOut).createService(GitHubService.class).getRepo("rinlv").enqueue(new Callback<>(new IRequestCallbackListener<ArrayList<GitHub>>() {
            @Override
            public void success(ArrayList<GitHub> gitHubs) {
                for (GitHub gitHub : gitHubs) {
                    LogUtils.d("github rinlv", gitHub.toString());
                }
            }

            @Override
            public void failByNoInternet() {

            }

            @Override
            public void failure(int code, ResponseBody errorBody) {

            }
        }));
 
```
OR

``` java
new ApiGenerator(headerEntities, host, timeOut).createService(GitHubService.class).getRepo("rinlv").enqueue(new Callback<>(new IRequestCallbackListener<ArrayList<GitHub>>() {
            @Override
            public void success(ArrayList<GitHub> gitHubs) {
                for (GitHub gitHub : gitHubs) {
                    LogUtils.d("github rinlv", gitHub.toString());
                }
            }

            @Override
            public void failByNoInternet() {

            }

            @Override
            public void failure(int code, ResponseBody errorBody) {

            }
        }));
```
