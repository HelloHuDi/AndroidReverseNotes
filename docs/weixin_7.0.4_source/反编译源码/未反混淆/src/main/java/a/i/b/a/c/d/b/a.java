package a.i.b.a.c.d.b;

import a.a.l;
import a.a.m;
import a.a.t;
import a.a.v;
import a.f.b.j;
import a.f.b.k;
import a.i.b.a.c.b.am;
import a.i.b.a.c.d.a.p;
import a.i.b.a.c.e.a.aa;
import a.i.b.a.c.e.a.ae;
import a.i.b.a.c.e.a.ai;
import a.i.b.a.c.e.a.h;
import a.i.b.a.c.e.a.o;
import a.i.b.a.c.e.a.u;
import a.i.b.a.c.e.b.a.g;
import a.i.b.a.c.g.q;
import a.i.b.a.c.j.a.s;
import a.i.b.a.c.k.i;
import a.i.b.a.c.l.w;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.baseutils.IOUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public abstract class a<A, C> implements a.i.b.a.c.j.a.b<A, C> {
    private static final Set<a.i.b.a.c.f.a> BqO;
    private static final a BqP = new a();
    private final m BmS;
    private final a.i.b.a.c.k.c<n, c<A, C>> BqN;

    enum b {
        PROPERTY,
        BACKING_FIELD,
        DELEGATE_FIELD;

        static {
            AppMethodBeat.o(120211);
        }
    }

    public static final class e implements a.i.b.a.c.d.b.n.c {
        final /* synthetic */ ArrayList BcP;
        final /* synthetic */ a BqW;

        e(a aVar, ArrayList arrayList) {
            this.BqW = aVar;
            this.BcP = arrayList;
        }

        public final a.i.b.a.c.d.b.n.a a(a.i.b.a.c.f.a aVar, am amVar) {
            AppMethodBeat.i(120223);
            j.p(aVar, "classId");
            j.p(amVar, "source");
            a.i.b.a.c.d.b.n.a a = a.a(this.BqW, aVar, amVar, (List) this.BcP);
            AppMethodBeat.o(120223);
            return a;
        }

        public final void zn() {
        }
    }

    static final class c<A, C> {
        final Map<q, List<A>> BqU;
        final Map<q, C> BqV;

        public c(Map<q, ? extends List<? extends A>> map, Map<q, ? extends C> map2) {
            j.p(map, "memberAnnotations");
            j.p(map2, "propertyConstants");
            AppMethodBeat.i(120214);
            this.BqU = map;
            this.BqV = map2;
            AppMethodBeat.o(120214);
        }
    }

    public static final class d implements a.i.b.a.c.d.b.n.e {
        final /* synthetic */ a BqW;
        final /* synthetic */ HashMap BqX;
        final /* synthetic */ HashMap BqY;

        public class b implements a.i.b.a.c.d.b.n.c {
            final /* synthetic */ d BqZ;
            private final ArrayList<A> Bra = new ArrayList();
            final q Brb;

            public b(d dVar, q qVar) {
                j.p(qVar, "signature");
                this.BqZ = dVar;
                AppMethodBeat.i(120220);
                this.Brb = qVar;
                AppMethodBeat.o(120220);
            }

            public final a.i.b.a.c.d.b.n.a a(a.i.b.a.c.f.a aVar, am amVar) {
                AppMethodBeat.i(120218);
                j.p(aVar, "classId");
                j.p(amVar, "source");
                a.i.b.a.c.d.b.n.a a = a.a(this.BqZ.BqW, aVar, amVar, (List) this.Bra);
                AppMethodBeat.o(120218);
                return a;
            }

            public final void zn() {
                AppMethodBeat.i(120219);
                if ((!((Collection) this.Bra).isEmpty() ? 1 : null) != null) {
                    this.BqZ.BqX.put(this.Brb, this.Bra);
                }
                AppMethodBeat.o(120219);
            }
        }

        public final class a extends b implements a.i.b.a.c.d.b.n.f {
            final /* synthetic */ d BqZ;

            public a(d dVar, q qVar) {
                j.p(qVar, "signature");
                this.BqZ = dVar;
                super(dVar, qVar);
                AppMethodBeat.i(120217);
                AppMethodBeat.o(120217);
            }

            public final a.i.b.a.c.d.b.n.a a(int i, a.i.b.a.c.f.a aVar, am amVar) {
                AppMethodBeat.i(120216);
                j.p(aVar, "classId");
                j.p(amVar, "source");
                a.i.b.a.c.d.b.q.a aVar2 = q.BrI;
                q a = a.i.b.a.c.d.b.q.a.a(this.Brb, i);
                List list = (List) this.BqZ.BqX.get(a);
                if (list == null) {
                    list = new ArrayList();
                    this.BqZ.BqX.put(a, list);
                }
                a.i.b.a.c.d.b.n.a a2 = a.a(this.BqZ.BqW, aVar, amVar, list);
                AppMethodBeat.o(120216);
                return a2;
            }
        }

        d(a aVar, HashMap hashMap, HashMap hashMap2) {
            this.BqW = aVar;
            this.BqX = hashMap;
            this.BqY = hashMap2;
        }

        public final a.i.b.a.c.d.b.n.f a(a.i.b.a.c.f.f fVar, String str) {
            AppMethodBeat.i(120221);
            j.p(fVar, "name");
            j.p(str, "desc");
            a.i.b.a.c.d.b.q.a aVar = q.BrI;
            String str2 = fVar.name;
            j.o(str2, "name.asString()");
            a.i.b.a.c.d.b.n.f aVar2 = new a(this, a.i.b.a.c.d.b.q.a.iT(str2, str));
            AppMethodBeat.o(120221);
            return aVar2;
        }

        public final a.i.b.a.c.d.b.n.c b(a.i.b.a.c.f.f fVar, String str) {
            AppMethodBeat.i(120222);
            j.p(fVar, "name");
            j.p(str, "desc");
            a.i.b.a.c.d.b.q.a aVar = q.BrI;
            String str2 = fVar.name;
            j.o(str2, "name.asString()");
            a.i.b.a.c.d.b.n.c bVar = new b(this, a.i.b.a.c.d.b.q.a.iU(str2, str));
            AppMethodBeat.o(120222);
            return bVar;
        }
    }

    static final class f extends k implements a.f.a.b<n, c<? extends A, ? extends C>> {
        final /* synthetic */ a BqW;

        f(a aVar) {
            this.BqW = aVar;
            super(1);
        }

        public final /* synthetic */ Object am(Object obj) {
            AppMethodBeat.i(120224);
            n nVar = (n) obj;
            j.p(nVar, "kotlinClass");
            c a = a.a(this.BqW, nVar);
            AppMethodBeat.o(120224);
            return a;
        }
    }

    static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }
    }

    public abstract a.i.b.a.c.d.b.n.a a(a.i.b.a.c.f.a aVar, am amVar, List<A> list);

    public abstract A a(a.i.b.a.c.e.a.a aVar, a.i.b.a.c.e.a.c cVar);

    public abstract C dF(C c);

    public a(i iVar, m mVar) {
        j.p(iVar, "storageManager");
        j.p(mVar, "kotlinClassFinder");
        this.BmS = mVar;
        this.BqN = iVar.f(new f(this));
    }

    private static n a(a.i.b.a.c.j.a.s.a aVar) {
        am amVar = aVar.Bfq;
        if (!(amVar instanceof p)) {
            amVar = null;
        }
        p pVar = (p) amVar;
        if (pVar != null) {
            return pVar.BrH;
        }
        return null;
    }

    public final List<A> b(a.i.b.a.c.j.a.s.a aVar) {
        j.p(aVar, "container");
        n a = a(aVar);
        if (a == null) {
            throw new IllegalStateException(("Class for loading annotations is not found: " + aVar.ejR()).toString());
        }
        ArrayList arrayList = new ArrayList(1);
        a.i.b.a.c.d.b.n.c eVar = new e(this, arrayList);
        j.p(a, "kotlinClass");
        a.a(eVar);
        return arrayList;
    }

    public final List<A> a(s sVar, q qVar, a.i.b.a.c.j.a.a aVar) {
        j.p(sVar, "container");
        j.p(qVar, "proto");
        j.p(aVar, "kind");
        if (aVar == a.i.b.a.c.j.a.a.PROPERTY) {
            return a(sVar, (u) qVar, b.PROPERTY);
        }
        q a = a(qVar, sVar.AWq, sVar.AWr, aVar, false);
        return a == null ? v.AUP : a(this, sVar, a, false, null, false, 60);
    }

    public final List<A> a(s sVar, u uVar) {
        j.p(sVar, "container");
        j.p(uVar, "proto");
        return a(sVar, uVar, b.BACKING_FIELD);
    }

    public final List<A> b(s sVar, u uVar) {
        j.p(sVar, "container");
        j.p(uVar, "proto");
        return a(sVar, uVar, b.DELEGATE_FIELD);
    }

    private final List<A> a(s sVar, u uVar, b bVar) {
        Boolean Ug = a.i.b.a.c.e.a.b.BwP.Ug(uVar.BsW);
        j.o(Ug, "Flags.IS_CONST.get(proto.flags)");
        boolean booleanValue = Ug.booleanValue();
        boolean f = a.i.b.a.c.e.b.a.j.f(uVar);
        q a;
        if (bVar == b.PROPERTY) {
            a = a(uVar, sVar.AWq, sVar.AWr, false, true, false, 40);
            if (a == null) {
                return v.AUP;
            }
            return a(this, sVar, a, true, Boolean.valueOf(booleanValue), f, 8);
        }
        a = a(uVar, sVar.AWq, sVar.AWr, true, false, false, 48);
        if (a == null) {
            return v.AUP;
        }
        boolean z;
        boolean a2 = a.k.v.a((CharSequence) a.signature, (CharSequence) "$delegate", false);
        if (bVar == b.DELEGATE_FIELD) {
            z = true;
        } else {
            z = false;
        }
        if (a2 != z) {
            return v.AUP;
        }
        return a(sVar, a, true, true, Boolean.valueOf(booleanValue), f);
    }

    public final List<A> a(s sVar, a.i.b.a.c.e.a.k kVar) {
        j.p(sVar, "container");
        j.p(kVar, "proto");
        a.i.b.a.c.d.b.q.a aVar = q.BrI;
        String string = sVar.AWq.getString(kVar.Buf);
        String pq = ((a.i.b.a.c.j.a.s.a) sVar).BcB.pq();
        j.o(pq, "(container as ProtoConta…Class).classId.asString()");
        return a(this, sVar, a.i.b.a.c.d.b.q.a.iU(string, a.i.b.a.c.e.b.a.c.avV(pq)), false, null, false, 60);
    }

    private final List<A> a(s sVar, q qVar, boolean z, boolean z2, Boolean bool, boolean z3) {
        n a = a(sVar, a(sVar, z, z2, bool, z3));
        if (a == null) {
            return v.AUP;
        }
        List<A> list = (List) ((c) this.BqN.am(a)).BqU.get(qVar);
        if (list == null) {
            return v.AUP;
        }
        return list;
    }

    public final List<A> a(aa aaVar, a.i.b.a.c.e.a.c cVar) {
        j.p(aaVar, "proto");
        j.p(cVar, "nameResolver");
        Object e = aaVar.e(a.i.b.a.c.e.b.b.BxE);
        j.o(e, "proto.getExtension(JvmProtoBuf.typeAnnotation)");
        Iterable<a.i.b.a.c.e.a.a> iterable = (Iterable) e;
        Collection arrayList = new ArrayList(m.d(iterable));
        for (a.i.b.a.c.e.a.a aVar : iterable) {
            j.o(aVar, "it");
            arrayList.add(a(aVar, cVar));
        }
        return (List) arrayList;
    }

    public final List<A> a(ae aeVar, a.i.b.a.c.e.a.c cVar) {
        j.p(aeVar, "proto");
        j.p(cVar, "nameResolver");
        Object e = aeVar.e(a.i.b.a.c.e.b.b.BxG);
        j.o(e, "proto.getExtension(JvmPr….typeParameterAnnotation)");
        Iterable<a.i.b.a.c.e.a.a> iterable = (Iterable) e;
        Collection arrayList = new ArrayList(m.d(iterable));
        for (a.i.b.a.c.e.a.a aVar : iterable) {
            j.o(aVar, "it");
            arrayList.add(a(aVar, cVar));
        }
        return (List) arrayList;
    }

    public final C a(s sVar, u uVar, w wVar) {
        boolean z = true;
        j.p(sVar, "container");
        j.p(uVar, "proto");
        j.p(wVar, "expectedType");
        n a = a(sVar, a(sVar, true, true, a.i.b.a.c.e.a.b.BwP.Ug(uVar.BsW), a.i.b.a.c.e.b.a.j.f(uVar)));
        if (a == null) {
            return null;
        }
        g gVar = a.dXA().Bsd;
        a.i.b.a.c.d.b.e.a aVar = e.Brr;
        a.i.b.a.c.e.a.a ecr = e.Brq;
        j.p(ecr, "version");
        int i = ecr.major;
        int i2 = ecr.minor;
        int i3 = ecr.Bwp;
        if (gVar.major <= i && (gVar.major < i || (gVar.minor <= i2 && (gVar.minor < i2 || gVar.Bwp < i3)))) {
            z = false;
        }
        q a2 = a((q) uVar, sVar.AWq, sVar.AWr, a.i.b.a.c.j.a.a.PROPERTY, z);
        if (a2 == null) {
            return null;
        }
        C c = ((c) this.BqN.am(a)).BqV.get(a2);
        if (c == null) {
            return null;
        }
        a.i.b.a.c.a.m mVar = a.i.b.a.c.a.m.BcG;
        return a.i.b.a.c.a.m.G(wVar) ? dF(c) : c;
    }

    private static n a(s sVar, n nVar) {
        if (nVar != null) {
            return nVar;
        }
        if (sVar instanceof a.i.b.a.c.j.a.s.a) {
            return a((a.i.b.a.c.j.a.s.a) sVar);
        }
        return null;
    }

    private final n a(s sVar, boolean z, boolean z2, Boolean bool, boolean z3) {
        am amVar;
        i iVar;
        if (z) {
            if (bool == null) {
                throw new IllegalStateException(("isConst should not be null for property (container=" + sVar + ')').toString());
            } else if ((sVar instanceof a.i.b.a.c.j.a.s.a) && ((a.i.b.a.c.j.a.s.a) sVar).BHv == a.i.b.a.c.e.a.c.b.INTERFACE) {
                m mVar = this.BmS;
                a.i.b.a.c.f.a p = ((a.i.b.a.c.j.a.s.a) sVar).BcB.p(a.i.b.a.c.f.f.avX("DefaultImpls"));
                j.o(p, "container.classId.create…EFAULT_IMPLS_CLASS_NAME))");
                return mVar.b(p);
            } else if (bool.booleanValue() && (sVar instanceof a.i.b.a.c.j.a.s.b)) {
                a.i.b.a.c.i.d.b bVar;
                amVar = sVar.Bfq;
                if (!(amVar instanceof i)) {
                    amVar = null;
                }
                iVar = (i) amVar;
                if (iVar != null) {
                    bVar = iVar.Bry;
                } else {
                    bVar = null;
                }
                if (bVar != null) {
                    m mVar2 = this.BmS;
                    String str = bVar.BrD;
                    j.o(str, "facadeClassName.internalName");
                    a.i.b.a.c.f.a n = a.i.b.a.c.f.a.n(new a.i.b.a.c.f.b(a.k.u.a(str, IOUtils.DIR_SEPARATOR_UNIX, '.')));
                    j.o(n, "ClassId.topLevel(FqName(…lName.replace('/', '.')))");
                    return mVar2.b(n);
                }
            }
        }
        if (z2 && (sVar instanceof a.i.b.a.c.j.a.s.a) && ((a.i.b.a.c.j.a.s.a) sVar).BHv == a.i.b.a.c.e.a.c.b.COMPANION_OBJECT) {
            a.i.b.a.c.j.a.s.a aVar = ((a.i.b.a.c.j.a.s.a) sVar).BHw;
            if (aVar != null && (aVar.BHv == a.i.b.a.c.e.a.c.b.CLASS || aVar.BHv == a.i.b.a.c.e.a.c.b.ENUM_CLASS || (z3 && (aVar.BHv == a.i.b.a.c.e.a.c.b.INTERFACE || aVar.BHv == a.i.b.a.c.e.a.c.b.ANNOTATION_CLASS)))) {
                return a(aVar);
            }
        }
        if (!(sVar instanceof a.i.b.a.c.j.a.s.b) || !(sVar.Bfq instanceof i)) {
            return null;
        }
        amVar = sVar.Bfq;
        if (amVar == null) {
            throw new a.v("null cannot be cast to non-null type org.jetbrains.kotlin.load.kotlin.JvmPackagePartSource");
        }
        iVar = (i) amVar;
        n nVar = iVar.BrB;
        if (nVar == null) {
            return this.BmS.b(iVar.dWY());
        }
        return nVar;
    }

    private static q a(u uVar, a.i.b.a.c.e.a.c cVar, h hVar, boolean z, boolean z2, boolean z3) {
        a.i.b.a.c.g.i.c cVar2 = uVar;
        a.i.b.a.c.g.i.f fVar = a.i.b.a.c.e.b.b.BxC;
        j.o(fVar, "propertySignature");
        a.i.b.a.c.e.b.b.e eVar = (a.i.b.a.c.e.b.b.e) a.i.b.a.c.e.a.f.a(cVar2, fVar);
        if (eVar == null) {
            return null;
        }
        a.i.b.a.c.d.b.q.a aVar;
        if (z) {
            a.i.b.a.c.e.b.a.j jVar = a.i.b.a.c.e.b.a.j.ByD;
            a.i.b.a.c.e.b.a.f.a a = a.i.b.a.c.e.b.a.j.a(uVar, cVar, hVar, z3);
            if (a == null) {
                return null;
            }
            aVar = q.BrI;
            return a.i.b.a.c.d.b.q.a.a(a);
        } else if (!z2 || !eVar.egX()) {
            return null;
        } else {
            aVar = q.BrI;
            a.i.b.a.c.e.b.b.c cVar3 = eVar.BxR;
            j.o(cVar3, "signature.syntheticMethod");
            return a.i.b.a.c.d.b.q.a.a(cVar, cVar3);
        }
    }

    private static q a(q qVar, a.i.b.a.c.e.a.c cVar, h hVar, a.i.b.a.c.j.a.a aVar, boolean z) {
        a.i.b.a.c.d.b.q.a aVar2;
        a.i.b.a.c.e.b.a.j jVar;
        a.i.b.a.c.e.b.a.f.b a;
        if (qVar instanceof a.i.b.a.c.e.a.e) {
            aVar2 = q.BrI;
            jVar = a.i.b.a.c.e.b.a.j.ByD;
            a = a.i.b.a.c.e.b.a.j.a((a.i.b.a.c.e.a.e) qVar, cVar, hVar);
            if (a != null) {
                return a.i.b.a.c.d.b.q.a.a(a);
            }
            return null;
        } else if (qVar instanceof o) {
            aVar2 = q.BrI;
            jVar = a.i.b.a.c.e.b.a.j.ByD;
            a = a.i.b.a.c.e.b.a.j.a((o) qVar, cVar, hVar);
            return a != null ? a.i.b.a.c.d.b.q.a.a(a) : null;
        } else if (!(qVar instanceof u)) {
            return null;
        } else {
            a.i.b.a.c.g.i.c cVar2 = (a.i.b.a.c.g.i.c) qVar;
            a.i.b.a.c.g.i.f fVar = a.i.b.a.c.e.b.b.BxC;
            j.o(fVar, "propertySignature");
            a.i.b.a.c.e.b.b.e eVar = (a.i.b.a.c.e.b.b.e) a.i.b.a.c.e.a.f.a(cVar2, fVar);
            if (eVar == null) {
                return null;
            }
            a.i.b.a.c.d.b.q.a aVar3;
            a.i.b.a.c.e.b.b.c cVar3;
            switch (b.eQZ[aVar.ordinal()]) {
                case 1:
                    if (!eVar.egY()) {
                        return null;
                    }
                    aVar3 = q.BrI;
                    cVar3 = eVar.BxS;
                    j.o(cVar3, "signature.getter");
                    return a.i.b.a.c.d.b.q.a.a(cVar, cVar3);
                case 2:
                    if (!eVar.egZ()) {
                        return null;
                    }
                    aVar3 = q.BrI;
                    cVar3 = eVar.BxT;
                    j.o(cVar3, "signature.setter");
                    return a.i.b.a.c.d.b.q.a.a(cVar, cVar3);
                case 3:
                    return a((u) qVar, cVar, hVar, true, true, z);
                default:
                    return null;
            }
        }
    }

    static {
        Iterable<a.i.b.a.c.f.b> listOf = l.listOf(p.Bll, p.Blo, p.Blp, new a.i.b.a.c.f.b("java.lang.annotation.Target"), new a.i.b.a.c.f.b("java.lang.annotation.Retention"), new a.i.b.a.c.f.b("java.lang.annotation.Documented"));
        Collection arrayList = new ArrayList(m.d(listOf));
        for (a.i.b.a.c.f.b n : listOf) {
            arrayList.add(a.i.b.a.c.f.a.n(n));
        }
        BqO = t.o((List) arrayList);
    }

    public final List<A> a(s sVar, q qVar, a.i.b.a.c.j.a.a aVar, int i, ai aiVar) {
        j.p(sVar, "container");
        j.p(qVar, "callableProto");
        j.p(aVar, "kind");
        j.p(aiVar, "proto");
        q a = a(qVar, sVar.AWq, sVar.AWr, aVar, false);
        if (a == null) {
            return v.AUP;
        }
        int i2;
        if (qVar instanceof o) {
            i2 = a.i.b.a.c.e.a.g.f((o) qVar) ? 1 : 0;
        } else if (qVar instanceof u) {
            i2 = a.i.b.a.c.e.a.g.e((u) qVar) ? 1 : 0;
        } else if (!(qVar instanceof a.i.b.a.c.e.a.e)) {
            throw new UnsupportedOperationException("Unsupported message: " + qVar.getClass());
        } else if (sVar == null) {
            throw new a.v("null cannot be cast to non-null type org.jetbrains.kotlin.serialization.deserialization.ProtoContainer.Class");
        } else {
            i2 = ((a.i.b.a.c.j.a.s.a) sVar).BHv == a.i.b.a.c.e.a.c.b.ENUM_CLASS ? 2 : ((a.i.b.a.c.j.a.s.a) sVar).BeM ? 1 : 0;
        }
        i2 += i;
        a.i.b.a.c.d.b.q.a aVar2 = q.BrI;
        return a(this, sVar, a.i.b.a.c.d.b.q.a.a(a, i2), false, null, false, 60);
    }

    public final List<A> b(s sVar, q qVar, a.i.b.a.c.j.a.a aVar) {
        j.p(sVar, "container");
        j.p(qVar, "proto");
        j.p(aVar, "kind");
        q a = a(qVar, sVar.AWq, sVar.AWr, aVar, false);
        if (a == null) {
            return v.AUP;
        }
        a.i.b.a.c.d.b.q.a aVar2 = q.BrI;
        return a(this, sVar, a.i.b.a.c.d.b.q.a.a(a, 0), false, null, false, 60);
    }
}
