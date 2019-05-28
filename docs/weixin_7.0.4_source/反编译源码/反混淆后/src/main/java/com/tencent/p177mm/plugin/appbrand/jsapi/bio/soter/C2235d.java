package com.tencent.p177mm.plugin.appbrand.jsapi.bio.soter;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import org.json.JSONArray;
import org.json.JSONException;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.bio.soter.d */
public final class C2235d {
    /* renamed from: m */
    public static String m4450m(JSONArray jSONArray) {
        AppMethodBeat.m2504i(73795);
        String str = "MicroMsg.AppBrandSoterTranslateUtil";
        String str2 = "hy: translating string array: %s";
        Object[] objArr = new Object[1];
        objArr[0] = jSONArray == null ? null : jSONArray.toString();
        C4990ab.m7417i(str, str2, objArr);
        if (jSONArray == null || jSONArray.length() == 0) {
            String str3 = "0x00";
            AppMethodBeat.m2505o(73795);
            return str3;
        }
        int i = 0;
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            try {
                i = (byte) (i | C2235d.m4449AS(jSONArray.getString(i2)));
            } catch (JSONException e) {
                C4990ab.printErrStackTrace("MicroMsg.AppBrandSoterTranslateUtil", e, "hy: json error in translate", new Object[0]);
            }
        }
        C4990ab.m7417i("MicroMsg.AppBrandSoterTranslateUtil", "hy: translated bitsetStr: %s", "0x" + Integer.toHexString(i));
        AppMethodBeat.m2505o(73795);
        return "0x" + Integer.toHexString(i);
    }

    /* renamed from: AS */
    public static int m4449AS(String str) {
        AppMethodBeat.m2504i(73796);
        if ("fingerPrint".equals(str)) {
            AppMethodBeat.m2505o(73796);
            return 1;
        } else if ("facial".equals(str)) {
            AppMethodBeat.m2505o(73796);
            return 8;
        } else if ("speech".equals(str)) {
            AppMethodBeat.m2505o(73796);
            return 2;
        } else {
            C4990ab.m7412e("MicroMsg.AppBrandSoterTranslateUtil", "hy: invalid item");
            AppMethodBeat.m2505o(73796);
            return 0;
        }
    }
}
