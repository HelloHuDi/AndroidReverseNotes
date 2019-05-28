package com.bumptech.glide;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import com.bumptech.glide.manager.C0783h;
import com.bumptech.glide.manager.C0784i;
import com.bumptech.glide.manager.C25466n;
import com.bumptech.glide.manager.C31979c;
import com.bumptech.glide.manager.C31979c.C31980a;
import com.bumptech.glide.manager.C37198d;
import com.bumptech.glide.manager.C37200m;
import com.bumptech.glide.manager.C8567o;
import com.bumptech.glide.p086c.p088b.C31938i;
import com.bumptech.glide.p086c.p092d.p788e.C37186c;
import com.bumptech.glide.p095h.C45002j;
import com.bumptech.glide.p791f.C17553b;
import com.bumptech.glide.p791f.C41570e;
import com.bumptech.glide.p791f.p1156a.C17551e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.Map.Entry;

/* renamed from: com.bumptech.glide.j */
public final class C8565j implements C0784i {
    private static final C41570e awW = C41570e.m72766a(C31938i.aBk).mo66586b(C37192g.LOW).mo66591nQ();
    private static final C41570e axk;
    private static final C41570e axl;
    private final Handler awA;
    C41570e awZ;
    protected final C8555c awc;
    final C0783h axm;
    final C25466n axn;
    private final C37200m axo;
    final C8567o axp;
    private final Runnable axq;
    private final C31979c axr;
    protected final Context context;

    /* renamed from: com.bumptech.glide.j$a */
    static class C8564a implements C31980a {
        private final C25466n axn;

        C8564a(C25466n c25466n) {
            this.axn = c25466n;
        }

        /* renamed from: aw */
        public final void mo18673aw(boolean z) {
            AppMethodBeat.m2504i(91651);
            if (z) {
                C25466n c25466n = this.axn;
                for (C17553b c17553b : C45002j.m82418d(c25466n.aGR)) {
                    if (!(c17553b.isComplete() || c17553b.isCancelled())) {
                        c17553b.pause();
                        if (c25466n.isPaused) {
                            c25466n.aGS.add(c17553b);
                        } else {
                            c17553b.begin();
                        }
                    }
                }
            }
            AppMethodBeat.m2505o(91651);
        }
    }

    /* renamed from: com.bumptech.glide.j$1 */
    class C85661 implements Runnable {
        C85661() {
        }

        public final void run() {
            AppMethodBeat.m2504i(91649);
            C8565j.this.axm.mo2254a(C8565j.this);
            AppMethodBeat.m2505o(91649);
        }
    }

    static {
        AppMethodBeat.m2504i(91663);
        C41570e w = C41570e.m72770w(Bitmap.class);
        w.aCf = true;
        axk = w;
        w = C41570e.m72770w(C37186c.class);
        w.aCf = true;
        axl = w;
        AppMethodBeat.m2505o(91663);
    }

    public C8565j(C8555c c8555c, C0783h c0783h, C37200m c37200m, Context context) {
        this(c8555c, c0783h, c37200m, new C25466n(), c8555c.awm, context);
        AppMethodBeat.m2504i(91652);
        AppMethodBeat.m2505o(91652);
    }

    private C8565j(C8555c c8555c, C0783h c0783h, C37200m c37200m, C25466n c25466n, C37198d c37198d, Context context) {
        AppMethodBeat.m2504i(91653);
        this.axp = new C8567o();
        this.axq = new C85661();
        this.awA = new Handler(Looper.getMainLooper());
        this.awc = c8555c;
        this.axm = c0783h;
        this.axo = c37200m;
        this.axn = c25466n;
        this.context = context;
        this.axr = c37198d.mo31994a(context.getApplicationContext(), new C8564a(c25466n));
        if (C45002j.m82428oo()) {
            this.awA.post(this.axq);
        } else {
            c0783h.mo2254a(this);
        }
        c0783h.mo2254a(this.axr);
        this.awZ = c8555c.awi.awv.mo66592nR().mo66593nS();
        synchronized (c8555c.awn) {
            try {
                if (c8555c.awn.contains(this)) {
                    Object illegalStateException = new IllegalStateException("Cannot register already registered manager");
                    throw illegalStateException;
                } else {
                    c8555c.awn.add(this);
                }
            } finally {
                AppMethodBeat.m2505o(91653);
            }
        }
        AppMethodBeat.m2505o(91653);
    }

