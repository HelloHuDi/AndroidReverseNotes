package com.tencent.p177mm.plugin.appbrand.jsapi.p308i;

import com.facebook.share.internal.ShareConstants;
import com.tencent.luggage.p1170a.C37384e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p230g.p231a.C18319m;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2241c;
import com.tencent.p177mm.plugin.appbrand.jsapi.C42467ah;
import com.tencent.p177mm.plugin.appbrand.p321l.C19538j;
import com.tencent.p177mm.plugin.appbrand.p321l.C33422d;
import com.tencent.p177mm.plugin.appbrand.p321l.C33422d.C27148a;
import com.tencent.p177mm.plugin.appbrand.p321l.C38414a;
import com.tencent.p177mm.plugin.appbrand.p321l.C42598f;
import com.tencent.p177mm.plugin.appbrand.p321l.C42602o;
import com.tencent.p177mm.plugin.appbrand.p329s.C27295q;
import com.tencent.p177mm.plugin.appbrand.p329s.C27295q.C10730b;
import com.tencent.p177mm.plugin.appbrand.p329s.C27295q.C27296a;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.smtt.sdk.TbsVideoCacheTask;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.i.e */
public final class C38309e extends C10433b {
    public static final int CTRL_INDEX = 242;
    public static final String NAME = "createRequestTask";

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.i.e$a */
    public static class C19399a extends C42467ah {
        public static final int CTRL_INDEX = 244;
        public static final String NAME = "onRequestTaskStateChange";
    }

    public final String aBA() {
        AppMethodBeat.m2504i(108033);
        StringBuilder stringBuilder = new StringBuilder();
        C42598f.aIE();
        String stringBuilder2 = stringBuilder.append(C42598f.aIA()).toString();
        AppMethodBeat.m2505o(108033);
        return stringBuilder2;
    }

    /* renamed from: OA */
    public final String mo21946OA() {
        return "requestTaskId";
    }

