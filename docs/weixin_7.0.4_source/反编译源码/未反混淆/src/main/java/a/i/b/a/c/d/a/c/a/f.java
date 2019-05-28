package a.i.b.a.c.d.a.c.a;

import a.a.ab;
import a.a.al;
import a.a.m;
import a.a.t;
import a.aa;
import a.f.b.k;
import a.i.b.a.c.b.ap;
import a.i.b.a.c.b.ar;
import a.i.b.a.c.b.as;
import a.i.b.a.c.b.ay;
import a.i.b.a.c.b.az;
import a.i.b.a.c.b.c.g;
import a.i.b.a.c.b.e;
import a.i.b.a.c.b.w;
import a.i.b.a.c.d.a.a.l;
import a.i.b.a.c.d.a.b.d;
import a.i.b.a.c.d.a.c.h;
import a.i.b.a.c.d.a.e.j;
import a.i.b.a.c.d.a.e.v;
import a.i.b.a.c.d.a.n;
import a.i.b.a.c.d.a.p;
import a.i.b.a.c.f.i;
import a.i.b.a.c.i.b.s;
import a.i.b.a.c.l.an;
import a.i.b.a.c.l.ba;
import a.i.b.a.c.l.x;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public final class f extends g implements d {
    private static final Set<String> Bob = al.setOf("equals", "hashCode", "getClass", "wait", "notify", "notifyAll", "toString");
    public static final a Boc = new a();
    private final boolean BeM;
    private final a.i.b.a.c.b.a.g Bfn;
    private final az BhQ;
    private final w Bhv;
    private final a.i.b.a.c.b.f Bhw;
    public final a.i.b.a.c.d.a.e.g BnJ;
    final b BnV;
    public final g BnW;
    private final a.i.b.a.c.i.e.f BnX;
    private final l BnY;
    private final a.i.b.a.c.k.f<List<ar>> BnZ;
    public final h Bnn;
    private final e Boa;

    static final class c extends k implements a.f.a.a<List<? extends ar>> {
        final /* synthetic */ f Boe;

        c(f fVar) {
            this.Boe = fVar;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.i(119894);
            Iterable<a.i.b.a.c.d.a.e.w> dYS = this.Boe.BnJ.dYS();
            Collection arrayList = new ArrayList(m.d(dYS));
            for (a.i.b.a.c.d.a.e.w wVar : dYS) {
                ar a = this.Boe.Bnn.Bnw.a(wVar);
                if (a == null) {
                    Throwable assertionError = new AssertionError("Parameter " + wVar + " surely belongs to class " + this.Boe.BnJ + ", so it must be resolved");
                    AppMethodBeat.o(119894);
                    throw assertionError;
                }
                arrayList.add(a);
            }
            List list = (List) arrayList;
            AppMethodBeat.o(119894);
            return list;
        }
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }
    }

    final class b extends a.i.b.a.c.l.b {
        private final a.i.b.a.c.k.f<List<ar>> Bod;

        static final class a extends k implements a.f.a.a<List<? extends ar>> {
            final /* synthetic */ b Bof;

            a(b bVar) {
                this.Bof = bVar;
                super(0);
            }

            public final /* synthetic */ Object invoke() {
                AppMethodBeat.i(119887);
                List a = as.a(f.this);
                AppMethodBeat.o(119887);
                return a;
            }
        }

        public b() {
            super(f.this.Bnn.Bnv.Baf);
            AppMethodBeat.i(119893);
            this.Bod = f.this.Bnn.Bnv.Baf.i(new a(this));
            AppMethodBeat.o(119893);
        }

        public final List<ar> getParameters() {
            AppMethodBeat.i(119888);
            List list = (List) this.Bod.invoke();
            AppMethodBeat.o(119888);
            return list;
        }

        public final Collection<a.i.b.a.c.l.w> dYr() {
            int i;
            Object obj = null;
            AppMethodBeat.i(119889);
            Collection<j> eap = f.this.BnJ.eap();
            ArrayList arrayList = new ArrayList(eap.size());
            ArrayList arrayList2 = new ArrayList(0);
            a.i.b.a.c.l.w ebs = ebs();
            for (j jVar : eap) {
                a.i.b.a.c.l.w a = f.this.Bnn.Bnu.a((v) jVar, a.i.b.a.c.d.a.c.b.d.a(l.SUPERTYPE, false, null, 3));
                if (a.ejw().dYs() instanceof a.i.b.a.c.b.aa.b) {
                    arrayList2.add(jVar);
                }
                if (!(a.f.b.j.j(a.ejw(), ebs != null ? ebs.ejw() : null) || a.i.b.a.c.a.g.A(a))) {
                    arrayList.add(a);
                }
            }
            Collection collection = arrayList;
            e c = f.this.Boa;
            if (c != null) {
                obj = a.i.b.a.c.a.b.h.a(c, f.this).ekr().c(c.dZf(), ba.INVARIANT);
            }
            a.i.b.a.c.n.a.b(collection, obj);
            a.i.b.a.c.n.a.b(arrayList, ebs);
            if (arrayList2.isEmpty()) {
                i = 0;
            } else {
                i = 1;
            }
            if (i != 0) {
                a.i.b.a.c.j.a.m mVar = f.this.Bnn.Bnv.BmV;
                e eVar = f.this;
                Iterable<v> iterable = arrayList2;
                Collection arrayList3 = new ArrayList(m.d(iterable));
                for (v vVar : iterable) {
                    if (vVar == null) {
                        a.v vVar2 = new a.v("null cannot be cast to non-null type org.jetbrains.kotlin.load.java.structure.JavaClassifierType");
                        AppMethodBeat.o(119889);
                        throw vVar2;
                    }
                    arrayList3.add(((j) vVar).ebP());
                }
                mVar.a(eVar, (List) arrayList3);
            }
            if ((!((Collection) arrayList).isEmpty() ? 1 : 0) != 0) {
                collection = t.m(arrayList);
                AppMethodBeat.o(119889);
                return collection;
            }
            Collection<a.i.b.a.c.l.w> listOf = a.a.k.listOf(f.this.Bnn.Bnv.BcH.dZD().dXM());
            AppMethodBeat.o(119889);
            return listOf;
        }

        public final ap dYv() {
            AppMethodBeat.i(119891);
            ap apVar = f.this.Bnn.Bnv.Bhr;
            AppMethodBeat.o(119891);
            return apVar;
        }

        public final boolean dYu() {
            return true;
        }

        public final e dYt() {
            return f.this;
        }

        public final String toString() {
            AppMethodBeat.i(119892);
            String str = f.this.BgZ.name;
            a.f.b.j.o(str, "name.asString()");
            AppMethodBeat.o(119892);
            return str;
        }

        /* JADX WARNING: Removed duplicated region for block: B:42:0x00aa  */
        /* JADX WARNING: Removed duplicated region for block: B:38:0x00a1  */
        /* JADX WARNING: Missing block: B:27:0x0085, code skipped:
            r3 = r3 + 1;
     */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private final a.i.b.a.c.l.w ebs() {
            a.i.b.a.c.f.b bVar;
            Object i;
            int length;
            int i2;
            AppMethodBeat.i(119890);
            a.i.b.a.c.b.a.g dYn = f.this.dYn();
            a.i.b.a.c.f.b bVar2 = p.Blu;
            a.f.b.j.o(bVar2, "JvmAnnotationNames.PURELY_IMPLEMENTS_ANNOTATION");
            a.i.b.a.c.b.a.c i3 = dYn.i(bVar2);
            if (i3 == null) {
                bVar = null;
            } else {
                i = t.i((Iterable) i3.eah().values());
                if (!(i instanceof s)) {
                    i = null;
                }
                s sVar = (s) i;
                if (sVar != null) {
                    String str = (String) sVar.getValue();
                    if (str != null) {
                        if (str != null) {
                            i iVar = i.BEGINNING;
                            length = str.length();
                            int i4 = 0;
                            while (i4 < length) {
                                char charAt = str.charAt(i4);
                                switch (a.i.b.a.c.f.e.eQZ[iVar.ordinal()]) {
                                    case 1:
                                    case 2:
                                        if (!Character.isJavaIdentifierPart(charAt)) {
                                            break;
                                        }
                                        iVar = i.MIDDLE;
                                        continue;
                                    case 3:
                                        if (charAt != '.') {
                                            if (!Character.isJavaIdentifierPart(charAt)) {
                                                break;
                                            }
                                            break;
                                        }
                                        iVar = i.AFTER_DOT;
                                        continue;
                                    default:
                                        break;
                                }
                            }
                            if (iVar != i.AFTER_DOT) {
                                i2 = 1;
                                if (i2 != 0) {
                                    bVar = null;
                                } else {
                                    bVar = new a.i.b.a.c.f.b(str);
                                }
                            }
                        }
                        i2 = 0;
                        if (i2 != 0) {
                        }
                    }
                }
                bVar = null;
            }
            if (bVar != null) {
                int i5 = (bVar.ByQ.ByV.isEmpty() || !bVar.r(a.i.b.a.c.a.g.AZU)) ? 0 : 1;
                if (i5 == 0) {
                    bVar = null;
                }
            } else {
                bVar = null;
            }
            if (bVar == null) {
                a.i.b.a.c.d.a.i iVar2 = a.i.b.a.c.d.a.i.Bld;
                bVar2 = a.i.b.a.c.d.a.i.k(a.i.b.a.c.i.c.a.o(f.this));
            } else {
                bVar2 = bVar;
            }
            if (bVar2 == null) {
                AppMethodBeat.o(119890);
                return null;
            }
            e b = a.i.b.a.c.i.c.a.b(f.this.Bnn.Bnv.BcH, bVar2, a.i.b.a.c.c.a.c.FROM_JAVA_LOADER);
            if (b == null) {
                AppMethodBeat.o(119890);
                return null;
            }
            List list;
            an dXY = b.dXY();
            a.f.b.j.o(dXY, "classDescriptor.typeConstructor");
            i2 = dXY.getParameters().size();
            List parameters = f.this.BnV.getParameters();
            a.f.b.j.o(parameters, "getTypeConstructor().parameters");
            length = parameters.size();
            Collection arrayList;
            Iterator it;
            if (length == i2) {
                Iterable<ar> iterable = parameters;
                arrayList = new ArrayList(m.d(iterable));
                for (ar arVar : iterable) {
                    ba baVar = ba.INVARIANT;
                    a.f.b.j.o(arVar, "parameter");
                    arrayList.add(new a.i.b.a.c.l.ar(baVar, arVar.dZf()));
                }
                list = (List) arrayList;
            } else if (length == 1 && i2 > 1 && bVar == null) {
                ba baVar2 = ba.INVARIANT;
                i = t.fN(parameters);
                a.f.b.j.o(i, "typeParameters.single()");
                a.i.b.a.c.l.ar arVar2 = new a.i.b.a.c.l.ar(baVar2, ((ar) i).dZf());
                Iterable dVar = new a.h.d(1, i2);
                arrayList = new ArrayList(m.d(dVar));
                it = dVar.iterator();
                while (it.hasNext()) {
                    ((ab) it).nextInt();
                    arrayList.add(arVar2);
                }
                list = (List) arrayList;
            } else {
                AppMethodBeat.o(119890);
                return null;
            }
            a.i.b.a.c.b.a.g.a aVar = a.i.b.a.c.b.a.g.BfJ;
            a.i.b.a.c.l.w a = x.a(a.i.b.a.c.b.a.g.a.eai(), b, list);
            AppMethodBeat.o(119890);
            return a;
        }

        public final /* bridge */ /* synthetic */ a.i.b.a.c.b.h dYs() {
            return f.this;
        }
    }

    public final /* synthetic */ Collection dYb() {
        AppMethodBeat.i(119897);
        Collection ebr = ebr();
        AppMethodBeat.o(119897);
        return ebr;
    }

    public /* synthetic */ f(h hVar, a.i.b.a.c.b.l lVar, a.i.b.a.c.d.a.e.g gVar) {
        this(hVar, lVar, gVar, null);
    }

    static {
        AppMethodBeat.i(119901);
        AppMethodBeat.o(119901);
    }

    public final a.i.b.a.c.b.f dYc() {
        return this.Bhw;
    }

    public final w dYd() {
        return this.Bhv;
    }

    public final az dYf() {
        AppMethodBeat.i(119895);
        Object obj = (a.f.b.j.j(this.BhQ, ay.BeW) && this.BnJ.ebG() == null) ? n.Blg : this.BhQ;
        a.f.b.j.o(obj, "if (visibility == Visibi…ISIBILITY else visibility");
        AppMethodBeat.o(119895);
        return obj;
    }

    public final boolean dYh() {
        return this.BeM;
    }

    public final boolean dYi() {
        return false;
    }

    public final boolean dYj() {
        return false;
    }

    public final boolean dYg() {
        return false;
    }

    public final boolean dYk() {
        return false;
    }

    public final boolean dYl() {
        return false;
    }

    public final an dXY() {
        return this.BnV;
    }

    public final a.i.b.a.c.i.e.h dZk() {
        return this.BnX;
    }

    public final a.i.b.a.c.i.e.h dXX() {
        return this.BnY;
    }

    public final a.i.b.a.c.b.d dYe() {
        return null;
    }

    public final e dYa() {
        return null;
    }

    public final List<a.i.b.a.c.b.d> ebr() {
        AppMethodBeat.i(119896);
        List list = (List) this.BnW.Bog.invoke();
        AppMethodBeat.o(119896);
        return list;
    }

    public final a.i.b.a.c.b.a.g dYn() {
        return this.Bfn;
    }

    public final List<ar> dYq() {
        AppMethodBeat.i(119898);
        List list = (List) this.BnZ.invoke();
        AppMethodBeat.o(119898);
        return list;
    }

    public final String toString() {
        AppMethodBeat.i(119899);
        String str = "Lazy Java class " + a.i.b.a.c.i.c.a.q(this);
        AppMethodBeat.o(119899);
        return str;
    }

    public final /* bridge */ /* synthetic */ a.i.b.a.c.i.e.h dXZ() {
        return this.BnW;
    }

    public final Collection<e> dYp() {
        return a.a.v.AUP;
    }

    public f(h hVar, a.i.b.a.c.b.l lVar, a.i.b.a.c.d.a.e.g gVar, e eVar) {
        a.i.b.a.c.b.f fVar;
        w wVar;
        boolean z = true;
        a.f.b.j.p(hVar, "outerContext");
        a.f.b.j.p(lVar, "containingDeclaration");
        a.f.b.j.p(gVar, "jClass");
        super(hVar.Bnv.Baf, lVar, gVar.dZg(), hVar.Bnv.BmZ.a(gVar));
        AppMethodBeat.i(119900);
        this.BnJ = gVar;
        this.Boa = eVar;
        this.Bnn = a.i.b.a.c.d.a.c.a.a(hVar, (a.i.b.a.c.b.g) this, (a.i.b.a.c.d.a.e.x) this.BnJ, 4);
        boolean z2 = aa.AUz;
        if (this.BnJ.ebH()) {
            fVar = a.i.b.a.c.b.f.ANNOTATION_CLASS;
        } else if (this.BnJ.isInterface()) {
            fVar = a.i.b.a.c.b.f.INTERFACE;
        } else if (this.BnJ.isEnum()) {
            fVar = a.i.b.a.c.b.f.ENUM_CLASS;
        } else {
            fVar = a.i.b.a.c.b.f.CLASS;
        }
        this.Bhw = fVar;
        if (this.BnJ.ebH()) {
            wVar = w.FINAL;
        } else {
            a.i.b.a.c.b.w.a aVar = w.BeG;
            z2 = this.BnJ.ebX() || this.BnJ.isInterface();
            wVar = a.i.b.a.c.b.w.a.an(z2, !this.BnJ.ebY());
        }
        this.Bhv = wVar;
        this.BhQ = this.BnJ.dYf();
        if (this.BnJ.ebG() == null || this.BnJ.isStatic()) {
            z = false;
        }
        this.BeM = z;
        this.BnV = new b();
        this.BnW = new g(this.Bnn, this, this.BnJ);
        this.BnX = new a.i.b.a.c.i.e.f(this.BnW);
        this.BnY = new l(this.Bnn, this.BnJ, this);
        this.Bfn = a.i.b.a.c.d.a.c.f.a(this.Bnn, this.BnJ);
        this.BnZ = this.Bnn.Bnv.Baf.i(new c(this));
        AppMethodBeat.o(119900);
    }
}
