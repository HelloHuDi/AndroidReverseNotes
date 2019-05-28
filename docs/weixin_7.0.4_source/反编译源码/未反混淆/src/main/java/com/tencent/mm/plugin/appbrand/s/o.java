package com.tencent.mm.plugin.appbrand.s;

import android.webkit.ValueCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.h.i;
import com.tencent.mm.plugin.appbrand.h.l;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.net.MalformedURLException;
import java.net.URL;

public final class o {

    public enum a {
        LIB,
        USR;

        static {
            AppMethodBeat.o(133585);
        }
    }

    public static void a(q qVar, i iVar, String str, String str2, String str3, String str4, a aVar, com.tencent.mm.plugin.appbrand.s.n.a aVar2) {
        AppMethodBeat.i(133586);
        if (qVar == null) {
            ab.w("MicroMsg.JsValidationInjectorWC", "hy: service is null! abort");
            AppMethodBeat.o(133586);
            return;
        }
        String a = a(qVar, aVar);
        String xc = qVar.xc(str);
        n.a(iVar, a + str, str2, str3, str4, xc, aVar2);
        AppMethodBeat.o(133586);
    }

    public static void a(q qVar, i iVar, String str, String str2, a aVar, com.tencent.mm.plugin.appbrand.s.n.a aVar2) {
        AppMethodBeat.i(133587);
        a(qVar, iVar, str, "", "", str2, aVar, aVar2);
        AppMethodBeat.o(133587);
    }

    public static void a(com.tencent.mm.plugin.appbrand.i iVar, i iVar2, String str, String str2, String str3, String str4, a aVar, com.tencent.mm.plugin.appbrand.s.n.a aVar2) {
        AppMethodBeat.i(133588);
        if (iVar == null || iVar.xT() == null) {
            ab.i("MicroMsg.JsValidationInjectorWC", "hy: runtime or service is null!");
            AppMethodBeat.o(133588);
            return;
        }
        String a = u.a(iVar, str, a(iVar.xT(), aVar));
        if (!bo.isNullOrNil(a)) {
            n.a(iVar2, a, null);
        }
        a(iVar.xT(), iVar2, str, str2, str3, str4, aVar, aVar2);
        AppMethodBeat.o(133588);
    }

    private static String a(q qVar, a aVar) {
        AppMethodBeat.i(133589);
        String str = "";
        if (aVar == a.LIB) {
            str = qVar.auf();
        } else if (aVar == a.USR) {
            str = qVar.aug();
        }
        AppMethodBeat.o(133589);
        return str;
    }

    public static void b(q qVar, i iVar, String str, String str2, a aVar, final com.tencent.mm.plugin.appbrand.s.n.a aVar2) {
        AppMethodBeat.i(133590);
        if (bo.isNullOrNil(str2)) {
            aVar2.lo("isNullOrNil script");
            AppMethodBeat.o(133590);
            return;
        }
        l lVar = (l) iVar.af(l.class);
        if (lVar == null) {
            AppMethodBeat.o(133590);
            return;
        }
        try {
            lVar.a(str2 + String.format(";(function(){return %d;})();", new Object[]{Integer.valueOf(11111)}), new URL(a(qVar, aVar) + str).toString(), new ValueCallback<String>() {
                public final /* synthetic */ void onReceiveValue(Object obj) {
                    AppMethodBeat.i(133582);
                    String str = (String) obj;
                    if (str == null || !str.contains("11111")) {
                        if (aVar2 != null) {
                            aVar2.lo(str);
                            AppMethodBeat.o(133582);
                            return;
                        }
                    } else if (aVar2 != null) {
                        aVar2.onSuccess(str);
                    }
                    AppMethodBeat.o(133582);
                }
            });
            AppMethodBeat.o(133590);
        } catch (MalformedURLException e) {
            AppMethodBeat.o(133590);
        }
    }
}
