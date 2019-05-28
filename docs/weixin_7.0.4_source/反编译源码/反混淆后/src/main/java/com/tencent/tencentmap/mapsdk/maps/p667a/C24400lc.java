package com.tencent.tencentmap.mapsdk.maps.p667a;

import com.tencent.map.lib.basemap.data.DoublePoint;
import com.tencent.map.lib.basemap.data.GeoPoint;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.p666a.C24343db;
import com.tencent.tencentmap.mapsdk.p666a.C36467cs;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* renamed from: com.tencent.tencentmap.mapsdk.maps.a.lc */
public class C24400lc implements C31075lb {
    /* renamed from: b */
    static int f4765b = 4;
    /* renamed from: a */
    C5898kn<Double, C36904kx> f4766a;
    /* renamed from: c */
    double f4767c;
    /* renamed from: d */
    double f4768d;
    /* renamed from: e */
    private C44527jx f4769e;

    public C24400lc(C44527jx c44527jx) {
        this.f4769e = c44527jx;
    }

    /* renamed from: a */
    public List<C41069kb> mo40688a(DoublePoint doublePoint, DoublePoint doublePoint2, double d) {
        double d2;
        AppMethodBeat.m2504i(100323);
        HashMap hashMap = new HashMap();
        ArrayList arrayList = new ArrayList();
        int i = (int) (10.0d / d);
        double d3 = (this.f4768d - this.f4767c) / 20.0d;
        double pow = (((Math.pow((-Math.log(d)) / Math.log(2.0d), (double) f4765b) / Math.pow(21.0d, (double) (f4765b - 1))) - 0.2d) * d3) + this.f4767c;
        if (pow < this.f4767c) {
            d2 = this.f4767c;
        } else {
            d2 = pow;
        }
        if (this.f4766a != null) {
            d3 = d2;
            final int i2 = i;
            final HashMap hashMap2 = hashMap;
            final ArrayList arrayList2 = arrayList;
            this.f4766a.mo12526b(C16304ky.m25121a(doublePoint.f2800x, doublePoint2.f2801y, doublePoint2.f2800x, doublePoint.f2801y)).mo65171a(new C31080me<C16298kg<Double, C36904kx>>() {
                /* renamed from: a */
                public void mo40690a(C16298kg<Double, C36904kx> c16298kg) {
                    AppMethodBeat.m2504i(100321);
                    double doubleValue = ((Double) c16298kg.mo29552a()).doubleValue() / d3;
                    C44529jz c44529jz = new C44529jz();
                    C36904kx c36904kx = (C36904kx) c16298kg.mo29553b();
                    int b = (int) c36904kx.mo58930b();
                    int c = (int) c36904kx.mo58931c();
                    c44529jz.f17473a = (double) ((b - (b % i2)) + (i2 / 2));
                    c44529jz.f17474b = (double) ((c - (c % i2)) + (i2 / 2));
                    C41069kb c41069kb = (C41069kb) hashMap2.get(c44529jz);
                    if (c41069kb == null) {
                        c41069kb = new C41069kb(c44529jz, doubleValue);
                        hashMap2.put(c44529jz, c41069kb);
                        arrayList2.add(c41069kb);
                        AppMethodBeat.m2505o(100321);
                        return;
                    }
                    c41069kb.mo65155a(doubleValue + c41069kb.mo65156b());
                    AppMethodBeat.m2505o(100321);
                }
            });
        }
        AppMethodBeat.m2505o(100323);
        return arrayList;
    }

    /* renamed from: a */
    public void mo40689a(List<C36467cs> list) {
        int i;
        AppMethodBeat.m2504i(100324);
        this.f4766a = C5898kn.m9167a(22).mo12530b(32).mo12529a();
        this.f4767c = 0.0d;
        this.f4768d = Double.MIN_VALUE;
        float[][] fArr = (float[][]) Array.newInstance(Float.TYPE, new int[]{256, 256});
        for (C36467cs c36467cs : list) {
            C24343db b = c36467cs.mo57693b();
            DoublePoint a = this.f4769e.mo70907e().mo70909a(new GeoPoint((int) (b.f4615a * 1000000.0d), (int) (b.f4616b * 1000000.0d)));
            double a2 = c36467cs.mo57692a();
            this.f4766a = this.f4766a.mo12524a(Double.valueOf(a2), C36904kx.m61663a(a.f2800x, a.f2801y));
            if (a2 > this.f4767c) {
                this.f4767c = a2;
            }
            i = (int) (a.f2800x / 1048576.0d);
            int i2 = (int) (a.f2801y / 1048576.0d);
            float[] fArr2 = fArr[i];
            fArr2[i2] = (float) (a2 + ((double) fArr2[i2]));
        }
        i = 0;
        while (true) {
            int i3 = i;
            if (i3 < 256) {
                for (i = 0; i < 256; i++) {
                    if (((double) fArr[i3][i]) > this.f4768d) {
                        this.f4768d = (double) fArr[i3][i];
                    }
                }
                i = i3 + 1;
            } else {
                AppMethodBeat.m2505o(100324);
                return;
            }
        }
    }
}
