package com.tencent.mm.plugin.appbrand.jsapi.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.l.g;
import com.tencent.mm.plugin.appbrand.l.h;
import com.tencent.mm.plugin.appbrand.l.i;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashMap;
import org.json.JSONObject;

public final class l extends a {
    public static final int CTRL_INDEX = 273;
    public static final String NAME = "operateUploadTask";

    public final void a(c cVar, JSONObject jSONObject, int i) {
        AppMethodBeat.i(108078);
        ab.d("MicroMsg.JsApiOperateUploadTask", "JsApiOperateUploadTask");
        if (jSONObject == null) {
            cVar.M(i, j("fail:data is null", null));
            ab.e("MicroMsg.JsApiOperateUploadTask", "data is null");
            AppMethodBeat.o(108078);
            return;
        }
        String optString = jSONObject.optString("uploadTaskId");
        if (bo.isNullOrNil(optString)) {
            ab.e("MicroMsg.JsApiOperateUploadTask", "uploadTaskId is null");
            cVar.M(i, j("fail:uploadTaskId is null or nil", null));
            AppMethodBeat.o(108078);
            return;
        }
        String optString2 = jSONObject.optString("operationType");
        if (bo.isNullOrNil(optString2)) {
            ab.e("MicroMsg.JsApiOperateUploadTask", "operationType is null");
            cVar.M(i, j("fail:operationType is null or nil", null));
            AppMethodBeat.o(108078);
        } else if (optString2.equals("abort")) {
            g CO = i.aIG().CO(cVar.getAppId());
            if (CO == null) {
                ab.i("MicroMsg.JsApiOperateUploadTask", "upload is null");
                cVar.M(i, j("fail:no task", null));
                AppMethodBeat.o(108078);
                return;
            }
            h CN = CO.CN(optString);
            if (CN == null) {
                ab.i("MicroMsg.JsApiOperateUploadTask", "uploadInfo is null %s", optString);
                cVar.M(i, j("fail:no task", null));
                AppMethodBeat.o(108078);
                return;
            }
            CO.a(CN);
            cVar.M(i, j("ok", null));
            HashMap hashMap = new HashMap();
            hashMap.put("uploadTaskId", String.valueOf(optString));
            hashMap.put("state", "fail");
            hashMap.put("errMsg", "abort");
            new g.a().j(cVar).AM(new JSONObject(hashMap).toString()).aCj();
            ab.d("MicroMsg.JsApiOperateUploadTask", "abortTask finish %s", optString);
            AppMethodBeat.o(108078);
        } else {
            cVar.M(i, j("fail:unknown operationType", null));
            AppMethodBeat.o(108078);
        }
    }
}
