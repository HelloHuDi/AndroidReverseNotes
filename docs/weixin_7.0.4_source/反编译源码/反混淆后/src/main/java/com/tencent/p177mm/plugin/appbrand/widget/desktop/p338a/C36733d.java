package com.tencent.p177mm.plugin.appbrand.widget.desktop.p338a;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.support.p069v7.widget.LinearLayoutManager;
import android.support.p069v7.widget.RecyclerView;
import android.support.p069v7.widget.RecyclerView.C41531v;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.plugin.appbrand.widget.desktop.AppBrandDesktopView.C19835c;
import com.tencent.p177mm.plugin.appbrand.widget.desktop.C42712g;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.Collections;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.appbrand.widget.desktop.a.d */
public final class C36733d<T extends C41531v> extends C33601b<T> {
    int coc = 0;
    int endPos = 0;
    View iYn;
    public C42712g iYu = null;
    FrameLayout jbb;
    private List jbc;
    List jbd;
    Object jbe;
    boolean jbf;
    public C2541a jbg;
    C31333a jbh;
    public int paddingLeft = 0;
    public int paddingTop = 0;

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.desktop.a.d$a */
    public interface C31333a extends C27359f {
        void aPj();

        void aPk();

        /* renamed from: x */
        boolean mo22525x(Object obj, Object obj2);
    }

    public C36733d(FrameLayout frameLayout, List list, List list2, C31333a c31333a) {
        this.jbb = frameLayout;
        this.jbc = list;
        this.jbh = c31333a;
        this.jbd = list2;
    }

    /* renamed from: O */
    public final boolean mo58581O(T t) {
        AppMethodBeat.m2504i(134215);
        if (this.jbg != null) {
            boolean O = this.jbg.mo6498O(t);
            AppMethodBeat.m2505o(134215);
            return O;
        } else if (t == null) {
            AppMethodBeat.m2505o(134215);
            return false;
        } else {
            AppMethodBeat.m2505o(134215);
            return true;
        }
    }

    /* renamed from: d */
    public final View mo58587d(RecyclerView recyclerView, T t) {
        AppMethodBeat.m2504i(134216);
        this.iYn = m60947f(recyclerView, t);
        if (this.iYn != null) {
            FrameLayout frameLayout = this.jbb;
            View f = m60947f(recyclerView, t);
            this.iYn = f;
            frameLayout.addView(f);
            this.jbf = false;
            if (t.mo66454kj() < this.jbc.size()) {
                this.jbe = this.jbh.mo22522bz(this.jbc.get(t.mo66454kj()));
                this.coc = t.mo66454kj();
                View view = this.iYn;
                AppMethodBeat.m2505o(134216);
                return view;
            }
        }
        AppMethodBeat.m2505o(134216);
        return null;
    }

    /* renamed from: R */
    public final boolean mo58583R(T t) {
        AppMethodBeat.m2504i(134217);
        if (this.jbg != null) {
            boolean a = this.jbg.mo6502a(t, this.jbe);
            AppMethodBeat.m2505o(134217);
            return a;
        }
        AppMethodBeat.m2505o(134217);
        return true;
    }

