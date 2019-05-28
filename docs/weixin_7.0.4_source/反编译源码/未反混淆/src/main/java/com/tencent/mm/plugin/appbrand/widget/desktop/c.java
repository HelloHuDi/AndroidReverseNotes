package com.tencent.mm.plugin.appbrand.widget.desktop;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.support.v4.view.s;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.v;
import android.support.v7.widget.av;
import android.view.View;
import android.view.ViewPropertyAnimator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.widget.recentview.ConversationAppBrandRecentView;
import com.tencent.mm.plugin.appbrand.widget.recentview.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class c extends av {
    private static TimeInterpolator ahn;
    private ArrayList<v> aho = new ArrayList();
    private ArrayList<v> ahp = new ArrayList();
    private ArrayList<b> ahq = new ArrayList();
    private ArrayList<a> ahr = new ArrayList();
    ArrayList<ArrayList<v>> ahs = new ArrayList();
    ArrayList<ArrayList<b>> aht = new ArrayList();
    ArrayList<ArrayList<a>> ahu = new ArrayList();
    ArrayList<v> ahv = new ArrayList();
    ArrayList<v> ahw = new ArrayList();
    ArrayList<v> ahx = new ArrayList();
    ArrayList<v> ahy = new ArrayList();
    boolean iWU = false;
    public boolean iWV = false;
    ConversationAppBrandRecentView iWW;
    private android.support.v7.widget.RecyclerView.f.a iWX = new android.support.v7.widget.RecyclerView.f.a() {
        public final void jT() {
            AppMethodBeat.i(133774);
            if (c.this.iWW != null) {
                ConversationAppBrandRecentView conversationAppBrandRecentView = c.this.iWW;
                c.this.iWW.getCurrentPage();
                LinearLayoutManager linearLayoutManager = (LinearLayoutManager) conversationAppBrandRecentView.getLayoutManager();
                int iQ = linearLayoutManager.iQ();
                int iS = linearLayoutManager.iS();
                ab.i("MicroMsg.AppBrandDesktopRecyclerItemAnimator", "alvinluo checkAlphaChange firstPos: %d, lastPos: %d", Integer.valueOf(iQ), Integer.valueOf(iS));
                for (int i = iQ; i <= iS; i++) {
                    v cf = conversationAppBrandRecentView.cf(i);
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
            AppMethodBeat.o(133774);
        }
    };

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.desktop.c$3 */
    class AnonymousClass3 extends AnimatorListenerAdapter {
        final /* synthetic */ ViewPropertyAnimator ahJ;
        final /* synthetic */ View ahK;
        final /* synthetic */ a iWZ;
        final /* synthetic */ float iXa;
        final /* synthetic */ boolean iXb;

        AnonymousClass3(a aVar, ViewPropertyAnimator viewPropertyAnimator, View view, float f, boolean z) {
            this.iWZ = aVar;
            this.ahJ = viewPropertyAnimator;
            this.ahK = view;
            this.iXa = f;
            this.iXb = z;
        }

        public final void onAnimationStart(Animator animator) {
        }

        public final void onAnimationEnd(Animator animator) {
            AppMethodBeat.i(133776);
            this.ahJ.setListener(null);
            this.ahK.setAlpha(this.iXa);
            this.ahK.setTranslationX(0.0f);
            this.ahK.setTranslationY(0.0f);
            c.this.m(this.iWZ.ahM);
            c.this.ahy.remove(this.iWZ.ahM);
            c.this.hY();
            AppMethodBeat.o(133776);
        }

        public final void onAnimationCancel(Animator animator) {
            AppMethodBeat.i(133777);
            super.onAnimationCancel(animator);
            if (this.iXb) {
                this.ahK.setAlpha(1.0f);
                AppMethodBeat.o(133777);
                return;
            }
            this.ahK.setAlpha(0.0f);
            AppMethodBeat.o(133777);
        }
    }

    static class a {
        public v ahL;
        public v ahM;
        public int ahN;
        public int ahO;
        public int ahP;
        public int ahQ;

        private a(v vVar, v vVar2) {
            this.ahL = vVar;
            this.ahM = vVar2;
        }

        a(v vVar, v vVar2, int i, int i2, int i3, int i4) {
            this(vVar, vVar2);
            this.ahN = i;
            this.ahO = i2;
            this.ahP = i3;
            this.ahQ = i4;
        }

        public final String toString() {
            AppMethodBeat.i(133795);
            String str = "ChangeInfo{oldHolder=" + this.ahL + ", newHolder=" + this.ahM + ", fromX=" + this.ahN + ", fromY=" + this.ahO + ", toX=" + this.ahP + ", toY=" + this.ahQ + '}';
            AppMethodBeat.o(133795);
            return str;
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.desktop.c$2 */
    class AnonymousClass2 extends AnimatorListenerAdapter {
        final /* synthetic */ ViewPropertyAnimator ahI;
        final /* synthetic */ a iWZ;
        final /* synthetic */ View val$view;

        AnonymousClass2(a aVar, ViewPropertyAnimator viewPropertyAnimator, View view) {
            this.iWZ = aVar;
            this.ahI = viewPropertyAnimator;
            this.val$view = view;
        }

        public final void onAnimationStart(Animator animator) {
        }

        public final void onAnimationEnd(Animator animator) {
            AppMethodBeat.i(133775);
            this.ahI.setListener(null);
            this.val$view.setAlpha(1.0f);
            this.val$view.setTranslationX(0.0f);
            this.val$view.setTranslationY(0.0f);
            c.this.m(this.iWZ.ahL);
            c.this.ahy.remove(this.iWZ.ahL);
            c.this.hY();
            AppMethodBeat.o(133775);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.desktop.c$10 */
    class AnonymousClass10 implements Runnable {
        final /* synthetic */ v ahD;
        final /* synthetic */ ViewPropertyAnimator ahE;
        final /* synthetic */ View val$view;

        AnonymousClass10(v vVar, View view, ViewPropertyAnimator viewPropertyAnimator) {
            this.ahD = vVar;
            this.val$view = view;
            this.ahE = viewPropertyAnimator;
        }

        public final void run() {
            AppMethodBeat.i(133791);
            ((com.tencent.mm.plugin.appbrand.widget.recentview.BaseAppBrandRecentView.c) this.ahD).iYe.animate().scaleX(1.0f).scaleY(1.0f).setDuration(150).setListener(new AnimatorListenerAdapter() {
                public final void onAnimationStart(Animator animator) {
                }

                public final void onAnimationCancel(Animator animator) {
                    AppMethodBeat.i(133789);
                    AnonymousClass10.this.val$view.setAlpha(1.0f);
                    AnonymousClass10.this.val$view.setScaleX(1.0f);
                    AnonymousClass10.this.val$view.setScaleY(1.0f);
                    AnonymousClass10.this.val$view.setVisibility(0);
                    AppMethodBeat.o(133789);
                }

                public final void onAnimationEnd(Animator animator) {
                    AppMethodBeat.i(133790);
                    AnonymousClass10.this.ahE.setListener(null);
                    ((com.tencent.mm.plugin.appbrand.widget.recentview.BaseAppBrandRecentView.c) AnonymousClass10.this.ahD).iYe.animate().setListener(null);
                    c.this.m(AnonymousClass10.this.ahD);
                    c.this.ahv.remove(AnonymousClass10.this.ahD);
                    c.this.hY();
                    AppMethodBeat.o(133790);
                }
            }).start();
            AppMethodBeat.o(133791);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.desktop.c$8 */
    class AnonymousClass8 implements Runnable {
        final /* synthetic */ v ahD;
        final /* synthetic */ ViewPropertyAnimator ahE;
        final /* synthetic */ View val$view;

        AnonymousClass8(v vVar, View view, ViewPropertyAnimator viewPropertyAnimator) {
            this.ahD = vVar;
            this.val$view = view;
            this.ahE = viewPropertyAnimator;
        }

        public final void run() {
            AppMethodBeat.i(133786);
            ((com.tencent.mm.plugin.appbrand.widget.recentview.BaseAppBrandRecentView.c) this.ahD).iYe.animate().scaleX(1.0f).scaleY(1.0f).setDuration(150).setListener(new AnimatorListenerAdapter() {
                public final void onAnimationStart(Animator animator) {
                }

                public final void onAnimationCancel(Animator animator) {
                    AppMethodBeat.i(133784);
                    ab.v("MicroMsg.AppBrandDesktopRecyclerItemAnimator", "alvinluo onAnimationCancel");
                    ((com.tencent.mm.plugin.appbrand.widget.recentview.BaseAppBrandRecentView.c) AnonymousClass8.this.ahD).iYe.setAlpha(1.0f);
                    ((com.tencent.mm.plugin.appbrand.widget.recentview.BaseAppBrandRecentView.c) AnonymousClass8.this.ahD).iYe.setScaleX(1.0f);
                    ((com.tencent.mm.plugin.appbrand.widget.recentview.BaseAppBrandRecentView.c) AnonymousClass8.this.ahD).iYe.setScaleY(1.0f);
                    ((com.tencent.mm.plugin.appbrand.widget.recentview.BaseAppBrandRecentView.c) AnonymousClass8.this.ahD).iYe.animate().setListener(null);
                    AnonymousClass8.this.val$view.setVisibility(0);
                    c.this.iWV = false;
                    AppMethodBeat.o(133784);
                }

                public final void onAnimationEnd(Animator animator) {
                    AppMethodBeat.i(133785);
                    ab.v("MicroMsg.AppBrandDesktopRecyclerItemAnimator", "alvinluo onAnimationEnd");
                    AnonymousClass8.this.ahE.setListener(null);
                    ((com.tencent.mm.plugin.appbrand.widget.recentview.BaseAppBrandRecentView.c) AnonymousClass8.this.ahD).iYe.setAlpha(1.0f);
                    ((com.tencent.mm.plugin.appbrand.widget.recentview.BaseAppBrandRecentView.c) AnonymousClass8.this.ahD).iYe.setScaleX(1.0f);
                    ((com.tencent.mm.plugin.appbrand.widget.recentview.BaseAppBrandRecentView.c) AnonymousClass8.this.ahD).iYe.setScaleY(1.0f);
                    ((com.tencent.mm.plugin.appbrand.widget.recentview.BaseAppBrandRecentView.c) AnonymousClass8.this.ahD).iYe.animate().setListener(null);
                    c.this.m(AnonymousClass8.this.ahD);
                    c.this.ahv.remove(AnonymousClass8.this.ahD);
                    c.this.hY();
                    c.this.iWV = false;
                    AppMethodBeat.o(133785);
                }
            }).start();
            AppMethodBeat.o(133786);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.desktop.c$11 */
    class AnonymousClass11 extends AnimatorListenerAdapter {
        final /* synthetic */ v ahD;
        final /* synthetic */ ViewPropertyAnimator ahE;
        final /* synthetic */ int ahF;
        final /* synthetic */ int ahG;
        final /* synthetic */ float iXa;
        final /* synthetic */ boolean iXb;
        final /* synthetic */ View val$view;

        AnonymousClass11(v vVar, int i, View view, int i2, boolean z, float f, ViewPropertyAnimator viewPropertyAnimator) {
            this.ahD = vVar;
            this.ahF = i;
            this.val$view = view;
            this.ahG = i2;
            this.iXb = z;
            this.iXa = f;
            this.ahE = viewPropertyAnimator;
        }

        public final void onAnimationStart(Animator animator) {
            AppMethodBeat.i(133792);
            c.this.F(this.ahD);
            AppMethodBeat.o(133792);
        }

        public final void onAnimationCancel(Animator animator) {
            AppMethodBeat.i(133793);
            if (this.ahF != 0) {
                this.val$view.setTranslationX(0.0f);
            }
            if (this.ahG != 0) {
                this.val$view.setTranslationY(0.0f);
            }
            if (this.iXb) {
                this.val$view.setAlpha(this.iXa);
                AppMethodBeat.o(133793);
                return;
            }
            this.val$view.setAlpha(0.0f);
            AppMethodBeat.o(133793);
        }

        public final void onAnimationEnd(Animator animator) {
            AppMethodBeat.i(133794);
            this.ahE.setListener(null);
            c.this.C(this.ahD);
            c.this.ahw.remove(this.ahD);
            c.this.hY();
            AppMethodBeat.o(133794);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.desktop.c$9 */
    class AnonymousClass9 extends AnimatorListenerAdapter {
        final /* synthetic */ v ahD;
        final /* synthetic */ ViewPropertyAnimator ahE;
        final /* synthetic */ int gvp;
        final /* synthetic */ boolean iXb;
        final /* synthetic */ View val$view;

        AnonymousClass9(v vVar, View view, int i, boolean z, ViewPropertyAnimator viewPropertyAnimator) {
            this.ahD = vVar;
            this.val$view = view;
            this.gvp = i;
            this.iXb = z;
            this.ahE = viewPropertyAnimator;
        }

        public final void onAnimationStart(Animator animator) {
        }

        public final void onAnimationCancel(Animator animator) {
            AppMethodBeat.i(133787);
            this.val$view.setAlpha(c.this.iWW.qX(this.gvp) ? 0.3f : 1.0f);
            this.val$view.setScaleX(1.0f);
            this.val$view.setScaleY(1.0f);
            if (this.iXb) {
                this.val$view.setVisibility(0);
                AppMethodBeat.o(133787);
                return;
            }
            this.val$view.setVisibility(4);
            AppMethodBeat.o(133787);
        }

        public final void onAnimationEnd(Animator animator) {
            AppMethodBeat.i(133788);
            this.ahE.setListener(null);
            c.this.m(this.ahD);
            c.this.ahv.remove(this.ahD);
            c.this.hY();
            AppMethodBeat.o(133788);
        }
    }

    static class b {
        public int ahN;
        public int ahO;
        public int ahP;
        public int ahQ;
        public v ahR;

        b(v vVar, int i, int i2, int i3, int i4) {
            this.ahR = vVar;
            this.ahN = i;
            this.ahO = i2;
            this.ahP = i3;
            this.ahQ = i4;
        }
    }

    public c(ConversationAppBrandRecentView conversationAppBrandRecentView, boolean z) {
        AppMethodBeat.i(133796);
        this.iWW = conversationAppBrandRecentView;
        this.iWU = z;
        AppMethodBeat.o(133796);
    }

    public final void hX() {
        AppMethodBeat.i(133797);
        a(this.iWX);
        Object obj = !this.aho.isEmpty() ? 1 : null;
        Object obj2 = !this.ahq.isEmpty() ? 1 : null;
        Object obj3 = !this.ahr.isEmpty() ? 1 : null;
        Object obj4 = !this.ahp.isEmpty() ? 1 : null;
        if (obj == null && obj2 == null && obj4 == null && obj3 == null) {
            AppMethodBeat.o(133797);
            return;
        }
        final ArrayList arrayList;
        Iterator it = this.aho.iterator();
        while (it.hasNext()) {
            final v vVar = (v) it.next();
            final View view = vVar.apJ;
            final ViewPropertyAnimator animate = view.animate();
            this.ahx.add(vVar);
            final int bo = RecyclerView.bo(vVar.apJ);
            float f = 0.0f;
            if (bo - 1 == e.rc(this.iWW.getCurrentPage())) {
                f = 0.3f;
            }
            ab.d("MicroMsg.AppBrandDesktopRecyclerItemAnimator", "alvinluo animateRemoveImpl %s, pos: %d, targetAlpha: %f", ((com.tencent.mm.plugin.appbrand.widget.recentview.BaseAppBrandRecentView.c) vVar).gne.getText(), Integer.valueOf(bo), Float.valueOf(f));
            animate.setDuration(this.aou).alpha(r1).setListener(new AnimatorListenerAdapter() {
                public final void onAnimationStart(Animator animator) {
                    AppMethodBeat.i(133781);
                    c.this.D(vVar);
                    AppMethodBeat.o(133781);
                }

                public final void onAnimationEnd(Animator animator) {
                    AppMethodBeat.i(133782);
                    ab.v("MicroMsg.AppBrandDesktopRecyclerItemAnimator", "alvinluo animateRemoveImpl onAnimationEnd, pos: %d", Integer.valueOf(bo));
                    animate.setListener(null);
                    view.setAlpha(1.0f);
                    c.this.B(vVar);
                    c.this.ahx.remove(vVar);
                    c.this.hY();
                    AppMethodBeat.o(133782);
                }

                public final void onAnimationCancel(Animator animator) {
                    AppMethodBeat.i(133783);
                    ab.v("MicroMsg.AppBrandDesktopRecyclerItemAnimator", "alvinluo animateRemoveImpl onAnimationCancel");
                    AppMethodBeat.o(133783);
                }
            }).start();
        }
        this.aho.clear();
        if (obj2 != null) {
            arrayList = new ArrayList();
            arrayList.addAll(this.ahq);
            this.aht.add(arrayList);
            this.ahq.clear();
            AnonymousClass4 anonymousClass4 = new Runnable() {
                public final void run() {
                    AppMethodBeat.i(133778);
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        b bVar = (b) it.next();
                        c cVar = c.this;
                        v vVar = bVar.ahR;
                        int i = bVar.ahN;
                        int i2 = bVar.ahO;
                        int i3 = bVar.ahP;
                        int i4 = bVar.ahQ;
                        View view = vVar.apJ;
                        i = i3 - i;
                        i2 = i4 - i2;
                        if (i != 0) {
                            view.animate().translationX(0.0f);
                        }
                        if (i2 != 0) {
                            view.animate().translationY(0.0f);
                        }
                        ViewPropertyAnimator animate = view.animate();
                        cVar.ahw.add(vVar);
                        i4 = RecyclerView.bo(vVar.apJ);
                        float f = 1.0f;
                        boolean z = i4 < cVar.iWW.getDataCount();
                        if (!z) {
                            f = 0.0f;
                            vVar.apJ.setVisibility(4);
                        } else if (e.rc(cVar.iWW.getCurrentPage()) == i4 && i > 0) {
                            vVar.apJ.setVisibility(0);
                            f = 0.3f;
                        } else if (e.rc(cVar.iWW.getCurrentPage()) == i4 && i < 0) {
                            vVar.apJ.setVisibility(0);
                            f = 0.3f;
                        }
                        ab.d("MicroMsg.AppBrandDesktopRecyclerItemAnimator", "alvinluo animateMoveImpl position: %d, %s, isValid: %b, targetAlpha: %f, deltaX: %d, lastPosOfPage: %d", Integer.valueOf(i4), ((com.tencent.mm.plugin.appbrand.widget.recentview.BaseAppBrandRecentView.c) vVar).gne.getText(), Boolean.valueOf(z), Float.valueOf(f), Integer.valueOf(i), Integer.valueOf(e.rc(cVar.iWW.getCurrentPage())));
                        animate.alpha(f).setDuration(cVar.aov).setListener(new AnonymousClass11(vVar, i, view, i2, z, f, animate)).start();
                    }
                    arrayList.clear();
                    c.this.aht.remove(arrayList);
                    AppMethodBeat.o(133778);
                }
            };
            if (obj != null) {
                s.a(((b) arrayList.get(0)).ahR.apJ, anonymousClass4, this.aou);
            } else {
                anonymousClass4.run();
            }
        }
        if (obj3 != null) {
            arrayList = new ArrayList();
            arrayList.addAll(this.ahr);
            this.ahu.add(arrayList);
            this.ahr.clear();
            AnonymousClass5 anonymousClass5 = new Runnable() {
                public final void run() {
                    AppMethodBeat.i(133779);
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        a aVar = (a) it.next();
                        if (aVar != null) {
                            c cVar = c.this;
                            v vVar = aVar.ahL;
                            View view = vVar == null ? null : vVar.apJ;
                            v vVar2 = aVar.ahM;
                            View view2 = vVar2 != null ? vVar2.apJ : null;
                            ab.v("MicroMsg.AppBrandDesktopRecyclerItemAnimator", "alvinluo animateChangeImpl %s", ((com.tencent.mm.plugin.appbrand.widget.recentview.BaseAppBrandRecentView.c) vVar).gne.getText());
                            if (view != null) {
                                ViewPropertyAnimator duration = view.animate().setDuration(cVar.aow);
                                cVar.ahy.add(aVar.ahL);
                                duration.translationX((float) (aVar.ahP - aVar.ahN));
                                duration.translationY((float) (aVar.ahQ - aVar.ahO));
                                duration.alpha(0.0f).setListener(new AnonymousClass2(aVar, duration, view)).start();
                            }
                            if (view2 != null) {
                                int bo = RecyclerView.bo(view2);
                                float f = 1.0f;
                                boolean z = bo < cVar.iWW.getDataCount();
                                if (z) {
                                    ab.d("MicroMsg.AppBrandDesktopRecyclerItemAnimator", "alvinluo animateChangeImpl lastVisiblePos: %d, position: %d", Integer.valueOf(((LinearLayoutManager) cVar.iWW.getLayoutManager()).iS()), Integer.valueOf(bo));
                                    if (((LinearLayoutManager) cVar.iWW.getLayoutManager()).iS() == bo) {
                                        f = 0.3f;
                                    }
                                } else {
                                    f = 0.0f;
                                }
                                ViewPropertyAnimator animate = view2.animate();
                                cVar.ahy.add(aVar.ahM);
                                animate.translationX(0.0f).translationY(0.0f).alpha(f).setDuration(cVar.aow).setListener(new AnonymousClass3(aVar, animate, view2, f, z)).start();
                            }
                        }
                    }
                    arrayList.clear();
                    c.this.ahu.remove(arrayList);
                    AppMethodBeat.o(133779);
                }
            };
            if (obj != null) {
                s.a(((a) arrayList.get(0)).ahL.apJ, anonymousClass5, this.aou);
            } else {
                anonymousClass5.run();
            }
        }
        if (obj4 != null) {
            final ArrayList arrayList2 = new ArrayList();
            arrayList2.addAll(this.ahp);
            this.ahs.add(arrayList2);
            this.ahp.clear();
            AnonymousClass6 anonymousClass6 = new Runnable() {
                public final void run() {
                    AppMethodBeat.i(133780);
                    Iterator it = arrayList2.iterator();
                    while (it.hasNext()) {
                        v vVar = (v) it.next();
                        c cVar = c.this;
                        ab.v("MicroMsg.AppBrandDesktopRecyclerItemAnimator", "alvinluo animateAddImpl holder %s", ((com.tencent.mm.plugin.appbrand.widget.recentview.BaseAppBrandRecentView.c) vVar).gne.getText());
                        View view = vVar.apJ;
                        ViewPropertyAnimator animate = view.animate();
                        cVar.ahv.add(vVar);
                        int bo = RecyclerView.bo(view);
                        ViewPropertyAnimator animate2;
                        if (cVar.iWV && bo == 1) {
                            ab.v("MicroMsg.AppBrandDesktopRecyclerItemAnimator", "alvinluo animateFirstItemInserted holder %s", ((com.tencent.mm.plugin.appbrand.widget.recentview.BaseAppBrandRecentView.c) vVar).gne.getText());
                            view = vVar.apJ;
                            animate2 = view.animate();
                            if ((RecyclerView.bo(vVar.apJ) < cVar.iWW.getDataCount() ? 1 : null) == null) {
                                view.setVisibility(4);
                            } else {
                                view.setVisibility(0);
                                view.setAlpha(1.0f);
                                view.setScaleX(1.0f);
                                view.setScaleY(1.0f);
                                ((com.tencent.mm.plugin.appbrand.widget.recentview.BaseAppBrandRecentView.c) vVar).gne.setAlpha(0.0f);
                                ((com.tencent.mm.plugin.appbrand.widget.recentview.BaseAppBrandRecentView.c) vVar).iYe.setAlpha(0.0f);
                                ((com.tencent.mm.plugin.appbrand.widget.recentview.BaseAppBrandRecentView.c) vVar).iYe.setScaleX(1.0f);
                                ((com.tencent.mm.plugin.appbrand.widget.recentview.BaseAppBrandRecentView.c) vVar).iYe.setScaleY(1.0f);
                                ((com.tencent.mm.plugin.appbrand.widget.recentview.BaseAppBrandRecentView.c) vVar).gne.animate().alpha(1.0f).setDuration(150).setListener(null).start();
                                ((com.tencent.mm.plugin.appbrand.widget.recentview.BaseAppBrandRecentView.c) vVar).iYe.animate().alpha(1.0f).scaleX(1.2f).scaleY(1.2f).setDuration(150).withEndAction(new AnonymousClass8(vVar, view, animate2)).start();
                            }
                        } else if (cVar.iWU && bo == cVar.iWW.getDataCount() - 1) {
                            ab.v("MicroMsg.AppBrandDesktopRecyclerItemAnimator", "alvinluo lastItemAnimateAddImpl holder %s", ((com.tencent.mm.plugin.appbrand.widget.recentview.BaseAppBrandRecentView.c) vVar).gne.getText());
                            view = vVar.apJ;
                            animate2 = view.animate();
                            view.setVisibility(0);
                            view.setAlpha(1.0f);
                            view.setScaleX(1.0f);
                            view.setScaleY(1.0f);
                            ((com.tencent.mm.plugin.appbrand.widget.recentview.BaseAppBrandRecentView.c) vVar).gne.setAlpha(0.0f);
                            ((com.tencent.mm.plugin.appbrand.widget.recentview.BaseAppBrandRecentView.c) vVar).iYe.setAlpha(0.0f);
                            ((com.tencent.mm.plugin.appbrand.widget.recentview.BaseAppBrandRecentView.c) vVar).iYe.setScaleX(1.0f);
                            ((com.tencent.mm.plugin.appbrand.widget.recentview.BaseAppBrandRecentView.c) vVar).iYe.setScaleY(1.0f);
                            ((com.tencent.mm.plugin.appbrand.widget.recentview.BaseAppBrandRecentView.c) vVar).gne.animate().alpha(1.0f).setDuration(150).setListener(null).start();
                            ((com.tencent.mm.plugin.appbrand.widget.recentview.BaseAppBrandRecentView.c) vVar).iYe.animate().alpha(1.0f).scaleX(1.2f).scaleY(1.2f).setDuration(150).withEndAction(new AnonymousClass10(vVar, view, animate2)).start();
                        } else {
                            float f;
                            boolean z = bo < cVar.iWW.getDataCount();
                            if (!z) {
                                vVar.apJ.setVisibility(4);
                                f = 0.0f;
                            } else if (cVar.iWW.qX(bo)) {
                                vVar.apJ.setVisibility(0);
                                f = 0.3f;
                            } else {
                                vVar.apJ.setVisibility(0);
                                f = 1.0f;
                            }
                            ab.d("MicroMsg.AppBrandDesktopRecyclerItemAnimator", "alvinluo animateAddImpl pos: %d, targetAlpha: %f, customItemCount: %d, dataCount: %d", Integer.valueOf(bo), Float.valueOf(f), Integer.valueOf(cVar.iWW.getCustomItemCount()), Integer.valueOf(cVar.iWW.getDataCount()));
                            animate.alpha(f).scaleX(1.0f).scaleY(1.0f).setDuration(cVar.aot).setListener(new AnonymousClass9(vVar, view, bo, z, animate)).start();
                        }
                    }
                    arrayList2.clear();
                    c.this.ahs.remove(arrayList2);
                    AppMethodBeat.o(133780);
                }
            };
            if (obj == null && obj2 == null && obj3 == null) {
                anonymousClass6.run();
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
                s.a(((v) arrayList2.get(0)).apJ, anonymousClass6, j + Math.max(j2, j3));
                AppMethodBeat.o(133797);
                return;
            }
        }
        AppMethodBeat.o(133797);
    }

    public final boolean b(v vVar) {
        AppMethodBeat.i(133798);
        ab.v("MicroMsg.AppBrandDesktopRecyclerItemAnimator", "alvinluo animateRemove %s", ((com.tencent.mm.plugin.appbrand.widget.recentview.BaseAppBrandRecentView.c) vVar).gne.getText());
        e(vVar);
        this.aho.add(vVar);
        AppMethodBeat.o(133798);
        return true;
    }

    public final boolean c(v vVar) {
        AppMethodBeat.i(133799);
        e(vVar);
        ab.v("MicroMsg.AppBrandDesktopRecyclerItemAnimator", "alvinluo animateAdd holder %s", ((com.tencent.mm.plugin.appbrand.widget.recentview.BaseAppBrandRecentView.c) vVar).gne.getText());
        int bo = RecyclerView.bo(vVar.apJ);
        if ((bo < this.iWW.getDataCount() ? 1 : 0) == 0) {
            ab.v("MicroMsg.AppBrandDesktopRecyclerItemAnimator", "alvinluo animateAdd not valid item");
            ((com.tencent.mm.plugin.appbrand.widget.recentview.BaseAppBrandRecentView.c) vVar).apJ.setVisibility(4);
            AppMethodBeat.o(133799);
            return true;
        } else if (this.iWW.qX(bo)) {
            ab.d("MicroMsg.AppBrandDesktopRecyclerItemAnimator", "alvinluo animateAdd last position %d of currentPage: %d", Integer.valueOf(bo), Integer.valueOf(this.iWW.getCurrentPage()));
            int y = (int) vVar.apJ.getY();
            int y2 = (int) vVar.apJ.getY();
            ab.d("MicroMsg.AppBrandDesktopRecyclerItemAnimator", "alvinluo animateLastItemOfPage fromX: %d, toX: %d", Integer.valueOf(d.dj(ah.getContext()) + (((int) vVar.apJ.getX()) + ((int) d.dl(ah.getContext())))), Integer.valueOf((int) vVar.apJ.getX()));
            vVar.apJ.setVisibility(0);
            vVar.apJ.animate().alpha(0.3f).setDuration(0).setListener(null).start();
            boolean a = a(vVar, bo, y, r4, y2);
            AppMethodBeat.o(133799);
            return a;
        } else {
            vVar.apJ.setAlpha(0.0f);
            vVar.apJ.setScaleX(0.8f);
            vVar.apJ.setScaleY(0.8f);
            this.ahp.add(vVar);
            AppMethodBeat.o(133799);
            return true;
        }
    }

    public final boolean a(v vVar, int i, int i2, int i3, int i4) {
        AppMethodBeat.i(133800);
        View view = vVar.apJ;
        int translationX = ((int) vVar.apJ.getTranslationX()) + i;
        int translationY = ((int) vVar.apJ.getTranslationY()) + i2;
        e(vVar);
        int i5 = i3 - translationX;
        int i6 = i4 - translationY;
        if (i5 == 0 && i6 == 0) {
            C(vVar);
            AppMethodBeat.o(133800);
            return false;
        }
        if (i5 != 0) {
            view.setTranslationX((float) (-i5));
        }
        if (i6 != 0) {
            view.setTranslationY((float) (-i6));
        }
        ab.v("MicroMsg.AppBrandDesktopRecyclerItemAnimator", "alvinluo animateMove holder %s", ((com.tencent.mm.plugin.appbrand.widget.recentview.BaseAppBrandRecentView.c) vVar).gne.getText());
        vVar.apJ.setScaleX(1.0f);
        vVar.apJ.setScaleY(1.0f);
        this.ahq.add(new b(vVar, translationX, translationY, i3, i4));
        AppMethodBeat.o(133800);
        return true;
    }

    public final boolean a(v vVar, v vVar2, int i, int i2, int i3, int i4) {
        AppMethodBeat.i(133801);
        if (vVar == vVar2) {
            boolean a = a(vVar, i, i2, i3, i4);
            AppMethodBeat.o(133801);
            return a;
        }
        int bo = RecyclerView.bo(vVar.apJ);
        ab.v("MicroMsg.AppBrandDesktopRecyclerItemAnimator", "alvinluo animateChange %s, pos: %d", ((com.tencent.mm.plugin.appbrand.widget.recentview.BaseAppBrandRecentView.c) vVar2).gne.getText(), Integer.valueOf(bo));
        float translationX = vVar.apJ.getTranslationX();
        float translationY = vVar.apJ.getTranslationY();
        float alpha = vVar.apJ.getAlpha();
        e(vVar);
        int i5 = (int) (((float) (i3 - i)) - translationX);
        int i6 = (int) (((float) (i4 - i2)) - translationY);
        vVar.apJ.setTranslationX(translationX);
        vVar.apJ.setTranslationY(translationY);
        vVar.apJ.setAlpha(alpha);
        if (vVar2 != null) {
            e(vVar2);
            vVar2.apJ.setTranslationX((float) (-i5));
            vVar2.apJ.setTranslationY((float) (-i6));
            vVar2.apJ.setAlpha(0.0f);
        }
        this.ahr.add(new a(vVar, vVar2, i, i2, i3, i4));
        AppMethodBeat.o(133801);
        return true;
    }

    private void a(List<a> list, v vVar) {
        AppMethodBeat.i(133802);
        for (int size = list.size() - 1; size >= 0; size--) {
            a aVar = (a) list.get(size);
            if (a(aVar, vVar) && aVar.ahL == null && aVar.ahM == null) {
                list.remove(aVar);
            }
        }
        AppMethodBeat.o(133802);
    }

    private void a(a aVar) {
        AppMethodBeat.i(133803);
        if (aVar.ahL != null) {
            a(aVar, aVar.ahL);
        }
        if (aVar.ahM != null) {
            a(aVar, aVar.ahM);
        }
        AppMethodBeat.o(133803);
    }

    private boolean a(a aVar, v vVar) {
        AppMethodBeat.i(133804);
        if (aVar.ahM == vVar) {
            aVar.ahM = null;
        } else if (aVar.ahL == vVar) {
            aVar.ahL = null;
        } else {
            AppMethodBeat.o(133804);
            return false;
        }
        vVar.apJ.setAlpha(1.0f);
        vVar.apJ.setTranslationX(0.0f);
        vVar.apJ.setTranslationY(0.0f);
        m(vVar);
        AppMethodBeat.o(133804);
        return true;
    }

    public final void d(v vVar) {
        int size;
        ArrayList arrayList;
        AppMethodBeat.i(133805);
        View view = vVar.apJ;
        view.animate().cancel();
        for (size = this.ahq.size() - 1; size >= 0; size--) {
            if (((b) this.ahq.get(size)).ahR == vVar) {
                view.setTranslationY(0.0f);
                view.setTranslationX(0.0f);
                C(vVar);
                this.ahq.remove(size);
            }
        }
        a(this.ahr, vVar);
        if (this.aho.remove(vVar)) {
            view.setAlpha(1.0f);
            B(vVar);
        }
        if (this.ahp.remove(vVar)) {
            view.setAlpha(1.0f);
            m(vVar);
        }
        for (size = this.ahu.size() - 1; size >= 0; size--) {
            List list = (ArrayList) this.ahu.get(size);
            a(list, vVar);
            if (list.isEmpty()) {
                this.ahu.remove(size);
            }
        }
        for (int size2 = this.aht.size() - 1; size2 >= 0; size2--) {
            arrayList = (ArrayList) this.aht.get(size2);
            int size3 = arrayList.size() - 1;
            while (size3 >= 0) {
                if (((b) arrayList.get(size3)).ahR == vVar) {
                    view.setTranslationY(0.0f);
                    view.setTranslationX(0.0f);
                    C(vVar);
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
            if (arrayList.remove(vVar)) {
                view.setAlpha(1.0f);
                m(vVar);
                if (arrayList.isEmpty()) {
                    this.ahs.remove(size);
                }
            }
        }
        this.ahx.remove(vVar);
        this.ahv.remove(vVar);
        this.ahy.remove(vVar);
        this.ahw.remove(vVar);
        hY();
        AppMethodBeat.o(133805);
    }

    private void e(v vVar) {
        AppMethodBeat.i(133806);
        if (ahn == null) {
            ahn = new ValueAnimator().getInterpolator();
        }
        vVar.apJ.animate().setInterpolator(ahn);
        d(vVar);
        AppMethodBeat.o(133806);
    }

    public final boolean isRunning() {
        AppMethodBeat.i(133807);
        if (this.ahp.isEmpty() && this.ahr.isEmpty() && this.ahq.isEmpty() && this.aho.isEmpty() && this.ahw.isEmpty() && this.ahx.isEmpty() && this.ahv.isEmpty() && this.ahy.isEmpty() && this.aht.isEmpty() && this.ahs.isEmpty() && this.ahu.isEmpty()) {
            AppMethodBeat.o(133807);
            return false;
        }
        AppMethodBeat.o(133807);
        return true;
    }

    /* Access modifiers changed, original: final */
    public final void hY() {
        AppMethodBeat.i(133808);
        if (!isRunning()) {
            jS();
        }
        AppMethodBeat.o(133808);
    }

    public final void hZ() {
        int size;
        AppMethodBeat.i(133809);
        for (size = this.ahq.size() - 1; size >= 0; size--) {
            b bVar = (b) this.ahq.get(size);
            View view = bVar.ahR.apJ;
            view.setTranslationY(0.0f);
            view.setTranslationX(0.0f);
            C(bVar.ahR);
            this.ahq.remove(size);
        }
        for (size = this.aho.size() - 1; size >= 0; size--) {
            B((v) this.aho.get(size));
            this.aho.remove(size);
        }
        for (size = this.ahp.size() - 1; size >= 0; size--) {
            v vVar = (v) this.ahp.get(size);
            vVar.apJ.setAlpha(1.0f);
            m(vVar);
            this.ahp.remove(size);
        }
        for (size = this.ahr.size() - 1; size >= 0; size--) {
            a((a) this.ahr.get(size));
        }
        this.ahr.clear();
        if (isRunning()) {
            int size2;
            ArrayList arrayList;
            int size3;
            for (size2 = this.aht.size() - 1; size2 >= 0; size2--) {
                arrayList = (ArrayList) this.aht.get(size2);
                for (size3 = arrayList.size() - 1; size3 >= 0; size3--) {
                    b bVar2 = (b) arrayList.get(size3);
                    View view2 = bVar2.ahR.apJ;
                    view2.setTranslationY(0.0f);
                    view2.setTranslationX(0.0f);
                    C(bVar2.ahR);
                    arrayList.remove(size3);
                    if (arrayList.isEmpty()) {
                        this.aht.remove(arrayList);
                    }
                }
            }
            for (size2 = this.ahs.size() - 1; size2 >= 0; size2--) {
                arrayList = (ArrayList) this.ahs.get(size2);
                for (size3 = arrayList.size() - 1; size3 >= 0; size3--) {
                    v vVar2 = (v) arrayList.get(size3);
                    vVar2.apJ.setAlpha(1.0f);
                    m(vVar2);
                    arrayList.remove(size3);
                    if (arrayList.isEmpty()) {
                        this.ahs.remove(arrayList);
                    }
                }
            }
            for (size2 = this.ahu.size() - 1; size2 >= 0; size2--) {
                arrayList = (ArrayList) this.ahu.get(size2);
                for (size3 = arrayList.size() - 1; size3 >= 0; size3--) {
                    a((a) arrayList.get(size3));
                    if (arrayList.isEmpty()) {
                        this.ahu.remove(arrayList);
                    }
                }
            }
            o(this.ahx);
            o(this.ahw);
            o(this.ahv);
            o(this.ahy);
            jS();
            AppMethodBeat.o(133809);
            return;
        }
        AppMethodBeat.o(133809);
    }

    private static void o(List<v> list) {
        AppMethodBeat.i(133810);
        for (int size = list.size() - 1; size >= 0; size--) {
            ((v) list.get(size)).apJ.animate().cancel();
        }
        AppMethodBeat.o(133810);
    }

    public final boolean a(v vVar, List<Object> list) {
        AppMethodBeat.i(133811);
        if (!list.isEmpty() || super.a(vVar, list)) {
            AppMethodBeat.o(133811);
            return true;
        }
        AppMethodBeat.o(133811);
        return false;
    }
}
