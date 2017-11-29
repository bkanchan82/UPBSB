package com.example.board.siksha.basic.up.upbsb.db;

import android.arch.persistence.room.TypeConverter;

import java.util.Date;

/**
 * Created by kanchan on 18-11-2017.
 */

public class DateConverter {

    @TypeConverter
    public static Date toDate(Long timestamp){
        return timestamp == null ? null : new Date(timestamp);
    }

    @TypeConverter
    public static Long toTimeStamp(Date date){
        return date == null ? null : date.getTime();
    }

}
