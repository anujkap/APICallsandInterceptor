package com.anuj.apicallsandinterceptor;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.anuj.apicallsandinterceptor.network.ApiResponse;
import com.anuj.apicallsandinterceptor.network.requestBod.Request1;

public class MainActivity extends AppCompatActivity {

    ApiViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewModel = new ViewModelProvider(this).get(ApiViewModel.class);

        viewModel.getListener().observe(this, response->{
            ApiResponse.ApiResponseStatus status = response.getApiStatus();
            switch (status) {
                case LOADING:
                    /*
                      TODO Handle Loading
                     Show Loading UI
                    */
                    break;
                case FAILED:
                    /*
                    TODO Handle Failure
                    Show Fail UI
                    */
                    break;
                case SUCCESS:
                    /*
                    TODO Handle Success
                    Show the UI
                    */
                    break;
            }

        });

        /*
            To send the request just call this function
         */
        viewModel.sendRequest(this, new Request1("Hello World"));


    }
}