package com.tencent.p177mm.compatible.util;

import android.os.Build.VERSION;

/* renamed from: com.tencent.mm.compatible.util.d */
public final class C1443d {
    /* renamed from: iW */
    public static boolean m3068iW(int i) {
        return VERSION.SDK_INT >= i;
    }

    /* renamed from: fP */
    public static boolean m3067fP(int i) {
        return VERSION.SDK_INT < i;
    }

    /* renamed from: iX */
    public static boolean m3069iX(int i) {
        return VERSION.SDK_INT > i;
    }
}
