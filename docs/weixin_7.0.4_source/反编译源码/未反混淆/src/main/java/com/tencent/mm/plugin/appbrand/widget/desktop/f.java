package com.tencent.mm.plugin.appbrand.widget.desktop;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.support.v4.view.s;
import android.support.v7.widget.RecyclerView.v;
import android.support.v7.widget.av;
import android.view.View;
import android.view.ViewPropertyAnimator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class f extends av {
    private static TimeInterpolator ahn;
    android.support.v7.widget.RecyclerView.a Yq = null;
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
    private boolean iYB = false;

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.desktop.f$5 */
    class AnonymousClass5 extends AnimatorListenerAdapter {
        final /* synthetic */ v ahD;
        final /* synthetic */ ViewPropertyAnimator ahE;
        final /* synthetic */ View val$view;

        AnonymousClass5(v vVar, View view, ViewPropertyAnimator viewPropertyAnimator) {
            this.ahD = vVar;
            this.val$view = view;
            this.ahE = viewPropertyAnimator;
        }

        public final void onAnimationStart(Animator animator) {
        }

        public final void onAnimationCancel(Animator animator) {
            AppMethodBeat.i(133907);
            this.val$view.setScaleX(1.0f);
            this.val$view.setScaleY(1.0f);
            AppMethodBeat.o(133907);
        }

        public final void onAnimationEnd(Animator animator) {
            AppMethodBeat.i(133908);
            this.ahE.setListener(null);
            f.this.m(this.ahD);
            f.this.ahv.remove(this.ahD);
            f.this.hY();
            AppMethodBeat.o(133908);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.desktop.f$6 */
    class AnonymousClass6 extends AnimatorListenerAdapter {
        final /* synthetic */ v ahD;
        final /* synthetic */ ViewPropertyAnimator ahE;
        final /* synthetic */ int ahF;
        final /* synthetic */ int ahG;
        final /* synthetic */ View val$view;

        AnonymousClass6(v vVar, int i, View view, int i2, ViewPropertyAnimator viewPropertyAnimator) {
            this.ahD = vVar;
            this.ahF = i;
            this.val$view = view;
            this.ahG = i2;
            this.ahE = viewPropertyAnimator;
        }

        public final void onAnimationStart(Animator animator) {
            AppMethodBeat.i(133909);
            f.this.F(this.ahD);
            AppMethodBeat.o(133909);
        }

        public final void onAnimationCancel(Animator animator) {
            AppMethodBeat.i(133910);
            if (this.ahF != 0) {
                this.val$view.setTranslationX(0.0f);
            }
            if (this.ahG != 0) {
                this.val$view.setTranslationY(0.0f);
            }
            AppMethodBeat.o(133910);
        }

        public final void onAnimationEnd(Animator animator) {
            AppMethodBeat.i(133911);
            this.ahE.setListener(null);
            f.this.C(this.ahD);
            f.this.ahw.remove(this.ahD);
            f.this.hY();
            AppMethodBeat.o(133911);
        }
    }

    static class a {
        public v ahL;
        public v ahM;
        public int ahN;
        public int ahO;
        public int ahP;
        public int ahQ;
        public boolean iYE;

        private a(v vVar, v vVar2) {
            this.iYE = false;
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
            AppMethodBeat.i(133914);
            String str = "ChangeInfo{oldHolder=" + this.ahL + ", newHolder=" + this.ahM + ", fromX=" + this.ahN + ", fromY=" + this.ahO + ", toX=" + this.ahP + ", toY=" + this.ahQ + '}';
            AppMethodBeat.o(133914);
            return str;
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.desktop.f$8 */
    class AnonymousClass8 extends AnimatorListenerAdapter {
        final /* synthetic */ ViewPropertyAnimator ahJ;
        final /* synthetic */ View ahK;
        final /* synthetic */ a iYD;

        AnonymousClass8(a aVar, ViewPropertyAnimator viewPropertyAnimator, View view) {
            this.iYD = aVar;
            this.ahJ = viewPropertyAnimator;
            this.ahK = view;
        }

        public final void onAnimationStart(Animator animator) {
        }

        public final void onAnimationEnd(Animator animator) {
            AppMethodBeat.i(133913);
            this.ahJ.setListener(null);
            this.ahK.setAlpha(1.0f);
            this.ahK.setTranslationX(0.0f);
            this.ahK.setTranslationY(0.0f);
            f.this.m(this.iYD.ahM);
            f.this.ahy.remove(this.iYD.ahM);
            f.this.hY();
            AppMethodBeat.o(133913);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.desktop.f$7 */
    class AnonymousClass7 extends AnimatorListenerAdapter {
        final /* synthetic */ ViewPropertyAnimator ahI;
        final /* synthetic */ a iYD;
        final /* synthetic */ View val$view;

        AnonymousClass7(a aVar, ViewPropertyAnimator viewPropertyAnimator, View view) {
            this.iYD = aVar;
            this.ahI = viewPropertyAnimator;
            this.val$view = view;
        }

        public final void onAnimationStart(Animator animator) {
        }

        public final void onAnimationEnd(Animator animator) {
            AppMethodBeat.i(133912);
            this.ahI.setListener(null);
            this.val$view.setAlpha(1.0f);
            this.val$view.setTranslationX(0.0f);
            this.val$view.setTranslationY(0.0f);
            this.val$view.setScaleX(1.0f);
            this.val$view.setScaleY(1.0f);
            f.this.m(this.iYD.ahL);
            f.this.ahy.remove(this.iYD.ahL);
            f.this.hY();
            AppMethodBeat.o(133912);
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

    f() {
        AppMethodBeat.i(133915);
        AppMethodBeat.o(133915);
    }

    public final void hX() {
        int i;
        int i2;
        int i3;
        AppMethodBeat.i(133916);
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
            AppMethodBeat.o(133916);
            return;
        }
        final ArrayList arrayList;
        Iterator it = this.aho.iterator();
        while (it.hasNext()) {
            final v vVar = (v) it.next();
            final View view = vVar.apJ;
            final ViewPropertyAnimator animate = view.animate();
            this.ahx.add(vVar);
            animate.setDuration(this.aou).alpha(0.0f).setListener(new AnimatorListenerAdapter() {
                public final void onAnimationStart(Animator animator) {
                    AppMethodBeat.i(133905);
                    f.this.D(vVar);
                    AppMethodBeat.o(133905);
                }

                public final void onAnimationEnd(Animator animator) {
                    AppMethodBeat.i(133906);
                    animate.setListener(null);
                    view.setAlpha(1.0f);
                    f.this.B(vVar);
                    f.this.ahx.remove(vVar);
                    f.this.hY();
                    AppMethodBeat.o(133906);
                }
            }).start();
        }
        this.aho.clear();
        if (i != 0) {
            arrayList = new ArrayList();
            arrayList.addAll(this.ahq);
            this.aht.add(arrayList);
            this.ahq.clear();
            AnonymousClass1 anonymousClass1 = new Runnable() {
                public final void run() {
                    AppMethodBeat.i(133902);
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        b bVar = (b) it.next();
                        f fVar = f.this;
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
                        fVar.ahw.add(vVar);
                        animate.setDuration(fVar.aov).setListener(new AnonymousClass6(vVar, i, view, i2, animate)).start();
                    }
                    arrayList.clear();
                    f.this.aht.remove(arrayList);
                    AppMethodBeat.o(133902);
                }
            };
            if (i4 != 0) {
                s.a(((b) arrayList.get(0)).ahR.apJ, anonymousClass1, this.aou);
            } else {
                anonymousClass1.run();
            }
        }
        if (i2 != 0) {
            arrayList = new ArrayList();
            arrayList.addAll(this.ahr);
            this.ahu.add(arrayList);
            this.ahr.clear();
            AnonymousClass2 anonymousClass2 = new Runnable() {
                public final void run() {
                    AppMethodBeat.i(133903);
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        View view;
                        a aVar = (a) it.next();
                        f fVar = f.this;
                        v vVar = aVar.ahL;
                        View view2 = vVar == null ? null : vVar.apJ;
                        v vVar2 = aVar.ahM;
                        if (vVar2 != null) {
                            view = vVar2.apJ;
                        } else {
                            view = null;
                        }
                        if (view2 != null) {
                            ViewPropertyAnimator duration = view2.animate().setDuration(fVar.aow);
                            fVar.ahy.add(aVar.ahL);
                            duration.translationX((float) (aVar.ahP - aVar.ahN));
                            duration.translationY((float) (aVar.ahQ - aVar.ahO));
                            duration.alpha(0.0f).setListener(new AnonymousClass7(aVar, duration, view2)).start();
                        }
                        if (view != null) {
                            ViewPropertyAnimator animate = view.animate();
                            fVar.ahy.add(aVar.ahM);
                            animate.translationX(0.0f).translationY(0.0f).setDuration(fVar.aow).alpha(1.0f).setListener(new AnonymousClass8(aVar, animate, view)).start();
                        }
                    }
                    arrayList.clear();
                    f.this.ahu.remove(arrayList);
                    AppMethodBeat.o(133903);
                }
            };
            if (i4 != 0) {
                s.a(((a) arrayList.get(0)).ahL.apJ, anonymousClass2, this.aou);
            } else {
                anonymousClass2.run();
            }
        }
        if (i3 != 0) {
            final ArrayList arrayList2 = new ArrayList();
            arrayList2.addAll(this.ahp);
            this.ahs.add(arrayList2);
            this.ahp.clear();
            AnonymousClass3 anonymousClass3 = new Runnable() {
                public final void run() {
                    AppMethodBeat.i(133904);
                    Iterator it = arrayList2.iterator();
                    while (it.hasNext()) {
                        v vVar = (v) it.next();
                        f fVar = f.this;
                        View view = vVar.apJ;
                        ViewPropertyAnimator animate = view.animate();
                        fVar.ahv.add(vVar);
                        view.setAlpha(1.0f);
                        animate.scaleX(1.0f).scaleY(1.0f).setDuration(fVar.aot).setListener(new AnonymousClass5(vVar, view, animate)).start();
                    }
                    arrayList2.clear();
                    f.this.ahs.remove(arrayList2);
                    AppMethodBeat.o(133904);
                }
            };
            if (i4 == 0 && i == 0 && i2 == 0) {
                anonymousClass3.run();
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
                s.a(((v) arrayList2.get(0)).apJ, anonymousClass3, j + Math.max(j2, j3));
                AppMethodBeat.o(133916);
                return;
            }
        }
        AppMethodBeat.o(133916);
    }

    public final boolean b(v vVar) {
        AppMethodBeat.i(133917);
        ab.i("MicroMsg.RecentAppBrandItemAnimator", "alvinluo animateRemove %d", Integer.valueOf(vVar.kj()));
        e(vVar);
        this.aho.add(vVar);
        AppMethodBeat.o(133917);
        return true;
    }

    public final boolean c(v vVar) {
        AppMethodBeat.i(133918);
        e(vVar);
        vVar.apJ.setAlpha(0.0f);
        vVar.apJ.setScaleX(0.75f);
        vVar.apJ.setScaleY(0.75f);
        this.ahp.add(vVar);
        AppMethodBeat.o(133918);
        return true;
    }

    public final boolean a(v vVar, int i, int i2, int i3, int i4) {
        AppMethodBeat.i(133919);
        View view = vVar.apJ;
        int translationX = i + ((int) vVar.apJ.getTranslationX());
        int translationY = i2 + ((int) vVar.apJ.getTranslationY());
        e(vVar);
        int i5 = i3 - translationX;
        int i6 = i4 - translationY;
        if (i5 == 0 && i6 == 0) {
            C(vVar);
            AppMethodBeat.o(133919);
            return false;
        }
        if (i5 != 0) {
            view.setTranslationX((float) (-i5));
        }
        if (i6 != 0) {
            view.setTranslationY((float) (-i6));
        }
        this.ahq.add(new b(vVar, translationX, translationY, i3, i4));
        AppMethodBeat.o(133919);
        return true;
    }

    public final boolean a(v vVar, v vVar2, int i, int i2, int i3, int i4) {
        AppMethodBeat.i(133920);
        ab.i("MicroMsg.RecentAppBrandItemAnimator", "alvinluo animateChange lastPos: %d", Integer.valueOf(vVar.kj()));
        if (vVar == vVar2) {
            boolean a = a(vVar, i, i2, i3, i4);
            AppMethodBeat.o(133920);
            return a;
        }
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
        AppMethodBeat.o(133920);
        return true;
    }

    private void a(List<a> list, v vVar) {
        AppMethodBeat.i(133921);
        for (int size = list.size() - 1; size >= 0; size--) {
            a aVar = (a) list.get(size);
            if (a(aVar, vVar) && aVar.ahL == null && aVar.ahM == null) {
                list.remove(aVar);
            }
        }
        AppMethodBeat.o(133921);
    }

    private void a(a aVar) {
        AppMethodBeat.i(133922);
        if (aVar.ahL != null) {
            a(aVar, aVar.ahL);
        }
        if (aVar.ahM != null) {
            a(aVar, aVar.ahM);
        }
        AppMethodBeat.o(133922);
    }

    private boolean a(a aVar, v vVar) {
        AppMethodBeat.i(133923);
        if (aVar.ahM == vVar) {
            aVar.ahM = null;
        } else if (aVar.ahL == vVar) {
            aVar.ahL = null;
        } else {
            AppMethodBeat.o(133923);
            return false;
        }
        vVar.apJ.setAlpha(1.0f);
        vVar.apJ.setTranslationX(0.0f);
        vVar.apJ.setTranslationY(0.0f);
        m(vVar);
        AppMethodBeat.o(133923);
        return true;
    }

    public final void d(v vVar) {
        int size;
        ArrayList arrayList;
        AppMethodBeat.i(133924);
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
        AppMethodBeat.o(133924);
    }

    private void e(v vVar) {
        AppMethodBeat.i(133925);
        if (ahn == null) {
            ahn = new ValueAnimator().getInterpolator();
        }
        vVar.apJ.animate().setInterpolator(ahn);
        d(vVar);
        AppMethodBeat.o(133925);
    }

    public final boolean isRunning() {
        AppMethodBeat.i(133926);
        if (this.ahp.isEmpty() && this.ahr.isEmpty() && this.ahq.isEmpty() && this.aho.isEmpty() && this.ahw.isEmpty() && this.ahx.isEmpty() && this.ahv.isEmpty() && this.ahy.isEmpty() && this.aht.isEmpty() && this.ahs.isEmpty() && this.ahu.isEmpty()) {
            AppMethodBeat.o(133926);
            return false;
        }
        AppMethodBeat.o(133926);
        return true;
    }

    /* Access modifiers changed, original: final */
    public final void hY() {
        AppMethodBeat.i(133927);
        if (!isRunning()) {
            jS();
        }
        AppMethodBeat.o(133927);
    }

    public final void hZ() {
        int size;
        AppMethodBeat.i(133928);
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
            AppMethodBeat.o(133928);
            return;
        }
        AppMethodBeat.o(133928);
    }

    private static void o(List<v> list) {
        AppMethodBeat.i(133929);
        for (int size = list.size() - 1; size >= 0; size--) {
            ((v) list.get(size)).apJ.animate().cancel();
        }
        AppMethodBeat.o(133929);
    }

    public final boolean a(v vVar, List<Object> list) {
        AppMethodBeat.i(133930);
        if (!list.isEmpty() || super.a(vVar, list)) {
            AppMethodBeat.o(133930);
            return true;
        }
        AppMethodBeat.o(133930);
        return false;
    }
}
