package com.tencent.p177mm.plugin.appbrand.p322m.p1229b;

import com.tencent.luggage.p147g.C32192i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.C6750i;
import com.tencent.p177mm.plugin.appbrand.appstorage.C19092p;
import com.tencent.p177mm.plugin.appbrand.appstorage.C2062w;
import com.tencent.p177mm.plugin.appbrand.appstorage.C33102s;
import com.tencent.p177mm.plugin.appbrand.p321l.C38414a;
import com.tencent.p177mm.plugin.appbrand.p329s.C27295q.C27296a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.LinkedList;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.m.b.b */
public final class C42628b {
    private static C27192a iqd = null;

    /* renamed from: com.tencent.mm.plugin.appbrand.m.b.b$a */
    public interface C27192a {
        /* renamed from: a */
        void mo22137a(C6750i c6750i, JSONObject jSONObject);
    }

    /* renamed from: a */
    public static void m75491a(C27192a c27192a) {
        iqd = c27192a;
    }

    /* renamed from: y */
    public static JSONObject m75493y(C6750i c6750i) {
        JSONObject jSONObject;
        AppMethodBeat.m2504i(102190);
        JSONObject jSONObject2 = new JSONObject();
        try {
            int i;
            jSONObject2.put("appId", c6750i.mAppId);
            jSONObject2.put("appversion", c6750i.mo15034ye() == null ? 0 : c6750i.mo15034ye().hhd.gVu);
            String str = "appstate";
            if (c6750i.mo15034ye() == null) {
                i = 0;
            } else {
                i = c6750i.mo15034ye().hhd.gVt + 1;
            }
            jSONObject2.put(str, i);
        } catch (JSONException e) {
            C4990ab.m7413e("MicroMsg.PrepareDataForNodeHelper", "prepareCommonData e:%s", e);
        }
        C38414a c38414a = (C38414a) c6750i.mo14986aa(C38414a.class);
        if (c38414a != null) {
            jSONObject = new JSONObject();
            try {
                jSONObject.put("maxWebsocketConcurrent", c38414a.iok);
                jSONObject.put("socketDomains", C32192i.m52506D(c38414a.bQG));
                jSONObject.put("websocketSkipPortCheck", c38414a.bQB);
                jSONObject.put("websocketTimeoutMS", c38414a.ioh);
                jSONObject.put("headerFilterMode", c38414a.mode);
                jSONObject.put("blacklistHeaders", C32192i.m52506D(c38414a.iol));
                jSONObject.put("whitelistHeaders", C32192i.m52506D(c38414a.iom));
                jSONObject.put("referer", c38414a.referer);
                jSONObject.put("canSkipCheckDomainsByArg", c38414a.ioe);
                jSONObject.put("shouldCheckDomains", c38414a.iof);
                jSONObject.put("userAgentString", c38414a.ioo);
                jSONObject2.put("networkConfig", jSONObject);
            } catch (JSONException e2) {
                C4990ab.m7413e("MicroMsg.PrepareDataForNodeHelper", "prepareNetworkConfigData e:%s", e2);
            }
        }
        C27296a c27296a = (C27296a) c6750i.mo14986aa(C27296a.class);
        if (c27296a != null) {
            jSONObject = new JSONObject();
            try {
                jSONObject.put("nativeBufferSizeLimitByte", c27296a.hfX);
                jSONObject.put("itemBase64", c27296a.iRH);
                jSONObject.put("itemID", c27296a.iRG);
                jSONObject.put("itemKey", c27296a.iRF);
                jSONObject.put("outKey", c27296a.iRE);
                jSONObject2.put("nativeBufferConfig", jSONObject);
            } catch (JSONException e22) {
                C4990ab.m7413e("MicroMsg.PrepareDataForNodeHelper", "prepareNativeBufferConfigData e:%s", e22);
            }
        }
        C42628b.m75492b(c6750i, jSONObject2);
        if (iqd != null) {
            iqd.mo22137a(c6750i, jSONObject2);
        }
        C4990ab.m7419v("MicroMsg.PrepareDataForNodeHelper", "prepareDataForNode :%s", jSONObject2.toString());
        AppMethodBeat.m2505o(102190);
        return jSONObject2;
    }

    /* renamed from: b */
    private static void m75492b(C6750i c6750i, JSONObject jSONObject) {
        AppMethodBeat.m2504i(102191);
        if (c6750i.asE() instanceof C33102s) {
            JSONObject jSONObject2 = new JSONObject();
            LinkedList linkedList = ((C33102s) c6750i.asE()).gYd;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < linkedList.size()) {
                    C19092p c19092p = (C19092p) linkedList.get(i2);
                    if (c19092p instanceof C2062w) {
                        C2062w c2062w = (C2062w) c19092p;
                        C4990ab.m7417i("MicroMsg.PrepareDataForNodeHelper", "prepareFSData rootPath:%s pathPrefix:%s quota:%d", c2062w.gXQ, c2062w.gYj, Long.valueOf(c2062w.gYk));
                        try {
                            JSONObject jSONObject3 = new JSONObject();
                            jSONObject3.put("rootPath", r4);
                            jSONObject3.put("quota", r6);
                            jSONObject2.put(r5, jSONObject3);
                        } catch (JSONException e) {
                            C4990ab.m7413e("MicroMsg.PrepareDataForNodeHelper", "prepareFSData e:%s", e);
                        }
                    }
                    i = i2 + 1;
                } else {
                    try {
                        jSONObject.put("fsData", jSONObject2);
                        AppMethodBeat.m2505o(102191);
                        return;
                    } catch (JSONException e2) {
                        C4990ab.m7413e("MicroMsg.PrepareDataForNodeHelper", "prepareFSData e:%s", e2);
                        AppMethodBeat.m2505o(102191);
                        return;
                    }
                }
            }
        }
        IllegalStateException illegalStateException = new IllegalStateException("getFileSystem not LuggageFileSystemRegistry");
        AppMethodBeat.m2505o(102191);
        throw illegalStateException;
    }
}
