package com.tencent.luggage.d;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import com.tencent.luggage.g.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.LinkedList;

public class f implements h {
    protected Class<? extends com.tencent.luggage.webview.a> bPi = com.tencent.mm.plugin.webview.luggage.d.a.class;
    public FrameLayout bPj;
    public a<e> bPk = new a(this, (byte) 0);
    protected d bPl;
    e bPm;
    public j bPn;
    Integer bPo = null;
    private Class<? extends com.tencent.luggage.webview.a> bPp = null;
    public g bPq = new g() {
        /* Access modifiers changed, original: final */
        public final Context getContext() {
            return f.this.mContext;
        }

        /* Access modifiers changed, original: final */
        public final Class<? extends com.tencent.luggage.webview.a> xe() {
            AppMethodBeat.i(90781);
            Class xe = f.this.xe();
            AppMethodBeat.o(90781);
            return xe;
        }

        public final LinkedList<e> xh() {
            return f.this.bPk;
        }

        public final h xi() {
            return f.this;
        }

        public final LinkedList<Class<? extends a>> xj() {
            AppMethodBeat.i(90782);
            LinkedList linkedList = (LinkedList) f.this.bPl.bPc.clone();
            AppMethodBeat.o(90782);
            return linkedList;
        }

        public final k xd() {
            AppMethodBeat.i(90783);
            k a = f.a(f.this);
            AppMethodBeat.o(90783);
            return a;
        }

        public final e xk() {
            return f.this.bPm;
        }
    };
    protected Context mContext;

    public class a<E> extends LinkedList<E> {
        private a() {
        }

        /* synthetic */ a(f fVar, byte b) {
            this();
        }

        public final E remove(int i) {
            AppMethodBeat.i(90784);
            Object remove = super.remove(i);
            f.this.xg();
            AppMethodBeat.o(90784);
            return remove;
        }

        public final E pop() {
            AppMethodBeat.i(90785);
            Object pop = super.pop();
            f.this.xg();
            AppMethodBeat.o(90785);
            return pop;
        }

        public final void push(E e) {
            AppMethodBeat.i(90786);
            super.push(e);
            f.this.xf();
            AppMethodBeat.o(90786);
        }

        public final boolean add(E e) {
            AppMethodBeat.i(90787);
            boolean add = super.add(e);
            if (add) {
                f.this.xf();
            }
            AppMethodBeat.o(90787);
            return add;
        }

        public final void add(int i, E e) {
            AppMethodBeat.i(90788);
            super.add(i, e);
            f.this.xf();
            AppMethodBeat.o(90788);
        }
    }

    public f(Activity activity) {
        AppMethodBeat.i(90789);
        this.mContext = activity;
        FrameLayout frameLayout = new FrameLayout(this.mContext);
        frameLayout.setLayoutParams(new LayoutParams(-1, -1));
        frameLayout.setBackgroundColor(-1);
        this.bPj = frameLayout;
        this.bPl = new d();
        a(null);
        this.bPm = e.ax(activity);
        AppMethodBeat.o(90789);
    }

    public final e xa() {
        AppMethodBeat.i(90790);
        if (this.bPk.size() > 0) {
            e eVar = (e) this.bPk.peek();
            AppMethodBeat.o(90790);
            return eVar;
        }
        AppMethodBeat.o(90790);
        return null;
    }

    public final void destroy() {
        AppMethodBeat.i(90791);
        Iterator it = this.bPk.iterator();
        while (it.hasNext()) {
            ((e) it.next()).destroy();
        }
        k xd = xd();
        if (xd != null) {
            xd.destroy();
        }
        e.ay(this.mContext);
        AppMethodBeat.o(90791);
    }

    public final boolean bC(String str) {
        AppMethodBeat.i(90792);
        boolean h = h(str, null);
        AppMethodBeat.o(90792);
        return h;
    }

