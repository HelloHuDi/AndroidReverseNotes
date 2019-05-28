package com.tencent.p177mm.plugin.appbrand.p329s;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.ttpic.baseutils.IOUtils;

/* renamed from: com.tencent.mm.plugin.appbrand.s.l */
public final class C42681l {
    private static String[][] iRx;

    static {
        r0 = new String[8][];
        r0[0] = new String[]{"\\", "\\\\"};
        r0[1] = new String[]{"'", "\\'"};
        r0[2] = new String[]{"\"", "\\\""};
        r0[3] = new String[]{IOUtils.LINE_SEPARATOR_UNIX, "\\n"};
        r0[4] = new String[]{"\t", "\\t"};
        r0[5] = new String[]{"\b", "\\b"};
        r0[6] = new String[]{"\f", "\\f"};
        r0[7] = new String[]{"\r", "\\r"};
        iRx = r0;
    }

    /* renamed from: Ej */
    public static String m75588Ej(String str) {
        AppMethodBeat.m2504i(87424);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(87424);
        } else {
            for (CharSequence[] charSequenceArr : iRx) {
                str = str.replace(charSequenceArr[0], charSequenceArr[1]);
            }
            AppMethodBeat.m2505o(87424);
        }
        return str;
    }
}
