package com.tencent.p177mm.plugin.appbrand.jsapi.p308i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.jsapi.C10296a;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2241c;
import com.tencent.p177mm.plugin.appbrand.jsapi.p308i.C38312g.C38311a;
import com.tencent.p177mm.plugin.appbrand.p321l.C42599g;
import com.tencent.p177mm.plugin.appbrand.p321l.C42600h;
import com.tencent.p177mm.plugin.appbrand.p321l.C42601i;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.HashMap;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.i.l */
public final class C42519l extends C10296a {
    public static final int CTRL_INDEX = 273;
    public static final String NAME = "operateUploadTask";

    /* renamed from: a */
    public final void mo5994a(C2241c c2241c, JSONObject jSONObject, int i) {
        AppMethodBeat.m2504i(108078);
        C4990ab.m7410d("MicroMsg.JsApiOperateUploadTask", "JsApiOperateUploadTask");
        if (jSONObject == null) {
            c2241c.mo6107M(i, mo73394j("fail:data is null", null));
            C4990ab.m7412e("MicroMsg.JsApiOperateUploadTask", "data is null");
            AppMethodBeat.m2505o(108078);
            return;
        }
        String optString = jSONObject.optString("uploadTaskId");
        if (C5046bo.isNullOrNil(optString)) {
            C4990ab.m7412e("MicroMsg.JsApiOperateUploadTask", "uploadTaskId is null");
            c2241c.mo6107M(i, mo73394j("fail:uploadTaskId is null or nil", null));
            AppMethodBeat.m2505o(108078);
            return;
        }
        String optString2 = jSONObject.optString("operationType");
        if (C5046bo.isNullOrNil(optString2)) {
            C4990ab.m7412e("MicroMsg.JsApiOperateUploadTask", "operationType is null");
            c2241c.mo6107M(i, mo73394j("fail:operationType is null or nil", null));
            AppMethodBeat.m2505o(108078);
        } else if (optString2.equals("abort")) {
            C42599g CO = C42601i.aIG().mo68036CO(c2241c.getAppId());
            if (CO == null) {
                C4990ab.m7416i("MicroMsg.JsApiOperateUploadTask", "upload is null");
                c2241c.mo6107M(i, mo73394j("fail:no task", null));
                AppMethodBeat.m2505o(108078);
                return;
            }
            C42600h CN = CO.mo68032CN(optString);
            if (CN == null) {
                C4990ab.m7417i("MicroMsg.JsApiOperateUploadTask", "uploadInfo is null %s", optString);
                c2241c.mo6107M(i, mo73394j("fail:no task", null));
                AppMethodBeat.m2505o(108078);
                return;
            }
            CO.mo68034a(CN);
            c2241c.mo6107M(i, mo73394j("ok", null));
            HashMap hashMap = new HashMap();
            hashMap.put("uploadTaskId", String.valueOf(optString));
            hashMap.put("state", "fail");
            hashMap.put("errMsg", "abort");
            new C38311a().mo61032j(c2241c).mo61028AM(new JSONObject(hashMap).toString()).aCj();
            C4990ab.m7411d("MicroMsg.JsApiOperateUploadTask", "abortTask finish %s", optString);
            AppMethodBeat.m2505o(108078);
        } else {
            c2241c.mo6107M(i, mo73394j("fail:unknown operationType", null));
            AppMethodBeat.m2505o(108078);
        }
    }
}
