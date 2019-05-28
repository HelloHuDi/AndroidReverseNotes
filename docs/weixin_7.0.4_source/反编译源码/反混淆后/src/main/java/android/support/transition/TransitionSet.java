package android.support.transition;

import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.support.p057v4.content.p062a.C0379c;
import android.support.transition.Transition.C31851b;
import android.support.transition.Transition.C31852c;
import android.util.AndroidRuntimeException;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.ttpic.baseutils.IOUtils;
import java.util.ArrayList;
import java.util.Iterator;

public class TransitionSet extends Transition {
    /* renamed from: Av */
    ArrayList<Transition> f5121Av = new ArrayList();
    /* renamed from: Aw */
    private boolean f5122Aw = true;
    /* renamed from: Ax */
    private int f5123Ax;
    private boolean mStarted = false;

    /* renamed from: android.support.transition.TransitionSet$a */
    static class C17409a extends C36668ad {
        /* renamed from: AA */
        TransitionSet f3841AA;

        C17409a(TransitionSet transitionSet) {
            this.f3841AA = transitionSet;
        }

        /* renamed from: cT */
        public final void mo31631cT() {
            if (!this.f3841AA.mStarted) {
                this.f3841AA.start();
                this.f3841AA.mStarted = true;
            }
        }

        /* renamed from: a */
        public final void mo452a(Transition transition) {
            TransitionSet.m39924b(this.f3841AA);
            if (this.f3841AA.f5123Ax == 0) {
                this.f3841AA.mStarted = false;
                this.f3841AA.end();
            }
            transition.mo42277b((C31852c) this);
        }
    }

