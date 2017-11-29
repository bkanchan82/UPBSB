package com.example.board.siksha.basic.up.upbsb.db;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

import static android.arch.persistence.room.OnConflictStrategy.IGNORE;

/**
 * Created by kanchan on 18-11-2017.
 */
@Dao
public interface AttendanceDao {

    @Query("select * from Attendance")
    public LiveData<List<Attendance>> getAttendance();


    @Insert(onConflict = IGNORE)
    void insertAttendance(Attendance attendance);

    @Query("DELETE FROM Attendance")
    void deleteAll();

}
