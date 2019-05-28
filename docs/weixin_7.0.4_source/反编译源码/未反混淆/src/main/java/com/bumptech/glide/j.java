package com.bumptech.glide;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import com.bumptech.glide.f.b;
import com.bumptech.glide.f.e;
import com.bumptech.glide.manager.c;
import com.bumptech.glide.manager.d;
import com.bumptech.glide.manager.h;
import com.bumptech.glide.manager.i;
import com.bumptech.glide.manager.m;
import com.bumptech.glide.manager.n;
import com.bumptech.glide.manager.o;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.Map.Entry;

public final class j implements i {
    private static final e awW = e.a(com.bumptech.glide.c.b.i.aBk).b(g.LOW).nQ();
    private static final e axk;
    private static final e axl;
    private final Handler awA;
    e awZ;
    protected final c awc;
    final h axm;
    final n axn;
    private final m axo;
    final o axp;
    private final Runnable axq;
    private final c axr;
    protected final Context context;

    static class a implements com.bumptech.glide.manager.c.a {
        private final n axn;

        a(n nVar) {
            this.axn = nVar;
        }

        public final void aw(boolean z) {
            AppMethodBeat.i(91651);
            if (z) {
                n nVar = this.axn;
                for (b bVar : com.bumptech.glide.h.j.d(nVar.aGR)) {
                    if (!(bVar.isComplete() || bVar.isCancelled())) {
                        bVar.pause();
                        if (nVar.isPaused) {
                            nVar.aGS.add(bVar);
                        } else {
                            bVar.begin();
                        }
                    }
                }
            }
            AppMethodBeat.o(91651);
        }
    }

    static {
        AppMethodBeat.i(91663);
        e w = e.w(Bitmap.class);
        w.aCf = true;
        axk = w;
        w = e.w(com.bumptech.glide.c.d.e.c.class);
        w.aCf = true;
        axl = w;
        AppMethodBeat.o(91663);
    }

    public j(c cVar, h hVar, m mVar, Context context) {
        this(cVar, hVar, mVar, new n(), cVar.awm, context);
        AppMethodBeat.i(91652);
        AppMethodBeat.o(91652);
    }

    private j(c cVar, h hVar, m mVar, n nVar, d dVar, Context context) {
        AppMethodBeat.i(91653);
        this.axp = new o();
        this.axq = new Runnable() {
            public final void run() {
                AppMethodBeat.i(91649);
                j.this.axm.a(j.this);
                AppMethodBeat.o(91649);
            }
        };
        this.awA = new Handler(Looper.getMainLooper());
        this.awc = cVar;
        this.axm = hVar;
        this.axo = mVar;
        this.axn = nVar;
        this.context = context;
        this.axr = dVar.a(context.getApplicationContext(), new a(nVar));
        if (com.bumptech.glide.h.j.oo()) {
            this.awA.post(this.axq);
        } else {
            hVar.a(this);
        }
        hVar.a(this.axr);
        this.awZ = cVar.awi.awv.nR().nS();
        synchronized (cVar.awn) {
            try {
                if (cVar.awn.contains(this)) {
                    Object illegalStateException = new IllegalStateException("Cannot register already registered manager");
                    throw illegalStateException;
                } else {
                    cVar.awn.add(this);
                }
            } finally {
                AppMethodBeat.o(91653);
            }
        }
        AppMethodBeat.o(91653);
    }

    public final void onDestroy() {
        AppMethodBeat.i(91656);
        this.axp.onDestroy();
        for (com.bumptech.glide.f.a.e c : com.bumptech.glide.h.j.d(this.axp.aGW)) {
            c(c);
        }
        this.axp.aGW.clear();
        n nVar = this.axn;
        for (b a : com.bumptech.glide.h.j.d(nVar.aGR)) {
            nVar.a(a, false);
        }
        nVar.aGS.clear();
        this.axm.b(this);
        this.axm.b(this.axr);
        this.awA.removeCallbacks(this.axq);
        c cVar = this.awc;
        synchronized (cVar.awn) {
            try {
                if (cVar.awn.contains(this)) {
                    cVar.awn.remove(this);
                } else {
                    Object illegalStateException = new IllegalStateException("Cannot unregister not yet registered manager");
                    throw illegalStateException;
                }
            } finally {
                AppMethodBeat.o(91656);
            }
        }
        AppMethodBeat.o(91656);
    }

