package com.tencent.mm.plugin.appbrand.jsapi.i;

import com.facebook.share.internal.ShareConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.m;
import com.tencent.mm.plugin.appbrand.jsapi.ah;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.l.d;
import com.tencent.mm.plugin.appbrand.l.f;
import com.tencent.mm.plugin.appbrand.l.j;
import com.tencent.mm.plugin.appbrand.l.o;
import com.tencent.mm.plugin.appbrand.s.q;
import com.tencent.mm.plugin.appbrand.s.q.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.smtt.sdk.TbsVideoCacheTask;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public final class e extends b {
    public static final int CTRL_INDEX = 242;
    public static final String NAME = "createRequestTask";

    public static class a extends ah {
        public static final int CTRL_INDEX = 244;
        public static final String NAME = "onRequestTaskStateChange";
    }

    public final String aBA() {
        AppMethodBeat.i(108033);
        StringBuilder stringBuilder = new StringBuilder();
        f.aIE();
        String stringBuilder2 = stringBuilder.append(f.aIA()).toString();
        AppMethodBeat.o(108033);
        return stringBuilder2;
    }

    public final String OA() {
        return "requestTaskId";
    }

    public final void a(c cVar, JSONObject jSONObject, String str) {
        AppMethodBeat.i(108034);
        ab.d("MicroMsg.JsApiCreateRequestTask", "JsApiCreateRequestTask");
        final long currentTimeMillis = System.currentTimeMillis();
        final c cVar2 = cVar;
        final String str2 = str;
        AnonymousClass1 anonymousClass1 = new com.tencent.mm.plugin.appbrand.l.d.a() {
            public final void BA(String str) {
                int i;
                AppMethodBeat.i(108030);
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
                ab.d(str2, str3, objArr);
                d CM = f.aIE().CM(cVar2.getAppId());
                if (CM == null || !CM.CH(str2)) {
                    e.a(cVar2, str2, str);
                    ((o) com.tencent.luggage.a.e.C(o.class)).zT(cVar2.getAppId());
                    AppMethodBeat.o(108030);
                    return;
                }
                ab.d("MicroMsg.JsApiCreateRequestTask", "request abort %s", str2);
                AppMethodBeat.o(108030);
            }

            public final void a(String str, Object obj, int i, JSONObject jSONObject) {
                int length;
                AppMethodBeat.i(108031);
                if (obj != null && (obj instanceof ByteBuffer)) {
                    length = ((ByteBuffer) obj).array().length;
                } else if (obj == null || !(obj instanceof String)) {
                    length = 0;
                } else {
                    length = ((String) obj).length();
                }
                ab.d("MicroMsg.JsApiCreateRequestTask", "onRequestResult, time: %d, data size: %d, code %s,reqrestId %s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis), Integer.valueOf(length), Integer.valueOf(i), str2);
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
                a aVar = new a();
                b a = q.a(cVar2.aBx(), hashMap, (com.tencent.mm.plugin.appbrand.s.q.a) cVar2.aa(com.tencent.mm.plugin.appbrand.s.q.a.class));
                if ((obj == null || !(obj instanceof String)) && a != b.OK) {
                    if (a == b.FAIL_SIZE_EXCEED_LIMIT) {
                        q.m(cVar2, a.NAME);
                    }
                    AppMethodBeat.o(108031);
                    return;
                }
                aVar.j(cVar2).AM(new JSONObject(hashMap).toString()).aCj();
                AppMethodBeat.o(108031);
            }

            public final void p(JSONObject jSONObject) {
                AppMethodBeat.i(108032);
                if (jSONObject == null) {
                    AppMethodBeat.o(108032);
                } else if (!jSONObject.optBoolean("__AppBrandRemoteDebugRequestHeader__")) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("requestTaskId", str2);
                    hashMap.put("state", "headersReceived");
                    hashMap.put(TbsVideoCacheTask.KEY_VIDEO_CACHE_PARAM_HEADER, jSONObject);
                    JSONArray optJSONArray = jSONObject.optJSONArray("cookies");
                    if (optJSONArray != null) {
                        hashMap.put("cookies", optJSONArray);
                    }
                    a aVar = new a();
                    aVar.j(cVar2).AM(new JSONObject(hashMap).toString()).aCj();
                    AppMethodBeat.o(108032);
                } else if (((com.tencent.mm.plugin.appbrand.l.a) cVar2.aa(com.tencent.mm.plugin.appbrand.l.a.class)).bQf) {
                    jSONObject.remove("__AppBrandRemoteDebugRequestHeader__");
                    m mVar = new m();
                    mVar.csn.cso = ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID;
                    mVar.csn.csq = jSONObject;
                    mVar.csn.csp = str2;
                    com.tencent.mm.sdk.b.a.xxA.m(mVar);
                    AppMethodBeat.o(108032);
                } else {
                    AppMethodBeat.o(108032);
                }
            }
        };
        String optString = jSONObject.optString("url");
        if (bo.isNullOrNil(optString)) {
            ab.e("MicroMsg.JsApiCreateRequestTask", "url is null");
            a(cVar, str, "url is null or nil");
            AppMethodBeat.o(108034);
            return;
        }
        com.tencent.mm.plugin.appbrand.l.a aVar = (com.tencent.mm.plugin.appbrand.l.a) cVar.aa(com.tencent.mm.plugin.appbrand.l.a.class);
        int i = 60000;
        int optInt = jSONObject.optInt("timeout", 0);
        ab.i("MicroMsg.JsApiCreateRequestTask", "lm:data configTimeout %d", Integer.valueOf(optInt));
        if (optInt <= 0) {
            optInt = j.a(aVar, 0);
            ab.i("MicroMsg.JsApiCreateRequestTask", "lm:getRequiredTimeout configTimeout %d", Integer.valueOf(optInt));
        }
        if (optInt > 0) {
            i = optInt;
        }
        ab.i("MicroMsg.JsApiCreateRequestTask", "lm:configTimeout: %d,timeout: %d", Integer.valueOf(optInt), Integer.valueOf(i));
        if (aVar.bQw <= 0) {
            ab.i("MicroMsg.JsApiCreateRequestTask", "maxRequestConcurrent <= 0 use default concurrent");
        }
        Map a = j.a(jSONObject, aVar);
        Object obj = (aVar.ioe && jSONObject.optBoolean("__skipDomainCheck__")) ? 1 : null;
        boolean z = obj != null ? false : aVar.iof;
        if (!z || j.c(aVar.bQF, optString)) {
            d dVar;
            if (f.aIE().CM(cVar.getAppId()) == null) {
                dVar = new d(cVar);
                f aIE = f.aIE();
                String appId = cVar.getAppId();
                if (!aIE.hGk.containsKey(appId)) {
                    aIE.hGk.put(appId, dVar);
                }
            } else {
                dVar = f.aIE().CM(cVar.getAppId());
            }
            ab.i("MicroMsg.JsApiCreateRequestTask", "request url: %s", optString);
            if (dVar == null) {
                a(cVar, str, "create request error");
                AppMethodBeat.o(108034);
                return;
            } else if (z) {
                dVar.a(cVar, i, jSONObject, a, aVar.bQF, anonymousClass1, str, NAME);
                AppMethodBeat.o(108034);
                return;
            } else {
                ab.i("MicroMsg.JsApiCreateRequestTask", "debug type, do not verify domains");
                dVar.a(cVar, i, jSONObject, a, null, anonymousClass1, str, NAME);
                AppMethodBeat.o(108034);
                return;
            }
        }
        ab.i("MicroMsg.JsApiCreateRequestTask", "not in domain url %s", optString);
        a(cVar, str, "url not in domain list");
        AppMethodBeat.o(108034);
    }

    static void a(c cVar, String str, String str2) {
        AppMethodBeat.i(108035);
        HashMap hashMap = new HashMap();
        hashMap.put("requestTaskId", str);
        hashMap.put("state", "fail");
        hashMap.put("errMsg", str2);
        new a().j(cVar).AM(new JSONObject(hashMap).toString()).aCj();
        AppMethodBeat.o(108035);
    }
}
