package com.tencent.p177mm.plugin.appbrand.jsapi.p308i;

import com.google.android.gms.auth.api.proxy.AuthApiStatusCodes;
import com.tencent.luggage.p1170a.C37384e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.jsapi.C10296a;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2241c;
import com.tencent.p177mm.plugin.appbrand.jsapi.websocket.C10562d;
import com.tencent.p177mm.plugin.appbrand.jsapi.websocket.C27135e;
import com.tencent.p177mm.plugin.appbrand.p321l.C19541k.C19544c;
import com.tencent.p177mm.plugin.appbrand.p321l.C19546l;
import com.tencent.p177mm.plugin.appbrand.p326n.C2402a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import java.nio.ByteBuffer;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.i.k */
public final class C19400k extends C10296a {
    public static final int CTRL_INDEX = 347;
    public static final String NAME = "operateSocketTask";
    private boolean hRD = false;
    private boolean hRE = false;
    private C19544c hRz;

    public C19400k(C19544c c19544c) {
        this.hRz = c19544c;
    }

    /* renamed from: a */
    public final void mo5994a(C2241c c2241c, JSONObject jSONObject, int i) {
        AppMethodBeat.m2504i(108076);
        C4990ab.m7410d("MicroMsg.JsApiOperateSocketTask", "JsApiOperateSocketTask");
        if (jSONObject == null) {
            c2241c.mo6107M(i, mo73394j("fail:data is null", null));
            C4990ab.m7412e("MicroMsg.JsApiOperateSocketTask", "data is null");
            AppMethodBeat.m2505o(108076);
            return;
        }
        String optString = jSONObject.optString("socketTaskId");
        if (C5046bo.isNullOrNil(optString)) {
            C4990ab.m7412e("MicroMsg.JsApiOperateSocketTask", "taskId is null");
            c2241c.mo6107M(i, mo73394j("fail:taskId is null or nil", null));
            AppMethodBeat.m2505o(108076);
            return;
        }
        String optString2 = jSONObject.optString("operationType");
        if (C5046bo.isNullOrNil(optString2)) {
            C4990ab.m7412e("MicroMsg.JsApiOperateSocketTask", "operationType is null");
            c2241c.mo6107M(i, mo73394j("fail:operationType is null or nil", null));
            AppMethodBeat.m2505o(108076);
            return;
        }
        C10562d CT = C19546l.aII().mo34742CT(c2241c.getAppId());
        if (CT == null) {
            c2241c.mo6107M(i, mo73394j("fail:no task", null));
            C4990ab.m7420w("MicroMsg.JsApiOperateSocketTask", "client is null");
            AppMethodBeat.m2505o(108076);
            return;
        }
        C27135e BS = CT.mo22056BS(optString);
        if (BS == null) {
            c2241c.mo6107M(i, mo73394j("fail:taskID not exist", null));
            C4990ab.m7420w("MicroMsg.JsApiOperateSocketTask", "webSocketClient is null");
            AppMethodBeat.m2505o(108076);
        } else if (optString2.equals("close")) {
            int optInt = jSONObject.optInt(TMQQDownloaderOpenSDKConst.UINTYPE_CODE, 1000);
            if (optInt == 1000 || (optInt >= AuthApiStatusCodes.AUTH_API_INVALID_CREDENTIALS && optInt < 5000)) {
                CT.mo22058a(BS, optInt, jSONObject.optString("reason", ""));
                c2241c.mo6107M(i, mo73394j("ok", null));
                C4990ab.m7417i("MicroMsg.JsApiOperateSocketTask", "closeSocket taskId:%s, code %d, reason %s", optString, Integer.valueOf(optInt), r4);
                AppMethodBeat.m2505o(108076);
                return;
            }
            c2241c.mo6107M(i, mo73394j("fail:The code must be either 1000, or between 3000 and 4999", null));
            AppMethodBeat.m2505o(108076);
        } else if (!optString2.equals("send")) {
            c2241c.mo6107M(i, mo73394j("fail:unknown operationType", null));
            C4990ab.m7420w("MicroMsg.JsApiOperateSocketTask", "sendSocketMessage fail:unknown operationType");
            AppMethodBeat.m2505o(108076);
        } else if (CT.mo22062b(BS)) {
            Object opt = jSONObject.opt("data");
            if (opt != null) {
                try {
                    if (opt instanceof ByteBuffer) {
                        C4990ab.m7417i("MicroMsg.JsApiOperateSocketTask", "sendSocketMessage ok message:%s", opt);
                        CT.mo22060a(BS, (ByteBuffer) opt);
                        ((C2402a) C37384e.m62986C(C2402a.class)).mo6307f(972, 4, 1);
                    } else if (opt instanceof String) {
                        C4990ab.m7416i("MicroMsg.JsApiOperateSocketTask", "sendSocketMessage ok message");
                        CT.mo22059a(BS, (String) opt);
                        ((C2402a) C37384e.m62986C(C2402a.class)).mo6307f(972, 4, 1);
                    } else {
                        C4990ab.m7420w("MicroMsg.JsApiOperateSocketTask", "sendSocketMessage error message type wrong");
                        c2241c.mo6107M(i, mo73394j("fail:unknown data", null));
                        AppMethodBeat.m2505o(108076);
                        return;
                    }
                    c2241c.mo6107M(i, mo73394j("ok", null));
                    AppMethodBeat.m2505o(108076);
                    return;
                } catch (Exception e) {
                    c2241c.mo6107M(i, mo73394j("fail:" + e.getMessage(), null));
                    if (this.hRD || this.hRE) {
                        ((C2402a) C37384e.m62986C(C2402a.class)).mo6307f(972, 6, 1);
                        AppMethodBeat.m2505o(108076);
                        return;
                    }
                    ((C2402a) C37384e.m62986C(C2402a.class)).mo6307f(972, 5, 1);
                    AppMethodBeat.m2505o(108076);
                    return;
                }
            }
            c2241c.mo6107M(i, mo73394j("fail:message is null or nil", null));
            C4990ab.m7421w("MicroMsg.JsApiOperateSocketTask", "sendSocketMessage fail:%s", opt);
            AppMethodBeat.m2505o(108076);
        } else {
            c2241c.mo6107M(i, mo73394j("fail", null));
            C4990ab.m7421w("MicroMsg.JsApiOperateSocketTask", "send fail taskId: %s", optString);
            AppMethodBeat.m2505o(108076);
        }
    }

    /* renamed from: g */
    public final void mo31168g(C2241c c2241c) {
        AppMethodBeat.m2504i(108077);
        if (this.hRz != null) {
            this.hRD = this.hRz.mo21412xj(c2241c.getAppId());
            this.hRE = this.hRz.auB();
        }
        AppMethodBeat.m2505o(108077);
    }
}
