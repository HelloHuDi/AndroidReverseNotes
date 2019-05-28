package com.tencent.p177mm.plugin.appbrand.appcache;

import com.tencent.luggage.p147g.C32192i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.InputStream;

/* renamed from: com.tencent.mm.plugin.appbrand.appcache.i */
public final class C10095i {
    private static final C19062o gSt = new C33093c();

    static {
        AppMethodBeat.m2504i(101714);
        AppMethodBeat.m2505o(101714);
    }

    /* renamed from: xn */
    public static String m17688xn(String str) {
        AppMethodBeat.m2504i(101713);
        InputStream openRead = gSt.openRead(str);
        String str2;
        if (openRead == null) {
            str2 = "";
            AppMethodBeat.m2505o(101713);
            return str2;
        }
        str2 = C32192i.convertStreamToString(openRead);
        AppMethodBeat.m2505o(101713);
        return str2;
    }
}
