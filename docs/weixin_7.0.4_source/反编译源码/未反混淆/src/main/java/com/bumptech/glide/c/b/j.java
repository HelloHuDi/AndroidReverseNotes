package com.bumptech.glide.c.b;

import android.util.Log;
import com.bumptech.glide.c.b.b.h;
import com.bumptech.glide.c.m;
import com.bumptech.glide.e;
import com.bumptech.glide.f.f;
import com.bumptech.glide.g;
import com.bumptech.glide.h.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;

public final class j implements com.bumptech.glide.c.b.b.h.a, l, a {
    private static final boolean aBn = Log.isLoggable("Engine", 2);
    private final r aBo;
    private final n aBp;
    private final h aBq;
    private final b aBr;
    private final x aBs;
    private final c aBt;
    private final a aBu;
    private final a aBv;

    public static class d {
        public final k<?> aBD;
        public final f aBE;

        d(f fVar, k<?> kVar) {
            this.aBE = fVar;
            this.aBD = kVar;
        }
    }

    static class b {
        final android.support.v4.f.k.a<k<?>> aAr = com.bumptech.glide.h.a.a.a(new com.bumptech.glide.h.a.a.a<k<?>>() {
            public final /* synthetic */ Object mG() {
                AppMethodBeat.i(91810);
                k kVar = new k(b.this.awr, b.this.awq, b.this.aBy, b.this.awx, b.this.aBz, b.this.aAr);
                AppMethodBeat.o(91810);
                return kVar;
            }
        });
        final com.bumptech.glide.c.b.c.a aBy;
        final l aBz;
        final com.bumptech.glide.c.b.c.a awq;
        final com.bumptech.glide.c.b.c.a awr;
        final com.bumptech.glide.c.b.c.a awx;

        b(com.bumptech.glide.c.b.c.a aVar, com.bumptech.glide.c.b.c.a aVar2, com.bumptech.glide.c.b.c.a aVar3, com.bumptech.glide.c.b.c.a aVar4, l lVar) {
            AppMethodBeat.i(91811);
            this.awr = aVar;
            this.awq = aVar2;
            this.aBy = aVar3;
            this.awx = aVar4;
            this.aBz = lVar;
            AppMethodBeat.o(91811);
        }
    }

    static class c implements d {
        private final com.bumptech.glide.c.b.b.a.a aBB;
        private volatile com.bumptech.glide.c.b.b.a aBC;

        c(com.bumptech.glide.c.b.b.a.a aVar) {
            this.aBB = aVar;
        }

        public final com.bumptech.glide.c.b.b.a mn() {
            AppMethodBeat.i(91812);
            if (this.aBC == null) {
                synchronized (this) {
                    try {
                        if (this.aBC == null) {
                            this.aBC = this.aBB.mU();
                        }
                        if (this.aBC == null) {
                            this.aBC = new com.bumptech.glide.c.b.b.b();
                        }
                    } catch (Throwable th) {
                        while (true) {
                            AppMethodBeat.o(91812);
                        }
                    }
                }
            }
            com.bumptech.glide.c.b.b.a aVar = this.aBC;
            AppMethodBeat.o(91812);
            return aVar;
        }
    }

    static class a {
        final d aAg;
        final android.support.v4.f.k.a<g<?>> aAr = com.bumptech.glide.h.a.a.a(new com.bumptech.glide.h.a.a.a<g<?>>() {
            public final /* synthetic */ Object mG() {
                AppMethodBeat.i(91808);
                g gVar = new g(a.this.aAg, a.this.aAr);
                AppMethodBeat.o(91808);
                return gVar;
            }
        });
        int aBw;

        a(d dVar) {
            AppMethodBeat.i(91809);
            this.aAg = dVar;
            AppMethodBeat.o(91809);
        }
    }

    static {
        AppMethodBeat.i(91821);
        AppMethodBeat.o(91821);
    }

