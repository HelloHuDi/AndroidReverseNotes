package com.tencent.matrix.p157d;

import android.util.Log;

/* renamed from: com.tencent.matrix.d.c */
public final class C1070c {
    private static C1069a caR;
    private static C1069a caS;

    /* renamed from: com.tencent.matrix.d.c$a */
    public interface C1069a {
        /* renamed from: d */
        void mo4204d(String str, String str2, Object... objArr);

        /* renamed from: e */
        void mo4205e(String str, String str2, Object... objArr);

        /* renamed from: i */
        void mo4206i(String str, String str2, Object... objArr);

        void printErrStackTrace(String str, Throwable th, String str2, Object... objArr);

        /* renamed from: v */
        void mo4208v(String str, String str2, Object... objArr);

        /* renamed from: w */
        void mo4209w(String str, String str2, Object... objArr);
    }

    /* renamed from: com.tencent.matrix.d.c$1 */
    static class C10711 implements C1069a {
        C10711() {
        }

        /* renamed from: v */
        public final void mo4208v(String str, String str2, Object... objArr) {
            if (objArr != null && objArr.length != 0) {
                String.format(str2, objArr);
            }
        }

        /* renamed from: i */
        public final void mo4206i(String str, String str2, Object... objArr) {
            if (objArr != null && objArr.length != 0) {
                String.format(str2, objArr);
            }
        }

        /* renamed from: d */
        public final void mo4204d(String str, String str2, Object... objArr) {
            if (objArr != null && objArr.length != 0) {
                String.format(str2, objArr);
            }
        }

        /* renamed from: w */
        public final void mo4209w(String str, String str2, Object... objArr) {
            if (objArr != null && objArr.length != 0) {
                String.format(str2, objArr);
            }
        }

        /* renamed from: e */
        public final void mo4205e(String str, String str2, Object... objArr) {
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
        C10711 c10711 = new C10711();
        caR = c10711;
        caS = c10711;
    }

    /* renamed from: b */
    public static void m2365b(C1069a c1069a) {
        caS = c1069a;
    }

    /* renamed from: v */
    public static void m2369v(String str, String str2, Object... objArr) {
        if (caS != null) {
            caS.mo4208v(str, str2, objArr);
        }
    }

    /* renamed from: e */
    public static void m2367e(String str, String str2, Object... objArr) {
        if (caS != null) {
            caS.mo4205e(str, str2, objArr);
        }
    }

    /* renamed from: w */
    public static void m2370w(String str, String str2, Object... objArr) {
        if (caS != null) {
            caS.mo4209w(str, str2, objArr);
        }
    }

    /* renamed from: i */
    public static void m2368i(String str, String str2, Object... objArr) {
        if (caS != null) {
            caS.mo4206i(str, str2, objArr);
        }
    }

    /* renamed from: d */
    public static void m2366d(String str, String str2, Object... objArr) {
        if (caS != null) {
            caS.mo4204d(str, str2, objArr);
        }
    }

    public static void printErrStackTrace(String str, Throwable th, String str2, Object... objArr) {
        if (caS != null) {
            caS.printErrStackTrace(str, th, str2, objArr);
        }
    }
}
