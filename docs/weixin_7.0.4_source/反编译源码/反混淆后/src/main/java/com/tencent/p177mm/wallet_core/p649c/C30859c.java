package com.tencent.p177mm.wallet_core.p649c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.wallet_core.c.c */
public final class C30859c {
    public String Afl = "";
    public String Afm = "";
    public String Afn = "";
    public String cBF = "";
    public String title = "";

    public C30859c(String str) {
        AppMethodBeat.m2504i(49036);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(49036);
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.title = jSONObject.optString("title");
            this.Afl = jSONObject.optString("body1");
            this.Afm = jSONObject.optString("body2");
            this.Afn = jSONObject.optString("button");
            AppMethodBeat.m2505o(49036);
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.CrtRtnWoding", "crtwoding error %s", e.getMessage());
            AppMethodBeat.m2505o(49036);
        }
    }
}
