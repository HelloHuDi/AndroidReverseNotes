package a.i.b.a.c.b.c;

import a.i.b.a.c.a.g;
import a.i.b.a.c.b.am;
import a.i.b.a.c.b.ap;
import a.i.b.a.c.b.ar;
import a.i.b.a.c.b.h;
import a.i.b.a.c.b.l;
import a.i.b.a.c.b.n;
import a.i.b.a.c.b.o;
import a.i.b.a.c.i.e.m;
import a.i.b.a.c.k.f;
import a.i.b.a.c.k.i;
import a.i.b.a.c.l.ad;
import a.i.b.a.c.l.an;
import a.i.b.a.c.l.ba;
import a.i.b.a.c.l.c;
import a.i.b.a.c.l.p;
import a.i.b.a.c.l.w;
import a.i.b.a.c.l.x;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public abstract class e extends k implements ar {
    private final f<ad> Bha;
    final ba Bhj;
    final boolean Bhk;
    private final f<an> Bhl;
    private final int index;

    class a extends c {
        private final ap Bhr;

        public a(i iVar, ap apVar) {
            super(iVar);
            this.Bhr = apVar;
        }

        public final Collection<w> dYr() {
            AppMethodBeat.i(119391);
            List eaq = e.this.eaq();
            AppMethodBeat.o(119391);
            return eaq;
        }

        public final List<ar> getParameters() {
            AppMethodBeat.i(119392);
            List emptyList = Collections.emptyList();
            AppMethodBeat.o(119392);
            return emptyList;
        }

        public final boolean dYu() {
            return true;
        }

        public final h dYs() {
            return e.this;
        }

        public final g dZD() {
            AppMethodBeat.i(119393);
            g G = a.i.b.a.c.i.c.a.G(e.this);
            AppMethodBeat.o(119393);
            return G;
        }

        public final String toString() {
            AppMethodBeat.i(119394);
            String fVar = e.this.BgZ.toString();
            AppMethodBeat.o(119394);
            return fVar;
        }

        public final ap dYv() {
            return this.Bhr;
        }

        public final void J(w wVar) {
            AppMethodBeat.i(119395);
            e.this.J(wVar);
            AppMethodBeat.o(119395);
        }

        public final w ear() {
            AppMethodBeat.i(119396);
            ad awn = p.awn("Cyclic upper bounds");
            AppMethodBeat.o(119396);
            return awn;
        }
    }

    public abstract void J(w wVar);

    public abstract List<w> eaq();

    protected e(final i iVar, l lVar, a.i.b.a.c.b.a.g gVar, final a.i.b.a.c.f.f fVar, ba baVar, boolean z, int i, am amVar, final ap apVar) {
        super(lVar, gVar, fVar, amVar);
        this.Bhj = baVar;
        this.Bhk = z;
        this.index = i;
        this.Bhl = iVar.i(new a.f.a.a<an>() {
            public final /* synthetic */ Object invoke() {
                AppMethodBeat.i(119388);
                a aVar = new a(iVar, apVar);
                AppMethodBeat.o(119388);
                return aVar;
            }
        });
        this.Bha = iVar.i(new a.f.a.a<ad>() {
            public final /* synthetic */ Object invoke() {
                AppMethodBeat.i(119390);
                a.i.b.a.c.b.a.g.a aVar = a.i.b.a.c.b.a.g.BfJ;
                ad a = x.a(a.i.b.a.c.b.a.g.a.eai(), e.this.dXY(), Collections.emptyList(), false, new a.i.b.a.c.i.e.g(iVar.i(new a.f.a.a<a.i.b.a.c.i.e.h>() {
                    public final /* synthetic */ Object invoke() {
                        AppMethodBeat.i(119389);
                        a.i.b.a.c.i.e.h a = m.a("Scope for type parameter " + fVar.name, e.this.dWP());
                        AppMethodBeat.o(119389);
                        return a;
                    }
                })));
                AppMethodBeat.o(119390);
                return a;
            }
        });
    }

    public final ba dZh() {
        return this.Bhj;
    }

    public final boolean dZi() {
        return this.Bhk;
    }

    public final int getIndex() {
        return this.index;
    }

    public final boolean dZb() {
        return false;
    }

    public final List<w> dWP() {
        return ((a) dXY()).eap();
    }

    public final an dXY() {
        return (an) this.Bhl.invoke();
    }

    public final ad dZf() {
        return (ad) this.Bha.invoke();
    }

    public final ar dZc() {
        return (ar) super.dZd();
    }

    public final <R, D> R a(n<R, D> nVar, D d) {
        return nVar.a((ar) this, (Object) d);
    }

    public final /* bridge */ /* synthetic */ o ean() {
        return (ar) super.dZd();
    }

    public final /* synthetic */ l dZd() {
        return (ar) super.dZd();
    }

    public final /* synthetic */ h dZe() {
        return (ar) super.dZd();
    }
}
