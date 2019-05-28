package android.support.transition;

import android.support.v4.view.s;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver.OnPreDrawListener;
import com.tencent.mm.R;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

public final class ae {
    private static Transition Aq = new AutoTransition();
    private static ThreadLocal<WeakReference<android.support.v4.f.a<ViewGroup, ArrayList<Transition>>>> Ar = new ThreadLocal();
    private static ArrayList<ViewGroup> As = new ArrayList();

    static class a implements OnAttachStateChangeListener, OnPreDrawListener {
        Transition Ap;
        ViewGroup zk;

        a(Transition transition, ViewGroup viewGroup) {
            this.Ap = transition;
            this.zk = viewGroup;
        }

        private void db() {
            this.zk.getViewTreeObserver().removeOnPreDrawListener(this);
            this.zk.removeOnAttachStateChangeListener(this);
        }

        public final void onViewAttachedToWindow(View view) {
        }

        public final void onViewDetachedFromWindow(View view) {
            db();
            ae.As.remove(this.zk);
            ArrayList arrayList = (ArrayList) ae.cZ().get(this.zk);
            if (arrayList != null && arrayList.size() > 0) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    ((Transition) it.next()).G(this.zk);
                }
            }
            this.Ap.v(true);
        }

        public final boolean onPreDraw() {
            db();
            if (ae.As.remove(this.zk)) {
                final android.support.v4.f.a cZ = ae.cZ();
                ArrayList arrayList = (ArrayList) cZ.get(this.zk);
                ArrayList arrayList2 = null;
                if (arrayList == null) {
                    arrayList = new ArrayList();
                    cZ.put(this.zk, arrayList);
                } else if (arrayList.size() > 0) {
                    arrayList2 = new ArrayList(arrayList);
                }
                arrayList.add(this.Ap);
                this.Ap.a(new ad() {
                    public final void a(Transition transition) {
                        ((ArrayList) cZ.get(a.this.zk)).remove(transition);
                    }
                });
                this.Ap.b(this.zk, false);
                if (arrayList2 != null) {
                    Iterator it = arrayList2.iterator();
                    while (it.hasNext()) {
                        ((Transition) it.next()).G(this.zk);
                    }
                }
                this.Ap.b(this.zk);
            }
            return true;
        }
    }

    static android.support.v4.f.a<ViewGroup, ArrayList<Transition>> cZ() {
        WeakReference weakReference = (WeakReference) Ar.get();
        if (weakReference == null || weakReference.get() == null) {
            weakReference = new WeakReference(new android.support.v4.f.a());
            Ar.set(weakReference);
        }
        return (android.support.v4.f.a) weakReference.get();
    }

    public static void a(ViewGroup viewGroup, Transition transition) {
        if (!As.contains(viewGroup) && s.as(viewGroup)) {
            As.add(viewGroup);
            if (transition == null) {
                transition = Aq;
            }
            Transition cY = transition.clone();
            ArrayList arrayList = (ArrayList) cZ().get(viewGroup);
            if (arrayList != null && arrayList.size() > 0) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    ((Transition) it.next()).F(viewGroup);
                }
            }
            if (cY != null) {
                cY.b(viewGroup, true);
            }
            aa B = aa.B(viewGroup);
            if (!(B == null || aa.B(B.zk) != B || B.zl == null)) {
                B.zl.run();
            }
            viewGroup.setTag(R.id.cz, null);
            if (cY != null && viewGroup != null) {
                a aVar = new a(cY, viewGroup);
                viewGroup.addOnAttachStateChangeListener(aVar);
                viewGroup.getViewTreeObserver().addOnPreDrawListener(aVar);
            }
        }
    }
}
