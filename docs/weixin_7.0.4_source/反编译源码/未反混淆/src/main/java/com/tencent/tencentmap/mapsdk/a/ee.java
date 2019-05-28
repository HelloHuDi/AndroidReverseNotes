package com.tencent.tencentmap.mapsdk.a;

import com.tencent.mapsdk.raster.model.BitmapDescriptor;
import com.tencent.mapsdk.raster.model.LatLng;
import com.tencent.mapsdk.raster.model.Polyline;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

public class ee implements Polyline {
    private dl a;

    public ee(dl dlVar) {
        this.a = dlVar;
    }

    public void remove() {
        AppMethodBeat.i(101427);
        if (this.a != null) {
            this.a.b();
        }
        AppMethodBeat.o(101427);
    }

    public String getId() {
        AppMethodBeat.i(101428);
        if (this.a != null) {
            String c = this.a.c();
            AppMethodBeat.o(101428);
            return c;
        }
        AppMethodBeat.o(101428);
        return null;
    }

    public void setPoints(List<LatLng> list) {
        AppMethodBeat.i(101429);
        if (this.a != null) {
            this.a.a(ej.b((List) list));
        }
        AppMethodBeat.o(101429);
    }

    public List<LatLng> getPoints() {
        AppMethodBeat.i(101430);
        if (this.a != null) {
            List a = ej.a(this.a.d());
            AppMethodBeat.o(101430);
            return a;
        }
        AppMethodBeat.o(101430);
        return null;
    }

    public void setWidth(float f) {
        AppMethodBeat.i(101431);
        if (this.a != null) {
            dl dlVar = this.a;
            if (f < 0.0f) {
                f = 0.0f;
            }
            dlVar.a(f);
        }
        AppMethodBeat.o(101431);
    }

    public float getWidth() {
        AppMethodBeat.i(101432);
        if (this.a != null) {
            float e = this.a.e();
            AppMethodBeat.o(101432);
            return e;
        }
        AppMethodBeat.o(101432);
        return 0.0f;
    }

    public void setColor(int i) {
        AppMethodBeat.i(101433);
        if (this.a != null) {
            this.a.a(i);
        }
        AppMethodBeat.o(101433);
    }

    public int getColor() {
        AppMethodBeat.i(101434);
        if (this.a != null) {
            int f = this.a.f();
            AppMethodBeat.o(101434);
            return f;
        }
        AppMethodBeat.o(101434);
        return 0;
    }

    public void setZIndex(float f) {
        AppMethodBeat.i(101435);
        if (this.a != null) {
            this.a.b((int) f);
        }
        AppMethodBeat.o(101435);
    }

    public void setLevel(int i) {
        AppMethodBeat.i(101436);
        if (this.a != null) {
            this.a.c(i);
        }
        AppMethodBeat.o(101436);
    }

    public float getZIndex() {
        AppMethodBeat.i(101437);
        if (this.a != null) {
            float g = (float) this.a.g();
            AppMethodBeat.o(101437);
            return g;
        }
        AppMethodBeat.o(101437);
        return 0.0f;
    }

    public int getLevel() {
        AppMethodBeat.i(101438);
        if (this.a != null) {
            int k = this.a.k();
            AppMethodBeat.o(101438);
            return k;
        }
        AppMethodBeat.o(101438);
        return 0;
    }

    public void setVisible(boolean z) {
        AppMethodBeat.i(101439);
        if (this.a != null) {
            this.a.a(z);
        }
        AppMethodBeat.o(101439);
    }

    public boolean isVisible() {
        AppMethodBeat.i(101440);
        if (this.a != null) {
            boolean h = this.a.h();
            AppMethodBeat.o(101440);
            return h;
        }
        AppMethodBeat.o(101440);
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
        AppMethodBeat.i(101441);
        if (this.a == null || this.a.i() == null) {
            AppMethodBeat.o(101441);
            return false;
        }
        AppMethodBeat.o(101441);
        return true;
    }

    public void setColorTexture(BitmapDescriptor bitmapDescriptor) {
        AppMethodBeat.i(101442);
        if (this.a == null) {
            AppMethodBeat.o(101442);
            return;
        }
        this.a.a(cn.a(bitmapDescriptor.getBitmap()));
        AppMethodBeat.o(101442);
    }

    public void eraseTo(int i, LatLng latLng) {
        AppMethodBeat.i(101443);
        if (this.a == null) {
            AppMethodBeat.o(101443);
            return;
        }
        this.a.a(i, ej.a(latLng));
        AppMethodBeat.o(101443);
    }

    public void setEraseable(boolean z) {
        AppMethodBeat.i(101444);
        if (this.a == null) {
            AppMethodBeat.o(101444);
            return;
        }
        this.a.b(z);
        AppMethodBeat.o(101444);
    }
}
