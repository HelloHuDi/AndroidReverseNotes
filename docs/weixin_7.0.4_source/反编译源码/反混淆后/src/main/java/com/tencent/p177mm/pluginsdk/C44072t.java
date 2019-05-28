package com.tencent.p177mm.pluginsdk;

import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.pluginsdk.t */
public final class C44072t {
    /* renamed from: c */
    public static double m79222c(double d, double d2, double d3, double d4) {
        AppMethodBeat.m2504i(79196);
        double d5 = (3.141592653589793d * d) / 180.0d;
        double d6 = (3.141592653589793d * d3) / 180.0d;
        double d7 = ((d2 - d4) * 3.141592653589793d) / 180.0d;
        d5 = (double) (Math.round(((Math.asin(Math.sqrt(((Math.cos(d5) * Math.cos(d6)) * Math.pow(Math.sin(d7 / 2.0d), 2.0d)) + Math.pow(Math.sin((d5 - d6) / 2.0d), 2.0d))) * 2.0d) * 6378137.0d) * 10000.0d) / 10000);
        AppMethodBeat.m2505o(79196);
        return d5;
    }
}
