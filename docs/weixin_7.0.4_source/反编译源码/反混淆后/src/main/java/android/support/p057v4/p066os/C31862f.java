package android.support.p057v4.p066os;

import android.os.Build.VERSION;
import android.os.Trace;

/* renamed from: android.support.v4.os.f */
public final class C31862f {
    public static void beginSection(String str) {
        if (VERSION.SDK_INT >= 18) {
            Trace.beginSection(str);
        }
    }

    public static void endSection() {
        if (VERSION.SDK_INT >= 18) {
            Trace.endSection();
        }
    }
}
