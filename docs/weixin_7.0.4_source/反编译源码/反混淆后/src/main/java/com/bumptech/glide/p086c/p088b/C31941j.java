package com.bumptech.glide.p086c.p088b;

import android.support.p057v4.p065f.C37122k.C8387a;
import android.util.Log;
import com.bumptech.glide.C37191e;
import com.bumptech.glide.C37192g;
import com.bumptech.glide.p086c.C0779h;
import com.bumptech.glide.p086c.C25405a;
import com.bumptech.glide.p086c.C31967j;
import com.bumptech.glide.p086c.C31970m;
import com.bumptech.glide.p086c.p088b.C36671g.C31936d;
import com.bumptech.glide.p086c.p088b.C36671g.C36672f;
import com.bumptech.glide.p086c.p088b.C36671g.C36673g;
import com.bumptech.glide.p086c.p088b.C44983a.C44981b;
import com.bumptech.glide.p086c.p088b.C44988o.C44987a;
import com.bumptech.glide.p086c.p088b.p785b.C25414h;
import com.bumptech.glide.p086c.p088b.p785b.C25414h.C17519a;
import com.bumptech.glide.p086c.p088b.p785b.C31932a;
import com.bumptech.glide.p086c.p088b.p785b.C31932a.C31933a;
import com.bumptech.glide.p086c.p088b.p785b.C37166b;
import com.bumptech.glide.p086c.p088b.p786c.C44985a;
import com.bumptech.glide.p095h.C31975e;
import com.bumptech.glide.p095h.C45002j;
import com.bumptech.glide.p095h.C8561i;
import com.bumptech.glide.p095h.p1136a.C37193a;
import com.bumptech.glide.p095h.p1136a.C37193a.C37194a;
import com.bumptech.glide.p791f.C41571f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;

/* renamed from: com.bumptech.glide.c.b.j */
public final class C31941j implements C17519a, C25423l, C44987a {
    private static final boolean aBn = Log.isLoggable("Engine", 2);
    private final C37170r aBo;
    private final C8528n aBp;
    private final C25414h aBq;
    private final C31940b aBr;
    private final C41549x aBs;
    private final C31942c aBt;
    private final C31943a aBu;
    private final C44983a aBv;

    /* renamed from: com.bumptech.glide.c.b.j$d */
    public static class C0759d {
        public final C24644k<?> aBD;
        public final C41571f aBE;

        C0759d(C41571f c41571f, C24644k<?> c24644k) {
            this.aBE = c41571f;
            this.aBD = c24644k;
        }
    }

    /* renamed from: com.bumptech.glide.c.b.j$b */
    static class C31940b {
        final C8387a<C24644k<?>> aAr = C37193a.m62344a(new C254221());
        final C44985a aBy;
        final C25423l aBz;
        final C44985a awq;
        final C44985a awr;
        final C44985a awx;

        /* renamed from: com.bumptech.glide.c.b.j$b$1 */
        class C254221 implements C37194a<C24644k<?>> {
            C254221() {
            }

            /* renamed from: mG */
            public final /* synthetic */ Object mo18632mG() {
                AppMethodBeat.m2504i(91810);
                C24644k c24644k = new C24644k(C31940b.this.awr, C31940b.this.awq, C31940b.this.aBy, C31940b.this.awx, C31940b.this.aBz, C31940b.this.aAr);
                AppMethodBeat.m2505o(91810);
                return c24644k;
            }
        }

        C31940b(C44985a c44985a, C44985a c44985a2, C44985a c44985a3, C44985a c44985a4, C25423l c25423l) {
            AppMethodBeat.m2504i(91811);
            this.awr = c44985a;
            this.awq = c44985a2;
            this.aBy = c44985a3;
            this.awx = c44985a4;
            this.aBz = c25423l;
            AppMethodBeat.m2505o(91811);
        }
    }

    /* renamed from: com.bumptech.glide.c.b.j$c */
    static class C31942c implements C31936d {
        private final C31933a aBB;
        private volatile C31932a aBC;

        C31942c(C31933a c31933a) {
            this.aBB = c31933a;
        }

        /* renamed from: mn */
        public final C31932a mo52051mn() {
            AppMethodBeat.m2504i(91812);
            if (this.aBC == null) {
                synchronized (this) {
                    try {
                        if (this.aBC == null) {
                            this.aBC = this.aBB.mo52048mU();
                        }
                        if (this.aBC == null) {
                            this.aBC = new C37166b();
                        }
                    } catch (Throwable th) {
                        while (true) {
                            AppMethodBeat.m2505o(91812);
                        }
                    }
                }
            }
            C31932a c31932a = this.aBC;
            AppMethodBeat.m2505o(91812);
            return c31932a;
        }
    }

    /* renamed from: com.bumptech.glide.c.b.j$a */
    static class C31943a {
        final C31936d aAg;
        final C8387a<C36671g<?>> aAr = C37193a.m62344a(new C319441());
        int aBw;

