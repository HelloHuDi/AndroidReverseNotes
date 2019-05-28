package com.tencent.tencentmap.mapsdk.a;

import android.content.Context;

public class j {
    private static volatile Context a;

    public static void a(Context context) {
        a = context;
    }

    public static Context a() {
        return a;
    }
}
