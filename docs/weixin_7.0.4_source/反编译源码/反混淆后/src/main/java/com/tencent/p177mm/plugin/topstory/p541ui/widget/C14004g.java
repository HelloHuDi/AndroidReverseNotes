package com.tencent.p177mm.plugin.topstory.p541ui.widget;

import android.support.p069v7.widget.C41189ah;
import android.support.p069v7.widget.RecyclerView;
import android.support.p069v7.widget.RecyclerView.C17480i;
import android.support.p069v7.widget.RecyclerView.C37139r;
import android.support.p069v7.widget.RecyclerView.C37139r.C37138a;
import android.support.p069v7.widget.RecyclerView.C37139r.C37140b;
import android.support.p069v7.widget.RecyclerView.C41529k;
import android.support.p069v7.widget.RecyclerView.C41530m;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.Scroller;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.plugin.topstory.ui.widget.g */
public abstract class C14004g extends C41529k {
    public RecyclerView aiB;
    private final C41530m anZ = new C42521();
    protected Scroller arO;

    /* renamed from: com.tencent.mm.plugin.topstory.ui.widget.g$1 */
    class C42521 extends C41530m {
        boolean arP = false;

        C42521() {
        }

        /* renamed from: c */
        public final void mo6643c(RecyclerView recyclerView, int i) {
            AppMethodBeat.m2504i(2266);
            super.mo6643c(recyclerView, i);
            if (i == 0 && this.arP) {
                this.arP = false;
                C14004g.this.mo26238kR();
            }
            AppMethodBeat.m2505o(2266);
        }

        /* renamed from: a */
        public final void mo6642a(RecyclerView recyclerView, int i, int i2) {
            if (i != 0 || i2 != 0) {
                this.arP = true;
            }
        }
    }

    /* renamed from: a */
    public abstract int mo26232a(C17480i c17480i, int i, int i2);

    /* renamed from: a */
    public abstract View mo26233a(C17480i c17480i);

    /* renamed from: a */
    public abstract int[] mo26234a(C17480i c17480i, View view);

    /* renamed from: aE */
    public final boolean mo26235aE(int i, int i2) {
        C17480i layoutManager = this.aiB.getLayoutManager();
        if (layoutManager == null || this.aiB.getAdapter() == null) {
            return false;
        }
        int minFlingVelocity = this.aiB.getMinFlingVelocity();
        if (Math.abs(i2) <= minFlingVelocity && Math.abs(i) <= minFlingVelocity) {
            return false;
        }
        boolean z;
        if (layoutManager instanceof C37140b) {
            C37139r f = mo26236f(layoutManager);
            if (f == null) {
                z = false;
            } else {
                int a = mo26232a(layoutManager, i, i2);
                if (a == -1) {
                    z = false;
                } else {
                    f.ape = a;
                    layoutManager.mo31829a(f);
                    z = true;
                }
            }
        } else {
            z = false;
        }
        if (z) {
            return true;
        }
        return false;
    }

    /* renamed from: i */
    public final void mo26237i(RecyclerView recyclerView) {
        if (this.aiB != recyclerView) {
            if (this.aiB != null) {
                this.aiB.mo66348b(this.anZ);
                this.aiB.setOnFlingListener(null);
            }
            this.aiB = recyclerView;
            if (this.aiB == null) {
                return;
            }
            if (this.aiB.getOnFlingListener() != null) {
                throw new IllegalStateException("An instance of OnFlingListener already set.");
            }
            this.aiB.mo66332a(this.anZ);
            this.aiB.setOnFlingListener(this);
            this.arO = new Scroller(this.aiB.getContext(), new DecelerateInterpolator());
            mo26238kR();
        }
    }

    /* Access modifiers changed, original: final */
    /* renamed from: kR */
    public final void mo26238kR() {
        if (this.aiB != null) {
            C17480i layoutManager = this.aiB.getLayoutManager();
            if (layoutManager != null) {
                View a = mo26233a(layoutManager);
                if (a != null) {
                    int[] a2 = mo26234a(layoutManager, a);
                    if (a2[0] != 0 || a2[1] != 0) {
                        this.aiB.mo66329a(a2[0], a2[1], null);
                    }
                }
            }
        }
    }

    /* Access modifiers changed, original: protected */
    @Deprecated
    /* renamed from: f */
    public C41189ah mo26236f(C17480i c17480i) {
        if (c17480i instanceof C37140b) {
            return new C41189ah(this.aiB.getContext()) {
                /* renamed from: a */
                public final void mo9234a(View view, C37138a c37138a) {
                    AppMethodBeat.m2504i(2267);
                    if (C14004g.this.aiB == null) {
                        AppMethodBeat.m2505o(2267);
                        return;
                    }
                    int[] a = C14004g.this.mo26234a(C14004g.this.aiB.getLayoutManager(), view);
                    int i = a[0];
                    int i2 = a[1];
                    int ca = mo65816ca(Math.max(Math.abs(i), Math.abs(i2)));
                    if (ca > 0) {
                        c37138a.mo59203a(i, i2, ca, this.f16584Sf);
                    }
                    AppMethodBeat.m2505o(2267);
                }

                /* renamed from: c */
                public final float mo9235c(DisplayMetrics displayMetrics) {
                    return 100.0f / ((float) displayMetrics.densityDpi);
                }
            };
        }
        return null;
    }
}
