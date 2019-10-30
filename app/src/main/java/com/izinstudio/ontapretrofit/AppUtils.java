package com.izinstudio.ontapretrofit;

import retrofit2.Retrofit;

public class AppUtils {
    public static final String URL = "http://dummy.restapiexample.com/api/v1/";

    public static Employee getEmployee() {
        return RetrofitClient.getClient(URL).create(Employee.class);
    }
}
