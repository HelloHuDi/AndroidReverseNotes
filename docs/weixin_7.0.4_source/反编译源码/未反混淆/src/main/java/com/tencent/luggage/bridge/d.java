package com.tencent.luggage.bridge;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import org.json.JSONObject;

public final class d extends e {
    public d(String str, JSONObject jSONObject) {
        super(b.EVENT);
        AppMethodBeat.i(90716);
        if (TextUtils.isEmpty(str)) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("event name can not be null or empty");
            AppMethodBeat.o(90716);
            throw illegalArgumentException;
        }
        Object jSONObject2;
        if (jSONObject2 == null) {
            jSONObject2 = new JSONObject();
        }
        HashMap hashMap = new HashMap();
        hashMap.put("event", str);
        hashMap.put("data", jSONObject2);
        c(new JSONObject(hashMap));
        AppMethodBeat.o(90716);
    }
}
