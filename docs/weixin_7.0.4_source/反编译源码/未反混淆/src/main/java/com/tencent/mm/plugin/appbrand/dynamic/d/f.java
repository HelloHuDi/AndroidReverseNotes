package com.tencent.mm.plugin.appbrand.dynamic.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelappbrand.LogInfo;
import com.tencent.mm.plugin.appbrand.dynamic.d.a.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.z.b.b;
import com.tencent.recovery.util.Util;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class f extends a {
    public f(int i) {
        super("log", i);
    }

    public final void a(com.tencent.mm.z.c.a aVar, JSONObject jSONObject, b.a<JSONObject> aVar2) {
        AppMethodBeat.i(10832);
        try {
            JSONArray jSONArray = jSONObject.getJSONArray("dataArray");
            ArrayList arrayList = new ArrayList(jSONArray.length());
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                if (jSONObject2 != null) {
                    LogInfo logInfo = new LogInfo();
                    logInfo.ts = jSONObject2.optLong("ts");
                    logInfo.level = jSONObject2.optInt("level") + 1;
                    logInfo.message = jSONObject2.optString("msg");
                    arrayList.add(logInfo);
                    ab.d("MicroMsg.JsApiFunc_Log", "ts : %s, level : %d, msg : %s", Util.nz(logInfo.ts), Integer.valueOf(logInfo.level), logInfo.message);
                }
            }
            com.tencent.mm.plugin.appbrand.dynamic.debugger.a.c(aVar.Qy().getString("__page_view_id", null), arrayList);
            aVar2.au(a(true, "", null));
            AppMethodBeat.o(10832);
        } catch (JSONException e) {
            aVar2.au(a(false, "dataArray is null", null));
            AppMethodBeat.o(10832);
        }
    }
}
