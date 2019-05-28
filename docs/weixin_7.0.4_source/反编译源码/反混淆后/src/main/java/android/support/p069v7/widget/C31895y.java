package android.support.p069v7.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.support.p057v4.view.C0477s;
import android.support.p069v7.widget.RecyclerView.C41531v;
import android.view.View;
import android.view.ViewPropertyAnimator;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: android.support.v7.widget.y */
public class C31895y extends C17495av {
    private static TimeInterpolator ahn;
    private ArrayList<C41531v> aho = new ArrayList();
    private ArrayList<C41531v> ahp = new ArrayList();
    private ArrayList<C0729b> ahq = new ArrayList();
    private ArrayList<C31894a> ahr = new ArrayList();
    ArrayList<ArrayList<C41531v>> ahs = new ArrayList();
    ArrayList<ArrayList<C0729b>> aht = new ArrayList();
    ArrayList<ArrayList<C31894a>> ahu = new ArrayList();
    ArrayList<C41531v> ahv = new ArrayList();
    ArrayList<C41531v> ahw = new ArrayList();
    ArrayList<C41531v> ahx = new ArrayList();
    ArrayList<C41531v> ahy = new ArrayList();

    /* renamed from: android.support.v7.widget.y$b */
    static class C0729b {
        public int ahN;
        public int ahO;
        public int ahP;
        public int ahQ;
        public C41531v ahR;

        C0729b(C41531v c41531v, int i, int i2, int i3, int i4) {
            this.ahR = c41531v;
            this.ahN = i;
            this.ahO = i2;
            this.ahP = i3;
            this.ahQ = i4;
        }
    }

    /* renamed from: android.support.v7.widget.y$7 */
    class C84757 extends AnimatorListenerAdapter {
        final /* synthetic */ C31894a ahH;
        final /* synthetic */ ViewPropertyAnimator ahI;
        final /* synthetic */ View val$view;

        C84757(C31894a c31894a, ViewPropertyAnimator viewPropertyAnimator, View view) {
            this.ahH = c31894a;
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
            C31895y.this.mo51947m(this.ahH.ahL);
            C31895y.this.ahy.remove(this.ahH.ahL);
            C31895y.this.mo52004hY();
        }
    }

    /* renamed from: android.support.v7.widget.y$8 */
    class C84768 extends AnimatorListenerAdapter {
        final /* synthetic */ C31894a ahH;
        final /* synthetic */ ViewPropertyAnimator ahJ;
        final /* synthetic */ View ahK;

        C84768(C31894a c31894a, ViewPropertyAnimator viewPropertyAnimator, View view) {
            this.ahH = c31894a;
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
            C31895y.this.mo51947m(this.ahH.ahM);
            C31895y.this.ahy.remove(this.ahH.ahM);
            C31895y.this.mo52004hY();
        }
    }

    /* renamed from: android.support.v7.widget.y$6 */
    class C318936 extends AnimatorListenerAdapter {
        final /* synthetic */ C41531v ahD;
        final /* synthetic */ ViewPropertyAnimator ahE;
        final /* synthetic */ int ahF;
        final /* synthetic */ int ahG;
        final /* synthetic */ View val$view;

        C318936(C41531v c41531v, int i, View view, int i2, ViewPropertyAnimator viewPropertyAnimator) {
            this.ahD = c41531v;
            this.ahF = i;
            this.val$view = view;
            this.ahG = i2;
            this.ahE = viewPropertyAnimator;
        }

        public final void onAnimationStart(Animator animator) {
            C31895y.this.mo31915F(this.ahD);
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
            C31895y.this.mo31913C(this.ahD);
            C31895y.this.ahw.remove(this.ahD);
            C31895y.this.mo52004hY();
        }
    }

    /* renamed from: android.support.v7.widget.y$a */
    static class C31894a {
        public C41531v ahL;
        public C41531v ahM;
        public int ahN;
        public int ahO;
        public int ahP;
        public int ahQ;

        private C31894a(C41531v c41531v, C41531v c41531v2) {
            this.ahL = c41531v;
            this.ahM = c41531v2;
        }

