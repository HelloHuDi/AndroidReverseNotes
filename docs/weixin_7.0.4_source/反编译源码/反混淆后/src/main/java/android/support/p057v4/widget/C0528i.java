package android.support.p057v4.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Build.VERSION;
import android.widget.EdgeEffect;

/* renamed from: android.support.v4.widget.i */
public final class C0528i {
    /* renamed from: QN */
    private static final C0527b f703QN;
    /* renamed from: QM */
    public EdgeEffect f704QM;

    /* renamed from: android.support.v4.widget.i$b */
    static class C0527b {
        C0527b() {
        }

        /* renamed from: a */
        public void mo1288a(EdgeEffect edgeEffect, float f, float f2) {
            edgeEffect.onPull(f);
        }
    }

    /* renamed from: android.support.v4.widget.i$a */
    static class C0529a extends C0527b {
        C0529a() {
        }

        /* renamed from: a */
        public final void mo1288a(EdgeEffect edgeEffect, float f, float f2) {
            edgeEffect.onPull(f, f2);
        }
    }

    static {
        if (VERSION.SDK_INT >= 21) {
            f703QN = new C0529a();
        } else {
            f703QN = new C0527b();
        }
    }

    @Deprecated
    public C0528i(Context context) {
        this.f704QM = new EdgeEffect(context);
    }

    @Deprecated
    public final void setSize(int i, int i2) {
        this.f704QM.setSize(i, i2);
    }

    @Deprecated
    /* renamed from: F */
    public final boolean mo1289F(float f) {
        this.f704QM.onPull(f);
        return true;
    }

    /* renamed from: a */
    public static void m1133a(EdgeEffect edgeEffect, float f, float f2) {
        f703QN.mo1288a(edgeEffect, f, f2);
    }

    @Deprecated
    /* renamed from: eL */
    public final boolean mo1292eL() {
        this.f704QM.onRelease();
        return this.f704QM.isFinished();
    }

    @Deprecated
    /* renamed from: aT */
    public final boolean mo1290aT(int i) {
        this.f704QM.onAbsorb(i);
        return true;
    }

    @Deprecated
    public final boolean draw(Canvas canvas) {
        return this.f704QM.draw(canvas);
    }
}
