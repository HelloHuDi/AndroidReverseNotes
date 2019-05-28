package com.google.android.exoplayer2.source.p1520a;

import com.google.android.exoplayer2.p110h.C17668r.C17670e;

/* renamed from: com.google.android.exoplayer2.source.a.b */
public final class C41623b {
    /* renamed from: c */
    public static boolean m72930c(Exception exception) {
        if (!(exception instanceof C17670e)) {
            return false;
        }
        int i = ((C17670e) exception).responseCode;
        if (i == 404 || i == 410) {
            return true;
        }
        return false;
    }
}
