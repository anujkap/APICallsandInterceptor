package com.anuj.apicallsandinterceptor;

import android.content.Context;

import com.facebook.stetho.Stetho;

public class Application extends android.app.Application {

    /**
     * Create this class and call the Stetho.initialize fn to start the service.
     * Change this name of application in manifest too
     */

    public static Application application;

    public static synchronized Application getInstance() {
        return application;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Stetho.initializeWithDefaults(this);
    }

    public static Application getApplicationInstance() {
        if (application != null)
            return application;
        return null;
    }

    @Override
    public Context getApplicationContext() {
        return super.getApplicationContext();
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);

        //MultiDex.install(this);
    }
}
