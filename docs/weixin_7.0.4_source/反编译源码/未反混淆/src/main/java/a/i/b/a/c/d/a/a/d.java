package a.i.b.a.c.d.a.a;

import a.a.ag;
import a.a.q;
import a.a.x;
import a.f.a.b;
import a.f.b.j;
import a.f.b.k;
import a.i.b.a.c.a.g;
import a.i.b.a.c.b.a.m;
import a.i.b.a.c.b.a.n;
import a.i.b.a.c.b.au;
import a.i.b.a.c.b.y;
import a.i.b.a.c.i.b.f;
import a.i.b.a.c.i.b.i;
import a.i.b.a.c.l.ad;
import a.i.b.a.c.l.p;
import a.i.b.a.c.l.w;
import a.u;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumSet;
import java.util.List;
import java.util.Map;

public final class d {
    private static final Map<String, EnumSet<n>> Bmg = ag.a(u.I("PACKAGE", EnumSet.noneOf(n.class)), u.I("TYPE", EnumSet.of(n.CLASS, n.FILE)), u.I("ANNOTATION_TYPE", EnumSet.of(n.ANNOTATION_CLASS)), u.I("TYPE_PARAMETER", EnumSet.of(n.TYPE_PARAMETER)), u.I("FIELD", EnumSet.of(n.FIELD)), u.I("LOCAL_VARIABLE", EnumSet.of(n.LOCAL_VARIABLE)), u.I("PARAMETER", EnumSet.of(n.VALUE_PARAMETER)), u.I("CONSTRUCTOR", EnumSet.of(n.CONSTRUCTOR)), u.I("METHOD", EnumSet.of(n.FUNCTION, n.PROPERTY_GETTER, n.PROPERTY_SETTER)), u.I("TYPE_USE", EnumSet.of(n.TYPE)));
    private static final Map<String, m> Bmh = ag.a(u.I("RUNTIME", m.RUNTIME), u.I("CLASS", m.BINARY), u.I("SOURCE", m.SOURCE));
    public static final d Bmi = new d();

    static final class a extends k implements b<y, w> {
        public static final a Bmj = new a();

        static {
            AppMethodBeat.i(119760);
            AppMethodBeat.o(119760);
        }

        a() {
            super(1);
        }

        /* JADX WARNING: Missing block: B:3:0x002a, code skipped:
            if (r0 == null) goto L_0x002c;
     */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final /* synthetic */ Object am(Object obj) {
            Object dZS;
            AppMethodBeat.i(119759);
            y yVar = (y) obj;
            j.p(yVar, "module");
            c cVar = c.Bmf;
            au b = a.b(c.ebj(), yVar.dZD().c(g.Bag.BaQ));
            if (b != null) {
                dZS = b.dZS();
            }
            ad awn = p.awn("Error: AnnotationTarget[]");
            j.o(awn, "ErrorUtils.createErrorTy…ror: AnnotationTarget[]\")");
            dZS = awn;
            AppMethodBeat.o(119759);
            return dZS;
        }
    }

    static {
        AppMethodBeat.i(119763);
        AppMethodBeat.o(119763);
    }

    private d() {
    }

    public static f<?> fW(List<? extends a.i.b.a.c.d.a.e.b> list) {
        AppMethodBeat.i(119761);
        j.p(list, "arguments");
        Collection arrayList = new ArrayList();
        for (Object next : list) {
            if (next instanceof a.i.b.a.c.d.a.e.m) {
                arrayList.add(next);
            }
        }
        Collection arrayList2 = new ArrayList();
        for (a.i.b.a.c.d.a.e.m ebR : (List) arrayList) {
            Object obj;
            a.i.b.a.c.f.f ebR2 = ebR.ebR();
            if (ebR2 != null) {
                obj = ebR2.name;
            } else {
                obj = null;
            }
            x xVar = (EnumSet) Bmg.get(obj);
            if (xVar == null) {
                xVar = x.AUR;
            }
            q.a(arrayList2, (Iterable) xVar);
        }
        Iterable<n> iterable = (List) arrayList2;
        arrayList = new ArrayList(a.a.m.d(iterable));
        for (n nVar : iterable) {
            a.i.b.a.c.f.a n = a.i.b.a.c.f.a.n(g.Bag.BaR);
            j.o(n, "ClassId.topLevel(KotlinB…Q_NAMES.annotationTarget)");
            a.i.b.a.c.f.f avX = a.i.b.a.c.f.f.avX(nVar.name());
            j.o(avX, "Name.identifier(kotlinTarget.name)");
            arrayList.add(new i(n, avX));
        }
        f bVar = new a.i.b.a.c.i.b.b((List) arrayList, a.Bmj);
        AppMethodBeat.o(119761);
        return bVar;
    }

    public static f<?> a(a.i.b.a.c.d.a.e.b bVar) {
        i iVar;
        AppMethodBeat.i(119762);
        a.i.b.a.c.d.a.e.m mVar = (a.i.b.a.c.d.a.e.m) (!(bVar instanceof a.i.b.a.c.d.a.e.m) ? null : bVar);
        if (mVar != null) {
            Object obj;
            Map map = Bmh;
            a.i.b.a.c.f.f ebR = mVar.ebR();
            if (ebR != null) {
                obj = ebR.name;
            } else {
                obj = null;
            }
            m mVar2 = (m) map.get(obj);
            if (mVar2 != null) {
                a.i.b.a.c.f.a n = a.i.b.a.c.f.a.n(g.Bag.BaS);
                j.o(n, "ClassId.topLevel(KotlinB…AMES.annotationRetention)");
                ebR = a.i.b.a.c.f.f.avX(mVar2.name());
                j.o(ebR, "Name.identifier(retention.name)");
                iVar = new i(n, ebR);
            } else {
                iVar = null;
            }
        } else {
            iVar = null;
        }
        f fVar = iVar;
        AppMethodBeat.o(119762);
        return fVar;
    }
}
