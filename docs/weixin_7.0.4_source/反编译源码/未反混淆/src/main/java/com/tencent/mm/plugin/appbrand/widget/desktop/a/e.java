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
import com.tencent.mm.plugin.appbrand.widget.desktop.g;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.Collections;
import java.util.List;

public final class e<T extends v> extends b<T> {
    int coc = 0;
    int endPos = 0;
    private List iKa;
    View iYn;
    public g iYu = null;
    FrameLayout jbb;
    public a jbg;
    Object jbp;
    private f jbq;
    public int paddingLeft = 0;
    public int paddingTop = 0;

    public e(FrameLayout frameLayout, List list, f fVar) {
        this.jbb = frameLayout;
        this.iKa = list;
        this.jbq = fVar;
    }

    public final void a(a aVar) {
        this.jbg = aVar;
    }

    public final boolean O(T t) {
        AppMethodBeat.i(134228);
        if (this.jbg != null) {
            boolean O = this.jbg.O(t);
            AppMethodBeat.o(134228);
            return O;
        } else if (t == null) {
            AppMethodBeat.o(134228);
            return false;
        } else {
            AppMethodBeat.o(134228);
            return true;
        }
    }

    public final boolean R(T t) {
        AppMethodBeat.i(134230);
        if (this.jbg != null) {
            boolean a = this.jbg.a(t, null);
            AppMethodBeat.o(134230);
            return a;
        }
        AppMethodBeat.o(134230);
        return true;
    }

    public final boolean a(RecyclerView recyclerView, T t, T t2, int i, int i2) {
        AppMethodBeat.i(134231);
        ab.i("MicroMsg.ItemMoveHelper", "[onMoved] position:" + t.kj() + " target:" + t2.kj());
        ab.i("MicroMsg.ItemMoveHelper", "alvinluo onMoved mList: %d", Integer.valueOf(this.iKa.hashCode()));
        int i3;
        if (i < i2) {
            for (i3 = i; i3 < i2; i3++) {
                Collections.swap(this.iKa, i3, i3 + 1);
            }
        } else {
            for (i3 = i; i3 > i2; i3--) {
                Collections.swap(this.iKa, i3, i3 - 1);
            }
        }
        ab.i("MicroMsg.ItemMoveHelper", "alvinluo onMoved end mList: %d", Integer.valueOf(this.iKa.hashCode()));
        recyclerView.getAdapter().as(i, i2);
        if (this.jbq != null) {
            this.endPos = i2;
            this.jbq.f(this.jbp, i2);
        }
        AppMethodBeat.o(134231);
        return true;
    }

