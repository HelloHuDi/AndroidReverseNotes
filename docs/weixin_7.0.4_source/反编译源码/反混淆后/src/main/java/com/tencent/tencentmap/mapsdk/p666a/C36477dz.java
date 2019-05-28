package com.tencent.tencentmap.mapsdk.p666a;

import com.tencent.mapsdk.raster.model.LatLng;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.tencentmap.mapsdk.a.dz */
public class C36477dz {
    /* renamed from: a */
    public static double m60314a(LatLng latLng, LatLng latLng2) {
        AppMethodBeat.m2504i(101331);
        double longitude = latLng.getLongitude();
        double latitude = latLng.getLatitude();
        longitude *= 0.01745329251994329d;
        latitude *= 0.01745329251994329d;
        double longitude2 = latLng2.getLongitude() * 0.01745329251994329d;
        double latitude2 = latLng2.getLatitude() * 0.01745329251994329d;
        double sin = Math.sin(longitude);
        double sin2 = Math.sin(latitude);
        longitude = Math.cos(longitude);
        latitude = Math.cos(latitude);
        double sin3 = Math.sin(longitude2);
        double sin4 = Math.sin(latitude2);
        longitude2 = Math.cos(longitude2);
        latitude2 = Math.cos(latitude2);
        r18 = new double[3];
        double[] dArr = new double[]{longitude * latitude, latitude * sin, sin2};
        dArr[0] = latitude2 * longitude2;
        dArr[1] = latitude2 * sin3;
        dArr[2] = sin4;
        longitude = Math.asin(Math.sqrt((((r18[0] - dArr[0]) * (r18[0] - dArr[0])) + ((r18[1] - dArr[1]) * (r18[1] - dArr[1]))) + ((r18[2] - dArr[2]) * (r18[2] - dArr[2]))) / 2.0d) * 1.27420015798544E7d;
        AppMethodBeat.m2505o(101331);
        return longitude;
    }
}
