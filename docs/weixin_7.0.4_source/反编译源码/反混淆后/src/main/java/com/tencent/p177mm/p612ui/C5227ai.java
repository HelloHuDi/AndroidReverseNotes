package com.tencent.p177mm.p612ui;

import android.util.Log;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.ui.ai */
public final class C5227ai {
    private static C5226a yqS;
    private static C5226a yqT;

    /* renamed from: com.tencent.mm.ui.ai$a */
    public interface C5226a {
        /* renamed from: d */
        void mo10732d(String str, String str2);

        /* renamed from: e */
        void mo10733e(String str, String str2);

        /* renamed from: i */
        void mo10734i(String str, String str2);

        /* renamed from: v */
        void mo10735v(String str, String str2);

        /* renamed from: w */
        void mo10736w(String str, String str2);
    }

    /* renamed from: com.tencent.mm.ui.ai$1 */
    static class C52281 implements C5226a {
        C52281() {
        }

        /* renamed from: v */
        public final void mo10735v(String str, String str2) {
        }

        /* renamed from: d */
        public final void mo10732d(String str, String str2) {
        }

        /* renamed from: i */
        public final void mo10734i(String str, String str2) {
        }

        /* renamed from: w */
        public final void mo10736w(String str, String str2) {
        }

        /* renamed from: e */
        public final void mo10733e(String str, String str2) {
        }
    }

    static {
        AppMethodBeat.m2504i(112481);
        C52281 c52281 = new C52281();
        yqS = c52281;
        yqT = c52281;
        AppMethodBeat.m2505o(112481);
    }

    /* renamed from: a */
    public static void m7970a(C5226a c5226a) {
        yqT = c5226a;
    }

    /* renamed from: v */
    public static void m7974v(String str, String str2, Object... objArr) {
        AppMethodBeat.m2504i(112475);
        if (yqT != null) {
            String format = String.format(str2, objArr);
            if (format == null) {
                format = "";
            }
            yqT.mo10735v(str, format);
        }
        AppMethodBeat.m2505o(112475);
    }

    /* renamed from: d */
    public static void m7971d(String str, String str2, Object... objArr) {
        AppMethodBeat.m2504i(112476);
        if (yqT != null) {
            String format = String.format(str2, objArr);
            if (format == null) {
                format = "";
            }
            yqT.mo10732d(str, format);
        }
        AppMethodBeat.m2505o(112476);
    }

    /* renamed from: i */
    public static void m7973i(String str, String str2, Object... objArr) {
        AppMethodBeat.m2504i(112477);
        if (yqT != null) {
            String format = String.format(str2, objArr);
            if (format == null) {
                format = "";
            }
            yqT.mo10734i(str, format);
        }
        AppMethodBeat.m2505o(112477);
    }

    /* renamed from: w */
    public static void m7975w(String str, String str2, Object... objArr) {
        AppMethodBeat.m2504i(112478);
        if (yqT != null) {
            String format = String.format(str2, objArr);
            if (format == null) {
                format = "";
            }
            yqT.mo10736w(str, format);
        }
        AppMethodBeat.m2505o(112478);
    }

    /* renamed from: e */
    public static void m7972e(String str, String str2, Object... objArr) {
        AppMethodBeat.m2504i(112479);
        if (yqT != null) {
            String format = String.format(str2, objArr);
            if (format == null) {
                format = "";
            }
            yqT.mo10733e(str, format);
        }
        AppMethodBeat.m2505o(112479);
    }

    public static void printErrStackTrace(String str, Throwable th, String str2, Object... objArr) {
        AppMethodBeat.m2504i(112480);
        if (yqT != null) {
            String format = String.format(str2, objArr);
            if (format == null) {
                format = "";
            }
            yqT.mo10733e(str, format + "  " + Log.getStackTraceString(th));
        }
        AppMethodBeat.m2505o(112480);
    }
}
