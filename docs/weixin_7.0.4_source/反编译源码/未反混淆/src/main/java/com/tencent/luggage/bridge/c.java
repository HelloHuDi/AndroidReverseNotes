package com.tencent.luggage.bridge;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

final class c extends e {
    c(int i, String str, JSONObject jSONObject, boolean z) {
        super(b.CALLBACK);
        AppMethodBeat.i(90715);
        HashMap hashMap = new HashMap();
        hashMap.put("callbackId", Integer.valueOf(i));
        if (!TextUtils.isEmpty(str)) {
            hashMap.put("error", str);
        }
        if (jSONObject != null) {
            hashMap.put("data", jSONObject);
        }
        hashMap.put("keepCallback", Boolean.valueOf(z));
        c((Map) hashMap);
        AppMethodBeat.o(90715);
    }
}
