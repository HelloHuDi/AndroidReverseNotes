package com.tencent.p177mm.plugin.appbrand.widget.desktop;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.support.p057v4.view.C0477s;
import android.support.p069v7.widget.C17495av;
import android.support.p069v7.widget.RecyclerView.C41523a;
import android.support.p069v7.widget.RecyclerView.C41531v;
import android.view.View;
import android.view.ViewPropertyAnimator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.appbrand.widget.desktop.f */
public final class C42710f extends C17495av {
    private static TimeInterpolator ahn;
    /* renamed from: Yq */
    C41523a f17188Yq = null;
    private ArrayList<C41531v> aho = new ArrayList();
    private ArrayList<C41531v> ahp = new ArrayList();
    private ArrayList<C27379b> ahq = new ArrayList();
    private ArrayList<C10976a> ahr = new ArrayList();
    ArrayList<ArrayList<C41531v>> ahs = new ArrayList();
    ArrayList<ArrayList<C27379b>> aht = new ArrayList();
    ArrayList<ArrayList<C10976a>> ahu = new ArrayList();
    ArrayList<C41531v> ahv = new ArrayList();
    ArrayList<C41531v> ahw = new ArrayList();
    ArrayList<C41531v> ahx = new ArrayList();
    ArrayList<C41531v> ahy = new ArrayList();
    private boolean iYB = false;

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.desktop.f$5 */
    class C109745 extends AnimatorListenerAdapter {
        final /* synthetic */ C41531v ahD;
        final /* synthetic */ ViewPropertyAnimator ahE;
        final /* synthetic */ View val$view;

        C109745(C41531v c41531v, View view, ViewPropertyAnimator viewPropertyAnimator) {
            this.ahD = c41531v;
            this.val$view = view;
            this.ahE = viewPropertyAnimator;
        }

        public final void onAnimationStart(Animator animator) {
        }

        public final void onAnimationCancel(Animator animator) {
            AppMethodBeat.m2504i(133907);
            this.val$view.setScaleX(1.0f);
            this.val$view.setScaleY(1.0f);
            AppMethodBeat.m2505o(133907);
        }

