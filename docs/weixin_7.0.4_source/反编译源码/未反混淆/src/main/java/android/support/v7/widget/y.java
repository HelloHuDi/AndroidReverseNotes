package android.support.v7.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.support.v4.view.s;
import android.support.v7.widget.RecyclerView.v;
import android.view.View;
import android.view.ViewPropertyAnimator;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class y extends av {
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

    /* renamed from: android.support.v7.widget.y$7 */
    class AnonymousClass7 extends AnimatorListenerAdapter {
        final /* synthetic */ a ahH;
        final /* synthetic */ ViewPropertyAnimator ahI;
        final /* synthetic */ View val$view;

        AnonymousClass7(a aVar, ViewPropertyAnimator viewPropertyAnimator, View view) {
            this.ahH = aVar;
            this.ahI = viewPropertyAnimator;
            this.val$view = view;
        }

        public final void onAnimationStart(Animator animator) {
        }

        public final void onAnimationEnd(Animator animator) {
            this.ahI.setListener(null);
            this.val$view.setAlpha(1.0f);
            this.val$view.setTranslationX(0.0f);
            this.val$view.setTranslationY(0.0f);
            y.this.m(this.ahH.ahL);
            y.this.ahy.remove(this.ahH.ahL);
            y.this.hY();
        }
    }

    /* renamed from: android.support.v7.widget.y$8 */
    class AnonymousClass8 extends AnimatorListenerAdapter {
        final /* synthetic */ a ahH;
        final /* synthetic */ ViewPropertyAnimator ahJ;
        final /* synthetic */ View ahK;

        AnonymousClass8(a aVar, ViewPropertyAnimator viewPropertyAnimator, View view) {
            this.ahH = aVar;
            this.ahJ = viewPropertyAnimator;
            this.ahK = view;
        }

        public final void onAnimationStart(Animator animator) {
        }

        public final void onAnimationEnd(Animator animator) {
            this.ahJ.setListener(null);
            this.ahK.setAlpha(1.0f);
            this.ahK.setTranslationX(0.0f);
            this.ahK.setTranslationY(0.0f);
            y.this.m(this.ahH.ahM);
            y.this.ahy.remove(this.ahH.ahM);
            y.this.hY();
        }
    }

    /* renamed from: android.support.v7.widget.y$6 */
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
            y.this.F(this.ahD);
        }

        public final void onAnimationCancel(Animator animator) {
            if (this.ahF != 0) {
                this.val$view.setTranslationX(0.0f);
            }
            if (this.ahG != 0) {
                this.val$view.setTranslationY(0.0f);
            }
        }

        public final void onAnimationEnd(Animator animator) {
            this.ahE.setListener(null);
            y.this.C(this.ahD);
            y.this.ahw.remove(this.ahD);
            y.this.hY();
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
            return "ChangeInfo{oldHolder=" + this.ahL + ", newHolder=" + this.ahM + ", fromX=" + this.ahN + ", fromY=" + this.ahO + ", toX=" + this.ahP + ", toY=" + this.ahQ + '}';
        }
    }

    /* renamed from: android.support.v7.widget.y$5 */
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
            this.val$view.setAlpha(1.0f);
        }

        public final void onAnimationEnd(Animator animator) {
            this.ahE.setListener(null);
            y.this.m(this.ahD);
            y.this.ahv.remove(this.ahD);
            y.this.hY();
        }
    }

    public void hX() {
        int i;
        int i2;
        int i3;
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
        if (i4 != 0 || i != 0 || i3 != 0 || i2 != 0) {
            final ArrayList arrayList;
            Iterator it = this.aho.iterator();
            while (it.hasNext()) {
                final v vVar = (v) it.next();
                final View view = vVar.apJ;
                final ViewPropertyAnimator animate = view.animate();
                this.ahx.add(vVar);
                animate.setDuration(this.aou).alpha(0.0f).setListener(new AnimatorListenerAdapter() {
                    public final void onAnimationStart(Animator animator) {
                        y.this.D(vVar);
                    }

                    public final void onAnimationEnd(Animator animator) {
                        animate.setListener(null);
                        view.setAlpha(1.0f);
                        y.this.B(vVar);
                        y.this.ahx.remove(vVar);
                        y.this.hY();
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
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            b bVar = (b) it.next();
                            y yVar = y.this;
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
                            yVar.ahw.add(vVar);
                            animate.setDuration(yVar.aov).setListener(new AnonymousClass6(vVar, i, view, i2, animate)).start();
                        }
                        arrayList.clear();
                        y.this.aht.remove(arrayList);
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
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            View view;
                            a aVar = (a) it.next();
                            y yVar = y.this;
                            v vVar = aVar.ahL;
                            View view2 = vVar == null ? null : vVar.apJ;
                            v vVar2 = aVar.ahM;
                            if (vVar2 != null) {
                                view = vVar2.apJ;
                            } else {
                                view = null;
                            }
                            if (view2 != null) {
                                ViewPropertyAnimator duration = view2.animate().setDuration(yVar.aow);
                                yVar.ahy.add(aVar.ahL);
                                duration.translationX((float) (aVar.ahP - aVar.ahN));
                                duration.translationY((float) (aVar.ahQ - aVar.ahO));
                                duration.alpha(0.0f).setListener(new AnonymousClass7(aVar, duration, view2)).start();
                            }
                            if (view != null) {
                                ViewPropertyAnimator animate = view.animate();
                                yVar.ahy.add(aVar.ahM);
                                animate.translationX(0.0f).translationY(0.0f).setDuration(yVar.aow).alpha(1.0f).setListener(new AnonymousClass8(aVar, animate, view)).start();
                            }
                        }
                        arrayList.clear();
                        y.this.ahu.remove(arrayList);
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
                        Iterator it = arrayList2.iterator();
                        while (it.hasNext()) {
                            v vVar = (v) it.next();
                            y yVar = y.this;
                            View view = vVar.apJ;
                            ViewPropertyAnimator animate = view.animate();
                            yVar.ahv.add(vVar);
                            animate.alpha(1.0f).setDuration(yVar.aot).setListener(new AnonymousClass5(vVar, view, animate)).start();
                        }
                        arrayList2.clear();
                        y.this.ahs.remove(arrayList2);
                    }
                };
                if (i4 == 0 && i == 0 && i2 == 0) {
                    anonymousClass3.run();
                    return;
                }
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
            }
        }
    }

    public boolean b(v vVar) {
        e(vVar);
        this.aho.add(vVar);
        return true;
    }

    public boolean c(v vVar) {
        e(vVar);
        vVar.apJ.setAlpha(0.0f);
        this.ahp.add(vVar);
        return true;
    }

    public boolean a(v vVar, int i, int i2, int i3, int i4) {
        View view = vVar.apJ;
        int translationX = i + ((int) vVar.apJ.getTranslationX());
        int translationY = i2 + ((int) vVar.apJ.getTranslationY());
        e(vVar);
        int i5 = i3 - translationX;
        int i6 = i4 - translationY;
        if (i5 == 0 && i6 == 0) {
            C(vVar);
            return false;
        }
        if (i5 != 0) {
            view.setTranslationX((float) (-i5));
        }
        if (i6 != 0) {
            view.setTranslationY((float) (-i6));
        }
        this.ahq.add(new b(vVar, translationX, translationY, i3, i4));
        return true;
    }

    public boolean a(v vVar, v vVar2, int i, int i2, int i3, int i4) {
        if (vVar == vVar2) {
            return a(vVar, i, i2, i3, i4);
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
        return true;
    }

    private void a(List<a> list, v vVar) {
        for (int size = list.size() - 1; size >= 0; size--) {
            a aVar = (a) list.get(size);
            if (a(aVar, vVar) && aVar.ahL == null && aVar.ahM == null) {
                list.remove(aVar);
            }
        }
    }

    private void a(a aVar) {
        if (aVar.ahL != null) {
            a(aVar, aVar.ahL);
        }
        if (aVar.ahM != null) {
            a(aVar, aVar.ahM);
        }
    }

    private boolean a(a aVar, v vVar) {
        if (aVar.ahM == vVar) {
            aVar.ahM = null;
        } else if (aVar.ahL != vVar) {
            return false;
        } else {
            aVar.ahL = null;
        }
        vVar.apJ.setAlpha(1.0f);
        vVar.apJ.setTranslationX(0.0f);
        vVar.apJ.setTranslationY(0.0f);
        m(vVar);
        return true;
    }

    public void d(v vVar) {
        int size;
        ArrayList arrayList;
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
    }

    private void e(v vVar) {
        if (ahn == null) {
            ahn = new ValueAnimator().getInterpolator();
        }
        vVar.apJ.animate().setInterpolator(ahn);
        d(vVar);
    }

    public boolean isRunning() {
        return (this.ahp.isEmpty() && this.ahr.isEmpty() && this.ahq.isEmpty() && this.aho.isEmpty() && this.ahw.isEmpty() && this.ahx.isEmpty() && this.ahv.isEmpty() && this.ahy.isEmpty() && this.aht.isEmpty() && this.ahs.isEmpty() && this.ahu.isEmpty()) ? false : true;
    }

    /* Access modifiers changed, original: final */
    public final void hY() {
        if (!isRunning()) {
            jS();
        }
    }

    public final void hZ() {
        int size;
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
        }
    }

    private static void o(List<v> list) {
        for (int size = list.size() - 1; size >= 0; size--) {
            ((v) list.get(size)).apJ.animate().cancel();
        }
    }

    public boolean a(v vVar, List<Object> list) {
        return !list.isEmpty() || super.a(vVar, list);
    }
}
