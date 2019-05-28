package com.tencent.p177mm.plugin.recharge.model;

import com.google.firebase.analytics.FirebaseAnalytics.C8741b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.recharge.model.a */
public final class C43420a {
    public static final int[] pFK = new int[]{-1, -1};
    public static final int[] pFL = new int[]{-2, -2};
    public int cvp;
    public String name;
    public String pFM;
    public String pFN;
    public int[] pFO;

    public C43420a(String str, String str2, int i) {
        this(str, str2, "", i);
    }

    public C43420a(String str, String str2, String str3, int i) {
        this.pFO = pFK;
        this.pFM = str;
        this.name = str2;
        this.pFN = str3;
        this.cvp = i;
    }

    public final JSONObject toJson() {
        AppMethodBeat.m2504i(44181);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("record", C5046bo.m7532bc(this.pFM, ""));
            jSONObject.put("name", C5046bo.m7532bc(this.name, ""));
            jSONObject.put(C8741b.LOCATION, C5046bo.m7532bc(this.pFN, ""));
            AppMethodBeat.m2505o(44181);
            return jSONObject;
        } catch (JSONException e) {
            C4990ab.printErrStackTrace("MicroMsg.MallInputRecord", e, "", new Object[0]);
            AppMethodBeat.m2505o(44181);
            return null;
        }
    }

    /* renamed from: aj */
    public static C43420a m77502aj(JSONObject jSONObject) {
        AppMethodBeat.m2504i(44182);
        String optString = jSONObject.optString("name");
        String optString2 = jSONObject.optString("record");
        String optString3 = jSONObject.optString(C8741b.LOCATION);
        if (C5046bo.isNullOrNil(optString2)) {
            AppMethodBeat.m2505o(44182);
            return null;
        }
        C43420a c43420a = new C43420a(optString2, optString, optString3, 2);
        AppMethodBeat.m2505o(44182);
        return c43420a;
    }
}
