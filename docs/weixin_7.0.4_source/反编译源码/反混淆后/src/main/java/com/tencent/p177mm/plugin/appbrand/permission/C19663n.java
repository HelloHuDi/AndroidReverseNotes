package com.tencent.p177mm.plugin.appbrand.permission;

import android.support.p057v4.app.C6184a.C0315a;
import android.text.TextUtils;
import com.tencent.luggage.p147g.C45124d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.p328r.C27277i;
import java.util.Set;

/* renamed from: com.tencent.mm.plugin.appbrand.permission.n */
public final class C19663n {
    private static final C27277i<String, C0315a> ixe = new C27277i();

    static {
        AppMethodBeat.m2504i(91127);
        AppMethodBeat.m2505o(91127);
    }

    /* renamed from: a */
    public static void m30462a(String str, C0315a c0315a) {
        AppMethodBeat.m2504i(91123);
        if (TextUtils.isEmpty(str) || c0315a == null) {
            C45124d.m82927e("Luggage.RequestPermissionRegistry", "addCallback fail, invalid arguments");
            AppMethodBeat.m2505o(91123);
            return;
        }
        ixe.mo44963f(str, c0315a);
        AppMethodBeat.m2505o(91123);
    }

    @Deprecated
    /* renamed from: b */
    public static void m30463b(String str, C0315a c0315a) {
        AppMethodBeat.m2504i(91124);
        C19663n.m30462a(str, c0315a);
        AppMethodBeat.m2505o(91124);
    }

    /* renamed from: Dr */
    public static void m30460Dr(String str) {
        AppMethodBeat.m2504i(91125);
        if (TextUtils.isEmpty(str)) {
            C45124d.m82927e("Luggage.RequestPermissionRegistry", "removeCallbacks fail, invalid arguments");
            AppMethodBeat.m2505o(91125);
            return;
        }
        ixe.mo44962bD(str);
        AppMethodBeat.m2505o(91125);
    }

    /* renamed from: a */
    public static void m30461a(String str, int i, String[] strArr, int[] iArr) {
        AppMethodBeat.m2504i(91126);
        if (str == null || str.length() == 0) {
            C45124d.m82927e("Luggage.RequestPermissionRegistry", "removeCallback fail, invalid id");
            AppMethodBeat.m2505o(91126);
            return;
        }
        Set<C0315a> bC = ixe.mo44961bC(str);
        if (bC != null) {
            for (C0315a onRequestPermissionsResult : bC) {
                onRequestPermissionsResult.onRequestPermissionsResult(i, strArr, iArr);
            }
        }
        AppMethodBeat.m2505o(91126);
    }
}
