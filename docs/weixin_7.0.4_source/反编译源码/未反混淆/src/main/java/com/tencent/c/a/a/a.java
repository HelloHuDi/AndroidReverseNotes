package com.tencent.c.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONException;
import org.json.JSONObject;

final class a {
    public static String caZ = "ts";
    public static String cba = "times";
    public static String cbb = "mfreq";
    public static String cbc = "mdays";
    long caV = 0;
    int caW = 0;
    int caX = 100;
    int caY = 3;

    a() {
    }

    a(String str) {
        AppMethodBeat.i(125740);
        if (s.co(str)) {
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
                    AppMethodBeat.o(125740);
                    return;
                }
            } catch (JSONException e) {
                s.zY();
            }
            AppMethodBeat.o(125740);
            return;
        }
        AppMethodBeat.o(125740);
    }

    public final String toString() {
        AppMethodBeat.i(125741);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(caZ, this.caV);
            jSONObject.put(cba, this.caW);
            jSONObject.put(cbb, this.caX);
            jSONObject.put(cbc, this.caY);
        } catch (JSONException e) {
            s.zY();
        }
        String jSONObject2 = jSONObject.toString();
        AppMethodBeat.o(125741);
        return jSONObject2;
    }
}