        /* renamed from: com.bumptech.glide.c.b.j$a$1 */
        class C319441 implements C37194a<C36671g<?>> {
            C319441() {
            }

            /* renamed from: mG */
            public final /* synthetic */ Object mo18632mG() {
                AppMethodBeat.m2504i(91808);
                C36671g c36671g = new C36671g(C31943a.this.aAg, C31943a.this.aAr);
                AppMethodBeat.m2505o(91808);
                return c36671g;
            }
        }

        C31943a(C31936d c31936d) {
            AppMethodBeat.m2504i(91809);
            this.aAg = c31936d;
            AppMethodBeat.m2505o(91809);
        }
    }

    static {
        AppMethodBeat.m2504i(91821);
        AppMethodBeat.m2505o(91821);
    }

    public C31941j(C25414h c25414h, C31933a c31933a, C44985a c44985a, C44985a c44985a2, C44985a c44985a3, C44985a c44985a4, boolean z) {
        this(c25414h, c31933a, c44985a, c44985a2, c44985a3, c44985a4, z, (byte) 0);
    }

    private C31941j(C25414h c25414h, C31933a c31933a, C44985a c44985a, C44985a c44985a2, C44985a c44985a3, C44985a c44985a4, boolean z, byte b) {
        AppMethodBeat.m2504i(91813);
        this.aBq = c25414h;
        this.aBt = new C31942c(c31933a);
        C44983a c44983a = new C44983a(z);
        this.aBv = c44983a;
        c44983a.azJ = this;
        this.aBp = new C8528n();
        this.aBo = new C37170r();
        this.aBr = new C31940b(c44985a, c44985a2, c44985a3, c44985a4, this);
        this.aBu = new C31943a(this.aBt);
        this.aBs = new C41549x();
        c25414h.mo18621a(this);
        AppMethodBeat.m2505o(91813);
    }

    /* renamed from: a */
    public final <R> C0759d mo52054a(C37191e c37191e, Object obj, C0779h c0779h, int i, int i2, Class<?> cls, Class<R> cls2, C37192g c37192g, C31938i c31938i, Map<Class<?>, C31970m<?>> map, boolean z, boolean z2, C31967j c31967j, boolean z3, boolean z4, boolean z5, boolean z6, C41571f c41571f) {
        long ok;
        C17526u c17526u;
        Object c17526u2;
        AppMethodBeat.m2504i(91814);
        C45002j.m82426om();
        if (aBn) {
            ok = C31975e.m51954ok();
        } else {
            ok = 0;
        }
        C0779h c8527m = new C8527m(obj, c0779h, i, i2, map, cls, cls2, c31967j);
        if (z3) {
            C44983a c44983a = this.aBv;
            C44981b c44981b = (C44981b) c44983a.azI.get(c8527m);
            if (c44981b == null) {
                c17526u2 = null;
            } else {
                C44988o c44988o = (C44988o) c44981b.get();
                if (c44988o == null) {
                    c44983a.mo72263a(c44981b);
                }
                c17526u2 = c44988o;
            }
            if (c17526u2 != null) {
                c17526u2.acquire();
            }
        } else {
            c17526u2 = null;
        }
        if (c17526u2 != null) {
            c41571f.mo66598c(c17526u2, C25405a.MEMORY_CACHE);
            if (aBn) {
                C31941j.m51891a("Loaded resource from active resources", ok, c8527m);
            }
            AppMethodBeat.m2505o(91814);
            return null;
        }
        if (z3) {
            c17526u2 = this.aBq.mo18622b(c8527m);
            if (c17526u2 == null) {
                c17526u2 = null;
            } else if (c17526u2 instanceof C44988o) {
                C44988o c44988o2 = (C44988o) c17526u2;
            } else {
                c17526u2 = new C44988o(c17526u2, true, true);
            }
            if (c17526u2 != null) {
                c17526u2.acquire();
                this.aBv.mo72264a(c8527m, c17526u2);
            }
        } else {
            c17526u2 = null;
        }
        if (c17526u2 != null) {
            c41571f.mo66598c(c17526u2, C25405a.MEMORY_CACHE);
            if (aBn) {
                C31941j.m51891a("Loaded resource from cache", ok, c8527m);
            }
            AppMethodBeat.m2505o(91814);
            return null;
        }
        C24644k c24644k = (C24644k) this.aBo.mo59260ax(z6).get(c8527m);
        C0759d c0759d;
        if (c24644k != null) {
            c24644k.mo41476a(c41571f);
            if (aBn) {
                C31941j.m51891a("Added to existing load", ok, c8527m);
            }
            c0759d = new C0759d(c41571f, c24644k);
            AppMethodBeat.m2505o(91814);
            return c0759d;
        }
        Object obj2;
        C44985a c44985a;
        c24644k = (C24644k) C8561i.m15217d((C24644k) this.aBr.aAr.mo6364aA(), "Argument must not be null");
        c24644k.azP = c8527m;
        c24644k.azQ = z3;
        c24644k.aBJ = z4;
        c24644k.aBK = z5;
        c24644k.aAz = z6;
        C31943a c31943a = this.aBu;
        C36671g c36671g = (C36671g) C8561i.m15217d((C36671g) c31943a.aAr.mo6364aA(), "Argument must not be null");
        int i3 = c31943a.aBw;
        c31943a.aBw = i3 + 1;
        C37168f c37168f = c36671g.aAo;
        C31936d c31936d = c36671g.aAg;
        c37168f.awi = c37191e;
        c37168f.axb = obj;
        c37168f.aAb = c0779h;
        c37168f.width = i;
        c37168f.height = i2;
        c37168f.aAl = c31938i;
        c37168f.aAf = cls;
        c37168f.aAg = c31936d;
        c37168f.awY = cls2;
        c37168f.aAk = c37192g;
        c37168f.aAd = c31967j;
        c37168f.aAh = map;
        c37168f.aAm = z;
        c37168f.aAn = z2;
        c36671g.awi = c37191e;
        c36671g.aAb = c0779h;
        c36671g.aAk = c37192g;
        c36671g.aAu = c8527m;
        c36671g.width = i;
        c36671g.height = i2;
        c36671g.aAl = c31938i;
        c36671g.aAz = z6;
        c36671g.aAd = c31967j;
        c36671g.aAv = c24644k;
        c36671g.order = i3;
        c36671g.aAx = C36672f.INITIALIZE;
        c36671g.axb = obj;
        this.aBo.mo59260ax(c24644k.aAz).put(c8527m, c24644k);
        c24644k.mo41476a(c41571f);
        c24644k.aBQ = c36671g;
        C36673g a = c36671g.mo58535a(C36673g.INITIALIZE);
        if (a == C36673g.RESOURCE_CACHE || a == C36673g.DATA_CACHE) {
            obj2 = 1;
        } else {
            obj2 = null;
        }
        if (obj2 != null) {
            c44985a = c24644k.awr;
        } else {
            c44985a = c24644k.mo41478mH();
        }
        c44985a.execute(c36671g);
        if (aBn) {
            C31941j.m51891a("Started new load", ok, c8527m);
        }
        c0759d = new C0759d(c41571f, c24644k);
        AppMethodBeat.m2505o(91814);
        return c0759d;
    }