    public final i<Bitmap> lI() {
        AppMethodBeat.i(91657);
        i a = new i(this.awc, this, Bitmap.class, this.context).a(axk);
        AppMethodBeat.o(91657);
        return a;
    }

    public final void c(final com.bumptech.glide.f.a.e<?> eVar) {
        AppMethodBeat.i(91658);
        if (eVar == null) {
            AppMethodBeat.o(91658);
        } else if (com.bumptech.glide.h.j.on()) {
            d(eVar);
            AppMethodBeat.o(91658);
        } else {
            this.awA.post(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(91650);
                    j.this.c(eVar);
                    AppMethodBeat.o(91650);
                }
            });
            AppMethodBeat.o(91658);
        }
    }

    private void d(com.bumptech.glide.f.a.e<?> eVar) {
        AppMethodBeat.i(91659);
        if (!(e(eVar) || this.awc.a((com.bumptech.glide.f.a.e) eVar) || eVar.og() == null)) {
            b og = eVar.og();
            eVar.h(null);
            og.clear();
        }
        AppMethodBeat.o(91659);
    }

    /* Access modifiers changed, original: final */
    public final boolean e(com.bumptech.glide.f.a.e<?> eVar) {
        AppMethodBeat.i(91660);
        b og = eVar.og();
        if (og == null) {
            AppMethodBeat.o(91660);
            return true;
        } else if (this.axn.a(og, true)) {
            this.axp.f(eVar);
            eVar.h(null);
            AppMethodBeat.o(91660);
            return true;
        } else {
            AppMethodBeat.o(91660);
            return false;
        }
    }

    /* Access modifiers changed, original: final */
    public final <T> k<?, T> k(Class<T> cls) {
        AppMethodBeat.i(91661);
        e eVar = this.awc.awi;
        k<?, T> kVar = (k) eVar.awp.get(cls);
        if (kVar == null) {
            k<?, T> kVar2;
            Iterator it = eVar.awp.entrySet().iterator();
            while (true) {
                kVar2 = kVar;
                if (!it.hasNext()) {
                    break;
                }
                Entry entry = (Entry) it.next();
                if (((Class) entry.getKey()).isAssignableFrom(cls)) {
                    kVar = (k) entry.getValue();
                } else {
                    kVar = kVar2;
                }
            }
            kVar = kVar2;
        }
        if (kVar == null) {
            kVar = e.awz;
        }
        AppMethodBeat.o(91661);
        return kVar;
    }

    public final String toString() {
        AppMethodBeat.i(91662);
        String str = super.toString() + "{tracker=" + this.axn + ", treeNode=" + this.axo + "}";
        AppMethodBeat.o(91662);
        return str;
    }

    public final void onStart() {
        AppMethodBeat.i(91654);
        com.bumptech.glide.h.j.om();
        n nVar = this.axn;
        nVar.isPaused = false;
        for (b bVar : com.bumptech.glide.h.j.d(nVar.aGR)) {
            if (!(bVar.isComplete() || bVar.isCancelled() || bVar.isRunning())) {
                bVar.begin();
            }
        }
        nVar.aGS.clear();
        this.axp.onStart();
        AppMethodBeat.o(91654);
    }

    public final void onStop() {
        AppMethodBeat.i(91655);
        com.bumptech.glide.h.j.om();
        n nVar = this.axn;
        nVar.isPaused = true;
        for (b bVar : com.bumptech.glide.h.j.d(nVar.aGR)) {
            if (bVar.isRunning()) {
                bVar.pause();
                nVar.aGS.add(bVar);
            }
        }
        this.axp.onStop();
        AppMethodBeat.o(91655);
    }
}
