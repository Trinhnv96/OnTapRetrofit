package com.izinstudio.ontapretrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Employee {
    @GET("employees")
    Call<List<EmployeeUser>> getUser();
}
