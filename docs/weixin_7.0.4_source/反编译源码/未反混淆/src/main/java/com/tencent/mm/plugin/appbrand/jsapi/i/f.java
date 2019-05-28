package com.tencent.mm.plugin.appbrand.jsapi.i;

import com.facebook.share.internal.ShareConstants;
import com.tencent.luggage.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.m;
import com.tencent.mm.plugin.appbrand.b.b;
import com.tencent.mm.plugin.appbrand.jsapi.ah;
import com.tencent.mm.plugin.appbrand.jsapi.websocket.d;
import com.tencent.mm.plugin.appbrand.l.j;
import com.tencent.mm.plugin.appbrand.l.k;
import com.tencent.mm.plugin.appbrand.l.k.c;
import com.tencent.mm.plugin.appbrand.l.l;
import com.tencent.mm.plugin.appbrand.s.q;
import com.tencent.mm.plugin.appbrand.s.r;
import com.tencent.mm.plugin.appbrand.t.e.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.smtt.sdk.TbsVideoCacheTask;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class f extends b {
    public static final int CTRL_INDEX = 346;
    public static final String NAME = "createSocketTask";
    public static int hRA = 0;
    public static int hRB = 1;
    private static com.tencent.mm.plugin.appbrand.l.k.a hRy;
    private int hRC = hRA;
    private boolean hRD = false;
    private boolean hRE = false;
    private c hRz;

    public static class a extends ah {
        public static final int CTRL_INDEX = 348;
        public static final String NAME = "onSocketTaskStateChange";
    }

    static /* synthetic */ void b(com.tencent.mm.plugin.appbrand.jsapi.c cVar, String str, String str2) {
        AppMethodBeat.i(108051);
        a(cVar, str, str2);
        AppMethodBeat.o(108051);
    }

    public f(int i, c cVar) {
        AppMethodBeat.i(108043);
        ab.i("MicroMsg.JsApiCreateSocketTask", "JsApiCreateSocketTask, programType:%d", Integer.valueOf(i));
        this.hRC = i;
        this.hRz = cVar;
        AppMethodBeat.o(108043);
    }

    public static void a(com.tencent.mm.plugin.appbrand.l.k.a aVar) {
        hRy = aVar;
    }

    public final String aBA() {
        AppMethodBeat.i(108044);
        StringBuilder stringBuilder = new StringBuilder();
        l.aII();
        String stringBuilder2 = stringBuilder.append(l.aIA()).toString();
        AppMethodBeat.o(108044);
        return stringBuilder2;
    }

    public final String OA() {
        return "socketTaskId";
    }

    public static void a(com.tencent.mm.plugin.appbrand.jsapi.c cVar, String str, b bVar, String str2) {
        AppMethodBeat.i(108045);
        if (bVar == b.SUSPEND || bVar == b.DESTROYED) {
            d CT = l.aII().CT(str);
            if (CT == null) {
                AppMethodBeat.o(108045);
                return;
            }
            CT.a(CT.BS(str2));
            HashMap hashMap = new HashMap();
            hashMap.put("reason", "interrupted");
            hashMap.put("socketTaskId", str2);
            hashMap.put("state", "close");
            new a().j(cVar).AM(new JSONObject(hashMap).toString()).aCj();
        }
        AppMethodBeat.o(108045);
    }

    public final void a(final com.tencent.mm.plugin.appbrand.jsapi.c cVar, JSONObject jSONObject, final String str) {
        AppMethodBeat.i(108046);
        d CT = l.aII().CT(cVar.getAppId());
        if (CT == null) {
            if ((this.hRC == hRA && this.hRD) || (this.hRC == hRB && this.hRE)) {
                CT = new com.tencent.mm.plugin.appbrand.jsapi.websocket.a((com.tencent.mm.plugin.appbrand.l.a) cVar.aa(com.tencent.mm.plugin.appbrand.l.a.class));
            } else {
                Object kVar = new k((com.tencent.mm.plugin.appbrand.l.a) cVar.aa(com.tencent.mm.plugin.appbrand.l.a.class));
            }
            l aII = l.aII();
            String appId = cVar.getAppId();
            if (!aII.hGk.containsKey(appId)) {
                aII.hGk.put(appId, CT);
            }
        }
        AnonymousClass1 anonymousClass1 = new com.tencent.mm.plugin.appbrand.jsapi.websocket.d.a() {
            boolean hRF = false;

            public final void b(h hVar) {
                AppMethodBeat.i(108036);
                if (f.hRy != null) {
                    f.hRy.d(cVar, str);
                }
                HashMap hashMap = new HashMap();
                hashMap.put("socketTaskId", str);
                hashMap.put("state", "open");
                hashMap.put(TbsVideoCacheTask.KEY_VIDEO_CACHE_PARAM_HEADER, f.b((com.tencent.mm.plugin.appbrand.t.e.f) hVar));
                new a().j(cVar).AM(new JSONObject(hashMap).toString()).aCj();
                AppMethodBeat.o(108036);
            }

            public final void a(com.tencent.mm.plugin.appbrand.t.e.a aVar) {
                AppMethodBeat.i(108037);
                if (aVar == null || !((com.tencent.mm.plugin.appbrand.l.a) cVar.aa(com.tencent.mm.plugin.appbrand.l.a.class)).bQf) {
                    AppMethodBeat.o(108037);
                    return;
                }
                m mVar = new m();
                mVar.csn.cso = "socket";
                mVar.csn.csq = f.b((com.tencent.mm.plugin.appbrand.t.e.f) aVar);
                mVar.csn.csp = str;
                com.tencent.mm.sdk.b.a.xxA.m(mVar);
                AppMethodBeat.o(108037);
            }

            public final void zJ(String str) {
                AppMethodBeat.i(108038);
                if (this.hRF) {
                    ab.i("MicroMsg.JsApiCreateSocketTask", "onSocketError is true");
                    AppMethodBeat.o(108038);
                    return;
                }
                this.hRF = true;
                HashMap hashMap = new HashMap();
                hashMap.put("socketTaskId", str);
                hashMap.put("state", "error");
                hashMap.put("errMsg", str);
                new a().j(cVar).AM(new JSONObject(hashMap).toString()).aCj();
                if (f.this.hRD || f.this.hRE) {
                    ((com.tencent.mm.plugin.appbrand.n.a) e.C(com.tencent.mm.plugin.appbrand.n.a.class)).f(972, 2, 1);
                    AppMethodBeat.o(108038);
                    return;
                }
                ((com.tencent.mm.plugin.appbrand.n.a) e.C(com.tencent.mm.plugin.appbrand.n.a.class)).f(972, 1, 1);
                AppMethodBeat.o(108038);
            }

            public final void BB(String str) {
                AppMethodBeat.i(108039);
                HashMap hashMap = new HashMap();
                hashMap.put("data", r.Ei(str));
                hashMap.put("isBuffer", Boolean.FALSE);
                hashMap.put("socketTaskId", str);
                hashMap.put("state", ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
                new a().j(cVar).AM(new JSONObject(hashMap).toString()).aCj();
                AppMethodBeat.o(108039);
            }

            public final void l(ByteBuffer byteBuffer) {
                AppMethodBeat.i(108040);
                Map hashMap = new HashMap();
                hashMap.put("socketTaskId", str);
                hashMap.put("data", byteBuffer);
                hashMap.put("isBuffer", Boolean.TRUE);
                hashMap.put("state", ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
                q.b a = q.a(cVar.aBx(), hashMap, (com.tencent.mm.plugin.appbrand.s.q.a) cVar.aa(com.tencent.mm.plugin.appbrand.s.q.a.class));
                if (a == q.b.OK) {
                    new a().j(cVar).AM(new JSONObject(hashMap).toString()).aCj();
                    AppMethodBeat.o(108040);
                    return;
                }
                if (a == q.b.FAIL_SIZE_EXCEED_LIMIT) {
                    q.m(cVar, a.NAME);
                }
                AppMethodBeat.o(108040);
            }

            public final void K(int i, String str) {
                AppMethodBeat.i(108041);
                if (f.hRy != null) {
                    f.hRy.e(cVar, str);
                }
                HashMap hashMap = new HashMap();
                if (j.b(cVar.asD())) {
                    hashMap.put("reason", "interrupted");
                } else if (!bo.isNullOrNil(str)) {
                    hashMap.put("reason", str);
                }
                hashMap.put(TMQQDownloaderOpenSDKConst.UINTYPE_CODE, Integer.valueOf(i));
                hashMap.put("socketTaskId", str);
                hashMap.put("state", "close");
                new a().j(cVar).AM(new JSONObject(hashMap).toString()).aCj();
                AppMethodBeat.o(108041);
            }

            public final void zK(String str) {
                AppMethodBeat.i(108042);
                f.b(cVar, str, str);
                AppMethodBeat.o(108042);
            }
        };
        String optString = jSONObject.optString("url");
        if (bo.isNullOrNil(optString)) {
            ab.i("MicroMsg.JsApiCreateSocketTask", "url is null");
            a(cVar, str, "url is null");
            AppMethodBeat.o(108046);
            return;
        }
        ab.i("MicroMsg.JsApiCreateSocketTask", "url is ".concat(String.valueOf(optString)));
        com.tencent.mm.plugin.appbrand.l.a aVar = (com.tencent.mm.plugin.appbrand.l.a) cVar.aa(com.tencent.mm.plugin.appbrand.l.a.class);
        Map a = j.a(jSONObject, aVar);
        Object obj = (aVar.ioe && jSONObject.optBoolean("__skipDomainCheck__")) ? 1 : null;
        if (!(obj != null ? false : aVar.iof) || j.a(aVar.bQG, optString, aVar.bQB)) {
            int optInt = jSONObject.optInt("timeout", 0);
            if (optInt <= 0) {
                optInt = j.a(aVar, 1);
            }
            if (optInt <= 0) {
                optInt = 60000;
            }
            CT.a(cVar.getAppId(), str, this.hRC, optInt, jSONObject, a, anonymousClass1);
            if (this.hRD || this.hRE) {
                ((com.tencent.mm.plugin.appbrand.n.a) e.C(com.tencent.mm.plugin.appbrand.n.a.class)).f(972, 10, 1);
            } else {
                ((com.tencent.mm.plugin.appbrand.n.a) e.C(com.tencent.mm.plugin.appbrand.n.a.class)).f(972, 0, 1);
            }
            ab.i("MicroMsg.JsApiCreateSocketTask", "connectSocket, url is : %s , componentId: %s", optString, Integer.valueOf(cVar.aBw()));
            AppMethodBeat.o(108046);
            return;
        }
        ab.i("MicroMsg.JsApiCreateSocketTask", "not in domain url %s", optString);
        a(cVar, str, "url not in domain list");
        AppMethodBeat.o(108046);
    }

    public final void g(com.tencent.mm.plugin.appbrand.jsapi.c cVar) {
        AppMethodBeat.i(108047);
        if (this.hRz != null) {
            this.hRD = this.hRz.xj(cVar.getAppId());
            this.hRE = this.hRz.auB();
        }
        AppMethodBeat.o(108047);
    }

    private static JSONObject a(com.tencent.mm.plugin.appbrand.t.e.f fVar) {
        AppMethodBeat.i(108048);
        JSONObject jSONObject = new JSONObject();
        Iterator aOx = fVar.aOx();
        while (aOx.hasNext()) {
            try {
                String str = (String) aOx.next();
                jSONObject.put(str, fVar.Eq(str));
            } catch (JSONException e) {
                ab.printErrStackTrace("MicroMsg.JsApiCreateSocketTask", e, "JSONExceptions ", new Object[0]);
            }
        }
        AppMethodBeat.o(108048);
        return jSONObject;
    }

    private static void a(com.tencent.mm.plugin.appbrand.jsapi.c cVar, String str, String str2) {
        Object obj;
        AppMethodBeat.i(108049);
        if (bo.isNullOrNil(str2)) {
            obj = "fail";
        } else {
            obj = "fail:".concat(String.valueOf(str2));
        }
        HashMap hashMap = new HashMap();
        hashMap.put("socketTaskId", str);
        hashMap.put("state", "error");
        hashMap.put("errMsg", obj);
        new a().j(cVar).AM(new JSONObject(hashMap).toString()).aCj();
        ab.d("MicroMsg.JsApiCreateSocketTask", "onSocketConnectFail jsonResult:%s ", r0);
        ((com.tencent.mm.plugin.appbrand.n.a) e.C(com.tencent.mm.plugin.appbrand.n.a.class)).f(972, 3, 1);
        AppMethodBeat.o(108049);
    }
}
