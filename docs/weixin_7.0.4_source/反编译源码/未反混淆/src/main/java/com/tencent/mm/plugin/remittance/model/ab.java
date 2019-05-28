package com.tencent.mm.plugin.remittance.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.bo;

public final class ab {
    public static void VQ(String str) {
        AppMethodBeat.i(44799);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(44799);
            return;
        }
        String cfr = cfr();
        com.tencent.mm.sdk.platformtools.ab.d("Micromsg.RemittanceLogic", "cur friendsListStr=".concat(String.valueOf(cfr)));
        StringBuilder stringBuilder = new StringBuilder();
        if (!bo.isNullOrNil(cfr)) {
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
        com.tencent.mm.sdk.platformtools.ab.d("Micromsg.RemittanceLogic", "new friendsListStr=" + stringBuilder.toString());
        g.RQ();
        g.RP().Ry().set(327733, stringBuilder.toString());
        g.RQ();
        g.RP().Ry().dsb();
        AppMethodBeat.o(44799);
    }

    public static String cfr() {
        AppMethodBeat.i(44800);
        g.RQ();
        String nullAsNil = bo.nullAsNil((String) g.RP().Ry().get(327733, null));
        AppMethodBeat.o(44800);
        return nullAsNil;
    }
}
