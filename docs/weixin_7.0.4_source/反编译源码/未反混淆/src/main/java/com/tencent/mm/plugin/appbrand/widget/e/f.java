package com.tencent.mm.plugin.appbrand.widget.e;

import com.tencent.mapsdk.raster.model.LatLng;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class f {
    public static double jkp = 6378137.0d;
    final double jkq = (6.283185307179586d * jkp);

    public f() {
        AppMethodBeat.i(51276);
        AppMethodBeat.o(51276);
    }

    public final e b(LatLng latLng) {
        AppMethodBeat.i(51277);
        double longitude = (latLng.getLongitude() / 360.0d) + 0.5d;
        double sin = Math.sin(Math.toRadians(latLng.getLatitude()));
        e eVar = new e(longitude * this.jkq, (((Math.log((1.0d + sin) / (1.0d - sin)) * 0.5d) / -6.283185307179586d) + 0.5d) * this.jkq);
        AppMethodBeat.o(51277);
        return eVar;
    }
}
