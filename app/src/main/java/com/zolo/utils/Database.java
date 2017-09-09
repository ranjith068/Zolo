package com.zolo.utils;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;
import android.util.Log;

import com.zolo.di.ApplicationContext;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by ranjith on 29/4/17.
 */

@Singleton
public class Database extends SQLiteOpenHelper {

    // All Static variables
    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "userManager";

    // Contacts table name
    private static final String TABLE_USERS = "users";

    // Contacts Table Columns names
    private static final String KEY_ID = "id";
    private static final String KEY_PHONENUMBER = "phonenumber";
    private static final String KEY_EMAIL = "email";
    private static final String KEY_PASSWORD = "password";
    private static final String KEY_NAME = "name";


    @Inject
    public Database(@ApplicationContext Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            setWriteAheadLoggingEnabled(true);
        }
    }

    @Override
    public void onConfigure(SQLiteDatabase db) {
        super.onConfigure(db);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB &&
                Build.VERSION.SDK_INT < Build.VERSION_CODES.JELLY_BEAN) {
            db.enableWriteAheadLogging();
        } else {


            Log.d("DATABASE", "WAL is not supported on API levels below 11.");

        }
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_CONTACTS_TABLE = "CREATE TABLE " + TABLE_USERS + "("
                +  KEY_PHONENUMBER + " TEXT PRIMARY KEY,"+  KEY_EMAIL + " TEXT,"+  KEY_NAME + " TEXT,"+ KEY_PASSWORD + " TEXT"
                + ")";
        db.execSQL(CREATE_CONTACTS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USERS);

        // Create tables again
        onCreate(db);
    }


    public void addUser(UserModel user) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_PHONENUMBER, user.get_phonenumber()); // Contact Name
        values.put(KEY_EMAIL, user.get_email());
        values.put(KEY_PASSWORD, user.get_password());
        values.put(KEY_NAME, user.get_name());
        // Inserting Row
        db.insert(TABLE_USERS, null, values);
        db.close(); // Closing database connection
    }

//    public List<UserModel> getAllLocations() {
//        List<UserModel> contactList = new ArrayList<UserModel>();
//        // Select All Query
//        String selectQuery = "SELECT  * FROM " + TABLE_USERS;
//
//        SQLiteDatabase db = this.getWritableDatabase();
//        Cursor cursor = db.rawQuery(selectQuery, null);
//
//        // looping through all rows and adding to list
//        if (cursor.moveToFirst()) {
//            do {
//                UserModel contact = new UserModel();
//                contact.setID(Integer.parseInt(cursor.getString(0)));
//                contact.setName(cursor.getString(1));
//                // Adding contact to list
//                contactList.add(contact);
//            } while (cursor.moveToNext());
//        }
//
//        // return contact list
//        return contactList;
//    }


    // Getting events Count
    public int getUsersCount() {
        String countQuery = "SELECT  * FROM " + TABLE_USERS;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        int count = cursor.getCount();
        cursor.close();

        // return count
        return count;
    }


    public void deleteAll() {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("delete from " + TABLE_USERS);
        db.close();
    }

    boolean phoneNumberExists(String phonenumber) {
        SQLiteDatabase db = this.getReadableDatabase();
        long count = DatabaseUtils.queryNumEntries(db,
                "users", "phonenumber = ?", new String[] { phonenumber });
        return count > 0;
    }

    boolean passwordExists(String password) {
        SQLiteDatabase db = this.getReadableDatabase();
        long count = DatabaseUtils.queryNumEntries(db,
                "users", "password = ?", new String[] { password });
        return count > 0;


    }

    boolean loginExists(String phonenumber,String password) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor mCursor = db.rawQuery("SELECT * FROM " + TABLE_USERS + " WHERE    phonenumber = ? and password = ?", new String[]{phonenumber,password});

        if (mCursor.moveToFirst())
        {
            mCursor.close();
            return true;
            /* record exist */
        }
        else
        {
            mCursor.close();
            return false;
            /* record not exist */
        }
    }

    public UserModel getUser(String phonenumber) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_USERS, new String[] {
                        KEY_PHONENUMBER, KEY_EMAIL ,KEY_NAME,KEY_PASSWORD}, KEY_PHONENUMBER + "=?",
                new String[] { phonenumber }, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        UserModel user = new UserModel(
                cursor.getString(0), cursor.getString(1),cursor.getString(2),cursor.getString(3));
        // return contact
        return user;
    }
}
