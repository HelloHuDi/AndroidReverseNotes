package com.tencent.p136e.p137a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.baseutils.IOUtils;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.StringTokenizer;

/* renamed from: com.tencent.e.a.b */
public final class C0926b {
    private static volatile C0925a Axj;

    /* renamed from: com.tencent.e.a.b$a */
    public interface C0925a {
        boolean isLoggable(String str, int i);

        void println(int i, String str, String str2);
    }

    /* renamed from: com.tencent.e.a.b$1 */
    static class C09271 implements C0925a {
        C09271() {
        }

        public final void println(int i, String str, String str2) {
            AppMethodBeat.m2504i(63720);
            System.out.println("[" + str + "] " + str2);
            AppMethodBeat.m2505o(63720);
        }

        public final boolean isLoggable(String str, int i) {
            return true;
        }
    }

    /* renamed from: a */
    public static void m2095a(C0925a c0925a) {
        Axj = c0925a;
    }

    private static void println(int i, String str, String str2) {
        AppMethodBeat.m2504i(63705);
        C0925a c0925a = Axj;
        if (c0925a == null) {
            AppMethodBeat.m2505o(63705);
            return;
        }
        c0925a.println(i, str, str2);
        AppMethodBeat.m2505o(63705);
    }

    /* renamed from: b */
    private static void m2097b(int i, String str, Throwable th) {
        AppMethodBeat.m2504i(63706);
        C0925a c0925a = Axj;
        if (c0925a == null || !c0925a.isLoggable(str, i)) {
            AppMethodBeat.m2505o(63706);
            return;
        }
        StringWriter stringWriter = new StringWriter(512);
        th.printStackTrace(new PrintWriter(stringWriter));
        StringTokenizer stringTokenizer = new StringTokenizer(stringWriter.toString(), IOUtils.LINE_SEPARATOR_UNIX);
        while (stringTokenizer.hasMoreTokens()) {
            c0925a.println(i, str, stringTokenizer.nextToken());
        }
        AppMethodBeat.m2505o(63706);
    }

    /* renamed from: b */
    private static void m2096b(int i, String str, String str2, Object... objArr) {
        AppMethodBeat.m2504i(63707);
        C0925a c0925a = Axj;
        if (c0925a == null || !c0925a.isLoggable(str, i)) {
            AppMethodBeat.m2505o(63707);
            return;
        }
        c0925a.println(i, str, String.format(str2, objArr));
        AppMethodBeat.m2505o(63707);
    }

    /* renamed from: e */
    public static void m2103e(String str, String str2) {
        AppMethodBeat.m2504i(63708);
        C0926b.println(6, str, str2);
        AppMethodBeat.m2505o(63708);
    }

    /* renamed from: b */
    public static void m2098b(String str, Throwable th, String str2) {
        AppMethodBeat.m2504i(63709);
        if (!str2.isEmpty()) {
            C0926b.println(6, str, str2);
        }
        C0926b.m2097b(6, str, th);
        AppMethodBeat.m2505o(63709);
    }

    /* renamed from: e */
    public static void m2104e(String str, String str2, Object... objArr) {
        AppMethodBeat.m2504i(63710);
        C0926b.m2096b(6, str, str2, objArr);
        AppMethodBeat.m2505o(63710);
    }

    /* renamed from: b */
    public static void m2099b(String str, Throwable th, String str2, Object... objArr) {
        AppMethodBeat.m2504i(63711);
        C0926b.m2096b(6, str, str2, objArr);
        C0926b.m2097b(6, str, th);
        AppMethodBeat.m2505o(63711);
    }

    /* renamed from: w */
    public static void m2107w(String str, String str2) {
        AppMethodBeat.m2504i(63712);
        C0926b.println(5, str, str2);
        AppMethodBeat.m2505o(63712);
    }

    /* renamed from: c */
    public static void m2100c(String str, Throwable th, String str2) {
        AppMethodBeat.m2504i(63713);
        if (!str2.isEmpty()) {
            C0926b.println(5, str, str2);
        }
        C0926b.m2097b(5, str, th);
        AppMethodBeat.m2505o(63713);
    }

    /* renamed from: w */
    public static void m2108w(String str, String str2, Object... objArr) {
        AppMethodBeat.m2504i(63714);
        C0926b.m2096b(5, str, str2, objArr);
        AppMethodBeat.m2505o(63714);
    }

    /* renamed from: i */
    public static void m2105i(String str, String str2) {
        AppMethodBeat.m2504i(63715);
        C0926b.println(4, str, str2);
        AppMethodBeat.m2505o(63715);
    }

    /* renamed from: i */
    public static void m2106i(String str, String str2, Object... objArr) {
        AppMethodBeat.m2504i(63716);
        C0926b.m2096b(4, str, str2, objArr);
        AppMethodBeat.m2505o(63716);
    }

    /* renamed from: d */
    public static void m2101d(String str, String str2) {
        AppMethodBeat.m2504i(63717);
        C0926b.println(3, str, str2);
        AppMethodBeat.m2505o(63717);
    }

    /* renamed from: d */
    public static void m2102d(String str, String str2, Object... objArr) {
        AppMethodBeat.m2504i(63718);
        C0926b.m2096b(3, str, str2, objArr);
        AppMethodBeat.m2505o(63718);
    }

    static {
        C0925a c6267a;
        AppMethodBeat.m2504i(63719);
        try {
            Class.forName("android.util.Log");
            c6267a = new C6267a();
        } catch (ClassNotFoundException e) {
            c6267a = new C09271();
        }
        Axj = c6267a;
        AppMethodBeat.m2505o(63719);
    }
}
