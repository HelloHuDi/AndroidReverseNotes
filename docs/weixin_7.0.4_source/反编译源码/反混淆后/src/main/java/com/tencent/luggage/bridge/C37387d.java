package com.tencent.luggage.bridge;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import org.json.JSONObject;

/* renamed from: com.tencent.luggage.bridge.d */
public final class C37387d extends C45118e {
    public C37387d(String str, JSONObject jSONObject) {
        super(C8857b.EVENT);
        AppMethodBeat.m2504i(90716);
        if (TextUtils.isEmpty(str)) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("event name can not be null or empty");
            AppMethodBeat.m2505o(90716);
            throw illegalArgumentException;
        }
        Object jSONObject2;
        if (jSONObject2 == null) {
            jSONObject2 = new JSONObject();
        }
        HashMap hashMap = new HashMap();
        hashMap.put("event", str);
        hashMap.put("data", jSONObject2);
        mo72929c(new JSONObject(hashMap));
        AppMethodBeat.m2505o(90716);
    }
}
