package a.i.b.a.c.d.b;

import a.a.t;
import a.f.b.j;
import a.i.b.a.c.b.aa;
import a.i.b.a.c.b.am;
import a.i.b.a.c.b.au;
import a.i.b.a.c.b.e;
import a.i.b.a.c.b.s;
import a.i.b.a.c.b.y;
import a.i.b.a.c.d.b.n.d;
import a.i.b.a.c.i.b.f;
import a.i.b.a.c.i.b.g;
import a.i.b.a.c.i.b.i;
import a.i.b.a.c.i.b.l;
import a.i.b.a.c.i.b.o;
import a.i.b.a.c.i.b.p;
import a.i.b.a.c.i.b.r;
import a.i.b.a.c.i.b.u;
import a.i.b.a.c.i.b.v;
import a.i.b.a.c.l.w;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class c extends a<a.i.b.a.c.b.a.c, f<?>> {
    private final y BcH;
    private final aa Bcm;
    private final a.i.b.a.c.j.a.c Brc = new a.i.b.a.c.j.a.c(this.BcH, this.Bcm);

    public static final class a implements a.i.b.a.c.d.b.n.a {
        final HashMap<a.i.b.a.c.f.f, f<?>> Brd = new HashMap();
        final /* synthetic */ c Bre;
        final /* synthetic */ e Brf;
        final /* synthetic */ am Brg;
        final /* synthetic */ List rYn;

        public static final class b implements a.i.b.a.c.d.b.n.b {
            final /* synthetic */ a.i.b.a.c.f.f Beg;
            final /* synthetic */ a Bri;
            private final ArrayList<f<?>> Brk = new ArrayList();

            b(a aVar, a.i.b.a.c.f.f fVar) {
                this.Bri = aVar;
                this.Beg = fVar;
                AppMethodBeat.i(120235);
                AppMethodBeat.o(120235);
            }

            public final void dG(Object obj) {
                AppMethodBeat.i(120231);
                this.Brk.add(a.b(this.Beg, obj));
                AppMethodBeat.o(120231);
            }

            public final void a(a.i.b.a.c.f.a aVar, a.i.b.a.c.f.f fVar) {
                AppMethodBeat.i(120232);
                j.p(aVar, "enumClassId");
                j.p(fVar, "enumEntryName");
                this.Brk.add(new i(aVar, fVar));
                AppMethodBeat.o(120232);
            }

            public final void a(d dVar) {
                Object obj;
                AppMethodBeat.i(120233);
                j.p(dVar, "classLiteralId");
                ArrayList arrayList = this.Brk;
                o a = c.a(this.Bri.Bre, dVar);
                if (a != null) {
                    obj = a;
                } else {
                    a.i.b.a.c.i.b.j.a aVar = a.i.b.a.c.i.b.j.BET;
                    f obj2 = a.i.b.a.c.i.b.j.a.awi("Error array element value of annotation argument: " + this.Beg + ": class " + dVar.BcB.ehE() + " not found");
                }
                arrayList.add(obj2);
                AppMethodBeat.o(120233);
            }

            public final void zn() {
                AppMethodBeat.i(120234);
                au b = a.i.b.a.c.d.a.a.a.b(this.Beg, this.Bri.Brf);
                if (b != null) {
                    Map map = this.Bri.Brd;
                    a.i.b.a.c.f.f fVar = this.Beg;
                    g gVar = g.BEO;
                    List at = a.i.b.a.c.n.a.at(this.Brk);
                    w dZS = b.dZS();
                    j.o(dZS, "parameter.type");
                    map.put(fVar, g.a(at, dZS));
                }
                AppMethodBeat.o(120234);
            }
        }

        public static final class a implements a.i.b.a.c.d.b.n.a {
            final /* synthetic */ a.i.b.a.c.f.f Beg;
            final /* synthetic */ ArrayList Bqx;
            private final /* synthetic */ a.i.b.a.c.d.b.n.a Brh;
            final /* synthetic */ a Bri;
            final /* synthetic */ a.i.b.a.c.d.b.n.a Brj;

            public final a.i.b.a.c.d.b.n.a a(a.i.b.a.c.f.f fVar, a.i.b.a.c.f.a aVar) {
                AppMethodBeat.i(120227);
                j.p(fVar, "name");
                j.p(aVar, "classId");
                a.i.b.a.c.d.b.n.a a = this.Brh.a(fVar, aVar);
                AppMethodBeat.o(120227);
                return a;
            }

            public final void a(a.i.b.a.c.f.f fVar, d dVar) {
                AppMethodBeat.i(120229);
                j.p(fVar, "name");
                j.p(dVar, "classLiteralId");
                this.Brh.a(fVar, dVar);
                AppMethodBeat.o(120229);
            }

            public final void a(a.i.b.a.c.f.f fVar, a.i.b.a.c.f.a aVar, a.i.b.a.c.f.f fVar2) {
                AppMethodBeat.i(120230);
                j.p(fVar, "name");
                j.p(aVar, "enumClassId");
                j.p(fVar2, "enumEntryName");
                this.Brh.a(fVar, aVar, fVar2);
                AppMethodBeat.o(120230);
            }

            public final void a(a.i.b.a.c.f.f fVar, Object obj) {
                AppMethodBeat.i(120226);
                this.Brh.a(fVar, obj);
                AppMethodBeat.o(120226);
            }

            public final a.i.b.a.c.d.b.n.b o(a.i.b.a.c.f.f fVar) {
                AppMethodBeat.i(120228);
                j.p(fVar, "name");
                a.i.b.a.c.d.b.n.b o = this.Brh.o(fVar);
                AppMethodBeat.o(120228);
                return o;
            }

            a(a aVar, a.i.b.a.c.d.b.n.a aVar2, a.i.b.a.c.f.f fVar, ArrayList arrayList) {
                this.Bri = aVar;
                this.Brj = aVar2;
                this.Beg = fVar;
                this.Bqx = arrayList;
                this.Brh = aVar2;
            }

            public final void zn() {
                AppMethodBeat.i(120225);
                this.Brj.zn();
                this.Bri.Brd.put(this.Beg, new a.i.b.a.c.i.b.a((a.i.b.a.c.b.a.c) t.fN(this.Bqx)));
                AppMethodBeat.o(120225);
            }
        }

        a(c cVar, e eVar, List list, am amVar) {
            this.Bre = cVar;
            this.Brf = eVar;
            this.rYn = list;
            this.Brg = amVar;
            AppMethodBeat.i(120243);
            AppMethodBeat.o(120243);
        }

        public final void a(a.i.b.a.c.f.f fVar, Object obj) {
            AppMethodBeat.i(120236);
            if (fVar != null) {
                this.Brd.put(fVar, b(fVar, obj));
            }
            AppMethodBeat.o(120236);
        }

        public final void a(a.i.b.a.c.f.f fVar, d dVar) {
            Object obj;
            AppMethodBeat.i(120237);
            j.p(fVar, "name");
            j.p(dVar, "classLiteralId");
            Map map = this.Brd;
            o a = c.a(this.Bre, dVar);
            if (a != null) {
                obj = a;
            } else {
                a.i.b.a.c.i.b.j.a aVar = a.i.b.a.c.i.b.j.BET;
                f obj2 = a.i.b.a.c.i.b.j.a.awi("Error value of annotation argument: " + fVar + ": class " + dVar.BcB.ehE() + " not found");
            }
            map.put(fVar, obj2);
            AppMethodBeat.o(120237);
        }

        public final void a(a.i.b.a.c.f.f fVar, a.i.b.a.c.f.a aVar, a.i.b.a.c.f.f fVar2) {
            AppMethodBeat.i(120238);
            j.p(fVar, "name");
            j.p(aVar, "enumClassId");
            j.p(fVar2, "enumEntryName");
            this.Brd.put(fVar, new i(aVar, fVar2));
            AppMethodBeat.o(120238);
        }

        public final a.i.b.a.c.d.b.n.b o(a.i.b.a.c.f.f fVar) {
            AppMethodBeat.i(120239);
            j.p(fVar, "name");
            a.i.b.a.c.d.b.n.b bVar = new b(this, fVar);
            AppMethodBeat.o(120239);
            return bVar;
        }

        public final a.i.b.a.c.d.b.n.a a(a.i.b.a.c.f.f fVar, a.i.b.a.c.f.a aVar) {
            AppMethodBeat.i(120240);
            j.p(fVar, "name");
            j.p(aVar, "classId");
            ArrayList arrayList = new ArrayList();
            c cVar = this.Bre;
            am amVar = am.BeR;
            j.o(amVar, "SourceElement.NO_SOURCE");
            a.i.b.a.c.d.b.n.a aVar2 = new a(this, cVar.a(aVar, amVar, arrayList), fVar, arrayList);
            AppMethodBeat.o(120240);
            return aVar2;
        }

        public final void zn() {
            AppMethodBeat.i(120241);
            this.rYn.add(new a.i.b.a.c.b.a.d(this.Brf.dZf(), this.Brd, this.Brg));
            AppMethodBeat.o(120241);
        }

        static f<?> b(a.i.b.a.c.f.f fVar, Object obj) {
            AppMethodBeat.i(120242);
            f<?> dQ = g.BEO.dQ(obj);
            if (dQ == null) {
                a.i.b.a.c.i.b.j.a aVar = a.i.b.a.c.i.b.j.BET;
                dQ = a.i.b.a.c.i.b.j.a.awi("Unsupported annotation argument: ".concat(String.valueOf(fVar)));
            }
            AppMethodBeat.o(120242);
            return dQ;
        }
    }

    public final /* synthetic */ Object dF(Object obj) {
        AppMethodBeat.i(120245);
        f fVar = (f) obj;
        j.p(fVar, "constant");
        f tVar;
        if (fVar instanceof a.i.b.a.c.i.b.d) {
            tVar = new a.i.b.a.c.i.b.t(((Number) ((a.i.b.a.c.i.b.d) fVar).getValue()).byteValue());
            AppMethodBeat.o(120245);
            return tVar;
        } else if (fVar instanceof r) {
            tVar = new a.i.b.a.c.i.b.w(((Number) ((r) fVar).getValue()).shortValue());
            AppMethodBeat.o(120245);
            return tVar;
        } else if (fVar instanceof l) {
            tVar = new u(((Number) ((l) fVar).getValue()).intValue());
            AppMethodBeat.o(120245);
            return tVar;
        } else if (fVar instanceof p) {
            tVar = new v(((Number) ((p) fVar).getValue()).longValue());
            AppMethodBeat.o(120245);
            return tVar;
        } else {
            AppMethodBeat.o(120245);
            return fVar;
        }
    }

    public c(y yVar, aa aaVar, a.i.b.a.c.k.i iVar, m mVar) {
        j.p(yVar, "module");
        j.p(aaVar, "notFoundClasses");
        j.p(iVar, "storageManager");
        j.p(mVar, "kotlinClassFinder");
        super(iVar, mVar);
        AppMethodBeat.i(120248);
        this.BcH = yVar;
        this.Bcm = aaVar;
        AppMethodBeat.o(120248);
    }

    /* Access modifiers changed, original: protected|final */
    public final a.i.b.a.c.d.b.n.a a(a.i.b.a.c.f.a aVar, am amVar, List<a.i.b.a.c.b.a.c> list) {
        AppMethodBeat.i(120246);
        j.p(aVar, "annotationClassId");
        j.p(amVar, "source");
        j.p(list, "result");
        a.i.b.a.c.d.b.n.a aVar2 = new a(this, f(aVar), list, amVar);
        AppMethodBeat.o(120246);
        return aVar2;
    }

    private final e f(a.i.b.a.c.f.a aVar) {
        AppMethodBeat.i(120247);
        e a = s.a(this.BcH, aVar, this.Bcm);
        AppMethodBeat.o(120247);
        return a;
    }
}
