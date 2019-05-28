package com.tencent.p177mm.plugin.appbrand.jsapi.storage;

import com.tencent.luggage.sdk.p148b.C25697b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.appstorage.C19085f;
import com.tencent.p177mm.plugin.appbrand.appstorage.C26754q;
import com.tencent.p177mm.plugin.appbrand.appstorage.C38122r;
import com.tencent.p177mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.p177mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.p177mm.plugin.appbrand.jsapi.C19497u;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2241c;
import com.tencent.p177mm.plugin.appbrand.jsapi.C33327h;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.storage.o */
public final class C38386o extends C19497u<C33327h> {
    public static final int CTRL_INDEX = 16;
    public static final String NAME = "setStorageSync";

    /* renamed from: b */
    public final /* synthetic */ String mo6145b(C2241c c2241c, JSONObject jSONObject) {
        AppMethodBeat.m2504i(102083);
        C33327h c33327h = (C33327h) c2241c;
        String optString = jSONObject.optString("key");
        String optString2 = jSONObject.optString("data");
        String optString3 = jSONObject.optString("dataType");
        int optInt = jSONObject.optInt("storageId", 0);
        String j;
        if (C5046bo.isNullOrNil(optString)) {
            j = mo73394j("fail:key is empty", null);
            AppMethodBeat.m2505o(102083);
            return j;
        } else if (C38122r.m64503nw(optInt)) {
            j = mo73394j("fail:nonexistent storage space", null);
            AppMethodBeat.m2505o(102083);
            return j;
        } else if (C5046bo.isNullOrNil(c33327h.getAppId())) {
            j = mo73394j("fail:appID is empty", null);
            AppMethodBeat.m2505o(102083);
            return j;
        } else {
            if ((optString2 == null ? 0 : optString2.length()) + optString.length() > ((C25697b) c33327h.getRuntime()).mo43489xZ().bQO.hfL) {
                j = mo73394j("fail:entry size limit reached", null);
                AppMethodBeat.m2505o(102083);
                return j;
            }
            int i = c33327h.getRuntime().mo15034ye().hhe;
            if (i == 2) {
                j = C38386o.m64957b(c33327h, optString, optString2, optString3, optInt);
            } else if (i == 3) {
                j = C38386o.m64957b(c33327h, optString, optString2, optString3, optInt);
                C38386o.m64956a(c33327h, optString, optString2, optString3, optInt);
            } else {
                j = C38386o.m64956a(c33327h, optString, optString2, optString3, optInt);
            }
            j = mo73394j(j, null);
            AppMethodBeat.m2505o(102083);
            return j;
        }
    }

    /* renamed from: a */
    private static String m64956a(C33327h c33327h, String str, String str2, String str3, int i) {
        AppMethodBeat.m2504i(102081);
        long currentTimeMillis = System.currentTimeMillis();
        try {
            MainProcessTask jsApiSetStorageTask = new JsApiSetStorageTask();
            jsApiSetStorageTask.appId = c33327h.getAppId();
            jsApiSetStorageTask.hXg = i;
            jsApiSetStorageTask.mo53868C(str, str2, str3);
            if (AppBrandMainProcessService.m54355b(jsApiSetStorageTask)) {
                String str4 = jsApiSetStorageTask.result;
                C26754q.m42583a(1, 1, C38122r.m64499by(str, str2), 1, System.currentTimeMillis() - currentTimeMillis, c33327h);
                AppMethodBeat.m2505o(102081);
                return str4;
            }
            C26754q.m42583a(1, 1, C38122r.m64499by(str, str2), 1, System.currentTimeMillis() - currentTimeMillis, c33327h);
            AppMethodBeat.m2505o(102081);
            return "fail";
        } catch (Throwable th) {
            Throwable th2 = th;
            C26754q.m42583a(1, 1, C38122r.m64499by(str, str2), 1, System.currentTimeMillis() - currentTimeMillis, c33327h);
            AppMethodBeat.m2505o(102081);
        }
    }

    /* renamed from: b */
    private static String m64957b(C33327h c33327h, String str, String str2, String str3, int i) {
        AppMethodBeat.m2504i(102082);
        long currentTimeMillis = System.currentTimeMillis();
        try {
            C19085f c19085f = C19085f.gXv;
            String a = C45621p.m84206a(C19085f.m29665b(i, c33327h.getAppId(), str, str2, str3));
            C26754q.m42583a(2, 1, C38122r.m64499by(str, str2), 1, System.currentTimeMillis() - currentTimeMillis, c33327h);
            AppMethodBeat.m2505o(102082);
            return a;
        } catch (Throwable th) {
            Throwable th2 = th;
            C26754q.m42583a(2, 1, C38122r.m64499by(str, str2), 1, System.currentTimeMillis() - currentTimeMillis, c33327h);
            AppMethodBeat.m2505o(102082);
        }
    }
}
