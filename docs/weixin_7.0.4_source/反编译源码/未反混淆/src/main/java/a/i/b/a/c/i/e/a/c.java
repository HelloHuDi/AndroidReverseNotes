package a.i.b.a.c.i.e.a;

import a.f.b.j;
import a.i.b.a.c.b.e;
import a.i.b.a.c.l.ad;
import a.i.b.a.c.l.w;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class c implements d, g {
    private final c BGv = this;
    private final e BGw = this.BGx;
    private final e BGx;

    public c(e eVar) {
        j.p(eVar, "classDescriptor");
        AppMethodBeat.i(122236);
        this.BGx = eVar;
        AppMethodBeat.o(122236);
    }

    public final /* synthetic */ w dZS() {
        AppMethodBeat.i(122232);
        w ebq = ebq();
        AppMethodBeat.o(122232);
        return ebq;
    }

    public final e dZR() {
        return this.BGx;
    }

    private ad ebq() {
        AppMethodBeat.i(122231);
        ad dZf = this.BGx.dZf();
        j.o(dZf, "classDescriptor.defaultType");
        AppMethodBeat.o(122231);
        return dZf;
    }

    public final boolean equals(Object obj) {
        Object obj2 = null;
        AppMethodBeat.i(122233);
        e eVar = this.BGx;
        c cVar = (c) (!(obj instanceof c) ? null : obj);
        if (cVar != null) {
            obj2 = cVar.BGx;
        }
        boolean j = j.j(eVar, obj2);
        AppMethodBeat.o(122233);
        return j;
    }

    public final int hashCode() {
        AppMethodBeat.i(122234);
        int hashCode = this.BGx.hashCode();
        AppMethodBeat.o(122234);
        return hashCode;
    }

    public final String toString() {
        AppMethodBeat.i(122235);
        String str = "Class{" + ebq() + '}';
        AppMethodBeat.o(122235);
        return str;
    }
}
