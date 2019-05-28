package com.tencent.p124c.p125a.p126a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.c.a.a.a */
final class C25593a {
    public static String caZ = "ts";
    public static String cba = "times";
    public static String cbb = "mfreq";
    public static String cbc = "mdays";
    long caV = 0;
    int caW = 0;
    int caX = 100;
    int caY = 3;

    C25593a() {
    }

    C25593a(String str) {
        AppMethodBeat.m2504i(125740);
        if (C0916s.m2085co(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (!jSONObject.isNull(caZ)) {
                    this.caV = jSONObject.getLong(caZ);
                }
                if (!jSONObject.isNull(cbb)) {
                    this.caX = jSONObject.getInt(cbb);
                }
                if (!jSONObject.isNull(cba)) {
                    this.caW = jSONObject.getInt(cba);
                }
                if (!jSONObject.isNull(cbc)) {
                    this.caY = jSONObject.getInt(cbc);
                    AppMethodBeat.m2505o(125740);
                    return;
                }
            } catch (JSONException e) {
                C0916s.m2089zY();
            }
            AppMethodBeat.m2505o(125740);
            return;
        }
        AppMethodBeat.m2505o(125740);
    }

    public final String toString() {
        AppMethodBeat.m2504i(125741);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(caZ, this.caV);
            jSONObject.put(cba, this.caW);
            jSONObject.put(cbb, this.caX);
            jSONObject.put(cbc, this.caY);
        } catch (JSONException e) {
            C0916s.m2089zY();
        }
        String jSONObject2 = jSONObject.toString();
        AppMethodBeat.m2505o(125741);
        return jSONObject2;
    }
}
