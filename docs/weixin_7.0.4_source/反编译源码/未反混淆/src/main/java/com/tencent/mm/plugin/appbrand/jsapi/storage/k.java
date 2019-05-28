package com.tencent.mm.plugin.appbrand.jsapi.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.f;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import com.tencent.mm.sdk.g.d;

public class k extends a<h> {
    public static final int CTRL_INDEX = 98;
    public static final String NAME = "removeStorage";

    private void a(h hVar, String str, int i) {
        AppMethodBeat.i(102061);
        MainProcessTask jsApiRemoveStorageTask = new JsApiRemoveStorageTask();
        jsApiRemoveStorageTask.appId = u(hVar);
        jsApiRemoveStorageTask.hXg = i;
        jsApiRemoveStorageTask.key = str;
        AppBrandMainProcessService.a(jsApiRemoveStorageTask);
        AppMethodBeat.o(102061);
    }

    private void b(final h hVar, final String str, final int i) {
        AppMethodBeat.i(102062);
        d.post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(102060);
                f fVar = f.gXv;
                f.l(i, k.this.u(hVar), str);
                AppMethodBeat.o(102060);
            }
        }, "JsApiRemoveStorage");
        AppMethodBeat.o(102062);
    }

    /* Access modifiers changed, original: protected */
    public String u(c cVar) {
        AppMethodBeat.i(102063);
        String appId = cVar.getAppId();
        AppMethodBeat.o(102063);
        return appId;
    }
}
