package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.map.lib.basemap.data.DoublePoint;
import com.tencent.map.lib.basemap.data.GeoPoint;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class jy {
    private double a = 2.68435456E8d;
    private double b = (this.a / 2.0d);
    private double c = (this.a / 360.0d);
    private double d = (this.a / 6.283185307179586d);
    private gs e;
    private iz f;

    public jy(iz izVar) {
        AppMethodBeat.i(100152);
        this.f = izVar;
        this.e = this.f.b().A();
        AppMethodBeat.o(100152);
    }

    public gs a() {
        return this.e;
    }

    public double a(int i) {
        return ((double) (1 << i)) / 1048576.0d;
    }

    public DoublePoint a(GeoPoint geoPoint) {
        double min;
        double longitudeE6;
        AppMethodBeat.i(100153);
        if (geoPoint != null) {
            min = Math.min(Math.max(Math.sin((((double) geoPoint.getLatitudeE6()) / 1000000.0d) * 0.017453292519943295d), -0.9999d), 0.9999d);
            min = (3.141592653589793d - (Math.log((1.0d + min) / (1.0d - min)) * 0.5d)) * this.d;
            longitudeE6 = this.b + ((((double) geoPoint.getLongitudeE6()) / 1000000.0d) * this.c);
        } else {
            min = 0.0d;
            longitudeE6 = 0.0d;
        }
        DoublePoint doublePoint = new DoublePoint(longitudeE6, min);
        AppMethodBeat.o(100153);
        return doublePoint;
    }
}
