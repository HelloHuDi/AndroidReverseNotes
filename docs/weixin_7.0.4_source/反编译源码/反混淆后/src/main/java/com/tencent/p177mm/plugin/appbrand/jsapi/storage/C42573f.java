package com.tencent.p177mm.plugin.appbrand.jsapi.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.appstorage.C10108n.C10107a;
import com.tencent.p177mm.plugin.appbrand.appstorage.C19085f;
import com.tencent.p177mm.plugin.appbrand.appstorage.C26754q;
import com.tencent.p177mm.plugin.appbrand.appstorage.C38122r;
import com.tencent.p177mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.p177mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.p177mm.plugin.appbrand.jsapi.C10296a;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2241c;
import com.tencent.p177mm.plugin.appbrand.jsapi.C33327h;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.HashMap;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.storage.f */
public class C42573f extends C10296a<C33327h> {
    public static final int CTRL_INDEX = 17;
    public static final String NAME = "getStorage";

    /* renamed from: a */
    public final /* synthetic */ void mo5994a(C2241c c2241c, JSONObject jSONObject, int i) {
        AppMethodBeat.m2504i(102037);
        final C33327h c33327h = (C33327h) c2241c;
        final long currentTimeMillis = System.currentTimeMillis();
        final String optString = jSONObject.optString("key");
        final int optInt = jSONObject.optInt("storageId", 0);
        if (C38122r.m64503nw(optInt)) {
            c33327h.mo6107M(i, mo73394j("fail:nonexistent storage space", null));
            AppMethodBeat.m2505o(102037);
        } else if (C5046bo.isNullOrNil(optString)) {
            c33327h.mo6107M(i, mo73394j("fail:key is empty", null));
            AppMethodBeat.m2505o(102037);
        } else {
            final String u = mo34606u(c33327h);
            if (C5046bo.isNullOrNil(u)) {
                c33327h.mo6107M(i, mo73394j("fail:appID is empty", null));
                AppMethodBeat.m2505o(102037);
                return;
            }
            final long currentTimeMillis2 = System.currentTimeMillis();
            if (c33327h.getRuntime().mo15034ye().hhe != 1) {
                final int i2 = i;
                C7305d.post(new Runnable() {
                    public final void run() {
                        String str;
                        String str2;
                        AppMethodBeat.m2504i(102034);
                        C19085f c19085f = C19085f.gXv;
                        Object[] k = C19085f.m29668k(optInt, u, optString);
                        if (((C10107a) k[0]) == C10107a.NONE) {
                            str = (String) k[2];
                            str2 = (String) k[1];
                        } else {
                            str = null;
                            str2 = null;
                        }
                        C42573f.m75374a(C42573f.this, str2 == null ? "fail:data not found" : "ok", str2, str, c33327h, i2);
                        C42573f.m75373a(2, C38122r.m64499by(optString, str2), currentTimeMillis2, c33327h);
                        AppMethodBeat.m2505o(102034);
                    }
                }, "JsApiGetStorage");
                AppMethodBeat.m2505o(102037);
                return;
            }
            final MainProcessTask jsApiGetStorageTask = new JsApiGetStorageTask();
            jsApiGetStorageTask.appId = u;
            jsApiGetStorageTask.key = optString;
            jsApiGetStorageTask.hXg = optInt;
            final C33327h c33327h2 = c33327h;
            final int i3 = i;
            final String str = optString;
            final long j = currentTimeMillis2;
            jsApiGetStorageTask.hww = new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(102035);
                    C42573f.m75374a(C42573f.this, jsApiGetStorageTask.value == null ? "fail:data not found" : "ok", jsApiGetStorageTask.value, jsApiGetStorageTask.type, c33327h2, i3);
                    C42573f.m75373a(1, C38122r.m64499by(str, jsApiGetStorageTask.value), j, c33327h2);
                    jsApiGetStorageTask.aBW();
                    C4990ab.m7417i("MicroMsg.JsApiGetStorage", "getStorage: %s, time: %d", jsApiGetStorageTask.key, Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                    AppMethodBeat.m2505o(102035);
                }
            };
            jsApiGetStorageTask.aBV();
            AppBrandMainProcessService.m54349a(jsApiGetStorageTask);
            AppMethodBeat.m2505o(102037);
        }
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: u */
    public String mo34606u(C2241c c2241c) {
        AppMethodBeat.m2504i(102036);
        String appId = c2241c.getAppId();
        AppMethodBeat.m2505o(102036);
        return appId;
    }

    /* renamed from: a */
    static /* synthetic */ void m75374a(C42573f c42573f, String str, String str2, String str3, C2241c c2241c, int i) {
        Object str22;
        Object str32;
        AppMethodBeat.m2504i(102038);
        HashMap hashMap = new HashMap();
        String str4 = "data";
        if (str22 == null) {
            str22 = "";
        }
        hashMap.put(str4, str22);
        str4 = "dataType";
        if (str32 == null) {
            str32 = "";
        }
        hashMap.put(str4, str32);
        c2241c.mo6107M(i, c42573f.mo73394j(str, hashMap));
        AppMethodBeat.m2505o(102038);
    }

    /* renamed from: a */
    static /* synthetic */ void m75373a(int i, int i2, long j, C33327h c33327h) {
        AppMethodBeat.m2504i(102039);
        C26754q.m42583a(i, 2, i2, 1, System.currentTimeMillis() - j, c33327h);
        AppMethodBeat.m2505o(102039);
    }
}
