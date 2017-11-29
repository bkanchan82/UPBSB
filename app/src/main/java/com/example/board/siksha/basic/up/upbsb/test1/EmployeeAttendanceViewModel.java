package com.example.board.siksha.basic.up.upbsb.test1;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;

import com.example.board.siksha.basic.up.upbsb.db.AppDatabase;
import com.example.board.siksha.basic.up.upbsb.db.Employee;
import com.example.board.siksha.basic.up.upbsb.db.utils.DatabaseInitializer;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by kanchan on 18-11-2017.
 */

public class EmployeeAttendanceViewModel extends AndroidViewModel {

    public final LiveData<List<Employee>> employees;
    private AppDatabase mDb;

    public EmployeeAttendanceViewModel(Application application){
        super(application);
        createDb();

        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DATE,-1);
        Date yesterday = calendar.getTime();

        employees = mDb.employeeModel().getTodaysAttendanceEmployee(yesterday);

    }


    public void createDb(){
        mDb = AppDatabase.getInMemoryDatabase(this.getApplication());
        DatabaseInitializer.populateAsync(mDb);
    }

}
