package com.tencent.p177mm.plugin.appbrand.jsapi.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.appstorage.C19085f;
import com.tencent.p177mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.p177mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.p177mm.plugin.appbrand.jsapi.C19497u;
import com.tencent.p177mm.plugin.appbrand.jsapi.C33327h;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.storage.b */
public final class C27083b extends C19497u<C33327h> {
    public static final int CTRL_INDEX = 18;
    public static final String NAME = "clearStorageSync";

    /* renamed from: b */
    private String m43033b(C33327h c33327h, int i) {
        AppMethodBeat.m2504i(102025);
        MainProcessTask jsApiClearStorageTask = new JsApiClearStorageTask();
        jsApiClearStorageTask.appId = c33327h.getAppId();
        jsApiClearStorageTask.hXg = i;
        AppBrandMainProcessService.m54355b(jsApiClearStorageTask);
        String j = mo73394j("ok", null);
        AppMethodBeat.m2505o(102025);
        return j;
    }

    /* renamed from: c */
    private String m43034c(C33327h c33327h, int i) {
        AppMethodBeat.m2504i(102026);
        C19085f c19085f = C19085f.gXv;
        C19085f.m29661F(i, c33327h.getAppId());
        String j = mo73394j("ok", null);
        AppMethodBeat.m2505o(102026);
        return j;
    }
}
