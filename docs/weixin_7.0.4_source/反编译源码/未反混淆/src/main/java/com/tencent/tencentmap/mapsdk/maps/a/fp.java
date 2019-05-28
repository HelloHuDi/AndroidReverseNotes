package com.tencent.tencentmap.mapsdk.maps.a;

import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.location.Location;
import com.tencent.map.lib.basemap.data.DoublePoint;
import com.tencent.map.lib.basemap.data.GeoPoint;
import com.tencent.map.lib.basemap.data.b;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class fp implements fw {
    private gs a;
    private gh b;
    private gm c;

    public fp(gs gsVar, fn fnVar) {
        AppMethodBeat.i(98939);
        this.a = gsVar;
        this.b = fnVar.f();
        if (fnVar instanceof gm) {
            this.c = (gm) fnVar;
        }
        AppMethodBeat.o(98939);
    }

    public GeoPoint a(DoublePoint doublePoint) {
        AppMethodBeat.i(98940);
        if (doublePoint == null) {
            AppMethodBeat.o(98940);
            return null;
        }
        byte[] r = this.a.r();
        float f = (float) doublePoint.x;
        float f2 = (float) doublePoint.y;
        if (this.c != null) {
            Rect p = this.c.p();
            if (p != null) {
                f -= (float) p.left;
                f2 -= (float) p.top;
            }
        }
        GeoPoint a = this.b.a(r, f, f2);
        AppMethodBeat.o(98940);
        return a;
    }

    public DoublePoint b(GeoPoint geoPoint) {
        AppMethodBeat.i(98941);
        if (geoPoint == null) {
            AppMethodBeat.o(98941);
            return null;
        }
        double latitudeE6 = ((double) geoPoint.getLatitudeE6()) / 1000000.0d;
        double longitudeE6 = ((double) geoPoint.getLongitudeE6()) / 1000000.0d;
        PointF a = this.b.a(this.a.r(), latitudeE6, longitudeE6);
        float f = a.x;
        float f2 = a.y;
        if (this.c != null) {
            Rect p = this.c.p();
            if (p != null) {
                f += (float) p.left;
                f2 += (float) p.top;
            }
        }
        DoublePoint doublePoint = new DoublePoint((double) f, (double) f2);
        AppMethodBeat.o(98941);
        return doublePoint;
    }

    public static DoublePoint a(gs gsVar, GeoPoint geoPoint) {
        AppMethodBeat.i(98942);
        if (gsVar == null || geoPoint == null) {
            AppMethodBeat.o(98942);
            return null;
        }
        double d = 0.0d;
        double d2 = 0.0d;
        int f = gsVar.f() >> 1;
        double g = gsVar.g();
        double h = gsVar.h();
        if (geoPoint != null) {
            d2 = Math.min(Math.max(Math.sin((((double) geoPoint.getLatitudeE6()) / 1000000.0d) * 0.017453292519943295d), -0.9999d), 0.9999d);
            d = ((double) f) + (g * (((double) geoPoint.getLongitudeE6()) / 1000000.0d));
            d2 = ((Math.log((1.0d + d2) / (1.0d - d2)) * h) * 0.5d) + ((double) f);
        }
        DoublePoint doublePoint = new DoublePoint(d, d2);
        AppMethodBeat.o(98942);
        return doublePoint;
    }

    public double a(double d) {
        AppMethodBeat.i(98943);
        double pow = (4.0076E7d / (Math.pow(2.0d, (double) ((float) (((double) ((float) this.a.j())) + (Math.log((double) this.a.k()) / Math.log(2.0d))))) * 256.0d)) * Math.cos((3.141592653589793d * d) / 180.0d);
        AppMethodBeat.o(98943);
        return pow;
    }

    public double a(Point point, Point point2) {
        AppMethodBeat.i(98944);
        GeoPoint a = a(new DoublePoint((double) point.x, (double) point.y));
        GeoPoint a2 = a(new DoublePoint((double) point2.x, (double) point2.y));
        float[] fArr = new float[1];
        Location.distanceBetween(((double) a.getLatitudeE6()) / 1000000.0d, ((double) a.getLongitudeE6()) / 1000000.0d, ((double) a2.getLatitudeE6()) / 1000000.0d, ((double) a2.getLongitudeE6()) / 1000000.0d, fArr);
        double sqrt = (double) (fArr[0] / ((float) ((int) Math.sqrt(Math.pow((double) (point.x - point2.x), 2.0d) + Math.pow((double) (point.y - point2.y), 2.0d)))));
        AppMethodBeat.o(98944);
        return sqrt;
    }

    public static b a(GeoPoint geoPoint) {
        AppMethodBeat.i(98945);
        if (geoPoint == null) {
            AppMethodBeat.o(98945);
            return null;
        }
        b bVar = new b(((((double) geoPoint.getLongitudeE6()) / 1000000.0d) * 2.003750834E7d) / 180.0d, ((Math.log(Math.tan((((((double) geoPoint.getLatitudeE6()) / 1000000.0d) + 90.0d) * 3.141592653589793d) / 360.0d)) / 0.017453292519943295d) * 2.003750834E7d) / 180.0d);
        AppMethodBeat.o(98945);
        return bVar;
    }
}
