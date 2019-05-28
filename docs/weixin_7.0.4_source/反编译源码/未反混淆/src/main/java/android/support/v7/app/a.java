package android.support.v7.app;

import android.support.v4.widget.DrawerLayout.c;
import android.support.v7.d.a.b;

public final class a implements c {
    private final a Tb;
    private b Tc;
    private boolean Td;
    boolean Te;
    private final int Tf;
    private final int Tg;

    public interface a {
        void bc(int i);
    }

    public final void E(float f) {
        if (this.Td) {
            setPosition(Math.min(1.0f, Math.max(0.0f, f)));
        } else {
            setPosition(0.0f);
        }
    }

    public final void eH() {
        setPosition(1.0f);
        if (this.Te) {
            bc(this.Tg);
        }
    }

    public final void eI() {
        setPosition(0.0f);
        if (this.Te) {
            bc(this.Tf);
        }
    }

    private void bc(int i) {
        this.Tb.bc(i);
    }

    private void setPosition(float f) {
        if (f == 1.0f) {
            this.Tc.T(true);
        } else if (f == 0.0f) {
            this.Tc.T(false);
        }
        this.Tc.setProgress(f);
    }
}
