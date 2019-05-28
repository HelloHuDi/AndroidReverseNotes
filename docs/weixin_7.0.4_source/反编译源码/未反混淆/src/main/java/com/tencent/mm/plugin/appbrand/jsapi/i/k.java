package com.tencent.mm.plugin.appbrand.jsapi.i;

import com.google.android.gms.auth.api.proxy.AuthApiStatusCodes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.websocket.d;
import com.tencent.mm.plugin.appbrand.jsapi.websocket.e;
import com.tencent.mm.plugin.appbrand.l.k.c;
import com.tencent.mm.plugin.appbrand.l.l;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import java.nio.ByteBuffer;
import org.json.JSONObject;

public final class k extends a {
    public static final int CTRL_INDEX = 347;
    public static final String NAME = "operateSocketTask";
    private boolean hRD = false;
    private boolean hRE = false;
    private c hRz;

    public k(c cVar) {
        this.hRz = cVar;
    }

    public final void a(com.tencent.mm.plugin.appbrand.jsapi.c cVar, JSONObject jSONObject, int i) {
        AppMethodBeat.i(108076);
        ab.d("MicroMsg.JsApiOperateSocketTask", "JsApiOperateSocketTask");
        if (jSONObject == null) {
            cVar.M(i, j("fail:data is null", null));
            ab.e("MicroMsg.JsApiOperateSocketTask", "data is null");
            AppMethodBeat.o(108076);
            return;
        }
        String optString = jSONObject.optString("socketTaskId");
        if (bo.isNullOrNil(optString)) {
            ab.e("MicroMsg.JsApiOperateSocketTask", "taskId is null");
            cVar.M(i, j("fail:taskId is null or nil", null));
            AppMethodBeat.o(108076);
            return;
        }
        String optString2 = jSONObject.optString("operationType");
        if (bo.isNullOrNil(optString2)) {
            ab.e("MicroMsg.JsApiOperateSocketTask", "operationType is null");
            cVar.M(i, j("fail:operationType is null or nil", null));
            AppMethodBeat.o(108076);
            return;
        }
        d CT = l.aII().CT(cVar.getAppId());
        if (CT == null) {
            cVar.M(i, j("fail:no task", null));
            ab.w("MicroMsg.JsApiOperateSocketTask", "client is null");
            AppMethodBeat.o(108076);
            return;
        }
        e BS = CT.BS(optString);
        if (BS == null) {
            cVar.M(i, j("fail:taskID not exist", null));
            ab.w("MicroMsg.JsApiOperateSocketTask", "webSocketClient is null");
            AppMethodBeat.o(108076);
        } else if (optString2.equals("close")) {
            int optInt = jSONObject.optInt(TMQQDownloaderOpenSDKConst.UINTYPE_CODE, 1000);
            if (optInt == 1000 || (optInt >= AuthApiStatusCodes.AUTH_API_INVALID_CREDENTIALS && optInt < 5000)) {
                CT.a(BS, optInt, jSONObject.optString("reason", ""));
                cVar.M(i, j("ok", null));
                ab.i("MicroMsg.JsApiOperateSocketTask", "closeSocket taskId:%s, code %d, reason %s", optString, Integer.valueOf(optInt), r4);
                AppMethodBeat.o(108076);
                return;
            }
            cVar.M(i, j("fail:The code must be either 1000, or between 3000 and 4999", null));
            AppMethodBeat.o(108076);
        } else if (!optString2.equals("send")) {
            cVar.M(i, j("fail:unknown operationType", null));
            ab.w("MicroMsg.JsApiOperateSocketTask", "sendSocketMessage fail:unknown operationType");
            AppMethodBeat.o(108076);
        } else if (CT.b(BS)) {
            Object opt = jSONObject.opt("data");
            if (opt != null) {
                try {
                    if (opt instanceof ByteBuffer) {
                        ab.i("MicroMsg.JsApiOperateSocketTask", "sendSocketMessage ok message:%s", opt);
                        CT.a(BS, (ByteBuffer) opt);
                        ((com.tencent.mm.plugin.appbrand.n.a) com.tencent.luggage.a.e.C(com.tencent.mm.plugin.appbrand.n.a.class)).f(972, 4, 1);
                    } else if (opt instanceof String) {
                        ab.i("MicroMsg.JsApiOperateSocketTask", "sendSocketMessage ok message");
                        CT.a(BS, (String) opt);
                        ((com.tencent.mm.plugin.appbrand.n.a) com.tencent.luggage.a.e.C(com.tencent.mm.plugin.appbrand.n.a.class)).f(972, 4, 1);
                    } else {
                        ab.w("MicroMsg.JsApiOperateSocketTask", "sendSocketMessage error message type wrong");
                        cVar.M(i, j("fail:unknown data", null));
                        AppMethodBeat.o(108076);
                        return;
                    }
                    cVar.M(i, j("ok", null));
                    AppMethodBeat.o(108076);
                    return;
                } catch (Exception e) {
                    cVar.M(i, j("fail:" + e.getMessage(), null));
                    if (this.hRD || this.hRE) {
                        ((com.tencent.mm.plugin.appbrand.n.a) com.tencent.luggage.a.e.C(com.tencent.mm.plugin.appbrand.n.a.class)).f(972, 6, 1);
                        AppMethodBeat.o(108076);
                        return;
                    }
                    ((com.tencent.mm.plugin.appbrand.n.a) com.tencent.luggage.a.e.C(com.tencent.mm.plugin.appbrand.n.a.class)).f(972, 5, 1);
                    AppMethodBeat.o(108076);
                    return;
                }
            }
            cVar.M(i, j("fail:message is null or nil", null));
            ab.w("MicroMsg.JsApiOperateSocketTask", "sendSocketMessage fail:%s", opt);
            AppMethodBeat.o(108076);
        } else {
            cVar.M(i, j("fail", null));
            ab.w("MicroMsg.JsApiOperateSocketTask", "send fail taskId: %s", optString);
            AppMethodBeat.o(108076);
        }
    }

    public final void g(com.tencent.mm.plugin.appbrand.jsapi.c cVar) {
        AppMethodBeat.i(108077);
        if (this.hRz != null) {
            this.hRD = this.hRz.xj(cVar.getAppId());
            this.hRE = this.hRz.auB();
        }
        AppMethodBeat.o(108077);
    }
}
