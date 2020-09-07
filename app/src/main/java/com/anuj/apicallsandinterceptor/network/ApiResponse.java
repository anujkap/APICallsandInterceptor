package com.anuj.apicallsandinterceptor.network;

public class ApiResponse<T> {

    /**
     * This class is used in the view models for checking the status of the requests
     */

    private T data;
        private ApiError errorMessage;
        private ApiResponseStatus apiStatus;


    private ApiResponse(T data, ApiError errorMessage, ApiResponseStatus apiStatus) {
            this.data = data;
            this.errorMessage = errorMessage;
            this.apiStatus = apiStatus;
        }

    public T getData() {
        return data;
    }



    public void setData(T data) {
        this.data = data;
    }

    public ApiError getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(ApiError errorMessage) {
        this.errorMessage = errorMessage;
    }

    public ApiResponseStatus getApiStatus() {
        return apiStatus;
    }

    public void setApiStatus(ApiResponseStatus apiStatus) {
        this.apiStatus = apiStatus;
    }

    public static <T> ApiResponse<T> getSuccessResponse(T data) {
            return new ApiResponse<>(data, null, ApiResponseStatus.SUCCESS);
        }

        public static <T> ApiResponse<T> getFailureResponse(ApiError errorMessage) {
            return new ApiResponse<>(null, errorMessage, ApiResponseStatus.FAILED);
        }

        public static <T> ApiResponse<T> getLoadingResponse() {
            return new ApiResponse<>(null, null, ApiResponseStatus.LOADING);
        }


    public enum ApiResponseStatus {
        SUCCESS,
        FAILED,
        LOADING
    }

}
