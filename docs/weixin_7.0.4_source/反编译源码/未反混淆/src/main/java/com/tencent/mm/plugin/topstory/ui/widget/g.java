package com.tencent.mm.plugin.topstory.ui.widget;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.i;
import android.support.v7.widget.RecyclerView.k;
import android.support.v7.widget.RecyclerView.m;
import android.support.v7.widget.RecyclerView.r;
import android.support.v7.widget.RecyclerView.r.a;
import android.support.v7.widget.RecyclerView.r.b;
import android.support.v7.widget.ah;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.Scroller;
import com.tencent.matrix.trace.core.AppMethodBeat;

public abstract class g extends k {
    public RecyclerView aiB;
    private final m anZ = new m() {
        boolean arP = false;

        public final void c(RecyclerView recyclerView, int i) {
            AppMethodBeat.i(2266);
            super.c(recyclerView, i);
            if (i == 0 && this.arP) {
                this.arP = false;
                g.this.kR();
            }
            AppMethodBeat.o(2266);
        }

        public final void a(RecyclerView recyclerView, int i, int i2) {
            if (i != 0 || i2 != 0) {
                this.arP = true;
            }
        }
    };
    protected Scroller arO;

    public abstract int a(i iVar, int i, int i2);

    public abstract View a(i iVar);

    public abstract int[] a(i iVar, View view);

    public final boolean aE(int i, int i2) {
        i layoutManager = this.aiB.getLayoutManager();
        if (layoutManager == null || this.aiB.getAdapter() == null) {
            return false;
        }
        int minFlingVelocity = this.aiB.getMinFlingVelocity();
        if (Math.abs(i2) <= minFlingVelocity && Math.abs(i) <= minFlingVelocity) {
            return false;
        }
        boolean z;
        if (layoutManager instanceof b) {
            r f = f(layoutManager);
            if (f == null) {
                z = false;
            } else {
                int a = a(layoutManager, i, i2);
                if (a == -1) {
                    z = false;
                } else {
                    f.ape = a;
                    layoutManager.a(f);
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

    public final void i(RecyclerView recyclerView) {
        if (this.aiB != recyclerView) {
            if (this.aiB != null) {
                this.aiB.b(this.anZ);
                this.aiB.setOnFlingListener(null);
            }
            this.aiB = recyclerView;
            if (this.aiB == null) {
                return;
            }
            if (this.aiB.getOnFlingListener() != null) {
                throw new IllegalStateException("An instance of OnFlingListener already set.");
            }
            this.aiB.a(this.anZ);
            this.aiB.setOnFlingListener(this);
            this.arO = new Scroller(this.aiB.getContext(), new DecelerateInterpolator());
            kR();
        }
    }

    /* Access modifiers changed, original: final */
    public final void kR() {
        if (this.aiB != null) {
            i layoutManager = this.aiB.getLayoutManager();
            if (layoutManager != null) {
                View a = a(layoutManager);
                if (a != null) {
                    int[] a2 = a(layoutManager, a);
                    if (a2[0] != 0 || a2[1] != 0) {
                        this.aiB.a(a2[0], a2[1], null);
                    }
                }
            }
        }
    }

    /* Access modifiers changed, original: protected */
    @Deprecated
    public ah f(i iVar) {
        if (iVar instanceof b) {
            return new ah(this.aiB.getContext()) {
                public final void a(View view, a aVar) {
                    AppMethodBeat.i(2267);
                    if (g.this.aiB == null) {
                        AppMethodBeat.o(2267);
                        return;
                    }
                    int[] a = g.this.a(g.this.aiB.getLayoutManager(), view);
                    int i = a[0];
                    int i2 = a[1];
                    int ca = ca(Math.max(Math.abs(i), Math.abs(i2)));
                    if (ca > 0) {
                        aVar.a(i, i2, ca, this.Sf);
                    }
                    AppMethodBeat.o(2267);
                }

                public final float c(DisplayMetrics displayMetrics) {
                    return 100.0f / ((float) displayMetrics.densityDpi);
                }
            };
        }
        return null;
    }
}
