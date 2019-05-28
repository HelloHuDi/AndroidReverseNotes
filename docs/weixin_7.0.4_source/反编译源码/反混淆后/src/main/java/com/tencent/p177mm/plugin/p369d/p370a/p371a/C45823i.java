package com.tencent.p177mm.plugin.p369d.p370a.p371a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.math.BigDecimal;

/* renamed from: com.tencent.mm.plugin.d.a.a.i */
public final class C45823i {
    /* renamed from: i */
    public static BigDecimal m84809i(double d, double d2) {
        AppMethodBeat.m2504i(18358);
        BigDecimal multiply = new BigDecimal(d).multiply(new BigDecimal(d2));
        AppMethodBeat.m2505o(18358);
        return multiply;
    }

    /* renamed from: p */
    public static double m84810p(int[] iArr) {
        AppMethodBeat.m2504i(18359);
        if (iArr == null || iArr.length == 0) {
            NullPointerException nullPointerException = new NullPointerException("null == dataGroup || 0 == dataGroup.length");
            AppMethodBeat.m2505o(18359);
            throw nullPointerException;
        }
        int i = 0;
        int i2 = 0;
        while (i < iArr.length) {
            i++;
            i2 = iArr[i] + i2;
        }
        double doubleValue = new BigDecimal((double) i2).divide(new BigDecimal((double) iArr.length), 5, 4).doubleValue();
        AppMethodBeat.m2505o(18359);
        return doubleValue;
    }

    /* renamed from: q */
    public static double m84811q(int[] iArr) {
        AppMethodBeat.m2504i(18360);
        if (iArr == null || iArr.length == 0) {
            NullPointerException nullPointerException = new NullPointerException("null == dataGroup || 0 == dataGroup.length");
            AppMethodBeat.m2505o(18360);
            throw nullPointerException;
        }
        double p = C45823i.m84810p(iArr);
        BigDecimal bigDecimal = new BigDecimal(0.0d);
        for (int i : iArr) {
            bigDecimal = bigDecimal.add(new BigDecimal((double) i).subtract(new BigDecimal(p)).pow(2));
        }
        double pow = Math.pow(bigDecimal.divide(new BigDecimal(iArr.length - 1), 5, 4).doubleValue(), 0.5d);
        AppMethodBeat.m2505o(18360);
        return pow;
    }
}
