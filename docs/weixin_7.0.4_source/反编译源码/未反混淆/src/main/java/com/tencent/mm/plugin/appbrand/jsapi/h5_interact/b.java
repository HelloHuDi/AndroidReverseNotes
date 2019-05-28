package com.tencent.mm.plugin.appbrand.jsapi.h5_interact;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.c;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.ipcinvoker.wx_extension.service.ToolsProcessIPCService;
import com.tencent.mm.plugin.appbrand.s;
import com.tencent.mm.sdk.platformtools.ab;
import org.json.JSONObject;

public final class b extends com.tencent.mm.plugin.appbrand.jsapi.a<s> {
    private static final int CTRL_INDEX = 459;
    private static final String NAME = "sendDataToH5";

    static final class a implements com.tencent.mm.ipcinvoker.a<SendDataToH5FromMiniProgramEvent, IPCVoid> {
        private a() {
        }

        public final /* synthetic */ void a(Object obj, c cVar) {
            AppMethodBeat.i(131088);
            SendDataToH5FromMiniProgramEvent sendDataToH5FromMiniProgramEvent = (SendDataToH5FromMiniProgramEvent) obj;
            if (sendDataToH5FromMiniProgramEvent != null) {
                com.tencent.mm.sdk.b.a.xxA.m(sendDataToH5FromMiniProgramEvent);
            }
            AppMethodBeat.o(131088);
        }
    }

    public final /* synthetic */ void a(com.tencent.mm.plugin.appbrand.jsapi.c cVar, JSONObject jSONObject, int i) {
        AppMethodBeat.i(131089);
        s sVar = (s) cVar;
        if (jSONObject.has("webviewId")) {
            String appId = sVar.getAppId();
            int optInt = jSONObject.optInt("webviewId");
            String optString = jSONObject.optString("data");
            SendDataToH5FromMiniProgramEvent sendDataToH5FromMiniProgramEvent = new SendDataToH5FromMiniProgramEvent();
            sendDataToH5FromMiniProgramEvent.hJU = appId;
            sendDataToH5FromMiniProgramEvent.data = optString;
            sendDataToH5FromMiniProgramEvent.hJV = optInt;
            ToolsProcessIPCService.b(sendDataToH5FromMiniProgramEvent, a.class);
            sVar.M(i, j("ok", null));
            AppMethodBeat.o(131089);
            return;
        }
        sVar.M(i, j("fail:invalid data", null));
        ab.e("MicroMsg.AppBrand.JsApiSendDataToH5", "invoke with nil webviewId");
        AppMethodBeat.o(131089);
    }
}
