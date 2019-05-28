package com.tencent.p177mm.plugin.appbrand.jsapi.h5_interact;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.ipcinvoker.C18507c;
import com.tencent.p177mm.ipcinvoker.C37866a;
import com.tencent.p177mm.ipcinvoker.type.IPCVoid;
import com.tencent.p177mm.ipcinvoker.wx_extension.service.ToolsProcessIPCService;
import com.tencent.p177mm.plugin.appbrand.C19722s;
import com.tencent.p177mm.plugin.appbrand.jsapi.C10296a;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2241c;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.h5_interact.b */
public final class C27000b extends C10296a<C19722s> {
    private static final int CTRL_INDEX = 459;
    private static final String NAME = "sendDataToH5";

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.h5_interact.b$a */
    static final class C27001a implements C37866a<SendDataToH5FromMiniProgramEvent, IPCVoid> {
        private C27001a() {
        }

        /* renamed from: a */
        public final /* synthetic */ void mo5958a(Object obj, C18507c c18507c) {
            AppMethodBeat.m2504i(131088);
            SendDataToH5FromMiniProgramEvent sendDataToH5FromMiniProgramEvent = (SendDataToH5FromMiniProgramEvent) obj;
            if (sendDataToH5FromMiniProgramEvent != null) {
                C4879a.xxA.mo10055m(sendDataToH5FromMiniProgramEvent);
            }
            AppMethodBeat.m2505o(131088);
        }
    }

    /* renamed from: a */
    public final /* synthetic */ void mo5994a(C2241c c2241c, JSONObject jSONObject, int i) {
        AppMethodBeat.m2504i(131089);
        C19722s c19722s = (C19722s) c2241c;
        if (jSONObject.has("webviewId")) {
            String appId = c19722s.getAppId();
            int optInt = jSONObject.optInt("webviewId");
            String optString = jSONObject.optString("data");
            SendDataToH5FromMiniProgramEvent sendDataToH5FromMiniProgramEvent = new SendDataToH5FromMiniProgramEvent();
            sendDataToH5FromMiniProgramEvent.hJU = appId;
            sendDataToH5FromMiniProgramEvent.data = optString;
            sendDataToH5FromMiniProgramEvent.hJV = optInt;
            ToolsProcessIPCService.m63914b(sendDataToH5FromMiniProgramEvent, C27001a.class);
            c19722s.mo6107M(i, mo73394j("ok", null));
            AppMethodBeat.m2505o(131089);
            return;
        }
        c19722s.mo6107M(i, mo73394j("fail:invalid data", null));
        C4990ab.m7412e("MicroMsg.AppBrand.JsApiSendDataToH5", "invoke with nil webviewId");
        AppMethodBeat.m2505o(131089);
    }
}
