package com.izinstudio.ontapretrofit;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

public class UserAdapter extends BaseAdapter {
    private Context context;
    private List<EmployeeUser> listUser;
    private LayoutInflater inflater;
    private ImageView imgProfile;
    private TextView txtID, txtName, txtSalary, txtAge;

    public UserAdapter(Context context, List<EmployeeUser> listUser) {
        this.listUser = listUser;
        this.context = context;
        inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return listUser.size();
    }

    @Override
    public EmployeeUser getItem(int position) {
        return listUser.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null)
            convertView = inflater.inflate(R.layout.item_user, null);
        imgProfile = convertView.findViewById(R.id.imgProfile);
        txtID = convertView.findViewById(R.id.txtID);
        txtName = convertView.findViewById(R.id.txtName);
        txtSalary = convertView.findViewById(R.id.txtSalary);
        txtAge = convertView.findViewById(R.id.txtAge);

        EmployeeUser employeeUser = getItem(position);

        txtID.setText("ID: " + employeeUser.getId());
        txtName.setText("Name: " + employeeUser.getEmployeeName());
        txtSalary.setText("Salary: " + employeeUser.getEmployeeSalary());
        txtAge.setText("Age: " + employeeUser.getEmployeeAge());

        Glide.with(context).load(employeeUser.getProfileImage()).into(imgProfile);
        return convertView;
    }
}