    public TransitionSet(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C37103ac.f15735zE);
        mo42275ao(C0379c.m637a(obtainStyledAttributes, (XmlResourceParser) attributeSet, "transitionOrdering", 0, 0));
        obtainStyledAttributes.recycle();
    }

    /* renamed from: ao */
    public final TransitionSet mo42275ao(int i) {
        switch (i) {
            case 0:
                this.f5122Aw = true;
                break;
            case 1:
                this.f5122Aw = false;
                break;
            default:
                throw new AndroidRuntimeException("Invalid parameter for TransitionSet ordering: ".concat(String.valueOf(i)));
        }
        return this;
    }

    /* renamed from: d */
    public final TransitionSet mo42282d(Transition transition) {
        this.f5121Av.add(transition);
        transition.f15724zY = this;
        if (this.mDuration >= 0) {
            transition.mo42284g(this.mDuration);
        }
        return this;
    }

    /* renamed from: ap */
    public final Transition mo42276ap(int i) {
        if (i < 0 || i >= this.f5121Av.size()) {
            return null;
        }
        return (Transition) this.f5121Av.get(i);
    }

    /* renamed from: i */
    public final TransitionSet mo42284g(long j) {
        super.mo42284g(j);
        if (this.mDuration >= 0) {
            int size = this.f5121Av.size();
            for (int i = 0; i < size; i++) {
                ((Transition) this.f5121Av.get(i)).mo42284g(j);
            }
        }
        return this;
    }

    /* renamed from: b */
    public final TransitionSet mo42270a(TimeInterpolator timeInterpolator) {
        return (TransitionSet) super.mo42270a(timeInterpolator);
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: cX */
    public final void mo42279cX() {
        if (this.f5121Av.isEmpty()) {
            start();
            end();
            return;
        }
        C31852c c17409a = new C17409a(this);
        Iterator it = this.f5121Av.iterator();
        while (it.hasNext()) {
            ((Transition) it.next()).mo42271a(c17409a);
        }
        this.f5123Ax = this.f5121Av.size();
        if (this.f5122Aw) {
            Iterator it2 = this.f5121Av.iterator();
            while (it2.hasNext()) {
                ((Transition) it2.next()).mo42279cX();
            }
            return;
        }
        int i = 1;
        while (true) {
            int i2 = i;
            if (i2 >= this.f5121Av.size()) {
                break;
            }
            final Transition transition = (Transition) this.f5121Av.get(i2);
            ((Transition) this.f5121Av.get(i2 - 1)).mo42271a(new C36668ad() {
                /* renamed from: a */
                public final void mo452a(Transition transition) {
                    transition.mo42279cX();
                    transition.mo42277b((C31852c) this);
                }
            });
            i = i2 + 1;
        }
        Transition transition2 = (Transition) this.f5121Av.get(0);
        if (transition2 != null) {
            transition2.mo42279cX();
        }
    }

    /* renamed from: a */
    public final void mo410a(C8368ah c8368ah) {
        if (mo59139C(c8368ah.view)) {
            Iterator it = this.f5121Av.iterator();
            while (it.hasNext()) {
                Transition transition = (Transition) it.next();
                if (transition.mo59139C(c8368ah.view)) {
                    transition.mo410a(c8368ah);
                    c8368ah.f2315AD.add(transition);
                }
            }
        }
    }

    /* renamed from: b */
    public final void mo411b(C8368ah c8368ah) {
        if (mo59139C(c8368ah.view)) {
            Iterator it = this.f5121Av.iterator();
            while (it.hasNext()) {
                Transition transition = (Transition) it.next();
                if (transition.mo59139C(c8368ah.view)) {
                    transition.mo411b(c8368ah);
                    c8368ah.f2315AD.add(transition);
                }
            }
        }
    }

    /* Access modifiers changed, original: final */
    /* renamed from: d */
    public final void mo42283d(C8368ah c8368ah) {
        super.mo42283d(c8368ah);
        int size = this.f5121Av.size();
        for (int i = 0; i < size; i++) {
            ((Transition) this.f5121Av.get(i)).mo42283d(c8368ah);
        }
    }

    /* renamed from: F */
    public final void mo42268F(View view) {
        super.mo42268F(view);
        int size = this.f5121Av.size();
        for (int i = 0; i < size; i++) {
            ((Transition) this.f5121Av.get(i)).mo42268F(view);
        }
    }

    /* renamed from: G */
    public final void mo42269G(View view) {
        super.mo42269G(view);
        int size = this.f5121Av.size();
        for (int i = 0; i < size; i++) {
            ((Transition) this.f5121Av.get(i)).mo42269G(view);
        }
    }

    /* renamed from: a */
    public final void mo42273a(C37104af c37104af) {
        super.mo42273a(c37104af);
        int size = this.f5121Av.size();
        for (int i = 0; i < size; i++) {
            ((Transition) this.f5121Av.get(i)).mo42273a(c37104af);
        }
    }

    /* renamed from: a */
    public final void mo42272a(C31851b c31851b) {
        super.mo42272a(c31851b);
        int size = this.f5121Av.size();
        for (int i = 0; i < size; i++) {
            ((Transition) this.f5121Av.get(i)).mo42272a(c31851b);
        }
    }

    /* Access modifiers changed, original: final */
    public final String toString(String str) {
        String transition = super.toString(str);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.f5121Av.size()) {
                return transition;
            }
            transition = transition + IOUtils.LINE_SEPARATOR_UNIX + ((Transition) this.f5121Av.get(i2)).toString(str + "  ");
            i = i2 + 1;
        }
    }

    /* renamed from: cY */
    public final Transition clone() {
        TransitionSet transitionSet = (TransitionSet) super.clone();
        transitionSet.f5121Av = new ArrayList();
        int size = this.f5121Av.size();
        for (int i = 0; i < size; i++) {
            transitionSet.mo42282d(((Transition) this.f5121Av.get(i)).clone());
        }
        return transitionSet;
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: a */
    public final void mo42274a(ViewGroup viewGroup, C25322ai c25322ai, C25322ai c25322ai2, ArrayList<C8368ah> arrayList, ArrayList<C8368ah> arrayList2) {
        long j = this.f15709zJ;
        int size = this.f5121Av.size();
        int i = 0;
        while (i < size) {
            Transition transition = (Transition) this.f5121Av.get(i);
            if (j > 0 && (this.f5122Aw || i == 0)) {
                long j2 = transition.f15709zJ;
                if (j2 > 0) {
                    transition.mo42285h(j2 + j);
                } else {
                    transition.mo42285h(j);
                }
            }
            transition.mo42274a(viewGroup, c25322ai, c25322ai2, arrayList, arrayList2);
            i++;
        }
    }

    /* renamed from: E */
    public final /* synthetic */ Transition mo42267E(View view) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.f5121Av.size()) {
                return (TransitionSet) super.mo42267E(view);
            }
            ((Transition) this.f5121Av.get(i2)).mo42267E(view);
            i = i2 + 1;
        }
    }

    /* renamed from: D */
    public final /* synthetic */ Transition mo42266D(View view) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.f5121Av.size()) {
                return (TransitionSet) super.mo42266D(view);
            }
            ((Transition) this.f5121Av.get(i2)).mo42266D(view);
            i = i2 + 1;
        }
    }

    /* renamed from: h */
    public final /* bridge */ /* synthetic */ Transition mo42285h(long j) {
        return (TransitionSet) super.mo42285h(j);
    }
}
