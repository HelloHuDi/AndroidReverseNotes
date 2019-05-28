package android.support.v7.view;

import android.support.v4.view.w;
import android.support.v4.view.x;
import android.support.v4.view.y;
import android.view.View;
import android.view.animation.Interpolator;
import java.util.ArrayList;
import java.util.Iterator;

public final class h {
    boolean UO;
    x ZG;
    private final y ZH = new y() {
        private boolean ZI = false;
        private int ZJ = 0;

        public final void az(View view) {
            if (!this.ZI) {
                this.ZI = true;
                if (h.this.ZG != null) {
                    h.this.ZG.az(null);
                }
            }
        }

        public final void aA(View view) {
            int i = this.ZJ + 1;
            this.ZJ = i;
            if (i == h.this.uC.size()) {
                if (h.this.ZG != null) {
                    h.this.ZG.aA(null);
                }
                this.ZJ = 0;
                this.ZI = false;
                h.this.UO = false;
            }
        }
    };
    private long mDuration = -1;
    private Interpolator mInterpolator;
    final ArrayList<w> uC = new ArrayList();

    public final h a(w wVar) {
        if (!this.UO) {
            this.uC.add(wVar);
        }
        return this;
    }

    public final h a(w wVar, w wVar2) {
        this.uC.add(wVar);
        wVar2.m(wVar.getDuration());
        this.uC.add(wVar2);
        return this;
    }

    public final void start() {
        if (!this.UO) {
            Iterator it = this.uC.iterator();
            while (it.hasNext()) {
                w wVar = (w) it.next();
                if (this.mDuration >= 0) {
                    wVar.l(this.mDuration);
                }
                if (this.mInterpolator != null) {
                    wVar.c(this.mInterpolator);
                }
                if (this.ZG != null) {
                    wVar.a(this.ZH);
                }
                wVar.start();
            }
            this.UO = true;
        }
    }

    public final void cancel() {
        if (this.UO) {
            Iterator it = this.uC.iterator();
            while (it.hasNext()) {
                ((w) it.next()).cancel();
            }
            this.UO = false;
        }
    }

    public final h gg() {
        if (!this.UO) {
            this.mDuration = 250;
        }
        return this;
    }

    public final h d(Interpolator interpolator) {
        if (!this.UO) {
            this.mInterpolator = interpolator;
        }
        return this;
    }

    public final h b(x xVar) {
        if (!this.UO) {
            this.ZG = xVar;
        }
        return this;
    }
}
