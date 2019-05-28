package com.bumptech.glide.c.b;

import android.os.Build.VERSION;
import android.util.Log;
import com.bumptech.glide.c.h;
import com.bumptech.glide.c.j;
import com.bumptech.glide.c.l;
import com.bumptech.glide.c.m;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;

public final class g<R> implements com.bumptech.glide.c.b.e.a, com.bumptech.glide.h.a.a.c, Comparable<g<?>>, Runnable {
    private Thread aAA;
    h aAB;
    private h aAC;
    private Object aAD;
    private com.bumptech.glide.c.a aAE;
    private com.bumptech.glide.c.a.d<?> aAF;
    public volatile e aAG;
    private volatile boolean aAH;
    h aAb;
    j aAd;
    final d aAg;
    com.bumptech.glide.g aAk;
    i aAl;
    final f<R> aAo = new f();
    private final List<Throwable> aAp = new ArrayList();
    private final com.bumptech.glide.h.a.b aAq = new com.bumptech.glide.h.a.b.a();
    private final android.support.v4.f.k.a<g<?>> aAr;
    final c<?> aAs = new c();
    final e aAt = new e();
    m aAu;
    a<R> aAv;
    private g aAw;
    f aAx;
    private long aAy;
    boolean aAz;
    com.bumptech.glide.e awi;
    Object axb;
    int height;
    public volatile boolean isCancelled;
    int order;
    int width;

    interface a<R> {
        void a(g<?> gVar);

        void a(p pVar);

        void c(u<R> uVar, com.bumptech.glide.c.a aVar);
    }

    final class b<Z> implements a<Z> {
        private final com.bumptech.glide.c.a aAL;

        b(com.bumptech.glide.c.a aVar) {
            this.aAL = aVar;
        }

        public final u<Z> a(u<Z> uVar) {
            u<Z> a;
            Object obj;
            com.bumptech.glide.c.c b;
            l lVar;
            com.bumptech.glide.h.d dVar;
            AppMethodBeat.i(91773);
            g gVar = g.this;
            com.bumptech.glide.c.a aVar = this.aAL;
            Class cls = uVar.get().getClass();
            m mVar = null;
            if (aVar != com.bumptech.glide.c.a.RESOURCE_DISK_CACHE) {
                mVar = gVar.aAo.n(cls);
                a = mVar.a(gVar.awi, uVar, gVar.width, gVar.height);
            } else {
                a = uVar;
            }
            if (!uVar.equals(a)) {
                uVar.recycle();
            }
            if (gVar.aAo.awi.awj.awP.v(a.mK()) != null) {
                obj = 1;
            } else {
                obj = null;
            }
            if (obj != null) {
                l v = gVar.aAo.awi.awj.awP.v(a.mK());
                if (v != null) {
                    b = v.b(gVar.aAd);
                    lVar = v;
                } else {
                    dVar = new com.bumptech.glide.h.d(a.mK());
                    AppMethodBeat.o(91773);
                    throw dVar;
                }
            }
            b = com.bumptech.glide.c.c.NONE;
            lVar = null;
            f fVar = gVar.aAo;
            h hVar = gVar.aAB;
            List mo = fVar.mo();
            int size = mo.size();
            for (int i = 0; i < size; i++) {
                if (((com.bumptech.glide.c.c.n.a) mo.get(i)).azW.equals(hVar)) {
                    obj = 1;
                    break;
                }
            }
            obj = null;
            if (gVar.aAl.a(obj == null, aVar, b)) {
                if (lVar == null) {
                    dVar = new com.bumptech.glide.h.d(a.get().getClass());
                    AppMethodBeat.o(91773);
                    throw dVar;
                }
                h cVar;
                switch (b) {
                    case SOURCE:
                        cVar = new c(gVar.aAB, gVar.aAb);
                        break;
                    case TRANSFORMED:
                        cVar = new w(gVar.aAo.awi.awk, gVar.aAB, gVar.aAb, gVar.width, gVar.height, mVar, cls, gVar.aAd);
                        break;
                    default:
                        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Unknown strategy: ".concat(String.valueOf(b)));
                        AppMethodBeat.o(91773);
                        throw illegalArgumentException;
                }
                a = t.d(a);
                c cVar2 = gVar.aAs;
                cVar2.azP = cVar;
                cVar2.aAN = lVar;
                cVar2.aAO = a;
            }
            AppMethodBeat.o(91773);
            return a;
        }
    }

    static class c<Z> {
        l<Z> aAN;
        t<Z> aAO;
        h azP;

        c() {
        }