    /* renamed from: a */
    private static void m51891a(String str, long j, C0779h c0779h) {
        AppMethodBeat.m2504i(91815);
        new StringBuilder().append(str).append(" in ").append(C31975e.m51955q(j)).append("ms, key: ").append(c0779h);
        AppMethodBeat.m2505o(91815);
    }

    /* renamed from: b */
    public static void m51892b(C17526u<?> c17526u) {
        AppMethodBeat.m2504i(91816);
        C45002j.m82426om();
        if (c17526u instanceof C44988o) {
            ((C44988o) c17526u).release();
            AppMethodBeat.m2505o(91816);
            return;
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Cannot release anything but an EngineResource");
        AppMethodBeat.m2505o(91816);
        throw illegalArgumentException;
    }

    /* renamed from: a */
    public final void mo42466a(C24644k<?> c24644k, C0779h c0779h, C44988o<?> c44988o) {
        AppMethodBeat.m2504i(91817);
        C45002j.m82426om();
        if (c44988o != null) {
            c44988o.mo72280a(c0779h, this);
            if (c44988o.azQ) {
                this.aBv.mo72264a(c0779h, c44988o);
            }
        }
        this.aBo.mo59259a(c0779h, c24644k);
        AppMethodBeat.m2505o(91817);
    }

    /* renamed from: a */
    public final void mo42465a(C24644k<?> c24644k, C0779h c0779h) {
        AppMethodBeat.m2504i(91818);
        C45002j.m82426om();
        this.aBo.mo59259a(c0779h, c24644k);
        AppMethodBeat.m2505o(91818);
    }

    /* renamed from: c */
    public final void mo31950c(C17526u<?> c17526u) {
        AppMethodBeat.m2504i(91819);
        C45002j.m82426om();
        this.aBs.mo66574e(c17526u);
        AppMethodBeat.m2505o(91819);
    }

    /* renamed from: b */
    public final void mo52055b(C0779h c0779h, C44988o<?> c44988o) {
        AppMethodBeat.m2504i(91820);
        C45002j.m82426om();
        C44981b c44981b = (C44981b) this.aBv.azI.remove(c0779h);
        if (c44981b != null) {
            c44981b.reset();
        }
        if (c44988o.azQ) {
            this.aBq.mo18620a(c0779h, c44988o);
            AppMethodBeat.m2505o(91820);
            return;
        }
        this.aBs.mo66574e(c44988o);
        AppMethodBeat.m2505o(91820);
    }
}
