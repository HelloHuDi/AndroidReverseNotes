package com.tencent.p177mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import com.tencent.luggage.p146d.C37393a.C32183a;
import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.webview.luggage.jsapi.C22840bc.C22841a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.webview.luggage.jsapi.an */
public class C24927an extends C22840bc {
    public final String name() {
        return "reportIDKey";
    }

    public final int biG() {
        return 0;
    }

    /* renamed from: a */
    public final void mo9617a(Context context, String str, C22841a c22841a) {
    }

    /* renamed from: b */
    public final void mo9618b(C32183a c32183a) {
        AppMethodBeat.m2504i(6360);
        JSONArray optJSONArray = c32183a.bPa.bOf.optJSONArray("idKeyDataInfo");
        if (optJSONArray == null || optJSONArray.length() == 0) {
            C4990ab.m7412e("MicroMsg.JsApiReportIDKey", "idkey data is null");
            c32183a.mo52824a("invaild_parms", null);
            AppMethodBeat.m2505o(6360);
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < optJSONArray.length(); i++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i);
            IDKey iDKey = new IDKey();
            iDKey.SetID(C5046bo.getInt(optJSONObject.optString("id"), 0));
            iDKey.SetKey(C5046bo.getInt(optJSONObject.optString("key"), 0));
            iDKey.SetValue((long) C5046bo.getInt(optJSONObject.optString("value"), 0));
            arrayList.add(iDKey);
        }
        if (arrayList.size() > 0) {
            C7060h.pYm.mo8379b(arrayList, true);
        }
        c32183a.mo52824a("", null);
        AppMethodBeat.m2505o(6360);
    }
}
