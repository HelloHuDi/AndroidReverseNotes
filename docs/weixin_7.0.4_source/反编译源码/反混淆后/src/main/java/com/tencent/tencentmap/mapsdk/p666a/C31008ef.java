package com.tencent.tencentmap.mapsdk.p666a;

import com.tencent.mapsdk.raster.model.LatLng;
import com.tencent.mapsdk.raster.model.Polygon;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

/* renamed from: com.tencent.tencentmap.mapsdk.a.ef */
public class C31008ef implements Polygon {
    /* renamed from: a */
    private C31002dj f14024a;

    public C31008ef(C31002dj c31002dj) {
        this.f14024a = c31002dj;
    }

    public void remove() {
        AppMethodBeat.m2504i(101410);
        if (this.f14024a != null) {
            this.f14024a.mo50200b();
        }
        AppMethodBeat.m2505o(101410);
    }

    public String getId() {
        AppMethodBeat.m2504i(101411);
        if (this.f14024a != null) {
            String c = this.f14024a.mo50202c();
            AppMethodBeat.m2505o(101411);
            return c;
        }
        AppMethodBeat.m2505o(101411);
        return null;
    }

    public void setPoints(List<LatLng> list) {
        AppMethodBeat.m2504i(101412);
        if (this.f14024a != null) {
            this.f14024a.mo50197a(C41025ej.m71298b((List) list));
        }
        AppMethodBeat.m2505o(101412);
    }

    public List<LatLng> getPoints() {
        AppMethodBeat.m2504i(101413);
        if (this.f14024a != null) {
            List a = C41025ej.m71296a(this.f14024a.mo50204d());
            AppMethodBeat.m2505o(101413);
            return a;
        }
        AppMethodBeat.m2505o(101413);
        return null;
    }

    public void setStrokeWidth(float f) {
        AppMethodBeat.m2504i(101414);
        if (this.f14024a != null) {
            C31002dj c31002dj = this.f14024a;
            if (f < 0.0f) {
                f = 0.0f;
            }
            c31002dj.mo50195a(f / C24351y.m37638g());
        }
        AppMethodBeat.m2505o(101414);
    }

    public float getStrokeWidth() {
        AppMethodBeat.m2504i(101415);
        if (this.f14024a != null) {
            float e = this.f14024a.mo50206e() * C24351y.m37638g();
            AppMethodBeat.m2505o(101415);
            return e;
        }
        AppMethodBeat.m2505o(101415);
        return 0.0f;
    }

    public void setStrokeColor(int i) {
        AppMethodBeat.m2504i(101416);
        if (this.f14024a != null) {
            this.f14024a.mo50196a(i);
        }
        AppMethodBeat.m2505o(101416);
    }

    public int getStrokeColor() {
        AppMethodBeat.m2504i(101417);
        if (this.f14024a != null) {
            int f = this.f14024a.mo50208f();
            AppMethodBeat.m2505o(101417);
            return f;
        }
        AppMethodBeat.m2505o(101417);
        return 0;
    }

    public void setFillColor(int i) {
        AppMethodBeat.m2504i(101418);
        if (this.f14024a != null) {
            this.f14024a.mo50201b(i);
        }
        AppMethodBeat.m2505o(101418);
    }

    public int getFillColor() {
        AppMethodBeat.m2504i(101419);
        if (this.f14024a != null) {
            int g = this.f14024a.mo50209g();
            AppMethodBeat.m2505o(101419);
            return g;
        }
        AppMethodBeat.m2505o(101419);
        return 0;
    }

    public void setZIndex(float f) {
        AppMethodBeat.m2504i(101420);
        if (this.f14024a != null) {
            this.f14024a.mo50203c((int) f);
        }
        AppMethodBeat.m2505o(101420);
    }

    public float getZIndex() {
        AppMethodBeat.m2504i(101421);
        if (this.f14024a != null) {
            float h = (float) ((int) this.f14024a.mo50210h());
            AppMethodBeat.m2505o(101421);
            return h;
        }
        AppMethodBeat.m2505o(101421);
        return 0.0f;
    }

    public void setLevel(int i) {
        AppMethodBeat.m2504i(101422);
        if (this.f14024a != null) {
            this.f14024a.mo50205d(i);
        }
        AppMethodBeat.m2505o(101422);
    }

    public int getLevel() {
        AppMethodBeat.m2504i(101423);
        if (this.f14024a != null) {
            int j = this.f14024a.mo50213j();
            AppMethodBeat.m2505o(101423);
            return j;
        }
        AppMethodBeat.m2505o(101423);
        return 0;
    }

    public void setVisible(boolean z) {
        AppMethodBeat.m2504i(101424);
        if (this.f14024a != null) {
            this.f14024a.mo50198a(z);
        }
        AppMethodBeat.m2505o(101424);
    }

    public boolean isVisible() {
        AppMethodBeat.m2504i(101425);
        if (this.f14024a != null) {
            boolean i = this.f14024a.mo50212i();
            AppMethodBeat.m2505o(101425);
            return i;
        }
        AppMethodBeat.m2505o(101425);
        return false;
    }

    public boolean contains(LatLng latLng) {
        AppMethodBeat.m2504i(101426);
        if (this.f14024a != null) {
            boolean a = this.f14024a.mo50199a(C41025ej.m71291a(latLng));
            AppMethodBeat.m2505o(101426);
            return a;
        }
        AppMethodBeat.m2505o(101426);
        return false;
    }
}
