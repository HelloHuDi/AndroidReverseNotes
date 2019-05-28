package android.support.transition;

import android.support.p057v4.p065f.C6197a;
import android.support.p057v4.view.C0477s;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver.OnPreDrawListener;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: android.support.transition.ae */
public final class C44947ae {
    /* renamed from: Aq */
    private static Transition f17661Aq = new AutoTransition();
    /* renamed from: Ar */
    private static ThreadLocal<WeakReference<C6197a<ViewGroup, ArrayList<Transition>>>> f17662Ar = new ThreadLocal();
    /* renamed from: As */
    private static ArrayList<ViewGroup> f17663As = new ArrayList();

    /* renamed from: android.support.transition.ae$a */
    static class C44946a implements OnAttachStateChangeListener, OnPreDrawListener {
        /* renamed from: Ap */
        Transition f17659Ap;
        /* renamed from: zk */
        ViewGroup f17660zk;

        C44946a(Transition transition, ViewGroup viewGroup) {
            this.f17659Ap = transition;
            this.f17660zk = viewGroup;
        }

        /* renamed from: db */
        private void m82220db() {
            this.f17660zk.getViewTreeObserver().removeOnPreDrawListener(this);
            this.f17660zk.removeOnAttachStateChangeListener(this);
        }

        public final void onViewAttachedToWindow(View view) {
        }

        public final void onViewDetachedFromWindow(View view) {
            m82220db();
            C44947ae.f17663As.remove(this.f17660zk);
            ArrayList arrayList = (ArrayList) C44947ae.m82222cZ().get(this.f17660zk);
            if (arrayList != null && arrayList.size() > 0) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    ((Transition) it.next()).mo42269G(this.f17660zk);
                }
            }
            this.f17659Ap.mo59148v(true);
        }

        public final boolean onPreDraw() {
            m82220db();
            if (C44947ae.f17663As.remove(this.f17660zk)) {
                final C6197a cZ = C44947ae.m82222cZ();
                ArrayList arrayList = (ArrayList) cZ.get(this.f17660zk);
                ArrayList arrayList2 = null;
                if (arrayList == null) {
                    arrayList = new ArrayList();
                    cZ.put(this.f17660zk, arrayList);
                } else if (arrayList.size() > 0) {
                    arrayList2 = new ArrayList(arrayList);
                }
                arrayList.add(this.f17659Ap);
                this.f17659Ap.mo42271a(new C36668ad() {
                    /* renamed from: a */
                    public final void mo452a(Transition transition) {
                        ((ArrayList) cZ.get(C44946a.this.f17660zk)).remove(transition);
                    }
                });
                this.f17659Ap.mo59142b(this.f17660zk, false);
                if (arrayList2 != null) {
                    Iterator it = arrayList2.iterator();
                    while (it.hasNext()) {
                        ((Transition) it.next()).mo42269G(this.f17660zk);
                    }
                }
                this.f17659Ap.mo59141b(this.f17660zk);
            }
            return true;
        }
    }

    /* renamed from: cZ */
    static C6197a<ViewGroup, ArrayList<Transition>> m82222cZ() {
        WeakReference weakReference = (WeakReference) f17662Ar.get();
        if (weakReference == null || weakReference.get() == null) {
            weakReference = new WeakReference(new C6197a());
            f17662Ar.set(weakReference);
        }
        return (C6197a) weakReference.get();
    }

    /* renamed from: a */
    public static void m82221a(ViewGroup viewGroup, Transition transition) {
        if (!f17663As.contains(viewGroup) && C0477s.m927as(viewGroup)) {
            f17663As.add(viewGroup);
            if (transition == null) {
                transition = f17661Aq;
            }
            Transition cY = transition.clone();
            ArrayList arrayList = (ArrayList) C44947ae.m82222cZ().get(viewGroup);
            if (arrayList != null && arrayList.size() > 0) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    ((Transition) it.next()).mo42268F(viewGroup);
                }
            }
            if (cY != null) {
                cY.mo59142b(viewGroup, true);
            }
            C0277aa B = C0277aa.m453B(viewGroup);
            if (!(B == null || C0277aa.m453B(B.f190zk) != B || B.f191zl == null)) {
                B.f191zl.run();
            }
            viewGroup.setTag(2131820680, null);
            if (cY != null && viewGroup != null) {
                C44946a c44946a = new C44946a(cY, viewGroup);
                viewGroup.addOnAttachStateChangeListener(c44946a);
                viewGroup.getViewTreeObserver().addOnPreDrawListener(c44946a);
            }
        }
    }
}
