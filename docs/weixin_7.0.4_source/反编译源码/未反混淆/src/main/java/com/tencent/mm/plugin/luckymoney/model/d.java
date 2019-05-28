package com.tencent.mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.atb;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import org.json.JSONException;
import org.json.JSONObject;

public final class d {
    public atb nWu;
    public String nWv;
    public boolean nWw;
    public String nWx;

    public static d Qg(String str) {
        AppMethodBeat.i(42273);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(42273);
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            d dVar = new d();
            dVar.nWv = jSONObject.optString("showSourceMac");
            dVar.nWx = jSONObject.optString("illegal_msg");
            dVar.nWw = jSONObject.optBoolean("is_illegal");
            jSONObject = jSONObject.optJSONObject("showSource");
            if (jSONObject != null) {
                dVar.nWu = v.Z(jSONObject);
            }
            AppMethodBeat.o(42273);
            return dVar;
        } catch (JSONException e) {
            ab.printErrStackTrace("MicroMsg.EnvelopSourceMac", e, "", new Object[0]);
            AppMethodBeat.o(42273);
            return null;
        }
    }
}
