package a.i.b.a.c.a.a;

import a.a.m;
import a.a.t;
import a.a.y;
import a.aa;
import a.f.b.j;
import a.i.b.a.c.b.a.g;
import a.i.b.a.c.b.ak;
import a.i.b.a.c.b.al;
import a.i.b.a.c.b.am;
import a.i.b.a.c.b.ar;
import a.i.b.a.c.b.au;
import a.i.b.a.c.b.ay;
import a.i.b.a.c.b.c.ad;
import a.i.b.a.c.b.c.ai;
import a.i.b.a.c.b.c.p;
import a.i.b.a.c.b.l;
import a.i.b.a.c.l.ba;
import a.i.b.a.c.l.w;
import a.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.m.e;
import com.tencent.rtmp.sharp.jni.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public final class f extends ad {
    public static final a BcZ = new a();

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }

        /* Code decompiled incorrectly, please refer to instructions dump. */
        private static au a(f fVar, int i, ar arVar) {
            String str;
            AppMethodBeat.i(119159);
            String str2 = arVar.dZg().name;
            j.o(str2, "typeParameter.name.asString()");
            switch (str2.hashCode()) {
                case 69:
                    if (str2.equals(QLog.TAG_REPORTLEVEL_USER)) {
                        str = "receiver";
                        break;
                    }
                case e.CTRL_INDEX /*84*/:
                    if (str2.equals("T")) {
                        str = "instance";
                        break;
                    }
                default:
                    if (str2 != null) {
                        str2 = str2.toLowerCase();
                        j.o(str2, "(this as java.lang.String).toLowerCase()");
                        str = str2;
                        break;
                    }
                    v vVar = new v("null cannot be cast to non-null type java.lang.String");
                    AppMethodBeat.o(119159);
                    throw vVar;
            }
            a.i.b.a.c.b.a aVar = fVar;
            a.i.b.a.c.b.a.g.a aVar2 = g.BfJ;
            g eai = a.i.b.a.c.b.a.g.a.eai();
            a.i.b.a.c.f.f avX = a.i.b.a.c.f.f.avX(str);
            j.o(avX, "Name.identifier(name)");
            a.i.b.a.c.l.ad dZf = arVar.dZf();
            j.o(dZf, "typeParameter.defaultType");
            w wVar = dZf;
            am amVar = am.BeR;
            j.o(amVar, "SourceElement.NO_SOURCE");
            au aiVar = new ai(aVar, null, i, eai, avX, wVar, false, false, false, null, amVar);
            AppMethodBeat.o(119159);
            return aiVar;
        }

        public static f a(b bVar, boolean z) {
            AppMethodBeat.i(119158);
            j.p(bVar, "functionClass");
            List list = bVar.parameters;
            f fVar = new f(bVar, a.i.b.a.c.b.b.a.DECLARATION, z);
            ak dZl = bVar.dZl();
            List list2 = a.a.v.AUP;
            Iterable iterable = list;
            ArrayList arrayList = new ArrayList();
            for (Object next : iterable) {
                boolean z2;
                if (((ar) next).dZh() == ba.IN_VARIANCE) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (!z2) {
                    break;
                }
                arrayList.add(next);
            }
            Iterable<y> p = t.p(arrayList);
            Collection arrayList2 = new ArrayList(m.d(p));
            for (y yVar : p) {
                a aVar = f.BcZ;
                arrayList2.add(a(fVar, yVar.index, (ar) yVar.value));
            }
            fVar.b(null, dZl, list2, (List) arrayList2, ((ar) t.fL(list)).dZf(), a.i.b.a.c.b.w.ABSTRACT, ay.Bfa);
            fVar.rI(true);
            AppMethodBeat.o(119158);
            return fVar;
        }
    }

    static {
        AppMethodBeat.i(119164);
        AppMethodBeat.o(119164);
    }

    private f(l lVar, f fVar, a.i.b.a.c.b.b.a aVar, boolean z) {
        al alVar = fVar;
        a.i.b.a.c.b.a.g.a aVar2 = g.BfJ;
        super(lVar, alVar, a.i.b.a.c.b.a.g.a.eai(), a.i.b.a.c.m.j.BLT, aVar, am.BeR);
        AppMethodBeat.i(119163);
        this.BhR = true;
        this.BhZ = z;
        rH(false);
        AppMethodBeat.o(119163);
    }

    public /* synthetic */ f(l lVar, a.i.b.a.c.b.b.a aVar, boolean z) {
        this(lVar, null, aVar, z);
    }

    public final a.i.b.a.c.b.t a(a.i.b.a.c.b.c.p.a aVar) {
        AppMethodBeat.i(119160);
        j.p(aVar, "configuration");
        f fVar = (f) super.a(aVar);
        if (fVar == null) {
            AppMethodBeat.o(119160);
            return null;
        }
        w dZS;
        Object obj;
        List list = fVar.BhM;
        j.o(list, "substituted.valueParameters");
        Iterable<au> iterable = list;
        if (!((iterable instanceof Collection) && ((Collection) iterable).isEmpty())) {
            for (au auVar : iterable) {
                j.o(auVar, "it");
                dZS = auVar.dZS();
                j.o(dZS, "it.type");
                if (a.i.b.a.c.a.f.k(dZS) != null) {
                    obj = 1;
                    continue;
                } else {
                    obj = null;
                    continue;
                }
                if (obj != null) {
                    obj = null;
                    break;
                }
            }
        }
        int i = 1;
        a.i.b.a.c.b.t tVar;
        if (obj != null) {
            tVar = fVar;
            AppMethodBeat.o(119160);
            return tVar;
        }
        list = fVar.BhM;
        j.o(list, "substituted.valueParameters");
        iterable = list;
        Collection arrayList = new ArrayList(m.d(iterable));
        for (au auVar2 : iterable) {
            j.o(auVar2, "it");
            dZS = auVar2.dZS();
            j.o(dZS, "it.type");
            arrayList.add(a.i.b.a.c.a.f.k(dZS));
        }
        tVar = fVar.fQ((List) arrayList);
        AppMethodBeat.o(119160);
        return tVar;
    }

    public final p a(l lVar, a.i.b.a.c.b.t tVar, a.i.b.a.c.b.b.a aVar, a.i.b.a.c.f.f fVar, g gVar, am amVar) {
        AppMethodBeat.i(119161);
        j.p(lVar, "newOwner");
        j.p(aVar, "kind");
        j.p(gVar, "annotations");
        j.p(amVar, "source");
        p fVar2 = new f(lVar, (f) tVar, aVar, dZv());
        AppMethodBeat.o(119161);
        return fVar2;
    }

    public final boolean dYm() {
        return false;
    }

    public final boolean dYj() {
        return false;
    }

    public final boolean dYx() {
        return false;
    }

    private final a.i.b.a.c.b.t fQ(List<a.i.b.a.c.f.f> list) {
        boolean z = true;
        AppMethodBeat.i(119162);
        int size = this.BhM.size() - list.size();
        boolean z2 = size == 0 || size == 1;
        if (!aa.AUz || z2) {
            a.i.b.a.c.f.f fVar;
            List list2 = this.BhM;
            j.o(list2, "valueParameters");
            Iterable<au> iterable = list2;
            Collection arrayList = new ArrayList(m.d(iterable));
            for (au auVar : iterable) {
                j.o(auVar, "it");
                a.i.b.a.c.f.f dZg = auVar.dZg();
                j.o(dZg, "it.name");
                int index = auVar.getIndex();
                int i = index - size;
                if (i >= 0) {
                    fVar = (a.i.b.a.c.f.f) list.get(i);
                    if (fVar != null) {
                        dZg = fVar;
                    }
                }
                arrayList.add(auVar.a(this, dZg, index));
            }
            List list3 = (List) arrayList;
            a.i.b.a.c.b.c.p.a h = h(a.i.b.a.c.l.au.BJW);
            Iterable<a.i.b.a.c.f.f> iterable2 = list;
            if (!((Collection) iterable2).isEmpty()) {
                for (a.i.b.a.c.f.f fVar2 : iterable2) {
                    if (fVar2 == null) {
                        z2 = true;
                        continue;
                    } else {
                        z2 = false;
                        continue;
                    }
                    if (z2) {
                        break;
                    }
                }
            }
            z = false;
            h.Bix = Boolean.valueOf(z);
            a.i.b.a.c.b.c.p.a h2 = h.fT(list3).h(eaK());
            j.o(h2, "newCopyBuilder(TypeSubst…   .setOriginal(original)");
            a.i.b.a.c.b.t a = super.a(h2);
            if (a == null) {
                j.dWJ();
            }
            AppMethodBeat.o(119162);
            return a;
        }
        Throwable assertionError = new AssertionError("Assertion failed");
        AppMethodBeat.o(119162);
        throw assertionError;
    }
}