    public final void a(RecyclerView recyclerView, T t, int i, Runnable runnable) {
        AppMethodBeat.i(134232);
        if (this.jbg != null) {
            this.jbg.cu(this.iYn);
        }
        final Runnable runnable2 = runnable;
        final AnonymousClass1 anonymousClass1 = new Runnable() {
            public final void run() {
                AppMethodBeat.i(134226);
                if (e.this.jbg != null) {
                    e.this.jbg.a(e.this.coc, e.this.endPos, e.this.jbp, true);
                }
                runnable2.run();
                AppMethodBeat.o(134226);
            }
        };
        if (!(t == null || this.iYn == null)) {
            float f;
            ab.i("ItemMoveHelper", "[finishMove] position" + t.kj() + " dragViewPosition:" + i);
            final v cf = recyclerView.cf(i);
            float translationX = this.iYn.getTranslationX();
            float translationY = this.iYn.getTranslationY();
            if (i == t.kj() || cf != null) {
                if (cf != null) {
                    translationY = this.jbq.aNa() + b.c(recyclerView, cf);
                    translationX = this.jbq.aNb() + b.Q(cf);
                    if (this.iYu == null) {
                        f = 0.0f;
                    } else {
                        int computeVerticalScrollOffset = this.iYu.computeVerticalScrollOffset();
                        int computeVerticalScrollExtent = recyclerView.computeVerticalScrollExtent();
                        int computeVerticalScrollRange = (this.iYu.computeVerticalScrollRange() - recyclerView.getMeasuredHeight()) - computeVerticalScrollOffset;
                        ab.i("MicroMsg.ItemMoveHelper", "alvinluo computeMoveExtraY scrollOffset: %d, scrollExtent: %d, scrollRange: %d, height: %d, extra: %d, diff: %d", Integer.valueOf(computeVerticalScrollOffset), Integer.valueOf(computeVerticalScrollExtent), Integer.valueOf(this.iYu.computeVerticalScrollRange()), Integer.valueOf(recyclerView.getMeasuredHeight()), Integer.valueOf((int) (recyclerView.getResources().getDimension(R.dimen.a7o) * 0.75f)), Integer.valueOf(computeVerticalScrollRange));
                        if (((float) computeVerticalScrollRange) > recyclerView.getResources().getDimension(R.dimen.a7o) * 0.75f) {
                            f = 0.0f;
                        } else {
                            f = (recyclerView.getResources().getDimension(R.dimen.a7o) * 0.75f) - ((float) computeVerticalScrollRange);
                        }
                    }
                    ab.i("MicroMsg.ItemMoveHelper", "alvinluo finishMove computeMoveExtraY %f", Float.valueOf(f));
                    f += translationX;
                    translationX = translationY;
                } else {
                    f = translationY;
                }
            } else if (((LinearLayoutManager) recyclerView.getLayoutManager()).iQ() > i) {
                f = translationY - ((float) recyclerView.getHeight());
            } else {
                f = ((float) recyclerView.getHeight()) + translationY;
            }
            View cv = this.jbq.cv(this.iYn);
            if (cv == null) {
                cv = this.iYn;
            }
            cv.animate().scaleX(1.0f).scaleY(1.0f).setDuration(300).setListener(null).start();
            this.iYn.animate().translationX(translationX).translationY(f).setDuration(300).setListener(new AnimatorListener() {
                public final void onAnimationStart(Animator animator) {
                }

                public final void onAnimationEnd(Animator animator) {
                    AppMethodBeat.i(134227);
                    e.this.jbb.removeView(e.this.iYn);
                    e.this.iYn.setVisibility(8);
                    if (cf != null) {
                        cf.apJ.setVisibility(0);
                    }
                    anonymousClass1.run();
                    AppMethodBeat.o(134227);
                }

                public final void onAnimationCancel(Animator animator) {
                }

                public final void onAnimationRepeat(Animator animator) {
                }
            }).start();
        }
        AppMethodBeat.o(134232);
    }

    public final void a(View view, float f, float f2, v vVar, int i) {
        AppMethodBeat.i(134233);
        if (view == null) {
            AppMethodBeat.o(134233);
            return;
        }
        view.setTranslationX(view.getTranslationX() - f);
        view.setTranslationY(view.getTranslationY() - f2);
        AppMethodBeat.o(134233);
    }

    public final boolean P(T t) {
        AppMethodBeat.i(134234);
        if (this.jbg != null) {
            boolean P = this.jbg.P(t);
            AppMethodBeat.o(134234);
            return P;
        }
        AppMethodBeat.o(134234);
        return false;
    }

    public final void m(RecyclerView recyclerView) {
    }

    public final void e(RecyclerView recyclerView, T t) {
        AppMethodBeat.i(134235);
        ab.i("MicroMsg.ItemMoveHelper", "alvinluo onDelete adapter position: %d", Integer.valueOf(t.kj()));
        if (t instanceof com.tencent.mm.plugin.appbrand.widget.desktop.e) {
            ab.i("MicroMsg.ItemMoveHelper", "alvinluo onDelete holder: %s", ((com.tencent.mm.plugin.appbrand.widget.desktop.e) t).gne.getText());
        }
        this.iKa.remove(t.kj());
        ab.i("MicroMsg.ItemMoveHelper", "alvinluo mList hashCode: %d", Integer.valueOf(this.iKa.hashCode()));
        recyclerView.getAdapter().ci(t.kj());
        if (this.jbg != null) {
            this.jbg.by(this.jbp);
        }
        AppMethodBeat.o(134235);
    }

    public final View d(RecyclerView recyclerView, T t) {
        AppMethodBeat.i(134229);
        FrameLayout frameLayout = this.jbb;
        t.apJ.setVisibility(4);
        View b = this.jbg.b(recyclerView, t);
        b.setAlpha(1.0f);
        b.setScaleX(1.0f);
        b.setScaleY(1.0f);
        b.setVisibility(0);
        this.iYn = b;
        frameLayout.addView(b);
        ab.i("MicroMsg.ItemMoveHelper", "[onDragBegin] position:" + t.kj());
        if (this.jbq != null && this.iKa.size() > t.kj()) {
            this.jbp = this.jbq.bz(this.iKa.get(t.kj()));
            this.coc = t.kj();
            this.endPos = this.coc;
        }
        View view = this.iYn;
        AppMethodBeat.o(134229);
        return view;
    }
}
