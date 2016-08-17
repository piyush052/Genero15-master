package com.dexterous.genero15.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;

public class SharedPreferencesProvider {

    static private boolean firstRun = false;
    static private int ref = 0;

    /*
        public static final String USER_NAME = "com.dexterous.contactbook.username";
        public static final String USER_DEPT = "com.dexterous.contactbook..userdept";
        public static final String USER_MO = "com.dexterous.contactbook..usermo";
        public static final String USER_EXT = "com.dexterous.contactbook..userext";
        public static final String USER_ID = "com.dexterous.contactbook..userid";
        public static final String USER_EMAIL = "com.dexterous.contactbook..useremail";*/
    public static final String PREFERENCE_KEY_FOR_FIRST_RUN = "com.dexterous.genero15.firstrun";
    public static final String PREFERENCE_KEY_FOR_USERNAME = "com.dexterous.genero15.username";
    public static final String PREFERENCE_KEY_FOR_REFERCODE = "com.dexterous.genero15.refercode";
    public static final String PREFERENCE_KEY_FOR_DEVICEID = "com.dexterous.genero15.deviceid";
    public static final String PREFERENCE_KEY_FOR_CT = "com.dexterous.genero15.ct";

    public static SharedPreferences defaultSharedPrefs = null;

    public static SharedPreferences getDefaultSharedPreferences(Context context) {
        if (defaultSharedPrefs == null)
            defaultSharedPrefs = PreferenceManager
                    .getDefaultSharedPreferences(context
                            .getApplicationContext());
        return defaultSharedPrefs;
    }

    /*
        static public void saveUser(Context context, JSONObject jsonObject) {
            SharedPreferences filName = SharedPreferencesProvider.getDefaultSharedPreferences(context);
            SharedPreferences.Editor editor = filName.edit();
            editor.putString(USER_NAME, JsonUtil.getData(jsonObject, "name"));
            editor.putString(USER_DEPT, JsonUtil.getData(jsonObject, "dept"));
            editor.putString(USER_EXT, JsonUtil.getData(jsonObject, "speedDialNo"));
            editor.putString(USER_ID, JsonUtil.getData(jsonObject, "empId"));
            editor.putString(USER_EMAIL, JsonUtil.getData(jsonObject, "email"));
            editor.putString(USER_MO, JsonUtil.getData(jsonObject, "mobileNo"));
            editor.commit();
        }
    */
    static public boolean isFirstRun(Context context) {
        SharedPreferences filName = SharedPreferencesProvider
                .getDefaultSharedPreferences(context);
        firstRun = filName.getBoolean(SharedPreferencesProvider.PREFERENCE_KEY_FOR_FIRST_RUN, true);
        return firstRun;
    }

    static public void setFirstRun(Context context, boolean firstRun) {
        SharedPreferences.Editor filName = PreferenceManager
                .getDefaultSharedPreferences(context).edit();
        filName.putBoolean(SharedPreferencesProvider.PREFERENCE_KEY_FOR_FIRST_RUN, firstRun);
        filName.apply();
    }

    static public void saveUser(Context context, String username, String deviceid, String refcode) {
        SharedPreferences.Editor filName = PreferenceManager
                .getDefaultSharedPreferences(context).edit();
        filName.putString(PREFERENCE_KEY_FOR_USERNAME, username);
        filName.putString(PREFERENCE_KEY_FOR_DEVICEID, deviceid);
        filName.putInt(PREFERENCE_KEY_FOR_REFERCODE, Integer.valueOf(refcode));
        Log.e("KARTIK", "OKZ");
        filName.apply();
    }

    static public int getRefCode(Context context) {
        SharedPreferences filName = SharedPreferencesProvider
                .getDefaultSharedPreferences(context);
        ref = filName.getInt(PREFERENCE_KEY_FOR_REFERCODE, 0);
        return ref;
    }

    static public String getUIDCode(Context context) {
        SharedPreferences filName = SharedPreferencesProvider
                .getDefaultSharedPreferences(context);
        return filName.getString(PREFERENCE_KEY_FOR_DEVICEID, null);
    }

    static public String getUserName(Context context) {
        SharedPreferences filName = SharedPreferencesProvider
                .getDefaultSharedPreferences(context);
        return filName.getString(PREFERENCE_KEY_FOR_USERNAME, null);
    }

    static public void saveUserData(Context context, String ct) {
        SharedPreferences.Editor filName = PreferenceManager
                .getDefaultSharedPreferences(context).edit();
        filName.putInt(PREFERENCE_KEY_FOR_CT, Integer.valueOf(ct));
        filName.apply();
    }
}
