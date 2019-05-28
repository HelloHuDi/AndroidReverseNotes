package com.tencent.p177mm.plugin.appbrand.jsapi.p308i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.jsapi.C10296a;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2241c;
import com.tencent.p177mm.plugin.appbrand.jsapi.p308i.C45603d.C33328a;
import com.tencent.p177mm.plugin.appbrand.p321l.C10567c;
import com.tencent.p177mm.plugin.appbrand.p321l.C27146b;
import com.tencent.p177mm.plugin.appbrand.p321l.p1537a.C38413b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.HashMap;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.i.h */
public final class C27002h extends C10296a {
    public static final int CTRL_INDEX = 270;
    public static final String NAME = "operateDownloadTask";

    /* renamed from: a */
    public final void mo5994a(C2241c c2241c, JSONObject jSONObject, int i) {
        AppMethodBeat.m2504i(108060);
        C4990ab.m7410d("MicroMsg.JsApiOperateDownloadTask", "JsApiOperateDownloadTask");
        if (jSONObject == null) {
            c2241c.mo6107M(i, mo73394j("fail:data is null", null));
            C4990ab.m7412e("MicroMsg.JsApiOperateDownloadTask", "data is null");
            AppMethodBeat.m2505o(108060);
            return;
        }
        String optString = jSONObject.optString("downloadTaskId");
        if (C5046bo.isNullOrNil(optString)) {
            C4990ab.m7412e("MicroMsg.JsApiOperateDownloadTask", "downloadTaskId is null");
            c2241c.mo6107M(i, mo73394j("fail:downloadTaskId is null or nil", null));
            AppMethodBeat.m2505o(108060);
            return;
        }
        String optString2 = jSONObject.optString("operationType");
        if (C5046bo.isNullOrNil(optString2)) {
            C4990ab.m7412e("MicroMsg.JsApiOperateDownloadTask", "operationType is null");
            c2241c.mo6107M(i, mo73394j("fail:operationType is null or nil", null));
            AppMethodBeat.m2505o(108060);
        } else if (optString2.equals("abort")) {
            C27146b CJ = C10567c.aIB().mo22076CJ(c2241c.getAppId());
            if (CJ == null) {
                c2241c.mo6107M(i, mo73394j("fail:no task", null));
                C4990ab.m7420w("MicroMsg.JsApiOperateDownloadTask", "download is null");
                AppMethodBeat.m2505o(108060);
                return;
            }
            C38413b CG = CJ.mo44818CG(optString);
            if (CG == null) {
                c2241c.mo6107M(i, mo73394j("fail:no task", null));
                C4990ab.m7421w("MicroMsg.JsApiOperateDownloadTask", "downloadWorker is null %s", optString);
                AppMethodBeat.m2505o(108060);
                return;
            }
            CJ.mo44820a(CG);
            c2241c.mo6107M(i, mo73394j("ok", null));
            HashMap hashMap = new HashMap();
            hashMap.put("downloadTaskId", String.valueOf(optString));
            hashMap.put("state", "fail");
            hashMap.put("errMsg", "abort");
            new C33328a().mo61032j(c2241c).mo61028AM(new JSONObject(hashMap).toString()).aCj();
            C4990ab.m7411d("MicroMsg.JsApiOperateDownloadTask", "abortTask finish %s", optString);
            AppMethodBeat.m2505o(108060);
        } else {
            c2241c.mo6107M(i, mo73394j("fail:unknown operationType", null));
            AppMethodBeat.m2505o(108060);
        }
    }
}