        public final void onAnimationEnd(Animator animator) {
            AppMethodBeat.m2504i(133908);
            this.ahE.setListener(null);
            C42710f.this.mo51947m(this.ahD);
            C42710f.this.ahv.remove(this.ahD);
            C42710f.this.mo68128hY();
            AppMethodBeat.m2505o(133908);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.desktop.f$6 */
    class C109756 extends AnimatorListenerAdapter {
        final /* synthetic */ C41531v ahD;
        final /* synthetic */ ViewPropertyAnimator ahE;
        final /* synthetic */ int ahF;
        final /* synthetic */ int ahG;
        final /* synthetic */ View val$view;

        C109756(C41531v c41531v, int i, View view, int i2, ViewPropertyAnimator viewPropertyAnimator) {
            this.ahD = c41531v;
            this.ahF = i;
            this.val$view = view;
            this.ahG = i2;
            this.ahE = viewPropertyAnimator;
        }

        public final void onAnimationStart(Animator animator) {
            AppMethodBeat.m2504i(133909);
            C42710f.this.mo31915F(this.ahD);
            AppMethodBeat.m2505o(133909);
        }

        public final void onAnimationCancel(Animator animator) {
            AppMethodBeat.m2504i(133910);
            if (this.ahF != 0) {
                this.val$view.setTranslationX(0.0f);
            }
            if (this.ahG != 0) {
                this.val$view.setTranslationY(0.0f);
            }
            AppMethodBeat.m2505o(133910);
        }

        public final void onAnimationEnd(Animator animator) {
            AppMethodBeat.m2504i(133911);
            this.ahE.setListener(null);
            C42710f.this.mo31913C(this.ahD);
            C42710f.this.ahw.remove(this.ahD);
            C42710f.this.mo68128hY();
            AppMethodBeat.m2505o(133911);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.desktop.f$a */
    static class C10976a {
        public C41531v ahL;
        public C41531v ahM;
        public int ahN;
        public int ahO;
        public int ahP;
        public int ahQ;
        public boolean iYE;

        private C10976a(C41531v c41531v, C41531v c41531v2) {
            this.iYE = false;
            this.ahL = c41531v;
            this.ahM = c41531v2;
        }

        C10976a(C41531v c41531v, C41531v c41531v2, int i, int i2, int i3, int i4) {
            this(c41531v, c41531v2);
            this.ahN = i;
            this.ahO = i2;
            this.ahP = i3;
            this.ahQ = i4;
        }

        public final String toString() {
            AppMethodBeat.m2504i(133914);
            String str = "ChangeInfo{oldHolder=" + this.ahL + ", newHolder=" + this.ahM + ", fromX=" + this.ahN + ", fromY=" + this.ahO + ", toX=" + this.ahP + ", toY=" + this.ahQ + '}';
            AppMethodBeat.m2505o(133914);
            return str;
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.desktop.f$8 */
    class C198448 extends AnimatorListenerAdapter {
        final /* synthetic */ ViewPropertyAnimator ahJ;
        final /* synthetic */ View ahK;
        final /* synthetic */ C10976a iYD;

        C198448(C10976a c10976a, ViewPropertyAnimator viewPropertyAnimator, View view) {
            this.iYD = c10976a;
            this.ahJ = viewPropertyAnimator;
            this.ahK = view;
        }

        public final void onAnimationStart(Animator animator) {
        }

        public final void onAnimationEnd(Animator animator) {
            AppMethodBeat.m2504i(133913);
            this.ahJ.setListener(null);
            this.ahK.setAlpha(1.0f);
            this.ahK.setTranslationX(0.0f);
            this.ahK.setTranslationY(0.0f);
            C42710f.this.mo51947m(this.iYD.ahM);
            C42710f.this.ahy.remove(this.iYD.ahM);
            C42710f.this.mo68128hY();
            AppMethodBeat.m2505o(133913);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.desktop.f$7 */
    class C273787 extends AnimatorListenerAdapter {
        final /* synthetic */ ViewPropertyAnimator ahI;
        final /* synthetic */ C10976a iYD;
        final /* synthetic */ View val$view;

        C273787(C10976a c10976a, ViewPropertyAnimator viewPropertyAnimator, View view) {
            this.iYD = c10976a;
            this.ahI = viewPropertyAnimator;
            this.val$view = view;
        }

        public final void onAnimationStart(Animator animator) {
        }

        public final void onAnimationEnd(Animator animator) {
            AppMethodBeat.m2504i(133912);
            this.ahI.setListener(null);
            this.val$view.setAlpha(1.0f);
            this.val$view.setTranslationX(0.0f);
            this.val$view.setTranslationY(0.0f);
            this.val$view.setScaleX(1.0f);
            this.val$view.setScaleY(1.0f);
            C42710f.this.mo51947m(this.iYD.ahL);
            C42710f.this.ahy.remove(this.iYD.ahL);
            C42710f.this.mo68128hY();
            AppMethodBeat.m2505o(133912);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.desktop.f$b */
    static class C27379b {
        public int ahN;
        public int ahO;
        public int ahP;
        public int ahQ;
        public C41531v ahR;

        C27379b(C41531v c41531v, int i, int i2, int i3, int i4) {
            this.ahR = c41531v;
            this.ahN = i;
            this.ahO = i2;
            this.ahP = i3;
            this.ahQ = i4;
        }
    }

    C42710f() {
        AppMethodBeat.m2504i(133915);
        AppMethodBeat.m2505o(133915);
    }

    /* renamed from: hX */
    public final void mo22571hX() {
        int i;
        int i2;
        int i3;
        AppMethodBeat.m2504i(133916);
        int i4 = !this.aho.isEmpty() ? 1 : 0;
        if (this.ahq.isEmpty()) {
            i = 0;
        } else {
            i = 1;
        }
        if (this.ahr.isEmpty()) {
            i2 = 0;
        } else {
            i2 = 1;
        }
        if (this.ahp.isEmpty()) {
            i3 = 0;
        } else {
            i3 = 1;
        }
        if (i4 == 0 && i == 0 && i3 == 0 && i2 == 0) {
            AppMethodBeat.m2505o(133916);
            return;
        }
        final ArrayList arrayList;
        Iterator it = this.aho.iterator();
        while (it.hasNext()) {
            final C41531v c41531v = (C41531v) it.next();
            final View view = c41531v.apJ;
            final ViewPropertyAnimator animate = view.animate();
            this.ahx.add(c41531v);
            animate.setDuration(this.aou).alpha(0.0f).setListener(new AnimatorListenerAdapter() {
                public final void onAnimationStart(Animator animator) {
                    AppMethodBeat.m2504i(133905);
                    C42710f.this.mo31914D(c41531v);
                    AppMethodBeat.m2505o(133905);
                }

                public final void onAnimationEnd(Animator animator) {
                    AppMethodBeat.m2504i(133906);
                    animate.setListener(null);
                    view.setAlpha(1.0f);
                    C42710f.this.mo31912B(c41531v);
                    C42710f.this.ahx.remove(c41531v);
                    C42710f.this.mo68128hY();
                    AppMethodBeat.m2505o(133906);
                }
            }).start();
        }
        this.aho.clear();
        if (i != 0) {
            arrayList = new ArrayList();
            arrayList.addAll(this.ahq);
            this.aht.add(arrayList);
            this.ahq.clear();
            C385861 c385861 = new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(133902);
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        C27379b c27379b = (C27379b) it.next();
                        C42710f c42710f = C42710f.this;
                        C41531v c41531v = c27379b.ahR;
                        int i = c27379b.ahN;
                        int i2 = c27379b.ahO;
                        int i3 = c27379b.ahP;
                        int i4 = c27379b.ahQ;
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
                        c42710f.ahw.add(c41531v);
                        animate.setDuration(c42710f.aov).setListener(new C109756(c41531v, i, view, i2, animate)).start();
                    }
                    arrayList.clear();
                    C42710f.this.aht.remove(arrayList);
                    AppMethodBeat.m2505o(133902);
                }
            };
            if (i4 != 0) {
                C0477s.m908a(((C27379b) arrayList.get(0)).ahR.apJ, c385861, this.aou);
            } else {
                c385861.run();
            }
        }
        if (i2 != 0) {
            arrayList = new ArrayList();
            arrayList.addAll(this.ahr);
            this.ahu.add(arrayList);
            this.ahr.clear();
            C427112 c427112 = new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(133903);
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        View view;
                        C10976a c10976a = (C10976a) it.next();
                        C42710f c42710f = C42710f.this;
                        C41531v c41531v = c10976a.ahL;
                        View view2 = c41531v == null ? null : c41531v.apJ;
                        C41531v c41531v2 = c10976a.ahM;
                        if (c41531v2 != null) {
                            view = c41531v2.apJ;
                        } else {
                            view = null;
                        }
                        if (view2 != null) {
                            ViewPropertyAnimator duration = view2.animate().setDuration(c42710f.aow);
                            c42710f.ahy.add(c10976a.ahL);
                            duration.translationX((float) (c10976a.ahP - c10976a.ahN));
                            duration.translationY((float) (c10976a.ahQ - c10976a.ahO));
                            duration.alpha(0.0f).setListener(new C273787(c10976a, duration, view2)).start();
                        }
                        if (view != null) {
                            ViewPropertyAnimator animate = view.animate();
                            c42710f.ahy.add(c10976a.ahM);
                            animate.translationX(0.0f).translationY(0.0f).setDuration(c42710f.aow).alpha(1.0f).setListener(new C198448(c10976a, animate, view)).start();
                        }
                    }
                    arrayList.clear();
                    C42710f.this.ahu.remove(arrayList);
                    AppMethodBeat.m2505o(133903);
                }
            };
            if (i4 != 0) {
                C0477s.m908a(((C10976a) arrayList.get(0)).ahL.apJ, c427112, this.aou);
            } else {
                c427112.run();
            }
        }
        if (i3 != 0) {
            final ArrayList arrayList2 = new ArrayList();
            arrayList2.addAll(this.ahp);
            this.ahs.add(arrayList2);
            this.ahp.clear();
            C385873 c385873 = new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(133904);
                    Iterator it = arrayList2.iterator();
                    while (it.hasNext()) {
                        C41531v c41531v = (C41531v) it.next();
                        C42710f c42710f = C42710f.this;
                        View view = c41531v.apJ;
                        ViewPropertyAnimator animate = view.animate();
                        c42710f.ahv.add(c41531v);
                        view.setAlpha(1.0f);
                        animate.scaleX(1.0f).scaleY(1.0f).setDuration(c42710f.aot).setListener(new C109745(c41531v, view, animate)).start();
                    }
                    arrayList2.clear();
                    C42710f.this.ahs.remove(arrayList2);
                    AppMethodBeat.m2505o(133904);
                }
            };
            if (i4 == 0 && i == 0 && i2 == 0) {
                c385873.run();
            } else {
                long j;
                long j2;
                long j3;
                if (i4 != 0) {
                    j = this.aou;
                } else {
                    j = 0;
                }
                if (i != 0) {
                    j2 = this.aov;
                } else {
                    j2 = 0;
                }
                if (i2 != 0) {
                    j3 = this.aow;
                } else {
                    j3 = 0;
                }
                C0477s.m908a(((C41531v) arrayList2.get(0)).apJ, c385873, j + Math.max(j2, j3));
                AppMethodBeat.m2505o(133916);
                return;
            }
        }
        AppMethodBeat.m2505o(133916);
    }

    /* renamed from: b */
    public final boolean mo22568b(C41531v c41531v) {
        AppMethodBeat.m2504i(133917);
        C4990ab.m7417i("MicroMsg.RecentAppBrandItemAnimator", "alvinluo animateRemove %d", Integer.valueOf(c41531v.mo66454kj()));
        m75671e(c41531v);
        this.aho.add(c41531v);
        AppMethodBeat.m2505o(133917);
        return true;
    }

    /* renamed from: c */
    public final boolean mo22569c(C41531v c41531v) {
        AppMethodBeat.m2504i(133918);
        m75671e(c41531v);
        c41531v.apJ.setAlpha(0.0f);
        c41531v.apJ.setScaleX(0.75f);
        c41531v.apJ.setScaleY(0.75f);
        this.ahp.add(c41531v);
        AppMethodBeat.m2505o(133918);
        return true;
    }

    /* renamed from: a */
    public final boolean mo22565a(C41531v c41531v, int i, int i2, int i3, int i4) {
        AppMethodBeat.m2504i(133919);
        View view = c41531v.apJ;
        int translationX = i + ((int) c41531v.apJ.getTranslationX());
        int translationY = i2 + ((int) c41531v.apJ.getTranslationY());
        m75671e(c41531v);
        int i5 = i3 - translationX;
        int i6 = i4 - translationY;
        if (i5 == 0 && i6 == 0) {
            mo31913C(c41531v);
            AppMethodBeat.m2505o(133919);
            return false;
        }
        if (i5 != 0) {
            view.setTranslationX((float) (-i5));
        }
        if (i6 != 0) {
            view.setTranslationY((float) (-i6));
        }
        this.ahq.add(new C27379b(c41531v, translationX, translationY, i3, i4));
        AppMethodBeat.m2505o(133919);
        return true;
    }

    /* renamed from: a */
    public final boolean mo22566a(C41531v c41531v, C41531v c41531v2, int i, int i2, int i3, int i4) {
        AppMethodBeat.m2504i(133920);
        C4990ab.m7417i("MicroMsg.RecentAppBrandItemAnimator", "alvinluo animateChange lastPos: %d", Integer.valueOf(c41531v.mo66454kj()));
        if (c41531v == c41531v2) {
            boolean a = mo22565a(c41531v, i, i2, i3, i4);
            AppMethodBeat.m2505o(133920);
            return a;
        }
        float translationX = c41531v.apJ.getTranslationX();
        float translationY = c41531v.apJ.getTranslationY();
        float alpha = c41531v.apJ.getAlpha();
        m75671e(c41531v);
        int i5 = (int) (((float) (i3 - i)) - translationX);
        int i6 = (int) (((float) (i4 - i2)) - translationY);
        c41531v.apJ.setTranslationX(translationX);
        c41531v.apJ.setTranslationY(translationY);
        c41531v.apJ.setAlpha(alpha);
        if (c41531v2 != null) {
            m75671e(c41531v2);
            c41531v2.apJ.setTranslationX((float) (-i5));
            c41531v2.apJ.setTranslationY((float) (-i6));
            c41531v2.apJ.setAlpha(0.0f);
        }
        this.ahr.add(new C10976a(c41531v, c41531v2, i, i2, i3, i4));
        AppMethodBeat.m2505o(133920);
        return true;
    }

    /* renamed from: a */
    private void m75669a(List<C10976a> list, C41531v c41531v) {
        AppMethodBeat.m2504i(133921);
        for (int size = list.size() - 1; size >= 0; size--) {
            C10976a c10976a = (C10976a) list.get(size);
            if (m75670a(c10976a, c41531v) && c10976a.ahL == null && c10976a.ahM == null) {
                list.remove(c10976a);
            }
        }
        AppMethodBeat.m2505o(133921);
    }

    /* renamed from: a */
    private void m75668a(C10976a c10976a) {
        AppMethodBeat.m2504i(133922);
        if (c10976a.ahL != null) {
            m75670a(c10976a, c10976a.ahL);
        }
        if (c10976a.ahM != null) {
            m75670a(c10976a, c10976a.ahM);
        }
        AppMethodBeat.m2505o(133922);
    }

    /* renamed from: a */
    private boolean m75670a(C10976a c10976a, C41531v c41531v) {
        AppMethodBeat.m2504i(133923);
        if (c10976a.ahM == c41531v) {
            c10976a.ahM = null;
        } else if (c10976a.ahL == c41531v) {
            c10976a.ahL = null;
        } else {
            AppMethodBeat.m2505o(133923);
            return false;
        }
        c41531v.apJ.setAlpha(1.0f);
        c41531v.apJ.setTranslationX(0.0f);
        c41531v.apJ.setTranslationY(0.0f);
        mo51947m(c41531v);
        AppMethodBeat.m2505o(133923);
        return true;
    }

    /* renamed from: d */
    public final void mo22570d(C41531v c41531v) {
        int size;
        ArrayList arrayList;
        AppMethodBeat.m2504i(133924);
        View view = c41531v.apJ;
        view.animate().cancel();
        for (size = this.ahq.size() - 1; size >= 0; size--) {
            if (((C27379b) this.ahq.get(size)).ahR == c41531v) {
                view.setTranslationY(0.0f);
                view.setTranslationX(0.0f);
                mo31913C(c41531v);
                this.ahq.remove(size);
            }
        }
        m75669a(this.ahr, c41531v);
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
            m75669a(list, c41531v);
            if (list.isEmpty()) {
                this.ahu.remove(size);
            }
        }
        for (int size2 = this.aht.size() - 1; size2 >= 0; size2--) {
            arrayList = (ArrayList) this.aht.get(size2);
            int size3 = arrayList.size() - 1;
            while (size3 >= 0) {
                if (((C27379b) arrayList.get(size3)).ahR == c41531v) {
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
        mo68128hY();
        AppMethodBeat.m2505o(133924);
    }

    /* renamed from: e */
    private void m75671e(C41531v c41531v) {
        AppMethodBeat.m2504i(133925);
        if (ahn == null) {
            ahn = new ValueAnimator().getInterpolator();
        }
        c41531v.apJ.animate().setInterpolator(ahn);
        mo22570d(c41531v);
        AppMethodBeat.m2505o(133925);
    }

    public final boolean isRunning() {
        AppMethodBeat.m2504i(133926);
        if (this.ahp.isEmpty() && this.ahr.isEmpty() && this.ahq.isEmpty() && this.aho.isEmpty() && this.ahw.isEmpty() && this.ahx.isEmpty() && this.ahv.isEmpty() && this.ahy.isEmpty() && this.aht.isEmpty() && this.ahs.isEmpty() && this.ahu.isEmpty()) {
            AppMethodBeat.m2505o(133926);
            return false;
        }
        AppMethodBeat.m2505o(133926);
        return true;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: hY */
    public final void mo68128hY() {
        AppMethodBeat.m2504i(133927);
        if (!isRunning()) {
            mo51946jS();
        }
        AppMethodBeat.m2505o(133927);
    }

    /* renamed from: hZ */
    public final void mo22573hZ() {
        int size;
        AppMethodBeat.m2504i(133928);
        for (size = this.ahq.size() - 1; size >= 0; size--) {
            C27379b c27379b = (C27379b) this.ahq.get(size);
            View view = c27379b.ahR.apJ;
            view.setTranslationY(0.0f);
            view.setTranslationX(0.0f);
            mo31913C(c27379b.ahR);
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
            m75668a((C10976a) this.ahr.get(size));
        }
        this.ahr.clear();
        if (isRunning()) {
            int size2;
            ArrayList arrayList;
            int size3;
            for (size2 = this.aht.size() - 1; size2 >= 0; size2--) {
                arrayList = (ArrayList) this.aht.get(size2);
                for (size3 = arrayList.size() - 1; size3 >= 0; size3--) {
                    C27379b c27379b2 = (C27379b) arrayList.get(size3);
                    View view2 = c27379b2.ahR.apJ;
                    view2.setTranslationY(0.0f);
                    view2.setTranslationX(0.0f);
                    mo31913C(c27379b2.ahR);
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
                    m75668a((C10976a) arrayList.get(size3));
                    if (arrayList.isEmpty()) {
                        this.ahu.remove(arrayList);
                    }
                }
            }
            C42710f.m75672o(this.ahx);
            C42710f.m75672o(this.ahw);
            C42710f.m75672o(this.ahv);
            C42710f.m75672o(this.ahy);
            mo51946jS();
            AppMethodBeat.m2505o(133928);
            return;
        }
        AppMethodBeat.m2505o(133928);
    }

    /* renamed from: o */
    private static void m75672o(List<C41531v> list) {
        AppMethodBeat.m2504i(133929);
        for (int size = list.size() - 1; size >= 0; size--) {
            ((C41531v) list.get(size)).apJ.animate().cancel();
        }
        AppMethodBeat.m2505o(133929);
    }

    /* renamed from: a */
    public final boolean mo22567a(C41531v c41531v, List<Object> list) {
        AppMethodBeat.m2504i(133930);
        if (!list.isEmpty() || super.mo22567a(c41531v, list)) {
            AppMethodBeat.m2505o(133930);
            return true;
        }
        AppMethodBeat.m2505o(133930);
        return false;
    }
}
