package com.tencent.mm.plugin.appbrand.jsapi.bio.soter;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;

public final class a {
    public static JSONArray oc(int i) {
        AppMethodBeat.i(3205);
        JSONArray jSONArray;
        if (i <= 0) {
            jSONArray = new JSONArray();
            AppMethodBeat.o(3205);
            return jSONArray;
        }
        ArrayList arrayList = new ArrayList(3);
        if ((i & 1) == 1) {
            arrayList.add("fingerPrint");
        }
        if ((i & 8) == 8) {
            arrayList.add("facial");
        }
        if ((i & 2) == 2) {
            arrayList.add("speech");
        }
        ab.i("MicroMsg.AppBrandSoterTranslateUtil", "hy: final string is: %s", arrayList.toString());
        jSONArray = new JSONArray(arrayList);
        AppMethodBeat.o(3205);
        return jSONArray;
    }

    public static String m(JSONArray jSONArray) {
        AppMethodBeat.i(3206);
        String str = "MicroMsg.AppBrandSoterTranslateUtil";
        String str2 = "hy: translating string array: %s";
        Object[] objArr = new Object[1];
        objArr[0] = jSONArray == null ? null : jSONArray.toString();
        ab.i(str, str2, objArr);
        if (jSONArray == null || jSONArray.length() == 0) {
            String str3 = "0x00";
            AppMethodBeat.o(3206);
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
        AppMethodBeat.o(3206);
        return "0x" + Integer.toHexString(i);
    }

    public static int AS(String str) {
        AppMethodBeat.i(3207);
        if ("fingerPrint".equals(str)) {
            AppMethodBeat.o(3207);
            return 1;
        } else if ("facial".equals(str)) {
            AppMethodBeat.o(3207);
            return 8;
        } else if ("speech".equals(str)) {
            AppMethodBeat.o(3207);
            return 2;
        } else {
            ab.e("MicroMsg.AppBrandSoterTranslateUtil", "hy: invalid item");
            AppMethodBeat.o(3207);
            return 0;
        }
    }
}
