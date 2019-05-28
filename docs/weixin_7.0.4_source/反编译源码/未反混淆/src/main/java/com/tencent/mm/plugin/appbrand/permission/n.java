package com.tencent.mm.plugin.appbrand.permission;

import android.support.v4.app.a.a;
import android.text.TextUtils;
import com.tencent.luggage.g.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.r.i;
import java.util.Set;

public final class n {
    private static final i<String, a> ixe = new i();

    static {
        AppMethodBeat.i(91127);
        AppMethodBeat.o(91127);
    }

    public static void a(String str, a aVar) {
        AppMethodBeat.i(91123);
        if (TextUtils.isEmpty(str) || aVar == null) {
            d.e("Luggage.RequestPermissionRegistry", "addCallback fail, invalid arguments");
            AppMethodBeat.o(91123);
            return;
        }
        ixe.f(str, aVar);
        AppMethodBeat.o(91123);
    }

    @Deprecated
    public static void b(String str, a aVar) {
        AppMethodBeat.i(91124);
        a(str, aVar);
        AppMethodBeat.o(91124);
    }

    public static void Dr(String str) {
        AppMethodBeat.i(91125);
        if (TextUtils.isEmpty(str)) {
            d.e("Luggage.RequestPermissionRegistry", "removeCallbacks fail, invalid arguments");
            AppMethodBeat.o(91125);
            return;
        }
        ixe.bD(str);
        AppMethodBeat.o(91125);
    }

    public static void a(String str, int i, String[] strArr, int[] iArr) {
        AppMethodBeat.i(91126);
        if (str == null || str.length() == 0) {
            d.e("Luggage.RequestPermissionRegistry", "removeCallback fail, invalid id");
            AppMethodBeat.o(91126);
            return;
        }
        Set<a> bC = ixe.bC(str);
        if (bC != null) {
            for (a onRequestPermissionsResult : bC) {
                onRequestPermissionsResult.onRequestPermissionsResult(i, strArr, iArr);
            }
        }
        AppMethodBeat.o(91126);
    }
}
