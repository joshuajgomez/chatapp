package com.joshgm3z.chatapp.common.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

public class SharedPrefs {

    private static final String CHAT_APP_SHARED_PREFS = "CHAT_APP_SHARED_PREFS";
    private static final String CURRENT_USER = "CURRENT_USER";

    public static String getCurrentUser(Context context) {
        SharedPreferences sharedPrefs = context.getSharedPreferences(
                CHAT_APP_SHARED_PREFS, Context.MODE_PRIVATE);
        return sharedPrefs.getString(CURRENT_USER, "");
    }

    public static void setCurrentUser(Context context, String user) {
        if (!user.isEmpty()) {
            SharedPreferences.Editor editor = context.getSharedPreferences(
                    CHAT_APP_SHARED_PREFS, Context.MODE_PRIVATE).edit();
            editor.putString(CURRENT_USER, user);
            editor.apply();
        } else {
            Logger.log(Log.WARN, "Empty user");
        }
    }

}
