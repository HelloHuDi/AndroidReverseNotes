package com.tencent.p177mm.plugin.appbrand.jsapi.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.appstorage.C19085f;
import com.tencent.p177mm.plugin.appbrand.appstorage.C26754q;
import com.tencent.p177mm.plugin.appbrand.appstorage.C38122r;
import com.tencent.p177mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.p177mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.p177mm.plugin.appbrand.jsapi.C10296a;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2241c;
import com.tencent.p177mm.plugin.appbrand.jsapi.C33327h;
import com.tencent.p177mm.sdk.p604g.C7305d;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.storage.g */
public class C42574g extends C10296a<C33327h> {
    public static final int CTRL_INDEX = 113;
    public static final String NAME = "getStorageInfo";

    /* renamed from: a */
    public final /* synthetic */ void mo5994a(C2241c c2241c, JSONObject jSONObject, int i) {
        AppMethodBeat.m2504i(102043);
        final C33327h c33327h = (C33327h) c2241c;
        final int optInt = jSONObject.optInt("storageId", 0);
        if (C38122r.m64503nw(optInt)) {
            c33327h.mo6107M(i, mo73394j("fail:nonexistent storage space", null));
            AppMethodBeat.m2505o(102043);
            return;
        }
        final long currentTimeMillis = System.currentTimeMillis();
        final int i2;
        if (c33327h.getRuntime().mo15034ye().hhe != 1) {
            i2 = i;
            C7305d.post(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(102040);
                    C19085f c19085f = C19085f.gXv;
                    Object[] G = C19085f.m29662G(optInt, c33327h.getAppId());
                    ArrayList arrayList = (ArrayList) G[0];
                    int ceil = (int) Math.ceil(((Integer) G[1]).doubleValue() / 1000.0d);
                    C42574g.m75378a(C42574g.this, arrayList, ceil, (int) Math.ceil(((Integer) G[2]).doubleValue() / 1000.0d), c33327h, i2);
                    C42574g.m75377a(2, arrayList, ceil * 1000, currentTimeMillis, c33327h);
                    AppMethodBeat.m2505o(102040);
                }
            }, "JsApiGetStorageInfo");
            AppMethodBeat.m2505o(102043);
            return;
        }
        MainProcessTask jsApiGetStorageInfoTask = new JsApiGetStorageInfoTask();
        jsApiGetStorageInfoTask.appId = mo44747u(c33327h);
        jsApiGetStorageInfoTask.hXg = optInt;
        final MainProcessTask mainProcessTask = jsApiGetStorageInfoTask;
        i2 = i;
        jsApiGetStorageInfoTask.hww = new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(102041);
                C42574g.m75378a(C42574g.this, mainProcessTask.hXl, mainProcessTask.size, mainProcessTask.limit, c33327h, i2);
                C42574g.m75377a(1, mainProcessTask.hXl, mainProcessTask.size * 1000, currentTimeMillis, c33327h);
                AppMethodBeat.m2505o(102041);
            }
        };
        jsApiGetStorageInfoTask.aBV();
        AppBrandMainProcessService.m54349a(jsApiGetStorageInfoTask);
        AppMethodBeat.m2505o(102043);
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: u */
    public String mo44747u(C2241c c2241c) {
        AppMethodBeat.m2504i(102042);
        String appId = c2241c.getAppId();
        AppMethodBeat.m2505o(102042);
        return appId;
    }

    /* renamed from: a */
    static /* synthetic */ void m75378a(C42574g c42574g, ArrayList arrayList, int i, int i2, C2241c c2241c, int i3) {
        AppMethodBeat.m2504i(102044);
        HashMap hashMap = new HashMap();
        hashMap.put("keys", arrayList);
        hashMap.put("currentSize", Integer.valueOf(i));
        hashMap.put("limitSize", Integer.valueOf(i2));
        c2241c.mo6107M(i3, c42574g.mo73394j("ok", hashMap));
        AppMethodBeat.m2505o(102044);
    }

    /* renamed from: a */
    static /* synthetic */ void m75377a(int i, ArrayList arrayList, int i2, long j, C33327h c33327h) {
        int i3;
        AppMethodBeat.m2504i(102045);
        if (arrayList == null) {
            i3 = 0;
        } else {
            i3 = arrayList.size();
        }
        C26754q.m42583a(i, 3, i2, i3, System.currentTimeMillis() - j, c33327h);
        AppMethodBeat.m2505o(102045);
    }
}
