package com.tencent.tencentmap.mapsdk.maps.p667a;

import android.view.animation.Interpolator;
import com.tencent.map.lib.basemap.data.GeoPoint;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.tencentmap.mapsdk.maps.a.ik */
public class C44524ik extends C31056if {
    /* renamed from: e */
    private GeoPoint f17443e = null;
    /* renamed from: f */
    private GeoPoint f17444f = null;
    /* renamed from: g */
    private boolean f17445g = false;

    public C44524ik(GeoPoint geoPoint) {
        AppMethodBeat.m2504i(99846);
        if (geoPoint != null) {
            this.f17444f = new GeoPoint(geoPoint.getLatitudeE6(), geoPoint.getLongitudeE6());
            this.f17445g = true;
        }
        AppMethodBeat.m2505o(99846);
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: a */
    public void mo29509a(float f, Interpolator interpolator) {
        AppMethodBeat.m2504i(99847);
        if (this.f17444f == null || this.f17443e == null) {
            AppMethodBeat.m2505o(99847);
            return;
        }
        int latitudeE6 = this.f17444f.getLatitudeE6() - this.f17443e.getLatitudeE6();
        int longitudeE6 = this.f17444f.getLongitudeE6() - this.f17443e.getLongitudeE6();
        float interpolation = interpolator.getInterpolation(f);
        latitudeE6 = ((int) (((float) latitudeE6) * interpolation)) + this.f17443e.getLatitudeE6();
        longitudeE6 = ((int) (((float) longitudeE6) * interpolation)) + this.f17443e.getLongitudeE6();
        if (this.f14163d != null) {
            this.f14163d.mo29456a(latitudeE6, longitudeE6);
        }
        AppMethodBeat.m2505o(99847);
    }

    /* renamed from: a */
    public boolean mo29512a(GeoPoint geoPoint, GeoPoint geoPoint2) {
        AppMethodBeat.m2504i(99848);
        if (super.mo29512a(null, null)) {
            if (geoPoint != null) {
                this.f17443e = new GeoPoint(geoPoint.getLatitudeE6(), geoPoint.getLongitudeE6());
            }
            if (!(this.f17445g || geoPoint2 == null)) {
                this.f17444f = new GeoPoint(geoPoint2.getLatitudeE6(), geoPoint2.getLongitudeE6());
            }
            AppMethodBeat.m2505o(99848);
            return true;
        }
        AppMethodBeat.m2505o(99848);
        return false;
    }
}
