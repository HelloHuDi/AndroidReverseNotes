package a.i.b.a.c.d.a.c.b;

import a.a.t;
import a.f.b.j;
import a.f.b.k;
import a.i.b.a.c.b.ar;
import a.i.b.a.c.b.e;
import a.i.b.a.c.b.h;
import a.i.b.a.c.d.a.a.l;
import a.i.b.a.c.f.b;
import a.i.b.a.c.l.ad;
import a.i.b.a.c.l.ah;
import a.i.b.a.c.l.ai;
import a.i.b.a.c.l.ap;
import a.i.b.a.c.l.p;
import a.i.b.a.c.l.w;
import a.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

public final class d {
    private static final b Bpm = new b("java.lang.Class");

    static final class a extends k implements a.f.a.a<ad> {
        final /* synthetic */ ar Bpn;

        a(ar arVar) {
            this.Bpn = arVar;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.i(120050);
            ad awn = p.awn("Can't compute erased upper bound of type parameter `" + this.Bpn + '`');
            j.o(awn, "ErrorUtils.createErrorTy… type parameter `$this`\")");
            AppMethodBeat.o(120050);
            return awn;
        }
    }

    static {
        AppMethodBeat.i(120055);
        AppMethodBeat.o(120055);
    }

    public static /* synthetic */ a a(l lVar, boolean z, ar arVar, int i) {
        AppMethodBeat.i(120052);
        if ((i & 1) != 0) {
            z = false;
        }
        if ((i & 2) != 0) {
            arVar = null;
        }
        j.p(lVar, "receiver$0");
        a aVar = new a(lVar, z, arVar);
        AppMethodBeat.o(120052);
        return aVar;
    }

    public static /* synthetic */ w b(ar arVar) {
        AppMethodBeat.i(120054);
        w a = a(arVar, null, new a(arVar));
        AppMethodBeat.o(120054);
        return a;
    }

    public static final w a(ar arVar, ar arVar2, a.f.a.a<? extends w> aVar) {
        AppMethodBeat.i(120053);
        j.p(arVar, "receiver$0");
        j.p(aVar, "defaultValue");
        w wVar;
        if (arVar == arVar2) {
            wVar = (w) aVar.invoke();
            AppMethodBeat.o(120053);
            return wVar;
        }
        List dWP = arVar.dWP();
        j.o(dWP, "upperBounds");
        wVar = (w) t.fJ(dWP);
        if (wVar.ejw().dYs() instanceof e) {
            j.o(wVar, "firstUpperBound");
            wVar = a.i.b.a.c.l.c.a.aN(wVar);
            AppMethodBeat.o(120053);
            return wVar;
        }
        if (arVar2 != null) {
            arVar = arVar2;
        }
        h dYs = wVar.ejw().dYs();
        v vVar;
        if (dYs == null) {
            vVar = new v("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.TypeParameterDescriptor");
            AppMethodBeat.o(120053);
            throw vVar;
        }
        while (true) {
            ar arVar3 = (ar) dYs;
            if ((j.j(arVar3, arVar) ^ 1) != 0) {
                dWP = arVar3.dWP();
                j.o(dWP, "current.upperBounds");
                wVar = (w) t.fJ(dWP);
                if (wVar.ejw().dYs() instanceof e) {
                    j.o(wVar, "nextUpperBound");
                    wVar = a.i.b.a.c.l.c.a.aN(wVar);
                    AppMethodBeat.o(120053);
                    return wVar;
                }
                dYs = wVar.ejw().dYs();
                if (dYs == null) {
                    vVar = new v("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.TypeParameterDescriptor");
                    AppMethodBeat.o(120053);
                    throw vVar;
                }
            } else {
                wVar = (w) aVar.invoke();
                AppMethodBeat.o(120053);
                return wVar;
            }
        }
    }

    public static final ap a(ar arVar, a aVar) {
        AppMethodBeat.i(120051);
        j.p(arVar, "typeParameter");
        j.p(aVar, "attr");
        ap arVar2;
        if (aVar.BoW == l.SUPERTYPE) {
            arVar2 = new a.i.b.a.c.l.ar(ai.d(arVar));
            AppMethodBeat.o(120051);
            return arVar2;
        }
        arVar2 = new ah(arVar);
        AppMethodBeat.o(120051);
        return arVar2;
    }
}
