package com.tencent.luggage.p146d;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import com.tencent.luggage.p146d.C45123i.C6274e;
import com.tencent.luggage.p147g.C8870e;
import com.tencent.luggage.webview.C37407a;
import com.tencent.luggage.webview.default_impl.C25703a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.webview.luggage.p1070d.C31472a;
import java.util.Iterator;
import java.util.LinkedList;

/* renamed from: com.tencent.luggage.d.f */
public class C41707f implements C37397h {
    protected Class<? extends C37407a> bPi = C31472a.class;
    public FrameLayout bPj;
    public C25691a<C8860e> bPk = new C25691a(this, (byte) 0);
    protected C25688d bPl;
    C8870e bPm;
    public C37398j bPn;
    Integer bPo = null;
    private Class<? extends C37407a> bPp = null;
    public C41709g bPq = new C256908();
    protected Context mContext;

    /* renamed from: com.tencent.luggage.d.f$7 */
    class C178187 implements C37398j {
        C178187() {
        }

        /* renamed from: j */
        public final C8860e mo23952j(String str, Bundle bundle) {
            AppMethodBeat.m2504i(90780);
            C17821n c17821n = new C17821n(C41707f.this.bPq, bundle);
            AppMethodBeat.m2505o(90780);
            return c17821n;
        }
    }

    /* renamed from: com.tencent.luggage.d.f$6 */
    class C256896 implements Runnable {
        C256896() {
        }

        public final void run() {
            AppMethodBeat.m2504i(90779);
            if (!((Activity) C41707f.this.mContext).isFinishing()) {
                C41707f.this.bPo = C17820m.m27871a(C41707f.this.mContext.getApplicationContext(), C41707f.this.mo67385xe());
            }
            AppMethodBeat.m2505o(90779);
        }
    }

    /* renamed from: com.tencent.luggage.d.f$8 */
    class C256908 extends C41709g {
        C256908() {
        }

        /* Access modifiers changed, original: final */
        public final Context getContext() {
            return C41707f.this.mContext;
        }

        /* Access modifiers changed, original: final */
        /* renamed from: xe */
        public final Class<? extends C37407a> mo43475xe() {
            AppMethodBeat.m2504i(90781);
            Class xe = C41707f.this.mo67385xe();
            AppMethodBeat.m2505o(90781);
            return xe;
        }

        /* renamed from: xh */
        public final LinkedList<C8860e> mo43476xh() {
            return C41707f.this.bPk;
        }

        /* renamed from: xi */
        public final C37397h mo43477xi() {
            return C41707f.this;
        }

        /* renamed from: xj */
        public final LinkedList<Class<? extends C37393a>> mo43478xj() {
            AppMethodBeat.m2504i(90782);
            LinkedList linkedList = (LinkedList) C41707f.this.bPl.bPc.clone();
            AppMethodBeat.m2505o(90782);
            return linkedList;
        }

        /* renamed from: xd */
        public final C32186k mo43474xd() {
            AppMethodBeat.m2504i(90783);
            C32186k a = C41707f.m73364a(C41707f.this);
            AppMethodBeat.m2505o(90783);
            return a;
        }

        /* renamed from: xk */
        public final C8870e mo43479xk() {
            return C41707f.this.bPm;
        }
    }

    /* renamed from: com.tencent.luggage.d.f$a */
    public class C25691a<E> extends LinkedList<E> {
        private C25691a() {
        }

        /* synthetic */ C25691a(C41707f c41707f, byte b) {
            this();
        }

        public final E remove(int i) {
            AppMethodBeat.m2504i(90784);
            Object remove = super.remove(i);
            C41707f.this.mo63594xg();
            AppMethodBeat.m2505o(90784);
            return remove;
        }

        public final E pop() {
            AppMethodBeat.m2504i(90785);
            Object pop = super.pop();
            C41707f.this.mo63594xg();
            AppMethodBeat.m2505o(90785);
            return pop;
        }

        public final void push(E e) {
            AppMethodBeat.m2504i(90786);
            super.push(e);
            C41707f.this.mo63593xf();
            AppMethodBeat.m2505o(90786);
        }

        public final boolean add(E e) {
            AppMethodBeat.m2504i(90787);
            boolean add = super.add(e);
            if (add) {
                C41707f.this.mo63593xf();
            }
            AppMethodBeat.m2505o(90787);
            return add;
        }

        public final void add(int i, E e) {
            AppMethodBeat.m2504i(90788);
            super.add(i, e);
            C41707f.this.mo63593xf();
            AppMethodBeat.m2505o(90788);
        }
    }

    /* renamed from: com.tencent.luggage.d.f$4 */
    class C417064 implements Runnable {
        C417064() {
        }

        public final void run() {
            AppMethodBeat.m2504i(90777);
            ((C8860e) C41707f.this.bPk.peek()).mo20044wT();
            AppMethodBeat.m2505o(90777);
        }
    }

