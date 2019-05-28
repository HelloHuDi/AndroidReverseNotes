package com.tencent.mm.audio.mix.h;

import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

public final class b {
    private static final String SYS_INFO;
    private static a coi;
    private static a coj;
    private static int level = 6;

    public interface a {
    }

    static {
        AppMethodBeat.i(137218);
        AnonymousClass1 anonymousClass1 = new a() {
            private Handler handler = new Handler(Looper.getMainLooper());

            {
                AppMethodBeat.i(137211);
                AppMethodBeat.o(137211);
            }
        };
        coi = anonymousClass1;
        coj = anonymousClass1;
        StringBuilder stringBuilder = new StringBuilder();
        try {
            stringBuilder.append("VERSION.RELEASE:[" + VERSION.RELEASE);
            stringBuilder.append("] VERSION.CODENAME:[" + VERSION.CODENAME);
            stringBuilder.append("] VERSION.INCREMENTAL:[" + VERSION.INCREMENTAL);
            stringBuilder.append("] BOARD:[" + Build.BOARD);
            stringBuilder.append("] DEVICE:[" + Build.DEVICE);
            stringBuilder.append("] DISPLAY:[" + Build.DISPLAY);
            stringBuilder.append("] FINGERPRINT:[" + Build.FINGERPRINT);
            stringBuilder.append("] HOST:[" + Build.HOST);
            stringBuilder.append("] MANUFACTURER:[" + Build.MANUFACTURER);
            stringBuilder.append("] MODEL:[" + Build.MODEL);
            stringBuilder.append("] PRODUCT:[" + Build.PRODUCT);
            stringBuilder.append("] TAGS:[" + Build.TAGS);
            stringBuilder.append("] TYPE:[" + Build.TYPE);
            stringBuilder.append("] USER:[" + Build.USER + "]");
        } catch (Throwable th) {
            ab.printErrStackTrace("mix.Log", th, "", new Object[0]);
        }
        SYS_INFO = stringBuilder.toString();
        AppMethodBeat.o(137218);
    }

    public static void e(String str, String str2, Object... objArr) {
        AppMethodBeat.i(137215);
        ab.e(str, str2, objArr);
        AppMethodBeat.o(137215);
    }

    public static void i(String str, String str2, Object... objArr) {
        AppMethodBeat.i(137216);
        ab.i(str, str2, objArr);
        AppMethodBeat.o(137216);
    }

    public static void printErrStackTrace(String str, Throwable th, String str2, Object... objArr) {
        AppMethodBeat.i(137217);
        ab.printErrStackTrace(str, th, str2, objArr);
        AppMethodBeat.o(137217);
    }

    public static void e(String str, String str2) {
        AppMethodBeat.i(137212);
        ab.e(str, str2, null);
        AppMethodBeat.o(137212);
    }

    public static void i(String str, String str2) {
        AppMethodBeat.i(137213);
        ab.i(str, str2, null);
        AppMethodBeat.o(137213);
    }

    public static void d(String str, String str2) {
        AppMethodBeat.i(137214);
        ab.d(str, str2, null);
        AppMethodBeat.o(137214);
    }
}
