package com.tencent.mm.plugin.remittance.bankcard.model;

import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.platformtools.SpellMap;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.math.BigDecimal;

public final class a {
    public static long fK(String str, String str2) {
        AppMethodBeat.i(44485);
        try {
            long longValue = new BigDecimal(bo.getDouble(str.trim(), 0.0d) == 0.0d ? AppEventsConstants.EVENT_PARAM_VALUE_NO : str.trim()).divide(new BigDecimal(str2.trim()), 0, 4).longValue();
            AppMethodBeat.o(44485);
            return longValue;
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.BankRemitUtil", e, "", new Object[0]);
            AppMethodBeat.o(44485);
            return 0;
        }
    }

    public static double fL(String str, String str2) {
        double d = 0.0d;
        AppMethodBeat.i(44486);
        try {
            d = new BigDecimal(bo.getDouble(str.trim(), 0.0d) == 0.0d ? AppEventsConstants.EVENT_PARAM_VALUE_NO : str.trim()).divide(new BigDecimal(str2.trim()), 2, 4).doubleValue();
            AppMethodBeat.o(44486);
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.BankRemitUtil", e, "", new Object[0]);
            AppMethodBeat.o(44486);
        }
        return d;
    }

    public static double fM(String str, String str2) {
        double d = 0.0d;
        AppMethodBeat.i(44487);
        try {
            double d2 = bo.getDouble(str, 0.0d);
            double d3 = bo.getDouble(str2, 0.0d);
            if (d2 == 0.0d) {
                str = AppEventsConstants.EVENT_PARAM_VALUE_NO;
            }
            BigDecimal bigDecimal = new BigDecimal(str);
            if (d3 == 0.0d) {
                str2 = AppEventsConstants.EVENT_PARAM_VALUE_NO;
            }
            d = bigDecimal.multiply(new BigDecimal(str2)).doubleValue();
            AppMethodBeat.o(44487);
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.BankRemitUtil", e, "", new Object[0]);
            AppMethodBeat.o(44487);
        }
        return d;
    }

    public static double BJ(int i) {
        AppMethodBeat.i(44488);
        double fL = fL(String.valueOf(i), "100");
        AppMethodBeat.o(44488);
        return fL;
    }

    public static char VL(String str) {
        AppMethodBeat.i(44489);
        String r = SpellMap.r(str.charAt(0));
        ab.d("MicroMsg.BankRemitUtil", "pinyin: %s", r);
        if (bo.isNullOrNil(r)) {
            AppMethodBeat.o(44489);
            return '#';
        }
        char charAt = r.toUpperCase().charAt(0);
        AppMethodBeat.o(44489);
        return charAt;
    }
}
