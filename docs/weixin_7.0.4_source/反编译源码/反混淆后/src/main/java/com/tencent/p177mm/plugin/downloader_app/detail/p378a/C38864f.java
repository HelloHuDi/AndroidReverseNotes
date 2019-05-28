package com.tencent.p177mm.plugin.downloader_app.detail.p378a;

import android.content.Context;
import com.tencent.luggage.p146d.C37393a.C32183a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.downloader_app.p1646c.C45838a;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.webview.luggage.jsapi.C22840bc;
import com.tencent.p177mm.plugin.webview.luggage.jsapi.C22840bc.C22841a;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.downloader_app.detail.a.f */
public class C38864f extends C22840bc {
    public final int biG() {
        return 0;
    }

    public final String name() {
        return "reportDownloaderAppKvState";
    }

    /* renamed from: a */
    public final void mo9617a(Context context, String str, C22841a c22841a) {
    }

    /* renamed from: b */
    public final void mo9618b(C32183a c32183a) {
        AppMethodBeat.m2504i(136078);
        JSONObject jSONObject = c32183a.bPa.bOf;
        if (jSONObject == null) {
            c32183a.mo52824a("invalid_data", null);
            AppMethodBeat.m2505o(136078);
            return;
        }
        int optInt = jSONObject.optInt("logId");
        String optString = jSONObject.optString("values");
        if (optInt <= 0 || C5046bo.isNullOrNil(optString)) {
            c32183a.mo52824a("invalid_data", null);
            AppMethodBeat.m2505o(136078);
            return;
        }
        if (optInt == 16099) {
            optString = C45838a.azq() + "," + optString;
        }
        C7060h.pYm.mo8374X(optInt, optString);
        c32183a.mo52824a("", null);
        AppMethodBeat.m2505o(136078);
    }
}
