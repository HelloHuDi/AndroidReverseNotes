package com.tencent.tencentmap.mapsdk.p666a;

import com.tencent.mapsdk.raster.model.BitmapDescriptor;
import com.tencent.mapsdk.raster.model.LatLng;
import com.tencent.mapsdk.raster.model.Polyline;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

/* renamed from: com.tencent.tencentmap.mapsdk.a.ee */
public class C16194ee implements Polyline {
    /* renamed from: a */
    private C31003dl f3098a;

    public C16194ee(C31003dl c31003dl) {
        this.f3098a = c31003dl;
    }

    public void remove() {
        AppMethodBeat.m2504i(101427);
        if (this.f3098a != null) {
            this.f3098a.mo50220b();
        }
        AppMethodBeat.m2505o(101427);
    }

    public String getId() {
        AppMethodBeat.m2504i(101428);
        if (this.f3098a != null) {
            String c = this.f3098a.mo50223c();
            AppMethodBeat.m2505o(101428);
            return c;
        }
        AppMethodBeat.m2505o(101428);
        return null;
    }

    public void setPoints(List<LatLng> list) {
        AppMethodBeat.m2504i(101429);
        if (this.f3098a != null) {
            this.f3098a.mo50218a(C41025ej.m71298b((List) list));
        }
        AppMethodBeat.m2505o(101429);
    }

    public List<LatLng> getPoints() {
        AppMethodBeat.m2504i(101430);
        if (this.f3098a != null) {
            List a = C41025ej.m71296a(this.f3098a.mo50225d());
            AppMethodBeat.m2505o(101430);
            return a;
        }
        AppMethodBeat.m2505o(101430);
        return null;
    }

    public void setWidth(float f) {
        AppMethodBeat.m2504i(101431);
        if (this.f3098a != null) {
            C31003dl c31003dl = this.f3098a;
            if (f < 0.0f) {
                f = 0.0f;
            }
            c31003dl.mo50214a(f);
        }
        AppMethodBeat.m2505o(101431);
    }

    public float getWidth() {
        AppMethodBeat.m2504i(101432);
        if (this.f3098a != null) {
            float e = this.f3098a.mo50226e();
            AppMethodBeat.m2505o(101432);
            return e;
        }
        AppMethodBeat.m2505o(101432);
        return 0.0f;
    }

    public void setColor(int i) {
        AppMethodBeat.m2504i(101433);
        if (this.f3098a != null) {
            this.f3098a.mo50215a(i);
        }
        AppMethodBeat.m2505o(101433);
    }

    public int getColor() {
        AppMethodBeat.m2504i(101434);
        if (this.f3098a != null) {
            int f = this.f3098a.mo50228f();
            AppMethodBeat.m2505o(101434);
            return f;
        }
        AppMethodBeat.m2505o(101434);
        return 0;
    }

    public void setZIndex(float f) {
        AppMethodBeat.m2504i(101435);
        if (this.f3098a != null) {
            this.f3098a.mo50221b((int) f);
        }
        AppMethodBeat.m2505o(101435);
    }

    public void setLevel(int i) {
        AppMethodBeat.m2504i(101436);
        if (this.f3098a != null) {
            this.f3098a.mo50224c(i);
        }
        AppMethodBeat.m2505o(101436);
    }

    public float getZIndex() {
        AppMethodBeat.m2504i(101437);
        if (this.f3098a != null) {
            float g = (float) this.f3098a.mo50229g();
            AppMethodBeat.m2505o(101437);
            return g;
        }
        AppMethodBeat.m2505o(101437);
        return 0.0f;
    }

    public int getLevel() {
        AppMethodBeat.m2504i(101438);
        if (this.f3098a != null) {
            int k = this.f3098a.mo50234k();
            AppMethodBeat.m2505o(101438);
            return k;
        }
        AppMethodBeat.m2505o(101438);
        return 0;
    }

    public void setVisible(boolean z) {
        AppMethodBeat.m2504i(101439);
        if (this.f3098a != null) {
            this.f3098a.mo50219a(z);
        }
        AppMethodBeat.m2505o(101439);
    }

    public boolean isVisible() {
        AppMethodBeat.m2504i(101440);
        if (this.f3098a != null) {
            boolean h = this.f3098a.mo50230h();
            AppMethodBeat.m2505o(101440);
            return h;
        }
        AppMethodBeat.m2505o(101440);
        return false;
    }

    public void setGeodesic(boolean z) {
    }

    public boolean isGeodesic() {
        return false;
    }

    public void setDottedLine(boolean z) {
    }

    public boolean isDottedLine() {
        AppMethodBeat.m2504i(101441);
        if (this.f3098a == null || this.f3098a.mo50232i() == null) {
            AppMethodBeat.m2505o(101441);
            return false;
        }
        AppMethodBeat.m2505o(101441);
        return true;
    }

    public void setColorTexture(BitmapDescriptor bitmapDescriptor) {
        AppMethodBeat.m2504i(101442);
        if (this.f3098a == null) {
            AppMethodBeat.m2505o(101442);
            return;
        }
        this.f3098a.mo50217a(C5839cn.m8915a(bitmapDescriptor.getBitmap()));
        AppMethodBeat.m2505o(101442);
    }

    public void eraseTo(int i, LatLng latLng) {
        AppMethodBeat.m2504i(101443);
        if (this.f3098a == null) {
            AppMethodBeat.m2505o(101443);
            return;
        }
        this.f3098a.mo50216a(i, C41025ej.m71291a(latLng));
        AppMethodBeat.m2505o(101443);
    }

    public void setEraseable(boolean z) {
        AppMethodBeat.m2504i(101444);
        if (this.f3098a == null) {
            AppMethodBeat.m2505o(101444);
            return;
        }
        this.f3098a.mo50222b(z);
        AppMethodBeat.m2505o(101444);
    }
}
