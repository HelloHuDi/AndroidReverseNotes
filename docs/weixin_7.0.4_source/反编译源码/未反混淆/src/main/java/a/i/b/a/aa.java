package a.i.b.a;

import a.f.b.c;
import a.f.b.h;
import a.f.b.i;
import a.f.b.k;
import a.f.b.q;
import a.f.b.s;
import a.f.b.w;
import a.i.b;
import a.i.d;
import a.i.e;
import a.i.l;
import a.i.m;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class aa extends w {
    public final d f(Class cls, String str) {
        AppMethodBeat.i(118902);
        n nVar = new n(cls, str);
        AppMethodBeat.o(118902);
        return nVar;
    }

    public final b aN(Class cls) {
        AppMethodBeat.i(118903);
        g aO = f.aO(cls);
        AppMethodBeat.o(118903);
        return aO;
    }

    public final String a(k kVar) {
        AppMethodBeat.i(118904);
        String a = a((h) kVar);
        AppMethodBeat.o(118904);
        return a;
    }

    public final String a(h hVar) {
        String b;
        AppMethodBeat.i(118905);
        e a = a.i.b.b.a(hVar);
        if (a != null) {
            j dw = af.dw(a);
            if (dw != null) {
                ab abVar = ab.AYy;
                b = ab.b(dw.dXf());
                AppMethodBeat.o(118905);
                return b;
            }
        }
        b = super.a(hVar);
        AppMethodBeat.o(118905);
        return b;
    }

    public final e a(i iVar) {
        AppMethodBeat.i(118906);
        j jVar = new j(a((c) iVar), iVar.getName(), iVar.due(), iVar.dWC());
        AppMethodBeat.o(118906);
        return jVar;
    }

    public final l a(q qVar) {
        AppMethodBeat.i(118907);
        p pVar = new p(a((c) qVar), qVar.getName(), qVar.due(), qVar.dWC());
        AppMethodBeat.o(118907);
        return pVar;
    }

    public final m a(s sVar) {
        AppMethodBeat.i(118908);
        q qVar = new q(a((c) sVar), sVar.getName(), sVar.due(), sVar.dWC());
        AppMethodBeat.o(118908);
        return qVar;
    }

    public final a.i.h a(a.f.b.m mVar) {
        AppMethodBeat.i(118909);
        l lVar = new l(a((c) mVar), mVar.getName(), mVar.due(), mVar.dWC());
        AppMethodBeat.o(118909);
        return lVar;
    }

    private static i a(c cVar) {
        AppMethodBeat.i(118910);
        d dWF = cVar.dWF();
        i iVar;
        if (dWF instanceof i) {
            iVar = (i) dWF;
            AppMethodBeat.o(118910);
            return iVar;
        }
        iVar = a.AWe;
        AppMethodBeat.o(118910);
        return iVar;
    }
}
