package com.tencent.p177mm.plugin.appbrand.jsapi.p308i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.jsapi.C10296a;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2241c;
import com.tencent.p177mm.plugin.appbrand.jsapi.p308i.C38309e.C19399a;
import com.tencent.p177mm.plugin.appbrand.p321l.C10570e;
import com.tencent.p177mm.plugin.appbrand.p321l.C33422d;
import com.tencent.p177mm.plugin.appbrand.p321l.C42598f;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.HashMap;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.i.j */
public final class C27006j extends C10296a {
    public static final int CTRL_INDEX = 243;
    public static final String NAME = "operateRequestTask";

    /* renamed from: a */
    public final void mo5994a(C2241c c2241c, JSONObject jSONObject, int i) {
        AppMethodBeat.m2504i(108075);
        C4990ab.m7410d("MicroMsg.JsApiOperateRequestTask", "JsApiOperateRequestTask");
        if (jSONObject == null) {
            c2241c.mo6107M(i, mo73394j("fail:data is null", null));
            C4990ab.m7412e("MicroMsg.JsApiOperateRequestTask", "data is null");
            AppMethodBeat.m2505o(108075);
            return;
        }
        String optString = jSONObject.optString("requestTaskId");
        if (C5046bo.isNullOrNil(optString)) {
            C4990ab.m7412e("MicroMsg.JsApiOperateRequestTask", "requestTaskId is null");
            c2241c.mo6107M(i, mo73394j("fail:requestTaskId is null or nil", null));
            AppMethodBeat.m2505o(108075);
            return;
        }
        String optString2 = jSONObject.optString("operationType");
        if (C5046bo.isNullOrNil(optString2)) {
            C4990ab.m7412e("MicroMsg.JsApiOperateRequestTask", "operationType is null");
            c2241c.mo6107M(i, mo73394j("fail:operationType is null or nil", null));
            AppMethodBeat.m2505o(108075);
        } else if (optString2.equals("abort")) {
            C33422d CM = C42598f.aIE().mo68030CM(c2241c.getAppId());
            if (CM == null) {
                c2241c.mo6107M(i, mo73394j("fail:no task", null));
                C4990ab.m7420w("MicroMsg.JsApiOperateRequestTask", "request is null");
                AppMethodBeat.m2505o(108075);
                return;
            }
            C10570e CL = CM.mo53908CL(optString);
            if (CL == null) {
                c2241c.mo6107M(i, mo73394j("fail:no task", null));
                C4990ab.m7421w("MicroMsg.JsApiOperateRequestTask", "requestInfo is null %s", optString);
                AppMethodBeat.m2505o(108075);
                return;
            }
            CM.mo53910b(CL);
            c2241c.mo6107M(i, mo73394j("ok", null));
            HashMap hashMap = new HashMap();
            hashMap.put("requestTaskId", String.valueOf(optString));
            hashMap.put("state", "fail");
            hashMap.put("errMsg", "abort");
            new C19399a().mo61032j(c2241c).mo61028AM(new JSONObject(hashMap).toString()).aCj();
            C4990ab.m7411d("MicroMsg.JsApiOperateRequestTask", "abortTask finish %s", optString);
            AppMethodBeat.m2505o(108075);
        } else {
            c2241c.mo6107M(i, mo73394j("fail:unknown operationType", null));
            AppMethodBeat.m2505o(108075);
        }
    }
}
