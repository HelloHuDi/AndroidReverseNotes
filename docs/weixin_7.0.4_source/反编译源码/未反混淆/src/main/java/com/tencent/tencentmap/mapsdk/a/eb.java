package com.tencent.tencentmap.mapsdk.a;

import android.graphics.DashPathEffect;
import com.tencent.mapsdk.raster.model.Circle;
import com.tencent.mapsdk.raster.model.LatLng;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class eb implements Circle {
    private cq a;

    public eb(cq cqVar) {
        this.a = cqVar;
    }

    public void remove() {
        AppMethodBeat.i(101345);
        if (this.a != null) {
            this.a.b();
        }
        AppMethodBeat.o(101345);
    }

    public String getId() {
        AppMethodBeat.i(101346);
        if (this.a != null) {
            String c = this.a.c();
            AppMethodBeat.o(101346);
            return c;
        }
        AppMethodBeat.o(101346);
        return null;
    }

    public void setCenter(LatLng latLng) {
        AppMethodBeat.i(101347);
        if (this.a != null) {
            this.a.b(ej.a(latLng));
        }
        AppMethodBeat.o(101347);
    }

    public LatLng getCenter() {
        AppMethodBeat.i(101348);
        if (this.a != null) {
            LatLng a = ej.a(this.a.d());
            AppMethodBeat.o(101348);
            return a;
        }
        AppMethodBeat.o(101348);
        return null;
    }

    public void setRadius(double d) {
        AppMethodBeat.i(101349);
        if (this.a != null) {
            this.a.a(d);
        }
        AppMethodBeat.o(101349);
    }

    public double getRadius() {
        AppMethodBeat.i(101350);
        if (this.a != null) {
            double e = this.a.e();
            AppMethodBeat.o(101350);
            return e;
        }
        AppMethodBeat.o(101350);
        return 0.0d;
    }

    public void setStrokeWidth(float f) {
        AppMethodBeat.i(101351);
        if (this.a != null) {
            cq cqVar = this.a;
            if (f < 0.0f) {
                f = 0.0f;
            }
            cqVar.a(f / y.g());
        }
        AppMethodBeat.o(101351);
    }

    public float getStrokeWidth() {
        AppMethodBeat.i(101352);
        if (this.a != null) {
            float f = this.a.f() * y.g();
            AppMethodBeat.o(101352);
            return f;
        }
        AppMethodBeat.o(101352);
        return 0.0f;
    }

    public void setStrokeColor(int i) {
        AppMethodBeat.i(101353);
        if (this.a != null) {
            this.a.a(i);
        }
        AppMethodBeat.o(101353);
    }

    public int getStrokeColor() {
        AppMethodBeat.i(101354);
        if (this.a != null) {
            int g = this.a.g();
            AppMethodBeat.o(101354);
            return g;
        }
        AppMethodBeat.o(101354);
        return 0;
    }

    public void setFillColor(int i) {
        AppMethodBeat.i(101355);
        if (this.a != null) {
            this.a.b(i);
        }
        AppMethodBeat.o(101355);
    }

    public int getFillColor() {
        AppMethodBeat.i(101356);
        if (this.a != null) {
            int h = this.a.h();
            AppMethodBeat.o(101356);
            return h;
        }
        AppMethodBeat.o(101356);
        return 0;
    }

    public void setZIndex(float f) {
        AppMethodBeat.i(101357);
        if (this.a != null) {
            this.a.c((int) f);
        }
        AppMethodBeat.o(101357);
    }

    public float getZIndex() {
        AppMethodBeat.i(101358);
        if (this.a != null) {
            float i = (float) ((int) this.a.i());
            AppMethodBeat.o(101358);
            return i;
        }
        AppMethodBeat.o(101358);
        return 0.0f;
    }

    public void setLevel(int i) {
        AppMethodBeat.i(101359);
        if (this.a != null) {
            this.a.d(i);
        }
        AppMethodBeat.o(101359);
    }

    public int getLevel() {
        AppMethodBeat.i(101360);
        if (this.a != null) {
            int k = this.a.k();
            AppMethodBeat.o(101360);
            return k;
        }
        AppMethodBeat.o(101360);
        return 0;
    }

    public void setVisible(boolean z) {
        AppMethodBeat.i(101361);
        if (this.a != null) {
            this.a.a(z);
        }
        AppMethodBeat.o(101361);
    }

    public boolean isVisible() {
        AppMethodBeat.i(101362);
        if (this.a != null) {
            boolean j = this.a.j();
            AppMethodBeat.o(101362);
            return j;
        }
        AppMethodBeat.o(101362);
        return false;
    }

    public boolean contains(LatLng latLng) {
        AppMethodBeat.i(101363);
        if (this.a != null) {
            boolean a = this.a.a(ej.a(latLng));
            AppMethodBeat.o(101363);
            return a;
        }
        AppMethodBeat.o(101363);
        return false;
    }

    public void setStrokeDash(boolean z) {
    }

    public void strokeDashPathEffect(DashPathEffect dashPathEffect) {
    }

    public boolean getStrokeDash() {
        return false;
    }

    public DashPathEffect getStrokeDashPathEffect() {
        return null;
    }
}
