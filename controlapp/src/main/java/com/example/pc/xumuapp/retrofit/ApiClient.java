package com.example.pc.xumuapp.retrofit;


import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by wys
 */
public class ApiClient {
    public static Retrofit mRetrofit_internal, mRetrofit_external;
    public static final String BASEURL_INTERNAL = "http://49.4.71.112:8090/iahs/";

//    http://39.107.152.122/fm/app/install/api/
//    http://39.107.152.122/fm/a/
//    public static final String BASEURL_INTERNAL = "http://120.221.150.59:8081/EPIM/api/app/";
    public static final String BASEURL_EXTERNAL = "https://way.jd.com/jisuapi/";
    /*
    为了动态改变BaseUrl
     */

    public static Retrofit retrofit(@HostType.HostTypeChecker int hostType) {
        if (hostType == HostType.INTERNAL) {
            if (mRetrofit_internal == null) {
                OkHttpClient.Builder builder = new OkHttpClient.Builder();
                OkHttpClient okHttpClient = builder.build();
                mRetrofit_internal = new Retrofit.Builder()
                        .baseUrl(getHost(hostType))
                        .addConverterFactory(LenientGsonConverterFactory.create())
                        .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                        .client(okHttpClient)
                        .build();
            }

        } else if (hostType == HostType.EXTERNAL) {
            if (mRetrofit_external == null) {
                OkHttpClient.Builder builder = new OkHttpClient.Builder();
                OkHttpClient okHttpClient = builder.build();
                mRetrofit_external = new Retrofit.Builder()
                        .baseUrl(getHost(hostType))
                        .addConverterFactory(GsonConverterFactory.create())
                        .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                        .client(okHttpClient)
                        .build();
            }

        }
        return hostType==HostType.INTERNAL?mRetrofit_internal:mRetrofit_external;
    }


    public static String getHost(int hostType) {
        String host;
        switch (hostType) {
            case HostType.INTERNAL:
                host = BASEURL_INTERNAL;
                break;
            case HostType.EXTERNAL:
                host = BASEURL_EXTERNAL;
                break;

            default:
                host = "";
                break;
        }
        return host;
    }

}
