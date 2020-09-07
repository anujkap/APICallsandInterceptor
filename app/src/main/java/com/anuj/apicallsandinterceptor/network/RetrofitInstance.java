package com.anuj.apicallsandinterceptor.network;

import android.content.Context;

import com.facebook.flipper.plugins.network.FlipperOkhttpInterceptor;
import com.facebook.flipper.plugins.network.NetworkFlipperPlugin;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.anuj.apicallsandinterceptor.data.Constants.BASE_URL;

public class RetrofitInstance {

    /**
     * This Class is handling all our retrofit objects. It creates the objects and attaches
     * the necessary interceptors for debugging and convenience purposes.
     */
    private static Retrofit retrofit;

    public static Retrofit getRetrofitInstance(Context context) {
        OkHttpClient client = getOkHttpClient(context);
        if (retrofit == null) {
            retrofit = new retrofit2.Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .client(client)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }

    /**
     * If you want to increase the timeout period for the requests
     * make the changes in the below code as required.
     */
    private static OkHttpClient getOkHttpClient(Context context) {
        return new OkHttpClient.Builder()
                .addNetworkInterceptor(new FlipperOkhttpInterceptor(new NetworkFlipperPlugin()))
                .readTimeout(60, TimeUnit.SECONDS)
                .callTimeout(60, TimeUnit.SECONDS)
                .addInterceptor(new HeaderInterceptor(context))
                .build();
    }

}
