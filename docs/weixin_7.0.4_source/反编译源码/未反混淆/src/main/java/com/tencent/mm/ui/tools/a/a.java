package com.tencent.mm.ui.tools.a;

import android.graphics.PointF;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.ArrayList;
import java.util.List;

public final class a {
    public static List<PointF> v(List<PointF> list, int i) {
        AppMethodBeat.i(107824);
        if (i <= 1) {
            ab.w("MicroMsg.GestureRecognizer", "sample count <= 1 !");
            AppMethodBeat.o(107824);
            return list;
        } else if (i == list.size()) {
            ab.w("MicroMsg.GestureRecognizer", "sample count == path.size, no need resample!");
            AppMethodBeat.o(107824);
            return list;
        } else {
            List<PointF> list2;
            double d = 0.0d;
            PointF pointF = (PointF) list.get(0);
            int i2 = 1;
            while (true) {
                PointF pointF2 = pointF;
                if (i2 >= list.size()) {
                    break;
                }
                pointF = (PointF) list.get(i2);
                d += (double) ((float) Math.hypot((double) (pointF2.x - pointF.x), (double) (pointF2.y - pointF.y)));
                pointF = (PointF) list.get(i2);
                i2++;
            }
            double d2 = d / ((double) (i - 1));
            ab.i("MicroMsg.GestureRecognizer", "point count %d, interval %f", Integer.valueOf(list.size()), Double.valueOf(d2));
            if (list.size() <= 1 || d2 < 1.0d) {
                ab.w("MicroMsg.GestureRecognizer", "point count <= 1 or interval < 1, no need resample!");
                list2 = list;
            } else {
                ArrayList arrayList = new ArrayList();
                double d3 = 0.0d;
                arrayList.add(new PointF(((PointF) list.get(0)).x, ((PointF) list.get(0)).y));
                PointF pointF3 = (PointF) list.get(0);
                int i3 = 1;
                while (i3 < list.size()) {
                    double d4 = (double) (((PointF) list.get(i3)).x - ((PointF) list.get(i3 - 1)).x);
                    double d5 = (double) (((PointF) list.get(i3)).y - ((PointF) list.get(i3 - 1)).y);
                    double hypot = (double) ((float) Math.hypot(d4, d5));
                    d = hypot + d3;
                    PointF pointF4 = pointF3;
                    while (d >= d2) {
                        PointF pointF5;
                        double d6;
                        if (d == d2) {
                            pointF5 = new PointF(((PointF) list.get(i3)).x, ((PointF) list.get(i3)).y);
                            d6 = 0.0d;
                        } else {
                            d6 = (d2 - d3) / hypot;
                            float f = (float) (((double) pointF4.x) + (d4 * d6));
                            float f2 = f;
                            pointF5 = new PointF(f2, (float) ((d6 * d5) + ((double) pointF4.y)));
                            d6 = d - d2;
                        }
                        arrayList.add(pointF5);
                        d = d6;
                        pointF4 = pointF5;
                    }
                    i3++;
                    pointF3 = (PointF) list.get(i3);
                    d3 = d;
                }
                Object list22 = arrayList;
            }
            if (list22.size() < i) {
                ab.i("MicroMsg.GestureRecognizer", "sample result %d, sample count %d", Integer.valueOf(list22.size()), Integer.valueOf(i));
                list22.add(new PointF(((PointF) list.get(list.size() - 1)).x, ((PointF) list.get(list.size() - 1)).y));
            }
            AppMethodBeat.o(107824);
            return list22;
        }
    }

    private static float c(float[] fArr, float[] fArr2) {
        AppMethodBeat.i(107825);
        if (fArr.length != fArr2.length) {
            AppMethodBeat.o(107825);
            return -1.0f;
        }
        int i = 0;
        double d = 0.0d;
        double d2 = 0.0d;
        double d3 = 0.0d;
        while (i < fArr.length) {
            d3 += (double) (fArr[i] * fArr2[i]);
            double pow = Math.pow((double) fArr[i], 2.0d) + d2;
            d += Math.pow((double) fArr2[i], 2.0d);
            i++;
            d2 = pow;
        }
        float sqrt = (float) (d3 / (Math.sqrt(d2) * Math.sqrt(d)));
        AppMethodBeat.o(107825);
        return sqrt;
    }

    private static float[] fx(List<PointF> list) {
        int i = 1;
        AppMethodBeat.i(107826);
        float[] fArr = new float[(list.size() * 2)];
        fArr[0] = 0.0f;
        fArr[1] = 0.0f;
        while (true) {
            int i2 = i;
            if (i2 < list.size()) {
                fArr[i2 * 2] = ((PointF) list.get(i2)).x - ((PointF) list.get(i2 - 1)).x;
                fArr[(i2 * 2) + 1] = ((PointF) list.get(i2)).y - ((PointF) list.get(i2 - 1)).y;
                i = i2 + 1;
            } else {
                AppMethodBeat.o(107826);
                return fArr;
            }
        }
    }

    public static float r(List<PointF> list, List<PointF> list2) {
        AppMethodBeat.i(107827);
        int min = Math.min(list.size(), list2.size());
        if (min >= 20) {
            min = 20;
        }
        float a = a(list, list2, min);
        AppMethodBeat.o(107827);
        return a;
    }

    private static float a(List<PointF> list, List<PointF> list2, int i) {
        AppMethodBeat.i(107828);
        long currentTimeMillis = System.currentTimeMillis();
        float c = c(fx(v(list, i)), fx(v(list2, i)));
        ab.i("MicroMsg.GestureRecognizer", "computeSimilarity cost %d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        AppMethodBeat.o(107828);
        return c;
    }
}
