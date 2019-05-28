package a.i.b.a.c.l;

import a.a.m;
import a.a.t;
import a.f.b.j;
import a.i.b.a.c.b.ar;
import a.i.b.a.c.b.h;
import a.i.b.a.c.b.i;
import a.i.b.a.c.b.l;
import a.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public final class ai {

    public static final class a extends ao {
        final /* synthetic */ List BJN;

        a(List list) {
            this.BJN = list;
        }

        public final ap c(an anVar) {
            AppMethodBeat.i(122635);
            j.p(anVar, "key");
            if (this.BJN.contains(anVar)) {
                h dYs = anVar.dYs();
                if (dYs == null) {
                    v vVar = new v("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.TypeParameterDescriptor");
                    AppMethodBeat.o(122635);
                    throw vVar;
                }
                ap e = av.e((ar) dYs);
                AppMethodBeat.o(122635);
                return e;
            }
            AppMethodBeat.o(122635);
            return null;
        }
    }

    public static final w d(ar arVar) {
        AppMethodBeat.i(122636);
        j.p(arVar, "receiver$0");
        l dXW = arVar.dXW();
        if (dXW == null) {
            v vVar = new v("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassifierDescriptorWithTypeParameters");
            AppMethodBeat.o(122636);
            throw vVar;
        }
        an dXY = ((i) dXW).dXY();
        j.o(dXY, "classDescriptor.typeConstructor");
        List parameters = dXY.getParameters();
        j.o(parameters, "classDescriptor.typeConstructor.parameters");
        Iterable<ar> iterable = parameters;
        Collection arrayList = new ArrayList(m.d(iterable));
        for (ar arVar2 : iterable) {
            j.o(arVar2, "it");
            arrayList.add(arVar2.dXY());
        }
        au d = au.d((as) new a((List) arrayList));
        parameters = arVar.dWP();
        j.o(parameters, "this.upperBounds");
        w c = d.c((w) t.fJ(parameters), ba.OUT_VARIANCE);
        if (c == null) {
            ad dXN = a.i.b.a.c.i.c.a.G(arVar).dXN();
            j.o(dXN, "builtIns.defaultBound");
            c = dXN;
        }
        AppMethodBeat.o(122636);
        return c;
    }
}
