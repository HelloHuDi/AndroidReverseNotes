package com.tencent.mm.plugin.appbrand.widget.desktop.a;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.v;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.widget.desktop.AppBrandDesktopView.c;
import com.tencent.mm.plugin.appbrand.widget.desktop.g;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.Collections;
import java.util.List;

public final class d<T extends v> extends b<T> {
    int coc = 0;
    int endPos = 0;
    View iYn;
    public g iYu = null;
    FrameLayout jbb;
    private List jbc;
    List jbd;
    Object jbe;
    boolean jbf;
    public a jbg;
    a jbh;
    public int paddingLeft = 0;
    public int paddingTop = 0;

    public interface a extends f {
        void aPj();

        void aPk();

        boolean x(Object obj, Object obj2);
    }

    public d(FrameLayout frameLayout, List list, List list2, a aVar) {
        this.jbb = frameLayout;
        this.jbc = list;
        this.jbh = aVar;
        this.jbd = list2;
    }

    public final boolean O(T t) {
        AppMethodBeat.i(134215);
        if (this.jbg != null) {
            boolean O = this.jbg.O(t);
            AppMethodBeat.o(134215);
            return O;
        } else if (t == null) {
            AppMethodBeat.o(134215);
            return false;
        } else {
            AppMethodBeat.o(134215);
            return true;
        }
    }

    public final View d(RecyclerView recyclerView, T t) {
        AppMethodBeat.i(134216);
        this.iYn = f(recyclerView, t);
        if (this.iYn != null) {
            FrameLayout frameLayout = this.jbb;
            View f = f(recyclerView, t);
            this.iYn = f;
            frameLayout.addView(f);
            this.jbf = false;
            if (t.kj() < this.jbc.size()) {
                this.jbe = this.jbh.bz(this.jbc.get(t.kj()));
                this.coc = t.kj();
                View view = this.iYn;
                AppMethodBeat.o(134216);
                return view;
            }
        }
        AppMethodBeat.o(134216);
        return null;
    }

    public final boolean R(T t) {
        AppMethodBeat.i(134217);
        if (this.jbg != null) {
            boolean a = this.jbg.a(t, this.jbe);
            AppMethodBeat.o(134217);
            return a;
        }
        AppMethodBeat.o(134217);
        return true;
    }