        /* Access modifiers changed, original: final */
        public final void a(d dVar, j jVar) {
            AppMethodBeat.i(91774);
            try {
                dVar.mn().a(this.azP, new d(this.aAN, this.aAO, jVar));
            } finally {
                this.aAO.unlock();
                AppMethodBeat.o(91774);
            }
        }

        /* Access modifiers changed, original: final */
        public final boolean mz() {
            return this.aAO != null;
        }

        /* Access modifiers changed, original: final */
        public final void clear() {
            this.azP = null;
            this.aAN = null;
            this.aAO = null;
        }
    }

    static class e {
        private boolean aAP;
        private boolean aAQ;
        private boolean aAR;

        e() {
        }

        /* Access modifiers changed, original: final|declared_synchronized */
        public final synchronized boolean mA() {
            boolean mD;
            AppMethodBeat.i(91775);
            this.aAP = true;
            mD = mD();
            AppMethodBeat.o(91775);
            return mD;
        }

        /* Access modifiers changed, original: final|declared_synchronized */
        public final synchronized boolean mB() {
            boolean mD;
            AppMethodBeat.i(91776);
            this.aAQ = true;
            mD = mD();
            AppMethodBeat.o(91776);
            return mD;
        }

        /* Access modifiers changed, original: final|declared_synchronized */
        public final synchronized boolean mC() {
            boolean mD;
            AppMethodBeat.i(91777);
            this.aAR = true;
            mD = mD();
            AppMethodBeat.o(91777);
            return mD;
        }

        /* Access modifiers changed, original: final|declared_synchronized */
        public final synchronized void reset() {
            this.aAQ = false;
            this.aAP = false;
            this.aAR = false;
        }

        private boolean mD() {
            return (this.aAR || this.aAQ) && this.aAP;
        }
    }

    interface d {
        com.bumptech.glide.c.b.b.a mn();
    }

    enum f {
        INITIALIZE,
        SWITCH_TO_SOURCE_SERVICE,
        DECODE_DATA;

        static {
            AppMethodBeat.o(91780);
        }
    }

    enum g {
        INITIALIZE,
        RESOURCE_CACHE,
        DATA_CACHE,
        SOURCE,
        ENCODE,
        FINISHED;

        static {
            AppMethodBeat.o(91783);
        }
    }

    public final /* synthetic */ int compareTo(Object obj) {
        AppMethodBeat.i(91803);
        g gVar = (g) obj;
        int ordinal = this.aAk.ordinal() - gVar.aAk.ordinal();
        if (ordinal == 0) {
            ordinal = this.order - gVar.order;
        }
        AppMethodBeat.o(91803);
        return ordinal;
    }

    g(d dVar, android.support.v4.f.k.a<g<?>> aVar) {
        AppMethodBeat.i(91784);
        this.aAg = dVar;
        this.aAr = aVar;
        AppMethodBeat.o(91784);
    }

    private void mq() {
        AppMethodBeat.i(91785);
        if (this.aAt.mB()) {
            ms();
        }
        AppMethodBeat.o(91785);
    }

    private void mr() {
        AppMethodBeat.i(91786);
        if (this.aAt.mC()) {
            ms();
        }
        AppMethodBeat.o(91786);
    }

    /* Access modifiers changed, original: final */
    public final void ms() {
        AppMethodBeat.i(91787);
        this.aAt.reset();
        this.aAs.clear();
        this.aAo.clear();
        this.aAH = false;
        this.awi = null;
        this.aAb = null;
        this.aAd = null;
        this.aAk = null;
        this.aAu = null;
        this.aAv = null;
        this.aAw = null;
        this.aAG = null;
        this.aAA = null;
        this.aAB = null;
        this.aAD = null;
        this.aAE = null;
        this.aAF = null;
        this.aAy = 0;
        this.isCancelled = false;
        this.axb = null;
        this.aAp.clear();
        this.aAr.release(this);
        AppMethodBeat.o(91787);
    }

    public final void run() {
        AppMethodBeat.i(91788);
        com.bumptech.glide.c.a.d dVar = this.aAF;
        try {
            if (this.isCancelled) {
                mv();
            }
            switch (this.aAx) {
                case INITIALIZE:
                    this.aAw = a(g.INITIALIZE);
                    this.aAG = mt();
                    mu();
                    break;
                case SWITCH_TO_SOURCE_SERVICE:
                    mu();
                    break;
                case DECODE_DATA:
                    mx();
                    break;
                default:
                    IllegalStateException illegalStateException = new IllegalStateException("Unrecognized run reason: " + this.aAx);
                    AppMethodBeat.o(91788);
                    throw illegalStateException;
            }
            if (dVar != null) {
                dVar.cleanup();
            }
            AppMethodBeat.o(91788);
        } catch (Throwable th) {
            if (Log.isLoggable("DecodeJob", 3)) {
                new StringBuilder("DecodeJob threw unexpectedly, isCancelled: ").append(this.isCancelled).append(", stage: ").append(this.aAw);
            }
            if (this.aAw != g.ENCODE) {
                this.aAp.add(th);
                mv();
            }
            if (!this.isCancelled) {
                AppMethodBeat.o(91788);
            }
        } finally {
            if (dVar != null) {
                dVar.cleanup();
            }
            AppMethodBeat.o(91788);
        }
    }

