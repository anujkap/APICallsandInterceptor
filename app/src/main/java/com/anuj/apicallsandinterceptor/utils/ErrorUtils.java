package com.anuj.apicallsandinterceptor.utils;

import android.content.Context;

import com.anuj.apicallsandinterceptor.network.ApiError;
import com.anuj.apicallsandinterceptor.network.RetrofitInstance;

import java.io.IOException;
import java.lang.annotation.Annotation;

import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Response;

public class ErrorUtils {

    /**
     * No changes are required in this file
     */

    public static ApiError parseError(Context context, Response<?> response) {
        Converter<ResponseBody, ApiError> converter =
                RetrofitInstance.getRetrofitInstance(context)
                        .responseBodyConverter(ApiError.class, new Annotation[0]);

        ApiError error;

        try {
            error = converter.convert(response.errorBody());
        } catch (IOException e) {
            return new ApiError();
        }

        return error;
    }

}