    public final boolean h(String str, Bundle bundle) {
        AppMethodBeat.i(90793);
        boolean a = a(str, bundle, !this.bPk.isEmpty());
        AppMethodBeat.o(90793);
        return a;
    }

    public final boolean a(String str, Bundle bundle, final boolean z) {
        AppMethodBeat.i(90794);
        final e j = this.bPn.j(str, bundle);
        this.bPj.addView(j.getContentView(), 0);
        j.getContentView().setVisibility(4);
        final AnonymousClass1 anonymousClass1 = new Runnable() {
            boolean done = false;

            public final void run() {
                AppMethodBeat.i(90774);
                if (this.done) {
                    AppMethodBeat.o(90774);
                    return;
                }
                this.done = true;
                if (f.this.bPk.peek() != null && z) {
                    e eVar = (e) f.this.bPk.peek();
                    ObjectAnimator.ofFloat(eVar.getContentView(), "translationX", new float[]{0.0f, -(((float) eVar.getContentView().getWidth()) * 0.25f)}).setDuration(250);
                    ObjectAnimator.ofFloat(eVar.getContentView(), "translationX", new float[]{0.0f}).setDuration(0);
                    AnimatorSet animatorSet = new AnimatorSet();
                    animatorSet.playSequentially(new Animator[]{r1, r2});
                    eVar.a(animatorSet, null);
                    ((e) f.this.bPk.peek()).wV();
                }
                j.getContentView().bringToFront();
                j.getContentView().setVisibility(0);
                j.wT();
                AnonymousClass1 anonymousClass1 = new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(90773);
                        f.this.bPk.push(j);
                        f.this.xc();
                        AppMethodBeat.o(90773);
                    }
                };
                if (z) {
                    e eVar2 = j;
                    ObjectAnimator.ofFloat(eVar2.getContentView(), "translationX", new float[]{(float) eVar2.getContentView().getWidth(), 0.0f}).setDuration(250);
                    ObjectAnimator.ofFloat(eVar2.getContentView(), "alpha", new float[]{0.0f, 1.0f}).setDuration(166);
                    AnimatorSet animatorSet2 = new AnimatorSet();
                    animatorSet2.playTogether(new Animator[]{r2, r3});
                    eVar2.a(animatorSet2, anonymousClass1);
                    AppMethodBeat.o(90774);
                    return;
                }
                anonymousClass1.run();
                AppMethodBeat.o(90774);
            }
        };
        j.bPd.a(new i.e() {
            public final void onReady() {
                AppMethodBeat.i(90775);
                anonymousClass1.run();
                AppMethodBeat.o(90775);
            }
        });
        j.g(str, bundle);
        d(anonymousClass1, 300);
        if (!z) {
            anonymousClass1.run();
        }
        AppMethodBeat.o(90794);
        return true;
    }

    public final boolean xb() {
        AppMethodBeat.i(90795);
        boolean aZ = aZ(true);
        AppMethodBeat.o(90795);
        return aZ;
    }

    public final boolean aZ(boolean z) {
        AppMethodBeat.i(90796);
        if (this.bPk.size() <= 1) {
            AppMethodBeat.o(90796);
            return false;
        }
        final e eVar = (e) this.bPk.pop();
        if (z) {
            eVar.h(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(90776);
                    f.this.a(eVar);
                    AppMethodBeat.o(90776);
                }
            });
        } else {
            a(eVar);
        }
        if (z) {
            ((e) this.bPk.peek()).g(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(90777);
                    ((e) f.this.bPk.peek()).wT();
                    AppMethodBeat.o(90777);
                }
            });
        } else {
            ((e) this.bPk.peek()).wT();
        }
        AppMethodBeat.o(90796);
        return true;
    }

    public final boolean bJ(int i) {
        AppMethodBeat.i(90797);
        if (i < 0) {
            AppMethodBeat.o(90797);
            return true;
        } else if (this.bPk.size() <= 1 || this.bPk.size() <= i) {
            AppMethodBeat.o(90797);
            return false;
        } else if (i == 0) {
            boolean aZ = aZ(false);
            AppMethodBeat.o(90797);
            return aZ;
        } else {
            a((e) this.bPk.remove(i));
            AppMethodBeat.o(90797);
            return true;
        }
    }

    public final boolean i(String str, Bundle bundle) {
        AppMethodBeat.i(90798);
        e eVar = this.bPk.size() == 0 ? null : (e) this.bPk.pop();
        if (eVar != null) {
            a(eVar);
        }
        boolean a = a(str, bundle, false);
        AppMethodBeat.o(90798);
        return a;
    }

    /* Access modifiers changed, original: final */
    public final void a(final e eVar) {
        AppMethodBeat.i(90799);
        this.bPj.post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(90778);
                f.this.bPj.removeView(eVar.getContentView());
                AppMethodBeat.o(90778);
            }
        });
        eVar.destroy();
        AppMethodBeat.o(90799);
    }

    public final void xc() {
        AppMethodBeat.i(90800);
        if (this.bPo != null) {
            AppMethodBeat.o(90800);
            return;
        }
        d(new Runnable() {
            public final void run() {
                AppMethodBeat.i(90779);
                if (!((Activity) f.this.mContext).isFinishing()) {
                    f.this.bPo = m.a(f.this.mContext.getApplicationContext(), f.this.xe());
                }
                AppMethodBeat.o(90779);
            }
        }, 200);
        AppMethodBeat.o(90800);
    }

    private k xd() {
        AppMethodBeat.i(90801);
        Integer num = this.bPo;
        this.bPo = null;
        k a = m.a(this.mContext, num);
        if (a == null || !a.bPy.equals(xe())) {
            AppMethodBeat.o(90801);
            return null;
        }
        AppMethodBeat.o(90801);
        return a;
    }

    private void d(Runnable runnable, long j) {
        AppMethodBeat.i(90802);
        this.bPj.postDelayed(runnable, j);
        AppMethodBeat.o(90802);
    }

    /* Access modifiers changed, original: final */
    public final Class<? extends com.tencent.luggage.webview.a> xe() {
        if (this.bPp == null) {
            this.bPp = this.bPi == null ? com.tencent.luggage.webview.default_impl.a.class : this.bPi;
        }
        return this.bPp;
    }

    public final void a(j jVar) {
        AppMethodBeat.i(90803);
        if (jVar == null) {
            jVar = new j() {
                public final e j(String str, Bundle bundle) {
                    AppMethodBeat.i(90780);
                    n nVar = new n(f.this.bPq, bundle);
                    AppMethodBeat.o(90780);
                    return nVar;
                }
            };
        }
        this.bPn = jVar;
        AppMethodBeat.o(90803);
    }

    public void onResume() {
        AppMethodBeat.i(90804);
        e xa = xa();
        if (xa == null) {
            AppMethodBeat.o(90804);
            return;
        }
        xa.wT();
        AppMethodBeat.o(90804);
    }

    public final void onPause() {
        AppMethodBeat.i(90805);
        e xa = xa();
        if (xa == null) {
            AppMethodBeat.o(90805);
            return;
        }
        xa.wV();
        AppMethodBeat.o(90805);
    }

    public final boolean wY() {
        AppMethodBeat.i(90806);
        e xa = xa();
        if (xa == null) {
            AppMethodBeat.o(90806);
            return false;
        } else if (xa.wX()) {
            AppMethodBeat.o(90806);
            return true;
        } else if (this.bPk.size() > 1) {
            aZ(true);
            AppMethodBeat.o(90806);
            return true;
        } else {
            AppMethodBeat.o(90806);
            return false;
        }
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.i(90807);
        this.bPm.onActivityResult(i, i2, intent);
        AppMethodBeat.o(90807);
    }

    /* Access modifiers changed, original: protected */
    public void xf() {
    }

    /* Access modifiers changed, original: protected */
    public void xg() {
    }
}
