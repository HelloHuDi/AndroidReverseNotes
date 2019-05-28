package com.tencent.p177mm.plugin.appbrand.jsapi.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.appstorage.C19085f;
import com.tencent.p177mm.plugin.appbrand.appstorage.C26754q;
import com.tencent.p177mm.plugin.appbrand.appstorage.C38122r;
import com.tencent.p177mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.p177mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.p177mm.plugin.appbrand.jsapi.C19497u;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2241c;
import com.tencent.p177mm.plugin.appbrand.jsapi.C33327h;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.storage.h */
public final class C42575h extends C19497u<C33327h> {
    public static final int CTRL_INDEX = 113;
    public static final String NAME = "getStorageInfoSync";

    /* renamed from: b */
    public final /* synthetic */ String mo6145b(C2241c c2241c, JSONObject jSONObject) {
        AppMethodBeat.m2504i(102046);
        C33327h c33327h = (C33327h) c2241c;
        int optInt = jSONObject.optInt("storageId", 0);
        String j;
        if (C38122r.m64503nw(optInt)) {
            j = mo73394j("fail:nonexistent storage space", null);
            AppMethodBeat.m2505o(102046);
            return j;
        }
        int ceil;
        int ceil2;
        int i;
        Object obj;
        int i2;
        HashMap hashMap = new HashMap();
        long currentTimeMillis = System.currentTimeMillis();
        if (c33327h.getRuntime().mo15034ye().hhe != 1) {
            C19085f c19085f = C19085f.gXv;
            Object[] G = C19085f.m29662G(optInt, c33327h.getAppId());
            ceil = (int) Math.ceil(((Integer) G[1]).doubleValue() / 1000.0d);
            ceil2 = (int) Math.ceil(((Integer) G[2]).doubleValue() / 1000.0d);
            i = 2;
            obj = (ArrayList) G[0];
        } else {
            i = 1;
            MainProcessTask jsApiGetStorageInfoTask = new JsApiGetStorageInfoTask();
            jsApiGetStorageInfoTask.appId = c33327h.getAppId();
            jsApiGetStorageInfoTask.hXg = optInt;
            AppBrandMainProcessService.m54355b(jsApiGetStorageInfoTask);
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
        C26754q.m42583a(i, 3, i3, i2, System.currentTimeMillis() - currentTimeMillis, c33327h);
        hashMap.put("keys", obj2);
        hashMap.put("currentSize", Integer.valueOf(ceil));
        hashMap.put("limitSize", Integer.valueOf(ceil2));
        j = mo73394j("ok", hashMap);
        AppMethodBeat.m2505o(102046);
        return j;
    }
}
