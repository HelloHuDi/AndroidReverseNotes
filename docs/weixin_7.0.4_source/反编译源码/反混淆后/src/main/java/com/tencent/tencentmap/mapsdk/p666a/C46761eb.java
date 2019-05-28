package com.tencent.tencentmap.mapsdk.p666a;

import android.graphics.DashPathEffect;
import com.tencent.mapsdk.raster.model.Circle;
import com.tencent.mapsdk.raster.model.LatLng;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.tencentmap.mapsdk.a.eb */
public class C46761eb implements Circle {
    /* renamed from: a */
    private C5843cq f18046a;

    public C46761eb(C5843cq c5843cq) {
        this.f18046a = c5843cq;
    }

    public void remove() {
        AppMethodBeat.m2504i(101345);
        if (this.f18046a != null) {
            this.f18046a.mo12336b();
        }
        AppMethodBeat.m2505o(101345);
    }

    public String getId() {
        AppMethodBeat.m2504i(101346);
        if (this.f18046a != null) {
            String c = this.f18046a.mo12339c();
            AppMethodBeat.m2505o(101346);
            return c;
        }
        AppMethodBeat.m2505o(101346);
        return null;
    }

    public void setCenter(LatLng latLng) {
        AppMethodBeat.m2504i(101347);
        if (this.f18046a != null) {
            this.f18046a.mo12338b(C41025ej.m71291a(latLng));
        }
        AppMethodBeat.m2505o(101347);
    }

    public LatLng getCenter() {
        AppMethodBeat.m2504i(101348);
        if (this.f18046a != null) {
            LatLng a = C41025ej.m71282a(this.f18046a.mo12341d());
            AppMethodBeat.m2505o(101348);
            return a;
        }
        AppMethodBeat.m2505o(101348);
        return null;
    }

    public void setRadius(double d) {
        AppMethodBeat.m2504i(101349);
        if (this.f18046a != null) {
            this.f18046a.mo12331a(d);
        }
        AppMethodBeat.m2505o(101349);
    }

    public double getRadius() {
        AppMethodBeat.m2504i(101350);
        if (this.f18046a != null) {
            double e = this.f18046a.mo12343e();
            AppMethodBeat.m2505o(101350);
            return e;
        }
        AppMethodBeat.m2505o(101350);
        return 0.0d;
    }

    public void setStrokeWidth(float f) {
        AppMethodBeat.m2504i(101351);
        if (this.f18046a != null) {
            C5843cq c5843cq = this.f18046a;
            if (f < 0.0f) {
                f = 0.0f;
            }
            c5843cq.mo12332a(f / C24351y.m37638g());
        }
        AppMethodBeat.m2505o(101351);
    }

    public float getStrokeWidth() {
        AppMethodBeat.m2504i(101352);
        if (this.f18046a != null) {
            float f = this.f18046a.mo12345f() * C24351y.m37638g();
            AppMethodBeat.m2505o(101352);
            return f;
        }
        AppMethodBeat.m2505o(101352);
        return 0.0f;
    }

    public void setStrokeColor(int i) {
        AppMethodBeat.m2504i(101353);
        if (this.f18046a != null) {
            this.f18046a.mo12333a(i);
        }
        AppMethodBeat.m2505o(101353);
    }

    public int getStrokeColor() {
        AppMethodBeat.m2504i(101354);
        if (this.f18046a != null) {
            int g = this.f18046a.mo12346g();
            AppMethodBeat.m2505o(101354);
            return g;
        }
        AppMethodBeat.m2505o(101354);
        return 0;
    }

    public void setFillColor(int i) {
        AppMethodBeat.m2504i(101355);
        if (this.f18046a != null) {
            this.f18046a.mo12337b(i);
        }
        AppMethodBeat.m2505o(101355);
    }

    public int getFillColor() {
        AppMethodBeat.m2504i(101356);
        if (this.f18046a != null) {
            int h = this.f18046a.mo12347h();
            AppMethodBeat.m2505o(101356);
            return h;
        }
        AppMethodBeat.m2505o(101356);
        return 0;
    }

    public void setZIndex(float f) {
        AppMethodBeat.m2504i(101357);
        if (this.f18046a != null) {
            this.f18046a.mo12340c((int) f);
        }
        AppMethodBeat.m2505o(101357);
    }

    public float getZIndex() {
        AppMethodBeat.m2504i(101358);
        if (this.f18046a != null) {
            float i = (float) ((int) this.f18046a.mo12349i());
            AppMethodBeat.m2505o(101358);
            return i;
        }
        AppMethodBeat.m2505o(101358);
        return 0.0f;
    }

    public void setLevel(int i) {
        AppMethodBeat.m2504i(101359);
        if (this.f18046a != null) {
            this.f18046a.mo12342d(i);
        }
        AppMethodBeat.m2505o(101359);
    }

    public int getLevel() {
        AppMethodBeat.m2504i(101360);
        if (this.f18046a != null) {
            int k = this.f18046a.mo12351k();
            AppMethodBeat.m2505o(101360);
            return k;
        }
        AppMethodBeat.m2505o(101360);
        return 0;
    }

    public void setVisible(boolean z) {
        AppMethodBeat.m2504i(101361);
        if (this.f18046a != null) {
            this.f18046a.mo12334a(z);
        }
        AppMethodBeat.m2505o(101361);
    }

    public boolean isVisible() {
        AppMethodBeat.m2504i(101362);
        if (this.f18046a != null) {
            boolean j = this.f18046a.mo12350j();
            AppMethodBeat.m2505o(101362);
            return j;
        }
        AppMethodBeat.m2505o(101362);
        return false;
    }

    public boolean contains(LatLng latLng) {
        AppMethodBeat.m2504i(101363);
        if (this.f18046a != null) {
            boolean a = this.f18046a.mo12335a(C41025ej.m71291a(latLng));
            AppMethodBeat.m2505o(101363);
            return a;
        }
        AppMethodBeat.m2505o(101363);
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
