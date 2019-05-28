package com.tencent.mm.plugin.recharge.model;

import com.google.firebase.analytics.FirebaseAnalytics.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import org.json.JSONException;
import org.json.JSONObject;

public final class a {
    public static final int[] pFK = new int[]{-1, -1};
    public static final int[] pFL = new int[]{-2, -2};
    public int cvp;
    public String name;
    public String pFM;
    public String pFN;
    public int[] pFO;

    public a(String str, String str2, int i) {
        this(str, str2, "", i);
    }

    public a(String str, String str2, String str3, int i) {
        this.pFO = pFK;
        this.pFM = str;
        this.name = str2;
        this.pFN = str3;
        this.cvp = i;
    }

    public final JSONObject toJson() {
        AppMethodBeat.i(44181);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("record", bo.bc(this.pFM, ""));
            jSONObject.put("name", bo.bc(this.name, ""));
            jSONObject.put(b.LOCATION, bo.bc(this.pFN, ""));
            AppMethodBeat.o(44181);
            return jSONObject;
        } catch (JSONException e) {
            ab.printErrStackTrace("MicroMsg.MallInputRecord", e, "", new Object[0]);
            AppMethodBeat.o(44181);
            return null;
        }
    }

    public static a aj(JSONObject jSONObject) {
        AppMethodBeat.i(44182);
        String optString = jSONObject.optString("name");
        String optString2 = jSONObject.optString("record");
        String optString3 = jSONObject.optString(b.LOCATION);
        if (bo.isNullOrNil(optString2)) {
            AppMethodBeat.o(44182);
            return null;
        }
        a aVar = new a(optString2, optString, optString3, 2);
        AppMethodBeat.o(44182);
        return aVar;
    }
}
