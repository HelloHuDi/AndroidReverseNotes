package com.tencent.tencentmap.mapsdk.maps.p667a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.p666a.C24343db;

/* renamed from: com.tencent.tencentmap.mapsdk.maps.a.id */
public class C46791id {
    /* renamed from: a */
    public static double m88924a(C24343db c24343db, C24343db c24343db2) {
        AppMethodBeat.m2504i(99835);
        double d = c24343db.f4616b;
        double d2 = c24343db.f4615a;
        d *= 0.01745329251994329d;
        d2 *= 0.01745329251994329d;
        double d3 = c24343db2.f4616b * 0.01745329251994329d;
        double d4 = c24343db2.f4615a * 0.01745329251994329d;
        double sin = Math.sin(d);
        double sin2 = Math.sin(d2);
        d = Math.cos(d);
        d2 = Math.cos(d2);
        double sin3 = Math.sin(d3);
        double sin4 = Math.sin(d4);
        d3 = Math.cos(d3);
        d4 = Math.cos(d4);
        r18 = new double[3];
        double[] dArr = new double[]{d * d2, d2 * sin, sin2};
        dArr[0] = d4 * d3;
        dArr[1] = d4 * sin3;
        dArr[2] = sin4;
        d = Math.asin(Math.sqrt((((r18[0] - dArr[0]) * (r18[0] - dArr[0])) + ((r18[1] - dArr[1]) * (r18[1] - dArr[1]))) + ((r18[2] - dArr[2]) * (r18[2] - dArr[2]))) / 2.0d) * 1.27420015798544E7d;
        AppMethodBeat.m2505o(99835);
        return d;
    }
}
