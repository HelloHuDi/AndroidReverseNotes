package com.tencent.p177mm.plugin.appbrand.jsapi.p308i;

import com.facebook.share.internal.ShareConstants;
import com.tencent.luggage.p1170a.C37384e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p230g.p231a.C18319m;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2241c;
import com.tencent.p177mm.plugin.appbrand.jsapi.C42467ah;
import com.tencent.p177mm.plugin.appbrand.jsapi.websocket.C10562d;
import com.tencent.p177mm.plugin.appbrand.jsapi.websocket.C10562d.C10563a;
import com.tencent.p177mm.plugin.appbrand.jsapi.websocket.C45632a;
import com.tencent.p177mm.plugin.appbrand.p281b.C45524b;
import com.tencent.p177mm.plugin.appbrand.p321l.C19538j;
import com.tencent.p177mm.plugin.appbrand.p321l.C19541k;
import com.tencent.p177mm.plugin.appbrand.p321l.C19541k.C19544c;
import com.tencent.p177mm.plugin.appbrand.p321l.C19541k.C19545a;
import com.tencent.p177mm.plugin.appbrand.p321l.C19546l;
import com.tencent.p177mm.plugin.appbrand.p321l.C38414a;
import com.tencent.p177mm.plugin.appbrand.p326n.C2402a;
import com.tencent.p177mm.plugin.appbrand.p329s.C19721r;
import com.tencent.p177mm.plugin.appbrand.p329s.C27295q;
import com.tencent.p177mm.plugin.appbrand.p329s.C27295q.C10730b;
import com.tencent.p177mm.plugin.appbrand.p329s.C27295q.C27296a;
import com.tencent.p177mm.plugin.appbrand.p332t.p914e.C10742f;
import com.tencent.p177mm.plugin.appbrand.p332t.p914e.C16696h;
import com.tencent.p177mm.plugin.appbrand.p332t.p914e.C38514a;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.smtt.sdk.TbsVideoCacheTask;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.i.f */
public final class C45604f extends C10433b {
    public static final int CTRL_INDEX = 346;
    public static final String NAME = "createSocketTask";
    public static int hRA = 0;
    public static int hRB = 1;
    private static C19545a hRy;
    private int hRC = hRA;
    private boolean hRD = false;
    private boolean hRE = false;
    private C19544c hRz;

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.i.f$a */
    public static class C10436a extends C42467ah {
        public static final int CTRL_INDEX = 348;
        public static final String NAME = "onSocketTaskStateChange";
    }

    /* renamed from: b */
    static /* synthetic */ void m84170b(C2241c c2241c, String str, String str2) {
        AppMethodBeat.m2504i(108051);
        C45604f.m84166a(c2241c, str, str2);
        AppMethodBeat.m2505o(108051);
    }

    public C45604f(int i, C19544c c19544c) {
        AppMethodBeat.m2504i(108043);
        C4990ab.m7417i("MicroMsg.JsApiCreateSocketTask", "JsApiCreateSocketTask, programType:%d", Integer.valueOf(i));
        this.hRC = i;
        this.hRz = c19544c;
        AppMethodBeat.m2505o(108043);
    }

    /* renamed from: a */
    public static void m84167a(C19545a c19545a) {
        hRy = c19545a;
    }

    public final String aBA() {
        AppMethodBeat.m2504i(108044);
        StringBuilder stringBuilder = new StringBuilder();
        C19546l.aII();
        String stringBuilder2 = stringBuilder.append(C19546l.aIA()).toString();
        AppMethodBeat.m2505o(108044);
        return stringBuilder2;
    }

    /* renamed from: OA */
    public final String mo21946OA() {
        return "socketTaskId";
    }

    /* renamed from: a */
    public static void m84165a(C2241c c2241c, String str, C45524b c45524b, String str2) {
        AppMethodBeat.m2504i(108045);
        if (c45524b == C45524b.SUSPEND || c45524b == C45524b.DESTROYED) {
            C10562d CT = C19546l.aII().mo34742CT(str);
            if (CT == null) {
                AppMethodBeat.m2505o(108045);
                return;
            }
            CT.mo22057a(CT.mo22056BS(str2));
            HashMap hashMap = new HashMap();
            hashMap.put("reason", "interrupted");
            hashMap.put("socketTaskId", str2);
            hashMap.put("state", "close");
            new C10436a().mo61032j(c2241c).mo61028AM(new JSONObject(hashMap).toString()).aCj();
        }
        AppMethodBeat.m2505o(108045);
    }

