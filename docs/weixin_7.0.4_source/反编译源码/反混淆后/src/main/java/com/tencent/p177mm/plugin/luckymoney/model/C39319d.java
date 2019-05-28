package com.tencent.p177mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.protocal.protobuf.atb;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.luckymoney.model.d */
public final class C39319d {
    public atb nWu;
    public String nWv;
    public boolean nWw;
    public String nWx;

    /* renamed from: Qg */
    public static C39319d m66995Qg(String str) {
        AppMethodBeat.m2504i(42273);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(42273);
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            C39319d c39319d = new C39319d();
            c39319d.nWv = jSONObject.optString("showSourceMac");
            c39319d.nWx = jSONObject.optString("illegal_msg");
            c39319d.nWw = jSONObject.optBoolean("is_illegal");
            jSONObject = jSONObject.optJSONObject("showSource");
            if (jSONObject != null) {
                c39319d.nWu = C43263v.m77011Z(jSONObject);
            }
            AppMethodBeat.m2505o(42273);
            return c39319d;
        } catch (JSONException e) {
            C4990ab.printErrStackTrace("MicroMsg.EnvelopSourceMac", e, "", new Object[0]);
            AppMethodBeat.m2505o(42273);
            return null;
        }
    }
}
