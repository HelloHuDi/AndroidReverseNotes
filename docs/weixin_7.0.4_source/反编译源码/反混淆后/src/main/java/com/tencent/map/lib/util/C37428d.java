package com.tencent.map.lib.util;

import com.tencent.map.lib.basemap.data.GeoPoint;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.map.lib.util.d */
public class C37428d {
    /* renamed from: a */
    public static GeoPoint m63087a(int i, int i2) {
        AppMethodBeat.m2504i(98248);
        GeoPoint geoPoint = new GeoPoint((int) (Math.toDegrees((Math.atan(Math.exp(3.141592653589793d - (((double) i2) / 4.272282972352698E7d))) - 0.7853981633974483d) * 2.0d) * 1000000.0d), (int) (Math.toDegrees((((double) i) / 4.272282972352698E7d) - 3.141592653589793d) * 1000000.0d));
        AppMethodBeat.m2505o(98248);
        return geoPoint;
    }
}
