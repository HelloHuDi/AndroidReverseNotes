package com.google.android.exoplayer2.source.a;

import com.google.android.exoplayer2.h.r.e;

public final class b {
    public static boolean c(Exception exception) {
        if (!(exception instanceof e)) {
            return false;
        }
        int i = ((e) exception).responseCode;
        if (i == 404 || i == 410) {
            return true;
        }
        return false;
    }
}
