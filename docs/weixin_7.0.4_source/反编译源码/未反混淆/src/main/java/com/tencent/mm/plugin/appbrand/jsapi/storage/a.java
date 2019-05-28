package com.tencent.mm.plugin.appbrand.jsapi.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.f;
import com.tencent.mm.plugin.appbrand.appstorage.r;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import com.tencent.mm.sdk.g.d;
import org.json.JSONObject;

public final class a extends com.tencent.mm.plugin.appbrand.jsapi.a<h> {
    public static final int CTRL_INDEX = 18;
    public static final String NAME = "clearStorage";

    public final /* synthetic */ void a(c cVar, JSONObject jSONObject, int i) {
        AppMethodBeat.i(102024);
        h hVar = (h) cVar;
        int i2 = hVar.getRuntime().ye().hhe;
        int optInt = jSONObject.optInt("storageId", 0);
        if (r.nw(optInt)) {
            hVar.M(i, j("fail:nonexistent storage space", null));
            AppMethodBeat.o(102024);
            return;
        }
        if (i2 == 2) {
            a(hVar, optInt);
        } else {
            if (i2 == 3) {
                a(hVar, optInt);
            }
            MainProcessTask jsApiClearStorageTask = new JsApiClearStorageTask();
            jsApiClearStorageTask.appId = hVar.getAppId();
            jsApiClearStorageTask.hXg = optInt;
            AppBrandMainProcessService.a(jsApiClearStorageTask);
        }
        hVar.M(i, j("ok", null));
        AppMethodBeat.o(102024);
    }

    private void a(final h hVar, final int i) {
        AppMethodBeat.i(102023);
        d.post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(102022);
                f fVar = f.gXv;
                f.F(i, hVar.getAppId());
                AppMethodBeat.o(102022);
            }
        }, "JsApiClearStorage");
        AppMethodBeat.o(102023);
    }
}
