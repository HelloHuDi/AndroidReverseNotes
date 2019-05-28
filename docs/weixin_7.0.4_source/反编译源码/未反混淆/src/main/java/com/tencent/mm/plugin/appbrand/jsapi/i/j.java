package com.tencent.mm.plugin.appbrand.jsapi.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.l.d;
import com.tencent.mm.plugin.appbrand.l.e;
import com.tencent.mm.plugin.appbrand.l.f;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashMap;
import org.json.JSONObject;

public final class j extends a {
    public static final int CTRL_INDEX = 243;
    public static final String NAME = "operateRequestTask";

    public final void a(c cVar, JSONObject jSONObject, int i) {
        AppMethodBeat.i(108075);
        ab.d("MicroMsg.JsApiOperateRequestTask", "JsApiOperateRequestTask");
        if (jSONObject == null) {
            cVar.M(i, j("fail:data is null", null));
            ab.e("MicroMsg.JsApiOperateRequestTask", "data is null");
            AppMethodBeat.o(108075);
            return;
        }
        String optString = jSONObject.optString("requestTaskId");
        if (bo.isNullOrNil(optString)) {
            ab.e("MicroMsg.JsApiOperateRequestTask", "requestTaskId is null");
            cVar.M(i, j("fail:requestTaskId is null or nil", null));
            AppMethodBeat.o(108075);
            return;
        }
        String optString2 = jSONObject.optString("operationType");
        if (bo.isNullOrNil(optString2)) {
            ab.e("MicroMsg.JsApiOperateRequestTask", "operationType is null");
            cVar.M(i, j("fail:operationType is null or nil", null));
            AppMethodBeat.o(108075);
        } else if (optString2.equals("abort")) {
            d CM = f.aIE().CM(cVar.getAppId());
            if (CM == null) {
                cVar.M(i, j("fail:no task", null));
                ab.w("MicroMsg.JsApiOperateRequestTask", "request is null");
                AppMethodBeat.o(108075);
                return;
            }
            e CL = CM.CL(optString);
            if (CL == null) {
                cVar.M(i, j("fail:no task", null));
                ab.w("MicroMsg.JsApiOperateRequestTask", "requestInfo is null %s", optString);
                AppMethodBeat.o(108075);
                return;
            }
            CM.b(CL);
            cVar.M(i, j("ok", null));
            HashMap hashMap = new HashMap();
            hashMap.put("requestTaskId", String.valueOf(optString));
            hashMap.put("state", "fail");
            hashMap.put("errMsg", "abort");
            new e.a().j(cVar).AM(new JSONObject(hashMap).toString()).aCj();
            ab.d("MicroMsg.JsApiOperateRequestTask", "abortTask finish %s", optString);
            AppMethodBeat.o(108075);
        } else {
            cVar.M(i, j("fail:unknown operationType", null));
            AppMethodBeat.o(108075);
        }
    }
}
