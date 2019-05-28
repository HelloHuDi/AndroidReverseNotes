package com.tencent.p177mm.plugin.appbrand.widget.p1235e;

import com.tencent.mapsdk.raster.model.LatLng;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.plugin.appbrand.widget.e.f */
public final class C27392f {
    public static double jkp = 6378137.0d;
    final double jkq = (6.283185307179586d * jkp);

    public C27392f() {
        AppMethodBeat.m2504i(51276);
        AppMethodBeat.m2505o(51276);
    }

    /* renamed from: b */
    public final C19855e mo45130b(LatLng latLng) {
        AppMethodBeat.m2504i(51277);
        double longitude = (latLng.getLongitude() / 360.0d) + 0.5d;
        double sin = Math.sin(Math.toRadians(latLng.getLatitude()));
        C19855e c19855e = new C19855e(longitude * this.jkq, (((Math.log((1.0d + sin) / (1.0d - sin)) * 0.5d) / -6.283185307179586d) + 0.5d) * this.jkq);
        AppMethodBeat.m2505o(51277);
        return c19855e;
    }
}
