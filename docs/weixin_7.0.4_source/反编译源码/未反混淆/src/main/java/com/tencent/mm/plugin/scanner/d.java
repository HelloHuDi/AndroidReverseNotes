package com.tencent.mm.plugin.scanner;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.zero.b.a;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Arrays;

public final class d {
    public static boolean cgx() {
        AppMethodBeat.i(138579);
        int i = ((a) g.K(a.class)).Nu().getInt("EnableSessionPicTranslation", 0);
        String value = ((a) g.K(a.class)).Nu().getValue("SessionPicTranslationSupportUserLanguage");
        String str = "MicroMsg.ScannerHelper";
        String str2 = "enable %s, support lang %s, current lang %s";
        Object[] objArr = new Object[3];
        objArr[0] = Boolean.valueOf(i == 1);
        objArr[1] = value;
        objArr[2] = aa.dor();
        ab.i(str, str2, objArr);
        if (i == 1 && !bo.isNullOrNil(value)) {
            String[] split = value.split(";");
            if (split != null && Arrays.asList(split).contains(aa.dor())) {
                AppMethodBeat.o(138579);
                return true;
            }
        }
        if (com.tencent.mm.protocal.d.vxs) {
            AppMethodBeat.o(138579);
            return true;
        }
        AppMethodBeat.o(138579);
        return false;
    }
}
