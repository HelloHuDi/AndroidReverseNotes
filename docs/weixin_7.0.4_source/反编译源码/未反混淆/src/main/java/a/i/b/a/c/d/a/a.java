package a.i.b.a.c.d.a;

import a.a.l;
import a.a.q;
import a.f.b.i;
import a.f.b.j;
import a.f.b.v;
import a.i.b.a.c.b.e;
import a.i.b.a.c.b.f;
import a.i.b.a.c.k.d;
import a.i.b.a.c.n.g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public final class a {
    private final d<e, a.i.b.a.c.b.a.c> Bkd;
    public final boolean Bke = this.Bkf.ekx();
    public final a.i.b.a.c.n.e Bkf;

    public enum a {
        METHOD_RETURN_TYPE,
        VALUE_PARAMETER,
        FIELD,
        TYPE_USE;

        static {
            AppMethodBeat.o(119641);
        }
    }

    static final class c extends i implements a.f.a.b<e, a.i.b.a.c.b.a.c> {
        c(a aVar) {
            super((Object) aVar);
        }

        public final a.i.d dWF() {
            AppMethodBeat.i(119648);
            a.i.b aN = v.aN(a.class);
            AppMethodBeat.o(119648);
            return aN;
        }

        public final String due() {
            return "computeTypeQualifierNickname(Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;)Lorg/jetbrains/kotlin/descriptors/annotations/AnnotationDescriptor;";
        }

        public final String getName() {
            return "computeTypeQualifierNickname";
        }

        public final /* synthetic */ Object am(Object obj) {
            AppMethodBeat.i(119647);
            e eVar = (e) obj;
            j.p(eVar, "p1");
            a.i.b.a.c.b.a.c a = a.a((a) this.AVx, eVar);
            AppMethodBeat.o(119647);
            return a;
        }
    }

    public static final class b {
        public final a.i.b.a.c.b.a.c Bkl;
        private final int Bkm;

        public b(a.i.b.a.c.b.a.c cVar, int i) {
            j.p(cVar, "typeQualifier");
            AppMethodBeat.i(119646);
            this.Bkl = cVar;
            this.Bkm = i;
            AppMethodBeat.o(119646);
        }

        public final List<a> eaP() {
            AppMethodBeat.i(119644);
            a[] values = a.values();
            Collection arrayList = new ArrayList();
            for (a aVar : values) {
                Object obj;
                b bVar = this;
                if (bVar.a(a.TYPE_USE) || bVar.a(aVar)) {
                    obj = 1;
                } else {
                    obj = null;
                }
                if (obj != null) {
                    arrayList.add(aVar);
                }
            }
            List list = (List) arrayList;
            AppMethodBeat.o(119644);
            return list;
        }

        private final boolean a(a aVar) {
            AppMethodBeat.i(119645);
            if ((this.Bkm & (1 << aVar.ordinal())) != 0) {
                AppMethodBeat.o(119645);
                return true;
            }
            AppMethodBeat.o(119645);
            return false;
        }
    }

    public a(a.i.b.a.c.k.i iVar, a.i.b.a.c.n.e eVar) {
        j.p(iVar, "storageManager");
        j.p(eVar, "jsr305State");
        AppMethodBeat.i(119655);
        this.Bkf = eVar;
        this.Bkd = iVar.g(new c(this));
        AppMethodBeat.o(119655);
    }

    public final a.i.b.a.c.b.a.c d(a.i.b.a.c.b.a.c cVar) {
        AppMethodBeat.i(119649);
        j.p(cVar, "annotationDescriptor");
        if (this.Bkf.ekx()) {
            AppMethodBeat.o(119649);
            return null;
        }
        e l = a.i.b.a.c.i.c.a.l(cVar);
        if (l == null) {
            AppMethodBeat.o(119649);
            return null;
        } else if (b.r(l)) {
            AppMethodBeat.o(119649);
            return cVar;
        } else if (l.dYc() != f.ANNOTATION_CLASS) {
            AppMethodBeat.o(119649);
            return null;
        } else {
            a.i.b.a.c.b.a.c cVar2 = (a.i.b.a.c.b.a.c) this.Bkd.am(l);
            AppMethodBeat.o(119649);
            return cVar2;
        }
    }

    public final b e(a.i.b.a.c.b.a.c cVar) {
        AppMethodBeat.i(119650);
        j.p(cVar, "annotationDescriptor");
        if (this.Bkf.ekx()) {
            AppMethodBeat.o(119650);
            return null;
        }
        e l = a.i.b.a.c.i.c.a.l(cVar);
        if (l != null) {
            e eVar;
            if (l.dYn().j(b.Bkp)) {
                eVar = l;
            } else {
                eVar = null;
            }
            if (eVar != null) {
                Object obj;
                l = a.i.b.a.c.i.c.a.l(cVar);
                if (l == null) {
                    j.dWJ();
                }
                a.i.b.a.c.b.a.c i = l.dYn().i(b.Bkp);
                if (i == null) {
                    j.dWJ();
                }
                Map eah = i.eah();
                Collection arrayList = new ArrayList();
                for (Entry entry : eah.entrySet()) {
                    List a;
                    a.i.b.a.c.f.f fVar = (a.i.b.a.c.f.f) entry.getKey();
                    a.i.b.a.c.i.b.f fVar2 = (a.i.b.a.c.i.b.f) entry.getValue();
                    if (j.j(fVar, p.Bln)) {
                        a = a(fVar2);
                    } else {
                        a = a.a.v.AUP;
                    }
                    q.a(arrayList, (Iterable) a);
                }
                int i2 = 0;
                for (a ordinal : (List) arrayList) {
                    i2 = (1 << ordinal.ordinal()) | i2;
                }
                for (Object next : eVar.dYn()) {
                    int i3;
                    if (d((a.i.b.a.c.b.a.c) next) != null) {
                        i3 = 1;
                        continue;
                    } else {
                        i3 = 0;
                        continue;
                    }
                    if (i3 != 0) {
                        obj = next;
                        break;
                    }
                }
                b obj2 = null;
                i = (a.i.b.a.c.b.a.c) obj2;
                if (i == null) {
                    AppMethodBeat.o(119650);
                    return null;
                }
                b bVar = new b(i, i2);
                AppMethodBeat.o(119650);
                return bVar;
            }
        }
        AppMethodBeat.o(119650);
        return null;
    }

    public final g f(a.i.b.a.c.b.a.c cVar) {
        AppMethodBeat.i(119651);
        j.p(cVar, "annotationDescriptor");
        g g = g(cVar);
        if (g != null) {
            AppMethodBeat.o(119651);
            return g;
        }
        g = this.Bkf.BMZ;
        AppMethodBeat.o(119651);
        return g;
    }

    public final g g(a.i.b.a.c.b.a.c cVar) {
        Object obj;
        AppMethodBeat.i(119652);
        j.p(cVar, "annotationDescriptor");
        Map map = this.Bkf.BNb;
        a.i.b.a.c.f.b dZF = cVar.dZF();
        if (dZF != null) {
            obj = dZF.ByQ.ByV;
        } else {
            obj = null;
        }
        g gVar = (g) map.get(obj);
        if (gVar != null) {
            AppMethodBeat.o(119652);
            return gVar;
        }
        e l = a.i.b.a.c.i.c.a.l(cVar);
        if (l != null) {
            gVar = q(l);
            AppMethodBeat.o(119652);
            return gVar;
        }
        AppMethodBeat.o(119652);
        return null;
    }

    private final g q(e eVar) {
        AppMethodBeat.i(119653);
        a.i.b.a.c.b.a.c i = eVar.dYn().i(b.Bkq);
        a.i.b.a.c.i.b.f m = i != null ? a.i.b.a.c.i.c.a.m(i) : null;
        if (!(m instanceof a.i.b.a.c.i.b.i)) {
            m = null;
        }
        a.i.b.a.c.i.b.i iVar = (a.i.b.a.c.i.b.i) m;
        if (iVar == null) {
            AppMethodBeat.o(119653);
            return null;
        }
        g gVar = this.Bkf.BNa;
        if (gVar != null) {
            AppMethodBeat.o(119653);
            return gVar;
        }
        String str = iVar.BES.name;
        g gVar2;
        switch (str.hashCode()) {
            case -2137067054:
                if (str.equals("IGNORE")) {
                    gVar2 = g.IGNORE;
                    AppMethodBeat.o(119653);
                    return gVar2;
                }
                break;
            case -1838656823:
                if (str.equals("STRICT")) {
                    gVar2 = g.STRICT;
                    AppMethodBeat.o(119653);
                    return gVar2;
                }
                break;
            case 2656902:
                if (str.equals("WARN")) {
                    gVar2 = g.WARN;
                    AppMethodBeat.o(119653);
                    return gVar2;
                }
                break;
        }
        AppMethodBeat.o(119653);
        return null;
    }

    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final List<a> a(a.i.b.a.c.i.b.f<?> fVar) {
        AppMethodBeat.i(119654);
        if (fVar instanceof a.i.b.a.c.i.b.b) {
            Collection arrayList = new ArrayList();
            for (a.i.b.a.c.i.b.f a : (Iterable) ((a.i.b.a.c.i.b.b) fVar).getValue()) {
                q.a(arrayList, (Iterable) a(a));
            }
            List list = (List) arrayList;
            AppMethodBeat.o(119654);
            return list;
        } else if (fVar instanceof a.i.b.a.c.i.b.i) {
            Object obj;
            String ehN = ((a.i.b.a.c.i.b.i) fVar).BES.ehN();
            switch (ehN.hashCode()) {
                case -2024225567:
                    if (ehN.equals("METHOD")) {
                        obj = a.METHOD_RETURN_TYPE;
                        break;
                    }
                case 66889946:
                    if (ehN.equals("FIELD")) {
                        obj = a.FIELD;
                        break;
                    }
                case 107598562:
                    if (ehN.equals("TYPE_USE")) {
                        obj = a.TYPE_USE;
                        break;
                    }
                case 446088073:
                    if (ehN.equals("PARAMETER")) {
                        obj = a.VALUE_PARAMETER;
                        break;
                    }
                default:
                    obj = null;
                    break;
            }
            List<a> dm = l.dm(obj);
            AppMethodBeat.o(119654);
            return dm;
        } else {
            List<a> list2 = a.a.v.AUP;
            AppMethodBeat.o(119654);
            return list2;
        }
    }

    public static final /* synthetic */ a.i.b.a.c.b.a.c a(a aVar, e eVar) {
        AppMethodBeat.i(119656);
        if (eVar.dYn().j(b.Bkn)) {
            for (a.i.b.a.c.b.a.c d : eVar.dYn()) {
                a.i.b.a.c.b.a.c d2 = aVar.d(d2);
                if (d2 != null) {
                    AppMethodBeat.o(119656);
                    return d2;
                }
            }
        }
        AppMethodBeat.o(119656);
        return null;
    }
}
