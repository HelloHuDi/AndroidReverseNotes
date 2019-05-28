package com.tencent.mm.plugin.d.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.math.BigDecimal;

public final class i {
    public static BigDecimal i(double d, double d2) {
        AppMethodBeat.i(18358);
        BigDecimal multiply = new BigDecimal(d).multiply(new BigDecimal(d2));
        AppMethodBeat.o(18358);
        return multiply;
    }

    public static double p(int[] iArr) {
        AppMethodBeat.i(18359);
        if (iArr == null || iArr.length == 0) {
            NullPointerException nullPointerException = new NullPointerException("null == dataGroup || 0 == dataGroup.length");
            AppMethodBeat.o(18359);
            throw nullPointerException;
        }
        int i = 0;
        int i2 = 0;
        while (i < iArr.length) {
            i++;
            i2 = iArr[i] + i2;
        }
        double doubleValue = new BigDecimal((double) i2).divide(new BigDecimal((double) iArr.length), 5, 4).doubleValue();
        AppMethodBeat.o(18359);
        return doubleValue;
    }

    public static double q(int[] iArr) {
        AppMethodBeat.i(18360);
        if (iArr == null || iArr.length == 0) {
            NullPointerException nullPointerException = new NullPointerException("null == dataGroup || 0 == dataGroup.length");
            AppMethodBeat.o(18360);
            throw nullPointerException;
        }
        double p = p(iArr);
        BigDecimal bigDecimal = new BigDecimal(0.0d);
        for (int i : iArr) {
            bigDecimal = bigDecimal.add(new BigDecimal((double) i).subtract(new BigDecimal(p)).pow(2));
        }
        double pow = Math.pow(bigDecimal.divide(new BigDecimal(iArr.length - 1), 5, 4).doubleValue(), 0.5d);
        AppMethodBeat.o(18360);
        return pow;
    }
}
