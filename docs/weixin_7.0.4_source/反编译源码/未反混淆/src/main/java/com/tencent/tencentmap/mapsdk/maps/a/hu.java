package com.tencent.tencentmap.mapsdk.maps.a;

import android.graphics.Rect;
import com.tencent.map.lib.basemap.data.DoublePoint;
import com.tencent.map.lib.basemap.data.GeoPoint;
import com.tencent.map.lib.basemap.data.b;
import com.tencent.map.lib.element.j;
import com.tencent.map.lib.mapstructure.CircleInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.a.cr;
import com.tencent.tencentmap.mapsdk.a.db;
import javax.microedition.khronos.opengles.GL10;

public class hu extends hz implements j {
    private GeoPoint a = new GeoPoint(39909230, 116397428);
    private double b = 0.0d;
    private float c = 1000.0f;
    private iz d = null;
    private cr e;
    private int f = -1;
    private CircleInfo g = new CircleInfo();

    public hu(iz izVar) {
        AppMethodBeat.i(99586);
        this.d = izVar;
        AppMethodBeat.o(99586);
    }

    public void a(cr crVar) {
        AppMethodBeat.i(99587);
        if (crVar == null) {
            AppMethodBeat.o(99587);
            return;
        }
        this.e = crVar;
        db a = crVar.a();
        if (a != null) {
            a(ic.a(a));
        }
        a(crVar.b());
        d(crVar.c());
        c(crVar.d());
        d(crVar.e());
        c((float) crVar.f());
        a(crVar.g());
        a_(crVar.h());
        this.e = crVar;
        this.P = true;
        AppMethodBeat.o(99587);
    }

    public void a(GeoPoint geoPoint) {
        AppMethodBeat.i(99588);
        if (geoPoint == null) {
            AppMethodBeat.o(99588);
            return;
        }
        if (this.a == null) {
            this.a = new GeoPoint(geoPoint.getLatitudeE6(), geoPoint.getLongitudeE6());
        } else {
            this.a.setLatitudeE6(geoPoint.getLatitudeE6());
            this.a.setLongitudeE6(geoPoint.getLongitudeE6());
        }
        this.P = true;
        AppMethodBeat.o(99588);
    }

    public void a(double d) {
        AppMethodBeat.i(99589);
        if (d < 0.0d) {
            AppMethodBeat.o(99589);
            return;
        }
        if (d == 0.0d) {
            d = 1.0E-10d;
        }
        if (this.e == null || this.e.a() == null) {
            AppMethodBeat.o(99589);
            return;
        }
        this.b = d;
        this.c = (float) ic.a(d, this.e.a().a);
        this.P = true;
        AppMethodBeat.o(99589);
    }

    public void a(GL10 gl10) {
        AppMethodBeat.i(99590);
        if (this.d == null || this.d.b() == null) {
            AppMethodBeat.o(99590);
            return;
        }
        c();
        AppMethodBeat.o(99590);
    }

    public boolean a(float f, float f2) {
        AppMethodBeat.i(99591);
        if (this.a == null || this.d == null || this.d.b() == null) {
            AppMethodBeat.o(99591);
            return false;
        }
        GeoPoint a = this.d.b().t().a(new DoublePoint((double) f, (double) f2));
        if (Math.hypot((double) (a.getLatitudeE6() - this.a.getLatitudeE6()), (double) (a.getLongitudeE6() - this.a.getLongitudeE6())) <= ((double) this.c)) {
            AppMethodBeat.o(99591);
            return true;
        }
        AppMethodBeat.o(99591);
        return false;
    }

    public boolean a() {
        return this.O;
    }

    public void a(boolean z) {
        this.O = z;
        this.P = true;
    }

    public void b() {
    }

    public void c() {
        AppMethodBeat.i(99592);
        if ((this.f > 0 && !this.P) || this.d == null || this.d.b() == null) {
            AppMethodBeat.o(99592);
            return;
        }
        this.g.zIndex = (int) this.N;
        this.g.borderColor = this.M;
        this.g.borderWidth = (int) this.K;
        this.g.fillColor = this.L;
        this.g.radius = (float) this.b;
        this.g.centerX = this.a.getLongitudeE6();
        this.g.centerY = this.a.getLatitudeE6();
        this.g.isVisible = this.O;
        this.g.level = this.Q;
        if (this.f == -1) {
            this.f = this.d.b().a(this.g);
        } else if (this.P) {
            this.d.b().a(this.f, this.g);
        }
        this.P = false;
        AppMethodBeat.o(99592);
    }

    public void d() {
        AppMethodBeat.i(99593);
        if (!(this.f == -1 || this.d == null || this.d.b() == null)) {
            this.d.b().d(this.f);
            this.f = -1;
        }
        AppMethodBeat.o(99593);
    }

    public void b(gj gjVar, fw fwVar) {
    }

    public boolean a(fw fwVar, float f, float f2) {
        return false;
    }

    public Rect a(fw fwVar) {
        AppMethodBeat.i(99594);
        double a = a(this.b, ((double) this.a.getLatitudeE6()) / 1000000.0d);
        b a2 = a(new db(((double) this.a.getLatitudeE6()) / 1000000.0d, ((double) this.a.getLongitudeE6()) / 1000000.0d));
        b bVar = new b(a2.b() - a, a2.a() + a);
        b bVar2 = new b(a2.b() + a, a2.a() - a);
        db a3 = a(bVar);
        db a4 = a(bVar2);
        Rect rect = new Rect();
        rect.left = (int) (a3.b * 1000000.0d);
        rect.top = (int) (a3.a * 1000000.0d);
        rect.right = (int) (a4.b * 1000000.0d);
        rect.bottom = (int) (a4.a * 1000000.0d);
        AppMethodBeat.o(99594);
        return rect;
    }

    private double a(double d, double d2) {
        AppMethodBeat.i(99595);
        double cos = d / Math.cos((3.141592653589793d * d2) / 180.0d);
        AppMethodBeat.o(99595);
        return cos;
    }

    private b a(db dbVar) {
        AppMethodBeat.i(99596);
        if (dbVar == null) {
            AppMethodBeat.o(99596);
            return null;
        }
        b bVar = new b((dbVar.b * 2.003750834E7d) / 180.0d, ((Math.log(Math.tan(((dbVar.a + 90.0d) * 3.141592653589793d) / 360.0d)) / 0.017453292519943295d) * 2.003750834E7d) / 180.0d);
        AppMethodBeat.o(99596);
        return bVar;
    }

    private db a(b bVar) {
        AppMethodBeat.i(99597);
        db dbVar = new db((double) ((float) (57.29577951308232d * ((2.0d * Math.atan(Math.exp((((double) ((float) ((bVar.a() * 180.0d) / 2.003750834E7d))) * 3.141592653589793d) / 180.0d))) - 1.5707963267948966d))), (double) ((float) ((bVar.b() * 180.0d) / 2.003750834E7d)));
        AppMethodBeat.o(99597);
        return dbVar;
    }
}
