package com.tencent.mm.plugin.appbrand.jsapi.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.n;
import com.tencent.mm.plugin.appbrand.appstorage.q;
import com.tencent.mm.plugin.appbrand.appstorage.r;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashMap;
import org.json.JSONObject;

public class f extends a<h> {
    public static final int CTRL_INDEX = 17;
    public static final String NAME = "getStorage";

    public final /* synthetic */ void a(c cVar, JSONObject jSONObject, int i) {
        AppMethodBeat.i(102037);
        final h hVar = (h) cVar;
        final long currentTimeMillis = System.currentTimeMillis();
        final String optString = jSONObject.optString("key");
        final int optInt = jSONObject.optInt("storageId", 0);
        if (r.nw(optInt)) {
            hVar.M(i, j("fail:nonexistent storage space", null));
            AppMethodBeat.o(102037);
        } else if (bo.isNullOrNil(optString)) {
            hVar.M(i, j("fail:key is empty", null));
            AppMethodBeat.o(102037);
        } else {
            final String u = u(hVar);
            if (bo.isNullOrNil(u)) {
                hVar.M(i, j("fail:appID is empty", null));
                AppMethodBeat.o(102037);
                return;
            }
            final long currentTimeMillis2 = System.currentTimeMillis();
            if (hVar.getRuntime().ye().hhe != 1) {
                final int i2 = i;
                d.post(new Runnable() {
                    public final void run() {
                        String str;
                        String str2;
                        AppMethodBeat.i(102034);
                        com.tencent.mm.plugin.appbrand.appstorage.f fVar = com.tencent.mm.plugin.appbrand.appstorage.f.gXv;
                        Object[] k = com.tencent.mm.plugin.appbrand.appstorage.f.k(optInt, u, optString);
                        if (((n.a) k[0]) == n.a.NONE) {
                            str = (String) k[2];
                            str2 = (String) k[1];
                        } else {
                            str = null;
                            str2 = null;
                        }
                        f.a(f.this, str2 == null ? "fail:data not found" : "ok", str2, str, hVar, i2);
                        f.a(2, r.by(optString, str2), currentTimeMillis2, hVar);
                        AppMethodBeat.o(102034);
                    }
                }, "JsApiGetStorage");
                AppMethodBeat.o(102037);
                return;
            }
            final MainProcessTask jsApiGetStorageTask = new JsApiGetStorageTask();
            jsApiGetStorageTask.appId = u;
            jsApiGetStorageTask.key = optString;
            jsApiGetStorageTask.hXg = optInt;
            final h hVar2 = hVar;
            final int i3 = i;
            final String str = optString;
            final long j = currentTimeMillis2;
            jsApiGetStorageTask.hww = new Runnable() {
                public final void run() {
                    AppMethodBeat.i(102035);
                    f.a(f.this, jsApiGetStorageTask.value == null ? "fail:data not found" : "ok", jsApiGetStorageTask.value, jsApiGetStorageTask.type, hVar2, i3);
                    f.a(1, r.by(str, jsApiGetStorageTask.value), j, hVar2);
                    jsApiGetStorageTask.aBW();
                    ab.i("MicroMsg.JsApiGetStorage", "getStorage: %s, time: %d", jsApiGetStorageTask.key, Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                    AppMethodBeat.o(102035);
                }
            };
            jsApiGetStorageTask.aBV();
            AppBrandMainProcessService.a(jsApiGetStorageTask);
            AppMethodBeat.o(102037);
        }
    }

    /* Access modifiers changed, original: protected */
    public String u(c cVar) {
        AppMethodBeat.i(102036);
        String appId = cVar.getAppId();
        AppMethodBeat.o(102036);
        return appId;
    }

    static /* synthetic */ void a(f fVar, String str, String str2, String str3, c cVar, int i) {
        Object str22;
        Object str32;
        AppMethodBeat.i(102038);
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
        cVar.M(i, fVar.j(str, hashMap));
        AppMethodBeat.o(102038);
    }

    static /* synthetic */ void a(int i, int i2, long j, h hVar) {
        AppMethodBeat.i(102039);
        q.a(i, 2, i2, 1, System.currentTimeMillis() - j, hVar);
        AppMethodBeat.o(102039);
    }
}
