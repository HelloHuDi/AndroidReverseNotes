package com.tencent.p177mm.plugin.remittance.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.remittance.model.ab */
public final class C13047ab {
    /* renamed from: VQ */
    public static void m21032VQ(String str) {
        AppMethodBeat.m2504i(44799);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(44799);
            return;
        }
        String cfr = C13047ab.cfr();
        C4990ab.m7410d("Micromsg.RemittanceLogic", "cur friendsListStr=".concat(String.valueOf(cfr)));
        StringBuilder stringBuilder = new StringBuilder();
        if (!C5046bo.isNullOrNil(cfr)) {
            String[] split = cfr.split(",");
            if (split != null) {
                int i = 0;
                for (int i2 = 0; i2 < split.length; i2++) {
                    if (!str.equals(split[i2])) {
                        stringBuilder.append(split[i2]);
                        stringBuilder.append(",");
                        i++;
                        if (i >= 4) {
                            break;
                        }
                    }
                }
            }
        }
        stringBuilder.insert(0, ",");
        stringBuilder.insert(0, str);
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        C4990ab.m7410d("Micromsg.RemittanceLogic", "new friendsListStr=" + stringBuilder.toString());
        C1720g.m3537RQ();
        C1720g.m3536RP().mo5239Ry().set(327733, stringBuilder.toString());
        C1720g.m3537RQ();
        C1720g.m3536RP().mo5239Ry().dsb();
        AppMethodBeat.m2505o(44799);
    }

    public static String cfr() {
        AppMethodBeat.m2504i(44800);
        C1720g.m3537RQ();
        String nullAsNil = C5046bo.nullAsNil((String) C1720g.m3536RP().mo5239Ry().get(327733, null));
        AppMethodBeat.m2505o(44800);
        return nullAsNil;
    }
}
