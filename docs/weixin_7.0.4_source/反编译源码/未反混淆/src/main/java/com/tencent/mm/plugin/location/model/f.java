package com.tencent.mm.plugin.location.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.t;

public final class f {
    private static double hOA = -85.0d;
    private static double hOB = -1000.0d;
    private static double hOC = -85.0d;
    private static double hOD = -1000.0d;

    public static double h(double d, double d2) {
        double d3;
        AppMethodBeat.i(113309);
        hOC = d;
        hOD = d2;
        if (hOA == -85.0d || hOB == -1000.0d) {
            d3 = 0.0d;
        } else {
            d3 = (Math.atan2(hOD - hOB, hOC - hOA) * 180.0d) / 3.141592d;
        }
        hOA = hOC;
        hOB = hOD;
        AppMethodBeat.o(113309);
        return d3;
    }

    /* JADX WARNING: Missing block: B:8:0x001b, code skipped:
            if (r19 > 0.0d) goto L_0x001d;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean a(double d, double d2, double d3, double d4, int i, double d5) {
        AppMethodBeat.i(113310);
        boolean z = false;
        if (i == 0) {
            if (d5 == 0.0d) {
                z = false;
            }
        } else if (i == 1) {
            Object obj;
            if (d2 == -85.0d || d == -1000.0d) {
                obj = null;
            } else if (d3 == -1000.0d || d4 == -85.0d) {
                obj = null;
            } else if (t.c(d2, d, d4, d3) >= 5.0d) {
                obj = 1;
            } else {
                obj = null;
            }
            if (obj == null) {
                z = false;
            }
            z = true;
        }
        AppMethodBeat.o(113310);
        return z;
    }

    public static double z(int i, int i2, int i3, int i4) {
        AppMethodBeat.i(113311);
        double sqrt = Math.sqrt((double) (((i - i3) * (i - i3)) + ((i2 - i4) * (i2 - i4))));
        AppMethodBeat.o(113311);
        return sqrt;
    }

    public static boolean x(double d) {
        return d >= 4.0d;
    }
}
