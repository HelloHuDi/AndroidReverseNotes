package com.tencent.mm.plugin.appbrand.m.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.p;
import com.tencent.mm.plugin.appbrand.appstorage.s;
import com.tencent.mm.plugin.appbrand.appstorage.w;
import com.tencent.mm.plugin.appbrand.i;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.LinkedList;
import org.json.JSONException;
import org.json.JSONObject;

public final class b {
    private static a iqd = null;

    public interface a {
        void a(i iVar, JSONObject jSONObject);
    }

    public static void a(a aVar) {
        iqd = aVar;
    }

    public static JSONObject y(i iVar) {
        JSONObject jSONObject;
        AppMethodBeat.i(102190);
        JSONObject jSONObject2 = new JSONObject();
        try {
            int i;
            jSONObject2.put("appId", iVar.mAppId);
            jSONObject2.put("appversion", iVar.ye() == null ? 0 : iVar.ye().hhd.gVu);
            String str = "appstate";
            if (iVar.ye() == null) {
                i = 0;
            } else {
                i = iVar.ye().hhd.gVt + 1;
            }
            jSONObject2.put(str, i);
        } catch (JSONException e) {
            ab.e("MicroMsg.PrepareDataForNodeHelper", "prepareCommonData e:%s", e);
        }
        com.tencent.mm.plugin.appbrand.l.a aVar = (com.tencent.mm.plugin.appbrand.l.a) iVar.aa(com.tencent.mm.plugin.appbrand.l.a.class);
        if (aVar != null) {
            jSONObject = new JSONObject();
            try {
                jSONObject.put("maxWebsocketConcurrent", aVar.iok);
                jSONObject.put("socketDomains", com.tencent.luggage.g.i.D(aVar.bQG));
                jSONObject.put("websocketSkipPortCheck", aVar.bQB);
                jSONObject.put("websocketTimeoutMS", aVar.ioh);
                jSONObject.put("headerFilterMode", aVar.mode);
                jSONObject.put("blacklistHeaders", com.tencent.luggage.g.i.D(aVar.iol));
                jSONObject.put("whitelistHeaders", com.tencent.luggage.g.i.D(aVar.iom));
                jSONObject.put("referer", aVar.referer);
                jSONObject.put("canSkipCheckDomainsByArg", aVar.ioe);
                jSONObject.put("shouldCheckDomains", aVar.iof);
                jSONObject.put("userAgentString", aVar.ioo);
                jSONObject2.put("networkConfig", jSONObject);
            } catch (JSONException e2) {
                ab.e("MicroMsg.PrepareDataForNodeHelper", "prepareNetworkConfigData e:%s", e2);
            }
        }
        com.tencent.mm.plugin.appbrand.s.q.a aVar2 = (com.tencent.mm.plugin.appbrand.s.q.a) iVar.aa(com.tencent.mm.plugin.appbrand.s.q.a.class);
        if (aVar2 != null) {
            jSONObject = new JSONObject();
            try {
                jSONObject.put("nativeBufferSizeLimitByte", aVar2.hfX);
                jSONObject.put("itemBase64", aVar2.iRH);
                jSONObject.put("itemID", aVar2.iRG);
                jSONObject.put("itemKey", aVar2.iRF);
                jSONObject.put("outKey", aVar2.iRE);
                jSONObject2.put("nativeBufferConfig", jSONObject);
            } catch (JSONException e22) {
                ab.e("MicroMsg.PrepareDataForNodeHelper", "prepareNativeBufferConfigData e:%s", e22);
            }
        }
        b(iVar, jSONObject2);
        if (iqd != null) {
            iqd.a(iVar, jSONObject2);
        }
        ab.v("MicroMsg.PrepareDataForNodeHelper", "prepareDataForNode :%s", jSONObject2.toString());
        AppMethodBeat.o(102190);
        return jSONObject2;
    }

    private static void b(i iVar, JSONObject jSONObject) {
        AppMethodBeat.i(102191);
        if (iVar.asE() instanceof s) {
            JSONObject jSONObject2 = new JSONObject();
            LinkedList linkedList = ((s) iVar.asE()).gYd;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < linkedList.size()) {
                    p pVar = (p) linkedList.get(i2);
                    if (pVar instanceof w) {
                        w wVar = (w) pVar;
                        ab.i("MicroMsg.PrepareDataForNodeHelper", "prepareFSData rootPath:%s pathPrefix:%s quota:%d", wVar.gXQ, wVar.gYj, Long.valueOf(wVar.gYk));
                        try {
                            JSONObject jSONObject3 = new JSONObject();
                            jSONObject3.put("rootPath", r4);
                            jSONObject3.put("quota", r6);
                            jSONObject2.put(r5, jSONObject3);
                        } catch (JSONException e) {
                            ab.e("MicroMsg.PrepareDataForNodeHelper", "prepareFSData e:%s", e);
                        }
                    }
                    i = i2 + 1;
                } else {
                    try {
                        jSONObject.put("fsData", jSONObject2);
                        AppMethodBeat.o(102191);
                        return;
                    } catch (JSONException e2) {
                        ab.e("MicroMsg.PrepareDataForNodeHelper", "prepareFSData e:%s", e2);
                        AppMethodBeat.o(102191);
                        return;
                    }
                }
            }
        }
        IllegalStateException illegalStateException = new IllegalStateException("getFileSystem not LuggageFileSystemRegistry");
        AppMethodBeat.o(102191);
        throw illegalStateException;
    }
}
