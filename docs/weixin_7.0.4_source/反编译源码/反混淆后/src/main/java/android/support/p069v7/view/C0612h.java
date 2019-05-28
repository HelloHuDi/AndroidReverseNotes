package android.support.p069v7.view;

import android.support.p057v4.view.C0497w;
import android.support.p057v4.view.C0499x;
import android.support.p057v4.view.C6203y;
import android.view.View;
import android.view.animation.Interpolator;
import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: android.support.v7.view.h */
public final class C0612h {
    /* renamed from: UO */
    boolean f987UO;
    /* renamed from: ZG */
    C0499x f988ZG;
    /* renamed from: ZH */
    private final C6203y f989ZH = new C06131();
    private long mDuration = -1;
    private Interpolator mInterpolator;
    /* renamed from: uC */
    final ArrayList<C0497w> f990uC = new ArrayList();

    /* renamed from: android.support.v7.view.h$1 */
    class C06131 extends C6203y {
        /* renamed from: ZI */
        private boolean f991ZI = false;
        /* renamed from: ZJ */
        private int f992ZJ = 0;

        C06131() {
        }

        /* renamed from: az */
        public final void mo1166az(View view) {
            if (!this.f991ZI) {
                this.f991ZI = true;
                if (C0612h.this.f988ZG != null) {
                    C0612h.this.f988ZG.mo1166az(null);
                }
            }
        }

        /* renamed from: aA */
        public final void mo1164aA(View view) {
            int i = this.f992ZJ + 1;
            this.f992ZJ = i;
            if (i == C0612h.this.f990uC.size()) {
                if (C0612h.this.f988ZG != null) {
                    C0612h.this.f988ZG.mo1164aA(null);
                }
                this.f992ZJ = 0;
                this.f991ZI = false;
                C0612h.this.f987UO = false;
            }
        }
    }

    /* renamed from: a */
    public final C0612h mo1535a(C0497w c0497w) {
        if (!this.f987UO) {
            this.f990uC.add(c0497w);
        }
        return this;
    }

    /* renamed from: a */
    public final C0612h mo1536a(C0497w c0497w, C0497w c0497w2) {
        this.f990uC.add(c0497w);
        c0497w2.mo1159m(c0497w.getDuration());
        this.f990uC.add(c0497w2);
        return this;
    }

    public final void start() {
        if (!this.f987UO) {
            Iterator it = this.f990uC.iterator();
            while (it.hasNext()) {
                C0497w c0497w = (C0497w) it.next();
                if (this.mDuration >= 0) {
                    c0497w.mo1158l(this.mDuration);
                }
                if (this.mInterpolator != null) {
                    c0497w.mo1155c(this.mInterpolator);
                }
                if (this.f988ZG != null) {
                    c0497w.mo1153a(this.f989ZH);
                }
                c0497w.start();
            }
            this.f987UO = true;
        }
    }

    public final void cancel() {
        if (this.f987UO) {
            Iterator it = this.f990uC.iterator();
            while (it.hasNext()) {
                ((C0497w) it.next()).cancel();
            }
            this.f987UO = false;
        }
    }

    /* renamed from: gg */
    public final C0612h mo1540gg() {
        if (!this.f987UO) {
            this.mDuration = 250;
        }
        return this;
    }

    /* renamed from: d */
    public final C0612h mo1539d(Interpolator interpolator) {
        if (!this.f987UO) {
            this.mInterpolator = interpolator;
        }
        return this;
    }

    /* renamed from: b */
    public final C0612h mo1537b(C0499x c0499x) {
        if (!this.f987UO) {
            this.f988ZG = c0499x;
        }
        return this;
    }
}
