package com.tencent.p177mm.plugin.appbrand.jsapi.bio.soter;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.bio.soter.a */
public final class C45582a {
    /* renamed from: oc */
    public static JSONArray m84099oc(int i) {
        AppMethodBeat.m2504i(3205);
        JSONArray jSONArray;
        if (i <= 0) {
            jSONArray = new JSONArray();
            AppMethodBeat.m2505o(3205);
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
        C4990ab.m7417i("MicroMsg.AppBrandSoterTranslateUtil", "hy: final string is: %s", arrayList.toString());
        jSONArray = new JSONArray(arrayList);
        AppMethodBeat.m2505o(3205);
        return jSONArray;
    }

    /* renamed from: m */
    public static String m84098m(JSONArray jSONArray) {
        AppMethodBeat.m2504i(3206);
        String str = "MicroMsg.AppBrandSoterTranslateUtil";
        String str2 = "hy: translating string array: %s";
        Object[] objArr = new Object[1];
        objArr[0] = jSONArray == null ? null : jSONArray.toString();
        C4990ab.m7417i(str, str2, objArr);
        if (jSONArray == null || jSONArray.length() == 0) {
            String str3 = "0x00";
            AppMethodBeat.m2505o(3206);
            return str3;
        }
        int i = 0;
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            try {
                i = (byte) (i | C45582a.m84097AS(jSONArray.getString(i2)));
            } catch (JSONException e) {
                C4990ab.printErrStackTrace("MicroMsg.AppBrandSoterTranslateUtil", e, "hy: json error in translate", new Object[0]);
            }
        }
        C4990ab.m7417i("MicroMsg.AppBrandSoterTranslateUtil", "hy: translated bitsetStr: %s", "0x" + Integer.toHexString(i));
        AppMethodBeat.m2505o(3206);
        return "0x" + Integer.toHexString(i);
    }

    /* renamed from: AS */
    public static int m84097AS(String str) {
        AppMethodBeat.m2504i(3207);
        if ("fingerPrint".equals(str)) {
            AppMethodBeat.m2505o(3207);
            return 1;
        } else if ("facial".equals(str)) {
            AppMethodBeat.m2505o(3207);
            return 8;
        } else if ("speech".equals(str)) {
            AppMethodBeat.m2505o(3207);
            return 2;
        } else {
            C4990ab.m7412e("MicroMsg.AppBrandSoterTranslateUtil", "hy: invalid item");
            AppMethodBeat.m2505o(3207);
            return 0;
        }
    }
}
