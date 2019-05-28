package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.webview.luggage.jsapi.bc.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public class an extends bc {
    public final String name() {
        return "reportIDKey";
    }

    public final int biG() {
        return 0;
    }

    public final void a(Context context, String str, a aVar) {
    }

    public final void b(com.tencent.luggage.d.a.a aVar) {
        AppMethodBeat.i(6360);
        JSONArray optJSONArray = aVar.bPa.bOf.optJSONArray("idKeyDataInfo");
        if (optJSONArray == null || optJSONArray.length() == 0) {
            ab.e("MicroMsg.JsApiReportIDKey", "idkey data is null");
            aVar.a("invaild_parms", null);
            AppMethodBeat.o(6360);
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < optJSONArray.length(); i++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i);
            IDKey iDKey = new IDKey();
            iDKey.SetID(bo.getInt(optJSONObject.optString("id"), 0));
            iDKey.SetKey(bo.getInt(optJSONObject.optString("key"), 0));
            iDKey.SetValue((long) bo.getInt(optJSONObject.optString("value"), 0));
            arrayList.add(iDKey);
        }
        if (arrayList.size() > 0) {
            h.pYm.b(arrayList, true);
        }
        aVar.a("", null);
        AppMethodBeat.o(6360);
    }
}