    public final boolean a(final RecyclerView recyclerView, T t, T t2, final int i, final int i2) {
        AppMethodBeat.i(134218);
        ab.i("ItemInsertHelper", "alvinluo ItemInsertHelper onMoved isHasInserted: " + this.jbf + ", from: " + i + ", to: " + i2);
        int i3;
        if (!this.jbf) {
            this.jbd.add(i2, this.jbe);
            recyclerView.post(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(134210);
                    recyclerView.getAdapter().ch(i2);
                    AppMethodBeat.o(134210);
                }
            });
            this.jbf = true;
            if (this.jbh != null) {
                this.jbh.aPj();
            }
        } else if (i < i2) {
            for (i3 = i; i3 < i2; i3++) {
                Collections.swap(this.jbd, i3, i3 + 1);
            }
            if (recyclerView != null) {
                recyclerView.post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(134211);
                        recyclerView.getAdapter().as(i, i2);
                        AppMethodBeat.o(134211);
                    }
                });
            }
        } else if (i > i2) {
            for (i3 = i; i3 > i2; i3--) {
                Collections.swap(this.jbd, i3, i3 - 1);
            }
            if (recyclerView != null) {
                recyclerView.post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(134212);
                        recyclerView.getAdapter().as(i, i2);
                        AppMethodBeat.o(134212);
                    }
                });
            }
        }
        this.endPos = i2;
        if (this.jbh != null) {
            this.jbh.f(this.jbe, i2);
        }
        AppMethodBeat.o(134218);
        return true;
    }

    public final void a(final RecyclerView recyclerView, v vVar, int i, Runnable runnable) {
        AppMethodBeat.i(134219);
        if (this.jbg != null) {
            this.jbg.cu(this.iYn);
        }
        final int i2 = i;
        final Runnable runnable2 = runnable;
        final AnonymousClass4 anonymousClass4 = new Runnable() {
            public final void run() {
                AppMethodBeat.i(134213);
                if (d.this.jbf) {
                    d dVar = d.this;
                    RecyclerView recyclerView = recyclerView;
                    Object obj = d.this.jbe;
                    ab.i("ItemInsertHelper", "alvinluo checkDuplicate position: %d", Integer.valueOf(i2));
                    if (obj != null) {
                        int i;
                        if (dVar.jbh != null) {
                            int i2 = 0;
                            i = -1;
                            while (i2 < dVar.jbd.size()) {
                                if (dVar.jbh.x(obj, dVar.jbd.get(i2)) && i2 != r7) {
                                    i = i2;
                                }
                                i2++;
                            }
                        } else {
                            i = -1;
                        }
                        if (i != -1 && i < dVar.jbd.size()) {
                            ab.i("ItemInsertHelper", "alvinluo checkDuplicate targetPosition: %d", Integer.valueOf(i));
                            dVar.jbd.remove(i);
                            recyclerView.getAdapter().ci(i);
                        }
                    }
                }
                if (d.this.jbg != null) {
                    d.this.jbg.a(d.this.coc, d.this.endPos, d.this.jbe, d.this.jbf);
                }
                runnable2.run();
                AppMethodBeat.o(134213);
            }
        };
        if (vVar == null || this.iYn == null) {
            ab.e("ItemInsertHelper", "alvinluo finishMove viewHolder is null");
            AppMethodBeat.o(134219);
            return;
        }
        float Q;
        ab.i("ItemInsertHelper", "[finishMove] position:" + vVar.kj() + " dragViewPosition:" + i);
        final v cf = recyclerView.cf(i);
        float translationX = this.iYn.getTranslationX();
        float translationY = this.iYn.getTranslationY();
        if (!this.jbf) {
            translationY = this.jbh.aNa() + b.c(recyclerView, vVar);
            Q = b.Q(vVar) + this.jbh.aNb();
            translationX = translationY;
        } else if (cf != null && i == cf.kj()) {
            if (this.jbf) {
                translationX = b.c(recyclerView, cf) + this.jbh.aNa();
                translationY = this.jbh.aNb() + b.Q(cf);
                if (this.iYu == null) {
                    Q = 0.0f;
                } else {
                    int computeVerticalScrollOffset = this.iYu.computeVerticalScrollOffset();
                    int computeVerticalScrollExtent = recyclerView.computeVerticalScrollExtent();
                    int computeVerticalScrollRange = (this.iYu.computeVerticalScrollRange() - recyclerView.getMeasuredHeight()) - computeVerticalScrollOffset;
                    ab.i("ItemInsertHelper", "alvinluo computeMoveExtraY scrollOffset: %d, scrollExtent: %d, scrollRange: %d, height: %d, extra: %d, diff: %d", Integer.valueOf(computeVerticalScrollOffset), Integer.valueOf(computeVerticalScrollExtent), Integer.valueOf(this.iYu.computeVerticalScrollRange()), Integer.valueOf(recyclerView.getMeasuredHeight()), Integer.valueOf((int) (recyclerView.getResources().getDimension(R.dimen.a7o) * 0.75f)), Integer.valueOf(computeVerticalScrollRange));
                    if (((float) computeVerticalScrollRange) > recyclerView.getResources().getDimension(R.dimen.a7o) * 0.75f) {
                        Q = 0.0f;
                    } else {
                        Q = (recyclerView.getResources().getDimension(R.dimen.a7o) * 0.75f) - ((float) computeVerticalScrollRange);
                    }
                }
                translationY += Q;
                ab.i("ItemInsertHelper", "alvinluo finishMove computeMoveExtraY %f", Float.valueOf(Q));
            }
            Q = translationY;
        } else if (((LinearLayoutManager) recyclerView.getLayoutManager()).iQ() > i) {
            Q = translationY - ((float) recyclerView.getHeight());
        } else {
            Q = ((float) recyclerView.getHeight()) + translationY;
        }
        View cv = this.jbh.cv(this.iYn);
        if (cv == null) {
            cv = this.iYn;
        }
        ab.i("ItemInsertHelper", "alvinluo finishMove transX: %f, transY: %f", Float.valueOf(translationX), Float.valueOf(Q));
        this.iYn.findViewById(R.id.b9u).setVisibility(4);
        cv.animate().scaleX(1.0f).scaleY(1.0f).setDuration(300).setListener(null).start();
        final v vVar2 = vVar;
        this.iYn.animate().translationX(translationX).translationY(Q).setDuration(300).setListener(new AnimatorListener() {
            public final void onAnimationStart(Animator animator) {
            }

            public final void onAnimationEnd(Animator animator) {
                AppMethodBeat.i(134214);
                d.this.jbb.removeView(d.this.iYn);
                if (d.this.jbf) {
                    if (!(cf == null || cf.apJ == null)) {
                        cf.apJ.setVisibility(0);
                    }
                    if (vVar2 != null) {
                        vVar2.apJ.setVisibility(0);
                        vVar2.apJ.setScaleX(0.0f);
                        vVar2.apJ.setScaleY(0.0f);
                        vVar2.apJ.animate().scaleX(1.0f).scaleY(1.0f).alpha(1.0f).setDuration(300).setListener(null).start();
                    }
                    anonymousClass4.run();
                    d.this.iYn.setScaleX(1.0f);
                    d.this.iYn.setScaleY(1.0f);
                    AppMethodBeat.o(134214);
                    return;
                }
                vVar2.apJ.setVisibility(0);
                anonymousClass4.run();
                AppMethodBeat.o(134214);
            }

            public final void onAnimationCancel(Animator animator) {
            }

            public final void onAnimationRepeat(Animator animator) {
            }
        }).start();
        AppMethodBeat.o(134219);
    }

    public final void a(View view, float f, float f2, v vVar, int i) {
        AppMethodBeat.i(134220);
        if (view == null) {
            AppMethodBeat.o(134220);
            return;
        }
        view.setTranslationX(view.getTranslationX() - f);
        view.setTranslationY(view.getTranslationY() - f2);
        if (this.jbg != null) {
            this.jbg.a(vVar, view, this.jbe, i);
        }
        AppMethodBeat.o(134220);
    }

    public final boolean P(T t) {
        AppMethodBeat.i(134221);
        if (this.jbg != null) {
            boolean P = this.jbg.P(t);
            AppMethodBeat.o(134221);
            return P;
        }
        AppMethodBeat.o(134221);
        return false;
    }

    public final void e(RecyclerView recyclerView, T t) {
        AppMethodBeat.i(134222);
        int kj = t.kj();
        ab.i("ItemInsertHelper", "[onDelete] position:".concat(String.valueOf(kj)));
        if (kj >= 0 && kj < this.jbc.size()) {
            this.jbc.remove(kj);
        }
        n(recyclerView);
        if (this.jbg != null) {
            if (this.jbe instanceof c) {
                ((c) this.jbe).position = t.kj();
            }
            this.jbg.by(this.jbe);
        }
        AppMethodBeat.o(134222);
    }

    public final void m(RecyclerView recyclerView) {
        AppMethodBeat.i(134223);
        ab.i("ItemInsertHelper", "alvinluo onCancel");
        n(recyclerView);
        AppMethodBeat.o(134223);
    }

    private void n(RecyclerView recyclerView) {
        AppMethodBeat.i(134224);
        if (this.jbf) {
            int indexOf = this.jbd.indexOf(this.jbe);
            if (indexOf >= 0) {
                this.jbd.remove(indexOf);
                recyclerView.getAdapter().ci(indexOf);
            }
            this.jbf = false;
            if (this.jbh != null) {
                this.jbh.aPk();
            }
        }
        AppMethodBeat.o(134224);
    }

    private View f(RecyclerView recyclerView, T t) {
        AppMethodBeat.i(134225);
        t.apJ.setVisibility(4);
        View b = this.jbg.b(recyclerView, t);
        b.setVisibility(0);
        AppMethodBeat.o(134225);
        return b;
    }
}
