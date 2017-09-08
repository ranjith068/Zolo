package com.zolo.utils;

/**
 * Created by ranjith on 29/4/17.
 */

public class UserModel {

    //private variables
    int _id;
    String _phonenumber;
    String _email;
    String _password;


    // Empty constructor
    public UserModel(){

    }

    public String get_phonenumber() {
        return _phonenumber;
    }

    public void set_phonenumber(String _phonenumber) {
        this._phonenumber = _phonenumber;
    }

    public String get_email() {
        return _email;
    }

    public void set_email(String _email) {
        this._email = _email;
    }

    public String get_password() {
        return _password;
    }

    public void set_password(String _password) {
        this._password = _password;
    }

    public UserModel(String _phonenumber, String _email, String _password) {

        this._phonenumber = _phonenumber;
        this._email = _email;
        this._password = _password;
    }
}