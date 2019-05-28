package com.tencent.mm.plugin.address.e;

import android.util.Log;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.j.a.b;
import com.tencent.mm.sdk.platformtools.ab;
import org.json.JSONException;
import org.json.JSONObject;

public final class e {
    public static String a(b bVar) {
        AppMethodBeat.i(17014);
        JSONObject jSONObject = new JSONObject();
        String jSONObject2;
        if (bVar == null) {
            jSONObject2 = jSONObject.toString();
            AppMethodBeat.o(17014);
            return jSONObject2;
        }
        try {
            jSONObject.put("type", bVar.type);
            if (bVar.type == null || !bVar.type.equals("1")) {
                jSONObject.put("title", bVar.title);
                if (bVar.nuJ != null) {
                    jSONObject.put("taxNumber", bVar.nuJ);
                } else {
                    jSONObject.put("taxNumber", "");
                }
                if (bVar.nuP != null) {
                    jSONObject.put("companyAddress", bVar.nuP);
                } else {
                    jSONObject.put("companyAddress", "");
                }
                if (bVar.nuN != null) {
                    jSONObject.put("telephone", bVar.nuN);
                } else {
                    jSONObject.put("telephone", "");
                }
                if (bVar.nuL != null) {
                    jSONObject.put("bankName", bVar.nuL);
                } else {
                    jSONObject.put("bankName", "");
                }
                if (bVar.nuK != null) {
                    jSONObject.put("bankAccount", bVar.nuK);
                } else {
                    jSONObject.put("bankAccount", "");
                }
                jSONObject2 = jSONObject.toString();
                AppMethodBeat.o(17014);
                return jSONObject2;
            }
            jSONObject.put("title", bVar.nuI);
            jSONObject.put("taxNumber", "");
            jSONObject.put("companyAddress", "");
            jSONObject.put("telephone", "");
            jSONObject.put("bankName", "");
            jSONObject.put("bankAccount", "");
            jSONObject2 = jSONObject.toString();
            AppMethodBeat.o(17014);
            return jSONObject2;
        } catch (JSONException e) {
            ab.e("MicroMsg.InvoiceUtil", "put json value error : %s", Log.getStackTraceString(e));
        }
    }
}
