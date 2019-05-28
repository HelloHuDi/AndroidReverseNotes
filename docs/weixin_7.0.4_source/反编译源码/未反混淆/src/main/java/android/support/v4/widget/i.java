package android.support.v4.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Build.VERSION;
import android.widget.EdgeEffect;

public final class i {
    private static final b QN;
    public EdgeEffect QM;

    static class b {
        b() {
        }

        public void a(EdgeEffect edgeEffect, float f, float f2) {
            edgeEffect.onPull(f);
        }
    }

    static class a extends b {
        a() {
        }

        public final void a(EdgeEffect edgeEffect, float f, float f2) {
            edgeEffect.onPull(f, f2);
        }
    }

    static {
        if (VERSION.SDK_INT >= 21) {
            QN = new a();
        } else {
            QN = new b();
        }
    }

    @Deprecated
    public i(Context context) {
        this.QM = new EdgeEffect(context);
    }

    @Deprecated
    public final void setSize(int i, int i2) {
        this.QM.setSize(i, i2);
    }

    @Deprecated
    public final boolean F(float f) {
        this.QM.onPull(f);
        return true;
    }

    public static void a(EdgeEffect edgeEffect, float f, float f2) {
        QN.a(edgeEffect, f, f2);
    }

    @Deprecated
    public final boolean eL() {
        this.QM.onRelease();
        return this.QM.isFinished();
    }

    @Deprecated
    public final boolean aT(int i) {
        this.QM.onAbsorb(i);
        return true;
    }

    @Deprecated
    public final boolean draw(Canvas canvas) {
        return this.QM.draw(canvas);
    }
}
