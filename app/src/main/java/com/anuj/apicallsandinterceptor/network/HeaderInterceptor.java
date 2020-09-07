package com.anuj.apicallsandinterceptor.network;

import android.content.Context;

import com.anuj.apicallsandinterceptor.utils.SharedPrefs;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class HeaderInterceptor implements Interceptor {

    /**
     * This class is being used to set up a custom interceptor.
     * All the headers that need to be added to the request may be added here.
     * By default I have added the authorisation header.
     * authToken is being stored in Shared Preferences and can be fetched from there.
     * Also a Cookie integration can be done as shown if required. If not remove that addHeader statement
     */

    private final Context context;
    public HeaderInterceptor(Context context) {
        this.context = context;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        String authToken = SharedPrefs.getInstance(this.context).getAuthToken();
        Request request = chain.request()
                .newBuilder()
                .addHeader("authorization", authToken)
                .addHeader("Cookie", "User-Access-Token="+authToken)
                .build();
        return chain.proceed(request);
    }
}