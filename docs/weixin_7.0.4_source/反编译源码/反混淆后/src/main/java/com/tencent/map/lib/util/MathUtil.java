package com.tencent.map.lib.util;

import android.graphics.PointF;
import android.graphics.Rect;
import com.tencent.map.lib.basemap.data.GeoPoint;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.math.BigDecimal;

public class MathUtil {
    public static double getDoubleByDecimalNum(double d, int i) {
        AppMethodBeat.m2504i(98207);
        try {
            d = new BigDecimal(d).setScale(i, 4).doubleValue();
            AppMethodBeat.m2505o(98207);
        } catch (Exception e) {
            AppMethodBeat.m2505o(98207);
        }
        return d;
    }

    public static float getFloatByDecimalNum(float f, int i) {
        AppMethodBeat.m2504i(98208);
        try {
            f = new BigDecimal((double) f).setScale(i, 4).floatValue();
            AppMethodBeat.m2505o(98208);
        } catch (Exception e) {
            AppMethodBeat.m2505o(98208);
        }
        return f;
    }

    public static PointF getPoiWith2Line(PointF pointF, PointF pointF2, PointF pointF3, PointF pointF4) {
        AppMethodBeat.m2504i(98209);
        if (pointF2.x == pointF.x || pointF4.x == pointF3.x) {
            AppMethodBeat.m2505o(98209);
            return null;
        }
        float f = (pointF2.y - pointF.y) / (pointF2.x - pointF.x);
        float f2 = (pointF4.y - pointF3.y) / (pointF4.x - pointF3.x);
        if (f == f2) {
            AppMethodBeat.m2505o(98209);
            return null;
        }
        float f3 = ((pointF3.y * pointF4.x) - (pointF4.y * pointF3.x)) / (pointF4.x - pointF3.x);
        f = (f3 - (((pointF.y * pointF2.x) - (pointF2.y * pointF.x)) / (pointF2.x - pointF.x))) / (f - f2);
        PointF pointF5 = new PointF(f, (f2 * f) + f3);
        AppMethodBeat.m2505o(98209);
        return pointF5;
    }

    public static double calShortestAngleDistance(double d) {
        double d2 = d % 360.0d;
        if (d2 > 180.0d) {
            return d2 - 360.0d;
        }
        if (d2 < -180.0d) {
            return d2 + 360.0d;
        }
        return d2;
    }

    public static Rect getExtendedBound(GeoPoint geoPoint, Rect rect) {
        AppMethodBeat.m2504i(98210);
        int max = Math.max(Math.abs(rect.left - geoPoint.getLongitudeE6()), Math.abs(rect.right - geoPoint.getLongitudeE6()));
        int max2 = Math.max(Math.abs(rect.top - geoPoint.getLatitudeE6()), Math.abs(rect.bottom - geoPoint.getLatitudeE6()));
        Rect rect2 = new Rect(geoPoint.getLongitudeE6() - max2, geoPoint.getLatitudeE6() - max, max2 + geoPoint.getLongitudeE6(), max + geoPoint.getLatitudeE6());
        AppMethodBeat.m2505o(98210);
        return rect2;
    }

    public static Rect getBound(GeoPoint geoPoint, GeoPoint geoPoint2) {
        AppMethodBeat.m2504i(98211);
        if (geoPoint == null || geoPoint2 == null || geoPoint.equals(geoPoint2)) {
            AppMethodBeat.m2505o(98211);
            return null;
        }
        int abs = Math.abs(geoPoint.getLongitudeE6() - geoPoint2.getLongitudeE6());
        int abs2 = Math.abs(geoPoint.getLatitudeE6() - geoPoint2.getLatitudeE6());
        Rect rect = new Rect(geoPoint.getLongitudeE6() - abs, geoPoint.getLatitudeE6() - abs2, abs + geoPoint.getLongitudeE6(), abs2 + geoPoint.getLatitudeE6());
        AppMethodBeat.m2505o(98211);
        return rect;
    }

    public static GeoPoint findClosetPoint(GeoPoint geoPoint, GeoPoint geoPoint2, GeoPoint geoPoint3) {
        AppMethodBeat.m2504i(98212);
        int latitudeE6 = geoPoint2.getLatitudeE6() - geoPoint.getLatitudeE6();
        int longitudeE6 = geoPoint2.getLongitudeE6() - geoPoint.getLongitudeE6();
        if (latitudeE6 == 0 && longitudeE6 == 0) {
            AppMethodBeat.m2505o(98212);
            return null;
        }
        double latitudeE62 = ((double) (((geoPoint3.getLatitudeE6() - geoPoint.getLatitudeE6()) * latitudeE6) + ((geoPoint3.getLongitudeE6() - geoPoint.getLongitudeE6()) * longitudeE6))) / ((double) ((latitudeE6 * latitudeE6) + (longitudeE6 * longitudeE6)));
        GeoPoint geoPoint4;
        if (latitudeE62 < 0.0d) {
            geoPoint4 = new GeoPoint(geoPoint);
            AppMethodBeat.m2505o(98212);
            return geoPoint4;
        } else if (latitudeE62 > 1.0d) {
            geoPoint4 = new GeoPoint(geoPoint2);
            AppMethodBeat.m2505o(98212);
            return geoPoint4;
        } else {
            geoPoint4 = new GeoPoint(((int) (((double) latitudeE6) * latitudeE62)) + geoPoint.getLatitudeE6(), ((int) (latitudeE62 * ((double) longitudeE6))) + geoPoint.getLongitudeE6());
            AppMethodBeat.m2505o(98212);
            return geoPoint4;
        }
    }

    public static double angle2Radian(double d) {
        return (3.141592653589793d * d) / 180.0d;
    }

    public static double radian2Angle(double d) {
        return (180.0d * d) / 3.141592653589793d;
    }
}