    private e mt() {
        AppMethodBeat.i(91789);
        e bVar;
        switch (this.aAw) {
            case RESOURCE_CACHE:
                v vVar = new v(this.aAo, this);
                AppMethodBeat.o(91789);
                return vVar;
            case DATA_CACHE:
                bVar = new b(this.aAo, this);
                AppMethodBeat.o(91789);
                return bVar;
            case SOURCE:
                bVar = new y(this.aAo, this);
                AppMethodBeat.o(91789);
                return bVar;
            case FINISHED:
                AppMethodBeat.o(91789);
                return null;
            default:
                IllegalStateException illegalStateException = new IllegalStateException("Unrecognized stage: " + this.aAw);
                AppMethodBeat.o(91789);
                throw illegalStateException;
        }
    }

    private void mu() {
        AppMethodBeat.i(91790);
        this.aAA = Thread.currentThread();
        this.aAy = com.bumptech.glide.h.e.ok();
        boolean z = false;
        while (!this.isCancelled && this.aAG != null) {
            z = this.aAG.mk();
            if (z) {
                break;
            }
            this.aAw = a(this.aAw);
            this.aAG = mt();
            if (this.aAw == g.SOURCE) {
                mm();
                AppMethodBeat.o(91790);
                return;
            }
        }
        if ((this.aAw == g.FINISHED || this.isCancelled) && !r0) {
            mv();
        }
        AppMethodBeat.o(91790);
    }

    private void mv() {
        AppMethodBeat.i(91791);
        mw();
        this.aAv.a(new p("Failed to load resource", new ArrayList(this.aAp)));
        mr();
        AppMethodBeat.o(91791);
    }

    private void a(u<R> uVar, com.bumptech.glide.c.a aVar) {
        AppMethodBeat.i(91792);
        mw();
        this.aAv.c(uVar, aVar);
        AppMethodBeat.o(91792);
    }

    private void mw() {
        AppMethodBeat.i(91793);
        this.aAq.oq();
        if (this.aAH) {
            IllegalStateException illegalStateException = new IllegalStateException("Already notified");
            AppMethodBeat.o(91793);
            throw illegalStateException;
        }
        this.aAH = true;
        AppMethodBeat.o(91793);
    }

    /* Access modifiers changed, original: final */
    public final g a(g gVar) {
        AppMethodBeat.i(91794);
        while (true) {
            g gVar2;
            switch (gVar) {
                case RESOURCE_CACHE:
                    if (!this.aAl.mF()) {
                        gVar = g.DATA_CACHE;
                        break;
                    }
                    gVar2 = g.DATA_CACHE;
                    AppMethodBeat.o(91794);
                    return gVar2;
                case DATA_CACHE:
                    if (this.aAz) {
                        gVar2 = g.FINISHED;
                        AppMethodBeat.o(91794);
                        return gVar2;
                    }
                    gVar2 = g.SOURCE;
                    AppMethodBeat.o(91794);
                    return gVar2;
                case SOURCE:
                case FINISHED:
                    gVar2 = g.FINISHED;
                    AppMethodBeat.o(91794);
                    return gVar2;
                case INITIALIZE:
                    if (!this.aAl.mE()) {
                        gVar = g.RESOURCE_CACHE;
                        break;
                    }
                    gVar2 = g.RESOURCE_CACHE;
                    AppMethodBeat.o(91794);
                    return gVar2;
                default:
                    IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Unrecognized stage: ".concat(String.valueOf(gVar)));
                    AppMethodBeat.o(91794);
                    throw illegalArgumentException;
            }
        }
    }

    public final void mm() {
        AppMethodBeat.i(91795);
        this.aAx = f.SWITCH_TO_SOURCE_SERVICE;
        this.aAv.a(this);
        AppMethodBeat.o(91795);
    }

    public final void a(h hVar, Object obj, com.bumptech.glide.c.a.d<?> dVar, com.bumptech.glide.c.a aVar, h hVar2) {
        AppMethodBeat.i(91796);
        this.aAB = hVar;
        this.aAD = obj;
        this.aAF = dVar;
        this.aAE = aVar;
        this.aAC = hVar2;
        if (Thread.currentThread() != this.aAA) {
            this.aAx = f.DECODE_DATA;
            this.aAv.a(this);
            AppMethodBeat.o(91796);
            return;
        }
        try {
            mx();
        } finally {
            AppMethodBeat.o(91796);
        }
    }

