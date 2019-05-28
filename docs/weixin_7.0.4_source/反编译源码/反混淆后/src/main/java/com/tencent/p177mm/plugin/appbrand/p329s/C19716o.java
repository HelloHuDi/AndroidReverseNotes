package com.tencent.p177mm.plugin.appbrand.p329s;

import android.webkit.ValueCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.C38492q;
import com.tencent.p177mm.plugin.appbrand.C6750i;
import com.tencent.p177mm.plugin.appbrand.p297h.C19243l;
import com.tencent.p177mm.plugin.appbrand.p297h.C6747i;
import com.tencent.p177mm.plugin.appbrand.p329s.C42682n.C42683a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.net.MalformedURLException;
import java.net.URL;

/* renamed from: com.tencent.mm.plugin.appbrand.s.o */
public final class C19716o {

    /* renamed from: com.tencent.mm.plugin.appbrand.s.o$a */
    public enum C19718a {
        LIB,
        USR;

        static {
            AppMethodBeat.m2505o(133585);
        }
    }

    /* renamed from: a */
    public static void m30529a(C38492q c38492q, C6747i c6747i, String str, String str2, String str3, String str4, C19718a c19718a, C42683a c42683a) {
        AppMethodBeat.m2504i(133586);
        if (c38492q == null) {
            C4990ab.m7420w("MicroMsg.JsValidationInjectorWC", "hy: service is null! abort");
            AppMethodBeat.m2505o(133586);
            return;
        }
        String a = C19716o.m30526a(c38492q, c19718a);
        String xc = c38492q.mo61201xc(str);
        C42682n.m75590a(c6747i, a + str, str2, str3, str4, xc, c42683a);
        AppMethodBeat.m2505o(133586);
    }

    /* renamed from: a */
    public static void m30528a(C38492q c38492q, C6747i c6747i, String str, String str2, C19718a c19718a, C42683a c42683a) {
        AppMethodBeat.m2504i(133587);
        C19716o.m30529a(c38492q, c6747i, str, "", "", str2, c19718a, c42683a);
        AppMethodBeat.m2505o(133587);
    }

    /* renamed from: a */
    public static void m30527a(C6750i c6750i, C6747i c6747i, String str, String str2, String str3, String str4, C19718a c19718a, C42683a c42683a) {
        AppMethodBeat.m2504i(133588);
        if (c6750i == null || c6750i.mo15032xT() == null) {
            C4990ab.m7416i("MicroMsg.JsValidationInjectorWC", "hy: runtime or service is null!");
            AppMethodBeat.m2505o(133588);
            return;
        }
        String a = C42685u.m75594a(c6750i, str, C19716o.m30526a(c6750i.mo15032xT(), c19718a));
        if (!C5046bo.isNullOrNil(a)) {
            C42682n.m75589a(c6747i, a, null);
        }
        C19716o.m30529a(c6750i.mo15032xT(), c6747i, str, str2, str3, str4, c19718a, c42683a);
        AppMethodBeat.m2505o(133588);
    }

    /* renamed from: a */
    private static String m30526a(C38492q c38492q, C19718a c19718a) {
        AppMethodBeat.m2504i(133589);
        String str = "";
        if (c19718a == C19718a.LIB) {
            str = c38492q.auf();
        } else if (c19718a == C19718a.USR) {
            str = c38492q.aug();
        }
        AppMethodBeat.m2505o(133589);
        return str;
    }

    /* renamed from: b */
    public static void m30530b(C38492q c38492q, C6747i c6747i, String str, String str2, C19718a c19718a, final C42683a c42683a) {
        AppMethodBeat.m2504i(133590);
        if (C5046bo.isNullOrNil(str2)) {
            c42683a.mo5987lo("isNullOrNil script");
            AppMethodBeat.m2505o(133590);
            return;
        }
        C19243l c19243l = (C19243l) c6747i.mo14970af(C19243l.class);
        if (c19243l == null) {
            AppMethodBeat.m2505o(133590);
            return;
        }
        try {
            c19243l.mo30574a(str2 + String.format(";(function(){return %d;})();", new Object[]{Integer.valueOf(11111)}), new URL(C19716o.m30526a(c38492q, c19718a) + str).toString(), new ValueCallback<String>() {
                public final /* synthetic */ void onReceiveValue(Object obj) {
                    AppMethodBeat.m2504i(133582);
                    String str = (String) obj;
                    if (str == null || !str.contains("11111")) {
                        if (c42683a != null) {
                            c42683a.mo5987lo(str);
                            AppMethodBeat.m2505o(133582);
                            return;
                        }
                    } else if (c42683a != null) {
                        c42683a.onSuccess(str);
                    }
                    AppMethodBeat.m2505o(133582);
                }
            });
            AppMethodBeat.m2505o(133590);
        } catch (MalformedURLException e) {
            AppMethodBeat.m2505o(133590);
        }
    }
}
