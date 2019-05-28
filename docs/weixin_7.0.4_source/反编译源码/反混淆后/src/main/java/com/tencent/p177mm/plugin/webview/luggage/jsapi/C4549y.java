package com.tencent.p177mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import com.tencent.luggage.p146d.C37393a.C32183a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.webview.luggage.jsapi.C22840bc.C22841a;

/* renamed from: com.tencent.mm.plugin.webview.luggage.jsapi.y */
public class C4549y extends C22840bc {
    public final int biG() {
        return 0;
    }

    /* renamed from: a */
    public final void mo9617a(Context context, String str, C22841a c22841a) {
    }

    public final String name() {
        return "kvReport";
    }

    /* renamed from: b */
    public final void mo9618b(C32183a c32183a) {
        boolean z;
        boolean z2 = true;
        AppMethodBeat.m2504i(6322);
        int optInt = c32183a.bPa.bOf.optInt("id");
        if (optInt <= 0) {
            c32183a.mo52824a("fail", null);
        }
        String optString = c32183a.bPa.bOf.optString("value");
        if (c32183a.bPa.bOf.optInt("is_important") > 0) {
            z = true;
        } else {
            z = false;
        }
        if (c32183a.bPa.bOf.optInt("is_report_now") <= 0) {
            z2 = false;
        }
        C7060h.pYm.mo8376a(optInt, optString, z2, z);
        c32183a.mo52824a("", null);
        AppMethodBeat.m2505o(6322);
    }
}