    public j(h hVar, com.bumptech.glide.c.b.b.a.a aVar, com.bumptech.glide.c.b.c.a aVar2, com.bumptech.glide.c.b.c.a aVar3, com.bumptech.glide.c.b.c.a aVar4, com.bumptech.glide.c.b.c.a aVar5, boolean z) {
        this(hVar, aVar, aVar2, aVar3, aVar4, aVar5, z, (byte) 0);
    }

    private j(h hVar, com.bumptech.glide.c.b.b.a.a aVar, com.bumptech.glide.c.b.c.a aVar2, com.bumptech.glide.c.b.c.a aVar3, com.bumptech.glide.c.b.c.a aVar4, com.bumptech.glide.c.b.c.a aVar5, boolean z, byte b) {
        AppMethodBeat.i(91813);
        this.aBq = hVar;
        this.aBt = new c(aVar);
        a aVar6 = new a(z);
        this.aBv = aVar6;
        aVar6.azJ = this;
        this.aBp = new n();
        this.aBo = new r();
        this.aBr = new b(aVar2, aVar3, aVar4, aVar5, this);
        this.aBu = new a(this.aBt);
        this.aBs = new x();
        hVar.a(this);
        AppMethodBeat.o(91813);
    }

    public final <R> d a(e eVar, Object obj, com.bumptech.glide.c.h hVar, int i, int i2, Class<?> cls, Class<R> cls2, g gVar, i iVar, Map<Class<?>, m<?>> map, boolean z, boolean z2, com.bumptech.glide.c.j jVar, boolean z3, boolean z4, boolean z5, boolean z6, f fVar) {
        long ok;
        u uVar;
        Object uVar2;
        AppMethodBeat.i(91814);
        com.bumptech.glide.h.j.om();
        if (aBn) {
            ok = com.bumptech.glide.h.e.ok();
        } else {
            ok = 0;
        }
        com.bumptech.glide.c.h mVar = new m(obj, hVar, i, i2, map, cls, cls2, jVar);
        if (z3) {
            a aVar = this.aBv;
            b bVar = (b) aVar.azI.get(mVar);
            if (bVar == null) {
                uVar2 = null;
            } else {
                o oVar = (o) bVar.get();
                if (oVar == null) {
                    aVar.a(bVar);
                }
                uVar2 = oVar;
            }
            if (uVar2 != null) {
                uVar2.acquire();
            }
        } else {
            uVar2 = null;
        }
        if (uVar2 != null) {
            fVar.c(uVar2, com.bumptech.glide.c.a.MEMORY_CACHE);
            if (aBn) {
                a("Loaded resource from active resources", ok, mVar);
            }
            AppMethodBeat.o(91814);
            return null;
        }
        if (z3) {
            uVar2 = this.aBq.b(mVar);
            if (uVar2 == null) {
                uVar2 = null;
            } else if (uVar2 instanceof o) {
                o oVar2 = (o) uVar2;
            } else {
                uVar2 = new o(uVar2, true, true);
            }
            if (uVar2 != null) {
                uVar2.acquire();
                this.aBv.a(mVar, uVar2);
            }
        } else {
            uVar2 = null;
        }
        if (uVar2 != null) {
            fVar.c(uVar2, com.bumptech.glide.c.a.MEMORY_CACHE);
            if (aBn) {
                a("Loaded resource from cache", ok, mVar);
            }
            AppMethodBeat.o(91814);
            return null;
        }
        k kVar = (k) this.aBo.ax(z6).get(mVar);
        d dVar;
        if (kVar != null) {
            kVar.a(fVar);
            if (aBn) {
                a("Added to existing load", ok, mVar);
            }
            dVar = new d(fVar, kVar);
            AppMethodBeat.o(91814);
            return dVar;
        }
        Object obj2;
        com.bumptech.glide.c.b.c.a aVar2;
        kVar = (k) i.d((k) this.aBr.aAr.aA(), "Argument must not be null");
        kVar.azP = mVar;
        kVar.azQ = z3;
        kVar.aBJ = z4;
        kVar.aBK = z5;
        kVar.aAz = z6;
        a aVar3 = this.aBu;
        g gVar2 = (g) i.d((g) aVar3.aAr.aA(), "Argument must not be null");
        int i3 = aVar3.aBw;
        aVar3.aBw = i3 + 1;
        f fVar2 = gVar2.aAo;
        d dVar2 = gVar2.aAg;
        fVar2.awi = eVar;
        fVar2.axb = obj;
        fVar2.aAb = hVar;
        fVar2.width = i;
        fVar2.height = i2;
        fVar2.aAl = iVar;
        fVar2.aAf = cls;
        fVar2.aAg = dVar2;
        fVar2.awY = cls2;
        fVar2.aAk = gVar;
        fVar2.aAd = jVar;
        fVar2.aAh = map;
        fVar2.aAm = z;
        fVar2.aAn = z2;
        gVar2.awi = eVar;
        gVar2.aAb = hVar;
        gVar2.aAk = gVar;
        gVar2.aAu = mVar;
        gVar2.width = i;
        gVar2.height = i2;
        gVar2.aAl = iVar;
        gVar2.aAz = z6;
        gVar2.aAd = jVar;
        gVar2.aAv = kVar;
        gVar2.order = i3;
        gVar2.aAx = f.INITIALIZE;
        gVar2.axb = obj;
        this.aBo.ax(kVar.aAz).put(mVar, kVar);
        kVar.a(fVar);
        kVar.aBQ = gVar2;
        g a = gVar2.a(g.INITIALIZE);
        if (a == g.RESOURCE_CACHE || a == g.DATA_CACHE) {
            obj2 = 1;
        } else {
            obj2 = null;
        }
        if (obj2 != null) {
            aVar2 = kVar.awr;
        } else {
            aVar2 = kVar.mH();
        }
        aVar2.execute(gVar2);
        if (aBn) {
            a("Started new load", ok, mVar);
        }
        dVar = new d(fVar, kVar);
        AppMethodBeat.o(91814);
        return dVar;
    }

