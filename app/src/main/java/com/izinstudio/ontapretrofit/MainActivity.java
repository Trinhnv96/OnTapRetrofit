package com.izinstudio.ontapretrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private ListView listUser;
    private UserAdapter adapter;
    private List<EmployeeUser> list = new ArrayList<>();
    private Employee employee;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        getList();
        loadUser();
    }

    void init() {
        listUser = findViewById(R.id.listUser);

        employee = AppUtils.getEmployee();
    }

    void getList() {
        adapter = new UserAdapter(this, list);
        listUser.setAdapter(adapter);

    }

    void loadUser() {
        employee.getUser().enqueue(new Callback<List<EmployeeUser>>() {
            @Override
            public void onResponse(Call<List<EmployeeUser>> call, Response<List<EmployeeUser>> response) {
                if(response.isSuccessful()) {
                    Log.d("##A",response.toString());
                    for(int i=0;i<response.body().size();i++) {
                        list.add(response.body().get(i));
                    }
                    adapter.notifyDataSetChanged();

                }else {
                    int statusCode  = response.code();
                    Log.d("##A",statusCode+"");
                }
            }

            @Override
            public void onFailure(Call<List<EmployeeUser>> call, Throwable t) {
                Log.d("##A","Faild"+t.getMessage());
            }
        });
    }

}
