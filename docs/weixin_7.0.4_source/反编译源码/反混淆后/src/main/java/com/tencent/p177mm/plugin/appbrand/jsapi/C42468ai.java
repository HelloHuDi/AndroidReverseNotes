package com.tencent.p177mm.plugin.appbrand.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.C19722s;
import com.tencent.p177mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.p177mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.HashMap;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.ai */
public final class C42468ai extends C10296a<C19722s> {
    public static final int CTRL_INDEX = 101;
    public static final String NAME = "getAppConfig";

    /* renamed from: a */
    public final /* synthetic */ void mo5994a(C2241c c2241c, JSONObject jSONObject, int i) {
        AppMethodBeat.m2504i(130424);
        final C19722s c19722s = (C19722s) c2241c;
        if (jSONObject == null) {
            c19722s.mo6107M(i, mo73394j("fail", null));
            C4990ab.m7412e("MicroMsg.JsApiGetAppConfig", "data is null");
            AppMethodBeat.m2505o(130424);
            return;
        }
        String appId = c19722s.getAppId();
        final int optInt = jSONObject.optInt("type", 0);
        C4990ab.m7417i("MicroMsg.JsApiGetAppConfig", "getAppConfig app_id:%s,type:%d", appId, Integer.valueOf(optInt));
        if (optInt <= 0) {
            c19722s.mo6107M(i, mo73394j("fail", null));
            C4990ab.m7413e("MicroMsg.JsApiGetAppConfig", "type %d is invalid", Integer.valueOf(optInt));
            AppMethodBeat.m2505o(130424);
            return;
        }
        final MainProcessTask jsApiGetAppConfigTask = new JsApiGetAppConfigTask();
        jsApiGetAppConfigTask.appId = appId;
        jsApiGetAppConfigTask.type = optInt;
        jsApiGetAppConfigTask.scene = c19722s.getRuntime().mo43491ya().bQn.scene;
        final int i2 = i;
        jsApiGetAppConfigTask.hww = new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(130423);
                HashMap hashMap = new HashMap();
                hashMap.put("type", optInt);
                hashMap.put("data", jsApiGetAppConfigTask.value);
                C4990ab.m7417i("MicroMsg.JsApiGetAppConfig", "getAppConfig type:%d,data:\n%s", Integer.valueOf(optInt), jsApiGetAppConfigTask.value);
                if (C5046bo.isNullOrNil(jsApiGetAppConfigTask.value)) {
                    c19722s.mo6107M(i2, C42468ai.this.mo73394j("fail", null));
                } else {
                    c19722s.mo6107M(i2, C42468ai.this.mo73394j("ok", hashMap));
                }
                jsApiGetAppConfigTask.aBW();
                AppMethodBeat.m2505o(130423);
            }
        };
        jsApiGetAppConfigTask.aBV();
        AppBrandMainProcessService.m54349a(jsApiGetAppConfigTask);
        AppMethodBeat.m2505o(130424);
    }
}
