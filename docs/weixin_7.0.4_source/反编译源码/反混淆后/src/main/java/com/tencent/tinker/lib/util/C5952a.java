package com.tencent.tinker.lib.util;

import android.util.Log;

/* renamed from: com.tencent.tinker.lib.util.a */
public final class C5952a {
    private static C5951a ACj;
    private static C5951a ACk;

    /* renamed from: com.tencent.tinker.lib.util.a$a */
    public interface C5951a {
        /* renamed from: e */
        void mo12651e(String str, String str2, Object... objArr);

        /* renamed from: i */
        void mo12652i(String str, String str2, Object... objArr);

        void printErrStackTrace(String str, Throwable th, String str2, Object... objArr);

        /* renamed from: w */
        void mo12654w(String str, String str2, Object... objArr);
    }

    /* renamed from: com.tencent.tinker.lib.util.a$1 */
    static class C59531 implements C5951a {
        C59531() {
        }

        /* renamed from: i */
        public final void mo12652i(String str, String str2, Object... objArr) {
            if (objArr != null && objArr.length != 0) {
                String.format(str2, objArr);
            }
        }

        /* renamed from: w */
        public final void mo12654w(String str, String str2, Object... objArr) {
            if (objArr != null && objArr.length != 0) {
                String.format(str2, objArr);
            }
        }

        /* renamed from: e */
        public final void mo12651e(String str, String str2, Object... objArr) {
            if (objArr != null && objArr.length != 0) {
                String.format(str2, objArr);
            }
        }

        public final void printErrStackTrace(String str, Throwable th, String str2, Object... objArr) {
            String format = (objArr == null || objArr.length == 0) ? str2 : String.format(str2, objArr);
            if (format == null) {
                format = "";
            }
            new StringBuilder().append(format).append("  ").append(Log.getStackTraceString(th));
        }
    }

    static {
        C59531 c59531 = new C59531();
        ACj = c59531;
        ACk = c59531;
    }

    /* renamed from: a */
    public static void m9282a(C5951a c5951a) {
        ACk = c5951a;
    }

    /* renamed from: e */
    public static void m9283e(String str, String str2, Object... objArr) {
        if (ACk != null) {
            ACk.mo12651e(str, str2, objArr);
        }
    }

    /* renamed from: w */
    public static void m9285w(String str, String str2, Object... objArr) {
        if (ACk != null) {
            ACk.mo12654w(str, str2, objArr);
        }
    }

    /* renamed from: i */
    public static void m9284i(String str, String str2, Object... objArr) {
        if (ACk != null) {
            ACk.mo12652i(str, str2, objArr);
        }
    }

    public static void printErrStackTrace(String str, Throwable th, String str2, Object... objArr) {
        if (ACk != null) {
            ACk.printErrStackTrace(str, th, str2, objArr);
        }
    }
}
