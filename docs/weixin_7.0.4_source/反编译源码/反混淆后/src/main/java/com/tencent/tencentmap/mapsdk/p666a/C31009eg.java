package com.tencent.tencentmap.mapsdk.p666a;

import android.graphics.Point;
import com.tencent.mapsdk.raster.model.GeoPoint;
import com.tencent.mapsdk.raster.model.LatLng;
import com.tencent.mapsdk.raster.model.VisibleRegion;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.map.Projection;

/* renamed from: com.tencent.tencentmap.mapsdk.a.eg */
public class C31009eg implements Projection {
    /* renamed from: a */
    private C30980ai f14025a;
    /* renamed from: b */
    private C30982aj f14026b;

    public C31009eg(C30982aj c30982aj) {
        AppMethodBeat.m2504i(101445);
        this.f14025a = c30982aj.mo50150m();
        this.f14026b = c30982aj;
        AppMethodBeat.m2505o(101445);
    }

    public LatLng fromScreenLocation(Point point) {
        AppMethodBeat.m2504i(101446);
        LatLng a = C41025ej.m71282a(this.f14025a.mo50098a(point));
        AppMethodBeat.m2505o(101446);
        return a;
    }

    public Point toScreenLocation(LatLng latLng) {
        AppMethodBeat.m2504i(101447);
        Point a = this.f14025a.mo50097a(C41025ej.m71291a(latLng));
        AppMethodBeat.m2505o(101447);
        return a;
    }

    public VisibleRegion getVisibleRegion() {
        AppMethodBeat.m2504i(101448);
        VisibleRegion a = C41025ej.m71285a(this.f14025a.mo50100b());
        AppMethodBeat.m2505o(101448);
        return a;
    }

    public double distanceBetween(LatLng latLng, LatLng latLng2) {
        AppMethodBeat.m2504i(101449);
        double a = C36477dz.m60314a(latLng, latLng2);
        AppMethodBeat.m2505o(101449);
        return a;
    }

    public float metersToEquatorPixels(float f) {
        AppMethodBeat.m2504i(101450);
        C36476dy.m60311a("call metersToEquatorPixels");
        float metersToPixels = metersToPixels(0.0d, (double) f);
        AppMethodBeat.m2505o(101450);
        return metersToPixels;
    }

    public float metersToPixels(double d, double d2) {
        AppMethodBeat.m2504i(101451);
        C36476dy.m60311a("call metersToPixels");
        float a = (float) (d2 / this.f14025a.mo50096a(d));
        AppMethodBeat.m2505o(101451);
        return a;
    }

    public double getLatitudeSpan() {
        AppMethodBeat.m2504i(101452);
        C46759do b = this.f14025a.mo50100b();
        if (b == null) {
            AppMethodBeat.m2505o(101452);
            return -1.0d;
        }
        double d = b.f18045e.f4617a.f4615a - b.f18045e.f4618b.f4615a;
        AppMethodBeat.m2505o(101452);
        return d;
    }

    public double getLongitudeSpan() {
        AppMethodBeat.m2504i(101453);
        C46759do b = this.f14025a.mo50100b();
        if (b == null) {
            AppMethodBeat.m2505o(101453);
            return -1.0d;
        }
        double d = b.f18045e.f4617a.f4616b - b.f18045e.f4618b.f4616b;
        AppMethodBeat.m2505o(101453);
        return d;
    }

    public float getScalePerPixel() {
        AppMethodBeat.m2504i(101454);
        float a = (float) this.f14025a.mo50096a(this.f14026b.mo50136d().f1462a.f4615a);
        AppMethodBeat.m2505o(101454);
        return a;
    }

    @Deprecated
    public Point toPixels(GeoPoint geoPoint, Point point) {
        AppMethodBeat.m2504i(101455);
        LatLng g2l = GeoPoint.g2l(geoPoint);
        if (g2l == null) {
            AppMethodBeat.m2505o(101455);
            return null;
        }
        Point toScreenLocation = toScreenLocation(g2l);
        AppMethodBeat.m2505o(101455);
        return toScreenLocation;
    }
}
