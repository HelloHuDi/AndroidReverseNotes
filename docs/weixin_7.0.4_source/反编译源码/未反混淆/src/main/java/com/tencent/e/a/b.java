package com.tencent.e.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.baseutils.IOUtils;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.StringTokenizer;

public final class b {
    private static volatile a Axj;

    public interface a {
        boolean isLoggable(String str, int i);

        void println(int i, String str, String str2);
    }

    public static void a(a aVar) {
        Axj = aVar;
    }

    private static void println(int i, String str, String str2) {
        AppMethodBeat.i(63705);
        a aVar = Axj;
        if (aVar == null) {
            AppMethodBeat.o(63705);
            return;
        }
        aVar.println(i, str, str2);
        AppMethodBeat.o(63705);
    }

    private static void b(int i, String str, Throwable th) {
        AppMethodBeat.i(63706);
        a aVar = Axj;
        if (aVar == null || !aVar.isLoggable(str, i)) {
            AppMethodBeat.o(63706);
            return;
        }
        StringWriter stringWriter = new StringWriter(512);
        th.printStackTrace(new PrintWriter(stringWriter));
        StringTokenizer stringTokenizer = new StringTokenizer(stringWriter.toString(), IOUtils.LINE_SEPARATOR_UNIX);
        while (stringTokenizer.hasMoreTokens()) {
            aVar.println(i, str, stringTokenizer.nextToken());
        }
        AppMethodBeat.o(63706);
    }

    private static void b(int i, String str, String str2, Object... objArr) {
        AppMethodBeat.i(63707);
        a aVar = Axj;
        if (aVar == null || !aVar.isLoggable(str, i)) {
            AppMethodBeat.o(63707);
            return;
        }
        aVar.println(i, str, String.format(str2, objArr));
        AppMethodBeat.o(63707);
    }

    public static void e(String str, String str2) {
        AppMethodBeat.i(63708);
        println(6, str, str2);
        AppMethodBeat.o(63708);
    }

    public static void b(String str, Throwable th, String str2) {
        AppMethodBeat.i(63709);
        if (!str2.isEmpty()) {
            println(6, str, str2);
        }
        b(6, str, th);
        AppMethodBeat.o(63709);
    }

    public static void e(String str, String str2, Object... objArr) {
        AppMethodBeat.i(63710);
        b(6, str, str2, objArr);
        AppMethodBeat.o(63710);
    }

    public static void b(String str, Throwable th, String str2, Object... objArr) {
        AppMethodBeat.i(63711);
        b(6, str, str2, objArr);
        b(6, str, th);
        AppMethodBeat.o(63711);
    }

    public static void w(String str, String str2) {
        AppMethodBeat.i(63712);
        println(5, str, str2);
        AppMethodBeat.o(63712);
    }

    public static void c(String str, Throwable th, String str2) {
        AppMethodBeat.i(63713);
        if (!str2.isEmpty()) {
            println(5, str, str2);
        }
        b(5, str, th);
        AppMethodBeat.o(63713);
    }

    public static void w(String str, String str2, Object... objArr) {
        AppMethodBeat.i(63714);
        b(5, str, str2, objArr);
        AppMethodBeat.o(63714);
    }

    public static void i(String str, String str2) {
        AppMethodBeat.i(63715);
        println(4, str, str2);
        AppMethodBeat.o(63715);
    }

    public static void i(String str, String str2, Object... objArr) {
        AppMethodBeat.i(63716);
        b(4, str, str2, objArr);
        AppMethodBeat.o(63716);
    }

    public static void d(String str, String str2) {
        AppMethodBeat.i(63717);
        println(3, str, str2);
        AppMethodBeat.o(63717);
    }

    public static void d(String str, String str2, Object... objArr) {
        AppMethodBeat.i(63718);
        b(3, str, str2, objArr);
        AppMethodBeat.o(63718);
    }

    static {
        a aVar;
        AppMethodBeat.i(63719);
        try {
            Class.forName("android.util.Log");
            aVar = new a();
        } catch (ClassNotFoundException e) {
            aVar = new a() {
                public final void println(int i, String str, String str2) {
                    AppMethodBeat.i(63720);
                    System.out.println("[" + str + "] " + str2);
                    AppMethodBeat.o(63720);
                }

                public final boolean isLoggable(String str, int i) {
                    return true;
                }
            };
        }
        Axj = aVar;
        AppMethodBeat.o(63719);
    }
}
