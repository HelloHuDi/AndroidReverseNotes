package android.support.transition;

import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.support.transition.Transition.b;
import android.support.transition.Transition.c;
import android.util.AndroidRuntimeException;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.ttpic.baseutils.IOUtils;
import java.util.ArrayList;
import java.util.Iterator;

public class TransitionSet extends Transition {
    ArrayList<Transition> Av = new ArrayList();
    private boolean Aw = true;
    private int Ax;
    private boolean mStarted = false;

    static class a extends ad {
        TransitionSet AA;

        a(TransitionSet transitionSet) {
            this.AA = transitionSet;
        }

        public final void cT() {
            if (!this.AA.mStarted) {
                this.AA.start();
                this.AA.mStarted = true;
            }
        }

        public final void a(Transition transition) {
            TransitionSet.b(this.AA);
            if (this.AA.Ax == 0) {
                this.AA.mStarted = false;
                this.AA.end();
            }
            transition.b((c) this);
        }
    }

    public TransitionSet(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ac.zE);
        ao(android.support.v4.content.a.c.a(obtainStyledAttributes, (XmlResourceParser) attributeSet, "transitionOrdering", 0, 0));
        obtainStyledAttributes.recycle();
    }

    public final TransitionSet ao(int i) {
        switch (i) {
            case 0:
                this.Aw = true;
                break;
            case 1:
                this.Aw = false;
                break;
            default:
                throw new AndroidRuntimeException("Invalid parameter for TransitionSet ordering: ".concat(String.valueOf(i)));
        }
        return this;
    }

    public final TransitionSet d(Transition transition) {
        this.Av.add(transition);
        transition.zY = this;
        if (this.mDuration >= 0) {
            transition.g(this.mDuration);
        }
        return this;
    }

    public final Transition ap(int i) {
        if (i < 0 || i >= this.Av.size()) {
            return null;
        }
        return (Transition) this.Av.get(i);
    }

    /* renamed from: i */
    public final TransitionSet g(long j) {
        super.g(j);
        if (this.mDuration >= 0) {
            int size = this.Av.size();
            for (int i = 0; i < size; i++) {
                ((Transition) this.Av.get(i)).g(j);
            }
        }
        return this;
    }

    /* renamed from: b */
    public final TransitionSet a(TimeInterpolator timeInterpolator) {
        return (TransitionSet) super.a(timeInterpolator);
    }

    /* Access modifiers changed, original: protected|final */
    public final void cX() {
        if (this.Av.isEmpty()) {
            start();
            end();
            return;
        }
        c aVar = new a(this);
        Iterator it = this.Av.iterator();
        while (it.hasNext()) {
            ((Transition) it.next()).a(aVar);
        }
        this.Ax = this.Av.size();
        if (this.Aw) {
            Iterator it2 = this.Av.iterator();
            while (it2.hasNext()) {
                ((Transition) it2.next()).cX();
            }
            return;
        }
        int i = 1;
        while (true) {
            int i2 = i;
            if (i2 >= this.Av.size()) {
                break;
            }
            final Transition transition = (Transition) this.Av.get(i2);
            ((Transition) this.Av.get(i2 - 1)).a(new ad() {
                public final void a(Transition transition) {
                    transition.cX();
                    transition.b((c) this);
                }
            });
            i = i2 + 1;
        }
        Transition transition2 = (Transition) this.Av.get(0);
        if (transition2 != null) {
            transition2.cX();
        }
    }

    public final void a(ah ahVar) {
        if (C(ahVar.view)) {
            Iterator it = this.Av.iterator();
            while (it.hasNext()) {
                Transition transition = (Transition) it.next();
                if (transition.C(ahVar.view)) {
                    transition.a(ahVar);
                    ahVar.AD.add(transition);
                }
            }
        }
    }

    public final void b(ah ahVar) {
        if (C(ahVar.view)) {
            Iterator it = this.Av.iterator();
            while (it.hasNext()) {
                Transition transition = (Transition) it.next();
                if (transition.C(ahVar.view)) {
                    transition.b(ahVar);
                    ahVar.AD.add(transition);
                }
            }
        }
    }

    /* Access modifiers changed, original: final */
    public final void d(ah ahVar) {
        super.d(ahVar);
        int size = this.Av.size();
        for (int i = 0; i < size; i++) {
            ((Transition) this.Av.get(i)).d(ahVar);
        }
    }

    public final void F(View view) {
        super.F(view);
        int size = this.Av.size();
        for (int i = 0; i < size; i++) {
            ((Transition) this.Av.get(i)).F(view);
        }
    }

    public final void G(View view) {
        super.G(view);
        int size = this.Av.size();
        for (int i = 0; i < size; i++) {
            ((Transition) this.Av.get(i)).G(view);
        }
    }

    public final void a(af afVar) {
        super.a(afVar);
        int size = this.Av.size();
        for (int i = 0; i < size; i++) {
            ((Transition) this.Av.get(i)).a(afVar);
        }
    }

    public final void a(b bVar) {
        super.a(bVar);
        int size = this.Av.size();
        for (int i = 0; i < size; i++) {
            ((Transition) this.Av.get(i)).a(bVar);
        }
    }

    /* Access modifiers changed, original: final */
    public final String toString(String str) {
        String transition = super.toString(str);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.Av.size()) {
                return transition;
            }
            transition = transition + IOUtils.LINE_SEPARATOR_UNIX + ((Transition) this.Av.get(i2)).toString(str + "  ");
            i = i2 + 1;
        }
    }

    /* renamed from: cY */
    public final Transition clone() {
        TransitionSet transitionSet = (TransitionSet) super.clone();
        transitionSet.Av = new ArrayList();
        int size = this.Av.size();
        for (int i = 0; i < size; i++) {
            transitionSet.d(((Transition) this.Av.get(i)).clone());
        }
        return transitionSet;
    }

    /* Access modifiers changed, original: protected|final */
    public final void a(ViewGroup viewGroup, ai aiVar, ai aiVar2, ArrayList<ah> arrayList, ArrayList<ah> arrayList2) {
        long j = this.zJ;
        int size = this.Av.size();
        int i = 0;
        while (i < size) {
            Transition transition = (Transition) this.Av.get(i);
            if (j > 0 && (this.Aw || i == 0)) {
                long j2 = transition.zJ;
                if (j2 > 0) {
                    transition.h(j2 + j);
                } else {
                    transition.h(j);
                }
            }
            transition.a(viewGroup, aiVar, aiVar2, arrayList, arrayList2);
            i++;
        }
    }

    public final /* synthetic */ Transition E(View view) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.Av.size()) {
                return (TransitionSet) super.E(view);
            }
            ((Transition) this.Av.get(i2)).E(view);
            i = i2 + 1;
        }
    }

    public final /* synthetic */ Transition D(View view) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.Av.size()) {
                return (TransitionSet) super.D(view);
            }
            ((Transition) this.Av.get(i2)).D(view);
            i = i2 + 1;
        }
    }

    public final /* bridge */ /* synthetic */ Transition h(long j) {
        return (TransitionSet) super.h(j);
    }
}
