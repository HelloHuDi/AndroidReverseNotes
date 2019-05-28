package a.i.b.a.c.i.b;

import a.a.i;
import a.a.t;
import a.f.b.j;
import a.f.b.k;
import a.i.b.a.c.a.h;
import a.i.b.a.c.b.y;
import a.i.b.a.c.l.ad;
import a.i.b.a.c.l.w;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public final class g {
    public static final g BEO = new g();

    static final class a extends k implements a.f.a.b<y, w> {
        final /* synthetic */ w BEP;

        a(w wVar) {
            this.BEP = wVar;
            super(1);
        }

        public final /* synthetic */ Object am(Object obj) {
            AppMethodBeat.i(122078);
            j.p((y) obj, "it");
            w wVar = this.BEP;
            AppMethodBeat.o(122078);
            return wVar;
        }
    }

    static final class b extends k implements a.f.a.b<y, ad> {
        final /* synthetic */ h BEQ;

        b(h hVar) {
            this.BEQ = hVar;
            super(1);
        }

        public final /* synthetic */ Object am(Object obj) {
            AppMethodBeat.i(122079);
            y yVar = (y) obj;
            j.p(yVar, "module");
            ad b = yVar.dZD().b(this.BEQ);
            j.o(b, "module.builtIns.getPrimi…KotlinType(componentType)");
            AppMethodBeat.o(122079);
            return b;
        }
    }

    static {
        AppMethodBeat.i(122083);
        AppMethodBeat.o(122083);
    }

    private g() {
    }

    public static b a(List<? extends f<?>> list, w wVar) {
        AppMethodBeat.i(122080);
        j.p(list, "value");
        j.p(wVar, "type");
        b bVar = new b(list, new a(wVar));
        AppMethodBeat.o(122080);
        return bVar;
    }

    public final f<?> dQ(Object obj) {
        AppMethodBeat.i(122081);
        f<?> rVar;
        if (obj instanceof Byte) {
            f dVar = new d(((Number) obj).byteValue());
            AppMethodBeat.o(122081);
            return dVar;
        } else if (obj instanceof Short) {
            rVar = new r(((Number) obj).shortValue());
            AppMethodBeat.o(122081);
            return rVar;
        } else if (obj instanceof Integer) {
            rVar = new l(((Number) obj).intValue());
            AppMethodBeat.o(122081);
            return rVar;
        } else if (obj instanceof Long) {
            rVar = new p(((Number) obj).longValue());
            AppMethodBeat.o(122081);
            return rVar;
        } else if (obj instanceof Character) {
            rVar = new e(((Character) obj).charValue());
            AppMethodBeat.o(122081);
            return rVar;
        } else if (obj instanceof Float) {
            rVar = new k(((Number) obj).floatValue());
            AppMethodBeat.o(122081);
            return rVar;
        } else if (obj instanceof Double) {
            rVar = new h(((Number) obj).doubleValue());
            AppMethodBeat.o(122081);
            return rVar;
        } else if (obj instanceof Boolean) {
            rVar = new c(((Boolean) obj).booleanValue());
            AppMethodBeat.o(122081);
            return rVar;
        } else if (obj instanceof String) {
            rVar = new s((String) obj);
            AppMethodBeat.o(122081);
            return rVar;
        } else if (obj instanceof byte[]) {
            rVar = a(i.cu((byte[]) obj), h.BYTE);
            AppMethodBeat.o(122081);
            return rVar;
        } else if (obj instanceof short[]) {
            rVar = a(i.b((short[]) obj), h.SHORT);
            AppMethodBeat.o(122081);
            return rVar;
        } else if (obj instanceof int[]) {
            rVar = a(i.K((int[]) obj), h.INT);
            AppMethodBeat.o(122081);
            return rVar;
        } else if (obj instanceof long[]) {
            rVar = a(i.g((long[]) obj), h.LONG);
            AppMethodBeat.o(122081);
            return rVar;
        } else if (obj instanceof char[]) {
            rVar = a(i.c((char[]) obj), h.CHAR);
            AppMethodBeat.o(122081);
            return rVar;
        } else if (obj instanceof float[]) {
            rVar = a(i.k((float[]) obj), h.FLOAT);
            AppMethodBeat.o(122081);
            return rVar;
        } else if (obj instanceof double[]) {
            rVar = a(i.e((double[]) obj), h.DOUBLE);
            AppMethodBeat.o(122081);
            return rVar;
        } else if (obj instanceof boolean[]) {
            rVar = a(i.c((boolean[]) obj), h.BOOLEAN);
            AppMethodBeat.o(122081);
            return rVar;
        } else if (obj == null) {
            rVar = new q();
            AppMethodBeat.o(122081);
            return rVar;
        } else {
            AppMethodBeat.o(122081);
            return null;
        }
    }

    private final b a(List<?> list, h hVar) {
        AppMethodBeat.i(122082);
        Collection arrayList = new ArrayList();
        for (Object dQ : t.m(list)) {
            f dQ2 = dQ(dQ);
            if (dQ2 != null) {
                arrayList.add(dQ2);
            }
        }
        b bVar = new b((List) arrayList, new b(hVar));
        AppMethodBeat.o(122082);
        return bVar;
    }
}
