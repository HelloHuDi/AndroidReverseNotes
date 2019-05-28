package com.tencent.tencentmap.mapsdk.maps.p667a;

import com.tencent.map.lib.basemap.data.DoublePoint;
import com.tencent.map.lib.basemap.data.GeoPoint;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.tencentmap.mapsdk.maps.a.jy */
public class C44528jy {
    /* renamed from: a */
    private double f17467a = 2.68435456E8d;
    /* renamed from: b */
    private double f17468b = (this.f17467a / 2.0d);
    /* renamed from: c */
    private double f17469c = (this.f17467a / 360.0d);
    /* renamed from: d */
    private double f17470d = (this.f17467a / 6.283185307179586d);
    /* renamed from: e */
    private C24382gs f17471e;
    /* renamed from: f */
    private C31061iz f17472f;

    public C44528jy(C31061iz c31061iz) {
        AppMethodBeat.m2504i(100152);
        this.f17472f = c31061iz;
        this.f17471e = this.f17472f.mo75386b().mo20138A();
        AppMethodBeat.m2505o(100152);
    }

    /* renamed from: a */
    public C24382gs mo70910a() {
        return this.f17471e;
    }

    /* renamed from: a */
    public double mo70908a(int i) {
        return ((double) (1 << i)) / 1048576.0d;
    }

    /* renamed from: a */
    public DoublePoint mo70909a(GeoPoint geoPoint) {
        double min;
        double longitudeE6;
        AppMethodBeat.m2504i(100153);
        if (geoPoint != null) {
            min = Math.min(Math.max(Math.sin((((double) geoPoint.getLatitudeE6()) / 1000000.0d) * 0.017453292519943295d), -0.9999d), 0.9999d);
            min = (3.141592653589793d - (Math.log((1.0d + min) / (1.0d - min)) * 0.5d)) * this.f17470d;
            longitudeE6 = this.f17468b + ((((double) geoPoint.getLongitudeE6()) / 1000000.0d) * this.f17469c);
        } else {
            min = 0.0d;
            longitudeE6 = 0.0d;
        }
        DoublePoint doublePoint = new DoublePoint(longitudeE6, min);
        AppMethodBeat.m2505o(100153);
        return doublePoint;
    }
}
