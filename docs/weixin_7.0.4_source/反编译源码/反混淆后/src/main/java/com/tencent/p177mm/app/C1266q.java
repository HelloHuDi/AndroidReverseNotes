package com.tencent.p177mm.app;

import android.app.Application;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.kiss.p243a.C1742b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.svg.p610a.C5154e;
import com.tencent.p177mm.svg.p611b.C5159c.C5158a;

/* renamed from: com.tencent.mm.app.q */
public final class C1266q {
    private static Class<?> cff = null;
    private static Application cfh;
    private static Resources cfi;
    private static String mPackageName = null;

    /* renamed from: com.tencent.mm.app.q$1 */
    static class C12671 implements C5158a {
        C12671() {
        }

        /* renamed from: i */
        public final void mo4557i(String str, String str2, Object... objArr) {
            AppMethodBeat.m2504i(15392);
            C4990ab.m7417i(str, str2, objArr);
            AppMethodBeat.m2505o(15392);
        }

        /* renamed from: e */
        public final void mo4556e(String str, String str2, Object... objArr) {
            AppMethodBeat.m2504i(15393);
            C4990ab.m7413e(str, str2, objArr);
            AppMethodBeat.m2505o(15393);
        }

        /* renamed from: d */
        public final void mo4555d(String str, String str2, Object... objArr) {
            AppMethodBeat.m2504i(15394);
            C4990ab.m7411d(str, str2, objArr);
            AppMethodBeat.m2505o(15394);
        }

        public final void printErrStackTrace(String str, Throwable th, String str2, Object... objArr) {
            AppMethodBeat.m2504i(15395);
            C4990ab.printErrStackTrace(str, th, str2, objArr);
            AppMethodBeat.m2505o(15395);
        }
    }

    /* renamed from: G */
    public static void m2720G(Class<?> cls) {
        cff = cls;
    }

    /* renamed from: cY */
    public static void m2722cY(String str) {
        mPackageName = str;
    }

    /* renamed from: Bz */
    public static void m2719Bz() {
        boolean z = true;
        AppMethodBeat.m2504i(15396);
        C4990ab.m7416i("MicroMsg.SVGInit", "SVG initSVGPreload");
        C5154e.m7848a(new C12671());
        C5154e.m7843G(cff);
        C5154e.m7845a(cfh, cfi, mPackageName);
        try {
            boolean z2;
            if (cfh.getBaseContext().getResources().getDrawable(C1318a.actionbar_icon) != null) {
                z2 = true;
            } else {
                z2 = false;
            }
            C1742b SM = C1742b.m3596SM();
            if (z2) {
                z = false;
            }
            SM.eMQ = z;
            AppMethodBeat.m2505o(15396);
        } catch (Throwable th) {
            C4990ab.printErrStackTrace("MicroMsg.SVGInit", th, "not support get svg from application context", new Object[0]);
        } finally {
            C1742b.m3596SM().eMQ = true;
            AppMethodBeat.m2505o(15396);
        }
    }

    /* renamed from: a */
    public static void m2721a(Application application, Resources resources) {
        AppMethodBeat.m2504i(15397);
        C5154e.m7853d(application, mPackageName);
        cfh = application;
        cfi = resources;
        AppMethodBeat.m2505o(15397);
    }
}
