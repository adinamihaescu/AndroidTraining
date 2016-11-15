package com.endava.androidlist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class ListActivity extends AppCompatActivity {

    private ListView mListView;
    private EmployeeAdapter mAdapter;
    private List<Employee> mEmployeeList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        initData();

        mListView = (ListView) findViewById(R.id.lv_employee);
        mAdapter = new EmployeeAdapter(this, mEmployeeList);
        mListView.setAdapter(mAdapter);
    }

    private void initData() {
        mEmployeeList = new ArrayList<>();
        String[] employeeNames = getResources().getStringArray(R.array.employee_name);
        String[] employeePosition = getResources().getStringArray(R.array.employee_position);
        for (int i = 0; i < employeeNames.length; i++) {
            Employee employee = new Employee();
            employee.setName(employeeNames[i]);
            employee.setPosition(employeePosition[i]);
            mEmployeeList.add(employee);
        }
        mEmployeeList.get(1).setLineManager(true);
    }

}
