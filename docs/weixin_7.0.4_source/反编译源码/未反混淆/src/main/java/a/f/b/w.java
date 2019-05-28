package a.f.b;

import a.i.b;
import a.i.d;
import a.i.e;
import a.i.h;
import a.i.l;
import a.i.m;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class w {
    public d f(Class cls, String str) {
        AppMethodBeat.i(55888);
        o oVar = new o(cls, str);
        AppMethodBeat.o(55888);
        return oVar;
    }

    public b aN(Class cls) {
        AppMethodBeat.i(55889);
        e eVar = new e(cls);
        AppMethodBeat.o(55889);
        return eVar;
    }

    public String a(k kVar) {
        AppMethodBeat.i(55890);
        String a = a((h) kVar);
        AppMethodBeat.o(55890);
        return a;
    }

    public String a(h hVar) {
        AppMethodBeat.i(55891);
        String obj = hVar.getClass().getGenericInterfaces()[0].toString();
        if (obj.startsWith("kotlin.jvm.functions.")) {
            obj = obj.substring(21);
            AppMethodBeat.o(55891);
            return obj;
        }
        AppMethodBeat.o(55891);
        return obj;
    }

    public e a(i iVar) {
        return iVar;
    }

    public l a(q qVar) {
        return qVar;
    }

    public m a(s sVar) {
        return sVar;
    }

    public h a(m mVar) {
        return mVar;
    }
}
