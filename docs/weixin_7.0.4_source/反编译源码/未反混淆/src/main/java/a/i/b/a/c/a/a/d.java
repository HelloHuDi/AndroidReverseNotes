package a.i.b.a.c.a.a;

import a.a.k;
import a.f.b.j;
import a.i.b.a.c.a.a.f.a;
import a.i.b.a.c.b.t;
import a.i.b.a.c.i.e.e;
import a.i.b.a.c.k.i;
import a.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

public final class d extends e {
    public d(i iVar, b bVar) {
        j.p(iVar, "storageManager");
        j.p(bVar, "containingClass");
        super(iVar, bVar);
        AppMethodBeat.i(119157);
        AppMethodBeat.o(119157);
    }

    public final List<t> dYw() {
        AppMethodBeat.i(119156);
        a.i.b.a.c.b.e eVar = this.BFZ;
        if (eVar == null) {
            v vVar = new v("null cannot be cast to non-null type org.jetbrains.kotlin.builtins.functions.FunctionClassDescriptor");
            AppMethodBeat.o(119156);
            throw vVar;
        }
        a aVar;
        List<t> listOf;
        switch (e.eQZ[((b) eVar).BcN.ordinal()]) {
            case 1:
                aVar = f.BcZ;
                listOf = k.listOf(a.a((b) this.BFZ, false));
                AppMethodBeat.o(119156);
                return listOf;
            case 2:
                aVar = f.BcZ;
                listOf = k.listOf(a.a((b) this.BFZ, true));
                AppMethodBeat.o(119156);
                return listOf;
            default:
                List list = a.a.v.AUP;
                AppMethodBeat.o(119156);
                return list;
        }
    }
}
