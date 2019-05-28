package com.tencent.soter.core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import junit.framework.Assert;

public final class d {
    private static c Avg = new a();

    static class a implements c {
        private a() {
        }

        /* synthetic */ a(byte b) {
            this();
        }

        public final void v(String str, String str2, Object... objArr) {
            AppMethodBeat.i(73019);
            try {
                String.format(str2, objArr);
                AppMethodBeat.o(73019);
            } catch (Exception e) {
                AppMethodBeat.o(73019);
            }
        }

        public final void d(String str, String str2, Object... objArr) {
            AppMethodBeat.i(73020);
            try {
                String.format(str2, objArr);
                AppMethodBeat.o(73020);
            } catch (Exception e) {
                AppMethodBeat.o(73020);
            }
        }

        public final void i(String str, String str2, Object... objArr) {
            AppMethodBeat.i(73021);
            try {
                String.format(str2, objArr);
                AppMethodBeat.o(73021);
            } catch (Exception e) {
                AppMethodBeat.o(73021);
            }
        }

        public final void w(String str, String str2, Object... objArr) {
            AppMethodBeat.i(73022);
            try {
                String.format(str2, objArr);
                AppMethodBeat.o(73022);
            } catch (Exception e) {
                AppMethodBeat.o(73022);
            }
        }

        public final void e(String str, String str2, Object... objArr) {
            AppMethodBeat.i(73023);
            try {
                String.format(str2, objArr);
                AppMethodBeat.o(73023);
            } catch (Exception e) {
                AppMethodBeat.o(73023);
            }
        }

        public final void a(String str, Throwable th, String str2) {
        }
    }

    static {
        AppMethodBeat.i(73031);
        AppMethodBeat.o(73031);
    }

    public static void a(c cVar) {
        AppMethodBeat.i(73024);
        Assert.assertTrue(cVar != null);
        Avg = cVar;
        AppMethodBeat.o(73024);
    }

    public static void v(String str, String str2, Object... objArr) {
        AppMethodBeat.i(73025);
        Avg.v(str, str2, objArr);
        AppMethodBeat.o(73025);
    }

    public static void d(String str, String str2, Object... objArr) {
        AppMethodBeat.i(73026);
        Avg.d(str, str2, objArr);
        AppMethodBeat.o(73026);
    }

    public static void i(String str, String str2, Object... objArr) {
        AppMethodBeat.i(73027);
        Avg.i(str, str2, objArr);
        AppMethodBeat.o(73027);
    }

    public static void w(String str, String str2, Object... objArr) {
        AppMethodBeat.i(73028);
        Avg.w(str, str2, objArr);
        AppMethodBeat.o(73028);
    }

    public static void e(String str, String str2, Object... objArr) {
        AppMethodBeat.i(73029);
        Avg.e(str, str2, objArr);
        AppMethodBeat.o(73029);
    }

    public static void a(String str, Throwable th, String str2) {
        AppMethodBeat.i(73030);
        Avg.a(str, th, str2);
        AppMethodBeat.o(73030);
    }
}
