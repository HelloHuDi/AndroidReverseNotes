package com.tencent.p177mm.plugin.appbrand.luggage.p1227a;

import android.graphics.Bitmap;
import android.graphics.Rect;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.canvas.C2102d;
import com.tencent.p177mm.plugin.appbrand.canvas.C2103e;
import com.tencent.p177mm.plugin.appbrand.canvas.C2103e.C2104a;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2241c;
import com.tencent.p177mm.plugin.appbrand.p1219d.C19162a;
import com.tencent.p177mm.plugin.appbrand.p1219d.C19162a.C19164c;
import com.tencent.p177mm.plugin.appbrand.p1219d.C33139b;

/* renamed from: com.tencent.mm.plugin.appbrand.luggage.a.c */
public final class C19585c implements C2103e {
    /* renamed from: a */
    public final Bitmap mo5910a(C2102d c2102d, String str) {
        AppMethodBeat.m2504i(132092);
        Bitmap a = mo5912a(c2102d, str, null);
        AppMethodBeat.m2505o(132092);
        return a;
    }

    /* renamed from: a */
    public final Bitmap mo5912a(C2102d c2102d, String str, C2104a c2104a) {
        AppMethodBeat.m2504i(132093);
        Bitmap a = mo5911a(c2102d, str, null, c2104a);
        AppMethodBeat.m2505o(132093);
        return a;
    }

    /* renamed from: a */
    public final Bitmap mo5911a(final C2102d c2102d, final String str, Rect rect, final C2104a c2104a) {
        AppMethodBeat.m2504i(132094);
        C2241c c2241c = c2102d.hcM;
        Bitmap a = ((C19162a) c2241c.mo5936B(C19162a.class)).mo34401a(((C33139b) c2241c.mo5936B(C33139b.class)).mo22120b(c2241c, str), rect, new C19164c() {
            /* renamed from: E */
            public final void mo34405E(Bitmap bitmap) {
                AppMethodBeat.m2504i(132091);
                if (c2104a == null || bitmap == null || bitmap.isRecycled()) {
                    AppMethodBeat.m2505o(132091);
                    return;
                }
                c2104a.mo5913a(c2102d);
                AppMethodBeat.m2505o(132091);
            }
        });
        AppMethodBeat.m2505o(132094);
        return a;
    }
}
