package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import org.json.JSONObject;

public final class du {
    public Map<String, Object> a = new HashMap();

    public du() {
        AppMethodBeat.i(98746);
        AppMethodBeat.o(98746);
    }

    public final byte[] a() {
        AppMethodBeat.i(98747);
        JSONObject jSONObject = new JSONObject();
        for (Entry entry : this.a.entrySet()) {
            try {
                jSONObject.put((String) entry.getKey(), entry.getValue());
            } catch (Exception e) {
            }
        }
        byte[] bytes = jSONObject.toString().getBytes();
        AppMethodBeat.o(98747);
        return bytes;
    }
}
