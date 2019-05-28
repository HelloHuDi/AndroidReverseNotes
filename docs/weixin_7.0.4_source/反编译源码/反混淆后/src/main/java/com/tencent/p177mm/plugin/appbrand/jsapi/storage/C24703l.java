package com.tencent.p177mm.plugin.appbrand.jsapi.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.appstorage.C19085f;
import com.tencent.p177mm.plugin.appbrand.appstorage.C38122r;
import com.tencent.p177mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.p177mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.p177mm.plugin.appbrand.jsapi.C19497u;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2241c;
import com.tencent.p177mm.plugin.appbrand.jsapi.C33327h;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.storage.l */
public final class C24703l extends C19497u<C33327h> {
    public static final int CTRL_INDEX = 98;
    public static final String NAME = "removeStorageSync";

    /* renamed from: b */
    public final /* synthetic */ String mo6145b(C2241c c2241c, JSONObject jSONObject) {
        AppMethodBeat.m2504i(102066);
        C33327h c33327h = (C33327h) c2241c;
        String optString = jSONObject.optString("key");
        int optInt = jSONObject.optInt("storageId", 0);
        if (C5046bo.isNullOrNil(optString)) {
            optString = mo73394j("fail", null);
            AppMethodBeat.m2505o(102066);
            return optString;
        } else if (C38122r.m64503nw(optInt)) {
            optString = mo73394j("fail:nonexistent storage space", null);
            AppMethodBeat.m2505o(102066);
            return optString;
        } else {
            int i = c33327h.getRuntime().mo15034ye().hhe;
            if (i == 2) {
                C24703l.m38564b(c33327h, optString, optInt);
            } else {
                if (i == 3) {
                    C24703l.m38564b(c33327h, optString, optInt);
                }
                MainProcessTask jsApiRemoveStorageTask = new JsApiRemoveStorageTask();
                jsApiRemoveStorageTask.appId = c33327h.getAppId();
                jsApiRemoveStorageTask.hXg = optInt;
                jsApiRemoveStorageTask.key = optString;
                AppBrandMainProcessService.m54355b(jsApiRemoveStorageTask);
            }
            optString = mo73394j("ok", null);
            AppMethodBeat.m2505o(102066);
            return optString;
        }
    }

    /* renamed from: b */
    private static void m38564b(C33327h c33327h, String str, int i) {
        AppMethodBeat.m2504i(102065);
        C19085f c19085f = C19085f.gXv;
        C19085f.m29669l(i, c33327h.getAppId(), str);
        AppMethodBeat.m2505o(102065);
    }
}
