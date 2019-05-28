package com.tencent.mm.plugin.appbrand.s;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.ttpic.baseutils.IOUtils;

public final class l {
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

    public static String Ej(String str) {
        AppMethodBeat.i(87424);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(87424);
        } else {
            for (CharSequence[] charSequenceArr : iRx) {
                str = str.replace(charSequenceArr[0], charSequenceArr[1]);
            }
            AppMethodBeat.o(87424);
        }
        return str;
    }
}
