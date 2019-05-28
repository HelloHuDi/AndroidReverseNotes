package com.tencent.soter.core.p1351c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import junit.framework.Assert;

/* renamed from: com.tencent.soter.core.c.d */
public final class C44476d {
    private static C44475c Avg = new C44477a();

    /* renamed from: com.tencent.soter.core.c.d$a */
    static class C44477a implements C44475c {
        private C44477a() {
        }

        /* synthetic */ C44477a(byte b) {
            this();
        }

        /* renamed from: v */
        public final void mo47433v(String str, String str2, Object... objArr) {
            AppMethodBeat.m2504i(73019);
            try {
                String.format(str2, objArr);
                AppMethodBeat.m2505o(73019);
            } catch (Exception e) {
                AppMethodBeat.m2505o(73019);
            }
        }

        /* renamed from: d */
        public final void mo47430d(String str, String str2, Object... objArr) {
            AppMethodBeat.m2504i(73020);
            try {
                String.format(str2, objArr);
                AppMethodBeat.m2505o(73020);
            } catch (Exception e) {
                AppMethodBeat.m2505o(73020);
            }
        }

        /* renamed from: i */
        public final void mo47432i(String str, String str2, Object... objArr) {
            AppMethodBeat.m2504i(73021);
            try {
                String.format(str2, objArr);
                AppMethodBeat.m2505o(73021);
            } catch (Exception e) {
                AppMethodBeat.m2505o(73021);
            }
        }

        /* renamed from: w */
        public final void mo47434w(String str, String str2, Object... objArr) {
            AppMethodBeat.m2504i(73022);
            try {
                String.format(str2, objArr);
                AppMethodBeat.m2505o(73022);
            } catch (Exception e) {
                AppMethodBeat.m2505o(73022);
            }
        }

        /* renamed from: e */
        public final void mo47431e(String str, String str2, Object... objArr) {
            AppMethodBeat.m2504i(73023);
            try {
                String.format(str2, objArr);
                AppMethodBeat.m2505o(73023);
            } catch (Exception e) {
                AppMethodBeat.m2505o(73023);
            }
        }

        /* renamed from: a */
        public final void mo47429a(String str, Throwable th, String str2) {
        }
    }

    static {
        AppMethodBeat.m2504i(73031);
        AppMethodBeat.m2505o(73031);
    }

    /* renamed from: a */
    public static void m80480a(C44475c c44475c) {
        AppMethodBeat.m2504i(73024);
        Assert.assertTrue(c44475c != null);
        Avg = c44475c;
        AppMethodBeat.m2505o(73024);
    }

    /* renamed from: v */
    public static void m80485v(String str, String str2, Object... objArr) {
        AppMethodBeat.m2504i(73025);
        Avg.mo47433v(str, str2, objArr);
        AppMethodBeat.m2505o(73025);
    }

    /* renamed from: d */
    public static void m80482d(String str, String str2, Object... objArr) {
        AppMethodBeat.m2504i(73026);
        Avg.mo47430d(str, str2, objArr);
        AppMethodBeat.m2505o(73026);
    }

    /* renamed from: i */
    public static void m80484i(String str, String str2, Object... objArr) {
        AppMethodBeat.m2504i(73027);
        Avg.mo47432i(str, str2, objArr);
        AppMethodBeat.m2505o(73027);
    }

    /* renamed from: w */
    public static void m80486w(String str, String str2, Object... objArr) {
        AppMethodBeat.m2504i(73028);
        Avg.mo47434w(str, str2, objArr);
        AppMethodBeat.m2505o(73028);
    }

    /* renamed from: e */
    public static void m80483e(String str, String str2, Object... objArr) {
        AppMethodBeat.m2504i(73029);
        Avg.mo47431e(str, str2, objArr);
        AppMethodBeat.m2505o(73029);
    }

    /* renamed from: a */
    public static void m80481a(String str, Throwable th, String str2) {
        AppMethodBeat.m2504i(73030);
        Avg.mo47429a(str, th, str2);
        AppMethodBeat.m2505o(73030);
    }
}
