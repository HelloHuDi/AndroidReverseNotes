package com.tencent.mm.plugin.appbrand.jsapi.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.f;
import com.tencent.mm.plugin.appbrand.appstorage.r;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import com.tencent.mm.plugin.appbrand.jsapi.u;
import com.tencent.mm.sdk.platformtools.bo;
import org.json.JSONObject;

public final class l extends u<h> {
    public static final int CTRL_INDEX = 98;
    public static final String NAME = "removeStorageSync";

    public final /* synthetic */ String b(c cVar, JSONObject jSONObject) {
        AppMethodBeat.i(102066);
        h hVar = (h) cVar;
        String optString = jSONObject.optString("key");
        int optInt = jSONObject.optInt("storageId", 0);
        if (bo.isNullOrNil(optString)) {
            optString = j("fail", null);
            AppMethodBeat.o(102066);
            return optString;
        } else if (r.nw(optInt)) {
            optString = j("fail:nonexistent storage space", null);
            AppMethodBeat.o(102066);
            return optString;
        } else {
            int i = hVar.getRuntime().ye().hhe;
            if (i == 2) {
                b(hVar, optString, optInt);
            } else {
                if (i == 3) {
                    b(hVar, optString, optInt);
                }
                MainProcessTask jsApiRemoveStorageTask = new JsApiRemoveStorageTask();
                jsApiRemoveStorageTask.appId = hVar.getAppId();
                jsApiRemoveStorageTask.hXg = optInt;
                jsApiRemoveStorageTask.key = optString;
                AppBrandMainProcessService.b(jsApiRemoveStorageTask);
            }
            optString = j("ok", null);
            AppMethodBeat.o(102066);
            return optString;
        }
    }

    private static void b(h hVar, String str, int i) {
        AppMethodBeat.i(102065);
        f fVar = f.gXv;
        f.l(i, hVar.getAppId(), str);
        AppMethodBeat.o(102065);
    }
}
