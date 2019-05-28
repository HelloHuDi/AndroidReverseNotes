package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.map.lib.basemap.data.DoublePoint;
import com.tencent.map.lib.basemap.data.GeoPoint;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;

public class hc {
    public static int a(List<GeoPoint> list, int[] iArr, fw fwVar) {
        AppMethodBeat.i(99521);
        if (list == null) {
            AppMethodBeat.o(99521);
            return 0;
        }
        int size = list.size();
        if (size < 2) {
            AppMethodBeat.o(99521);
            return 0;
        }
        int i = 0;
        for (int i2 = 0; i2 < size - 1; i2++) {
            double a = a(fwVar.b((GeoPoint) list.get(i2)), fwVar.b((GeoPoint) list.get(i2 + 1)));
            int max = ((int) a) / Math.max(4, (((int) a) / 500) * 4);
            iArr[i2] = max;
            i += max;
        }
        AppMethodBeat.o(99521);
        return i;
    }

    public static List<GeoPoint> a(List<GeoPoint> list, int i) {
        AppMethodBeat.i(99522);
        if (list == null || list.isEmpty()) {
            AppMethodBeat.o(99522);
            return null;
        }
        int size = list.size();
        ArrayList arrayList = new ArrayList(i);
        GeoPoint geoPoint = (GeoPoint) list.get(0);
        GeoPoint geoPoint2 = (GeoPoint) list.get(size - 1);
        int longitudeE6 = (geoPoint.getLongitudeE6() + geoPoint2.getLongitudeE6()) / 2;
        int latitudeE6 = (geoPoint.getLatitudeE6() + geoPoint2.getLatitudeE6()) / 2;
        for (int i2 = 0; i2 < size; i2++) {
            geoPoint = (GeoPoint) list.get(i2);
            geoPoint.setLongitudeE6(geoPoint.getLongitudeE6() - longitudeE6);
            geoPoint.setLatitudeE6(geoPoint.getLatitudeE6() - latitudeE6);
        }
        float f = 1.0f / ((float) (i + 1));
        float f2 = f;
        for (int i3 = 0; i3 < i; i3++) {
            GeoPoint a = a((List) list, f2);
            a.setLongitudeE6(a.getLongitudeE6() + longitudeE6);
            a.setLatitudeE6(a.getLatitudeE6() + latitudeE6);
            arrayList.add(a);
            f2 += f;
        }
        AppMethodBeat.o(99522);
        return arrayList;
    }

    private static GeoPoint a(List<GeoPoint> list, float f) {
        AppMethodBeat.i(99523);
        if (list == null || list.isEmpty()) {
            AppMethodBeat.o(99523);
            return null;
        }
        int size = list.size();
        GeoPoint geoPoint;
        GeoPoint geoPoint2;
        GeoPoint geoPoint3;
        if (size != 3 && size != 4) {
            AppMethodBeat.o(99523);
            return null;
        } else if (size == 3) {
            geoPoint = (GeoPoint) list.get(0);
            geoPoint2 = (GeoPoint) list.get(1);
            geoPoint3 = (GeoPoint) list.get(2);
            if (geoPoint == null || geoPoint2 == null || geoPoint3 == null) {
                AppMethodBeat.o(99523);
                return null;
            }
            geoPoint = new GeoPoint((int) a(geoPoint.getLatitudeE6(), geoPoint2.getLatitudeE6(), geoPoint3.getLatitudeE6(), f), (int) a(geoPoint.getLongitudeE6(), geoPoint2.getLongitudeE6(), geoPoint3.getLongitudeE6(), f));
            AppMethodBeat.o(99523);
            return geoPoint;
        } else {
            geoPoint = (GeoPoint) list.get(0);
            geoPoint2 = (GeoPoint) list.get(1);
            geoPoint3 = (GeoPoint) list.get(2);
            GeoPoint geoPoint4 = (GeoPoint) list.get(3);
            if (geoPoint == null || geoPoint2 == null || geoPoint3 == null || geoPoint4 == null) {
                AppMethodBeat.o(99523);
                return null;
            }
            geoPoint = new GeoPoint((int) a(geoPoint.getLatitudeE6(), geoPoint2.getLatitudeE6(), geoPoint3.getLatitudeE6(), geoPoint4.getLatitudeE6(), f), (int) a(geoPoint.getLongitudeE6(), geoPoint2.getLongitudeE6(), geoPoint3.getLongitudeE6(), geoPoint4.getLongitudeE6(), f));
            AppMethodBeat.o(99523);
            return geoPoint;
        }
    }

    private static double a(int i, int i2, int i3, float f) {
        return ((((1.0d - ((double) f)) * (1.0d - ((double) f))) * ((double) i)) + ((((double) (2.0f * f)) * (1.0d - ((double) f))) * ((double) i2))) + ((double) ((f * f) * ((float) i3)));
    }

    private static float a(int i, int i2, int i3, int i4, float f) {
        float f2 = ((float) (i2 - i)) * 3.0f;
        float f3 = (((float) (i3 - i2)) * 3.0f) - f2;
        float f4 = f * f;
        return ((f2 * f) + ((f3 * f4) + (((((float) (i4 - i)) - f2) - f3) * (f4 * f)))) + ((float) i);
    }

    private static double a(DoublePoint doublePoint, DoublePoint doublePoint2) {
        AppMethodBeat.i(99524);
        double d = doublePoint2.x - doublePoint.x;
        double d2 = doublePoint2.y - doublePoint.y;
        d = Math.sqrt((d * d) + (d2 * d2));
        AppMethodBeat.o(99524);
        return d;
    }
}
