package com.tencent.mm.plugin.appbrand.jsapi.storage;

import com.tencent.luggage.sdk.b.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.f;
import com.tencent.mm.plugin.appbrand.appstorage.q;
import com.tencent.mm.plugin.appbrand.appstorage.r;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import com.tencent.mm.plugin.appbrand.jsapi.u;
import com.tencent.mm.sdk.platformtools.bo;
import org.json.JSONObject;

public final class o extends u<h> {
    public static final int CTRL_INDEX = 16;
    public static final String NAME = "setStorageSync";

    public final /* synthetic */ String b(c cVar, JSONObject jSONObject) {
        AppMethodBeat.i(102083);
        h hVar = (h) cVar;
        String optString = jSONObject.optString("key");
        String optString2 = jSONObject.optString("data");
        String optString3 = jSONObject.optString("dataType");
        int optInt = jSONObject.optInt("storageId", 0);
        String j;
        if (bo.isNullOrNil(optString)) {
            j = j("fail:key is empty", null);
            AppMethodBeat.o(102083);
            return j;
        } else if (r.nw(optInt)) {
            j = j("fail:nonexistent storage space", null);
            AppMethodBeat.o(102083);
            return j;
        } else if (bo.isNullOrNil(hVar.getAppId())) {
            j = j("fail:appID is empty", null);
            AppMethodBeat.o(102083);
            return j;
        } else {
            if ((optString2 == null ? 0 : optString2.length()) + optString.length() > ((b) hVar.getRuntime()).xZ().bQO.hfL) {
                j = j("fail:entry size limit reached", null);
                AppMethodBeat.o(102083);
                return j;
            }
            int i = hVar.getRuntime().ye().hhe;
            if (i == 2) {
                j = b(hVar, optString, optString2, optString3, optInt);
            } else if (i == 3) {
                j = b(hVar, optString, optString2, optString3, optInt);
                a(hVar, optString, optString2, optString3, optInt);
            } else {
                j = a(hVar, optString, optString2, optString3, optInt);
            }
            j = j(j, null);
            AppMethodBeat.o(102083);
            return j;
        }
    }

    private static String a(h hVar, String str, String str2, String str3, int i) {
        AppMethodBeat.i(102081);
        long currentTimeMillis = System.currentTimeMillis();
        try {
            MainProcessTask jsApiSetStorageTask = new JsApiSetStorageTask();
            jsApiSetStorageTask.appId = hVar.getAppId();
            jsApiSetStorageTask.hXg = i;
            jsApiSetStorageTask.C(str, str2, str3);
            if (AppBrandMainProcessService.b(jsApiSetStorageTask)) {
                String str4 = jsApiSetStorageTask.result;
                q.a(1, 1, r.by(str, str2), 1, System.currentTimeMillis() - currentTimeMillis, hVar);
                AppMethodBeat.o(102081);
                return str4;
            }
            q.a(1, 1, r.by(str, str2), 1, System.currentTimeMillis() - currentTimeMillis, hVar);
            AppMethodBeat.o(102081);
            return "fail";
        } catch (Throwable th) {
            Throwable th2 = th;
            q.a(1, 1, r.by(str, str2), 1, System.currentTimeMillis() - currentTimeMillis, hVar);
            AppMethodBeat.o(102081);
        }
    }

    private static String b(h hVar, String str, String str2, String str3, int i) {
        AppMethodBeat.i(102082);
        long currentTimeMillis = System.currentTimeMillis();
        try {
            f fVar = f.gXv;
            String a = p.a(f.b(i, hVar.getAppId(), str, str2, str3));
            q.a(2, 1, r.by(str, str2), 1, System.currentTimeMillis() - currentTimeMillis, hVar);
            AppMethodBeat.o(102082);
            return a;
        } catch (Throwable th) {
            Throwable th2 = th;
            q.a(2, 1, r.by(str, str2), 1, System.currentTimeMillis() - currentTimeMillis, hVar);
            AppMethodBeat.o(102082);
        }
    }
}
