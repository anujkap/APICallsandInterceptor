package com.anuj.apicallsandinterceptor.network;

public class ApiError {

    /**
     * This is a custom Error Class to set the error messages
     */

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    private boolean success;
    private String message;

    public ApiError() {
    }

    public ApiError(String message) {
        this.message = message;
    }

    public String message() {
        return message;
    }
}
