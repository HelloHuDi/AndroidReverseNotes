package com.tencent.tencentmap.mapsdk.a;

import android.view.View;
import android.view.animation.Animation;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.mapsdk.raster.model.BitmapDescriptor;
import com.tencent.mapsdk.raster.model.LatLng;
import com.tencent.mapsdk.raster.model.Marker;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class ed implements Marker {
    private de a;
    private eh b;

    public ed(eh ehVar, de deVar) {
        AppMethodBeat.i(101378);
        this.b = ehVar;
        this.a = deVar;
        if (this.b == null || this.b.a() == null) {
            AppMethodBeat.o(101378);
            return;
        }
        synchronized (ed.class) {
            try {
                this.b.a().add(this.a);
            } finally {
                while (true) {
                }
                AppMethodBeat.o(101378);
            }
        }
    }

    public float getAlpha() {
        AppMethodBeat.i(101379);
        if (this.a != null) {
            float h = this.a.h();
            AppMethodBeat.o(101379);
            return h;
        }
        AppMethodBeat.o(101379);
        return 0.0f;
    }

    public String getId() {
        AppMethodBeat.i(101380);
        String c;
        if (this.a != null) {
            c = this.a.c();
            AppMethodBeat.o(101380);
            return c;
        }
        c = "";
        AppMethodBeat.o(101380);
        return c;
    }

    public LatLng getPosition() {
        AppMethodBeat.i(101381);
        if (this.a != null) {
            LatLng a = ej.a(this.a.e());
            AppMethodBeat.o(101381);
            return a;
        }
        AppMethodBeat.o(101381);
        return null;
    }

    public float getRotation() {
        AppMethodBeat.i(101382);
        if (this.a != null) {
            float m = this.a.m();
            AppMethodBeat.o(101382);
            return m;
        }
        AppMethodBeat.o(101382);
        return 0.0f;
    }

    public String getSnippet() {
        AppMethodBeat.i(101383);
        if (this.a != null) {
            String g = this.a.g();
            AppMethodBeat.o(101383);
            return g;
        }
        AppMethodBeat.o(101383);
        return null;
    }

    public String getTitle() {
        AppMethodBeat.i(101384);
        if (this.a != null) {
            String f = this.a.f();
            AppMethodBeat.o(101384);
            return f;
        }
        AppMethodBeat.o(101384);
        return null;
    }

    public void hideInfoWindow() {
        AppMethodBeat.i(101385);
        if (this.a != null) {
            this.a.k();
        }
        AppMethodBeat.o(101385);
    }

    public boolean isDraggable() {
        AppMethodBeat.i(101386);
        if (this.a != null) {
            boolean i = this.a.i();
            AppMethodBeat.o(101386);
            return i;
        }
        AppMethodBeat.o(101386);
        return false;
    }

    public boolean isInfoWindowShown() {
        AppMethodBeat.i(101387);
        if (this.a != null) {
            boolean l = this.a.l();
            AppMethodBeat.o(101387);
            return l;
        }
        AppMethodBeat.o(101387);
        return false;
    }

    public boolean isVisible() {
        AppMethodBeat.i(101388);
        if (this.a != null) {
            boolean n = this.a.n();
            AppMethodBeat.o(101388);
            return n;
        }
        AppMethodBeat.o(101388);
        return false;
    }

    public void remove() {
        AppMethodBeat.i(101389);
        if (this.a != null) {
            synchronized (ed.class) {
                try {
                    if (!(this.b == null || this.b.a() == null)) {
                        this.b.a().remove(this.a);
                    }
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.o(101389);
                    }
                }
            }
            this.a.b();
        }
        AppMethodBeat.o(101389);
    }

    public void setAlpha(float f) {
        AppMethodBeat.i(101390);
        if (this.a != null) {
            this.a.b(f);
        }
        AppMethodBeat.o(101390);
    }

    public void setAnchor(float f, float f2) {
        AppMethodBeat.i(101391);
        if (this.a != null) {
            this.a.a(f, f2);
        }
        AppMethodBeat.o(101391);
    }

    public void setDraggable(boolean z) {
        AppMethodBeat.i(101392);
        if (this.a != null) {
            this.a.a(z);
        }
        AppMethodBeat.o(101392);
    }

    public void setIcon(BitmapDescriptor bitmapDescriptor) {
        AppMethodBeat.i(101393);
        if (!(this.a == null || bitmapDescriptor == null)) {
            this.a.a(cn.a(bitmapDescriptor.getBitmap()));
        }
        AppMethodBeat.o(101393);
    }

    public void setPosition(LatLng latLng) {
        AppMethodBeat.i(101394);
        if (this.a != null) {
            this.a.a(ej.a(latLng));
        }
        AppMethodBeat.o(101394);
    }

    public void setRotation(float f) {
        AppMethodBeat.i(101395);
        if (this.a != null) {
            this.a.a(f);
        }
        AppMethodBeat.o(101395);
    }

    public void setSnippet(String str) {
        AppMethodBeat.i(101396);
        if (this.a != null) {
            this.a.b(str);
        }
        AppMethodBeat.o(101396);
    }

    public void setTitle(String str) {
        AppMethodBeat.i(101397);
        if (this.a != null) {
            this.a.a(str);
        }
        AppMethodBeat.o(101397);
    }

    public void setVisible(boolean z) {
        AppMethodBeat.i(101398);
        if (this.a != null) {
            this.a.b(z);
        }
        AppMethodBeat.o(101398);
    }

    public void showInfoWindow() {
        AppMethodBeat.i(101399);
        if (this.a != null) {
            this.a.j();
        }
        AppMethodBeat.o(101399);
    }

    public void set2Top() {
        AppMethodBeat.i(101400);
        if (this.b == null || this.b.a() == null) {
            AppMethodBeat.o(101400);
            return;
        }
        synchronized (ed.class) {
            try {
                int size = this.b.a().size();
                for (de deVar : this.b.a()) {
                    int p;
                    if (deVar.p() > ((float) size)) {
                        p = (int) deVar.p();
                    } else {
                        p = size;
                    }
                    size = p;
                }
                this.a.c(size < BaseClientBuilder.API_PRIORITY_OTHER ? (float) (size + 1) : 2.14748365E9f);
            } finally {
                while (true) {
                }
                AppMethodBeat.o(101400);
            }
        }
    }

    public View getMarkerView() {
        return null;
    }

    public void setMarkerView(View view) {
        AppMethodBeat.i(101401);
        if (this.a != null) {
            this.a.a(cn.a(view));
        }
        AppMethodBeat.o(101401);
    }

    public void setInfoWindowHideAnimation(Animation animation) {
    }

    public void setInfoWindowShowAnimation(Animation animation) {
    }

    public Object getTag() {
        AppMethodBeat.i(101402);
        if (this.a != null) {
            Object t = this.a.t();
            AppMethodBeat.o(101402);
            return t;
        }
        AppMethodBeat.o(101402);
        return null;
    }

    public void setTag(Object obj) {
        AppMethodBeat.i(101403);
        if (this.a != null) {
            this.a.a(obj);
        }
        AppMethodBeat.o(101403);
    }

    public void setZIndex(float f) {
        AppMethodBeat.i(101404);
        if (this.a != null) {
            this.a.c(f);
        }
        AppMethodBeat.o(101404);
    }

    public float getZIndex() {
        AppMethodBeat.i(101405);
        if (this.a != null) {
            float p = this.a.p();
            AppMethodBeat.o(101405);
            return p;
        }
        AppMethodBeat.o(101405);
        return 0.0f;
    }

    public void setLevel(int i) {
        AppMethodBeat.i(101406);
        if (this.a != null) {
            this.a.a(i);
        }
        AppMethodBeat.o(101406);
    }

    public int getLevel() {
        AppMethodBeat.i(101407);
        if (this.a != null) {
            int v = this.a.v();
            AppMethodBeat.o(101407);
            return v;
        }
        AppMethodBeat.o(101407);
        return 0;
    }

    public void setContentDescription(String str) {
        AppMethodBeat.i(101408);
        if (this.a != null) {
            this.a.c(str);
        }
        AppMethodBeat.o(101408);
    }

    public String getContentDescription() {
        AppMethodBeat.i(101409);
        if (this.a != null) {
            String u = this.a.u();
            AppMethodBeat.o(101409);
            return u;
        }
        AppMethodBeat.o(101409);
        return null;
    }
}
