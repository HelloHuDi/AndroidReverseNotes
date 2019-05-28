package a.i.b.a.c.a.a;

import a.a.t;
import a.a.v;
import a.f.a.m;
import a.f.b.j;
import a.f.b.k;
import a.i.b.a.c.b.a.g;
import a.i.b.a.c.b.ab;
import a.i.b.a.c.b.am;
import a.i.b.a.c.b.ap;
import a.i.b.a.c.b.ar;
import a.i.b.a.c.b.ay;
import a.i.b.a.c.b.az;
import a.i.b.a.c.b.c.ah;
import a.i.b.a.c.b.e;
import a.i.b.a.c.b.h;
import a.i.b.a.c.b.l;
import a.i.b.a.c.c.a.c;
import a.i.b.a.c.f.f;
import a.i.b.a.c.i.d;
import a.i.b.a.c.k.i;
import a.i.b.a.c.l.an;
import a.i.b.a.c.l.ba;
import a.i.b.a.c.l.w;
import a.i.b.a.c.l.x;
import a.y;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public final class b extends a.i.b.a.c.b.c.a {
    final int AVt;
    private final i Baf;
    private final a BcK = new a();
    private final d BcL = new d(this.Baf, this);
    private final ab BcM;
    final b BcN;
    final List<ar> parameters;

    final class a extends a.i.b.a.c.l.b {

        static final class a extends k implements m<ab, f, y> {
            final /* synthetic */ ArrayList BcP;
            final /* synthetic */ a BcQ;

            a(a aVar, ArrayList arrayList) {
                this.BcQ = aVar;
                this.BcP = arrayList;
                super(2);
            }

            public final /* synthetic */ Object m(Object obj, Object obj2) {
                AppMethodBeat.i(119138);
                a((ab) obj, (f) obj2);
                y yVar = y.AUy;
                AppMethodBeat.o(119138);
                return yVar;
            }

            public final void a(ab abVar, f fVar) {
                AppMethodBeat.i(119139);
                j.p(abVar, "packageFragment");
                j.p(fVar, "name");
                h c = abVar.dXR().c(fVar, c.FROM_BUILTINS);
                if (!(c instanceof e)) {
                    c = null;
                }
                e eVar = (e) c;
                if (eVar == null) {
                    Throwable illegalStateException = new IllegalStateException(("Class " + fVar + " not found in " + abVar).toString());
                    AppMethodBeat.o(119139);
                    throw illegalStateException;
                }
                an dXY = eVar.dXY();
                j.o(dXY, "descriptor.typeConstructor");
                Iterable<ar> y = t.y(this.BcQ.getParameters(), dXY.getParameters().size());
                Collection arrayList = new ArrayList(a.a.m.d(y));
                for (ar dZf : y) {
                    arrayList.add(new a.i.b.a.c.l.ar(dZf.dZf()));
                }
                List list = (List) arrayList;
                ArrayList arrayList2 = this.BcP;
                a.i.b.a.c.b.a.g.a aVar = g.BfJ;
                arrayList2.add(x.a(a.i.b.a.c.b.a.g.a.eai(), eVar, list));
                AppMethodBeat.o(119139);
            }
        }

        public a() {
            super(b.this.Baf);
            AppMethodBeat.i(119144);
            AppMethodBeat.o(119144);
        }

        public final Collection<w> dYr() {
            a.i.b.a.c.f.b bVar;
            AppMethodBeat.i(119140);
            ArrayList arrayList = new ArrayList(2);
            a aVar = new a(this, arrayList);
            ab e;
            f avX;
            switch (c.eQZ[b.this.BcN.ordinal()]) {
                case 1:
                    bVar = a.i.b.a.c.a.g.AZV;
                    j.o(bVar, "BUILT_INS_PACKAGE_FQ_NAME");
                    e = e(bVar);
                    avX = f.avX("Function");
                    j.o(avX, "Name.identifier(\"Function\")");
                    aVar.a(e, avX);
                    break;
                case 2:
                    e = b.this.BcM;
                    avX = f.avX("KFunction");
                    j.o(avX, "Name.identifier(\"KFunction\")");
                    aVar.a(e, avX);
                    break;
                default:
                    e = b.this.BcM;
                    avX = f.avX(b.this.BcN.BcX);
                    j.o(avX, "Name.identifier(functionKind.classNamePrefix)");
                    aVar.a(e, avX);
                    break;
            }
            switch (c.pCY[b.this.BcN.ordinal()]) {
                case 1:
                    bVar = a.i.b.a.c.a.g.AZV;
                    j.o(bVar, "BUILT_INS_PACKAGE_FQ_NAME");
                    aVar.a(e(bVar), b.Function.SN(b.this.AVt));
                    break;
                case 2:
                    bVar = d.BDS;
                    j.o(bVar, "COROUTINES_PACKAGE_FQ_NAME_RELEASE");
                    aVar.a(e(bVar), b.SuspendFunction.SN(b.this.AVt));
                    break;
            }
            Collection m = t.m(arrayList);
            AppMethodBeat.o(119140);
            return m;
        }

        private final a.i.b.a.c.a.c e(a.i.b.a.c.f.b bVar) {
            AppMethodBeat.i(119141);
            Collection arrayList = new ArrayList();
            for (Object next : b.this.BcM.dZE().g(bVar).getFragments()) {
                if (next instanceof a.i.b.a.c.a.c) {
                    arrayList.add(next);
                }
            }
            a.i.b.a.c.a.c cVar = (a.i.b.a.c.a.c) t.fJ((List) arrayList);
            AppMethodBeat.o(119141);
            return cVar;
        }

        public final List<ar> getParameters() {
            AppMethodBeat.i(119142);
            List b = b.this.parameters;
            AppMethodBeat.o(119142);
            return b;
        }

        public final boolean dYu() {
            return true;
        }

        public final ap dYv() {
            return a.i.b.a.c.b.ap.a.BeT;
        }

        public final /* bridge */ /* synthetic */ h dYs() {
            return b.this;
        }

        public final /* bridge */ /* synthetic */ e dYt() {
            return b.this;
        }

        public final String toString() {
            AppMethodBeat.i(119143);
            String bVar = b.this.toString();
            AppMethodBeat.o(119143);
            return bVar;
        }
    }

    public enum b {
        Function(r3, "Function"),
        SuspendFunction(r3, "SuspendFunction"),
        KFunction(a.i.b.a.c.a.j.dXT(), "KFunction"),
        KSuspendFunction(a.i.b.a.c.a.j.dXT(), "KSuspendFunction");
        
        public static final a BcY = null;
        public final a.i.b.a.c.f.b BcW;
        public final String BcX;

        public static final class a {
            private a() {
            }

            public /* synthetic */ a(byte b) {
                this();
            }
        }

        private b(a.i.b.a.c.f.b bVar, String str) {
            j.p(bVar, "packageFqName");
            j.p(str, "classNamePrefix");
            AppMethodBeat.i(119147);
            this.BcW = bVar;
            this.BcX = str;
            AppMethodBeat.o(119147);
        }

        static {
            BcY = new a();
            AppMethodBeat.o(119145);
        }

        public final f SN(int i) {
            AppMethodBeat.i(119146);
            f avX = f.avX(this.BcX + i);
            j.o(avX, "Name.identifier(\"$classNamePrefix$arity\")");
            AppMethodBeat.o(119146);
            return avX;
        }
    }

    public final /* bridge */ /* synthetic */ e dYa() {
        return null;
    }

    public final /* bridge */ /* synthetic */ a.i.b.a.c.b.d dYe() {
        return null;
    }

    public b(i iVar, ab abVar, b bVar, int i) {
        j.p(iVar, "storageManager");
        j.p(abVar, "containingDeclaration");
        j.p(bVar, "functionKind");
        super(iVar, bVar.SN(i));
        AppMethodBeat.i(119154);
        this.Baf = iVar;
        this.BcM = abVar;
        this.BcN = bVar;
        this.AVt = i;
        final ArrayList arrayList = new ArrayList();
        AnonymousClass1 anonymousClass1 = new m<ba, String, y>(this) {
            final /* synthetic */ b BcO;

            public final /* synthetic */ Object m(Object obj, Object obj2) {
                AppMethodBeat.i(119135);
                a((ba) obj, (String) obj2);
                y yVar = y.AUy;
                AppMethodBeat.o(119135);
                return yVar;
            }

            public final void a(ba baVar, String str) {
                AppMethodBeat.i(119136);
                j.p(baVar, "variance");
                j.p(str, "name");
                ArrayList arrayList = arrayList;
                l lVar = this.BcO;
                a.i.b.a.c.b.a.g.a aVar = g.BfJ;
                arrayList.add(ah.a(lVar, a.i.b.a.c.b.a.g.a.eai(), baVar, f.avX(str), arrayList.size()));
                AppMethodBeat.o(119136);
            }
        };
        Iterable dVar = new a.h.d(1, this.AVt);
        Collection arrayList2 = new ArrayList(a.a.m.d(dVar));
        Iterator it = dVar.iterator();
        while (it.hasNext()) {
            anonymousClass1.a(ba.IN_VARIANCE, "P".concat(String.valueOf(((a.a.ab) it).nextInt())));
            arrayList2.add(y.AUy);
        }
        anonymousClass1.a(ba.OUT_VARIANCE, "R");
        this.parameters = t.m(arrayList);
        AppMethodBeat.o(119154);
    }

    public final an dXY() {
        return this.BcK;
    }

    public final a.i.b.a.c.b.f dYc() {
        return a.i.b.a.c.b.f.INTERFACE;
    }

    public final a.i.b.a.c.b.w dYd() {
        return a.i.b.a.c.b.w.ABSTRACT;
    }

    public final az dYf() {
        AppMethodBeat.i(119150);
        az azVar = ay.Bfa;
        j.o(azVar, "Visibilities.PUBLIC");
        AppMethodBeat.o(119150);
        return azVar;
    }

    public final boolean dYg() {
        return false;
    }

    public final boolean dYh() {
        return false;
    }

    public final boolean dYi() {
        return false;
    }

    public final boolean dYj() {
        return false;
    }

    public final boolean dYk() {
        return false;
    }

    public final boolean dYl() {
        return false;
    }

    public final boolean dYm() {
        return false;
    }

    public final g dYn() {
        AppMethodBeat.i(119151);
        a.i.b.a.c.b.a.g.a aVar = g.BfJ;
        g eai = a.i.b.a.c.b.a.g.a.eai();
        AppMethodBeat.o(119151);
        return eai;
    }

    public final am dYo() {
        AppMethodBeat.i(119152);
        am amVar = am.BeR;
        j.o(amVar, "SourceElement.NO_SOURCE");
        AppMethodBeat.o(119152);
        return amVar;
    }

    public final List<ar> dYq() {
        return this.parameters;
    }

    public final /* bridge */ /* synthetic */ l dXW() {
        return this.BcM;
    }

    public final /* bridge */ /* synthetic */ a.i.b.a.c.i.e.h dXX() {
        return a.i.b.a.c.i.e.h.b.BGh;
    }

    public final /* bridge */ /* synthetic */ a.i.b.a.c.i.e.h dXZ() {
        return this.BcL;
    }

    public final /* bridge */ /* synthetic */ Collection dYb() {
        return v.AUP;
    }

    public final /* bridge */ /* synthetic */ Collection dYp() {
        return v.AUP;
    }

    public final String toString() {
        AppMethodBeat.i(119153);
        String str = this.BgZ.name;
        j.o(str, "name.asString()");
        AppMethodBeat.o(119153);
        return str;
    }
}
