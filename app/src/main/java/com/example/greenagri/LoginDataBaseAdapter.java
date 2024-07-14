package com.example.greenagri;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class LoginDataBaseAdapter {

    static final String DATABASE_NAME = "login.db";
    static final int DATABASE_VERSION = 1;
    public static final int NAME_COLUMN = 1;
    public static final int EMAIL_COLUMN = 1;
    public static final int MOBILE_COLUMN = 1;
    public static final int ADDR_COLUMN = 1;
    public static final int PASSWORD_COLUMN = 1;


    // TODO: Create public field for each column in your table.                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    ,
    // SQL Statement to create a new database.
    static final String DATABASE_USER = "create table " + "LOGIN" +
            "( " + "S_NAME  text, S_EMAIL text, S_PASSWORD text, S_MOBILE text, S_ADHAR text, S_DOB text, S_ADDR text ); ";

    static final String DATABASE_FARMER = "create table " + "FORMERLOGIN" +
            "( " + "F_NAME  text, F_EMAIL text, F_PASSWORD text, F_MOBILE text, F_ADHAR text, F_ADDR text ); ";
    // Variable to hold the database instance

    public static SQLiteDatabase db;
    // Context of the application using the database.

    private final Context context;
    // Database open/upgrade helper

    private DataBaseHelper dbHelper;

    public LoginDataBaseAdapter(Context _context) {
        context = _context;
        dbHelper = new DataBaseHelper(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public com.example.greenagri.LoginDataBaseAdapter open() throws SQLException {
        db = dbHelper.getWritableDatabase();
        return this;
    }

    public static void close() {
        db.close();
    }

    public SQLiteDatabase getDatabaseInstance() {
        return db;
    }

    public static void insertEntry(String name, String email, String password, String mobile, String adhar, String dob, String addr) {
        ContentValues newValues = new ContentValues();
        // Assign values for each row.
        newValues.put("S_NAME", name);
        newValues.put("S_EMAIL", email);
        newValues.put("S_PASSWORD", password);
        newValues.put("S_MOBILE", mobile);
        newValues.put("S_ADHAR", adhar);
        newValues.put("S_DOB", dob);
        newValues.put("S_ADDR", addr);
        //newValues.put("S_YEAR",year);

        // Insert the row into your table
        db.insert("LOGIN", null, newValues);
        ///Toast.makeText(context, "Reminder Is Successfully Saved", Toast.LENGTH_LONG).show();
    }

    public static void insertFarmerEntry(String name, String email, String password, String mobile, String adhar, String addr) {
        ContentValues newValues = new ContentValues();
        // Assign values for each row.
        newValues.put("F_NAME", name);
        newValues.put("F_EMAIL", email);
        newValues.put("F_PASSWORD", password);
        newValues.put("F_MOBILE", mobile);
        newValues.put("F_ADHAR", adhar);
        newValues.put("F_ADDR", addr);
        //newValues.put("S_YEAR",year);

        // Insert the row into your table
        db.insert("FORMERLOGIN", null, newValues);
        ///Toast.makeText(context, "Reminder Is Successfully Saved", Toast.LENGTH_LONG).show();
    }

    public int deleteEntry(String name) {
        //String id=String.valueOf(ID);
        String where = "S_NAME=?";
        int numberOFEntriesDeleted = db.delete("LOGIN", where, new String[]{name});
        // Toast.makeText(context, "Number for Entry Deleted Successfully : "+numberOFEntriesDeleted, Toast.LENGTH_LONG).show();
        return numberOFEntriesDeleted;
    }

    public String getSinlgeEntry(String email) {
        Cursor cursor = db.query("LOGIN", null, " S_EMAIL=?", new String[]{email}, null, null, null);
        if (cursor.getCount() < 1) // UserName Not Exist
        {
            cursor.close();
            return "NOT EXIST";
        }
        cursor.moveToFirst();
        String password = cursor.getString(cursor.getColumnIndex("S_PASSWORD"));

        cursor.close();
        return password;
    }

    public String getSinlgeEntryF(String email) {
        Cursor cursor = db.query("FORMERLOGIN", null, " F_EMAIL=?", new String[]{email}, null, null, null);
        if (cursor.getCount() < 1) // UserName Not Exist
        {
            cursor.close();
            return "NOT EXIST";
        }
        cursor.moveToFirst();
        String password = cursor.getString(cursor.getColumnIndex("F_PASSWORD"));

        cursor.close();
        return password;
    }


    public String getSingleEntry1(String email) {
        Cursor cursor = db.query("LOGIN", null, " S_EMAIL=?", new String[]{email}, null, null, null);
        cursor.moveToFirst();
        String name = cursor.getString(cursor.getColumnIndex("S_NAME"));
        cursor.close();
        return name;
    }

    public String getSingleEntry2(String email) {
        Cursor c = db.query("LOGIN", null, " S_EMAIL=?", new String[]{email}, null, null, null);
        c.moveToFirst();
        String mobil = c.getString(c.getColumnIndex("S_EMAIL"));
        c.close();
        return mobil;
    }

    public String getSingleEntry3(String email) {
        Cursor c = db.query("LOGIN", null, " S_EMAIL=?", new String[]{email}, null, null, null);
        c.moveToFirst();
        String addr = c.getString(c.getColumnIndex("S_MOBILE"));
        c.close();
        return addr;
    }

    public String getSingleEntry5(String email) {
        Cursor c = db.query("LOGIN", null, " S_EMAIL=?", new String[]{email}, null, null, null);
        c.moveToFirst();
        String addr = c.getString(c.getColumnIndex("S_ADDR"));
        c.close();
        return addr;
    }

    public String getSingleEntry6(String email) {
        Cursor c = db.query("LOGIN", null, " S_EMAIL=?", new String[]{email}, null, null, null);
        c.moveToFirst();
        String addr = c.getString(c.getColumnIndex("S_ADDR"));
        c.close();
        return addr;
    }

    public String getSingleEntry7(String email) {
        Cursor c = db.query("LOGIN", null, " S_EMAIL=?", new String[]{email}, null, null, null);
        c.moveToFirst();
        String addr = c.getString(c.getColumnIndex("S_ADDR"));
        c.close();
        return addr;
    }
    public String getSingleEntry8(String email){
        Cursor c=db.query("LOGIN", null, " S_EMAIL=?", new String[]{email}, null, null, null);
        c.moveToFirst();
        String addr=c.getString(c.getColumnIndex("S_ADDR"));
        c.close();
        return addr;
    }


    public void updateEntry(String name, String email, String password, String mobile, String dob, String addr) {
        // Define the updated row content.
        ContentValues newValues = new ContentValues();
        // Assign values for each row.
        newValues.put("S_NAME", name);
        newValues.put("S_PASSWORD", password);
        newValues.put("S_MOBILE", mobile);
        newValues.put("S_DOB", dob);
        newValues.put("S_ADDR", addr);
        //newValues.put("S_YEAR",year);


        String where = "S_NAME = ?";
        db.update("LOGIN", newValues, where, new String[]{name});
    }

    public String getSingleEntry4(String did) {
        // TODO Auto-generated method stub
        return null;
    }


}