    /* renamed from: a */
    public final boolean mo58586a(final RecyclerView recyclerView, T t, T t2, final int i, final int i2) {
        AppMethodBeat.m2504i(134218);
        C4990ab.m7416i("ItemInsertHelper", "alvinluo ItemInsertHelper onMoved isHasInserted: " + this.jbf + ", from: " + i + ", to: " + i2);
        int i3;
        if (!this.jbf) {
            this.jbd.add(i2, this.jbe);
            recyclerView.post(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(134210);
                    recyclerView.getAdapter().mo66317ch(i2);
                    AppMethodBeat.m2505o(134210);
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
                        AppMethodBeat.m2504i(134211);
                        recyclerView.getAdapter().mo66309as(i, i2);
                        AppMethodBeat.m2505o(134211);
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
                        AppMethodBeat.m2504i(134212);
                        recyclerView.getAdapter().mo66309as(i, i2);
                        AppMethodBeat.m2505o(134212);
                    }
                });
            }
        }
        this.endPos = i2;
        if (this.jbh != null) {
            this.jbh.mo22524f(this.jbe, i2);
        }
        AppMethodBeat.m2505o(134218);
        return true;
    }

    /* renamed from: a */
    public final void mo58584a(final RecyclerView recyclerView, C41531v c41531v, int i, Runnable runnable) {
        AppMethodBeat.m2504i(134219);
        if (this.jbg != null) {
            this.jbg.mo6505cu(this.iYn);
        }
        final int i2 = i;
        final Runnable runnable2 = runnable;
        final C273584 c273584 = new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(134213);
                if (C36733d.this.jbf) {
                    C36733d c36733d = C36733d.this;
                    RecyclerView recyclerView = recyclerView;
                    Object obj = C36733d.this.jbe;
                    C4990ab.m7417i("ItemInsertHelper", "alvinluo checkDuplicate position: %d", Integer.valueOf(i2));
                    if (obj != null) {
                        int i;
                        if (c36733d.jbh != null) {
                            int i2 = 0;
                            i = -1;
                            while (i2 < c36733d.jbd.size()) {
                                if (c36733d.jbh.mo22525x(obj, c36733d.jbd.get(i2)) && i2 != r7) {
                                    i = i2;
                                }
                                i2++;
                            }
                        } else {
                            i = -1;
                        }
                        if (i != -1 && i < c36733d.jbd.size()) {
                            C4990ab.m7417i("ItemInsertHelper", "alvinluo checkDuplicate targetPosition: %d", Integer.valueOf(i));
                            c36733d.jbd.remove(i);
                            recyclerView.getAdapter().mo66318ci(i);
                        }
                    }
                }
                if (C36733d.this.jbg != null) {
                    C36733d.this.jbg.mo6500a(C36733d.this.coc, C36733d.this.endPos, C36733d.this.jbe, C36733d.this.jbf);
                }
                runnable2.run();
                AppMethodBeat.m2505o(134213);
            }
        };
        if (c41531v == null || this.iYn == null) {
            C4990ab.m7412e("ItemInsertHelper", "alvinluo finishMove viewHolder is null");
            AppMethodBeat.m2505o(134219);
            return;
        }
        float Q;
        C4990ab.m7416i("ItemInsertHelper", "[finishMove] position:" + c41531v.mo66454kj() + " dragViewPosition:" + i);
        final C41531v cf = recyclerView.mo66357cf(i);
        float translationX = this.iYn.getTranslationX();
        float translationY = this.iYn.getTranslationY();
        if (!this.jbf) {
            translationY = this.jbh.aNa() + C33601b.m54877c(recyclerView, c41531v);
            Q = C33601b.m54876Q(c41531v) + this.jbh.aNb();
            translationX = translationY;
        } else if (cf != null && i == cf.mo66454kj()) {
            if (this.jbf) {
                translationX = C33601b.m54877c(recyclerView, cf) + this.jbh.aNa();
                translationY = this.jbh.aNb() + C33601b.m54876Q(cf);
                if (this.iYu == null) {
                    Q = 0.0f;
                } else {
                    int computeVerticalScrollOffset = this.iYu.computeVerticalScrollOffset();
                    int computeVerticalScrollExtent = recyclerView.computeVerticalScrollExtent();
                    int computeVerticalScrollRange = (this.iYu.computeVerticalScrollRange() - recyclerView.getMeasuredHeight()) - computeVerticalScrollOffset;
                    C4990ab.m7417i("ItemInsertHelper", "alvinluo computeMoveExtraY scrollOffset: %d, scrollExtent: %d, scrollRange: %d, height: %d, extra: %d, diff: %d", Integer.valueOf(computeVerticalScrollOffset), Integer.valueOf(computeVerticalScrollExtent), Integer.valueOf(this.iYu.computeVerticalScrollRange()), Integer.valueOf(recyclerView.getMeasuredHeight()), Integer.valueOf((int) (recyclerView.getResources().getDimension(C25738R.dimen.a7o) * 0.75f)), Integer.valueOf(computeVerticalScrollRange));
                    if (((float) computeVerticalScrollRange) > recyclerView.getResources().getDimension(C25738R.dimen.a7o) * 0.75f) {
                        Q = 0.0f;
                    } else {
                        Q = (recyclerView.getResources().getDimension(C25738R.dimen.a7o) * 0.75f) - ((float) computeVerticalScrollRange);
                    }
                }
                translationY += Q;
                C4990ab.m7417i("ItemInsertHelper", "alvinluo finishMove computeMoveExtraY %f", Float.valueOf(Q));
            }
            Q = translationY;
        } else if (((LinearLayoutManager) recyclerView.getLayoutManager()).mo1780iQ() > i) {
            Q = translationY - ((float) recyclerView.getHeight());
        } else {
            Q = ((float) recyclerView.getHeight()) + translationY;
        }
        View cv = this.jbh.mo22523cv(this.iYn);
        if (cv == null) {
            cv = this.iYn;
        }
        C4990ab.m7417i("ItemInsertHelper", "alvinluo finishMove transX: %f, transY: %f", Float.valueOf(translationX), Float.valueOf(Q));
        this.iYn.findViewById(2131823276).setVisibility(4);
        cv.animate().scaleX(1.0f).scaleY(1.0f).setDuration(300).setListener(null).start();
        final C41531v c41531v2 = c41531v;
        this.iYn.animate().translationX(translationX).translationY(Q).setDuration(300).setListener(new AnimatorListener() {
            public final void onAnimationStart(Animator animator) {
            }

            public final void onAnimationEnd(Animator animator) {
                AppMethodBeat.m2504i(134214);
                C36733d.this.jbb.removeView(C36733d.this.iYn);
                if (C36733d.this.jbf) {
                    if (!(cf == null || cf.apJ == null)) {
                        cf.apJ.setVisibility(0);
                    }
                    if (c41531v2 != null) {
                        c41531v2.apJ.setVisibility(0);
                        c41531v2.apJ.setScaleX(0.0f);
                        c41531v2.apJ.setScaleY(0.0f);
                        c41531v2.apJ.animate().scaleX(1.0f).scaleY(1.0f).alpha(1.0f).setDuration(300).setListener(null).start();
                    }
                    c273584.run();
                    C36733d.this.iYn.setScaleX(1.0f);
                    C36733d.this.iYn.setScaleY(1.0f);
                    AppMethodBeat.m2505o(134214);
                    return;
                }
                c41531v2.apJ.setVisibility(0);
                c273584.run();
                AppMethodBeat.m2505o(134214);
            }

            public final void onAnimationCancel(Animator animator) {
            }

            public final void onAnimationRepeat(Animator animator) {
            }
        }).start();
        AppMethodBeat.m2505o(134219);
    }

    /* renamed from: a */
    public final void mo58585a(View view, float f, float f2, C41531v c41531v, int i) {
        AppMethodBeat.m2504i(134220);
        if (view == null) {
            AppMethodBeat.m2505o(134220);
            return;
        }
        view.setTranslationX(view.getTranslationX() - f);
        view.setTranslationY(view.getTranslationY() - f2);
        if (this.jbg != null) {
            this.jbg.mo6501a(c41531v, view, this.jbe, i);
        }
        AppMethodBeat.m2505o(134220);
    }

    /* renamed from: P */
    public final boolean mo58582P(T t) {
        AppMethodBeat.m2504i(134221);
        if (this.jbg != null) {
            boolean P = this.jbg.mo6499P(t);
            AppMethodBeat.m2505o(134221);
            return P;
        }
        AppMethodBeat.m2505o(134221);
        return false;
    }

    /* renamed from: e */
    public final void mo58588e(RecyclerView recyclerView, T t) {
        AppMethodBeat.m2504i(134222);
        int kj = t.mo66454kj();
        C4990ab.m7416i("ItemInsertHelper", "[onDelete] position:".concat(String.valueOf(kj)));
        if (kj >= 0 && kj < this.jbc.size()) {
            this.jbc.remove(kj);
        }
        m60948n(recyclerView);
        if (this.jbg != null) {
            if (this.jbe instanceof C19835c) {
                ((C19835c) this.jbe).position = t.mo66454kj();
            }
            this.jbg.mo6504by(this.jbe);
        }
        AppMethodBeat.m2505o(134222);
    }

    /* renamed from: m */
    public final void mo58589m(RecyclerView recyclerView) {
        AppMethodBeat.m2504i(134223);
        C4990ab.m7416i("ItemInsertHelper", "alvinluo onCancel");
        m60948n(recyclerView);
        AppMethodBeat.m2505o(134223);
    }

    /* renamed from: n */
    private void m60948n(RecyclerView recyclerView) {
        AppMethodBeat.m2504i(134224);
        if (this.jbf) {
            int indexOf = this.jbd.indexOf(this.jbe);
            if (indexOf >= 0) {
                this.jbd.remove(indexOf);
                recyclerView.getAdapter().mo66318ci(indexOf);
            }
            this.jbf = false;
            if (this.jbh != null) {
                this.jbh.aPk();
            }
        }
        AppMethodBeat.m2505o(134224);
    }

    /* renamed from: f */
    private View m60947f(RecyclerView recyclerView, T t) {
        AppMethodBeat.m2504i(134225);
        t.apJ.setVisibility(4);
        View b = this.jbg.mo6503b(recyclerView, t);
        b.setVisibility(0);
        AppMethodBeat.m2505o(134225);
        return b;
    }
}
