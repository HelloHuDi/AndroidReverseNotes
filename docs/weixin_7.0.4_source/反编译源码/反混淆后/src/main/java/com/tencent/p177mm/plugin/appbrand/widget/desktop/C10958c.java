package com.tencent.p177mm.plugin.appbrand.widget.desktop;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.support.p057v4.view.C0477s;
import android.support.p069v7.widget.C17495av;
import android.support.p069v7.widget.LinearLayoutManager;
import android.support.p069v7.widget.RecyclerView;
import android.support.p069v7.widget.RecyclerView.C31879f.C17477a;
import android.support.p069v7.widget.RecyclerView.C41531v;
import android.view.View;
import android.view.ViewPropertyAnimator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.widget.recentview.BaseAppBrandRecentView.C19910c;
import com.tencent.p177mm.plugin.appbrand.widget.recentview.C33646e;
import com.tencent.p177mm.plugin.appbrand.widget.recentview.ConversationAppBrandRecentView;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.appbrand.widget.desktop.c */
public final class C10958c extends C17495av {
    private static TimeInterpolator ahn;
    private ArrayList<C41531v> aho = new ArrayList();
    private ArrayList<C41531v> ahp = new ArrayList();
    private ArrayList<C10968b> ahq = new ArrayList();
    private ArrayList<C10959a> ahr = new ArrayList();
    ArrayList<ArrayList<C41531v>> ahs = new ArrayList();
    ArrayList<ArrayList<C10968b>> aht = new ArrayList();
    ArrayList<ArrayList<C10959a>> ahu = new ArrayList();
    ArrayList<C41531v> ahv = new ArrayList();
    ArrayList<C41531v> ahw = new ArrayList();
    ArrayList<C41531v> ahx = new ArrayList();
    ArrayList<C41531v> ahy = new ArrayList();
    boolean iWU = false;
    public boolean iWV = false;
    ConversationAppBrandRecentView iWW;
    private C17477a iWX = new C109621();

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.desktop.c$3 */
    class C109543 extends AnimatorListenerAdapter {
        final /* synthetic */ ViewPropertyAnimator ahJ;
        final /* synthetic */ View ahK;
        final /* synthetic */ C10959a iWZ;
        final /* synthetic */ float iXa;
        final /* synthetic */ boolean iXb;

        C109543(C10959a c10959a, ViewPropertyAnimator viewPropertyAnimator, View view, float f, boolean z) {
            this.iWZ = c10959a;
            this.ahJ = viewPropertyAnimator;
            this.ahK = view;
            this.iXa = f;
            this.iXb = z;
        }

        public final void onAnimationStart(Animator animator) {
        }

        public final void onAnimationEnd(Animator animator) {
            AppMethodBeat.m2504i(133776);
            this.ahJ.setListener(null);
            this.ahK.setAlpha(this.iXa);
            this.ahK.setTranslationX(0.0f);
            this.ahK.setTranslationY(0.0f);
            C10958c.this.mo51947m(this.iWZ.ahM);
            C10958c.this.ahy.remove(this.iWZ.ahM);
            C10958c.this.mo22572hY();
            AppMethodBeat.m2505o(133776);
        }

