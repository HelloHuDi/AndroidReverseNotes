package com.tencent.mm.plugin.luckymoney.model;

import com.tencent.luggage.g.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.atb;
import com.tencent.mm.sdk.platformtools.bo;
import org.json.JSONException;
import org.json.JSONObject;

public final class at {
    public atb nWu;
    public as nZp;

    public static at Ql(String str) {
        AppMethodBeat.i(42424);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(42424);
            return null;
        }
        try {
            at atVar = new at();
            JSONObject jSONObject = new JSONObject(str);
            JSONObject optJSONObject = jSONObject.optJSONObject("operation");
            if (optJSONObject != null) {
                atVar.nZp = v.Y(optJSONObject);
            }
            atVar.nWu = v.Z(jSONObject.optJSONObject("source"));
            AppMethodBeat.o(42424);
            return atVar;
        } catch (JSONException e) {
            d.printErrStackTrace("MicroMsg.ShowSourceOpen", e, "", new Object[0]);
            AppMethodBeat.o(42424);
            return null;
        }
    }
}
