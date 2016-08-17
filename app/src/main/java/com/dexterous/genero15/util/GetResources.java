package com.dexterous.genero15.util;

import android.content.Context;

/**
 * Created by Honey on 9/29/2015.
 */
public class GetResources {

    public static String getStringFromXml(Context context, String base, String post) {

        int resId = context.getResources().getIdentifier(base + post, "string", context.getPackageName());
        return context.getString(resId);
    }


    public static String[] getStringArrayFromXml(Context context, String base, String post) {

        int resId = context.getResources().getIdentifier(base + post, "array", context.getPackageName());
        return context.getResources().getStringArray(resId);
    }


}
