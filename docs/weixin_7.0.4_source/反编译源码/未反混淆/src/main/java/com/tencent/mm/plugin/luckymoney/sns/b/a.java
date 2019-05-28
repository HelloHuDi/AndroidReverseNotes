package com.tencent.mm.plugin.luckymoney.sns.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;

public final class a {
    public static int bMi() {
        AppMethodBeat.i(42551);
        g.RQ();
        int intValue = ((Integer) g.RP().Ry().get(com.tencent.mm.storage.ac.a.USERINFO_NEWYEAR_2016_HONGBAO_IS_OPEN_SNS_PAY_INT_SYNC, Integer.valueOf(0))).intValue();
        AppMethodBeat.o(42551);
        return intValue;
    }

    public static void xV(int i) {
        AppMethodBeat.i(42552);
        g.RQ();
        g.RP().Ry().set(com.tencent.mm.storage.ac.a.USERINFO_NEWYEAR_2016_HONGBAO_IS_OPEN_SNS_PAY_INT_SYNC, Integer.valueOf(i));
        g.RQ();
        g.RP().Ry().dsb();
        AppMethodBeat.o(42552);
    }

    public static String bMj() {
        AppMethodBeat.i(42553);
        g.RQ();
        String str = (String) g.RP().Ry().get(com.tencent.mm.storage.ac.a.USERINFO_NEWYEAR_2016_HONGBAO_SET_SNS_PAY_TITLE_STRING_SYNC, (Object) "");
        AppMethodBeat.o(42553);
        return str;
    }

    public static String bMk() {
        AppMethodBeat.i(42554);
        g.RQ();
        String str = (String) g.RP().Ry().get(com.tencent.mm.storage.ac.a.USERINFO_NEWYEAR_2016_HONGBAO_SET_SNS_PAY_WORDING_STRING_SYNC, (Object) "");
        AppMethodBeat.o(42554);
        return str;
    }
}
