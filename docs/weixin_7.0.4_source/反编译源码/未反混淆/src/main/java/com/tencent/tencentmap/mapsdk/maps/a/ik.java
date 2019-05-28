package com.tencent.tencentmap.mapsdk.maps.a;

import android.view.animation.Interpolator;
import com.tencent.map.lib.basemap.data.GeoPoint;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class ik extends if {
    private GeoPoint e = null;
    private GeoPoint f = null;
    private boolean g = false;

    public ik(GeoPoint geoPoint) {
        AppMethodBeat.i(99846);
        if (geoPoint != null) {
            this.f = new GeoPoint(geoPoint.getLatitudeE6(), geoPoint.getLongitudeE6());
            this.g = true;
        }
        AppMethodBeat.o(99846);
    }

    /* Access modifiers changed, original: protected */
    public void a(float f, Interpolator interpolator) {
        AppMethodBeat.i(99847);
        if (this.f == null || this.e == null) {
            AppMethodBeat.o(99847);
            return;
        }
        int latitudeE6 = this.f.getLatitudeE6() - this.e.getLatitudeE6();
        int longitudeE6 = this.f.getLongitudeE6() - this.e.getLongitudeE6();
        float interpolation = interpolator.getInterpolation(f);
        latitudeE6 = ((int) (((float) latitudeE6) * interpolation)) + this.e.getLatitudeE6();
        longitudeE6 = ((int) (((float) longitudeE6) * interpolation)) + this.e.getLongitudeE6();
        if (this.d != null) {
            this.d.a(latitudeE6, longitudeE6);
        }
        AppMethodBeat.o(99847);
    }

    public boolean a(GeoPoint geoPoint, GeoPoint geoPoint2) {
        AppMethodBeat.i(99848);
        if (super.a(null, null)) {
            if (geoPoint != null) {
                this.e = new GeoPoint(geoPoint.getLatitudeE6(), geoPoint.getLongitudeE6());
            }
            if (!(this.g || geoPoint2 == null)) {
                this.f = new GeoPoint(geoPoint2.getLatitudeE6(), geoPoint2.getLongitudeE6());
            }
            AppMethodBeat.o(99848);
            return true;
        }
        AppMethodBeat.o(99848);
        return false;
    }
}
