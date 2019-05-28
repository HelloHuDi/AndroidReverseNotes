package com.tencent.tencentmap.mapsdk.a;

import android.graphics.Point;
import com.tencent.mapsdk.raster.model.GeoPoint;
import com.tencent.mapsdk.raster.model.LatLng;
import com.tencent.mapsdk.raster.model.VisibleRegion;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.map.Projection;

public class eg implements Projection {
    private ai a;
    private aj b;

    public eg(aj ajVar) {
        AppMethodBeat.i(101445);
        this.a = ajVar.m();
        this.b = ajVar;
        AppMethodBeat.o(101445);
    }

    public LatLng fromScreenLocation(Point point) {
        AppMethodBeat.i(101446);
        LatLng a = ej.a(this.a.a(point));
        AppMethodBeat.o(101446);
        return a;
    }

    public Point toScreenLocation(LatLng latLng) {
        AppMethodBeat.i(101447);
        Point a = this.a.a(ej.a(latLng));
        AppMethodBeat.o(101447);
        return a;
    }

    public VisibleRegion getVisibleRegion() {
        AppMethodBeat.i(101448);
        VisibleRegion a = ej.a(this.a.b());
        AppMethodBeat.o(101448);
        return a;
    }

    public double distanceBetween(LatLng latLng, LatLng latLng2) {
        AppMethodBeat.i(101449);
        double a = dz.a(latLng, latLng2);
        AppMethodBeat.o(101449);
        return a;
    }

    public float metersToEquatorPixels(float f) {
        AppMethodBeat.i(101450);
        dy.a("call metersToEquatorPixels");
        float metersToPixels = metersToPixels(0.0d, (double) f);
        AppMethodBeat.o(101450);
        return metersToPixels;
    }

    public float metersToPixels(double d, double d2) {
        AppMethodBeat.i(101451);
        dy.a("call metersToPixels");
        float a = (float) (d2 / this.a.a(d));
        AppMethodBeat.o(101451);
        return a;
    }

    public double getLatitudeSpan() {
        AppMethodBeat.i(101452);
        do b = this.a.b();
        if (b == null) {
            AppMethodBeat.o(101452);
            return -1.0d;
        }
        double d = b.e.a.a - b.e.b.a;
        AppMethodBeat.o(101452);
        return d;
    }

    public double getLongitudeSpan() {
        AppMethodBeat.i(101453);
        do b = this.a.b();
        if (b == null) {
            AppMethodBeat.o(101453);
            return -1.0d;
        }
        double d = b.e.a.b - b.e.b.b;
        AppMethodBeat.o(101453);
        return d;
    }

    public float getScalePerPixel() {
        AppMethodBeat.i(101454);
        float a = (float) this.a.a(this.b.d().a.a);
        AppMethodBeat.o(101454);
        return a;
    }

    @Deprecated
    public Point toPixels(GeoPoint geoPoint, Point point) {
        AppMethodBeat.i(101455);
        LatLng g2l = GeoPoint.g2l(geoPoint);
        if (g2l == null) {
            AppMethodBeat.o(101455);
            return null;
        }
        Point toScreenLocation = toScreenLocation(g2l);
        AppMethodBeat.o(101455);
        return toScreenLocation;
    }
}
