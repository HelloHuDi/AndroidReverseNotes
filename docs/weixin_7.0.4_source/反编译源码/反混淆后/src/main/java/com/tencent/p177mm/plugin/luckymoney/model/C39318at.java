package com.tencent.p177mm.plugin.luckymoney.model;

import com.tencent.luggage.p147g.C45124d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.protocal.protobuf.atb;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.luckymoney.model.at */
public final class C39318at {
    public atb nWu;
    public C43255as nZp;

    /* renamed from: Ql */
    public static C39318at m66994Ql(String str) {
        AppMethodBeat.m2504i(42424);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(42424);
            return null;
        }
        try {
            C39318at c39318at = new C39318at();
            JSONObject jSONObject = new JSONObject(str);
            JSONObject optJSONObject = jSONObject.optJSONObject("operation");
            if (optJSONObject != null) {
                c39318at.nZp = C43263v.m77010Y(optJSONObject);
            }
            c39318at.nWu = C43263v.m77011Z(jSONObject.optJSONObject("source"));
            AppMethodBeat.m2505o(42424);
            return c39318at;
        } catch (JSONException e) {
            C45124d.printErrStackTrace("MicroMsg.ShowSourceOpen", e, "", new Object[0]);
            AppMethodBeat.m2505o(42424);
            return null;
        }
    }
}
