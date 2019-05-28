package com.tencent.tencentmap.mapsdk.p666a;

import android.view.View;
import android.view.animation.Animation;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.mapsdk.raster.model.BitmapDescriptor;
import com.tencent.mapsdk.raster.model.LatLng;
import com.tencent.mapsdk.raster.model.Marker;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.tencentmap.mapsdk.a.ed */
public class C31007ed implements Marker {
    /* renamed from: a */
    private C44490de f14022a;
    /* renamed from: b */
    private C44822eh f14023b;

    public C31007ed(C44822eh c44822eh, C44490de c44490de) {
        AppMethodBeat.m2504i(101378);
        this.f14023b = c44822eh;
        this.f14022a = c44490de;
        if (this.f14023b == null || this.f14023b.mo72027a() == null) {
            AppMethodBeat.m2505o(101378);
            return;
        }
        synchronized (C31007ed.class) {
            try {
                this.f14023b.mo72027a().add(this.f14022a);
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(101378);
            }
        }
    }

    public float getAlpha() {
        AppMethodBeat.m2504i(101379);
        if (this.f14022a != null) {
            float h = this.f14022a.mo70749h();
            AppMethodBeat.m2505o(101379);
            return h;
        }
        AppMethodBeat.m2505o(101379);
        return 0.0f;
    }

    public String getId() {
        AppMethodBeat.m2504i(101380);
        String c;
        if (this.f14022a != null) {
            c = this.f14022a.mo70741c();
            AppMethodBeat.m2505o(101380);
            return c;
        }
        c = "";
        AppMethodBeat.m2505o(101380);
        return c;
    }

    public LatLng getPosition() {
        AppMethodBeat.m2504i(101381);
        if (this.f14022a != null) {
            LatLng a = C41025ej.m71282a(this.f14022a.mo70745e());
            AppMethodBeat.m2505o(101381);
            return a;
        }
        AppMethodBeat.m2505o(101381);
        return null;
    }

    public float getRotation() {
        AppMethodBeat.m2504i(101382);
        if (this.f14022a != null) {
            float m = this.f14022a.mo70755m();
            AppMethodBeat.m2505o(101382);
            return m;
        }
        AppMethodBeat.m2505o(101382);
        return 0.0f;
    }

    public String getSnippet() {
        AppMethodBeat.m2504i(101383);
        if (this.f14022a != null) {
            String g = this.f14022a.mo70748g();
            AppMethodBeat.m2505o(101383);
            return g;
        }
        AppMethodBeat.m2505o(101383);
        return null;
    }

    public String getTitle() {
        AppMethodBeat.m2504i(101384);
        if (this.f14022a != null) {
            String f = this.f14022a.mo70747f();
            AppMethodBeat.m2505o(101384);
            return f;
        }
        AppMethodBeat.m2505o(101384);
        return null;
    }

    public void hideInfoWindow() {
        AppMethodBeat.m2504i(101385);
        if (this.f14022a != null) {
            this.f14022a.mo70753k();
        }
        AppMethodBeat.m2505o(101385);
    }

    public boolean isDraggable() {
        AppMethodBeat.m2504i(101386);
        if (this.f14022a != null) {
            boolean i = this.f14022a.mo70751i();
            AppMethodBeat.m2505o(101386);
            return i;
        }
        AppMethodBeat.m2505o(101386);
        return false;
    }

    public boolean isInfoWindowShown() {
        AppMethodBeat.m2504i(101387);
        if (this.f14022a != null) {
            boolean l = this.f14022a.mo70754l();
            AppMethodBeat.m2505o(101387);
            return l;
        }
        AppMethodBeat.m2505o(101387);
        return false;
    }

    public boolean isVisible() {
        AppMethodBeat.m2504i(101388);
        if (this.f14022a != null) {
            boolean n = this.f14022a.mo70756n();
            AppMethodBeat.m2505o(101388);
            return n;
        }
        AppMethodBeat.m2505o(101388);
        return false;
    }

