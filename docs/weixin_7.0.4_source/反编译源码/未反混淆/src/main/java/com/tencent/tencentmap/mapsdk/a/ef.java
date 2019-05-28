package com.tencent.tencentmap.mapsdk.a;

import com.tencent.mapsdk.raster.model.LatLng;
import com.tencent.mapsdk.raster.model.Polygon;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

public class ef implements Polygon {
    private dj a;

    public ef(dj djVar) {
        this.a = djVar;
    }

    public void remove() {
        AppMethodBeat.i(101410);
        if (this.a != null) {
            this.a.b();
        }
        AppMethodBeat.o(101410);
    }

    public String getId() {
        AppMethodBeat.i(101411);
        if (this.a != null) {
            String c = this.a.c();
            AppMethodBeat.o(101411);
            return c;
        }
        AppMethodBeat.o(101411);
        return null;
    }

    public void setPoints(List<LatLng> list) {
        AppMethodBeat.i(101412);
        if (this.a != null) {
            this.a.a(ej.b((List) list));
        }
        AppMethodBeat.o(101412);
    }

    public List<LatLng> getPoints() {
        AppMethodBeat.i(101413);
        if (this.a != null) {
            List a = ej.a(this.a.d());
            AppMethodBeat.o(101413);
            return a;
        }
        AppMethodBeat.o(101413);
        return null;
    }

    public void setStrokeWidth(float f) {
        AppMethodBeat.i(101414);
        if (this.a != null) {
            dj djVar = this.a;
            if (f < 0.0f) {
                f = 0.0f;
            }
            djVar.a(f / y.g());
        }
        AppMethodBeat.o(101414);
    }

    public float getStrokeWidth() {
        AppMethodBeat.i(101415);
        if (this.a != null) {
            float e = this.a.e() * y.g();
            AppMethodBeat.o(101415);
            return e;
        }
        AppMethodBeat.o(101415);
        return 0.0f;
    }

    public void setStrokeColor(int i) {
        AppMethodBeat.i(101416);
        if (this.a != null) {
            this.a.a(i);
        }
        AppMethodBeat.o(101416);
    }

    public int getStrokeColor() {
        AppMethodBeat.i(101417);
        if (this.a != null) {
            int f = this.a.f();
            AppMethodBeat.o(101417);
            return f;
        }
        AppMethodBeat.o(101417);
        return 0;
    }

    public void setFillColor(int i) {
        AppMethodBeat.i(101418);
        if (this.a != null) {
            this.a.b(i);
        }
        AppMethodBeat.o(101418);
    }

    public int getFillColor() {
        AppMethodBeat.i(101419);
        if (this.a != null) {
            int g = this.a.g();
            AppMethodBeat.o(101419);
            return g;
        }
        AppMethodBeat.o(101419);
        return 0;
    }

    public void setZIndex(float f) {
        AppMethodBeat.i(101420);
        if (this.a != null) {
            this.a.c((int) f);
        }
        AppMethodBeat.o(101420);
    }

    public float getZIndex() {
        AppMethodBeat.i(101421);
        if (this.a != null) {
            float h = (float) ((int) this.a.h());
            AppMethodBeat.o(101421);
            return h;
        }
        AppMethodBeat.o(101421);
        return 0.0f;
    }

    public void setLevel(int i) {
        AppMethodBeat.i(101422);
        if (this.a != null) {
            this.a.d(i);
        }
        AppMethodBeat.o(101422);
    }

    public int getLevel() {
        AppMethodBeat.i(101423);
        if (this.a != null) {
            int j = this.a.j();
            AppMethodBeat.o(101423);
            return j;
        }
        AppMethodBeat.o(101423);
        return 0;
    }

    public void setVisible(boolean z) {
        AppMethodBeat.i(101424);
        if (this.a != null) {
            this.a.a(z);
        }
        AppMethodBeat.o(101424);
    }

    public boolean isVisible() {
        AppMethodBeat.i(101425);
        if (this.a != null) {
            boolean i = this.a.i();
            AppMethodBeat.o(101425);
            return i;
        }
        AppMethodBeat.o(101425);
        return false;
    }

    public boolean contains(LatLng latLng) {
        AppMethodBeat.i(101426);
        if (this.a != null) {
            boolean a = this.a.a(ej.a(latLng));
            AppMethodBeat.o(101426);
            return a;
        }
        AppMethodBeat.o(101426);
        return false;
    }
}
