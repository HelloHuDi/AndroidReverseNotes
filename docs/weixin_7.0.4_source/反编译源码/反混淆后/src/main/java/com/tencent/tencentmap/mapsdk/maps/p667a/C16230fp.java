package com.tencent.tencentmap.mapsdk.maps.p667a;

import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.location.Location;
import com.tencent.map.lib.basemap.data.C45133b;
import com.tencent.map.lib.basemap.data.DoublePoint;
import com.tencent.map.lib.basemap.data.GeoPoint;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.tencentmap.mapsdk.maps.a.fp */
public class C16230fp implements C24374fw {
    /* renamed from: a */
    private C24382gs f3226a;
    /* renamed from: b */
    private C16238gh f3227b;
    /* renamed from: c */
    private C46789gm f3228c;

    public C16230fp(C24382gs c24382gs, C5876fn c5876fn) {
        AppMethodBeat.m2504i(98939);
        this.f3226a = c24382gs;
        this.f3227b = c5876fn.mo12445f();
        if (c5876fn instanceof C46789gm) {
            this.f3228c = (C46789gm) c5876fn;
        }
        AppMethodBeat.m2505o(98939);
    }

    /* renamed from: a */
    public GeoPoint mo29297a(DoublePoint doublePoint) {
        AppMethodBeat.m2504i(98940);
        if (doublePoint == null) {
            AppMethodBeat.m2505o(98940);
            return null;
        }
        byte[] r = this.f3226a.mo40627r();
        float f = (float) doublePoint.f2800x;
        float f2 = (float) doublePoint.f2801y;
        if (this.f3228c != null) {
            Rect p = this.f3228c.mo75464p();
            if (p != null) {
                f -= (float) p.left;
                f2 -= (float) p.top;
            }
        }
        GeoPoint a = this.f3227b.mo29313a(r, f, f2);
        AppMethodBeat.m2505o(98940);
        return a;
    }

    /* renamed from: b */
    public DoublePoint mo29298b(GeoPoint geoPoint) {
        AppMethodBeat.m2504i(98941);
        if (geoPoint == null) {
            AppMethodBeat.m2505o(98941);
            return null;
        }
        double latitudeE6 = ((double) geoPoint.getLatitudeE6()) / 1000000.0d;
        double longitudeE6 = ((double) geoPoint.getLongitudeE6()) / 1000000.0d;
        PointF a = this.f3227b.mo29312a(this.f3226a.mo40627r(), latitudeE6, longitudeE6);
        float f = a.x;
        float f2 = a.y;
        if (this.f3228c != null) {
            Rect p = this.f3228c.mo75464p();
            if (p != null) {
                f += (float) p.left;
                f2 += (float) p.top;
            }
        }
        DoublePoint doublePoint = new DoublePoint((double) f, (double) f2);
        AppMethodBeat.m2505o(98941);
        return doublePoint;
    }

    /* renamed from: a */
    public static DoublePoint m24761a(C24382gs c24382gs, GeoPoint geoPoint) {
        AppMethodBeat.m2504i(98942);
        if (c24382gs == null || geoPoint == null) {
            AppMethodBeat.m2505o(98942);
            return null;
        }
        double d = 0.0d;
        double d2 = 0.0d;
        int f = c24382gs.mo40614f() >> 1;
        double g = c24382gs.mo40615g();
        double h = c24382gs.mo40616h();
        if (geoPoint != null) {
            d2 = Math.min(Math.max(Math.sin((((double) geoPoint.getLatitudeE6()) / 1000000.0d) * 0.017453292519943295d), -0.9999d), 0.9999d);
            d = ((double) f) + (g * (((double) geoPoint.getLongitudeE6()) / 1000000.0d));
            d2 = ((Math.log((1.0d + d2) / (1.0d - d2)) * h) * 0.5d) + ((double) f);
        }
        DoublePoint doublePoint = new DoublePoint(d, d2);
        AppMethodBeat.m2505o(98942);
        return doublePoint;
    }

    /* renamed from: a */
    public double mo29295a(double d) {
        AppMethodBeat.m2504i(98943);
        double pow = (4.0076E7d / (Math.pow(2.0d, (double) ((float) (((double) ((float) this.f3226a.mo40619j())) + (Math.log((double) this.f3226a.mo40620k()) / Math.log(2.0d))))) * 256.0d)) * Math.cos((3.141592653589793d * d) / 180.0d);
        AppMethodBeat.m2505o(98943);
        return pow;
    }

    /* renamed from: a */
    public double mo29296a(Point point, Point point2) {
        AppMethodBeat.m2504i(98944);
        GeoPoint a = mo29297a(new DoublePoint((double) point.x, (double) point.y));
        GeoPoint a2 = mo29297a(new DoublePoint((double) point2.x, (double) point2.y));
        float[] fArr = new float[1];
        Location.distanceBetween(((double) a.getLatitudeE6()) / 1000000.0d, ((double) a.getLongitudeE6()) / 1000000.0d, ((double) a2.getLatitudeE6()) / 1000000.0d, ((double) a2.getLongitudeE6()) / 1000000.0d, fArr);
        double sqrt = (double) (fArr[0] / ((float) ((int) Math.sqrt(Math.pow((double) (point.x - point2.x), 2.0d) + Math.pow((double) (point.y - point2.y), 2.0d)))));
        AppMethodBeat.m2505o(98944);
        return sqrt;
    }

    /* renamed from: a */
    public static C45133b m24762a(GeoPoint geoPoint) {
        AppMethodBeat.m2504i(98945);
        if (geoPoint == null) {
            AppMethodBeat.m2505o(98945);
            return null;
        }
        C45133b c45133b = new C45133b(((((double) geoPoint.getLongitudeE6()) / 1000000.0d) * 2.003750834E7d) / 180.0d, ((Math.log(Math.tan((((((double) geoPoint.getLatitudeE6()) / 1000000.0d) + 90.0d) * 3.141592653589793d) / 360.0d)) / 0.017453292519943295d) * 2.003750834E7d) / 180.0d);
        AppMethodBeat.m2505o(98945);
        return c45133b;
    }
}
