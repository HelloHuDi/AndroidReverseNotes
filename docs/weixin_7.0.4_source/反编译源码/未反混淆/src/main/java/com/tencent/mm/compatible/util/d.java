package com.tencent.mm.compatible.util;

import android.os.Build.VERSION;

public final class d {
    public static boolean iW(int i) {
        return VERSION.SDK_INT >= i;
    }

    public static boolean fP(int i) {
        return VERSION.SDK_INT < i;
    }

    public static boolean iX(int i) {
        return VERSION.SDK_INT > i;
    }
}