    public void remove() {
        AppMethodBeat.m2504i(101389);
        if (this.f14022a != null) {
            synchronized (C31007ed.class) {
                try {
                    if (!(this.f14023b == null || this.f14023b.mo72027a() == null)) {
                        this.f14023b.mo72027a().remove(this.f14022a);
                    }
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.m2505o(101389);
                    }
                }
            }
            this.f14022a.mo70737b();
        }
        AppMethodBeat.m2505o(101389);
    }

    public void setAlpha(float f) {
        AppMethodBeat.m2504i(101390);
        if (this.f14022a != null) {
            this.f14022a.mo70738b(f);
        }
        AppMethodBeat.m2505o(101390);
    }

    public void setAnchor(float f, float f2) {
        AppMethodBeat.m2504i(101391);
        if (this.f14022a != null) {
            this.f14022a.mo70728a(f, f2);
        }
        AppMethodBeat.m2505o(101391);
    }

    public void setDraggable(boolean z) {
        AppMethodBeat.m2504i(101392);
        if (this.f14022a != null) {
            this.f14022a.mo70735a(z);
        }
        AppMethodBeat.m2505o(101392);
    }

    public void setIcon(BitmapDescriptor bitmapDescriptor) {
        AppMethodBeat.m2504i(101393);
        if (!(this.f14022a == null || bitmapDescriptor == null)) {
            this.f14022a.mo70731a(C5839cn.m8915a(bitmapDescriptor.getBitmap()));
        }
        AppMethodBeat.m2505o(101393);
    }

    public void setPosition(LatLng latLng) {
        AppMethodBeat.m2504i(101394);
        if (this.f14022a != null) {
            this.f14022a.mo70732a(C41025ej.m71291a(latLng));
        }
        AppMethodBeat.m2505o(101394);
    }

    public void setRotation(float f) {
        AppMethodBeat.m2504i(101395);
        if (this.f14022a != null) {
            this.f14022a.mo70727a(f);
        }
        AppMethodBeat.m2505o(101395);
    }

    public void setSnippet(String str) {
        AppMethodBeat.m2504i(101396);
        if (this.f14022a != null) {
            this.f14022a.mo70739b(str);
        }
        AppMethodBeat.m2505o(101396);
    }

    public void setTitle(String str) {
        AppMethodBeat.m2504i(101397);
        if (this.f14022a != null) {
            this.f14022a.mo70734a(str);
        }
        AppMethodBeat.m2505o(101397);
    }

    public void setVisible(boolean z) {
        AppMethodBeat.m2504i(101398);
        if (this.f14022a != null) {
            this.f14022a.mo70740b(z);
        }
        AppMethodBeat.m2505o(101398);
    }

    public void showInfoWindow() {
        AppMethodBeat.m2504i(101399);
        if (this.f14022a != null) {
            this.f14022a.mo70752j();
        }
        AppMethodBeat.m2505o(101399);
    }

    public void set2Top() {
        AppMethodBeat.m2504i(101400);
        if (this.f14023b == null || this.f14023b.mo72027a() == null) {
            AppMethodBeat.m2505o(101400);
            return;
        }
        synchronized (C31007ed.class) {
            try {
                int size = this.f14023b.mo72027a().size();
                for (C44490de c44490de : this.f14023b.mo72027a()) {
                    int p;
                    if (c44490de.mo70758p() > ((float) size)) {
                        p = (int) c44490de.mo70758p();
                    } else {
                        p = size;
                    }
                    size = p;
                }
                this.f14022a.mo70742c(size < BaseClientBuilder.API_PRIORITY_OTHER ? (float) (size + 1) : 2.14748365E9f);
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(101400);
            }
        }
    }

    public View getMarkerView() {
        return null;
    }

    public void setMarkerView(View view) {
        AppMethodBeat.m2504i(101401);
        if (this.f14022a != null) {
            this.f14022a.mo70731a(C5839cn.m8916a(view));
        }
        AppMethodBeat.m2505o(101401);
    }

    public void setInfoWindowHideAnimation(Animation animation) {
    }

    public void setInfoWindowShowAnimation(Animation animation) {
    }

    public Object getTag() {
        AppMethodBeat.m2504i(101402);
        if (this.f14022a != null) {
            Object t = this.f14022a.mo70762t();
            AppMethodBeat.m2505o(101402);
            return t;
        }
        AppMethodBeat.m2505o(101402);
        return null;
    }

    public void setTag(Object obj) {
        AppMethodBeat.m2504i(101403);
        if (this.f14022a != null) {
            this.f14022a.mo70733a(obj);
        }
        AppMethodBeat.m2505o(101403);
    }

    public void setZIndex(float f) {
        AppMethodBeat.m2504i(101404);
        if (this.f14022a != null) {
            this.f14022a.mo70742c(f);
        }
        AppMethodBeat.m2505o(101404);
    }

    public float getZIndex() {
        AppMethodBeat.m2504i(101405);
        if (this.f14022a != null) {
            float p = this.f14022a.mo70758p();
            AppMethodBeat.m2505o(101405);
            return p;
        }
        AppMethodBeat.m2505o(101405);
        return 0.0f;
    }

    public void setLevel(int i) {
        AppMethodBeat.m2504i(101406);
        if (this.f14022a != null) {
            this.f14022a.mo70729a(i);
        }
        AppMethodBeat.m2505o(101406);
    }

    public int getLevel() {
        AppMethodBeat.m2504i(101407);
        if (this.f14022a != null) {
            int v = this.f14022a.mo70764v();
            AppMethodBeat.m2505o(101407);
            return v;
        }
        AppMethodBeat.m2505o(101407);
        return 0;
    }

    public void setContentDescription(String str) {
        AppMethodBeat.m2504i(101408);
        if (this.f14022a != null) {
            this.f14022a.mo70743c(str);
        }
        AppMethodBeat.m2505o(101408);
    }

    public String getContentDescription() {
        AppMethodBeat.m2504i(101409);
        if (this.f14022a != null) {
            String u = this.f14022a.mo70763u();
            AppMethodBeat.m2505o(101409);
            return u;
        }
        AppMethodBeat.m2505o(101409);
        return null;
    }
}
