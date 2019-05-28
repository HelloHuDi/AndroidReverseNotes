package com.tencent.mm.app;

import android.app.Application;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kiss.a.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.svg.a.e;
import com.tencent.mm.svg.b.c.a;

public final class q {
    private static Class<?> cff = null;
    private static Application cfh;
    private static Resources cfi;
    private static String mPackageName = null;

    public static void G(Class<?> cls) {
        cff = cls;
    }

    public static void cY(String str) {
        mPackageName = str;
    }

    public static void Bz() {
        boolean z = true;
        AppMethodBeat.i(15396);
        ab.i("MicroMsg.SVGInit", "SVG initSVGPreload");
        e.a(new a() {
            public final void i(String str, String str2, Object... objArr) {
                AppMethodBeat.i(15392);
                ab.i(str, str2, objArr);
                AppMethodBeat.o(15392);
            }

            public final void e(String str, String str2, Object... objArr) {
                AppMethodBeat.i(15393);
                ab.e(str, str2, objArr);
                AppMethodBeat.o(15393);
            }

            public final void d(String str, String str2, Object... objArr) {
                AppMethodBeat.i(15394);
                ab.d(str, str2, objArr);
                AppMethodBeat.o(15394);
            }

            public final void printErrStackTrace(String str, Throwable th, String str2, Object... objArr) {
                AppMethodBeat.i(15395);
                ab.printErrStackTrace(str, th, str2, objArr);
                AppMethodBeat.o(15395);
            }
        });
        e.G(cff);
        e.a(cfh, cfi, mPackageName);
        try {
            boolean z2;
            if (cfh.getBaseContext().getResources().getDrawable(R.raw.actionbar_icon) != null) {
                z2 = true;
            } else {
                z2 = false;
            }
            b SM = b.SM();
            if (z2) {
                z = false;
            }
            SM.eMQ = z;
            AppMethodBeat.o(15396);
        } catch (Throwable th) {
            ab.printErrStackTrace("MicroMsg.SVGInit", th, "not support get svg from application context", new Object[0]);
        } finally {
            b.SM().eMQ = true;
            AppMethodBeat.o(15396);
        }
    }

    public static void a(Application application, Resources resources) {
        AppMethodBeat.i(15397);
        e.d(application, mPackageName);
        cfh = application;
        cfi = resources;
        AppMethodBeat.o(15397);
    }
}
