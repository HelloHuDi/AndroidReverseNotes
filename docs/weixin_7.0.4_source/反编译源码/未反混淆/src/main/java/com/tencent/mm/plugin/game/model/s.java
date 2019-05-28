package com.tencent.mm.plugin.game.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.gx;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.game.a.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class s {
    public static void a(gx gxVar) {
        AppMethodBeat.i(111335);
        String str = gxVar.cBD.cBy;
        ab.d("MicroMsg.GameJsapiProcessor", "writeMsg param=%s", str);
        if (str != null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.isNull("type") || bo.getInt(jSONObject.optString("type"), 0) == 0) {
                    JSONArray jSONArray = new JSONArray();
                    JSONArray jSONArray2 = jSONObject.getJSONArray("localIdList");
                    int length = jSONArray2.length();
                    long[] jArr = new long[length];
                    for (int i = 0; i < length; i++) {
                        jArr[i] = jSONArray2.getLong(i);
                    }
                    ((c) g.K(c.class)).bCY().d(jArr);
                    AppMethodBeat.o(111335);
                    return;
                } else if (bo.getInt(jSONObject.optString("type"), 0) == 65536) {
                    ((c) g.K(c.class)).bCY().hY("GameRawMessage", "update GameRawMessage set isRead=1 where 1=1");
                    AppMethodBeat.o(111335);
                    return;
                } else {
                    AppMethodBeat.o(111335);
                    return;
                }
            } catch (JSONException e) {
                ab.w("MicroMsg.GameJsapiProcessor", "JSONException : %s", e.getMessage());
                AppMethodBeat.o(111335);
                return;
            }
        }
        AppMethodBeat.o(111335);
    }
}
