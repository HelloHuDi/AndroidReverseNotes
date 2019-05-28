package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.s;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashMap;
import org.json.JSONObject;

public final class ai extends a<s> {
    public static final int CTRL_INDEX = 101;
    public static final String NAME = "getAppConfig";

    public final /* synthetic */ void a(c cVar, JSONObject jSONObject, int i) {
        AppMethodBeat.i(130424);
        final s sVar = (s) cVar;
        if (jSONObject == null) {
            sVar.M(i, j("fail", null));
            ab.e("MicroMsg.JsApiGetAppConfig", "data is null");
            AppMethodBeat.o(130424);
            return;
        }
        String appId = sVar.getAppId();
        final int optInt = jSONObject.optInt("type", 0);
        ab.i("MicroMsg.JsApiGetAppConfig", "getAppConfig app_id:%s,type:%d", appId, Integer.valueOf(optInt));
        if (optInt <= 0) {
            sVar.M(i, j("fail", null));
            ab.e("MicroMsg.JsApiGetAppConfig", "type %d is invalid", Integer.valueOf(optInt));
            AppMethodBeat.o(130424);
            return;
        }
        final MainProcessTask jsApiGetAppConfigTask = new JsApiGetAppConfigTask();
        jsApiGetAppConfigTask.appId = appId;
        jsApiGetAppConfigTask.type = optInt;
        jsApiGetAppConfigTask.scene = sVar.getRuntime().ya().bQn.scene;
        final int i2 = i;
        jsApiGetAppConfigTask.hww = new Runnable() {
            public final void run() {
                AppMethodBeat.i(130423);
                HashMap hashMap = new HashMap();
                hashMap.put("type", optInt);
                hashMap.put("data", jsApiGetAppConfigTask.value);
                ab.i("MicroMsg.JsApiGetAppConfig", "getAppConfig type:%d,data:\n%s", Integer.valueOf(optInt), jsApiGetAppConfigTask.value);
                if (bo.isNullOrNil(jsApiGetAppConfigTask.value)) {
                    sVar.M(i2, ai.this.j("fail", null));
                } else {
                    sVar.M(i2, ai.this.j("ok", hashMap));
                }
                jsApiGetAppConfigTask.aBW();
                AppMethodBeat.o(130423);
            }
        };
        jsApiGetAppConfigTask.aBV();
        AppBrandMainProcessService.a(jsApiGetAppConfigTask);
        AppMethodBeat.o(130424);
    }
}
