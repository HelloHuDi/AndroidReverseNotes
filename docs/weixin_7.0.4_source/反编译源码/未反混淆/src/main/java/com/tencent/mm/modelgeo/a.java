package com.tencent.mm.modelgeo;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a {

    public static class a {
        private static double a = 6378245.0d;
        private static double fBt = 3.141592653589793d;
        private static double fBu = 0.006693421622965943d;

        public static double[] f(double d, double d2) {
            Object obj;
            AppMethodBeat.i(78103);
            if (d < 72.004d || d > 137.8347d) {
                obj = 1;
            } else if (d2 < 0.8293d || d2 > 55.8271d) {
                obj = 1;
            } else {
                obj = null;
            }
            double[] dArr;
            if (obj != null) {
                dArr = new double[]{d, d2};
                AppMethodBeat.o(78103);
                return dArr;
            }
            double d3 = d - 105.0d;
            double d4 = d2 - 35.0d;
            d3 = ((((((Math.sin((d3 * 2.0d) * fBt) * 20.0d) + (20.0d * Math.sin((6.0d * d3) * fBt))) * 2.0d) / 3.0d) + (((((-100.0d + (2.0d * d3)) + (3.0d * d4)) + ((0.2d * d4) * d4)) + ((0.1d * d3) * d4)) + (0.2d * Math.sqrt(Math.abs(d3))))) + ((((20.0d * Math.sin(fBt * d4)) + (40.0d * Math.sin((d4 / 3.0d) * fBt))) * 2.0d) / 3.0d)) + ((((Math.sin((d4 * fBt) / 30.0d) * 320.0d) + (160.0d * Math.sin((d4 / 12.0d) * fBt))) * 2.0d) / 3.0d);
            d4 = d - 105.0d;
            double d5 = d2 - 35.0d;
            d4 = ((((Math.sin((d4 / 30.0d) * fBt) * 300.0d) + (150.0d * Math.sin((d4 / 12.0d) * fBt))) * 2.0d) / 3.0d) + (((((d5 * (0.1d * d4)) + (((300.0d + d4) + (2.0d * d5)) + ((0.1d * d4) * d4))) + (0.1d * Math.sqrt(Math.abs(d4)))) + ((((20.0d * Math.sin((6.0d * d4) * fBt)) + (20.0d * Math.sin((2.0d * d4) * fBt))) * 2.0d) / 3.0d)) + ((((20.0d * Math.sin(fBt * d4)) + (40.0d * Math.sin((d4 / 3.0d) * fBt))) * 2.0d) / 3.0d));
            d5 = (d2 / 180.0d) * fBt;
            double sin = Math.sin(d5);
            sin = 1.0d - (sin * (fBu * sin));
            double sqrt = Math.sqrt(sin);
            d3 = (d3 * 180.0d) / (((a * (1.0d - fBu)) / (sin * sqrt)) * fBt);
            d4 = (d4 * 180.0d) / ((Math.cos(d5) * (a / sqrt)) * fBt);
            d5 = d2 + d3;
            dArr = new double[2];
            dArr[0] = (2.0d * d) - (d4 + d);
            dArr[1] = (2.0d * d2) - d5;
            AppMethodBeat.o(78103);
            return dArr;
        }
    }

    public static boolean q(double d) {
        AppMethodBeat.i(78104);
        double abs = Math.abs(d);
        if (abs < 0.0d || abs > 180.0d) {
            AppMethodBeat.o(78104);
            return false;
        }
        AppMethodBeat.o(78104);
        return true;
    }

    public static boolean r(double d) {
        AppMethodBeat.i(78105);
        double abs = Math.abs(d);
        if (abs < 0.0d || abs > 90.0d) {
            AppMethodBeat.o(78105);
            return false;
        }
        AppMethodBeat.o(78105);
        return true;
    }
}
