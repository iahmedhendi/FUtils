package com.fourhcode.forhutils;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

/**
 * Created by Muhammad on 20/09/2016.
 */
public class FUtilsSession {

    private static FUtilsSession instance;
    private Context context;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;


    private String PREF_NAME = "";
    private static final String IS_LOGIN = "IsLoggedIn";
    public static final String KEY_USER_NAME = "username";
    public static final String KEY_USER_FULL_NAME = "full_name";
    public static final String KEY_USER_EMAIL = "email";
    public static final String KEY_USER_ID = "user_id";
    public static final String KEY_USER_LANGUAGE = "user_language";
    public static final String KEY_ACCESS_TOKEN = "access_token";
    public static final String KEY_FCM_TOKEN = "fcm_token";



    public void config(Context context, String sessionName) {
        this.context = context;
        this.PREF_NAME = sessionName;
    }

    public FUtilsSession() {
        sharedPreferences = context.getSharedPreferences(PREF_NAME, 0);
        editor = sharedPreferences.edit();
    }

    public static FUtilsSession getInstance() {
        if (instance == null) {
            instance = new FUtilsSession();
        }
        return instance;
    }

    public static void loginUser(int userId, String username, String email) {
        getInstance().localLoginUser(userId, username, email);
    }

    public static void setUserName(String username) {
        getInstance().localSetUserName(username);
    }

    public static void setUserEmail(String userEmail) {
        getInstance().localSetUserEmail(userEmail);
    }

    public static void setUserFullName(String fullName) {
        getInstance().localSetUserFullName(fullName);
    }

    public static void setUserId(int userId) {
        getInstance().localSetUserID(userId);
    }

    public static void setUserLanguage(String language) {
        getInstance().localSetUserLanguage(language);
    }

    public static void setAccessToken(String accessToken) {
        getInstance().localSetAccessToken(accessToken);
    }

    public static void setFcmToken(String fcmToken) {
        getInstance().localSetFcmToken(fcmToken);
    }

    public static void setUserLoginStatus(boolean loginStatus) {
        getInstance().localSetUserLoginStatus(loginStatus);
    }

    public static String getUserName() {
        return getInstance().localGetUserName();
    }

    public static String getUserEmail() {
        return getInstance().localGetUserEmail();
    }

    public static String getUserFullName() {
        return getInstance().localGetUserFullName();
    }

    public static String getAccessToken() {
        return getInstance().localGetAccessToken();
    }

    public static String getFcmToken() {
        return getInstance().localGetFcmToken();
    }

    public static int getUserID() {
        return getInstance().localGetUserID();
    }

    public static String getUserLanguage() {
        return getInstance().localGetUserLanguage();
    }

    public static boolean isLogin() {
        return getInstance().localIsLogin();
    }

    public static void logoutUserAndBackToLogin(Class<?> loginActivity) {
        getInstance().localLogoutUserAndBackToLogin(loginActivity);
    }

    public static void logoutUser() {
        getInstance().localLogoutUser();
    }


    private void localLoginUser(int userId, String username, String email) {
        editor.putBoolean(IS_LOGIN, true);
        editor.putString(KEY_USER_NAME, username);
        editor.putString(KEY_USER_EMAIL, email);
        editor.putInt(KEY_USER_ID, userId);
        editor.apply();
    }


    private void localSetUserName(String username) {
        editor.putString(KEY_USER_NAME, username).apply();
    }

    private void localSetUserEmail(String userEmail) {
        editor.putString(KEY_USER_EMAIL, userEmail).apply();
    }

    private void localSetUserFullName(String fullName) {
        editor.putString(KEY_USER_FULL_NAME, fullName).apply();
    }

    private void localSetUserID(int userId) {
        editor.putInt(KEY_USER_ID, userId).apply();
    }

    private void localSetUserLanguage(String language) {
        editor.putString(KEY_USER_LANGUAGE, language).apply();
    }

    private void localSetAccessToken(String accessToken) {
        editor.putString(KEY_ACCESS_TOKEN, accessToken).apply();
    }

    private void localSetFcmToken(String fcmToken) {
        editor.putString(KEY_FCM_TOKEN, fcmToken).apply();
    }

    private void localSetUserLoginStatus(boolean loginStatus) {
        editor.putBoolean(IS_LOGIN, loginStatus);
    }

    private String localGetUserName() {
        return sharedPreferences.getString(KEY_USER_NAME, "");
    }

    private String localGetUserEmail() {
        return sharedPreferences.getString(KEY_USER_EMAIL, "");
    }

    private String localGetUserFullName() {
        return sharedPreferences.getString(KEY_USER_FULL_NAME, "");
    }

    private String localGetAccessToken() {
        return sharedPreferences.getString(KEY_ACCESS_TOKEN, "");
    }

    private String localGetFcmToken() {
        return sharedPreferences.getString(KEY_FCM_TOKEN, "");
    }

    private int localGetUserID() {
        return sharedPreferences.getInt(KEY_USER_ID, 0);
    }

    private String localGetUserLanguage() {
        return sharedPreferences.getString(KEY_USER_LANGUAGE, "");
    }

    private boolean localIsLogin() {
        return sharedPreferences.getBoolean(IS_LOGIN, false);
    }


    public void localLogoutUserAndBackToLogin(Class<?> loginActivity) {
        editor.clear().apply();
        Intent i = new Intent(context, loginActivity);
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(i);
    }

    public void localLogoutUser() {
        editor.clear().apply();
    }


}
