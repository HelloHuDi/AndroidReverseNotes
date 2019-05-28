package com.tencent.mm.plugin.appbrand.jsapi.bio.soter;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import org.json.JSONArray;
import org.json.JSONException;

public final class d {
    public static String m(JSONArray jSONArray) {
        AppMethodBeat.i(73795);
        String str = "MicroMsg.AppBrandSoterTranslateUtil";
        String str2 = "hy: translating string array: %s";
        Object[] objArr = new Object[1];
        objArr[0] = jSONArray == null ? null : jSONArray.toString();
        ab.i(str, str2, objArr);
        if (jSONArray == null || jSONArray.length() == 0) {
            String str3 = "0x00";
            AppMethodBeat.o(73795);
            return str3;
        }
        int i = 0;
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            try {
                i = (byte) (i | AS(jSONArray.getString(i2)));
            } catch (JSONException e) {
                ab.printErrStackTrace("MicroMsg.AppBrandSoterTranslateUtil", e, "hy: json error in translate", new Object[0]);
            }
        }
        ab.i("MicroMsg.AppBrandSoterTranslateUtil", "hy: translated bitsetStr: %s", "0x" + Integer.toHexString(i));
        AppMethodBeat.o(73795);
        return "0x" + Integer.toHexString(i);
    }

    public static int AS(String str) {
        AppMethodBeat.i(73796);
        if ("fingerPrint".equals(str)) {
            AppMethodBeat.o(73796);
            return 1;
        } else if ("facial".equals(str)) {
            AppMethodBeat.o(73796);
            return 8;
        } else if ("speech".equals(str)) {
            AppMethodBeat.o(73796);
            return 2;
        } else {
            ab.e("MicroMsg.AppBrandSoterTranslateUtil", "hy: invalid item");
            AppMethodBeat.o(73796);
            return 0;
        }
    }
}
