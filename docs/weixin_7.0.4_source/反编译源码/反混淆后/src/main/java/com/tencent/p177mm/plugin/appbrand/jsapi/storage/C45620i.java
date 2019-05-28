package com.tencent.p177mm.plugin.appbrand.jsapi.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.appstorage.C10108n.C10107a;
import com.tencent.p177mm.plugin.appbrand.appstorage.C19085f;
import com.tencent.p177mm.plugin.appbrand.appstorage.C26754q;
import com.tencent.p177mm.plugin.appbrand.appstorage.C38122r;
import com.tencent.p177mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.p177mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.p177mm.plugin.appbrand.jsapi.C19497u;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2241c;
import com.tencent.p177mm.plugin.appbrand.jsapi.C33327h;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.HashMap;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.storage.i */
public final class C45620i extends C19497u<C33327h> {
    public static final int CTRL_INDEX = 17;
    public static final String NAME = "getStorageSync";

    /* renamed from: b */
    public final /* synthetic */ String mo6145b(C2241c c2241c, JSONObject jSONObject) {
        AppMethodBeat.m2504i(102053);
        C33327h c33327h = (C33327h) c2241c;
        String optString = jSONObject.optString("key");
        int optInt = jSONObject.optInt("storageId", 0);
        String j;
        if (C5046bo.isNullOrNil(optString)) {
            j = mo73394j("fail:key is empty", null);
            AppMethodBeat.m2505o(102053);
            return j;
        } else if (C38122r.m64503nw(optInt)) {
            j = mo73394j("fail:nonexistent storage space", null);
            AppMethodBeat.m2505o(102053);
            return j;
        } else {
            String appId = c33327h.getAppId();
            if (C5046bo.isNullOrNil(appId)) {
                j = mo73394j("fail:appID is empty", null);
                AppMethodBeat.m2505o(102053);
                return j;
            }
            Object obj;
            Object obj2;
            long currentTimeMillis = System.currentTimeMillis();
            String str;
            if (c33327h.getRuntime().mo15034ye().hhe != 1) {
                C19085f c19085f = C19085f.gXv;
                Object[] k = C19085f.m29668k(optInt, appId, optString);
                if (((C10107a) k[0]) == C10107a.NONE) {
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
                AppBrandMainProcessService.m54355b(jsApiGetStorageTask);
                str2 = jsApiGetStorageTask.value;
                optInt = 1;
                String obj3 = jsApiGetStorageTask.type;
                String obj22 = str2;
            }
            C26754q.m42583a(optInt, 2, C38122r.m64499by(optString, obj22), 1, System.currentTimeMillis() - currentTimeMillis, c33327h);
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
            j = mo73394j(j, hashMap);
            AppMethodBeat.m2505o(102053);
            return j;
        }
    }
}
