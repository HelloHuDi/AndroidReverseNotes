package com.tencent.p177mm.plugin.appbrand.jsapi.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.appstorage.C19085f;
import com.tencent.p177mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.p177mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.p177mm.plugin.appbrand.jsapi.C10296a;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2241c;
import com.tencent.p177mm.plugin.appbrand.jsapi.C33327h;
import com.tencent.p177mm.sdk.p604g.C7305d;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.storage.k */
public class C27085k extends C10296a<C33327h> {
    public static final int CTRL_INDEX = 98;
    public static final String NAME = "removeStorage";

    /* renamed from: a */
    private void m43037a(C33327h c33327h, String str, int i) {
        AppMethodBeat.m2504i(102061);
        MainProcessTask jsApiRemoveStorageTask = new JsApiRemoveStorageTask();
        jsApiRemoveStorageTask.appId = mo34607u(c33327h);
        jsApiRemoveStorageTask.hXg = i;
        jsApiRemoveStorageTask.key = str;
        AppBrandMainProcessService.m54349a(jsApiRemoveStorageTask);
        AppMethodBeat.m2505o(102061);
    }

    /* renamed from: b */
    private void m43038b(final C33327h c33327h, final String str, final int i) {
        AppMethodBeat.m2504i(102062);
        C7305d.post(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(102060);
                C19085f c19085f = C19085f.gXv;
                C19085f.m29669l(i, C27085k.this.mo34607u(c33327h), str);
                AppMethodBeat.m2505o(102060);
            }
        }, "JsApiRemoveStorage");
        AppMethodBeat.m2505o(102062);
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: u */
    public String mo34607u(C2241c c2241c) {
        AppMethodBeat.m2504i(102063);
        String appId = c2241c.getAppId();
        AppMethodBeat.m2505o(102063);
        return appId;
    }
}