    public C41707f(Activity activity) {
        AppMethodBeat.m2504i(90789);
        this.mContext = activity;
        FrameLayout frameLayout = new FrameLayout(this.mContext);
        frameLayout.setLayoutParams(new LayoutParams(-1, -1));
        frameLayout.setBackgroundColor(-1);
        this.bPj = frameLayout;
        this.bPl = new C25688d();
        mo67377a(null);
        this.bPm = C8870e.m15839ax(activity);
        AppMethodBeat.m2505o(90789);
    }

    /* renamed from: xa */
    public final C8860e mo67383xa() {
        AppMethodBeat.m2504i(90790);
        if (this.bPk.size() > 0) {
            C8860e c8860e = (C8860e) this.bPk.peek();
            AppMethodBeat.m2505o(90790);
            return c8860e;
        }
        AppMethodBeat.m2505o(90790);
        return null;
    }

    public final void destroy() {
        AppMethodBeat.m2504i(90791);
        Iterator it = this.bPk.iterator();
        while (it.hasNext()) {
            ((C8860e) it.next()).destroy();
        }
        C32186k xd = m73366xd();
        if (xd != null) {
            xd.destroy();
        }
        C8870e.m15840ay(this.mContext);
        AppMethodBeat.m2505o(90791);
    }

    /* renamed from: bC */
    public final boolean mo60234bC(String str) {
        AppMethodBeat.m2504i(90792);
        boolean h = mo60236h(str, null);
        AppMethodBeat.m2505o(90792);
        return h;
    }

    /* renamed from: h */
    public final boolean mo60236h(String str, Bundle bundle) {
        AppMethodBeat.m2504i(90793);
        boolean a = mo67378a(str, bundle, !this.bPk.isEmpty());
        AppMethodBeat.m2505o(90793);
        return a;
    }

    /* renamed from: a */
    public final boolean mo67378a(String str, Bundle bundle, final boolean z) {
        AppMethodBeat.m2504i(90794);
        final C8860e j = this.bPn.mo23952j(str, bundle);
        this.bPj.addView(j.getContentView(), 0);
        j.getContentView().setVisibility(4);
        final C417081 c417081 = new Runnable() {
            boolean done = false;

            /* renamed from: com.tencent.luggage.d.f$1$1 */
            class C417051 implements Runnable {
                C417051() {
                }

                public final void run() {
                    AppMethodBeat.m2504i(90773);
                    C41707f.this.bPk.push(j);
                    C41707f.this.mo67384xc();
                    AppMethodBeat.m2505o(90773);
                }
            }

            public final void run() {
                AppMethodBeat.m2504i(90774);
                if (this.done) {
                    AppMethodBeat.m2505o(90774);
                    return;
                }
                this.done = true;
                if (C41707f.this.bPk.peek() != null && z) {
                    C8860e c8860e = (C8860e) C41707f.this.bPk.peek();
                    ObjectAnimator.ofFloat(c8860e.getContentView(), "translationX", new float[]{0.0f, -(((float) c8860e.getContentView().getWidth()) * 0.25f)}).setDuration(250);
                    ObjectAnimator.ofFloat(c8860e.getContentView(), "translationX", new float[]{0.0f}).setDuration(0);
                    AnimatorSet animatorSet = new AnimatorSet();
                    animatorSet.playSequentially(new Animator[]{r1, r2});
                    c8860e.mo20034a(animatorSet, null);
                    ((C8860e) C41707f.this.bPk.peek()).mo20046wV();
                }
                j.getContentView().bringToFront();
                j.getContentView().setVisibility(0);
                j.mo20044wT();
                C417051 c417051 = new C417051();
                if (z) {
                    C8860e c8860e2 = j;
                    ObjectAnimator.ofFloat(c8860e2.getContentView(), "translationX", new float[]{(float) c8860e2.getContentView().getWidth(), 0.0f}).setDuration(250);
                    ObjectAnimator.ofFloat(c8860e2.getContentView(), "alpha", new float[]{0.0f, 1.0f}).setDuration(166);
                    AnimatorSet animatorSet2 = new AnimatorSet();
                    animatorSet2.playTogether(new Animator[]{r2, r3});
                    c8860e2.mo20034a(animatorSet2, c417051);
                    AppMethodBeat.m2505o(90774);
                    return;
                }
                c417051.run();
                AppMethodBeat.m2505o(90774);
            }
        };
        j.bPd.mo72933a(new C6274e() {
            public final void onReady() {
                AppMethodBeat.m2504i(90775);
                c417081.run();
                AppMethodBeat.m2505o(90775);
            }
        });
        j.mo20038g(str, bundle);
        m73365d(c417081, 300);
        if (!z) {
            c417081.run();
        }
        AppMethodBeat.m2505o(90794);
        return true;
    }

    /* renamed from: xb */
    public final boolean mo60238xb() {
        AppMethodBeat.m2504i(90795);
        boolean aZ = mo60233aZ(true);
        AppMethodBeat.m2505o(90795);
        return aZ;
    }

