package com.example.board.siksha.basic.up.upbsb.db;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.TypeConverters;

import java.util.Date;
import java.util.List;

import static android.arch.persistence.room.OnConflictStrategy.IGNORE;

/**
 * Created by kanchan on 18-11-2017.
 */
@Dao
@TypeConverters(DateConverter.class)
public interface EmployeeDao {

    @Query("select * from Employee")
    LiveData<List<Employee>> getAllEmployees();

    @Query("select * from Employee "+
    "INNER JOIN Attendance ON Attendance.employee_id = Employee.id "+
    "WHERE Attendance.deviceDateTime > :after")
    public LiveData<List<Employee>> getTodaysAttendanceEmployee(Date after);

    @Insert(onConflict = IGNORE)
    void insertEmployee(Employee employee);

    @Query("DELETE FROM Employee")
    void deleteAll();


}
