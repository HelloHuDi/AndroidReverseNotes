package com.tencent.mm.plugin.appbrand.jsapi.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.f;
import com.tencent.mm.plugin.appbrand.appstorage.q;
import com.tencent.mm.plugin.appbrand.appstorage.r;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import com.tencent.mm.sdk.g.d;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONObject;

public class g extends a<h> {
    public static final int CTRL_INDEX = 113;
    public static final String NAME = "getStorageInfo";

    public final /* synthetic */ void a(c cVar, JSONObject jSONObject, int i) {
        AppMethodBeat.i(102043);
        final h hVar = (h) cVar;
        final int optInt = jSONObject.optInt("storageId", 0);
        if (r.nw(optInt)) {
            hVar.M(i, j("fail:nonexistent storage space", null));
            AppMethodBeat.o(102043);
            return;
        }
        final long currentTimeMillis = System.currentTimeMillis();
        final int i2;
        if (hVar.getRuntime().ye().hhe != 1) {
            i2 = i;
            d.post(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(102040);
                    f fVar = f.gXv;
                    Object[] G = f.G(optInt, hVar.getAppId());
                    ArrayList arrayList = (ArrayList) G[0];
                    int ceil = (int) Math.ceil(((Integer) G[1]).doubleValue() / 1000.0d);
                    g.a(g.this, arrayList, ceil, (int) Math.ceil(((Integer) G[2]).doubleValue() / 1000.0d), hVar, i2);
                    g.a(2, arrayList, ceil * 1000, currentTimeMillis, hVar);
                    AppMethodBeat.o(102040);
                }
            }, "JsApiGetStorageInfo");
            AppMethodBeat.o(102043);
            return;
        }
        MainProcessTask jsApiGetStorageInfoTask = new JsApiGetStorageInfoTask();
        jsApiGetStorageInfoTask.appId = u(hVar);
        jsApiGetStorageInfoTask.hXg = optInt;
        final MainProcessTask mainProcessTask = jsApiGetStorageInfoTask;
        i2 = i;
        jsApiGetStorageInfoTask.hww = new Runnable() {
            public final void run() {
                AppMethodBeat.i(102041);
                g.a(g.this, mainProcessTask.hXl, mainProcessTask.size, mainProcessTask.limit, hVar, i2);
                g.a(1, mainProcessTask.hXl, mainProcessTask.size * 1000, currentTimeMillis, hVar);
                AppMethodBeat.o(102041);
            }
        };
        jsApiGetStorageInfoTask.aBV();
        AppBrandMainProcessService.a(jsApiGetStorageInfoTask);
        AppMethodBeat.o(102043);
    }

    /* Access modifiers changed, original: protected */
    public String u(c cVar) {
        AppMethodBeat.i(102042);
        String appId = cVar.getAppId();
        AppMethodBeat.o(102042);
        return appId;
    }

    static /* synthetic */ void a(g gVar, ArrayList arrayList, int i, int i2, c cVar, int i3) {
        AppMethodBeat.i(102044);
        HashMap hashMap = new HashMap();
        hashMap.put("keys", arrayList);
        hashMap.put("currentSize", Integer.valueOf(i));
        hashMap.put("limitSize", Integer.valueOf(i2));
        cVar.M(i3, gVar.j("ok", hashMap));
        AppMethodBeat.o(102044);
    }

    static /* synthetic */ void a(int i, ArrayList arrayList, int i2, long j, h hVar) {
        int i3;
        AppMethodBeat.i(102045);
        if (arrayList == null) {
            i3 = 0;
        } else {
            i3 = arrayList.size();
        }
        q.a(i, 3, i2, i3, System.currentTimeMillis() - j, hVar);
        AppMethodBeat.o(102045);
    }
}
