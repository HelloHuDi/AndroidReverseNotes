package com.tencent.mm.plugin.appbrand.jsapi.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.f;
import com.tencent.mm.plugin.appbrand.appstorage.n.a;
import com.tencent.mm.plugin.appbrand.appstorage.q;
import com.tencent.mm.plugin.appbrand.appstorage.r;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import com.tencent.mm.plugin.appbrand.jsapi.u;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashMap;
import org.json.JSONObject;

public final class i extends u<h> {
    public static final int CTRL_INDEX = 17;
    public static final String NAME = "getStorageSync";

    public final /* synthetic */ String b(c cVar, JSONObject jSONObject) {
        AppMethodBeat.i(102053);
        h hVar = (h) cVar;
        String optString = jSONObject.optString("key");
        int optInt = jSONObject.optInt("storageId", 0);
        String j;
        if (bo.isNullOrNil(optString)) {
            j = j("fail:key is empty", null);
            AppMethodBeat.o(102053);
            return j;
        } else if (r.nw(optInt)) {
            j = j("fail:nonexistent storage space", null);
            AppMethodBeat.o(102053);
            return j;
        } else {
            String appId = hVar.getAppId();
            if (bo.isNullOrNil(appId)) {
                j = j("fail:appID is empty", null);
                AppMethodBeat.o(102053);
                return j;
            }
            Object obj;
            Object obj2;
            long currentTimeMillis = System.currentTimeMillis();
            String str;
            if (hVar.getRuntime().ye().hhe != 1) {
                f fVar = f.gXv;
                Object[] k = f.k(optInt, appId, optString);
                if (((a) k[0]) == a.NONE) {
                    j = (String) k[1];
                    appId = (String) k[2];
                    str = j;
                } else {
                    appId = null;
                    Object str2 = null;
                }
                optInt = 2;
                obj = appId;
                obj2 = str2;
            } else {
                MainProcessTask jsApiGetStorageTask = new JsApiGetStorageTask();
                jsApiGetStorageTask.appId = appId;
                jsApiGetStorageTask.hXg = optInt;
                jsApiGetStorageTask.key = optString;
                AppBrandMainProcessService.b(jsApiGetStorageTask);
                str2 = jsApiGetStorageTask.value;
                optInt = 1;
                String obj3 = jsApiGetStorageTask.type;
                String obj22 = str2;
            }
            q.a(optInt, 2, r.by(optString, obj22), 1, System.currentTimeMillis() - currentTimeMillis, hVar);
            j = obj22 == null ? "fail:data not found" : "ok";
            HashMap hashMap = new HashMap();
            appId = "data";
            if (obj22 == null) {
                obj22 = "";
            }
            hashMap.put(appId, obj22);
            appId = "dataType";
            if (obj3 == null) {
                obj3 = "";
            }
            hashMap.put(appId, obj3);
            j = j(j, hashMap);
            AppMethodBeat.o(102053);
            return j;
        }
    }
}
