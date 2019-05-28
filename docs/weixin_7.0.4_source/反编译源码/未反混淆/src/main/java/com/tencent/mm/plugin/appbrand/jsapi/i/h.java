package com.tencent.mm.plugin.appbrand.jsapi.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.l.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashMap;
import org.json.JSONObject;

public final class h extends a {
    public static final int CTRL_INDEX = 270;
    public static final String NAME = "operateDownloadTask";

    public final void a(c cVar, JSONObject jSONObject, int i) {
        AppMethodBeat.i(108060);
        ab.d("MicroMsg.JsApiOperateDownloadTask", "JsApiOperateDownloadTask");
        if (jSONObject == null) {
            cVar.M(i, j("fail:data is null", null));
            ab.e("MicroMsg.JsApiOperateDownloadTask", "data is null");
            AppMethodBeat.o(108060);
            return;
        }
        String optString = jSONObject.optString("downloadTaskId");
        if (bo.isNullOrNil(optString)) {
            ab.e("MicroMsg.JsApiOperateDownloadTask", "downloadTaskId is null");
            cVar.M(i, j("fail:downloadTaskId is null or nil", null));
            AppMethodBeat.o(108060);
            return;
        }
        String optString2 = jSONObject.optString("operationType");
        if (bo.isNullOrNil(optString2)) {
            ab.e("MicroMsg.JsApiOperateDownloadTask", "operationType is null");
            cVar.M(i, j("fail:operationType is null or nil", null));
            AppMethodBeat.o(108060);
        } else if (optString2.equals("abort")) {
            b CJ = com.tencent.mm.plugin.appbrand.l.c.aIB().CJ(cVar.getAppId());
            if (CJ == null) {
                cVar.M(i, j("fail:no task", null));
                ab.w("MicroMsg.JsApiOperateDownloadTask", "download is null");
                AppMethodBeat.o(108060);
                return;
            }
            com.tencent.mm.plugin.appbrand.l.a.b CG = CJ.CG(optString);
            if (CG == null) {
                cVar.M(i, j("fail:no task", null));
                ab.w("MicroMsg.JsApiOperateDownloadTask", "downloadWorker is null %s", optString);
                AppMethodBeat.o(108060);
                return;
            }
            CJ.a(CG);
            cVar.M(i, j("ok", null));
            HashMap hashMap = new HashMap();
            hashMap.put("downloadTaskId", String.valueOf(optString));
            hashMap.put("state", "fail");
            hashMap.put("errMsg", "abort");
            new d.a().j(cVar).AM(new JSONObject(hashMap).toString()).aCj();
            ab.d("MicroMsg.JsApiOperateDownloadTask", "abortTask finish %s", optString);
            AppMethodBeat.o(108060);
        } else {
            cVar.M(i, j("fail:unknown operationType", null));
            AppMethodBeat.o(108060);
        }
    }
}
