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
import com.tencent.p177mm.plugin.appbrand.widget.desktop.C42712g;
import com.tencent.p177mm.plugin.appbrand.widget.desktop.C46898e;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.Collections;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.appbrand.widget.desktop.a.e */
public final class C38577e<T extends C41531v> extends C33601b<T> {
    int coc = 0;
    int endPos = 0;
    private List iKa;
    View iYn;
    public C42712g iYu = null;
    FrameLayout jbb;
    public C2541a jbg;
    Object jbp;
    private C27359f jbq;
    public int paddingLeft = 0;
    public int paddingTop = 0;

    public C38577e(FrameLayout frameLayout, List list, C27359f c27359f) {
        this.jbb = frameLayout;
        this.iKa = list;
        this.jbq = c27359f;
    }

    /* renamed from: a */
    public final void mo61319a(C2541a c2541a) {
        this.jbg = c2541a;
    }

    /* renamed from: O */
    public final boolean mo58581O(T t) {
        AppMethodBeat.m2504i(134228);
        if (this.jbg != null) {
            boolean O = this.jbg.mo6498O(t);
            AppMethodBeat.m2505o(134228);
            return O;
        } else if (t == null) {
            AppMethodBeat.m2505o(134228);
            return false;
        } else {
            AppMethodBeat.m2505o(134228);
            return true;
        }
    }

    /* renamed from: R */
    public final boolean mo58583R(T t) {
        AppMethodBeat.m2504i(134230);
        if (this.jbg != null) {
            boolean a = this.jbg.mo6502a(t, null);
            AppMethodBeat.m2505o(134230);
            return a;
        }
        AppMethodBeat.m2505o(134230);
        return true;
    }

    /* renamed from: a */
    public final boolean mo58586a(RecyclerView recyclerView, T t, T t2, int i, int i2) {
        AppMethodBeat.m2504i(134231);
        C4990ab.m7416i("MicroMsg.ItemMoveHelper", "[onMoved] position:" + t.mo66454kj() + " target:" + t2.mo66454kj());
        C4990ab.m7417i("MicroMsg.ItemMoveHelper", "alvinluo onMoved mList: %d", Integer.valueOf(this.iKa.hashCode()));
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
        C4990ab.m7417i("MicroMsg.ItemMoveHelper", "alvinluo onMoved end mList: %d", Integer.valueOf(this.iKa.hashCode()));
        recyclerView.getAdapter().mo66309as(i, i2);
        if (this.jbq != null) {
            this.endPos = i2;
            this.jbq.mo22524f(this.jbp, i2);
        }
        AppMethodBeat.m2505o(134231);
        return true;
    }

