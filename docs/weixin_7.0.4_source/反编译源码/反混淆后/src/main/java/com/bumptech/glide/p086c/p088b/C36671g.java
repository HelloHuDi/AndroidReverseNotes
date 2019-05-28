package com.bumptech.glide.p086c.p088b;

import android.os.Build.VERSION;
import android.support.p057v4.p065f.C37122k.C8387a;
import android.util.Log;
import com.bumptech.glide.C31976h.C31245d;
import com.bumptech.glide.C37191e;
import com.bumptech.glide.C37192g;
import com.bumptech.glide.p086c.C0779h;
import com.bumptech.glide.p086c.C25405a;
import com.bumptech.glide.p086c.C31967j;
import com.bumptech.glide.p086c.C31969l;
import com.bumptech.glide.p086c.C31970m;
import com.bumptech.glide.p086c.C44994c;
import com.bumptech.glide.p086c.p087a.C0742d;
import com.bumptech.glide.p086c.p087a.C8511e;
import com.bumptech.glide.p086c.p088b.C0753e.C0754a;
import com.bumptech.glide.p086c.p088b.C31937h.C8525a;
import com.bumptech.glide.p086c.p088b.p785b.C31932a;
import com.bumptech.glide.p086c.p090c.C37175n.C37176a;
import com.bumptech.glide.p086c.p092d.p093a.C31961h;
import com.bumptech.glide.p095h.C31975e;
import com.bumptech.glide.p095h.p1136a.C37193a.C31972c;
import com.bumptech.glide.p095h.p1136a.C41574b;
import com.bumptech.glide.p095h.p1136a.C41574b.C17561a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.bumptech.glide.c.b.g */
public final class C36671g<R> implements C0754a, C31972c, Comparable<C36671g<?>>, Runnable {
    private Thread aAA;
    C0779h aAB;
    private C0779h aAC;
    private Object aAD;
    private C25405a aAE;
    private C0742d<?> aAF;
    public volatile C0753e aAG;
    private volatile boolean aAH;
    C0779h aAb;
    C31967j aAd;
    final C31936d aAg;
    C37192g aAk;
    C31938i aAl;
    final C37168f<R> aAo = new C37168f();
    private final List<Throwable> aAp = new ArrayList();
    private final C41574b aAq = new C17561a();
    private final C8387a<C36671g<?>> aAr;
    final C17524c<?> aAs = new C17524c();
    final C17525e aAt = new C17525e();
    C8527m aAu;
    C17522a<R> aAv;
    private C36673g aAw;
    C36672f aAx;
    private long aAy;
    boolean aAz;
    C37191e awi;
    Object axb;
    int height;
    public volatile boolean isCancelled;
    int order;
    int width;

    /* renamed from: com.bumptech.glide.c.b.g$a */
    interface C17522a<R> {
        /* renamed from: a */
        void mo31951a(C36671g<?> c36671g);

        /* renamed from: a */
        void mo31952a(C37169p c37169p);

        /* renamed from: c */
        void mo31953c(C17526u<R> c17526u, C25405a c25405a);
    }

    /* renamed from: com.bumptech.glide.c.b.g$b */
    final class C17523b<Z> implements C8525a<Z> {
        private final C25405a aAL;

        C17523b(C25405a c25405a) {
            this.aAL = c25405a;
        }

