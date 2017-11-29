package com.example.board.siksha.basic.up.upbsb.db.utils;

import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.util.Log;

import com.example.board.siksha.basic.up.upbsb.db.AppDatabase;
import com.example.board.siksha.basic.up.upbsb.db.Attendance;
import com.example.board.siksha.basic.up.upbsb.db.Employee;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by kanchan on 18-11-2017.
 */

public class DatabaseInitializer {

    // Simulate a blocking operation delaying each Loan insertion with a delay:
    private static final int DELAY_MILLIS = 500;

    public static void populateAsync(final AppDatabase db) {

        PopulateDbAsync task = new PopulateDbAsync(db);
        task.execute();
    }

    public static void populateSync(@NonNull final AppDatabase db) {
        populateWithTestData(db);
    }

    private static Employee addEmployee(final AppDatabase db,
                                    final String id,
                                    final String name,
                                    final String contactOne,
                                    final String contactTwo,
                                    final String panNo,
                                    final String post,
                                    final String status,
                                    final String password) {
        Employee employee = new Employee();
        employee.id = id;
        employee.name = name;
        employee.contactOne = contactOne;
        employee.contactTwo = contactTwo;
        employee.panNo = panNo;
        employee.post = post;
        employee.status = status;
        employee.password = password;
        db.employeeModel().insertEmployee(employee);
        return employee;
    }

    private static Attendance addAttendance(final AppDatabase db,
                                            final Employee employee,
                                            final Date deviceDateTime,
                                            final String attendanceType,
                                            final String picturePath,
                                            final String address,
                                            final String sendingStatus,
                                            final double latitude,
                                            final double longitude) {
        Attendance attendance = new Attendance();
        attendance.employeeId = employee.id;
        attendance.deviceDateTime = deviceDateTime;
        attendance.attendanceType = attendanceType;
        attendance.picturePath = picturePath;
        attendance.address = address;
        attendance.sendingStatus = sendingStatus;
          attendance.latitude = latitude;
        attendance.longitude = longitude;
        db.attendanceModel().insertAttendance(attendance);
        return attendance;
    }


    private static void populateWithTestData(AppDatabase db) {
        db.employeeModel().deleteAll();
        db.attendanceModel().deleteAll();

        Employee employee1 = addEmployee(db, "1", "Kanchan", "1234567890", "","CHPUK123","BASIC TEACHER","Active","CHPUK123");
        Employee employee2 = addEmployee(db, "2", "Pushpendra", "0987654321", "","CHPUK567","BASIC TEACHER","Active","CHPUK567");
        Employee employee3 = addEmployee(db, "3", "Rahul", "5678904321", "","CHPUK890","BASIC TEACHER","Active","CHPUK890");
        Employee employee4 = addEmployee(db, "4", "Sarita", "7654321890", "","CHPUK098","BASIC TEACHER","Active","CHPUK098");

        Date today = getTodayPlusDays(0);
        Date yesterday = getTodayPlusDays(-1);
        Date twoDaysAgo = getTodayPlusDays(-2);
        Date lastWeek = getTodayPlusDays(-7);
        Date twoWeeksAgo = getTodayPlusDays(-14);


        Attendance attendance0 = addAttendance(db,employee1,yesterday,"IN","","","Save",26.500038,80.302851);
        Attendance attendance1 = addAttendance(db,employee2,today,"OUT","","","Save",26.500038,80.302851);
        Attendance attendance2 = addAttendance(db,employee3,twoDaysAgo,"IN","","","Save",26.500038,80.302851);
        /*try {
            // Loans are added with a delay, to have time for the UI to react to changes.

            Date today = getTodayPlusDays(0);
            Date yesterday = getTodayPlusDays(-1);
            Date twoDaysAgo = getTodayPlusDays(-2);
            Date lastWeek = getTodayPlusDays(-7);
            Date twoWeeksAgo = getTodayPlusDays(-14);

            addLoan(db, "1", user1, book1, twoWeeksAgo, lastWeek);
            Thread.sleep(DELAY_MILLIS);
            addLoan(db, "2", user2, book1, lastWeek, yesterday);
            Thread.sleep(DELAY_MILLIS);
            addLoan(db, "3", user2, book2, lastWeek, today);
            Thread.sleep(DELAY_MILLIS);
            addLoan(db, "4", user2, book3, lastWeek, twoDaysAgo);
            Thread.sleep(DELAY_MILLIS);
            addLoan(db, "5", user2, book4, lastWeek, today);
            Log.d("DB", "Added loans");

        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
    }

    private static Date getTodayPlusDays(int daysAgo) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DATE, daysAgo);
        return calendar.getTime();
    }

    private static class PopulateDbAsync extends AsyncTask<Void, Void, Void> {

        private final AppDatabase mDb;

        PopulateDbAsync(AppDatabase db) {
            mDb = db;
        }

        @Override
        protected Void doInBackground(final Void... params) {
            populateWithTestData(mDb);
            return null;
        }

    }

}