    /* renamed from: a */
    public final void mo58584a(RecyclerView recyclerView, T t, int i, Runnable runnable) {
        AppMethodBeat.m2504i(134232);
        if (this.jbg != null) {
            this.jbg.mo6505cu(this.iYn);
        }
        final Runnable runnable2 = runnable;
        final C336021 c336021 = new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(134226);
                if (C38577e.this.jbg != null) {
                    C38577e.this.jbg.mo6500a(C38577e.this.coc, C38577e.this.endPos, C38577e.this.jbp, true);
                }
                runnable2.run();
                AppMethodBeat.m2505o(134226);
            }
        };
        if (!(t == null || this.iYn == null)) {
            float f;
            C4990ab.m7416i("ItemMoveHelper", "[finishMove] position" + t.mo66454kj() + " dragViewPosition:" + i);
            final C41531v cf = recyclerView.mo66357cf(i);
            float translationX = this.iYn.getTranslationX();
            float translationY = this.iYn.getTranslationY();
            if (i == t.mo66454kj() || cf != null) {
                if (cf != null) {
                    translationY = this.jbq.aNa() + C33601b.m54877c(recyclerView, cf);
                    translationX = this.jbq.aNb() + C33601b.m54876Q(cf);
                    if (this.iYu == null) {
                        f = 0.0f;
                    } else {
                        int computeVerticalScrollOffset = this.iYu.computeVerticalScrollOffset();
                        int computeVerticalScrollExtent = recyclerView.computeVerticalScrollExtent();
                        int computeVerticalScrollRange = (this.iYu.computeVerticalScrollRange() - recyclerView.getMeasuredHeight()) - computeVerticalScrollOffset;
                        C4990ab.m7417i("MicroMsg.ItemMoveHelper", "alvinluo computeMoveExtraY scrollOffset: %d, scrollExtent: %d, scrollRange: %d, height: %d, extra: %d, diff: %d", Integer.valueOf(computeVerticalScrollOffset), Integer.valueOf(computeVerticalScrollExtent), Integer.valueOf(this.iYu.computeVerticalScrollRange()), Integer.valueOf(recyclerView.getMeasuredHeight()), Integer.valueOf((int) (recyclerView.getResources().getDimension(C25738R.dimen.a7o) * 0.75f)), Integer.valueOf(computeVerticalScrollRange));
                        if (((float) computeVerticalScrollRange) > recyclerView.getResources().getDimension(C25738R.dimen.a7o) * 0.75f) {
                            f = 0.0f;
                        } else {
                            f = (recyclerView.getResources().getDimension(C25738R.dimen.a7o) * 0.75f) - ((float) computeVerticalScrollRange);
                        }
                    }
                    C4990ab.m7417i("MicroMsg.ItemMoveHelper", "alvinluo finishMove computeMoveExtraY %f", Float.valueOf(f));
                    f += translationX;
                    translationX = translationY;
                } else {
                    f = translationY;
                }
            } else if (((LinearLayoutManager) recyclerView.getLayoutManager()).mo1780iQ() > i) {
                f = translationY - ((float) recyclerView.getHeight());
            } else {
                f = ((float) recyclerView.getHeight()) + translationY;
            }
            View cv = this.jbq.mo22523cv(this.iYn);
            if (cv == null) {
                cv = this.iYn;
            }
            cv.animate().scaleX(1.0f).scaleY(1.0f).setDuration(300).setListener(null).start();
            this.iYn.animate().translationX(translationX).translationY(f).setDuration(300).setListener(new AnimatorListener() {
                public final void onAnimationStart(Animator animator) {
                }

                public final void onAnimationEnd(Animator animator) {
                    AppMethodBeat.m2504i(134227);
                    C38577e.this.jbb.removeView(C38577e.this.iYn);
                    C38577e.this.iYn.setVisibility(8);
                    if (cf != null) {
                        cf.apJ.setVisibility(0);
                    }
                    c336021.run();
                    AppMethodBeat.m2505o(134227);
                }

                public final void onAnimationCancel(Animator animator) {
                }

                public final void onAnimationRepeat(Animator animator) {
                }
            }).start();
        }
        AppMethodBeat.m2505o(134232);
    }

    /* renamed from: a */
    public final void mo58585a(View view, float f, float f2, C41531v c41531v, int i) {
        AppMethodBeat.m2504i(134233);
        if (view == null) {
            AppMethodBeat.m2505o(134233);
            return;
        }
        view.setTranslationX(view.getTranslationX() - f);
        view.setTranslationY(view.getTranslationY() - f2);
        AppMethodBeat.m2505o(134233);
    }

    /* renamed from: P */
    public final boolean mo58582P(T t) {
        AppMethodBeat.m2504i(134234);
        if (this.jbg != null) {
            boolean P = this.jbg.mo6499P(t);
            AppMethodBeat.m2505o(134234);
            return P;
        }
        AppMethodBeat.m2505o(134234);
        return false;
    }

    /* renamed from: m */
    public final void mo58589m(RecyclerView recyclerView) {
    }

    /* renamed from: e */
    public final void mo58588e(RecyclerView recyclerView, T t) {
        AppMethodBeat.m2504i(134235);
        C4990ab.m7417i("MicroMsg.ItemMoveHelper", "alvinluo onDelete adapter position: %d", Integer.valueOf(t.mo66454kj()));
        if (t instanceof C46898e) {
            C4990ab.m7417i("MicroMsg.ItemMoveHelper", "alvinluo onDelete holder: %s", ((C46898e) t).gne.getText());
        }
        this.iKa.remove(t.mo66454kj());
        C4990ab.m7417i("MicroMsg.ItemMoveHelper", "alvinluo mList hashCode: %d", Integer.valueOf(this.iKa.hashCode()));
        recyclerView.getAdapter().mo66318ci(t.mo66454kj());
        if (this.jbg != null) {
            this.jbg.mo6504by(this.jbp);
        }
        AppMethodBeat.m2505o(134235);
    }

    /* renamed from: d */
    public final View mo58587d(RecyclerView recyclerView, T t) {
        AppMethodBeat.m2504i(134229);
        FrameLayout frameLayout = this.jbb;
        t.apJ.setVisibility(4);
        View b = this.jbg.mo6503b(recyclerView, t);
        b.setAlpha(1.0f);
        b.setScaleX(1.0f);
        b.setScaleY(1.0f);
        b.setVisibility(0);
        this.iYn = b;
        frameLayout.addView(b);
        C4990ab.m7416i("MicroMsg.ItemMoveHelper", "[onDragBegin] position:" + t.mo66454kj());
        if (this.jbq != null && this.iKa.size() > t.mo66454kj()) {
            this.jbp = this.jbq.mo22522bz(this.iKa.get(t.mo66454kj()));
            this.coc = t.mo66454kj();
            this.endPos = this.coc;
        }
        View view = this.iYn;
        AppMethodBeat.m2505o(134229);
        return view;
    }
}