    public final void onDestroy() {
        AppMethodBeat.m2504i(91656);
        this.axp.onDestroy();
        for (C17551e c : C45002j.m82418d(this.axp.aGW)) {
            mo18674c(c);
        }
        this.axp.aGW.clear();
        C25466n c25466n = this.axn;
        for (C17553b a : C45002j.m82418d(c25466n.aGR)) {
            c25466n.mo42517a(a, false);
        }
        c25466n.aGS.clear();
        this.axm.mo2255b(this);
        this.axm.mo2255b(this.axr);
        this.awA.removeCallbacks(this.axq);
        C8555c c8555c = this.awc;
        synchronized (c8555c.awn) {
            try {
                if (c8555c.awn.contains(this)) {
                    c8555c.awn.remove(this);
                } else {
                    Object illegalStateException = new IllegalStateException("Cannot unregister not yet registered manager");
                    throw illegalStateException;
                }
            } finally {
                AppMethodBeat.m2505o(91656);
            }
        }
        AppMethodBeat.m2505o(91656);
    }

    /* renamed from: lI */
    public final C8562i<Bitmap> mo18677lI() {
        AppMethodBeat.m2504i(91657);
        C8562i a = new C8562i(this.awc, this, Bitmap.class, this.context).mo18670a(axk);
        AppMethodBeat.m2505o(91657);
        return a;
    }

    /* renamed from: c */
    public final void mo18674c(final C17551e<?> c17551e) {
        AppMethodBeat.m2504i(91658);
        if (c17551e == null) {
            AppMethodBeat.m2505o(91658);
        } else if (C45002j.m82427on()) {
            m15228d(c17551e);
            AppMethodBeat.m2505o(91658);
        } else {
            this.awA.post(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(91650);
                    C8565j.this.mo18674c(c17551e);
                    AppMethodBeat.m2505o(91650);
                }
            });
            AppMethodBeat.m2505o(91658);
        }
    }

    /* renamed from: d */
    private void m15228d(C17551e<?> c17551e) {
        AppMethodBeat.m2504i(91659);
        if (!(mo18675e(c17551e) || this.awc.mo18656a((C17551e) c17551e) || c17551e.mo31978og() == null)) {
            C17553b og = c17551e.mo31978og();
            c17551e.mo31977h(null);
            og.clear();
        }
        AppMethodBeat.m2505o(91659);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: e */
    public final boolean mo18675e(C17551e<?> c17551e) {
        AppMethodBeat.m2504i(91660);
        C17553b og = c17551e.mo31978og();
        if (og == null) {
            AppMethodBeat.m2505o(91660);
            return true;
        } else if (this.axn.mo42517a(og, true)) {
            this.axp.mo18680f(c17551e);
            c17551e.mo31977h(null);
            AppMethodBeat.m2505o(91660);
            return true;
        } else {
            AppMethodBeat.m2505o(91660);
            return false;
        }
    }

    /* Access modifiers changed, original: final */
    /* renamed from: k */
    public final <T> C25465k<?, T> mo18676k(Class<T> cls) {
        AppMethodBeat.m2504i(91661);
        C37191e c37191e = this.awc.awi;
        C25465k<?, T> c25465k = (C25465k) c37191e.awp.get(cls);
        if (c25465k == null) {
            C25465k<?, T> c25465k2;
            Iterator it = c37191e.awp.entrySet().iterator();
            while (true) {
                c25465k2 = c25465k;
                if (!it.hasNext()) {
                    break;
                }
                Entry entry = (Entry) it.next();
                if (((Class) entry.getKey()).isAssignableFrom(cls)) {
                    c25465k = (C25465k) entry.getValue();
                } else {
                    c25465k = c25465k2;
                }
            }
            c25465k = c25465k2;
        }
        if (c25465k == null) {
            c25465k = C37191e.awz;
        }
        AppMethodBeat.m2505o(91661);
        return c25465k;
    }

    public final String toString() {
        AppMethodBeat.m2504i(91662);
        String str = super.toString() + "{tracker=" + this.axn + ", treeNode=" + this.axo + "}";
        AppMethodBeat.m2505o(91662);
        return str;
    }

    public final void onStart() {
        AppMethodBeat.m2504i(91654);
        C45002j.m82426om();
        C25466n c25466n = this.axn;
        c25466n.isPaused = false;
        for (C17553b c17553b : C45002j.m82418d(c25466n.aGR)) {
            if (!(c17553b.isComplete() || c17553b.isCancelled() || c17553b.isRunning())) {
                c17553b.begin();
            }
        }
        c25466n.aGS.clear();
        this.axp.onStart();
        AppMethodBeat.m2505o(91654);
    }

    public final void onStop() {
        AppMethodBeat.m2504i(91655);
        C45002j.m82426om();
        C25466n c25466n = this.axn;
        c25466n.isPaused = true;
        for (C17553b c17553b : C45002j.m82418d(c25466n.aGR)) {
            if (c17553b.isRunning()) {
                c17553b.pause();
                c25466n.aGS.add(c17553b);
            }
        }
        this.axp.onStop();
        AppMethodBeat.m2505o(91655);
    }
}