        /* renamed from: a */
        public final C17526u<Z> mo18627a(C17526u<Z> c17526u) {
            C17526u<Z> a;
            Object obj;
            C44994c b;
            C31969l c31969l;
            C31245d c31245d;
            AppMethodBeat.m2504i(91773);
            C36671g c36671g = C36671g.this;
            C25405a c25405a = this.aAL;
            Class cls = c17526u.get().getClass();
            C31970m c31970m = null;
            if (c25405a != C25405a.RESOURCE_DISK_CACHE) {
                c31970m = c36671g.aAo.mo59250n(cls);
                a = c31970m.mo31965a(c36671g.awi, c17526u, c36671g.width, c36671g.height);
            } else {
                a = c17526u;
            }
            if (!c17526u.equals(a)) {
                c17526u.recycle();
            }
            if (c36671g.aAo.awi.awj.awP.mo42495v(a.mo2232mK()) != null) {
                obj = 1;
            } else {
                obj = null;
            }
            if (obj != null) {
                C31969l v = c36671g.aAo.awi.awj.awP.mo42495v(a.mo2232mK());
                if (v != null) {
                    b = v.mo2228b(c36671g.aAd);
                    c31969l = v;
                } else {
                    c31245d = new C31245d(a.mo2232mK());
                    AppMethodBeat.m2505o(91773);
                    throw c31245d;
                }
            }
            b = C44994c.NONE;
            c31969l = null;
            C37168f c37168f = c36671g.aAo;
            C0779h c0779h = c36671g.aAB;
            List mo = c37168f.mo59248mo();
            int size = mo.size();
            for (int i = 0; i < size; i++) {
                if (((C37176a) mo.get(i)).azW.equals(c0779h)) {
                    obj = 1;
                    break;
                }
            }
            obj = null;
            if (c36671g.aAl.mo2216a(obj == null, c25405a, b)) {
                if (c31969l == null) {
                    c31245d = new C31245d(a.get().getClass());
                    AppMethodBeat.m2505o(91773);
                    throw c31245d;
                }
                C0779h c25421c;
                switch (b) {
                    case SOURCE:
                        c25421c = new C25421c(c36671g.aAB, c36671g.aAb);
                        break;
                    case TRANSFORMED:
                        c25421c = new C41548w(c36671g.aAo.awi.awk, c36671g.aAB, c36671g.aAb, c36671g.width, c36671g.height, c31970m, cls, c36671g.aAd);
                        break;
                    default:
                        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Unknown strategy: ".concat(String.valueOf(b)));
                        AppMethodBeat.m2505o(91773);
                        throw illegalArgumentException;
                }
                a = C8529t.m15147d(a);
                C17524c c17524c = c36671g.aAs;
                c17524c.azP = c25421c;
                c17524c.aAN = c31969l;
                c17524c.aAO = a;
            }
            AppMethodBeat.m2505o(91773);
            return a;
        }
    }

    /* renamed from: com.bumptech.glide.c.b.g$c */
    static class C17524c<Z> {
        C31969l<Z> aAN;
        C8529t<Z> aAO;
        C0779h azP;

        C17524c() {
        }

        /* Access modifiers changed, original: final */
        /* renamed from: a */
        public final void mo31954a(C31936d c31936d, C31967j c31967j) {
            AppMethodBeat.m2504i(91774);
            try {
                c31936d.mo52051mn().mo52047a(this.azP, new C0752d(this.aAN, this.aAO, c31967j));
            } finally {
                this.aAO.unlock();
                AppMethodBeat.m2505o(91774);
            }
        }

        /* Access modifiers changed, original: final */
        /* renamed from: mz */
        public final boolean mo31956mz() {
            return this.aAO != null;
        }

        /* Access modifiers changed, original: final */
        public final void clear() {
            this.azP = null;
            this.aAN = null;
            this.aAO = null;
        }
    }

    /* renamed from: com.bumptech.glide.c.b.g$e */
    static class C17525e {
        private boolean aAP;
        private boolean aAQ;
        private boolean aAR;

        C17525e() {
        }

        /* Access modifiers changed, original: final|declared_synchronized */
        /* renamed from: mA */
        public final synchronized boolean mo31957mA() {
            boolean mD;
            AppMethodBeat.m2504i(91775);
            this.aAP = true;
            mD = m27359mD();
            AppMethodBeat.m2505o(91775);
            return mD;
        }

        /* Access modifiers changed, original: final|declared_synchronized */
        /* renamed from: mB */
        public final synchronized boolean mo31958mB() {
            boolean mD;
            AppMethodBeat.m2504i(91776);
            this.aAQ = true;
            mD = m27359mD();
            AppMethodBeat.m2505o(91776);
            return mD;
        }

        /* Access modifiers changed, original: final|declared_synchronized */
        /* renamed from: mC */
        public final synchronized boolean mo31959mC() {
            boolean mD;
            AppMethodBeat.m2504i(91777);
            this.aAR = true;
            mD = m27359mD();
            AppMethodBeat.m2505o(91777);
            return mD;
        }

        /* Access modifiers changed, original: final|declared_synchronized */
        public final synchronized void reset() {
            this.aAQ = false;
            this.aAP = false;
            this.aAR = false;
        }

        /* renamed from: mD */
        private boolean m27359mD() {
            return (this.aAR || this.aAQ) && this.aAP;
        }
    }

    /* renamed from: com.bumptech.glide.c.b.g$d */
    interface C31936d {
        /* renamed from: mn */
        C31932a mo52051mn();
    }

