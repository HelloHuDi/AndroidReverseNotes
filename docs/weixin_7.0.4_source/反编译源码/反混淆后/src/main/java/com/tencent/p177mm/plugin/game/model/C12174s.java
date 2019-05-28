package com.tencent.p177mm.plugin.game.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p230g.p231a.C37722gx;
import com.tencent.p177mm.plugin.game.p1268a.C45983c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.game.model.s */
public final class C12174s {
    /* renamed from: a */
    public static void m20104a(C37722gx c37722gx) {
        AppMethodBeat.m2504i(111335);
        String str = c37722gx.cBD.cBy;
        C4990ab.m7411d("MicroMsg.GameJsapiProcessor", "writeMsg param=%s", str);
        if (str != null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.isNull("type") || C5046bo.getInt(jSONObject.optString("type"), 0) == 0) {
                    JSONArray jSONArray = new JSONArray();
                    JSONArray jSONArray2 = jSONObject.getJSONArray("localIdList");
                    int length = jSONArray2.length();
                    long[] jArr = new long[length];
                    for (int i = 0; i < length; i++) {
                        jArr[i] = jSONArray2.getLong(i);
                    }
                    ((C45983c) C1720g.m3528K(C45983c.class)).bCY().mo73902d(jArr);
                    AppMethodBeat.m2505o(111335);
                    return;
                } else if (C5046bo.getInt(jSONObject.optString("type"), 0) == 65536) {
                    ((C45983c) C1720g.m3528K(C45983c.class)).bCY().mo16768hY("GameRawMessage", "update GameRawMessage set isRead=1 where 1=1");
                    AppMethodBeat.m2505o(111335);
                    return;
                } else {
                    AppMethodBeat.m2505o(111335);
                    return;
                }
            } catch (JSONException e) {
                C4990ab.m7421w("MicroMsg.GameJsapiProcessor", "JSONException : %s", e.getMessage());
                AppMethodBeat.m2505o(111335);
                return;
            }
        }
        AppMethodBeat.m2505o(111335);
    }
}
