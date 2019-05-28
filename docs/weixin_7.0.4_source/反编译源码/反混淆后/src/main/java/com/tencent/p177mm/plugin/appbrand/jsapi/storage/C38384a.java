package com.tencent.p177mm.plugin.appbrand.jsapi.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.appstorage.C19085f;
import com.tencent.p177mm.plugin.appbrand.appstorage.C38122r;
import com.tencent.p177mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.p177mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.p177mm.plugin.appbrand.jsapi.C10296a;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2241c;
import com.tencent.p177mm.plugin.appbrand.jsapi.C33327h;
import com.tencent.p177mm.sdk.p604g.C7305d;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.storage.a */
public final class C38384a extends C10296a<C33327h> {
    public static final int CTRL_INDEX = 18;
    public static final String NAME = "clearStorage";

    /* renamed from: a */
    public final /* synthetic */ void mo5994a(C2241c c2241c, JSONObject jSONObject, int i) {
        AppMethodBeat.m2504i(102024);
        C33327h c33327h = (C33327h) c2241c;
        int i2 = c33327h.getRuntime().mo15034ye().hhe;
        int optInt = jSONObject.optInt("storageId", 0);
        if (C38122r.m64503nw(optInt)) {
            c33327h.mo6107M(i, mo73394j("fail:nonexistent storage space", null));
            AppMethodBeat.m2505o(102024);
            return;
        }
        if (i2 == 2) {
            m64954a(c33327h, optInt);
        } else {
            if (i2 == 3) {
                m64954a(c33327h, optInt);
            }
            MainProcessTask jsApiClearStorageTask = new JsApiClearStorageTask();
            jsApiClearStorageTask.appId = c33327h.getAppId();
            jsApiClearStorageTask.hXg = optInt;
            AppBrandMainProcessService.m54349a(jsApiClearStorageTask);
        }
        c33327h.mo6107M(i, mo73394j("ok", null));
        AppMethodBeat.m2505o(102024);
    }

    /* renamed from: a */
    private void m64954a(final C33327h c33327h, final int i) {
        AppMethodBeat.m2504i(102023);
        C7305d.post(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(102022);
                C19085f c19085f = C19085f.gXv;
                C19085f.m29661F(i, c33327h.getAppId());
                AppMethodBeat.m2505o(102022);
            }
        }, "JsApiClearStorage");
        AppMethodBeat.m2505o(102023);
    }
}
