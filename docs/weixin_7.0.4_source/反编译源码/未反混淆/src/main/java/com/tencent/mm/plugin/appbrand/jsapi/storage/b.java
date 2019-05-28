package com.tencent.mm.plugin.appbrand.jsapi.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.f;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import com.tencent.mm.plugin.appbrand.jsapi.u;

public final class b extends u<h> {
    public static final int CTRL_INDEX = 18;
    public static final String NAME = "clearStorageSync";

    private String b(h hVar, int i) {
        AppMethodBeat.i(102025);
        MainProcessTask jsApiClearStorageTask = new JsApiClearStorageTask();
        jsApiClearStorageTask.appId = hVar.getAppId();
        jsApiClearStorageTask.hXg = i;
        AppBrandMainProcessService.b(jsApiClearStorageTask);
        String j = j("ok", null);
        AppMethodBeat.o(102025);
        return j;
    }

    private String c(h hVar, int i) {
        AppMethodBeat.i(102026);
        f fVar = f.gXv;
        f.F(i, hVar.getAppId());
        String j = j("ok", null);
        AppMethodBeat.o(102026);
        return j;
    }
}