    /* renamed from: com.bumptech.glide.c.b.g$f */
    enum C36672f {
        INITIALIZE,
        SWITCH_TO_SOURCE_SERVICE,
        DECODE_DATA;

        static {
            AppMethodBeat.m2505o(91780);
        }
    }

    /* renamed from: com.bumptech.glide.c.b.g$g */
    enum C36673g {
        INITIALIZE,
        RESOURCE_CACHE,
        DATA_CACHE,
        SOURCE,
        ENCODE,
        FINISHED;

        static {
            AppMethodBeat.m2505o(91783);
        }
    }

    public final /* synthetic */ int compareTo(Object obj) {
        AppMethodBeat.m2504i(91803);
        C36671g c36671g = (C36671g) obj;
        int ordinal = this.aAk.ordinal() - c36671g.aAk.ordinal();
        if (ordinal == 0) {
            ordinal = this.order - c36671g.order;
        }
        AppMethodBeat.m2505o(91803);
        return ordinal;
    }

    C36671g(C31936d c31936d, C8387a<C36671g<?>> c8387a) {
        AppMethodBeat.m2504i(91784);
        this.aAg = c31936d;
        this.aAr = c8387a;
        AppMethodBeat.m2505o(91784);
    }

    /* renamed from: mq */
    private void m60810mq() {
        AppMethodBeat.m2504i(91785);
        if (this.aAt.mo31958mB()) {
            mo58537ms();
        }
        AppMethodBeat.m2505o(91785);
    }

