package android.support.v7.widget;

import android.support.v4.widget.j;
import android.support.v7.widget.RecyclerView.i;
import android.support.v7.widget.RecyclerView.k;
import android.support.v7.widget.RecyclerView.m;
import android.support.v7.widget.RecyclerView.r;
import android.support.v7.widget.RecyclerView.r.a;
import android.support.v7.widget.RecyclerView.r.b;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.Scroller;
import com.google.android.gms.common.api.Api.BaseClientBuilder;

public abstract class aw extends k {
    RecyclerView aiB;
    private final m anZ = new m() {
        boolean arP = false;

        public final void c(RecyclerView recyclerView, int i) {
            super.c(recyclerView, i);
            if (i == 0 && this.arP) {
                this.arP = false;
                aw.this.kR();
            }
        }

        public final void a(RecyclerView recyclerView, int i, int i2) {
            if (i != 0 || i2 != 0) {
                this.arP = true;
            }
        }
    };
    private Scroller arO;

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
            r g = g(layoutManager);
            if (g == null) {
                z = false;
            } else {
                int a = a(layoutManager, i, i2);
                if (a == -1) {
                    z = false;
                } else {
                    g.ape = a;
                    layoutManager.a(g);
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

    public final int[] aJ(int i, int i2) {
        r9 = new int[2];
        this.arO.fling(0, 0, i, i2, j.INVALID_ID, BaseClientBuilder.API_PRIORITY_OTHER, j.INVALID_ID, BaseClientBuilder.API_PRIORITY_OTHER);
        r9[0] = this.arO.getFinalX();
        r9[1] = this.arO.getFinalY();
        return r9;
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
    public r g(i iVar) {
        return f(iVar);
    }

    /* Access modifiers changed, original: protected */
    @Deprecated
    public ah f(i iVar) {
        if (iVar instanceof b) {
            return new ah(this.aiB.getContext()) {
                /* Access modifiers changed, original: protected|final */
                public final void a(View view, a aVar) {
                    if (aw.this.aiB != null) {
                        int[] a = aw.this.a(aw.this.aiB.getLayoutManager(), view);
                        int i = a[0];
                        int i2 = a[1];
                        int ca = ca(Math.max(Math.abs(i), Math.abs(i2)));
                        if (ca > 0) {
                            aVar.a(i, i2, ca, this.Sf);
                        }
                    }
                }

                /* Access modifiers changed, original: protected|final */
                public final float c(DisplayMetrics displayMetrics) {
                    return 100.0f / ((float) displayMetrics.densityDpi);
                }
            };
        }
        return null;
    }
}
