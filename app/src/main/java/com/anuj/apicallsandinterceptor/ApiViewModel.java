package com.anuj.apicallsandinterceptor;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.anuj.apicallsandinterceptor.network.APIService;
import com.anuj.apicallsandinterceptor.network.ApiError;
import com.anuj.apicallsandinterceptor.network.ApiResponse;
import com.anuj.apicallsandinterceptor.network.RetrofitInstance;
import com.anuj.apicallsandinterceptor.network.requestBod.Request1;
import com.anuj.apicallsandinterceptor.network.response.Response1;
import com.anuj.apicallsandinterceptor.utils.ErrorUtils;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ApiViewModel extends ViewModel {

    /**
     * This class is going to handel our API requests. Use a View model for the calls on a single route.
     * LiveData stores the current status for the API call.
     *
     * To check the status, this LiveData may be observed.
     * To make the actual call, the function of the View model needs to be called.
     */

    MutableLiveData<ApiResponse<Response1>> testLiveData = new MutableLiveData<>();

    void sendRequest(final Context context, Request1 req){
        APIService apiService = RetrofitInstance.getRetrofitInstance(context).create(APIService.class);
        Call<Response1> responseCall = apiService.callFunction(req);
        testLiveData.postValue(ApiResponse.<Response1>getLoadingResponse());
        responseCall.enqueue(new Callback<Response1>() {
            @Override
            public void onResponse(Call<Response1> call, Response<Response1> response) {
                if(response.isSuccessful()) {
                    testLiveData.postValue(ApiResponse.getSuccessResponse(response.body()));
                }
                else{
                    ApiError apiError = ErrorUtils.parseError(context,response);
                    testLiveData.postValue(ApiResponse.<Response1>getFailureResponse(apiError));
                }
            }

            @Override
            public void onFailure(Call<Response1> call, Throwable t) {
                testLiveData.postValue(ApiResponse.<Response1>getFailureResponse(new ApiError("Error sending search trailer request")));
            }
        });

    }

    public LiveData<ApiResponse<Response1>> getListener(){
        return testLiveData;
    }
}