    /* renamed from: mr */
    private void m60811mr() {
        AppMethodBeat.m2504i(91786);
        if (this.aAt.mo31959mC()) {
            mo58537ms();
        }
        AppMethodBeat.m2505o(91786);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: ms */
    public final void mo58537ms() {
        AppMethodBeat.m2504i(91787);
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
        AppMethodBeat.m2505o(91787);
    }

    public final void run() {
        AppMethodBeat.m2504i(91788);
        C0742d c0742d = this.aAF;
        try {
            if (this.isCancelled) {
                m60814mv();
            }
            switch (this.aAx) {
                case INITIALIZE:
                    this.aAw = mo58535a(C36673g.INITIALIZE);
                    this.aAG = m60812mt();
                    m60813mu();
                    break;
                case SWITCH_TO_SOURCE_SERVICE:
                    m60813mu();
                    break;
                case DECODE_DATA:
                    m60816mx();
                    break;
                default:
                    IllegalStateException illegalStateException = new IllegalStateException("Unrecognized run reason: " + this.aAx);
                    AppMethodBeat.m2505o(91788);
                    throw illegalStateException;
            }
            if (c0742d != null) {
                c0742d.cleanup();
            }
            AppMethodBeat.m2505o(91788);
        } catch (Throwable th) {
            if (Log.isLoggable("DecodeJob", 3)) {
                new StringBuilder("DecodeJob threw unexpectedly, isCancelled: ").append(this.isCancelled).append(", stage: ").append(this.aAw);
            }
            if (this.aAw != C36673g.ENCODE) {
                this.aAp.add(th);
                m60814mv();
            }
            if (!this.isCancelled) {
                AppMethodBeat.m2505o(91788);
            }
        } finally {
            if (c0742d != null) {
                c0742d.cleanup();
            }
            AppMethodBeat.m2505o(91788);
        }
    }

    /* renamed from: mt */
    private C0753e m60812mt() {
        AppMethodBeat.m2504i(91789);
        C0753e c17521b;
        switch (this.aAw) {
            case RESOURCE_CACHE:
                C17527v c17527v = new C17527v(this.aAo, this);
                AppMethodBeat.m2505o(91789);
                return c17527v;
            case DATA_CACHE:
                c17521b = new C17521b(this.aAo, this);
                AppMethodBeat.m2505o(91789);
                return c17521b;
            case SOURCE:
                c17521b = new C44644y(this.aAo, this);
                AppMethodBeat.m2505o(91789);
                return c17521b;
            case FINISHED:
                AppMethodBeat.m2505o(91789);
                return null;
            default:
                IllegalStateException illegalStateException = new IllegalStateException("Unrecognized stage: " + this.aAw);
                AppMethodBeat.m2505o(91789);
                throw illegalStateException;
        }
    }

    /* renamed from: mu */
    private void m60813mu() {
        AppMethodBeat.m2504i(91790);
        this.aAA = Thread.currentThread();
        this.aAy = C31975e.m51954ok();
        boolean z = false;
        while (!this.isCancelled && this.aAG != null) {
            z = this.aAG.mo2211mk();
            if (z) {
                break;
            }
            this.aAw = mo58535a(this.aAw);
            this.aAG = m60812mt();
            if (this.aAw == C36673g.SOURCE) {
                mo2214mm();
                AppMethodBeat.m2505o(91790);
                return;
            }
        }
        if ((this.aAw == C36673g.FINISHED || this.isCancelled) && !r0) {
            m60814mv();
        }
        AppMethodBeat.m2505o(91790);
    }

    /* renamed from: mv */
    private void m60814mv() {
        AppMethodBeat.m2504i(91791);
        m60815mw();
        this.aAv.mo31952a(new C37169p("Failed to load resource", new ArrayList(this.aAp)));
        m60811mr();
        AppMethodBeat.m2505o(91791);
    }

    /* renamed from: a */
    private void m60807a(C17526u<R> c17526u, C25405a c25405a) {
        AppMethodBeat.m2504i(91792);
        m60815mw();
        this.aAv.mo31953c(c17526u, c25405a);
        AppMethodBeat.m2505o(91792);
    }

    /* renamed from: mw */
    private void m60815mw() {
        AppMethodBeat.m2504i(91793);
        this.aAq.mo31993oq();
        if (this.aAH) {
            IllegalStateException illegalStateException = new IllegalStateException("Already notified");
            AppMethodBeat.m2505o(91793);
            throw illegalStateException;
        }
        this.aAH = true;
        AppMethodBeat.m2505o(91793);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: a */
    public final C36673g mo58535a(C36673g c36673g) {
        AppMethodBeat.m2504i(91794);
        while (true) {
            C36673g c36673g2;
            switch (c36673g) {
                case RESOURCE_CACHE:
                    if (!this.aAl.mo2218mF()) {
                        c36673g = C36673g.DATA_CACHE;
                        break;
                    }
                    c36673g2 = C36673g.DATA_CACHE;
                    AppMethodBeat.m2505o(91794);
                    return c36673g2;
                case DATA_CACHE:
                    if (this.aAz) {
                        c36673g2 = C36673g.FINISHED;
                        AppMethodBeat.m2505o(91794);
                        return c36673g2;
                    }
                    c36673g2 = C36673g.SOURCE;
                    AppMethodBeat.m2505o(91794);
                    return c36673g2;
                case SOURCE:
                case FINISHED:
                    c36673g2 = C36673g.FINISHED;
                    AppMethodBeat.m2505o(91794);
                    return c36673g2;
                case INITIALIZE:
                    if (!this.aAl.mo2217mE()) {
                        c36673g = C36673g.RESOURCE_CACHE;
                        break;
                    }
                    c36673g2 = C36673g.RESOURCE_CACHE;
                    AppMethodBeat.m2505o(91794);
                    return c36673g2;
                default:
                    IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Unrecognized stage: ".concat(String.valueOf(c36673g)));
                    AppMethodBeat.m2505o(91794);
                    throw illegalArgumentException;
            }
        }
    }

    /* renamed from: mm */
    public final void mo2214mm() {
        AppMethodBeat.m2504i(91795);
        this.aAx = C36672f.SWITCH_TO_SOURCE_SERVICE;
        this.aAv.mo31951a(this);
        AppMethodBeat.m2505o(91795);
    }

    /* renamed from: a */
    public final void mo2213a(C0779h c0779h, Object obj, C0742d<?> c0742d, C25405a c25405a, C0779h c0779h2) {
        AppMethodBeat.m2504i(91796);
        this.aAB = c0779h;
        this.aAD = obj;
        this.aAF = c0742d;
        this.aAE = c25405a;
        this.aAC = c0779h2;
        if (Thread.currentThread() != this.aAA) {
            this.aAx = C36672f.DECODE_DATA;
            this.aAv.mo31951a(this);
            AppMethodBeat.m2505o(91796);
            return;
        }
        try {
            m60816mx();
        } finally {
            AppMethodBeat.m2505o(91796);
        }
    }

    /* renamed from: a */
    public final void mo2212a(C0779h c0779h, Exception exception, C0742d<?> c0742d, C25405a c25405a) {
        AppMethodBeat.m2504i(91797);
        c0742d.cleanup();
        C37169p c37169p = new C37169p("Fetching data failed", (Throwable) exception);
        c37169p.mo59252a(c0779h, c25405a, c0742d.mo2187mg());
        this.aAp.add(c37169p);
        if (Thread.currentThread() != this.aAA) {
            this.aAx = C36672f.SWITCH_TO_SOURCE_SERVICE;
            this.aAv.mo31951a(this);
            AppMethodBeat.m2505o(91797);
            return;
        }
        m60813mu();
        AppMethodBeat.m2505o(91797);
    }

    /* renamed from: mx */
    private void m60816mx() {
        C17526u a;
        AppMethodBeat.m2504i(91798);
        if (Log.isLoggable("DecodeJob", 2)) {
            m60808a("Retrieved data", this.aAy, "data: " + this.aAD + ", cache key: " + this.aAB + ", fetcher: " + this.aAF);
        }
        try {
            a = m60805a(this.aAF, this.aAD, this.aAE);
        } catch (C37169p e) {
            e.mo59252a(this.aAC, this.aAE, null);
            this.aAp.add(e);
            a = null;
        }
        if (a != null) {
            m60809b(a, this.aAE);
            AppMethodBeat.m2505o(91798);
            return;
        }
        m60813mu();
        AppMethodBeat.m2505o(91798);
    }

    /* renamed from: b */
    private void m60809b(C17526u<R> c17526u, C25405a c25405a) {
        C17526u c17526u2;
        AppMethodBeat.m2504i(91799);
        if (c17526u2 instanceof C41547q) {
            ((C41547q) c17526u2).initialize();
        }
        C8529t c8529t = null;
        if (this.aAs.mo31956mz()) {
            C8529t d = C8529t.m15147d(c17526u2);
            c8529t = d;
            c17526u2 = d;
        }
        m60807a(c17526u2, c25405a);
        this.aAw = C36673g.ENCODE;
        try {
            if (this.aAs.mo31956mz()) {
                this.aAs.mo31954a(this.aAg, this.aAd);
            }
            if (c8529t != null) {
                c8529t.unlock();
            }
            m60810mq();
            AppMethodBeat.m2505o(91799);
        } catch (Throwable th) {
            if (c8529t != null) {
                c8529t.unlock();
            }
            AppMethodBeat.m2505o(91799);
        }
    }

    /* renamed from: a */
    private <Data> C17526u<R> m60805a(C0742d<?> c0742d, Data data, C25405a c25405a) {
        C17526u<R> c17526u = null;
        AppMethodBeat.m2504i(91800);
        if (data == null) {
            c0742d.cleanup();
            AppMethodBeat.m2505o(91800);
        } else {
            try {
                long ok = C31975e.m51954ok();
                c17526u = m60806a((Object) data, c25405a, this.aAo.mo59246m(data.getClass()));
                if (Log.isLoggable("DecodeJob", 2)) {
                    m60808a("Decoded result ".concat(String.valueOf(c17526u)), ok, null);
                }
                c0742d.cleanup();
                AppMethodBeat.m2505o(91800);
            } catch (Throwable th) {
                c0742d.cleanup();
                AppMethodBeat.m2505o(91800);
            }
        }
        return c17526u;
    }

    /* renamed from: a */
    private void m60808a(String str, long j, String str2) {
        AppMethodBeat.m2504i(91802);
        new StringBuilder().append(str).append(" in ").append(C31975e.m51955q(j)).append(", load key: ").append(this.aAu).append(str2 != null ? ", ".concat(String.valueOf(str2)) : "").append(", thread: ").append(Thread.currentThread().getName());
        AppMethodBeat.m2505o(91802);
    }

    /* renamed from: my */
    public final C41574b mo18630my() {
        return this.aAq;
    }

    /* renamed from: a */
    private <Data, ResourceType> C17526u<R> m60806a(Data data, C25405a c25405a, C25424s<Data, ResourceType, R> c25424s) {
        AppMethodBeat.m2504i(91801);
        C31967j c31967j = this.aAd;
        if (VERSION.SDK_INT >= 26 && c31967j.mo52069a(C31961h.aFo) == null && (c25405a == C25405a.RESOURCE_DISK_CACHE || this.aAo.aAn)) {
            c31967j = new C31967j();
            c31967j.mo52070a(this.aAd);
            c31967j.azh.put(C31961h.aFo, Boolean.TRUE);
        }
        C8511e T = this.awi.awj.awQ.mo2191T(data);
        try {
            C17526u<R> a = c25424s.mo42467a(T, c31967j, this.width, this.height, new C17523b(c25405a));
            return a;
        } finally {
            T.cleanup();
            AppMethodBeat.m2505o(91801);
        }
    }
}
