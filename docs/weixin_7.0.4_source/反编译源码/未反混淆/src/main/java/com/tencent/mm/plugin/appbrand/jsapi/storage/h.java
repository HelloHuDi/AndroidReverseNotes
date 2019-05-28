package com.tencent.mm.plugin.appbrand.jsapi.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.f;
import com.tencent.mm.plugin.appbrand.appstorage.q;
import com.tencent.mm.plugin.appbrand.appstorage.r;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.u;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONObject;

public final class h extends u<com.tencent.mm.plugin.appbrand.jsapi.h> {
    public static final int CTRL_INDEX = 113;
    public static final String NAME = "getStorageInfoSync";

    public final /* synthetic */ String b(c cVar, JSONObject jSONObject) {
        AppMethodBeat.i(102046);
        com.tencent.mm.plugin.appbrand.jsapi.h hVar = (com.tencent.mm.plugin.appbrand.jsapi.h) cVar;
        int optInt = jSONObject.optInt("storageId", 0);
        String j;
        if (r.nw(optInt)) {
            j = j("fail:nonexistent storage space", null);
            AppMethodBeat.o(102046);
            return j;
        }
        int ceil;
        int ceil2;
        int i;
        Object obj;
        int i2;
        HashMap hashMap = new HashMap();
        long currentTimeMillis = System.currentTimeMillis();
        if (hVar.getRuntime().ye().hhe != 1) {
            f fVar = f.gXv;
            Object[] G = f.G(optInt, hVar.getAppId());
            ceil = (int) Math.ceil(((Integer) G[1]).doubleValue() / 1000.0d);
            ceil2 = (int) Math.ceil(((Integer) G[2]).doubleValue() / 1000.0d);
            i = 2;
            obj = (ArrayList) G[0];
        } else {
            i = 1;
            MainProcessTask jsApiGetStorageInfoTask = new JsApiGetStorageInfoTask();
            jsApiGetStorageInfoTask.appId = hVar.getAppId();
            jsApiGetStorageInfoTask.hXg = optInt;
            AppBrandMainProcessService.b(jsApiGetStorageInfoTask);
            ArrayList arrayList = jsApiGetStorageInfoTask.hXl;
            ceil = jsApiGetStorageInfoTask.size;
            ceil2 = jsApiGetStorageInfoTask.limit;
            ArrayList obj2 = arrayList;
        }
        int i3 = ceil * 1000;
        if (obj2 == null) {
            i2 = 0;
        } else {
            i2 = obj2.size();
        }
        q.a(i, 3, i3, i2, System.currentTimeMillis() - currentTimeMillis, hVar);
        hashMap.put("keys", obj2);
        hashMap.put("currentSize", Integer.valueOf(ceil));
        hashMap.put("limitSize", Integer.valueOf(ceil2));
        j = j("ok", hashMap);
        AppMethodBeat.o(102046);
        return j;
    }
}
