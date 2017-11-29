package com.example.board.siksha.basic.up.upbsb;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.board.siksha.basic.up.upbsb.db.Employee;
import com.example.board.siksha.basic.up.upbsb.test1.EmployeeAttendanceViewModel;

import java.util.List;

public class SignUpActivity extends AppCompatActivity {

    private EmployeeAttendanceViewModel mViewModel;

    private TextView mEmployeeTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        mEmployeeTextView = (TextView)findViewById(R.id.employees_tv);
        mViewModel = ViewModelProviders.of(this).get(EmployeeAttendanceViewModel.class);

        showEmployees();

    }

    private void showEmployees() {
        mViewModel.employees.observe(this, new Observer<List<Employee>>() {
            @Override
            public void onChanged(@NonNull final List<Employee> books) {
                showBooksInUi(books, mEmployeeTextView);
            }
        });
    }

    private static void showBooksInUi(final @NonNull List<Employee> employees,
                                      final TextView employeeTextView) {
        StringBuilder sb = new StringBuilder();

        for (Employee employee : employees) {
            sb.append(employee.name);
            sb.append("\n");

        }
        employeeTextView.setText(sb.toString());
    }

}
