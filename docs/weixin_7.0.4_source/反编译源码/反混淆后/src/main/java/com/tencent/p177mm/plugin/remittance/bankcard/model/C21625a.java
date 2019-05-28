package com.tencent.p177mm.plugin.remittance.bankcard.model;

import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.platformtools.SpellMap;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.math.BigDecimal;

/* renamed from: com.tencent.mm.plugin.remittance.bankcard.model.a */
public final class C21625a {
    /* renamed from: fK */
    public static long m33130fK(String str, String str2) {
        AppMethodBeat.m2504i(44485);
        try {
            long longValue = new BigDecimal(C5046bo.getDouble(str.trim(), 0.0d) == 0.0d ? AppEventsConstants.EVENT_PARAM_VALUE_NO : str.trim()).divide(new BigDecimal(str2.trim()), 0, 4).longValue();
            AppMethodBeat.m2505o(44485);
            return longValue;
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.BankRemitUtil", e, "", new Object[0]);
            AppMethodBeat.m2505o(44485);
            return 0;
        }
    }

    /* renamed from: fL */
    public static double m33131fL(String str, String str2) {
        double d = 0.0d;
        AppMethodBeat.m2504i(44486);
        try {
            d = new BigDecimal(C5046bo.getDouble(str.trim(), 0.0d) == 0.0d ? AppEventsConstants.EVENT_PARAM_VALUE_NO : str.trim()).divide(new BigDecimal(str2.trim()), 2, 4).doubleValue();
            AppMethodBeat.m2505o(44486);
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.BankRemitUtil", e, "", new Object[0]);
            AppMethodBeat.m2505o(44486);
        }
        return d;
    }

    /* renamed from: fM */
    public static double m33132fM(String str, String str2) {
        double d = 0.0d;
        AppMethodBeat.m2504i(44487);
        try {
            double d2 = C5046bo.getDouble(str, 0.0d);
            double d3 = C5046bo.getDouble(str2, 0.0d);
            if (d2 == 0.0d) {
                str = AppEventsConstants.EVENT_PARAM_VALUE_NO;
            }
            BigDecimal bigDecimal = new BigDecimal(str);
            if (d3 == 0.0d) {
                str2 = AppEventsConstants.EVENT_PARAM_VALUE_NO;
            }
            d = bigDecimal.multiply(new BigDecimal(str2)).doubleValue();
            AppMethodBeat.m2505o(44487);
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.BankRemitUtil", e, "", new Object[0]);
            AppMethodBeat.m2505o(44487);
        }
        return d;
    }

    /* renamed from: BJ */
    public static double m33128BJ(int i) {
        AppMethodBeat.m2504i(44488);
        double fL = C21625a.m33131fL(String.valueOf(i), "100");
        AppMethodBeat.m2505o(44488);
        return fL;
    }

    /* renamed from: VL */
    public static char m33129VL(String str) {
        AppMethodBeat.m2504i(44489);
        String r = SpellMap.m42342r(str.charAt(0));
        C4990ab.m7411d("MicroMsg.BankRemitUtil", "pinyin: %s", r);
        if (C5046bo.isNullOrNil(r)) {
            AppMethodBeat.m2505o(44489);
            return '#';
        }
        char charAt = r.toUpperCase().charAt(0);
        AppMethodBeat.m2505o(44489);
        return charAt;
    }
}