    public final void a(h hVar, Exception exception, com.bumptech.glide.c.a.d<?> dVar, com.bumptech.glide.c.a aVar) {
        AppMethodBeat.i(91797);
        dVar.cleanup();
        p pVar = new p("Fetching data failed", (Throwable) exception);
        pVar.a(hVar, aVar, dVar.mg());
        this.aAp.add(pVar);
        if (Thread.currentThread() != this.aAA) {
            this.aAx = f.SWITCH_TO_SOURCE_SERVICE;
            this.aAv.a(this);
            AppMethodBeat.o(91797);
            return;
        }
        mu();
        AppMethodBeat.o(91797);
    }

    private void mx() {
        u a;
        AppMethodBeat.i(91798);
        if (Log.isLoggable("DecodeJob", 2)) {
            a("Retrieved data", this.aAy, "data: " + this.aAD + ", cache key: " + this.aAB + ", fetcher: " + this.aAF);
        }
        try {
            a = a(this.aAF, this.aAD, this.aAE);
        } catch (p e) {
            e.a(this.aAC, this.aAE, null);
            this.aAp.add(e);
            a = null;
        }
        if (a != null) {
            b(a, this.aAE);
            AppMethodBeat.o(91798);
            return;
        }
        mu();
        AppMethodBeat.o(91798);
    }

    private void b(u<R> uVar, com.bumptech.glide.c.a aVar) {
        u uVar2;
        AppMethodBeat.i(91799);
        if (uVar2 instanceof q) {
            ((q) uVar2).initialize();
        }
        t tVar = null;
        if (this.aAs.mz()) {
            t d = t.d(uVar2);
            tVar = d;
            uVar2 = d;
        }
        a(uVar2, aVar);
        this.aAw = g.ENCODE;
        try {
            if (this.aAs.mz()) {
                this.aAs.a(this.aAg, this.aAd);
            }
            if (tVar != null) {
                tVar.unlock();
            }
            mq();
            AppMethodBeat.o(91799);
        } catch (Throwable th) {
            if (tVar != null) {
                tVar.unlock();
            }
            AppMethodBeat.o(91799);
        }
    }

    private <Data> u<R> a(com.bumptech.glide.c.a.d<?> dVar, Data data, com.bumptech.glide.c.a aVar) {
        u<R> uVar = null;
        AppMethodBeat.i(91800);
        if (data == null) {
            dVar.cleanup();
            AppMethodBeat.o(91800);
        } else {
            try {
                long ok = com.bumptech.glide.h.e.ok();
                uVar = a((Object) data, aVar, this.aAo.m(data.getClass()));
                if (Log.isLoggable("DecodeJob", 2)) {
                    a("Decoded result ".concat(String.valueOf(uVar)), ok, null);
                }
                dVar.cleanup();
                AppMethodBeat.o(91800);
            } catch (Throwable th) {
                dVar.cleanup();
                AppMethodBeat.o(91800);
            }
        }
        return uVar;
    }

    private void a(String str, long j, String str2) {
        AppMethodBeat.i(91802);
        new StringBuilder().append(str).append(" in ").append(com.bumptech.glide.h.e.q(j)).append(", load key: ").append(this.aAu).append(str2 != null ? ", ".concat(String.valueOf(str2)) : "").append(", thread: ").append(Thread.currentThread().getName());
        AppMethodBeat.o(91802);
    }

    public final com.bumptech.glide.h.a.b my() {
        return this.aAq;
    }

    private <Data, ResourceType> u<R> a(Data data, com.bumptech.glide.c.a aVar, s<Data, ResourceType, R> sVar) {
        AppMethodBeat.i(91801);
        j jVar = this.aAd;
        if (VERSION.SDK_INT >= 26 && jVar.a(com.bumptech.glide.c.d.a.h.aFo) == null && (aVar == com.bumptech.glide.c.a.RESOURCE_DISK_CACHE || this.aAo.aAn)) {
            jVar = new j();
            jVar.a(this.aAd);
            jVar.azh.put(com.bumptech.glide.c.d.a.h.aFo, Boolean.TRUE);
        }
        com.bumptech.glide.c.a.e T = this.awi.awj.awQ.T(data);
        try {
            u<R> a = sVar.a(T, jVar, this.width, this.height, new b(aVar));
            return a;
        } finally {
            T.cleanup();
            AppMethodBeat.o(91801);
        }
    }
}