    /* renamed from: aZ */
    public final boolean mo60233aZ(boolean z) {
        AppMethodBeat.m2504i(90796);
        if (this.bPk.size() <= 1) {
            AppMethodBeat.m2505o(90796);
            return false;
        }
        final C8860e c8860e = (C8860e) this.bPk.pop();
        if (z) {
            c8860e.mo20040h(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(90776);
                    C41707f.this.mo67376a(c8860e);
                    AppMethodBeat.m2505o(90776);
                }
            });
        } else {
            mo67376a(c8860e);
        }
        if (z) {
            ((C8860e) this.bPk.peek()).mo20037g(new C417064());
        } else {
            ((C8860e) this.bPk.peek()).mo20044wT();
        }
        AppMethodBeat.m2505o(90796);
        return true;
    }

    /* renamed from: bJ */
    public final boolean mo60235bJ(int i) {
        AppMethodBeat.m2504i(90797);
        if (i < 0) {
            AppMethodBeat.m2505o(90797);
            return true;
        } else if (this.bPk.size() <= 1 || this.bPk.size() <= i) {
            AppMethodBeat.m2505o(90797);
            return false;
        } else if (i == 0) {
            boolean aZ = mo60233aZ(false);
            AppMethodBeat.m2505o(90797);
            return aZ;
        } else {
            mo67376a((C8860e) this.bPk.remove(i));
            AppMethodBeat.m2505o(90797);
            return true;
        }
    }

    /* renamed from: i */
    public final boolean mo60237i(String str, Bundle bundle) {
        AppMethodBeat.m2504i(90798);
        C8860e c8860e = this.bPk.size() == 0 ? null : (C8860e) this.bPk.pop();
        if (c8860e != null) {
            mo67376a(c8860e);
        }
        boolean a = mo67378a(str, bundle, false);
        AppMethodBeat.m2505o(90798);
        return a;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: a */
    public final void mo67376a(final C8860e c8860e) {
        AppMethodBeat.m2504i(90799);
        this.bPj.post(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(90778);
                C41707f.this.bPj.removeView(c8860e.getContentView());
                AppMethodBeat.m2505o(90778);
            }
        });
        c8860e.destroy();
        AppMethodBeat.m2505o(90799);
    }

    /* renamed from: xc */
    public final void mo67384xc() {
        AppMethodBeat.m2504i(90800);
        if (this.bPo != null) {
            AppMethodBeat.m2505o(90800);
            return;
        }
        m73365d(new C256896(), 200);
        AppMethodBeat.m2505o(90800);
    }

    /* renamed from: xd */
    private C32186k m73366xd() {
        AppMethodBeat.m2504i(90801);
        Integer num = this.bPo;
        this.bPo = null;
        C32186k a = C17820m.m27869a(this.mContext, num);
        if (a == null || !a.bPy.equals(mo67385xe())) {
            AppMethodBeat.m2505o(90801);
            return null;
        }
        AppMethodBeat.m2505o(90801);
        return a;
    }

    /* renamed from: d */
    private void m73365d(Runnable runnable, long j) {
        AppMethodBeat.m2504i(90802);
        this.bPj.postDelayed(runnable, j);
        AppMethodBeat.m2505o(90802);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: xe */
    public final Class<? extends C37407a> mo67385xe() {
        if (this.bPp == null) {
            this.bPp = this.bPi == null ? C25703a.class : this.bPi;
        }
        return this.bPp;
    }

    /* renamed from: a */
    public final void mo67377a(C37398j c37398j) {
        AppMethodBeat.m2504i(90803);
        if (c37398j == null) {
            c37398j = new C178187();
        }
        this.bPn = c37398j;
        AppMethodBeat.m2505o(90803);
    }

    public void onResume() {
        AppMethodBeat.m2504i(90804);
        C8860e xa = mo67383xa();
        if (xa == null) {
            AppMethodBeat.m2505o(90804);
            return;
        }
        xa.mo20044wT();
        AppMethodBeat.m2505o(90804);
    }

    public final void onPause() {
        AppMethodBeat.m2504i(90805);
        C8860e xa = mo67383xa();
        if (xa == null) {
            AppMethodBeat.m2505o(90805);
            return;
        }
        xa.mo20046wV();
        AppMethodBeat.m2505o(90805);
    }

    /* renamed from: wY */
    public final boolean mo67382wY() {
        AppMethodBeat.m2504i(90806);
        C8860e xa = mo67383xa();
        if (xa == null) {
            AppMethodBeat.m2505o(90806);
            return false;
        } else if (xa.mo20048wX()) {
            AppMethodBeat.m2505o(90806);
            return true;
        } else if (this.bPk.size() > 1) {
            mo60233aZ(true);
            AppMethodBeat.m2505o(90806);
            return true;
        } else {
            AppMethodBeat.m2505o(90806);
            return false;
        }
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.m2504i(90807);
        this.bPm.onActivityResult(i, i2, intent);
        AppMethodBeat.m2505o(90807);
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: xf */
    public void mo63593xf() {
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: xg */
    public void mo63594xg() {
    }
}