        C31894a(C41531v c41531v, C41531v c41531v2, int i, int i2, int i3, int i4) {
            this(c41531v, c41531v2);
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
    class C318975 extends AnimatorListenerAdapter {
        final /* synthetic */ C41531v ahD;
        final /* synthetic */ ViewPropertyAnimator ahE;
        final /* synthetic */ View val$view;

        C318975(C41531v c41531v, View view, ViewPropertyAnimator viewPropertyAnimator) {
            this.ahD = c41531v;
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
            C31895y.this.mo51947m(this.ahD);
            C31895y.this.ahv.remove(this.ahD);
            C31895y.this.mo52004hY();
        }
    }

    /* renamed from: hX */
    public void mo22571hX() {
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
                final C41531v c41531v = (C41531v) it.next();
                final View view = c41531v.apJ;
                final ViewPropertyAnimator animate = view.animate();
                this.ahx.add(c41531v);
                animate.setDuration(this.aou).alpha(0.0f).setListener(new AnimatorListenerAdapter() {
                    public final void onAnimationStart(Animator animator) {
                        C31895y.this.mo31914D(c41531v);
                    }

                    public final void onAnimationEnd(Animator animator) {
                        animate.setListener(null);
                        view.setAlpha(1.0f);
                        C31895y.this.mo31912B(c41531v);
                        C31895y.this.ahx.remove(c41531v);
                        C31895y.this.mo52004hY();
                    }
                }).start();
            }
            this.aho.clear();
            if (i != 0) {
                arrayList = new ArrayList();
                arrayList.addAll(this.ahq);
                this.aht.add(arrayList);
                this.ahq.clear();
                C84741 c84741 = new Runnable() {
                    public final void run() {
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            C0729b c0729b = (C0729b) it.next();
                            C31895y c31895y = C31895y.this;
                            C41531v c41531v = c0729b.ahR;
                            int i = c0729b.ahN;
                            int i2 = c0729b.ahO;
                            int i3 = c0729b.ahP;
                            int i4 = c0729b.ahQ;
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
                            c31895y.ahw.add(c41531v);
                            animate.setDuration(c31895y.aov).setListener(new C318936(c41531v, i, view, i2, animate)).start();
                        }
                        arrayList.clear();
                        C31895y.this.aht.remove(arrayList);
                    }
                };
                if (i4 != 0) {
                    C0477s.m908a(((C0729b) arrayList.get(0)).ahR.apJ, c84741, this.aou);
                } else {
                    c84741.run();
                }
            }
            if (i2 != 0) {
                arrayList = new ArrayList();
                arrayList.addAll(this.ahr);
                this.ahu.add(arrayList);
                this.ahr.clear();
                C253822 c253822 = new Runnable() {
                    public final void run() {
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            View view;
                            C31894a c31894a = (C31894a) it.next();
                            C31895y c31895y = C31895y.this;
                            C41531v c41531v = c31894a.ahL;
                            View view2 = c41531v == null ? null : c41531v.apJ;
                            C41531v c41531v2 = c31894a.ahM;
                            if (c41531v2 != null) {
                                view = c41531v2.apJ;
                            } else {
                                view = null;
                            }
                            if (view2 != null) {
                                ViewPropertyAnimator duration = view2.animate().setDuration(c31895y.aow);
                                c31895y.ahy.add(c31894a.ahL);
                                duration.translationX((float) (c31894a.ahP - c31894a.ahN));
                                duration.translationY((float) (c31894a.ahQ - c31894a.ahO));
                                duration.alpha(0.0f).setListener(new C84757(c31894a, duration, view2)).start();
                            }
                            if (view != null) {
                                ViewPropertyAnimator animate = view.animate();
                                c31895y.ahy.add(c31894a.ahM);
                                animate.translationX(0.0f).translationY(0.0f).setDuration(c31895y.aow).alpha(1.0f).setListener(new C84768(c31894a, animate, view)).start();
                            }
                        }
                        arrayList.clear();
                        C31895y.this.ahu.remove(arrayList);
                    }
                };
                if (i4 != 0) {
                    C0477s.m908a(((C31894a) arrayList.get(0)).ahL.apJ, c253822, this.aou);
                } else {
                    c253822.run();
                }
            }
            if (i3 != 0) {
                final ArrayList arrayList2 = new ArrayList();
                arrayList2.addAll(this.ahp);
                this.ahs.add(arrayList2);
                this.ahp.clear();
                C318963 c318963 = new Runnable() {
                    public final void run() {
                        Iterator it = arrayList2.iterator();
                        while (it.hasNext()) {
                            C41531v c41531v = (C41531v) it.next();
                            C31895y c31895y = C31895y.this;
                            View view = c41531v.apJ;
                            ViewPropertyAnimator animate = view.animate();
                            c31895y.ahv.add(c41531v);
                            animate.alpha(1.0f).setDuration(c31895y.aot).setListener(new C318975(c41531v, view, animate)).start();
                        }
                        arrayList2.clear();
                        C31895y.this.ahs.remove(arrayList2);
                    }
                };
                if (i4 == 0 && i == 0 && i2 == 0) {
                    c318963.run();
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
                C0477s.m908a(((C41531v) arrayList2.get(0)).apJ, c318963, j + Math.max(j2, j3));
            }
        }
    }

    /* renamed from: b */
    public boolean mo22568b(C41531v c41531v) {
        m51746e(c41531v);
        this.aho.add(c41531v);
        return true;
    }

    /* renamed from: c */
    public boolean mo22569c(C41531v c41531v) {
        m51746e(c41531v);
        c41531v.apJ.setAlpha(0.0f);
        this.ahp.add(c41531v);
        return true;
    }

    /* renamed from: a */
    public boolean mo22565a(C41531v c41531v, int i, int i2, int i3, int i4) {
        View view = c41531v.apJ;
        int translationX = i + ((int) c41531v.apJ.getTranslationX());
        int translationY = i2 + ((int) c41531v.apJ.getTranslationY());
        m51746e(c41531v);
        int i5 = i3 - translationX;
        int i6 = i4 - translationY;
        if (i5 == 0 && i6 == 0) {
            mo31913C(c41531v);
            return false;
        }
        if (i5 != 0) {
            view.setTranslationX((float) (-i5));
        }
        if (i6 != 0) {
            view.setTranslationY((float) (-i6));
        }
        this.ahq.add(new C0729b(c41531v, translationX, translationY, i3, i4));
        return true;
    }

    /* renamed from: a */
    public boolean mo22566a(C41531v c41531v, C41531v c41531v2, int i, int i2, int i3, int i4) {
        if (c41531v == c41531v2) {
            return mo22565a(c41531v, i, i2, i3, i4);
        }
        float translationX = c41531v.apJ.getTranslationX();
        float translationY = c41531v.apJ.getTranslationY();
        float alpha = c41531v.apJ.getAlpha();
        m51746e(c41531v);
        int i5 = (int) (((float) (i3 - i)) - translationX);
        int i6 = (int) (((float) (i4 - i2)) - translationY);
        c41531v.apJ.setTranslationX(translationX);
        c41531v.apJ.setTranslationY(translationY);
        c41531v.apJ.setAlpha(alpha);
        if (c41531v2 != null) {
            m51746e(c41531v2);
            c41531v2.apJ.setTranslationX((float) (-i5));
            c41531v2.apJ.setTranslationY((float) (-i6));
            c41531v2.apJ.setAlpha(0.0f);
        }
        this.ahr.add(new C31894a(c41531v, c41531v2, i, i2, i3, i4));
        return true;
    }

    /* renamed from: a */
    private void m51744a(List<C31894a> list, C41531v c41531v) {
        for (int size = list.size() - 1; size >= 0; size--) {
            C31894a c31894a = (C31894a) list.get(size);
            if (m51745a(c31894a, c41531v) && c31894a.ahL == null && c31894a.ahM == null) {
                list.remove(c31894a);
            }
        }
    }

    /* renamed from: a */
    private void m51743a(C31894a c31894a) {
        if (c31894a.ahL != null) {
            m51745a(c31894a, c31894a.ahL);
        }
        if (c31894a.ahM != null) {
            m51745a(c31894a, c31894a.ahM);
        }
    }

    /* renamed from: a */
    private boolean m51745a(C31894a c31894a, C41531v c41531v) {
        if (c31894a.ahM == c41531v) {
            c31894a.ahM = null;
        } else if (c31894a.ahL != c41531v) {
            return false;
        } else {
            c31894a.ahL = null;
        }
        c41531v.apJ.setAlpha(1.0f);
        c41531v.apJ.setTranslationX(0.0f);
        c41531v.apJ.setTranslationY(0.0f);
        mo51947m(c41531v);
        return true;
    }

    /* renamed from: d */
    public void mo22570d(C41531v c41531v) {
        int size;
        ArrayList arrayList;
        View view = c41531v.apJ;
        view.animate().cancel();
        for (size = this.ahq.size() - 1; size >= 0; size--) {
            if (((C0729b) this.ahq.get(size)).ahR == c41531v) {
                view.setTranslationY(0.0f);
                view.setTranslationX(0.0f);
                mo31913C(c41531v);
                this.ahq.remove(size);
            }
        }
        m51744a(this.ahr, c41531v);
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
            m51744a(list, c41531v);
            if (list.isEmpty()) {
                this.ahu.remove(size);
            }
        }
        for (int size2 = this.aht.size() - 1; size2 >= 0; size2--) {
            arrayList = (ArrayList) this.aht.get(size2);
            int size3 = arrayList.size() - 1;
            while (size3 >= 0) {
                if (((C0729b) arrayList.get(size3)).ahR == c41531v) {
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
        mo52004hY();
    }

    /* renamed from: e */
    private void m51746e(C41531v c41531v) {
        if (ahn == null) {
            ahn = new ValueAnimator().getInterpolator();
        }
        c41531v.apJ.animate().setInterpolator(ahn);
        mo22570d(c41531v);
    }

    public boolean isRunning() {
        return (this.ahp.isEmpty() && this.ahr.isEmpty() && this.ahq.isEmpty() && this.aho.isEmpty() && this.ahw.isEmpty() && this.ahx.isEmpty() && this.ahv.isEmpty() && this.ahy.isEmpty() && this.aht.isEmpty() && this.ahs.isEmpty() && this.ahu.isEmpty()) ? false : true;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: hY */
    public final void mo52004hY() {
        if (!isRunning()) {
            mo51946jS();
        }
    }

    /* renamed from: hZ */
    public final void mo22573hZ() {
        int size;
        for (size = this.ahq.size() - 1; size >= 0; size--) {
            C0729b c0729b = (C0729b) this.ahq.get(size);
            View view = c0729b.ahR.apJ;
            view.setTranslationY(0.0f);
            view.setTranslationX(0.0f);
            mo31913C(c0729b.ahR);
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
            m51743a((C31894a) this.ahr.get(size));
        }
        this.ahr.clear();
        if (isRunning()) {
            int size2;
            ArrayList arrayList;
            int size3;
            for (size2 = this.aht.size() - 1; size2 >= 0; size2--) {
                arrayList = (ArrayList) this.aht.get(size2);
                for (size3 = arrayList.size() - 1; size3 >= 0; size3--) {
                    C0729b c0729b2 = (C0729b) arrayList.get(size3);
                    View view2 = c0729b2.ahR.apJ;
                    view2.setTranslationY(0.0f);
                    view2.setTranslationX(0.0f);
                    mo31913C(c0729b2.ahR);
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
                    m51743a((C31894a) arrayList.get(size3));
                    if (arrayList.isEmpty()) {
                        this.ahu.remove(arrayList);
                    }
                }
            }
            C31895y.m51747o(this.ahx);
            C31895y.m51747o(this.ahw);
            C31895y.m51747o(this.ahv);
            C31895y.m51747o(this.ahy);
            mo51946jS();
        }
    }

    /* renamed from: o */
    private static void m51747o(List<C41531v> list) {
        for (int size = list.size() - 1; size >= 0; size--) {
            ((C41531v) list.get(size)).apJ.animate().cancel();
        }
    }

    /* renamed from: a */
    public boolean mo22567a(C41531v c41531v, List<Object> list) {
        return !list.isEmpty() || super.mo22567a(c41531v, list);
    }
}
