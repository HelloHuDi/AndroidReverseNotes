package com.tencent.tencentmap.mapsdk.maps.p667a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Locale;

/* renamed from: com.tencent.tencentmap.mapsdk.maps.a.ag */
public final class C16205ag {
    /* renamed from: a */
    public static boolean f3125a = false;
    /* renamed from: b */
    public static boolean f3126b = false;

    /* renamed from: a */
    public static void m24683a(String str, Object... objArr) {
        AppMethodBeat.m2504i(98416);
        if (!((f3125a ? 1 : null) == null || str == null)) {
            if (objArr == null || objArr.length == 0) {
                AppMethodBeat.m2505o(98416);
                return;
            }
            String.format(Locale.US, str, objArr);
        }
        AppMethodBeat.m2505o(98416);
    }

    /* renamed from: b */
    public static void m24685b(String str, Object... objArr) {
        AppMethodBeat.m2504i(98417);
        if (!((f3125a ? 1 : null) == null || str == null)) {
            if (objArr == null || objArr.length == 0) {
                AppMethodBeat.m2505o(98417);
                return;
            }
            String.format(Locale.US, str, objArr);
        }
        AppMethodBeat.m2505o(98417);
    }

    /* renamed from: c */
    public static void m24686c(String str, Object... objArr) {
        AppMethodBeat.m2504i(98418);
        if (str != null) {
            if (objArr == null || objArr.length == 0) {
                AppMethodBeat.m2505o(98418);
                return;
            }
            String.format(Locale.US, str, objArr);
        }
        AppMethodBeat.m2505o(98418);
    }

    /* renamed from: d */
    public static void m24687d(String str, Object... objArr) {
        AppMethodBeat.m2504i(98419);
        if (str != null) {
            if (objArr == null || objArr.length == 0) {
                AppMethodBeat.m2505o(98419);
                return;
            }
            String.format(Locale.US, str, objArr);
        }
        AppMethodBeat.m2505o(98419);
    }

    /* renamed from: a */
    public static void m24684a(Throwable th) {
        AppMethodBeat.m2504i(98420);
        if (th != null && (th instanceof Throwable)) {
            if ((f3125a ? 1 : 0) != 0) {
                AppMethodBeat.m2505o(98420);
                return;
            }
            C16205ag.m24687d(th.getMessage(), new Object[0]);
        }
        AppMethodBeat.m2505o(98420);
    }

    /* renamed from: a */
    private static void m24682a(String str, String str2, Object... objArr) {
        AppMethodBeat.m2504i(98421);
        if (!((f3125a ? 1 : null) == null || str2 == null)) {
            if (objArr == null || objArr.length == 0) {
                AppMethodBeat.m2505o(98421);
                return;
            }
            String.format(Locale.US, str2, objArr);
        }
        AppMethodBeat.m2505o(98421);
    }

    /* renamed from: e */
    public static void m24688e(String str, Object... objArr) {
        AppMethodBeat.m2504i(98422);
        C16205ag.m24682a("beacon_step_api", str, objArr);
        AppMethodBeat.m2505o(98422);
    }

    /* renamed from: f */
    public static void m24689f(String str, Object... objArr) {
        AppMethodBeat.m2504i(98423);
        C16205ag.m24682a("beacon_step_buffer", str, objArr);
        AppMethodBeat.m2505o(98423);
    }

    /* renamed from: g */
    public static void m24690g(String str, Object... objArr) {
        AppMethodBeat.m2504i(98424);
        C16205ag.m24682a("beacon_step_db", str, objArr);
        AppMethodBeat.m2505o(98424);
    }

    /* renamed from: h */
    public static void m24691h(String str, Object... objArr) {
        AppMethodBeat.m2504i(98425);
        C16205ag.m24682a("beacon_step_upload", str, objArr);
        AppMethodBeat.m2505o(98425);
    }
}
