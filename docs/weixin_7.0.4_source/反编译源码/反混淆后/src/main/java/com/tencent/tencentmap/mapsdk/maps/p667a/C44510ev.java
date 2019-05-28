package com.tencent.tencentmap.mapsdk.maps.p667a;

import android.os.SystemClock;
import android.view.animation.Interpolator;

/* renamed from: com.tencent.tencentmap.mapsdk.maps.a.ev */
public abstract class C44510ev {
    /* renamed from: a */
    protected long f17414a;
    /* renamed from: b */
    protected long f17415b;
    /* renamed from: c */
    protected C5870a f17416c;
    /* renamed from: d */
    private boolean f17417d;
    /* renamed from: e */
    private boolean f17418e;
    /* renamed from: f */
    private Interpolator f17419f;

    /* renamed from: com.tencent.tencentmap.mapsdk.maps.a.ev$a */
    public interface C5870a {
        /* renamed from: a */
        void mo12425a();
    }

    /* renamed from: a */
    public abstract void mo70881a(float f, Interpolator interpolator);

    /* renamed from: c */
    private long m80732c() {
        return SystemClock.uptimeMillis();
    }

    /* renamed from: a */
    public void mo70880a() {
        if (this.f17417d) {
            float c = ((float) (m80732c() - this.f17415b)) / ((float) this.f17414a);
            if (c > 1.0f) {
                this.f17417d = false;
                mo70881a(1.0f, this.f17419f);
                if (this.f17416c != null) {
                    this.f17416c.mo12425a();
                }
                this.f17418e = true;
                return;
            }
            mo70881a(c, this.f17419f);
        } else if (!this.f17418e && this.f17416c != null) {
            this.f17416c.mo12425a();
        }
    }

    /* renamed from: b */
    public boolean mo70882b() {
        return this.f17418e;
    }
}
