package a.i.b.a.c.b;

import a.a.t;
import a.f.b.i;
import a.f.b.j;
import a.f.b.k;
import a.f.b.v;
import a.i.b.a.c.c.a.c;
import a.i.b.a.c.f.f;
import a.i.b.a.c.i.e.h;
import a.i.d;
import a.j.l;
import a.j.n;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.List;

public final class s {

    static final class b extends k implements a.f.a.b<a.i.b.a.c.f.a, Integer> {
        public static final b BeA = new b();

        static {
            AppMethodBeat.i(119272);
            AppMethodBeat.o(119272);
        }

        b() {
            super(1);
        }

        public final /* synthetic */ Object am(Object obj) {
            AppMethodBeat.i(119271);
            j.p((a.i.b.a.c.f.a) obj, "it");
            Integer valueOf = Integer.valueOf(0);
            AppMethodBeat.o(119271);
            return valueOf;
        }
    }

    static final class a extends i implements a.f.a.b<a.i.b.a.c.f.a, a.i.b.a.c.f.a> {
        public static final a Bez = new a();

        static {
            AppMethodBeat.i(119270);
            AppMethodBeat.o(119270);
        }

        a() {
            super(1);
        }

        public final d dWF() {
            AppMethodBeat.i(119269);
            a.i.b aN = v.aN(a.i.b.a.c.f.a.class);
            AppMethodBeat.o(119269);
            return aN;
        }

        public final String due() {
            return "getOuterClassId()Lorg/jetbrains/kotlin/name/ClassId;";
        }

        public final String getName() {
            return "getOuterClassId";
        }

        public final /* synthetic */ Object am(Object obj) {
            AppMethodBeat.i(119268);
            a.i.b.a.c.f.a aVar = (a.i.b.a.c.f.a) obj;
            j.p(aVar, "p1");
            a.i.b.a.c.f.a ehC = aVar.ehC();
            AppMethodBeat.o(119268);
            return ehC;
        }
    }

    public static final e a(y yVar, a.i.b.a.c.f.a aVar, aa aaVar) {
        AppMethodBeat.i(119274);
        j.p(yVar, "receiver$0");
        j.p(aVar, "classId");
        j.p(aaVar, "notFoundClasses");
        e a = a(yVar, aVar);
        if (a != null) {
            AppMethodBeat.o(119274);
            return a;
        }
        a = aaVar.a(aVar, n.c(n.d(l.a(aVar, a.Bez), b.BeA)));
        AppMethodBeat.o(119274);
        return a;
    }

    public static final e a(y yVar, a.i.b.a.c.f.a aVar) {
        AppMethodBeat.i(119273);
        j.p(yVar, "receiver$0");
        j.p(aVar, "classId");
        a.i.b.a.c.f.b bVar = aVar.BcW;
        j.o(bVar, "classId.packageFqName");
        ad g = yVar.g(bVar);
        List ehM = aVar.ByN.ByQ.ehM();
        j.o(ehM, "classId.relativeClassName.pathSegments()");
        h dXR = g.dXR();
        Object fJ = t.fJ(ehM);
        j.o(fJ, "segments.first()");
        h c = dXR.c((f) fJ, c.FROM_DESERIALIZATION);
        if (!(c instanceof e)) {
            c = null;
        }
        e eVar = (e) c;
        if (eVar == null) {
            AppMethodBeat.o(119273);
            return null;
        }
        Iterator it = ehM.subList(1, ehM.size()).iterator();
        while (true) {
            e eVar2 = eVar;
            if (it.hasNext()) {
                f fVar = (f) it.next();
                h dZk = eVar2.dZk();
                j.o(fVar, "name");
                c = dZk.c(fVar, c.FROM_DESERIALIZATION);
                if (!(c instanceof e)) {
                    c = null;
                }
                eVar = (e) c;
                if (eVar == null) {
                    AppMethodBeat.o(119273);
                    return null;
                }
            } else {
                AppMethodBeat.o(119273);
                return eVar2;
            }
        }
    }
}
