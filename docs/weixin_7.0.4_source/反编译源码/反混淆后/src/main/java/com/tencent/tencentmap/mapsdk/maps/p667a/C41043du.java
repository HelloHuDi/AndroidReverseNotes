package com.tencent.tencentmap.mapsdk.maps.p667a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import org.json.JSONObject;

/* renamed from: com.tencent.tencentmap.mapsdk.maps.a.du */
public final class C41043du {
    /* renamed from: a */
    public Map<String, Object> f16467a = new HashMap();

    public C41043du() {
        AppMethodBeat.m2504i(98746);
        AppMethodBeat.m2505o(98746);
    }

    /* renamed from: a */
    public final byte[] mo65132a() {
        AppMethodBeat.m2504i(98747);
        JSONObject jSONObject = new JSONObject();
        for (Entry entry : this.f16467a.entrySet()) {
            try {
                jSONObject.put((String) entry.getKey(), entry.getValue());
            } catch (Exception e) {
            }
        }
        byte[] bytes = jSONObject.toString().getBytes();
        AppMethodBeat.m2505o(98747);
        return bytes;
    }
}
