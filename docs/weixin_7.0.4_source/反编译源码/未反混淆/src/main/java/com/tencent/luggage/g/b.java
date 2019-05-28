package com.tencent.luggage.g;

import android.os.Build.VERSION;

public final class b {
    public static boolean iW(int i) {
        return VERSION.SDK_INT >= i;
    }

    public static boolean fP(int i) {
        return VERSION.SDK_INT < i;
    }
}
