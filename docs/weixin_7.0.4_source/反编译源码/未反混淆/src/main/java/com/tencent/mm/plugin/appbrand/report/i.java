package com.tencent.mm.plugin.appbrand.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.q;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class i {
    private static String DA(String str) {
        AppMethodBeat.i(132569);
        String str2;
        if (bo.isNullOrNil(str)) {
            str2 = "";
            AppMethodBeat.o(132569);
            return str2;
        }
        try {
            str2 = bo.nullAsNil(q.encode(str));
            AppMethodBeat.o(132569);
            return str2;
        } catch (Exception e) {
            ab.e("MicroMsg.AppBrand.ReportUtil", "safeEncode, given %s, e %s", str, e);
            str2 = "";
            AppMethodBeat.o(132569);
            return str2;
        }
    }

    public static Object[] k(Object... objArr) {
        AppMethodBeat.i(132570);
        if (objArr == null || objArr.length <= 0) {
            Object[] objArr2 = new Object[0];
            AppMethodBeat.o(132570);
            return objArr2;
        }
        Object[] objArr3 = new Object[objArr.length];
        int length = objArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            Object obj = objArr[i];
            if (obj == null) {
                obj = "";
            } else if ((obj instanceof String) && (((String) obj).contains(",") || ((String) obj).contains("/"))) {
                obj = DA((String) obj);
            }
            int i3 = i2 + 1;
            objArr3[i2] = String.valueOf(obj);
            i++;
            i2 = i3;
        }
        AppMethodBeat.o(132570);
        return objArr3;
    }
}
