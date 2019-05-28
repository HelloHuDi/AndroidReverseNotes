package a.i.b.a.c.i.b;

import a.f.b.j;
import a.i.b.a.c.b.y;
import a.i.b.a.c.l.ad;
import a.i.b.a.c.l.w;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class s extends f<String> {
    public s(String str) {
        j.p(str, "value");
        super(str);
        AppMethodBeat.i(122113);
        AppMethodBeat.o(122113);
    }

    public final /* synthetic */ w b(y yVar) {
        AppMethodBeat.i(122111);
        j.p(yVar, "module");
        ad dXP = yVar.dZD().dXP();
        j.o(dXP, "module.builtIns.stringType");
        w wVar = dXP;
        AppMethodBeat.o(122111);
        return wVar;
    }

    public final String toString() {
        AppMethodBeat.i(122112);
        String str = "\"" + ((String) getValue()) + '\"';
        AppMethodBeat.o(122112);
        return str;
    }
}
