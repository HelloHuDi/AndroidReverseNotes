package com.tencent.p177mm.plugin.address.p1218e;

import android.util.Log;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.p984j.p985a.C12328b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.address.e.e */
public final class C18973e {
    /* renamed from: a */
    public static String m29545a(C12328b c12328b) {
        AppMethodBeat.m2504i(17014);
        JSONObject jSONObject = new JSONObject();
        String jSONObject2;
        if (c12328b == null) {
            jSONObject2 = jSONObject.toString();
            AppMethodBeat.m2505o(17014);
            return jSONObject2;
        }
        try {
            jSONObject.put("type", c12328b.type);
            if (c12328b.type == null || !c12328b.type.equals("1")) {
                jSONObject.put("title", c12328b.title);
                if (c12328b.nuJ != null) {
                    jSONObject.put("taxNumber", c12328b.nuJ);
                } else {
                    jSONObject.put("taxNumber", "");
                }
                if (c12328b.nuP != null) {
                    jSONObject.put("companyAddress", c12328b.nuP);
                } else {
                    jSONObject.put("companyAddress", "");
                }
                if (c12328b.nuN != null) {
                    jSONObject.put("telephone", c12328b.nuN);
                } else {
                    jSONObject.put("telephone", "");
                }
                if (c12328b.nuL != null) {
                    jSONObject.put("bankName", c12328b.nuL);
                } else {
                    jSONObject.put("bankName", "");
                }
                if (c12328b.nuK != null) {
                    jSONObject.put("bankAccount", c12328b.nuK);
                } else {
                    jSONObject.put("bankAccount", "");
                }
                jSONObject2 = jSONObject.toString();
                AppMethodBeat.m2505o(17014);
                return jSONObject2;
            }
            jSONObject.put("title", c12328b.nuI);
            jSONObject.put("taxNumber", "");
            jSONObject.put("companyAddress", "");
            jSONObject.put("telephone", "");
            jSONObject.put("bankName", "");
            jSONObject.put("bankAccount", "");
            jSONObject2 = jSONObject.toString();
            AppMethodBeat.m2505o(17014);
            return jSONObject2;
        } catch (JSONException e) {
            C4990ab.m7413e("MicroMsg.InvoiceUtil", "put json value error : %s", Log.getStackTraceString(e));
        }
    }
}
