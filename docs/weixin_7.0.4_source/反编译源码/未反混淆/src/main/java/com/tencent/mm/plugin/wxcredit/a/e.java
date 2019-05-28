package com.tencent.mm.plugin.wxcredit.a;

import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class e extends m {
    public String token;
    public List<l> uYx;
    public int uYy;

    public e(String str) {
        AppMethodBeat.i(48661);
        HashMap hashMap = new HashMap();
        hashMap.put("bind_serialno", str);
        M(hashMap);
        AppMethodBeat.o(48661);
    }

    public final int bgI() {
        return 59;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        AppMethodBeat.i(48662);
        ab.d("Micromsg.NetSceneTenpayCheckPwd", "errCode " + i + " errMsg: " + str);
        if (i != 0) {
            AppMethodBeat.o(48662);
            return;
        }
        try {
            this.token = jSONObject.getString("session_key");
            this.uYy = jSONObject.optInt("answer_times_left", -1);
            JSONArray jSONArray = jSONObject.getJSONArray("Array");
            if (jSONArray != null && jSONArray.length() > 0) {
                HashMap hashMap = new HashMap();
                int length = jSONArray.length();
                for (int i2 = 0; i2 < length; i2++) {
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i2);
                    l lVar = new l();
                    lVar.id = jSONObject2.getString("qt_id");
                    lVar.uYQ = jSONObject2.getString("parent_id");
                    lVar.type = jSONObject2.getString("qt_type");
                    lVar.desc = jSONObject2.getString("qt_cont");
                    lVar.uYR = jSONObject2.getInt("ans_len");
                    lVar.kfM = jSONObject2.getString("wording");
                    lVar.level = jSONObject2.getInt("level");
                    if (!hashMap.containsKey(lVar.uYQ) || AppEventsConstants.EVENT_PARAM_VALUE_NO.equals(lVar.uYQ)) {
                        hashMap.put(lVar.id, lVar);
                    } else {
                        ((l) hashMap.get(lVar.uYQ)).uYS = lVar;
                    }
                }
                this.uYx = new ArrayList(hashMap.values());
                hashMap.clear();
            }
            AppMethodBeat.o(48662);
        } catch (JSONException e) {
            ab.printErrStackTrace("Micromsg.NetSceneTenpayCheckPwd", e, "", new Object[0]);
            AppMethodBeat.o(48662);
        }
    }
}
