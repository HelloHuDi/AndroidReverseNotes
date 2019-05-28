package com.tencent.luggage.bridge;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* renamed from: com.tencent.luggage.bridge.c */
final class C25682c extends C45118e {
    C25682c(int i, String str, JSONObject jSONObject, boolean z) {
        super(C8857b.CALLBACK);
        AppMethodBeat.m2504i(90715);
        HashMap hashMap = new HashMap();
        hashMap.put("callbackId", Integer.valueOf(i));
        if (!TextUtils.isEmpty(str)) {
            hashMap.put("error", str);
        }
        if (jSONObject != null) {
            hashMap.put("data", jSONObject);
        }
        hashMap.put("keepCallback", Boolean.valueOf(z));
        mo72928c((Map) hashMap);
        AppMethodBeat.m2505o(90715);
    }
}