    /* renamed from: a */
    public final void mo21947a(final C2241c c2241c, JSONObject jSONObject, final String str) {
        AppMethodBeat.m2504i(108046);
        C10562d CT = C19546l.aII().mo34742CT(c2241c.getAppId());
        if (CT == null) {
            if ((this.hRC == hRA && this.hRD) || (this.hRC == hRB && this.hRE)) {
                CT = new C45632a((C38414a) c2241c.mo5937aa(C38414a.class));
            } else {
                Object c19541k = new C19541k((C38414a) c2241c.mo5937aa(C38414a.class));
            }
            C19546l aII = C19546l.aII();
            String appId = c2241c.getAppId();
            if (!aII.hGk.containsKey(appId)) {
                aII.hGk.put(appId, CT);
            }
        }
        C425181 c425181 = new C10563a() {
            boolean hRF = false;

            /* renamed from: b */
            public final void mo22067b(C16696h c16696h) {
                AppMethodBeat.m2504i(108036);
                if (C45604f.hRy != null) {
                    C45604f.hRy.mo34740d(c2241c, str);
                }
                HashMap hashMap = new HashMap();
                hashMap.put("socketTaskId", str);
                hashMap.put("state", "open");
                hashMap.put(TbsVideoCacheTask.KEY_VIDEO_CACHE_PARAM_HEADER, C45604f.m84169b((C10742f) c16696h));
                new C10436a().mo61032j(c2241c).mo61028AM(new JSONObject(hashMap).toString()).aCj();
                AppMethodBeat.m2505o(108036);
            }

            /* renamed from: a */
            public final void mo22066a(C38514a c38514a) {
                AppMethodBeat.m2504i(108037);
                if (c38514a == null || !((C38414a) c2241c.mo5937aa(C38414a.class)).bQf) {
                    AppMethodBeat.m2505o(108037);
                    return;
                }
                C18319m c18319m = new C18319m();
                c18319m.csn.cso = "socket";
                c18319m.csn.csq = C45604f.m84169b((C10742f) c38514a);
                c18319m.csn.csp = str;
                C4879a.xxA.mo10055m(c18319m);
                AppMethodBeat.m2505o(108037);
            }

            /* renamed from: zJ */
            public final void mo22069zJ(String str) {
                AppMethodBeat.m2504i(108038);
                if (this.hRF) {
                    C4990ab.m7416i("MicroMsg.JsApiCreateSocketTask", "onSocketError is true");
                    AppMethodBeat.m2505o(108038);
                    return;
                }
                this.hRF = true;
                HashMap hashMap = new HashMap();
                hashMap.put("socketTaskId", str);
                hashMap.put("state", "error");
                hashMap.put("errMsg", str);
                new C10436a().mo61032j(c2241c).mo61028AM(new JSONObject(hashMap).toString()).aCj();
                if (C45604f.this.hRD || C45604f.this.hRE) {
                    ((C2402a) C37384e.m62986C(C2402a.class)).mo6307f(972, 2, 1);
                    AppMethodBeat.m2505o(108038);
                    return;
                }
                ((C2402a) C37384e.m62986C(C2402a.class)).mo6307f(972, 1, 1);
                AppMethodBeat.m2505o(108038);
            }

            /* renamed from: BB */
            public final void mo22064BB(String str) {
                AppMethodBeat.m2504i(108039);
                HashMap hashMap = new HashMap();
                hashMap.put("data", C19721r.m30532Ei(str));
                hashMap.put("isBuffer", Boolean.FALSE);
                hashMap.put("socketTaskId", str);
                hashMap.put("state", ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
                new C10436a().mo61032j(c2241c).mo61028AM(new JSONObject(hashMap).toString()).aCj();
                AppMethodBeat.m2505o(108039);
            }

            /* renamed from: l */
            public final void mo22068l(ByteBuffer byteBuffer) {
                AppMethodBeat.m2504i(108040);
                Map hashMap = new HashMap();
                hashMap.put("socketTaskId", str);
                hashMap.put("data", byteBuffer);
                hashMap.put("isBuffer", Boolean.TRUE);
                hashMap.put("state", ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
                C10730b a = C27295q.m43333a(c2241c.aBx(), hashMap, (C27296a) c2241c.mo5937aa(C27296a.class));
                if (a == C10730b.OK) {
                    new C10436a().mo61032j(c2241c).mo61028AM(new JSONObject(hashMap).toString()).aCj();
                    AppMethodBeat.m2505o(108040);
                    return;
                }
                if (a == C10730b.FAIL_SIZE_EXCEED_LIMIT) {
                    C27295q.m43336m(c2241c, C10436a.NAME);
                }
                AppMethodBeat.m2505o(108040);
            }

            /* renamed from: K */
            public final void mo22065K(int i, String str) {
                AppMethodBeat.m2504i(108041);
                if (C45604f.hRy != null) {
                    C45604f.hRy.mo34741e(c2241c, str);
                }
                HashMap hashMap = new HashMap();
                if (C19538j.m30272b(c2241c.asD())) {
                    hashMap.put("reason", "interrupted");
                } else if (!C5046bo.isNullOrNil(str)) {
                    hashMap.put("reason", str);
                }
                hashMap.put(TMQQDownloaderOpenSDKConst.UINTYPE_CODE, Integer.valueOf(i));
                hashMap.put("socketTaskId", str);
                hashMap.put("state", "close");
                new C10436a().mo61032j(c2241c).mo61028AM(new JSONObject(hashMap).toString()).aCj();
                AppMethodBeat.m2505o(108041);
            }

            /* renamed from: zK */
            public final void mo22070zK(String str) {
                AppMethodBeat.m2504i(108042);
                C45604f.m84170b(c2241c, str, str);
                AppMethodBeat.m2505o(108042);
            }
        };
        String optString = jSONObject.optString("url");
        if (C5046bo.isNullOrNil(optString)) {
            C4990ab.m7416i("MicroMsg.JsApiCreateSocketTask", "url is null");
            C45604f.m84166a(c2241c, str, "url is null");
            AppMethodBeat.m2505o(108046);
            return;
        }
        C4990ab.m7416i("MicroMsg.JsApiCreateSocketTask", "url is ".concat(String.valueOf(optString)));
        C38414a c38414a = (C38414a) c2241c.mo5937aa(C38414a.class);
        Map a = C19538j.m30267a(jSONObject, c38414a);
        Object obj = (c38414a.ioe && jSONObject.optBoolean("__skipDomainCheck__")) ? 1 : null;
        if (!(obj != null ? false : c38414a.iof) || C19538j.m30270a(c38414a.bQG, optString, c38414a.bQB)) {
            int optInt = jSONObject.optInt("timeout", 0);
            if (optInt <= 0) {
                optInt = C19538j.m30265a(c38414a, 1);
            }
            if (optInt <= 0) {
                optInt = 60000;
            }
            CT.mo22061a(c2241c.getAppId(), str, this.hRC, optInt, jSONObject, a, c425181);
            if (this.hRD || this.hRE) {
                ((C2402a) C37384e.m62986C(C2402a.class)).mo6307f(972, 10, 1);
            } else {
                ((C2402a) C37384e.m62986C(C2402a.class)).mo6307f(972, 0, 1);
            }
            C4990ab.m7417i("MicroMsg.JsApiCreateSocketTask", "connectSocket, url is : %s , componentId: %s", optString, Integer.valueOf(c2241c.aBw()));
            AppMethodBeat.m2505o(108046);
            return;
        }
        C4990ab.m7417i("MicroMsg.JsApiCreateSocketTask", "not in domain url %s", optString);
        C45604f.m84166a(c2241c, str, "url not in domain list");
        AppMethodBeat.m2505o(108046);
    }

    /* renamed from: g */
    public final void mo31168g(C2241c c2241c) {
        AppMethodBeat.m2504i(108047);
        if (this.hRz != null) {
            this.hRD = this.hRz.mo21412xj(c2241c.getAppId());
            this.hRE = this.hRz.auB();
        }
        AppMethodBeat.m2505o(108047);
    }

    /* renamed from: a */
    private static JSONObject m84164a(C10742f c10742f) {
        AppMethodBeat.m2504i(108048);
        JSONObject jSONObject = new JSONObject();
        Iterator aOx = c10742f.aOx();
        while (aOx.hasNext()) {
            try {
                String str = (String) aOx.next();
                jSONObject.put(str, c10742f.mo22296Eq(str));
            } catch (JSONException e) {
                C4990ab.printErrStackTrace("MicroMsg.JsApiCreateSocketTask", e, "JSONExceptions ", new Object[0]);
            }
        }
        AppMethodBeat.m2505o(108048);
        return jSONObject;
    }

    /* renamed from: a */
    private static void m84166a(C2241c c2241c, String str, String str2) {
        Object obj;
        AppMethodBeat.m2504i(108049);
        if (C5046bo.isNullOrNil(str2)) {
            obj = "fail";
        } else {
            obj = "fail:".concat(String.valueOf(str2));
        }
        HashMap hashMap = new HashMap();
        hashMap.put("socketTaskId", str);
        hashMap.put("state", "error");
        hashMap.put("errMsg", obj);
        new C10436a().mo61032j(c2241c).mo61028AM(new JSONObject(hashMap).toString()).aCj();
        C4990ab.m7411d("MicroMsg.JsApiCreateSocketTask", "onSocketConnectFail jsonResult:%s ", r0);
        ((C2402a) C37384e.m62986C(C2402a.class)).mo6307f(972, 3, 1);
        AppMethodBeat.m2505o(108049);
    }
}