    private static void a(String str, long j, com.bumptech.glide.c.h hVar) {
        AppMethodBeat.i(91815);
        new StringBuilder().append(str).append(" in ").append(com.bumptech.glide.h.e.q(j)).append("ms, key: ").append(hVar);
        AppMethodBeat.o(91815);
    }

    public static void b(u<?> uVar) {
        AppMethodBeat.i(91816);
        com.bumptech.glide.h.j.om();
        if (uVar instanceof o) {
            ((o) uVar).release();
            AppMethodBeat.o(91816);
            return;
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Cannot release anything but an EngineResource");
        AppMethodBeat.o(91816);
        throw illegalArgumentException;
    }

    public final void a(k<?> kVar, com.bumptech.glide.c.h hVar, o<?> oVar) {
        AppMethodBeat.i(91817);
        com.bumptech.glide.h.j.om();
        if (oVar != null) {
            oVar.a(hVar, this);
            if (oVar.azQ) {
                this.aBv.a(hVar, oVar);
            }
        }
        this.aBo.a(hVar, kVar);
        AppMethodBeat.o(91817);
    }

    public final void a(k<?> kVar, com.bumptech.glide.c.h hVar) {
        AppMethodBeat.i(91818);
        com.bumptech.glide.h.j.om();
        this.aBo.a(hVar, kVar);
        AppMethodBeat.o(91818);
    }

    public final void c(u<?> uVar) {
        AppMethodBeat.i(91819);
        com.bumptech.glide.h.j.om();
        this.aBs.e(uVar);
        AppMethodBeat.o(91819);
    }

    public final void b(com.bumptech.glide.c.h hVar, o<?> oVar) {
        AppMethodBeat.i(91820);
        com.bumptech.glide.h.j.om();
        b bVar = (b) this.aBv.azI.remove(hVar);
        if (bVar != null) {
            bVar.reset();
        }
        if (oVar.azQ) {
            this.aBq.a(hVar, oVar);
            AppMethodBeat.o(91820);
            return;
        }
        this.aBs.e(oVar);
        AppMethodBeat.o(91820);
    }
}
