package com.anuj.apicallsandinterceptor.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import androidx.annotation.NonNull;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class SharedPrefs {

    /**
     * This file is for easy integration of SharedPreferences.
     * Create Constants for the app data names and define methods for easy of use and to reduce confusion
     * Change the name app_prefs to whatever you want to name your preferences file.
     *
     * Define setters as shown below along with getters.
     *
     * To use the function call the static method getInstance() as:
     *          SharedPrefs prefs = SharedPrefs.getInstance(context)
     *
     * Pass the context as required from the activity that is using the preferences
     */

    private static SharedPrefs instance = null;
    private SharedPreferences prefs;

    private static final String APP_PREFS = "app_prefs";

    private static final String AUTH_TOKEN = "auth_token";


    public static SharedPrefs getInstance(Context context) {
        if (instance == null) {
            instance = new SharedPrefs(context);
        }
        return instance;
    }

    private SharedPrefs(Context context) {
        prefs = context.getSharedPreferences(APP_PREFS, Context.MODE_PRIVATE);
    }

    public String getAuthToken() {
        return prefs.getString(AUTH_TOKEN, "");
    }

    public void setAuthToken(@NonNull String token) {
        Log.v("SharedPrefs", token);
        prefs.edit()
                .putString(AUTH_TOKEN, token)
                .apply();
    }

}