    /* renamed from: a */
    public final void mo21947a(C2241c c2241c, JSONObject jSONObject, String str) {
        AppMethodBeat.m2504i(108034);
        C4990ab.m7410d("MicroMsg.JsApiCreateRequestTask", "JsApiCreateRequestTask");
        final long currentTimeMillis = System.currentTimeMillis();
        final C2241c c2241c2 = c2241c;
        final String str2 = str;
        C383081 c383081 = new C27148a() {
            /* renamed from: BA */
            public final void mo44821BA(String str) {
                int i;
                AppMethodBeat.m2504i(108030);
                String str2 = "MicroMsg.JsApiCreateRequestTask";
                String str3 = "onRequestResult, time: %d, data size: %d";
                Object[] objArr = new Object[2];
                objArr[0] = Long.valueOf(System.currentTimeMillis() - currentTimeMillis);
                if (str == null) {
                    i = 0;
                } else {
                    i = str.length();
                }
                objArr[1] = Integer.valueOf(i);
                C4990ab.m7411d(str2, str3, objArr);
                C33422d CM = C42598f.aIE().mo68030CM(c2241c2.getAppId());
                if (CM == null || !CM.mo53907CH(str2)) {
                    C38309e.m64828a(c2241c2, str2, str);
                    ((C42602o) C37384e.m62986C(C42602o.class)).mo68038zT(c2241c2.getAppId());
                    AppMethodBeat.m2505o(108030);
                    return;
                }
                C4990ab.m7411d("MicroMsg.JsApiCreateRequestTask", "request abort %s", str2);
                AppMethodBeat.m2505o(108030);
            }

            /* renamed from: a */
            public final void mo44822a(String str, Object obj, int i, JSONObject jSONObject) {
                int length;
                AppMethodBeat.m2504i(108031);
                if (obj != null && (obj instanceof ByteBuffer)) {
                    length = ((ByteBuffer) obj).array().length;
                } else if (obj == null || !(obj instanceof String)) {
                    length = 0;
                } else {
                    length = ((String) obj).length();
                }
                C4990ab.m7411d("MicroMsg.JsApiCreateRequestTask", "onRequestResult, time: %d, data size: %d, code %s,reqrestId %s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis), Integer.valueOf(length), Integer.valueOf(i), str2);
                Map hashMap = new HashMap();
                hashMap.put("requestTaskId", str2);
                if (str.equalsIgnoreCase("ok")) {
                    hashMap.put("state", "success");
                    hashMap.put("data", obj);
                } else {
                    hashMap.put("state", "fail");
                }
                hashMap.put("statusCode", Integer.valueOf(i));
                if (jSONObject != null) {
                    hashMap.put(TbsVideoCacheTask.KEY_VIDEO_CACHE_PARAM_HEADER, jSONObject);
                }
                JSONArray optJSONArray = jSONObject.optJSONArray("cookies");
                if (optJSONArray != null) {
                    hashMap.put("cookies", optJSONArray);
                }
                C19399a c19399a = new C19399a();
                C10730b a = C27295q.m43333a(c2241c2.aBx(), hashMap, (C27296a) c2241c2.mo5937aa(C27296a.class));
                if ((obj == null || !(obj instanceof String)) && a != C10730b.OK) {
                    if (a == C10730b.FAIL_SIZE_EXCEED_LIMIT) {
                        C27295q.m43336m(c2241c2, C19399a.NAME);
                    }
                    AppMethodBeat.m2505o(108031);
                    return;
                }
                c19399a.mo61032j(c2241c2).mo61028AM(new JSONObject(hashMap).toString()).aCj();
                AppMethodBeat.m2505o(108031);
            }

            /* renamed from: p */
            public final void mo44823p(JSONObject jSONObject) {
                AppMethodBeat.m2504i(108032);
                if (jSONObject == null) {
                    AppMethodBeat.m2505o(108032);
                } else if (!jSONObject.optBoolean("__AppBrandRemoteDebugRequestHeader__")) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("requestTaskId", str2);
                    hashMap.put("state", "headersReceived");
                    hashMap.put(TbsVideoCacheTask.KEY_VIDEO_CACHE_PARAM_HEADER, jSONObject);
                    JSONArray optJSONArray = jSONObject.optJSONArray("cookies");
                    if (optJSONArray != null) {
                        hashMap.put("cookies", optJSONArray);
                    }
                    C19399a c19399a = new C19399a();
                    c19399a.mo61032j(c2241c2).mo61028AM(new JSONObject(hashMap).toString()).aCj();
                    AppMethodBeat.m2505o(108032);
                } else if (((C38414a) c2241c2.mo5937aa(C38414a.class)).bQf) {
                    jSONObject.remove("__AppBrandRemoteDebugRequestHeader__");
                    C18319m c18319m = new C18319m();
                    c18319m.csn.cso = ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID;
                    c18319m.csn.csq = jSONObject;
                    c18319m.csn.csp = str2;
                    C4879a.xxA.mo10055m(c18319m);
                    AppMethodBeat.m2505o(108032);
                } else {
                    AppMethodBeat.m2505o(108032);
                }
            }
        };
        String optString = jSONObject.optString("url");
        if (C5046bo.isNullOrNil(optString)) {
            C4990ab.m7412e("MicroMsg.JsApiCreateRequestTask", "url is null");
            C38309e.m64828a(c2241c, str, "url is null or nil");
            AppMethodBeat.m2505o(108034);
            return;
        }
        C38414a c38414a = (C38414a) c2241c.mo5937aa(C38414a.class);
        int i = 60000;
        int optInt = jSONObject.optInt("timeout", 0);
        C4990ab.m7417i("MicroMsg.JsApiCreateRequestTask", "lm:data configTimeout %d", Integer.valueOf(optInt));
        if (optInt <= 0) {
            optInt = C19538j.m30265a(c38414a, 0);
            C4990ab.m7417i("MicroMsg.JsApiCreateRequestTask", "lm:getRequiredTimeout configTimeout %d", Integer.valueOf(optInt));
        }
        if (optInt > 0) {
            i = optInt;
        }
        C4990ab.m7417i("MicroMsg.JsApiCreateRequestTask", "lm:configTimeout: %d,timeout: %d", Integer.valueOf(optInt), Integer.valueOf(i));
        if (c38414a.bQw <= 0) {
            C4990ab.m7416i("MicroMsg.JsApiCreateRequestTask", "maxRequestConcurrent <= 0 use default concurrent");
        }
        Map a = C19538j.m30267a(jSONObject, c38414a);
        Object obj = (c38414a.ioe && jSONObject.optBoolean("__skipDomainCheck__")) ? 1 : null;
        boolean z = obj != null ? false : c38414a.iof;
        if (!z || C19538j.m30275c(c38414a.bQF, optString)) {
            C33422d c33422d;
            if (C42598f.aIE().mo68030CM(c2241c.getAppId()) == null) {
                c33422d = new C33422d(c2241c);
                C42598f aIE = C42598f.aIE();
                String appId = c2241c.getAppId();
                if (!aIE.hGk.containsKey(appId)) {
                    aIE.hGk.put(appId, c33422d);
                }
            } else {
                c33422d = C42598f.aIE().mo68030CM(c2241c.getAppId());
            }
            C4990ab.m7417i("MicroMsg.JsApiCreateRequestTask", "request url: %s", optString);
            if (c33422d == null) {
                C38309e.m64828a(c2241c, str, "create request error");
                AppMethodBeat.m2505o(108034);
                return;
            } else if (z) {
                c33422d.mo53909a(c2241c, i, jSONObject, a, c38414a.bQF, c383081, str, NAME);
                AppMethodBeat.m2505o(108034);
                return;
            } else {
                C4990ab.m7416i("MicroMsg.JsApiCreateRequestTask", "debug type, do not verify domains");
                c33422d.mo53909a(c2241c, i, jSONObject, a, null, c383081, str, NAME);
                AppMethodBeat.m2505o(108034);
                return;
            }
        }
        C4990ab.m7417i("MicroMsg.JsApiCreateRequestTask", "not in domain url %s", optString);
        C38309e.m64828a(c2241c, str, "url not in domain list");
        AppMethodBeat.m2505o(108034);
    }

    /* renamed from: a */
    static void m64828a(C2241c c2241c, String str, String str2) {
        AppMethodBeat.m2504i(108035);
        HashMap hashMap = new HashMap();
        hashMap.put("requestTaskId", str);
        hashMap.put("state", "fail");
        hashMap.put("errMsg", str2);
        new C19399a().mo61032j(c2241c).mo61028AM(new JSONObject(hashMap).toString()).aCj();
        AppMethodBeat.m2505o(108035);
    }
}
