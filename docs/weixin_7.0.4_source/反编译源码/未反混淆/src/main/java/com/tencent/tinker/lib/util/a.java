package com.tencent.tinker.lib.util;

import android.util.Log;

public final class a {
    private static a ACj;
    private static a ACk;

    public interface a {
        void e(String str, String str2, Object... objArr);

        void i(String str, String str2, Object... objArr);

        void printErrStackTrace(String str, Throwable th, String str2, Object... objArr);

        void w(String str, String str2, Object... objArr);
    }

    static {
        AnonymousClass1 anonymousClass1 = new a() {
            public final void i(String str, String str2, Object... objArr) {
                if (objArr != null && objArr.length != 0) {
                    String.format(str2, objArr);
                }
            }

            public final void w(String str, String str2, Object... objArr) {
                if (objArr != null && objArr.length != 0) {
                    String.format(str2, objArr);
                }
            }

            public final void e(String str, String str2, Object... objArr) {
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
        };
        ACj = anonymousClass1;
        ACk = anonymousClass1;
    }

    public static void a(a aVar) {
        ACk = aVar;
    }

    public static void e(String str, String str2, Object... objArr) {
        if (ACk != null) {
            ACk.e(str, str2, objArr);
        }
    }

    public static void w(String str, String str2, Object... objArr) {
        if (ACk != null) {
            ACk.w(str, str2, objArr);
        }
    }

    public static void i(String str, String str2, Object... objArr) {
        if (ACk != null) {
            ACk.i(str, str2, objArr);
        }
    }

    public static void printErrStackTrace(String str, Throwable th, String str2, Object... objArr) {
        if (ACk != null) {
            ACk.printErrStackTrace(str, th, str2, objArr);
        }
    }
}
