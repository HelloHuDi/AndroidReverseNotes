package com.tencent.p177mm.plugin.wxcredit.p1334a;

import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.wallet_core.tenpay.model.C5749m;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.wxcredit.a.e */
public final class C44025e extends C5749m {
    public String token;
    public List<C44027l> uYx;
    public int uYy;

    public C44025e(String str) {
        AppMethodBeat.m2504i(48661);
        HashMap hashMap = new HashMap();
        hashMap.put("bind_serialno", str);
        mo70323M(hashMap);
        AppMethodBeat.m2505o(48661);
    }

    public final int bgI() {
        return 59;
    }

    /* renamed from: a */
    public final void mo9383a(int i, String str, JSONObject jSONObject) {
        AppMethodBeat.m2504i(48662);
        C4990ab.m7410d("Micromsg.NetSceneTenpayCheckPwd", "errCode " + i + " errMsg: " + str);
        if (i != 0) {
            AppMethodBeat.m2505o(48662);
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
                    C44027l c44027l = new C44027l();
                    c44027l.f17236id = jSONObject2.getString("qt_id");
                    c44027l.uYQ = jSONObject2.getString("parent_id");
                    c44027l.type = jSONObject2.getString("qt_type");
                    c44027l.desc = jSONObject2.getString("qt_cont");
                    c44027l.uYR = jSONObject2.getInt("ans_len");
                    c44027l.kfM = jSONObject2.getString("wording");
                    c44027l.level = jSONObject2.getInt("level");
                    if (!hashMap.containsKey(c44027l.uYQ) || AppEventsConstants.EVENT_PARAM_VALUE_NO.equals(c44027l.uYQ)) {
                        hashMap.put(c44027l.f17236id, c44027l);
                    } else {
                        ((C44027l) hashMap.get(c44027l.uYQ)).uYS = c44027l;
                    }
                }
                this.uYx = new ArrayList(hashMap.values());
                hashMap.clear();
            }
            AppMethodBeat.m2505o(48662);
        } catch (JSONException e) {
            C4990ab.printErrStackTrace("Micromsg.NetSceneTenpayCheckPwd", e, "", new Object[0]);
            AppMethodBeat.m2505o(48662);
        }
    }
}
