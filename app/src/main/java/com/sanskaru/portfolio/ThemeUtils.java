package com.sanskaru.portfolio;

import android.app.Activity;
import android.util.Log;

public class ThemeUtils
{
    static Boolean myBool;

    public static void onActivityCreateSetConditionTheme(Activity activity, boolean b) {

        myBool = b;
        if (b) activity.setTheme(R.style.AppThemeDark);

        else activity.setTheme(R.style.AppTheme);

        Log.i("Dark Mode", myBool.toString());
    }
}
