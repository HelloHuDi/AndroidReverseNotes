package com.tencent.p177mm.plugin.scanner;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.plugin.zero.p757b.C7234a;
import com.tencent.p177mm.protocal.C7243d;
import com.tencent.p177mm.sdk.platformtools.C4988aa;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.Arrays;

/* renamed from: com.tencent.mm.plugin.scanner.d */
public final class C43487d {
    public static boolean cgx() {
        AppMethodBeat.m2504i(138579);
        int i = ((C7234a) C1720g.m3528K(C7234a.class)).mo15608Nu().getInt("EnableSessionPicTranslation", 0);
        String value = ((C7234a) C1720g.m3528K(C7234a.class)).mo15608Nu().getValue("SessionPicTranslationSupportUserLanguage");
        String str = "MicroMsg.ScannerHelper";
        String str2 = "enable %s, support lang %s, current lang %s";
        Object[] objArr = new Object[3];
        objArr[0] = Boolean.valueOf(i == 1);
        objArr[1] = value;
        objArr[2] = C4988aa.dor();
        C4990ab.m7417i(str, str2, objArr);
        if (i == 1 && !C5046bo.isNullOrNil(value)) {
            String[] split = value.split(";");
            if (split != null && Arrays.asList(split).contains(C4988aa.dor())) {
                AppMethodBeat.m2505o(138579);
                return true;
            }
        }
        if (C7243d.vxs) {
            AppMethodBeat.m2505o(138579);
            return true;
        }
        AppMethodBeat.m2505o(138579);
        return false;
    }
}
