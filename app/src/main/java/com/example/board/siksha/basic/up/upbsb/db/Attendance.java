package com.example.board.siksha.basic.up.upbsb.db;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.TypeConverter;
import android.arch.persistence.room.TypeConverters;

import java.util.Date;

/**
 * Created by kanchan on 18-11-2017.
 */

@Entity(foreignKeys = {
        @ForeignKey(entity = Employee.class,
        parentColumns = "id",
        childColumns = "employee_id")
})

@TypeConverters(DateConverter.class)
public class Attendance {
    public @PrimaryKey(autoGenerate = true) int id;
    @ColumnInfo(name = "employee_id")
    public String employeeId;
    public Date deviceDateTime;
    public String attendanceType;
    public String picturePath;
    public String address;
    public String sendingStatus;
    public double latitude;
    public double longitude;
}
