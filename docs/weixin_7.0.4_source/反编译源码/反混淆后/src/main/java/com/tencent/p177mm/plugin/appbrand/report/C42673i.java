package com.tencent.p177mm.plugin.appbrand.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.util.C18178q;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.appbrand.report.i */
public final class C42673i {
    /* renamed from: DA */
    private static String m75574DA(String str) {
        AppMethodBeat.m2504i(132569);
        String str2;
        if (C5046bo.isNullOrNil(str)) {
            str2 = "";
            AppMethodBeat.m2505o(132569);
            return str2;
        }
        try {
            str2 = C5046bo.nullAsNil(C18178q.encode(str));
            AppMethodBeat.m2505o(132569);
            return str2;
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.AppBrand.ReportUtil", "safeEncode, given %s, e %s", str, e);
            str2 = "";
            AppMethodBeat.m2505o(132569);
            return str2;
        }
    }

    /* renamed from: k */
    public static Object[] m75575k(Object... objArr) {
        AppMethodBeat.m2504i(132570);
        if (objArr == null || objArr.length <= 0) {
            Object[] objArr2 = new Object[0];
            AppMethodBeat.m2505o(132570);
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
                obj = C42673i.m75574DA((String) obj);
            }
            int i3 = i2 + 1;
            objArr3[i2] = String.valueOf(obj);
            i++;
            i2 = i3;
        }
        AppMethodBeat.m2505o(132570);
        return objArr3;
    }
}
