package com.tencent.map.lib.util;

import com.tencent.map.lib.basemap.data.GeoPoint;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class d {
    public static GeoPoint a(int i, int i2) {
        AppMethodBeat.i(98248);
        GeoPoint geoPoint = new GeoPoint((int) (Math.toDegrees((Math.atan(Math.exp(3.141592653589793d - (((double) i2) / 4.272282972352698E7d))) - 0.7853981633974483d) * 2.0d) * 1000000.0d), (int) (Math.toDegrees((((double) i) / 4.272282972352698E7d) - 3.141592653589793d) * 1000000.0d));
        AppMethodBeat.o(98248);
        return geoPoint;
    }
}
