package android.support.p069v7.widget;

import android.support.p057v4.widget.C8415j;
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
import com.google.android.gms.common.api.Api.BaseClientBuilder;

/* renamed from: android.support.v7.widget.aw */
public abstract class C25379aw extends C41529k {
    RecyclerView aiB;
    private final C41530m anZ = new C253801();
    private Scroller arO;

    /* renamed from: android.support.v7.widget.aw$1 */
    class C253801 extends C41530m {
        boolean arP = false;

        C253801() {
        }

        /* renamed from: c */
        public final void mo6643c(RecyclerView recyclerView, int i) {
            super.mo6643c(recyclerView, i);
            if (i == 0 && this.arP) {
                this.arP = false;
                C25379aw.this.mo42394kR();
            }
        }

        /* renamed from: a */
        public final void mo6642a(RecyclerView recyclerView, int i, int i2) {
            if (i != 0 || i2 != 0) {
                this.arP = true;
            }
        }
    }

    /* renamed from: a */
    public abstract int mo31909a(C17480i c17480i, int i, int i2);

    /* renamed from: a */
    public abstract View mo31910a(C17480i c17480i);

    /* renamed from: a */
    public abstract int[] mo9101a(C17480i c17480i, View view);

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
            C37139r g = mo42392g(layoutManager);
            if (g == null) {
                z = false;
            } else {
                int a = mo31909a(layoutManager, i, i2);
                if (a == -1) {
                    z = false;
                } else {
                    g.ape = a;
                    layoutManager.mo31829a(g);
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
    public final void mo42393i(RecyclerView recyclerView) {
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
            mo42394kR();
        }
    }

    /* renamed from: aJ */
    public final int[] mo42391aJ(int i, int i2) {
        r9 = new int[2];
        this.arO.fling(0, 0, i, i2, C8415j.INVALID_ID, BaseClientBuilder.API_PRIORITY_OTHER, C8415j.INVALID_ID, BaseClientBuilder.API_PRIORITY_OTHER);
        r9[0] = this.arO.getFinalX();
        r9[1] = this.arO.getFinalY();
        return r9;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: kR */
    public final void mo42394kR() {
        if (this.aiB != null) {
            C17480i layoutManager = this.aiB.getLayoutManager();
            if (layoutManager != null) {
                View a = mo31910a(layoutManager);
                if (a != null) {
                    int[] a2 = mo9101a(layoutManager, a);
                    if (a2[0] != 0 || a2[1] != 0) {
                        this.aiB.mo66329a(a2[0], a2[1], null);
                    }
                }
            }
        }
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: g */
    public C37139r mo42392g(C17480i c17480i) {
        return mo31911f(c17480i);
    }

    /* Access modifiers changed, original: protected */
    @Deprecated
    /* renamed from: f */
    public C41189ah mo31911f(C17480i c17480i) {
        if (c17480i instanceof C37140b) {
            return new C41189ah(this.aiB.getContext()) {
                /* Access modifiers changed, original: protected|final */
                /* renamed from: a */
                public final void mo9234a(View view, C37138a c37138a) {
                    if (C25379aw.this.aiB != null) {
                        int[] a = C25379aw.this.mo9101a(C25379aw.this.aiB.getLayoutManager(), view);
                        int i = a[0];
                        int i2 = a[1];
                        int ca = mo65816ca(Math.max(Math.abs(i), Math.abs(i2)));
                        if (ca > 0) {
                            c37138a.mo59203a(i, i2, ca, this.f16584Sf);
                        }
                    }
                }

                /* Access modifiers changed, original: protected|final */
                /* renamed from: c */
                public final float mo9235c(DisplayMetrics displayMetrics) {
                    return 100.0f / ((float) displayMetrics.densityDpi);
                }
            };
        }
        return null;
    }
}