        public final void onAnimationCancel(Animator animator) {
            AppMethodBeat.m2504i(133777);
            super.onAnimationCancel(animator);
            if (this.iXb) {
                this.ahK.setAlpha(1.0f);
                AppMethodBeat.m2505o(133777);
                return;
            }
            this.ahK.setAlpha(0.0f);
            AppMethodBeat.m2505o(133777);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.desktop.c$a */
    static class C10959a {
        public C41531v ahL;
        public C41531v ahM;
        public int ahN;
        public int ahO;
        public int ahP;
        public int ahQ;

        private C10959a(C41531v c41531v, C41531v c41531v2) {
            this.ahL = c41531v;
            this.ahM = c41531v2;
        }

        C10959a(C41531v c41531v, C41531v c41531v2, int i, int i2, int i3, int i4) {
            this(c41531v, c41531v2);
            this.ahN = i;
            this.ahO = i2;
            this.ahP = i3;
            this.ahQ = i4;
        }

        public final String toString() {
            AppMethodBeat.m2504i(133795);
            String str = "ChangeInfo{oldHolder=" + this.ahL + ", newHolder=" + this.ahM + ", fromX=" + this.ahN + ", fromY=" + this.ahO + ", toX=" + this.ahP + ", toY=" + this.ahQ + '}';
            AppMethodBeat.m2505o(133795);
            return str;
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.desktop.c$2 */
    class C109602 extends AnimatorListenerAdapter {
        final /* synthetic */ ViewPropertyAnimator ahI;
        final /* synthetic */ C10959a iWZ;
        final /* synthetic */ View val$view;

        C109602(C10959a c10959a, ViewPropertyAnimator viewPropertyAnimator, View view) {
            this.iWZ = c10959a;
            this.ahI = viewPropertyAnimator;
            this.val$view = view;
        }

        public final void onAnimationStart(Animator animator) {
        }

        public final void onAnimationEnd(Animator animator) {
            AppMethodBeat.m2504i(133775);
            this.ahI.setListener(null);
            this.val$view.setAlpha(1.0f);
            this.val$view.setTranslationX(0.0f);
            this.val$view.setTranslationY(0.0f);
            C10958c.this.mo51947m(this.iWZ.ahL);
            C10958c.this.ahy.remove(this.iWZ.ahL);
            C10958c.this.mo22572hY();
            AppMethodBeat.m2505o(133775);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.desktop.c$10 */
    class C1096110 implements Runnable {
        final /* synthetic */ C41531v ahD;
        final /* synthetic */ ViewPropertyAnimator ahE;
        final /* synthetic */ View val$view;

        /* renamed from: com.tencent.mm.plugin.appbrand.widget.desktop.c$10$1 */
        class C109531 extends AnimatorListenerAdapter {
            C109531() {
            }

            public final void onAnimationStart(Animator animator) {
            }

            public final void onAnimationCancel(Animator animator) {
                AppMethodBeat.m2504i(133789);
                C1096110.this.val$view.setAlpha(1.0f);
                C1096110.this.val$view.setScaleX(1.0f);
                C1096110.this.val$view.setScaleY(1.0f);
                C1096110.this.val$view.setVisibility(0);
                AppMethodBeat.m2505o(133789);
            }

            public final void onAnimationEnd(Animator animator) {
                AppMethodBeat.m2504i(133790);
                C1096110.this.ahE.setListener(null);
                ((C19910c) C1096110.this.ahD).iYe.animate().setListener(null);
                C10958c.this.mo51947m(C1096110.this.ahD);
                C10958c.this.ahv.remove(C1096110.this.ahD);
                C10958c.this.mo22572hY();
                AppMethodBeat.m2505o(133790);
            }
        }

        C1096110(C41531v c41531v, View view, ViewPropertyAnimator viewPropertyAnimator) {
            this.ahD = c41531v;
            this.val$view = view;
            this.ahE = viewPropertyAnimator;
        }

        public final void run() {
            AppMethodBeat.m2504i(133791);
            ((C19910c) this.ahD).iYe.animate().scaleX(1.0f).scaleY(1.0f).setDuration(150).setListener(new C109531()).start();
            AppMethodBeat.m2505o(133791);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.desktop.c$1 */
    class C109621 implements C17477a {
        C109621() {
        }

        /* renamed from: jT */
        public final void mo22448jT() {
            AppMethodBeat.m2504i(133774);
            if (C10958c.this.iWW != null) {
                ConversationAppBrandRecentView conversationAppBrandRecentView = C10958c.this.iWW;
                C10958c.this.iWW.getCurrentPage();
                LinearLayoutManager linearLayoutManager = (LinearLayoutManager) conversationAppBrandRecentView.getLayoutManager();
                int iQ = linearLayoutManager.mo1780iQ();
                int iS = linearLayoutManager.mo1782iS();
                C4990ab.m7417i("MicroMsg.AppBrandDesktopRecyclerItemAnimator", "alvinluo checkAlphaChange firstPos: %d, lastPos: %d", Integer.valueOf(iQ), Integer.valueOf(iS));
                for (int i = iQ; i <= iS; i++) {
                    C41531v cf = conversationAppBrandRecentView.mo66357cf(i);
                    if (!(cf == null || cf.apJ == null)) {
                        cf.apJ.setScaleX(1.0f);
                        cf.apJ.setScaleY(1.0f);
                        if (i == iS) {
                            cf.apJ.setAlpha(0.3f);
                        } else {
                            cf.apJ.setAlpha(1.0f);
                        }
                    }
                }
            }
            AppMethodBeat.m2505o(133774);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.desktop.c$8 */
    class C109638 implements Runnable {
        final /* synthetic */ C41531v ahD;
        final /* synthetic */ ViewPropertyAnimator ahE;
        final /* synthetic */ View val$view;

        /* renamed from: com.tencent.mm.plugin.appbrand.widget.desktop.c$8$1 */
        class C109641 extends AnimatorListenerAdapter {
            C109641() {
            }

            public final void onAnimationStart(Animator animator) {
            }

            public final void onAnimationCancel(Animator animator) {
                AppMethodBeat.m2504i(133784);
                C4990ab.m7418v("MicroMsg.AppBrandDesktopRecyclerItemAnimator", "alvinluo onAnimationCancel");
                ((C19910c) C109638.this.ahD).iYe.setAlpha(1.0f);
                ((C19910c) C109638.this.ahD).iYe.setScaleX(1.0f);
                ((C19910c) C109638.this.ahD).iYe.setScaleY(1.0f);
                ((C19910c) C109638.this.ahD).iYe.animate().setListener(null);
                C109638.this.val$view.setVisibility(0);
                C10958c.this.iWV = false;
                AppMethodBeat.m2505o(133784);
            }

            public final void onAnimationEnd(Animator animator) {
                AppMethodBeat.m2504i(133785);
                C4990ab.m7418v("MicroMsg.AppBrandDesktopRecyclerItemAnimator", "alvinluo onAnimationEnd");
                C109638.this.ahE.setListener(null);
                ((C19910c) C109638.this.ahD).iYe.setAlpha(1.0f);
                ((C19910c) C109638.this.ahD).iYe.setScaleX(1.0f);
                ((C19910c) C109638.this.ahD).iYe.setScaleY(1.0f);
                ((C19910c) C109638.this.ahD).iYe.animate().setListener(null);
                C10958c.this.mo51947m(C109638.this.ahD);
                C10958c.this.ahv.remove(C109638.this.ahD);
                C10958c.this.mo22572hY();
                C10958c.this.iWV = false;
                AppMethodBeat.m2505o(133785);
            }
        }

        C109638(C41531v c41531v, View view, ViewPropertyAnimator viewPropertyAnimator) {
            this.ahD = c41531v;
            this.val$view = view;
            this.ahE = viewPropertyAnimator;
        }

        public final void run() {
            AppMethodBeat.m2504i(133786);
            ((C19910c) this.ahD).iYe.animate().scaleX(1.0f).scaleY(1.0f).setDuration(150).setListener(new C109641()).start();
            AppMethodBeat.m2505o(133786);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.desktop.c$11 */
    class C1096611 extends AnimatorListenerAdapter {
        final /* synthetic */ C41531v ahD;
        final /* synthetic */ ViewPropertyAnimator ahE;
        final /* synthetic */ int ahF;
        final /* synthetic */ int ahG;
        final /* synthetic */ float iXa;
        final /* synthetic */ boolean iXb;
        final /* synthetic */ View val$view;

        C1096611(C41531v c41531v, int i, View view, int i2, boolean z, float f, ViewPropertyAnimator viewPropertyAnimator) {
            this.ahD = c41531v;
            this.ahF = i;
            this.val$view = view;
            this.ahG = i2;
            this.iXb = z;
            this.iXa = f;
            this.ahE = viewPropertyAnimator;
        }

        public final void onAnimationStart(Animator animator) {
            AppMethodBeat.m2504i(133792);
            C10958c.this.mo31915F(this.ahD);
            AppMethodBeat.m2505o(133792);
        }

        public final void onAnimationCancel(Animator animator) {
            AppMethodBeat.m2504i(133793);
            if (this.ahF != 0) {
                this.val$view.setTranslationX(0.0f);
            }
            if (this.ahG != 0) {
                this.val$view.setTranslationY(0.0f);
            }
            if (this.iXb) {
                this.val$view.setAlpha(this.iXa);
                AppMethodBeat.m2505o(133793);
                return;
            }
            this.val$view.setAlpha(0.0f);
            AppMethodBeat.m2505o(133793);
        }

        public final void onAnimationEnd(Animator animator) {
            AppMethodBeat.m2504i(133794);
            this.ahE.setListener(null);
            C10958c.this.mo31913C(this.ahD);
            C10958c.this.ahw.remove(this.ahD);
            C10958c.this.mo22572hY();
            AppMethodBeat.m2505o(133794);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.desktop.c$9 */
    class C109679 extends AnimatorListenerAdapter {
        final /* synthetic */ C41531v ahD;
        final /* synthetic */ ViewPropertyAnimator ahE;
        final /* synthetic */ int gvp;
        final /* synthetic */ boolean iXb;
        final /* synthetic */ View val$view;

        C109679(C41531v c41531v, View view, int i, boolean z, ViewPropertyAnimator viewPropertyAnimator) {
            this.ahD = c41531v;
            this.val$view = view;
            this.gvp = i;
            this.iXb = z;
            this.ahE = viewPropertyAnimator;
        }

        public final void onAnimationStart(Animator animator) {
        }

        public final void onAnimationCancel(Animator animator) {
            AppMethodBeat.m2504i(133787);
            this.val$view.setAlpha(C10958c.this.iWW.mo61455qX(this.gvp) ? 0.3f : 1.0f);
            this.val$view.setScaleX(1.0f);
            this.val$view.setScaleY(1.0f);
            if (this.iXb) {
                this.val$view.setVisibility(0);
                AppMethodBeat.m2505o(133787);
                return;
            }
            this.val$view.setVisibility(4);
            AppMethodBeat.m2505o(133787);
        }

        public final void onAnimationEnd(Animator animator) {
            AppMethodBeat.m2504i(133788);
            this.ahE.setListener(null);
            C10958c.this.mo51947m(this.ahD);
            C10958c.this.ahv.remove(this.ahD);
            C10958c.this.mo22572hY();
            AppMethodBeat.m2505o(133788);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.desktop.c$b */
    static class C10968b {
        public int ahN;
        public int ahO;
        public int ahP;
        public int ahQ;
        public C41531v ahR;

        C10968b(C41531v c41531v, int i, int i2, int i3, int i4) {
            this.ahR = c41531v;
            this.ahN = i;
            this.ahO = i2;
            this.ahP = i3;
            this.ahQ = i4;
        }
    }

    public C10958c(ConversationAppBrandRecentView conversationAppBrandRecentView, boolean z) {
        AppMethodBeat.m2504i(133796);
        this.iWW = conversationAppBrandRecentView;
        this.iWU = z;
        AppMethodBeat.m2505o(133796);
    }

    /* renamed from: hX */
    public final void mo22571hX() {
        AppMethodBeat.m2504i(133797);
        mo51945a(this.iWX);
        Object obj = !this.aho.isEmpty() ? 1 : null;
        Object obj2 = !this.ahq.isEmpty() ? 1 : null;
        Object obj3 = !this.ahr.isEmpty() ? 1 : null;
        Object obj4 = !this.ahp.isEmpty() ? 1 : null;
        if (obj == null && obj2 == null && obj4 == null && obj3 == null) {
            AppMethodBeat.m2505o(133797);
            return;
        }
        final ArrayList arrayList;
        Iterator it = this.aho.iterator();
        while (it.hasNext()) {
            final C41531v c41531v = (C41531v) it.next();
            final View view = c41531v.apJ;
            final ViewPropertyAnimator animate = view.animate();
            this.ahx.add(c41531v);
            final int bo = RecyclerView.m72547bo(c41531v.apJ);
            float f = 0.0f;
            if (bo - 1 == C33646e.m54943rc(this.iWW.getCurrentPage())) {
                f = 0.3f;
            }
            C4990ab.m7411d("MicroMsg.AppBrandDesktopRecyclerItemAnimator", "alvinluo animateRemoveImpl %s, pos: %d, targetAlpha: %f", ((C19910c) c41531v).gne.getText(), Integer.valueOf(bo), Float.valueOf(f));
            animate.setDuration(this.aou).alpha(r1).setListener(new AnimatorListenerAdapter() {
                public final void onAnimationStart(Animator animator) {
                    AppMethodBeat.m2504i(133781);
                    C10958c.this.mo31914D(c41531v);
                    AppMethodBeat.m2505o(133781);
                }

                public final void onAnimationEnd(Animator animator) {
                    AppMethodBeat.m2504i(133782);
                    C4990ab.m7419v("MicroMsg.AppBrandDesktopRecyclerItemAnimator", "alvinluo animateRemoveImpl onAnimationEnd, pos: %d", Integer.valueOf(bo));
                    animate.setListener(null);
                    view.setAlpha(1.0f);
                    C10958c.this.mo31912B(c41531v);
                    C10958c.this.ahx.remove(c41531v);
                    C10958c.this.mo22572hY();
                    AppMethodBeat.m2505o(133782);
                }

                public final void onAnimationCancel(Animator animator) {
                    AppMethodBeat.m2504i(133783);
                    C4990ab.m7418v("MicroMsg.AppBrandDesktopRecyclerItemAnimator", "alvinluo animateRemoveImpl onAnimationCancel");
                    AppMethodBeat.m2505o(133783);
                }
            }).start();
        }
        this.aho.clear();
        if (obj2 != null) {
            arrayList = new ArrayList();
            arrayList.addAll(this.ahq);
            this.aht.add(arrayList);
            this.ahq.clear();
            C109554 c109554 = new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(133778);
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        C10968b c10968b = (C10968b) it.next();
                        C10958c c10958c = C10958c.this;
                        C41531v c41531v = c10968b.ahR;
                        int i = c10968b.ahN;
                        int i2 = c10968b.ahO;
                        int i3 = c10968b.ahP;
                        int i4 = c10968b.ahQ;
                        View view = c41531v.apJ;
                        i = i3 - i;
                        i2 = i4 - i2;
                        if (i != 0) {
                            view.animate().translationX(0.0f);
                        }
                        if (i2 != 0) {
                            view.animate().translationY(0.0f);
                        }
                        ViewPropertyAnimator animate = view.animate();
                        c10958c.ahw.add(c41531v);
                        i4 = RecyclerView.m72547bo(c41531v.apJ);
                        float f = 1.0f;
                        boolean z = i4 < c10958c.iWW.getDataCount();
                        if (!z) {
                            f = 0.0f;
                            c41531v.apJ.setVisibility(4);
                        } else if (C33646e.m54943rc(c10958c.iWW.getCurrentPage()) == i4 && i > 0) {
                            c41531v.apJ.setVisibility(0);
                            f = 0.3f;
                        } else if (C33646e.m54943rc(c10958c.iWW.getCurrentPage()) == i4 && i < 0) {
                            c41531v.apJ.setVisibility(0);
                            f = 0.3f;
                        }
                        C4990ab.m7411d("MicroMsg.AppBrandDesktopRecyclerItemAnimator", "alvinluo animateMoveImpl position: %d, %s, isValid: %b, targetAlpha: %f, deltaX: %d, lastPosOfPage: %d", Integer.valueOf(i4), ((C19910c) c41531v).gne.getText(), Boolean.valueOf(z), Float.valueOf(f), Integer.valueOf(i), Integer.valueOf(C33646e.m54943rc(c10958c.iWW.getCurrentPage())));
                        animate.alpha(f).setDuration(c10958c.aov).setListener(new C1096611(c41531v, i, view, i2, z, f, animate)).start();
                    }
                    arrayList.clear();
                    C10958c.this.aht.remove(arrayList);
                    AppMethodBeat.m2505o(133778);
                }
            };
            if (obj != null) {
                C0477s.m908a(((C10968b) arrayList.get(0)).ahR.apJ, c109554, this.aou);
            } else {
                c109554.run();
            }
        }
        if (obj3 != null) {
            arrayList = new ArrayList();
            arrayList.addAll(this.ahr);
            this.ahu.add(arrayList);
            this.ahr.clear();
            C109565 c109565 = new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(133779);
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        C10959a c10959a = (C10959a) it.next();
                        if (c10959a != null) {
                            C10958c c10958c = C10958c.this;
                            C41531v c41531v = c10959a.ahL;
                            View view = c41531v == null ? null : c41531v.apJ;
                            C41531v c41531v2 = c10959a.ahM;
                            View view2 = c41531v2 != null ? c41531v2.apJ : null;
                            C4990ab.m7419v("MicroMsg.AppBrandDesktopRecyclerItemAnimator", "alvinluo animateChangeImpl %s", ((C19910c) c41531v).gne.getText());
                            if (view != null) {
                                ViewPropertyAnimator duration = view.animate().setDuration(c10958c.aow);
                                c10958c.ahy.add(c10959a.ahL);
                                duration.translationX((float) (c10959a.ahP - c10959a.ahN));
                                duration.translationY((float) (c10959a.ahQ - c10959a.ahO));
                                duration.alpha(0.0f).setListener(new C109602(c10959a, duration, view)).start();
                            }
                            if (view2 != null) {
                                int bo = RecyclerView.m72547bo(view2);
                                float f = 1.0f;
                                boolean z = bo < c10958c.iWW.getDataCount();
                                if (z) {
                                    C4990ab.m7411d("MicroMsg.AppBrandDesktopRecyclerItemAnimator", "alvinluo animateChangeImpl lastVisiblePos: %d, position: %d", Integer.valueOf(((LinearLayoutManager) c10958c.iWW.getLayoutManager()).mo1782iS()), Integer.valueOf(bo));
                                    if (((LinearLayoutManager) c10958c.iWW.getLayoutManager()).mo1782iS() == bo) {
                                        f = 0.3f;
                                    }
                                } else {
                                    f = 0.0f;
                                }
                                ViewPropertyAnimator animate = view2.animate();
                                c10958c.ahy.add(c10959a.ahM);
                                animate.translationX(0.0f).translationY(0.0f).alpha(f).setDuration(c10958c.aow).setListener(new C109543(c10959a, animate, view2, f, z)).start();
                            }
                        }
                    }
                    arrayList.clear();
                    C10958c.this.ahu.remove(arrayList);
                    AppMethodBeat.m2505o(133779);
                }
            };
            if (obj != null) {
                C0477s.m908a(((C10959a) arrayList.get(0)).ahL.apJ, c109565, this.aou);
            } else {
                c109565.run();
            }
        }
        if (obj4 != null) {
            final ArrayList arrayList2 = new ArrayList();
            arrayList2.addAll(this.ahp);
            this.ahs.add(arrayList2);
            this.ahp.clear();
            C109576 c109576 = new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(133780);
                    Iterator it = arrayList2.iterator();
                    while (it.hasNext()) {
                        C41531v c41531v = (C41531v) it.next();
                        C10958c c10958c = C10958c.this;
                        C4990ab.m7419v("MicroMsg.AppBrandDesktopRecyclerItemAnimator", "alvinluo animateAddImpl holder %s", ((C19910c) c41531v).gne.getText());
                        View view = c41531v.apJ;
                        ViewPropertyAnimator animate = view.animate();
                        c10958c.ahv.add(c41531v);
                        int bo = RecyclerView.m72547bo(view);
                        ViewPropertyAnimator animate2;
                        if (c10958c.iWV && bo == 1) {
                            C4990ab.m7419v("MicroMsg.AppBrandDesktopRecyclerItemAnimator", "alvinluo animateFirstItemInserted holder %s", ((C19910c) c41531v).gne.getText());
                            view = c41531v.apJ;
                            animate2 = view.animate();
                            if ((RecyclerView.m72547bo(c41531v.apJ) < c10958c.iWW.getDataCount() ? 1 : null) == null) {
                                view.setVisibility(4);
                            } else {
                                view.setVisibility(0);
                                view.setAlpha(1.0f);
                                view.setScaleX(1.0f);
                                view.setScaleY(1.0f);
                                ((C19910c) c41531v).gne.setAlpha(0.0f);
                                ((C19910c) c41531v).iYe.setAlpha(0.0f);
                                ((C19910c) c41531v).iYe.setScaleX(1.0f);
                                ((C19910c) c41531v).iYe.setScaleY(1.0f);
                                ((C19910c) c41531v).gne.animate().alpha(1.0f).setDuration(150).setListener(null).start();
                                ((C19910c) c41531v).iYe.animate().alpha(1.0f).scaleX(1.2f).scaleY(1.2f).setDuration(150).withEndAction(new C109638(c41531v, view, animate2)).start();
                            }
                        } else if (c10958c.iWU && bo == c10958c.iWW.getDataCount() - 1) {
                            C4990ab.m7419v("MicroMsg.AppBrandDesktopRecyclerItemAnimator", "alvinluo lastItemAnimateAddImpl holder %s", ((C19910c) c41531v).gne.getText());
                            view = c41531v.apJ;
                            animate2 = view.animate();
                            view.setVisibility(0);
                            view.setAlpha(1.0f);
                            view.setScaleX(1.0f);
                            view.setScaleY(1.0f);
                            ((C19910c) c41531v).gne.setAlpha(0.0f);
                            ((C19910c) c41531v).iYe.setAlpha(0.0f);
                            ((C19910c) c41531v).iYe.setScaleX(1.0f);
                            ((C19910c) c41531v).iYe.setScaleY(1.0f);
                            ((C19910c) c41531v).gne.animate().alpha(1.0f).setDuration(150).setListener(null).start();
                            ((C19910c) c41531v).iYe.animate().alpha(1.0f).scaleX(1.2f).scaleY(1.2f).setDuration(150).withEndAction(new C1096110(c41531v, view, animate2)).start();
                        } else {
                            float f;
                            boolean z = bo < c10958c.iWW.getDataCount();
                            if (!z) {
                                c41531v.apJ.setVisibility(4);
                                f = 0.0f;
                            } else if (c10958c.iWW.mo61455qX(bo)) {
                                c41531v.apJ.setVisibility(0);
                                f = 0.3f;
                            } else {
                                c41531v.apJ.setVisibility(0);
                                f = 1.0f;
                            }
                            C4990ab.m7411d("MicroMsg.AppBrandDesktopRecyclerItemAnimator", "alvinluo animateAddImpl pos: %d, targetAlpha: %f, customItemCount: %d, dataCount: %d", Integer.valueOf(bo), Float.valueOf(f), Integer.valueOf(c10958c.iWW.getCustomItemCount()), Integer.valueOf(c10958c.iWW.getDataCount()));
                            animate.alpha(f).scaleX(1.0f).scaleY(1.0f).setDuration(c10958c.aot).setListener(new C109679(c41531v, view, bo, z, animate)).start();
                        }
                    }
                    arrayList2.clear();
                    C10958c.this.ahs.remove(arrayList2);
                    AppMethodBeat.m2505o(133780);
                }
            };
            if (obj == null && obj2 == null && obj3 == null) {
                c109576.run();
            } else {
                long j;
                long j2;
                long j3;
                if (obj != null) {
                    j = this.aou;
                } else {
                    j = 0;
                }
                if (obj2 != null) {
                    j2 = this.aov;
                } else {
                    j2 = 0;
                }
                if (obj3 != null) {
                    j3 = this.aow;
                } else {
                    j3 = 0;
                }
                C0477s.m908a(((C41531v) arrayList2.get(0)).apJ, c109576, j + Math.max(j2, j3));
                AppMethodBeat.m2505o(133797);
                return;
            }
        }
        AppMethodBeat.m2505o(133797);
    }

    /* renamed from: b */
    public final boolean mo22568b(C41531v c41531v) {
        AppMethodBeat.m2504i(133798);
        C4990ab.m7419v("MicroMsg.AppBrandDesktopRecyclerItemAnimator", "alvinluo animateRemove %s", ((C19910c) c41531v).gne.getText());
        m18691e(c41531v);
        this.aho.add(c41531v);
        AppMethodBeat.m2505o(133798);
        return true;
    }

    /* renamed from: c */
    public final boolean mo22569c(C41531v c41531v) {
        AppMethodBeat.m2504i(133799);
        m18691e(c41531v);
        C4990ab.m7419v("MicroMsg.AppBrandDesktopRecyclerItemAnimator", "alvinluo animateAdd holder %s", ((C19910c) c41531v).gne.getText());
        int bo = RecyclerView.m72547bo(c41531v.apJ);
        if ((bo < this.iWW.getDataCount() ? 1 : 0) == 0) {
            C4990ab.m7418v("MicroMsg.AppBrandDesktopRecyclerItemAnimator", "alvinluo animateAdd not valid item");
            ((C19910c) c41531v).apJ.setVisibility(4);
            AppMethodBeat.m2505o(133799);
            return true;
        } else if (this.iWW.mo61455qX(bo)) {
            C4990ab.m7411d("MicroMsg.AppBrandDesktopRecyclerItemAnimator", "alvinluo animateAdd last position %d of currentPage: %d", Integer.valueOf(bo), Integer.valueOf(this.iWW.getCurrentPage()));
            int y = (int) c41531v.apJ.getY();
            int y2 = (int) c41531v.apJ.getY();
            C4990ab.m7411d("MicroMsg.AppBrandDesktopRecyclerItemAnimator", "alvinluo animateLastItemOfPage fromX: %d, toX: %d", Integer.valueOf(C10969d.m18707dj(C4996ah.getContext()) + (((int) c41531v.apJ.getX()) + ((int) C10969d.m18709dl(C4996ah.getContext())))), Integer.valueOf((int) c41531v.apJ.getX()));
            c41531v.apJ.setVisibility(0);
            c41531v.apJ.animate().alpha(0.3f).setDuration(0).setListener(null).start();
            boolean a = mo22565a(c41531v, bo, y, r4, y2);
            AppMethodBeat.m2505o(133799);
            return a;
        } else {
            c41531v.apJ.setAlpha(0.0f);
            c41531v.apJ.setScaleX(0.8f);
            c41531v.apJ.setScaleY(0.8f);
            this.ahp.add(c41531v);
            AppMethodBeat.m2505o(133799);
            return true;
        }
    }

    /* renamed from: a */
    public final boolean mo22565a(C41531v c41531v, int i, int i2, int i3, int i4) {
        AppMethodBeat.m2504i(133800);
        View view = c41531v.apJ;
        int translationX = ((int) c41531v.apJ.getTranslationX()) + i;
        int translationY = ((int) c41531v.apJ.getTranslationY()) + i2;
        m18691e(c41531v);
        int i5 = i3 - translationX;
        int i6 = i4 - translationY;
        if (i5 == 0 && i6 == 0) {
            mo31913C(c41531v);
            AppMethodBeat.m2505o(133800);
            return false;
        }
        if (i5 != 0) {
            view.setTranslationX((float) (-i5));
        }
        if (i6 != 0) {
            view.setTranslationY((float) (-i6));
        }
        C4990ab.m7419v("MicroMsg.AppBrandDesktopRecyclerItemAnimator", "alvinluo animateMove holder %s", ((C19910c) c41531v).gne.getText());
        c41531v.apJ.setScaleX(1.0f);
        c41531v.apJ.setScaleY(1.0f);
        this.ahq.add(new C10968b(c41531v, translationX, translationY, i3, i4));
        AppMethodBeat.m2505o(133800);
        return true;
    }

    /* renamed from: a */
    public final boolean mo22566a(C41531v c41531v, C41531v c41531v2, int i, int i2, int i3, int i4) {
        AppMethodBeat.m2504i(133801);
        if (c41531v == c41531v2) {
            boolean a = mo22565a(c41531v, i, i2, i3, i4);
            AppMethodBeat.m2505o(133801);
            return a;
        }
        int bo = RecyclerView.m72547bo(c41531v.apJ);
        C4990ab.m7419v("MicroMsg.AppBrandDesktopRecyclerItemAnimator", "alvinluo animateChange %s, pos: %d", ((C19910c) c41531v2).gne.getText(), Integer.valueOf(bo));
        float translationX = c41531v.apJ.getTranslationX();
        float translationY = c41531v.apJ.getTranslationY();
        float alpha = c41531v.apJ.getAlpha();
        m18691e(c41531v);
        int i5 = (int) (((float) (i3 - i)) - translationX);
        int i6 = (int) (((float) (i4 - i2)) - translationY);
        c41531v.apJ.setTranslationX(translationX);
        c41531v.apJ.setTranslationY(translationY);
        c41531v.apJ.setAlpha(alpha);
        if (c41531v2 != null) {
            m18691e(c41531v2);
            c41531v2.apJ.setTranslationX((float) (-i5));
            c41531v2.apJ.setTranslationY((float) (-i6));
            c41531v2.apJ.setAlpha(0.0f);
        }
        this.ahr.add(new C10959a(c41531v, c41531v2, i, i2, i3, i4));
        AppMethodBeat.m2505o(133801);
        return true;
    }

    /* renamed from: a */
    private void m18689a(List<C10959a> list, C41531v c41531v) {
        AppMethodBeat.m2504i(133802);
        for (int size = list.size() - 1; size >= 0; size--) {
            C10959a c10959a = (C10959a) list.get(size);
            if (m18690a(c10959a, c41531v) && c10959a.ahL == null && c10959a.ahM == null) {
                list.remove(c10959a);
            }
        }
        AppMethodBeat.m2505o(133802);
    }

    /* renamed from: a */
    private void m18688a(C10959a c10959a) {
        AppMethodBeat.m2504i(133803);
        if (c10959a.ahL != null) {
            m18690a(c10959a, c10959a.ahL);
        }
        if (c10959a.ahM != null) {
            m18690a(c10959a, c10959a.ahM);
        }
        AppMethodBeat.m2505o(133803);
    }

    /* renamed from: a */
    private boolean m18690a(C10959a c10959a, C41531v c41531v) {
        AppMethodBeat.m2504i(133804);
        if (c10959a.ahM == c41531v) {
            c10959a.ahM = null;
        } else if (c10959a.ahL == c41531v) {
            c10959a.ahL = null;
        } else {
            AppMethodBeat.m2505o(133804);
            return false;
        }
        c41531v.apJ.setAlpha(1.0f);
        c41531v.apJ.setTranslationX(0.0f);
        c41531v.apJ.setTranslationY(0.0f);
        mo51947m(c41531v);
        AppMethodBeat.m2505o(133804);
        return true;
    }

    /* renamed from: d */
    public final void mo22570d(C41531v c41531v) {
        int size;
        ArrayList arrayList;
        AppMethodBeat.m2504i(133805);
        View view = c41531v.apJ;
        view.animate().cancel();
        for (size = this.ahq.size() - 1; size >= 0; size--) {
            if (((C10968b) this.ahq.get(size)).ahR == c41531v) {
                view.setTranslationY(0.0f);
                view.setTranslationX(0.0f);
                mo31913C(c41531v);
                this.ahq.remove(size);
            }
        }
        m18689a(this.ahr, c41531v);
        if (this.aho.remove(c41531v)) {
            view.setAlpha(1.0f);
            mo31912B(c41531v);
        }
        if (this.ahp.remove(c41531v)) {
            view.setAlpha(1.0f);
            mo51947m(c41531v);
        }
        for (size = this.ahu.size() - 1; size >= 0; size--) {
            List list = (ArrayList) this.ahu.get(size);
            m18689a(list, c41531v);
            if (list.isEmpty()) {
                this.ahu.remove(size);
            }
        }
        for (int size2 = this.aht.size() - 1; size2 >= 0; size2--) {
            arrayList = (ArrayList) this.aht.get(size2);
            int size3 = arrayList.size() - 1;
            while (size3 >= 0) {
                if (((C10968b) arrayList.get(size3)).ahR == c41531v) {
                    view.setTranslationY(0.0f);
                    view.setTranslationX(0.0f);
                    mo31913C(c41531v);
                    arrayList.remove(size3);
                    if (arrayList.isEmpty()) {
                        this.aht.remove(size2);
                    }
                } else {
                    size3--;
                }
            }
        }
        for (size = this.ahs.size() - 1; size >= 0; size--) {
            arrayList = (ArrayList) this.ahs.get(size);
            if (arrayList.remove(c41531v)) {
                view.setAlpha(1.0f);
                mo51947m(c41531v);
                if (arrayList.isEmpty()) {
                    this.ahs.remove(size);
                }
            }
        }
        this.ahx.remove(c41531v);
        this.ahv.remove(c41531v);
        this.ahy.remove(c41531v);
        this.ahw.remove(c41531v);
        mo22572hY();
        AppMethodBeat.m2505o(133805);
    }

    /* renamed from: e */
    private void m18691e(C41531v c41531v) {
        AppMethodBeat.m2504i(133806);
        if (ahn == null) {
            ahn = new ValueAnimator().getInterpolator();
        }
        c41531v.apJ.animate().setInterpolator(ahn);
        mo22570d(c41531v);
        AppMethodBeat.m2505o(133806);
    }

    public final boolean isRunning() {
        AppMethodBeat.m2504i(133807);
        if (this.ahp.isEmpty() && this.ahr.isEmpty() && this.ahq.isEmpty() && this.aho.isEmpty() && this.ahw.isEmpty() && this.ahx.isEmpty() && this.ahv.isEmpty() && this.ahy.isEmpty() && this.aht.isEmpty() && this.ahs.isEmpty() && this.ahu.isEmpty()) {
            AppMethodBeat.m2505o(133807);
            return false;
        }
        AppMethodBeat.m2505o(133807);
        return true;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: hY */
    public final void mo22572hY() {
        AppMethodBeat.m2504i(133808);
        if (!isRunning()) {
            mo51946jS();
        }
        AppMethodBeat.m2505o(133808);
    }

    /* renamed from: hZ */
    public final void mo22573hZ() {
        int size;
        AppMethodBeat.m2504i(133809);
        for (size = this.ahq.size() - 1; size >= 0; size--) {
            C10968b c10968b = (C10968b) this.ahq.get(size);
            View view = c10968b.ahR.apJ;
            view.setTranslationY(0.0f);
            view.setTranslationX(0.0f);
            mo31913C(c10968b.ahR);
            this.ahq.remove(size);
        }
        for (size = this.aho.size() - 1; size >= 0; size--) {
            mo31912B((C41531v) this.aho.get(size));
            this.aho.remove(size);
        }
        for (size = this.ahp.size() - 1; size >= 0; size--) {
            C41531v c41531v = (C41531v) this.ahp.get(size);
            c41531v.apJ.setAlpha(1.0f);
            mo51947m(c41531v);
            this.ahp.remove(size);
        }
        for (size = this.ahr.size() - 1; size >= 0; size--) {
            m18688a((C10959a) this.ahr.get(size));
        }
        this.ahr.clear();
        if (isRunning()) {
            int size2;
            ArrayList arrayList;
            int size3;
            for (size2 = this.aht.size() - 1; size2 >= 0; size2--) {
                arrayList = (ArrayList) this.aht.get(size2);
                for (size3 = arrayList.size() - 1; size3 >= 0; size3--) {
                    C10968b c10968b2 = (C10968b) arrayList.get(size3);
                    View view2 = c10968b2.ahR.apJ;
                    view2.setTranslationY(0.0f);
                    view2.setTranslationX(0.0f);
                    mo31913C(c10968b2.ahR);
                    arrayList.remove(size3);
                    if (arrayList.isEmpty()) {
                        this.aht.remove(arrayList);
                    }
                }
            }
            for (size2 = this.ahs.size() - 1; size2 >= 0; size2--) {
                arrayList = (ArrayList) this.ahs.get(size2);
                for (size3 = arrayList.size() - 1; size3 >= 0; size3--) {
                    C41531v c41531v2 = (C41531v) arrayList.get(size3);
                    c41531v2.apJ.setAlpha(1.0f);
                    mo51947m(c41531v2);
                    arrayList.remove(size3);
                    if (arrayList.isEmpty()) {
                        this.ahs.remove(arrayList);
                    }
                }
            }
            for (size2 = this.ahu.size() - 1; size2 >= 0; size2--) {
                arrayList = (ArrayList) this.ahu.get(size2);
                for (size3 = arrayList.size() - 1; size3 >= 0; size3--) {
                    m18688a((C10959a) arrayList.get(size3));
                    if (arrayList.isEmpty()) {
                        this.ahu.remove(arrayList);
                    }
                }
            }
            C10958c.m18692o(this.ahx);
            C10958c.m18692o(this.ahw);
            C10958c.m18692o(this.ahv);
            C10958c.m18692o(this.ahy);
            mo51946jS();
            AppMethodBeat.m2505o(133809);
            return;
        }
        AppMethodBeat.m2505o(133809);
    }

    /* renamed from: o */
    private static void m18692o(List<C41531v> list) {
        AppMethodBeat.m2504i(133810);
        for (int size = list.size() - 1; size >= 0; size--) {
            ((C41531v) list.get(size)).apJ.animate().cancel();
        }
        AppMethodBeat.m2505o(133810);
    }

    /* renamed from: a */
    public final boolean mo22567a(C41531v c41531v, List<Object> list) {
        AppMethodBeat.m2504i(133811);
        if (!list.isEmpty() || super.mo22567a(c41531v, list)) {
            AppMethodBeat.m2505o(133811);
            return true;
        }
        AppMethodBeat.m2505o(133811);
        return false;
    }
}
