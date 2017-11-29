package com.example.board.siksha.basic.up.upbsb.db;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

/**
 * Created by kanchan on 18-11-2017.
 */
@Entity
public class Employee {
    @ColumnInfo(name = "id")
    public @PrimaryKey @NonNull String id;
    public String name;
    public String contactOne;
    public String contactTwo;
    public String panNo;
    public String post;
    public String status;
    public String password;

}
