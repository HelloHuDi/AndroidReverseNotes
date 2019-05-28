package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.map.lib.basemap.data.DoublePoint;
import com.tencent.map.lib.basemap.data.GeoPoint;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.a.cs;
import com.tencent.tencentmap.mapsdk.a.db;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class lc implements lb {
    static int b = 4;
    kn<Double, kx> a;
    double c;
    double d;
    private jx e;

    public lc(jx jxVar) {
        this.e = jxVar;
    }

    public List<kb> a(DoublePoint doublePoint, DoublePoint doublePoint2, double d) {
        double d2;
        AppMethodBeat.i(100323);
        HashMap hashMap = new HashMap();
        ArrayList arrayList = new ArrayList();
        int i = (int) (10.0d / d);
        double d3 = (this.d - this.c) / 20.0d;
        double pow = (((Math.pow((-Math.log(d)) / Math.log(2.0d), (double) b) / Math.pow(21.0d, (double) (b - 1))) - 0.2d) * d3) + this.c;
        if (pow < this.c) {
            d2 = this.c;
        } else {
            d2 = pow;
        }
        if (this.a != null) {
            d3 = d2;
            final int i2 = i;
            final HashMap hashMap2 = hashMap;
            final ArrayList arrayList2 = arrayList;
            this.a.b(ky.a(doublePoint.x, doublePoint2.y, doublePoint2.x, doublePoint.y)).a(new me<kg<Double, kx>>() {
                public void a(kg<Double, kx> kgVar) {
                    AppMethodBeat.i(100321);
                    double doubleValue = ((Double) kgVar.a()).doubleValue() / d3;
                    jz jzVar = new jz();
                    kx kxVar = (kx) kgVar.b();
                    int b = (int) kxVar.b();
                    int c = (int) kxVar.c();
                    jzVar.a = (double) ((b - (b % i2)) + (i2 / 2));
                    jzVar.b = (double) ((c - (c % i2)) + (i2 / 2));
                    kb kbVar = (kb) hashMap2.get(jzVar);
                    if (kbVar == null) {
                        kbVar = new kb(jzVar, doubleValue);
                        hashMap2.put(jzVar, kbVar);
                        arrayList2.add(kbVar);
                        AppMethodBeat.o(100321);
                        return;
                    }
                    kbVar.a(doubleValue + kbVar.b());
                    AppMethodBeat.o(100321);
                }
            });
        }
        AppMethodBeat.o(100323);
        return arrayList;
    }

    public void a(List<cs> list) {
        int i;
        AppMethodBeat.i(100324);
        this.a = kn.a(22).b(32).a();
        this.c = 0.0d;
        this.d = Double.MIN_VALUE;
        float[][] fArr = (float[][]) Array.newInstance(Float.TYPE, new int[]{256, 256});
        for (cs csVar : list) {
            db b = csVar.b();
            DoublePoint a = this.e.e().a(new GeoPoint((int) (b.a * 1000000.0d), (int) (b.b * 1000000.0d)));
            double a2 = csVar.a();
            this.a = this.a.a(Double.valueOf(a2), kx.a(a.x, a.y));
            if (a2 > this.c) {
                this.c = a2;
            }
            i = (int) (a.x / 1048576.0d);
            int i2 = (int) (a.y / 1048576.0d);
            float[] fArr2 = fArr[i];
            fArr2[i2] = (float) (a2 + ((double) fArr2[i2]));
        }
        i = 0;
        while (true) {
            int i3 = i;
            if (i3 < 256) {
                for (i = 0; i < 256; i++) {
                    if (((double) fArr[i3][i]) > this.d) {
                        this.d = (double) fArr[i3][i];
                    }
                }
                i = i3 + 1;
            } else {
                AppMethodBeat.o(100324);
                return;
            }
        }
    }
}
