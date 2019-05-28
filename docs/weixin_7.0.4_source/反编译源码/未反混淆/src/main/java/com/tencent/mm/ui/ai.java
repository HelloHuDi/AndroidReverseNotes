package com.tencent.mm.ui;

import android.util.Log;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ai {
    private static a yqS;
    private static a yqT;

    public interface a {
        void d(String str, String str2);

        void e(String str, String str2);

        void i(String str, String str2);

        void v(String str, String str2);

        void w(String str, String str2);
    }

    static {
        AppMethodBeat.i(112481);
        AnonymousClass1 anonymousClass1 = new a() {
            public final void v(String str, String str2) {
            }

            public final void d(String str, String str2) {
            }

            public final void i(String str, String str2) {
            }

            public final void w(String str, String str2) {
            }

            public final void e(String str, String str2) {
            }
        };
        yqS = anonymousClass1;
        yqT = anonymousClass1;
        AppMethodBeat.o(112481);
    }

    public static void a(a aVar) {
        yqT = aVar;
    }

    public static void v(String str, String str2, Object... objArr) {
        AppMethodBeat.i(112475);
        if (yqT != null) {
            String format = String.format(str2, objArr);
            if (format == null) {
                format = "";
            }
            yqT.v(str, format);
        }
        AppMethodBeat.o(112475);
    }

    public static void d(String str, String str2, Object... objArr) {
        AppMethodBeat.i(112476);
        if (yqT != null) {
            String format = String.format(str2, objArr);
            if (format == null) {
                format = "";
            }
            yqT.d(str, format);
        }
        AppMethodBeat.o(112476);
    }

    public static void i(String str, String str2, Object... objArr) {
        AppMethodBeat.i(112477);
        if (yqT != null) {
            String format = String.format(str2, objArr);
            if (format == null) {
                format = "";
            }
            yqT.i(str, format);
        }
        AppMethodBeat.o(112477);
    }

    public static void w(String str, String str2, Object... objArr) {
        AppMethodBeat.i(112478);
        if (yqT != null) {
            String format = String.format(str2, objArr);
            if (format == null) {
                format = "";
            }
            yqT.w(str, format);
        }
        AppMethodBeat.o(112478);
    }

    public static void e(String str, String str2, Object... objArr) {
        AppMethodBeat.i(112479);
        if (yqT != null) {
            String format = String.format(str2, objArr);
            if (format == null) {
                format = "";
            }
            yqT.e(str, format);
        }
        AppMethodBeat.o(112479);
    }

    public static void printErrStackTrace(String str, Throwable th, String str2, Object... objArr) {
        AppMethodBeat.i(112480);
        if (yqT != null) {
            String format = String.format(str2, objArr);
            if (format == null) {
                format = "";
            }
            yqT.e(str, format + "  " + Log.getStackTraceString(th));
        }
        AppMethodBeat.o(112480);
    }
}
