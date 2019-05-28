package com.tencent.p177mm.audio.mix.p197h;

import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.audio.mix.h.b */
public final class C45174b {
    private static final String SYS_INFO;
    private static C17963a coi;
    private static C17963a coj;
    private static int level = 6;

    /* renamed from: com.tencent.mm.audio.mix.h.b$a */
    public interface C17963a {
    }

    /* renamed from: com.tencent.mm.audio.mix.h.b$1 */
    static class C451731 implements C17963a {
        private Handler handler = new Handler(Looper.getMainLooper());

        C451731() {
            AppMethodBeat.m2504i(137211);
            AppMethodBeat.m2505o(137211);
        }
    }

    static {
        AppMethodBeat.m2504i(137218);
        C451731 c451731 = new C451731();
        coi = c451731;
        coj = c451731;
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
            C4990ab.printErrStackTrace("mix.Log", th, "", new Object[0]);
        }
        SYS_INFO = stringBuilder.toString();
        AppMethodBeat.m2505o(137218);
    }

    /* renamed from: e */
    public static void m83208e(String str, String str2, Object... objArr) {
        AppMethodBeat.m2504i(137215);
        C4990ab.m7413e(str, str2, objArr);
        AppMethodBeat.m2505o(137215);
    }

    /* renamed from: i */
    public static void m83210i(String str, String str2, Object... objArr) {
        AppMethodBeat.m2504i(137216);
        C4990ab.m7417i(str, str2, objArr);
        AppMethodBeat.m2505o(137216);
    }

    public static void printErrStackTrace(String str, Throwable th, String str2, Object... objArr) {
        AppMethodBeat.m2504i(137217);
        C4990ab.printErrStackTrace(str, th, str2, objArr);
        AppMethodBeat.m2505o(137217);
    }

    /* renamed from: e */
    public static void m83207e(String str, String str2) {
        AppMethodBeat.m2504i(137212);
        C4990ab.m7413e(str, str2, null);
        AppMethodBeat.m2505o(137212);
    }

    /* renamed from: i */
    public static void m83209i(String str, String str2) {
        AppMethodBeat.m2504i(137213);
        C4990ab.m7417i(str, str2, null);
        AppMethodBeat.m2505o(137213);
    }

    /* renamed from: d */
    public static void m83206d(String str, String str2) {
        AppMethodBeat.m2504i(137214);
        C4990ab.m7411d(str, str2, null);
        AppMethodBeat.m2505o(137214);
    }
}
