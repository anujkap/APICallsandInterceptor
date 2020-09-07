package com.anuj.apicallsandinterceptor.network;

import com.anuj.apicallsandinterceptor.network.requestBod.Request1;
import com.anuj.apicallsandinterceptor.network.response.Response1;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface APIService {

    /**
     * Add your API calls here with the required method(POST, GET, PUT, etc)
     * and define the type of req eg. MULTIPART
     * Replace the Response, with the object defined that you will get back from the API
     * and the RequestBody with the actual body of your Request
     * We don't need to add headers here as we use Header Interceptor for that purpose.
     */
    @POST("/apiRouteToAccess")
    Call<Response1> callFunction(
            @Body Request1 request1
    );
}
